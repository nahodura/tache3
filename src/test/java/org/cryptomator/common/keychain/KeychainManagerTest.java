package org.cryptomator.common.keychain;


import org.cryptomator.integrations.keychain.KeychainAccessException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import javafx.application.Platform;
import javafx.beans.property.ReadOnlyBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import java.time.Duration;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;


public class KeychainManagerTest {

	@Test
	public void testStoreAndLoad() throws KeychainAccessException {
		KeychainManager keychainManager = new KeychainManager(new SimpleObjectProperty<>(new MapKeychainAccess()));
		keychainManager.storePassphrase("test", "Test", "asd");
		Assertions.assertArrayEquals("asd".toCharArray(), keychainManager.loadPassphrase("test"));
	}

	@Nested
	public static class WhenObservingProperties {

		@BeforeAll
		public static void startup() throws InterruptedException {
			CountDownLatch latch = new CountDownLatch(1);
			Platform.startup(latch::countDown);
			var javafxStarted = latch.await(5, TimeUnit.SECONDS);
			Assumptions.assumeTrue(javafxStarted);
		}

		@Test
		public void testPropertyChangesWhenStoringPassword() throws KeychainAccessException, InterruptedException {
			KeychainManager keychainManager = new KeychainManager(new SimpleObjectProperty<>(new MapKeychainAccess()));
			ReadOnlyBooleanProperty property = keychainManager.getPassphraseStoredProperty("test");
			Assertions.assertFalse(property.get());

			keychainManager.storePassphrase("test", null,"bar");

			AtomicBoolean result = new AtomicBoolean(false);
			CountDownLatch latch = new CountDownLatch(1);
			Platform.runLater(() -> {
				result.set(property.get());
				latch.countDown();
			});
			Assertions.assertTimeoutPreemptively(Duration.ofSeconds(1), () -> latch.await());
			Assertions.assertTrue(result.get());
		}
	}

	/**
	 * Test for the method {@link KeychainManager#deletePassphrase(String)}.
	 * @throws KeychainAccessException if an error occurs while deleting the passphrase.
	 * Asserts that the correct passphrase is deleted successfully and that any attempt to use the
	 * 'changePassphrase' method on a deleted Passphrase will have no effect.
	 */
	@Test
	public void testDeletePassphrase() throws KeychainAccessException {
		//Arrange
		KeychainManager keychainManager = new KeychainManager(new SimpleObjectProperty<>(new MapKeychainAccess()));

		//Act
		keychainManager.storePassphrase("testKey", "testToDeleteKey", "helloWorld");
		keychainManager.storePassphrase("testKey2", "testToDeleteKey2", "helloFriend");

		keychainManager.deletePassphrase("testKey");
		keychainManager.changePassphrase("testKey", "testToDeleteKey", "helloFriend");

		//Assert
		Assertions.assertFalse(keychainManager.isPassphraseStored("testKey"));
		Assertions.assertTrue(keychainManager.isPassphraseStored("testKey2"));
	}


	/**
	 * Test for the method {@link KeychainManager#storePassphrase(String, String, CharSequence)}.
	 * @throws KeychainAccessException if an error occurs while storing the passphrase.
	 * Asserts that only one (the most recent) passphrase is stored in the keychain and
	 * tests edge cases where the passphrase is empty or null.
	 */
	@Test
	public void testStorePassphrases() {
		// Arrange
		KeychainManager keychainManager = new KeychainManager(new SimpleObjectProperty<>(new MapKeychainAccess()));

		//Act and Assert per case
		try {
			keychainManager.storePassphrase("test1", "TestStoreTwice", "helloWorld");
			Assertions.assertArrayEquals("helloWorld".toCharArray(), keychainManager.loadPassphrase("test1"));

			// Store the 2nd passphrase on top of the 1st
			keychainManager.storePassphrase("test1", "TestStoreTwice", "helloFriend");
			Assertions.assertArrayEquals("helloFriend".toCharArray(), keychainManager.loadPassphrase("test1"));

			// Edge case : empty passphrase
			keychainManager.storePassphrase("test2", "TestEmpty", "");
			Assertions.assertArrayEquals("".toCharArray(), keychainManager.loadPassphrase("test2"));

			// Edge case : null passphrase to throw NullPointerException (expected)
			Assertions.assertThrows(NullPointerException.class, () -> {keychainManager.storePassphrase("test3", "TestNull", null);});

		} catch (KeychainAccessException e) {
			e.printStackTrace();
			Assertions.fail("An exception should not have been thrown");
		}
	}

}

