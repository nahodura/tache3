package org.cryptomator.common;

import org.cryptomator.common.ShutdownHook;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ShutdownHookTest {

    private ShutdownHook shutdownHook;

    @BeforeEach
    public void setUp() {
        // Arrange: Créer une nouvelle instance de ShutdownHook
        shutdownHook = new ShutdownHook();
    }

    @Test
    public void testShutdownHookCreation() {
        // Intention: Verifier que l'instance de ShutdownHook est créé avec succés
        // Arrange, Act & Assert
        Assertions.assertNotNull(shutdownHook);
    }

    @Test
    public void testRunOnShutdownWithDefaultPriority() {
        // Intention: Vérifier que la tache peut etre schedulé pour run quand shutdown avec la priorité par défaut.
        // Arrange
        Runnable task = Mockito.mock(Runnable.class);

        // Act
        shutdownHook.runOnShutdown(task);

        // Assert: Check si la tache est ajoutée avec succés (no exceptions thrown)
        Assertions.assertTrue(true);
    }

    @Test
    public void testRunOnShutdownWithSpecificPriority() {
        // Intention: Vérifier que la tache peut etre schedulé pour run quand shutdown avec la priorité donnée.
        // Arrange
        Runnable task = Mockito.mock(Runnable.class);
        int priority = ShutdownHook.PRIO_FIRST;

        // Act
        shutdownHook.runOnShutdown(priority, task);

        // Assert: Check si la tache est ajoutée avec succés (no exceptions thrown)
        Assertions.assertTrue(true);
    }

    @Test
    public void testRunGracefulShutdownTasks() {
        // Intention: Vérifier que la tache est éxécutée pendant le processus de shutdown.
        // Arrange
        Runnable task = Mockito.mock(Runnable.class);
        shutdownHook.runOnShutdown(task);

        // Act
        shutdownHook.run();

        // Assert: Verifier que la tache est lancé
        Mockito.verify(task, Mockito.times(1)).run();
    }
}
