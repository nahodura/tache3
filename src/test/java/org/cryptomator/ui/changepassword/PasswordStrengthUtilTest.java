package org.cryptomator.ui.changepassword;

import com.google.common.base.Strings;
import org.cryptomator.common.Environment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.time.Duration;
import java.util.ResourceBundle;

public class PasswordStrengthUtilTest {


	@Test
	public void testLongPasswords() {
		PasswordStrengthUtil util = new PasswordStrengthUtil(Mockito.mock(ResourceBundle.class), Mockito.mock(Environment.class));
		String longPw = Strings.repeat("x", 10_000);
		Assertions.assertTimeout(Duration.ofSeconds(5), () -> {
			util.computeRate(longPw);
		});
	}

	@Test
	public void testIssue979() {
		PasswordStrengthUtil util = new PasswordStrengthUtil(Mockito.mock(ResourceBundle.class), Mockito.mock(Environment.class));
		int result1 = util.computeRate("backed derrick buckling mountains glove client procedures desire destination sword hidden ram");
		int result2 = util.computeRate("backed derrick buckling mountains glove client procedures desire destination sword hidden ram escalation");
		Assertions.assertEquals(4, result1);
		Assertions.assertEquals(4, result2);
	}

	/**
	 * Test for the method {@link PasswordStrengthUtil#getStrengthDescription(Number)}.
	 * Asserts that the method returns the correct strength description for a given score.
	 */
	@Test
	public void testValidPasswordStrength() {
		// Arrange
		ResourceBundle mockBundle = Mockito.mock(ResourceBundle.class);
		Environment mockEnv = Mockito.mock(Environment.class);
		PasswordStrengthUtil util = new PasswordStrengthUtil(mockBundle, mockEnv);

		String prefix = "passwordStrength.messageLabel.";
		String expectedKey = prefix + 3;

		Mockito.when(mockBundle.getString(expectedKey)).thenReturn("Password strength: Strong");
		Mockito.when(mockBundle.containsKey(expectedKey)).thenReturn(true);
		Mockito.when(mockEnv.getMinPwLength()).thenReturn(8);

		// Act
		String strengthDescription = util.getStrengthDescription(3);

		// Assert
		Assertions.assertEquals("Password strength: Strong", strengthDescription);
	}

	
	/**
	 * Test for the method {@link PasswordStrengthUtil#computeRate(CharSequence)}.
	 * Asserts that the method returns the correct rating for a given password.
	 */
	@Test
	public void testComputeRate() {
		// Arrange
		Environment mockEnv = Mockito.mock(Environment.class);
		Mockito.when(mockEnv.getMinPwLength()).thenReturn(8);
		PasswordStrengthUtil util = new PasswordStrengthUtil(Mockito.mock(ResourceBundle.class), mockEnv);
		String shortPassword = "hi";
		String longPassword = Strings.repeat("insertHereAVeryReallyExtremelyLongPasswordThatIsNotGoingToBeUsed" +
				"ForAnythingButTestingBecauseItIsJustTooLongAndItIsNotGoingToBeTypedByAnyoneEverAndIWishIDidNotHaveTo" +
				"TypeItButIHaveToBecauseIAmWastingMyTimeWritingThisLongStringThatIsNotGoingToBeUsedForAnythingWhenI" +
				"CouldJustFinishThisAssignmentAndMoveOnWIthMyLife.", 100);
		
		// Act
		int ratingNull = util.computeRate(null);
		int ratingShort = util.computeRate(shortPassword);
		int ratingLong = util.computeRate(longPassword);
		
		// Assert
		Assertions.assertEquals(-1, ratingNull);
		Assertions.assertEquals(-1, ratingShort);
		Assertions.assertNotEquals(-1, ratingLong);
	}
}
