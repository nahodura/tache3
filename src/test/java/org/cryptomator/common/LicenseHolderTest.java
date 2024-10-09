package org.cryptomator.common;

import org.cryptomator.common.LicenseHolder;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Optional;

import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import org.cryptomator.common.settings.Settings;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class LicenseHolderTest {

    /**
     * Test method for {@link org.cryptomator.common.LicenseHolder#LicenseHolder(org.cryptomator.common.LicenseChecker,
     * org.cryptomator.common.settings.Settings)}.
     * Asserts that the constructor creates a new instance of {@link LicenseHolder} with a valid license.
     * The license checker is mocked to return a valid license.
     */
    @Test
    void testNewLicenseHolder() {
        // Arrange
        LicenseChecker licenseChecker = mock(LicenseChecker.class);
        Optional<DecodedJWT> ofResult = Optional.of(mock(DecodedJWT.class));
        when(licenseChecker.check(Mockito.<String>any())).thenReturn(ofResult);

        // Act
        LicenseHolder actualLicenseHolder = new LicenseHolder(licenseChecker,
                Settings.create(Environment.getInstance()));

        // Assert
        verify(licenseChecker).check(isNull());
        BooleanBinding validLicensePropertyResult = actualLicenseHolder.validLicenseProperty();
        ObservableList<?> dependencies = validLicensePropertyResult.getDependencies();
        assertEquals(1, dependencies.size());
        Object getResult = dependencies.get(0);
        assertTrue(getResult instanceof SimpleObjectProperty);
        assertNull(actualLicenseHolder.getLicenseSubject());
        assertTrue(validLicensePropertyResult.get());
        assertTrue(actualLicenseHolder.isValidLicense());
    }
}