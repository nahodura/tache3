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
import org.cryptomator.ui.common.VaultService;
import org.cryptomator.ui.fxapp.FxApplicationWindows;
import org.cryptomator.ui.removevault.RemoveVaultComponent;
import org.cryptomator.ui.vaultoptions.VaultOptionsComponent;

@ScopeMetadata("org.cryptomator.ui.mainwindow.MainWindowScoped")
@QualifierMetadata("org.cryptomator.ui.mainwindow.MainWindow")
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class VaultListContextMenuController_Factory
    implements Factory<VaultListContextMenuController> {
  private final Provider<ObjectProperty<Vault>> selectedVaultProvider;

  private final Provider<Stage> mainWindowProvider;

  private final Provider<FxApplicationWindows> appWindowsProvider;

  private final Provider<VaultService> vaultServiceProvider;

  private final Provider<KeychainManager> keychainProvider;

  private final Provider<RemoveVaultComponent.Builder> removeVaultProvider;

  private final Provider<VaultOptionsComponent.Factory> vaultOptionsWindowProvider;

  public VaultListContextMenuController_Factory(
      Provider<ObjectProperty<Vault>> selectedVaultProvider,
      Provider<Stage> mainWindowProvider,
      Provider<FxApplicationWindows> appWindowsProvider,
      Provider<VaultService> vaultServiceProvider,
      Provider<KeychainManager> keychainProvider,
      Provider<RemoveVaultComponent.Builder> removeVaultProvider,
      Provider<VaultOptionsComponent.Factory> vaultOptionsWindowProvider) {
    this.selectedVaultProvider = selectedVaultProvider;
    this.mainWindowProvider = mainWindowProvider;
    this.appWindowsProvider = appWindowsProvider;
    this.vaultServiceProvider = vaultServiceProvider;
    this.keychainProvider = keychainProvider;
    this.removeVaultProvider = removeVaultProvider;
    this.vaultOptionsWindowProvider = vaultOptionsWindowProvider;
  }

  @Override
  public VaultListContextMenuController get() {
    return newInstance(
        selectedVaultProvider.get(),
        mainWindowProvider.get(),
        appWindowsProvider.get(),
        vaultServiceProvider.get(),
        keychainProvider.get(),
        removeVaultProvider.get(),
        vaultOptionsWindowProvider.get());
  }

  public static VaultListContextMenuController_Factory create(
      Provider<ObjectProperty<Vault>> selectedVaultProvider,
      Provider<Stage> mainWindowProvider,
      Provider<FxApplicationWindows> appWindowsProvider,
      Provider<VaultService> vaultServiceProvider,
      Provider<KeychainManager> keychainProvider,
      Provider<RemoveVaultComponent.Builder> removeVaultProvider,
      Provider<VaultOptionsComponent.Factory> vaultOptionsWindowProvider) {
    return new VaultListContextMenuController_Factory(
        selectedVaultProvider,
        mainWindowProvider,
        appWindowsProvider,
        vaultServiceProvider,
        keychainProvider,
        removeVaultProvider,
        vaultOptionsWindowProvider);
  }

  public static VaultListContextMenuController newInstance(
      ObjectProperty<Vault> selectedVault,
      Stage mainWindow,
      FxApplicationWindows appWindows,
      VaultService vaultService,
      KeychainManager keychain,
      RemoveVaultComponent.Builder removeVault,
      VaultOptionsComponent.Factory vaultOptionsWindow) {
    return new VaultListContextMenuController(
        selectedVault,
        mainWindow,
        appWindows,
        vaultService,
        keychain,
        removeVault,
        vaultOptionsWindow);
  }
}
