package org.cryptomator.common;

import org.cryptomator.common.CommonsModule;
import org.cryptomator.common.ShutdownHook;
import org.cryptomator.common.settings.Settings;
import org.cryptomator.common.settings.SettingsProvider;
import org.cryptomator.cryptolib.common.MasterkeyFileAccess;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.inject.Named;
import java.security.SecureRandom;
import java.util.Comparator;
import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;

public class CommonsModuleTest {

    private ShutdownHook shutdownHook;
    private SettingsProvider settingsProviderMock;

    @BeforeEach
    public void setUp() {
        // Arrange: Créer mocks nécessaire
        shutdownHook = Mockito.mock(ShutdownHook.class);
        settingsProviderMock = Mockito.mock(SettingsProvider.class);
    }

    @Test
    public void testProvideEnvironment() {
        // Intention: Vérifier que l'environement est donné correctement.
        // Arrange, Act & Assert
        Assertions.assertNotNull(CommonsModule.provideEnvironment());
    }

    @Test
    public void testProvideLicensePublicKey() {
        // Intention: Vérifie que la clé publique de licence est bien fournie et non vide.
        // Arrange, Act
        String publicKey = CommonsModule.provideLicensePublicKey();

        // Assert
        Assertions.assertNotNull(publicKey);
        Assertions.assertFalse(publicKey.isEmpty());
    }

    @Test
    public void testProvideCSPRNG() {
        // Intention: Vérifie qu'une instance sécurisée de SecureRandom est bien fournie.
        // Arrange, Act
        SecureRandom random = CommonsModule.provideCSPRNG();

        // Assert
        Assertions.assertNotNull(random);
    }

    @Test
    public void testProvideMasterkeyFileAccess() {
        // Intention: Vérifie que l'accès au fichier de clé maître est créé avec succès.
        // Arrange
        SecureRandom csprng = Mockito.mock(SecureRandom.class);

        // Act
        MasterkeyFileAccess masterkeyFileAccess = CommonsModule.provideMasterkeyFileAccess(csprng);

        // Assert
        Assertions.assertNotNull(masterkeyFileAccess);
    }

    @Test
    public void testProvidesSemVerComparator() {
        // Intention: Vérifie que le comparateur de version sémantique est fourni et fonctionne correctement.
        // Arrange, Act
        Comparator<String> comparator = CommonsModule.providesSemVerComparator();

        // Assert
        Assertions.assertNotNull(comparator);
        Assertions.assertEquals(0, comparator.compare("1.0.0", "1.0.0"));
    }

    @Test
    public void testProvideRevealPathService() {
        // Intention: Vérifie qu'un Optional<RevealPathService> est fourni.
        // Arrange, Act
        Optional<?> revealPathService = CommonsModule.provideRevealPathService();

        // Assert
        Assertions.assertNotNull(revealPathService);
    }

    @Test
    public void testProvideSettings() {
        // Intention: Vérifie que les paramètres (Settings) sont fournis à partir du fournisseur.
        // Arrange
        Settings settings = Mockito.mock(Settings.class);
        Mockito.when(settingsProviderMock.get()).thenReturn(settings);

        // Act
        Settings providedSettings = CommonsModule.provideSettings(settingsProviderMock);

        // Assert
        Assertions.assertNotNull(providedSettings);
    }

    @Test
    public void testProvideScheduledExecutorService() {
        // Intention:  Vérifie que le service de planification est bien créé.
        // Arrange, Act
        ScheduledExecutorService executorService = CommonsModule.provideScheduledExecutorService(shutdownHook);

        // Assert
        Assertions.assertNotNull(executorService);
        executorService.shutdown();
    }

    @Test
    public void testProvideExecutorService() {
        // Intention: Vérifie que le service d'exécution est bien créé.
        // Arrange, Act
        ExecutorService executorService = CommonsModule.provideExecutorService(shutdownHook);

        // Assert
        Assertions.assertNotNull(executorService);
        executorService.shutdown();
    }
}
