package org.cryptomator.ui.mainwindow;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javafx.beans.property.ObjectProperty;
import javafx.stage.Stage;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.cryptomator.common.keychain.KeychainManager;
import org.cryptomator.common.vaults.Vault;
import org.cryptomator.ui.fxapp.FxApplicationWindows;
import org.cryptomator.ui.vaultoptions.VaultOptionsComponent;

@ScopeMetadata("org.cryptomator.ui.mainwindow.MainWindowScoped")
@QualifierMetadata("org.cryptomator.ui.mainwindow.MainWindow")
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class VaultDetailLockedController_Factory
    implements Factory<VaultDetailLockedController> {
  private final Provider<ObjectProperty<Vault>> vaultProvider;

  private final Provider<FxApplicationWindows> appWindowsProvider;

  private final Provider<VaultOptionsComponent.Factory> vaultOptionsWindowProvider;

  private final Provider<KeychainManager> keychainProvider;

  private final Provider<Stage> mainWindowProvider;

  public VaultDetailLockedController_Factory(
      Provider<ObjectProperty<Vault>> vaultProvider,
      Provider<FxApplicationWindows> appWindowsProvider,
      Provider<VaultOptionsComponent.Factory> vaultOptionsWindowProvider,
      Provider<KeychainManager> keychainProvider,
      Provider<Stage> mainWindowProvider) {
    this.vaultProvider = vaultProvider;
    this.appWindowsProvider = appWindowsProvider;
    this.vaultOptionsWindowProvider = vaultOptionsWindowProvider;
    this.keychainProvider = keychainProvider;
    this.mainWindowProvider = mainWindowProvider;
  }

  @Override
  public VaultDetailLockedController get() {
    return newInstance(
        vaultProvider.get(),
        appWindowsProvider.get(),
        vaultOptionsWindowProvider.get(),
        keychainProvider.get(),
        mainWindowProvider.get());
  }

  public static VaultDetailLockedController_Factory create(
      Provider<ObjectProperty<Vault>> vaultProvider,
      Provider<FxApplicationWindows> appWindowsProvider,
      Provider<VaultOptionsComponent.Factory> vaultOptionsWindowProvider,
      Provider<KeychainManager> keychainProvider,
      Provider<Stage> mainWindowProvider) {
    return new VaultDetailLockedController_Factory(
        vaultProvider,
        appWindowsProvider,
        vaultOptionsWindowProvider,
        keychainProvider,
        mainWindowProvider);
  }

  public static VaultDetailLockedController newInstance(
      ObjectProperty<Vault> vault,
      FxApplicationWindows appWindows,
      VaultOptionsComponent.Factory vaultOptionsWindow,
      KeychainManager keychain,
      Stage mainWindow) {
    return new VaultDetailLockedController(
        vault, appWindows, vaultOptionsWindow, keychain, mainWindow);
  }
}
