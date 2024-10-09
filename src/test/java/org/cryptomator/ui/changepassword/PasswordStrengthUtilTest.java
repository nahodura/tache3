package org.cryptomator.ui.changepassword;

import com.google.common.base.Strings;
import org.cryptomator.common.Environment;
import org.cryptomator.ui.changepassword.PasswordStrengthUtil;
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
		String prefix = "passwordStrength.messageLabel.";
		String expectedKey = prefix + 3;
		Mockito.when(mockBundle.getString(expectedKey)).thenReturn("Password strength: Strong");
		Mockito.when(mockBundle.containsKey(expectedKey)).thenReturn(true);

		Environment mockEnv = Mockito.mock(Environment.class);
		Mockito.when(mockEnv.getMinPwLength()).thenReturn(8);

		PasswordStrengthUtil util = new PasswordStrengthUtil(mockBundle, mockEnv);

		// Act
		String strengthDescription = util.getStrengthDescription(3);

		// Assert
		Assertions.assertEquals("Password strength: Strong", strengthDescription);
	}

}
