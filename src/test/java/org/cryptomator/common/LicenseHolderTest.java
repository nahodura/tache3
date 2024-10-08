package org.cryptomator.common;

import org.cryptomator.common.LicenseHolder;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
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

    @Test
    void testNewLicenseHolder() {
        // Arrange
        LicenseChecker licenseChecker = mock(LicenseChecker.class);
        Optional<DecodedJWT> ofResult = Optional.of(mock(DecodedJWT.class));
        when(licenseChecker.check(Mockito.<String>any())).thenReturn(ofResult);

        // Act
        LicenseHolder actualLicenseHolder = new LicenseHolder(licenseChecker, Settings.create(Environment.getInstance()));

        // Assert
        verify(licenseChecker).check(isNull());
        BooleanBinding validLicensePropertyResult = actualLicenseHolder.validLicenseProperty();
        ObservableList<?> dependencies = validLicensePropertyResult.getDependencies();
        assertEquals(1, dependencies.size());
        Object getResult = dependencies.get(0);
        assertTrue(getResult instanceof SimpleObjectProperty);
        assertEquals("", ((SimpleObjectProperty<Object>) getResult).getName());
        assertNull(((SimpleObjectProperty<Object>) getResult).getBean());
        assertNull(actualLicenseHolder.getLicenseSubject());
        BooleanBinding notResult = validLicensePropertyResult.not();
        BooleanBinding notResult2 = notResult.not();
        BooleanBinding notResult3 = notResult2.not();
        BooleanBinding notResult4 = notResult3.not();
        BooleanBinding notResult5 = notResult4.not();
        BooleanBinding notResult6 = notResult5.not();
        assertEquals(1, notResult6.getDependencies().size());
        assertEquals(1, notResult5.getDependencies().size());
        assertEquals(1, notResult4.getDependencies().size());
        BooleanBinding isNotNullResult = ((SimpleObjectProperty<Object>) getResult).isNotNull();
        BooleanBinding notResult7 = isNotNullResult.not();
        BooleanBinding notResult8 = notResult7.not();
        BooleanBinding notResult9 = notResult8.not();
        assertEquals(1, notResult9.getDependencies().size());
        BooleanBinding isNullResult = ((SimpleObjectProperty<Object>) getResult).isNull();
        BooleanBinding notResult10 = isNullResult.not();
        BooleanBinding notResult11 = notResult10.not();
        BooleanBinding notResult12 = notResult11.not();
        assertEquals(1, notResult12.getDependencies().size());
        assertEquals(1, notResult3.getDependencies().size());
        ObservableList<?> dependencies2 = notResult8.getDependencies();
        assertEquals(1, dependencies2.size());
        ObservableList<?> dependencies3 = notResult11.getDependencies();
        assertEquals(1, dependencies3.size());
        assertEquals(1, notResult2.getDependencies().size());
        assertEquals(1, notResult7.getDependencies().size());
        assertEquals(1, notResult10.getDependencies().size());
        ObservableList<?> dependencies4 = notResult.getDependencies();
        assertEquals(1, dependencies4.size());
        ObservableList<?> dependencies5 = isNotNullResult.getDependencies();
        assertEquals(1, dependencies5.size());
        ObservableList<?> dependencies6 = isNullResult.getDependencies();
        assertEquals(1, dependencies6.size());
        assertFalse(notResult6.not().get());
        assertFalse(notResult5.get());
        assertFalse(notResult12.not().get());
        assertFalse(notResult9.get());
        assertFalse(notResult3.get());
        assertFalse(notResult11.get());
        assertFalse(notResult7.get());
        assertFalse(notResult.get());
        assertFalse(isNullResult.get());
        assertFalse(((SimpleObjectProperty<Object>) getResult).isBound());
        assertTrue(notResult6.get());
        assertTrue(notResult9.not().get());
        assertTrue(notResult4.get());
        assertTrue(notResult12.get());
        assertTrue(notResult8.get());
        assertTrue(notResult2.get());
        assertTrue(notResult10.get());
        assertTrue(isNotNullResult.get());
        assertTrue(validLicensePropertyResult.get());
        assertTrue(validLicensePropertyResult.isValid());
        assertTrue(actualLicenseHolder.isValidLicense());
        assertSame(dependencies2.get(0), dependencies2.get(0));
        assertSame(dependencies3.get(0), dependencies3.get(0));
        assertSame(validLicensePropertyResult, dependencies4.get(0));
        assertSame(getResult, dependencies5.get(0));
        assertSame(getResult, dependencies6.get(0));
    }
}