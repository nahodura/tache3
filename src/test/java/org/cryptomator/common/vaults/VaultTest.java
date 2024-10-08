import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.cryptomator.common.mount.Mounter;
import org.cryptomator.common.mount.Mounter.MountHandle;
import org.cryptomator.common.settings.Settings;
import org.cryptomator.common.settings.VaultSettings;
import org.cryptomator.cryptofs.CryptoFileSystem;
import org.cryptomator.cryptolib.api.MasterkeyLoader;
import org.cryptomator.integrations.mount.Mount;
import org.cryptomator.integrations.mount.MountFailedException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

class VaultTest {

    @Mock
    private MasterkeyLoader keyLoader;
    @Mock
    private CryptoFileSystem cryptoFileSystem;
    @Mock
    private Mounter mounter;
    @Mock
    private MountHandle mountHandle;
    @Mock
    private VaultSettings vaultSettings;
    @Mock
    private Settings settings;
    @Mock
    private Mount mount;
    @Mock
    private Runnable specialCleanup;

    @InjectMocks
    private Vault vault;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        when(settings.useQuickAccess.getValue()).thenReturn(false);
        when(mountHandle.mountObj()).thenReturn(mount);
        when(mountHandle.specialCleanup()).thenReturn(specialCleanup);
    }

    @Test
    void testUnlockAlreadyUnlocked() {
        // Arrange
        vault.cryptoFileSystem.set(cryptoFileSystem);

        // Act & Assert
        assertThrows(IllegalStateException.class, () -> vault.unlock(keyLoader));
    }

    @Test
    void testUnlockSuccess() throws Exception {
        // Arrange
        when(vault.createCryptoFileSystem(keyLoader)).thenReturn(cryptoFileSystem);
        when(cryptoFileSystem.getRootDirectories()).thenReturn(List.of(Paths.get("/root")));
        when(mounter.mount(any(), any())).thenReturn(mountHandle);

        // Act
        vault.unlock(keyLoader);

        // Assert
        assertEquals(cryptoFileSystem, vault.cryptoFileSystem.get());
        verify(mounter).mount(any(), any());
    }

    @Test
    void testUnlockMountFailure() throws Exception {
        // Arrange
        when(vault.createCryptoFileSystem(keyLoader)).thenReturn(cryptoFileSystem);
        when(cryptoFileSystem.getRootDirectories()).thenReturn(List.of(Paths.get("/root")));
        when(mounter.mount(any(), any())).thenThrow(new MountFailedException("Mount failed"));

        // Act & Assert
        assertThrows(MountFailedException.class, () -> vault.unlock(keyLoader));

        // Assert
        verify(vault).destroyCryptoFileSystem();
    }

    @Test
    void testUnlockWithQuickAccess() throws Exception {
        // Arrange
        when(vault.createCryptoFileSystem(keyLoader)).thenReturn(cryptoFileSystem);
        when(cryptoFileSystem.getRootDirectories()).thenReturn(List.of(Paths.get("/root")));
        when(mounter.mount(any(), any())).thenReturn(mountHandle);
        when(settings.useQuickAccess.getValue()).thenReturn(true);

        // Act
        vault.unlock(keyLoader);

        // Assert
        verify(vault).addToQuickAccess();
    }

    @Test
    void testLockWithNullMountHandle() {
        // Arrange
        vault.mountHandle.set(null);

        // Act
        assertDoesNotThrow(() -> vault.lock(false));

        // Assert
        // No exception should be thrown and no further actions should be taken
    }

    @Test
    void testLockNormalUnmount() throws Exception {
        // Arrange
        vault.mountHandle.set(mountHandle);

        // Act
        vault.lock(false);

        // Assert
        verify(mount).unmount();
        verify(mount).close();
        verify(specialCleanup).run();
        verify(vault).removeFromQuickAccess();
        verify(vault).destroyCryptoFileSystem();
        assertNull(vault.mountHandle.get());
    }

    @Test
    void testLockForcedUnmount() throws Exception {
        // Arrange
        vault.mountHandle.set(mountHandle);
        when(mountHandle.supportsUnmountForced()).thenReturn(true);

        // Act
        vault.lock(true);

        // Assert
        verify(mount).unmountForced();
        verify(mount).close();
        verify(specialCleanup).run();
        verify(vault).removeFromQuickAccess();
        verify(vault).destroyCryptoFileSystem();
        assertNull(vault.mountHandle.get());
    }

    @Test
    void testLockForcedUnmountNotSupported() throws Exception {
        // Arrange
        vault.mountHandle.set(mountHandle);
        when(mountHandle.supportsUnmountForced()).thenReturn(false);

        // Act
        vault.lock(true);

        // Assert
        verify(mount).unmount();
        verify(mount).close();
        verify(specialCleanup).run();
        verify(vault).removeFromQuickAccess();
        verify(vault).destroyCryptoFileSystem();
        assertNull(vault.mountHandle.get());
    }
}