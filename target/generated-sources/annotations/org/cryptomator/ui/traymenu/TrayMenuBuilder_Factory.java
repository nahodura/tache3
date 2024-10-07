package org.cryptomator.ui.traymenu;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.cryptomator.common.vaults.Vault;
import org.cryptomator.integrations.tray.TrayMenuController;
import org.cryptomator.ui.common.VaultService;
import org.cryptomator.ui.fxapp.FxApplicationTerminator;
import org.cryptomator.ui.fxapp.FxApplicationWindows;

@ScopeMetadata("org.cryptomator.ui.traymenu.TrayMenuScoped")
@QualifierMetadata
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class TrayMenuBuilder_Factory implements Factory<TrayMenuBuilder> {
  private final Provider<ResourceBundle> resourceBundleProvider;

  private final Provider<VaultService> vaultServiceProvider;

  private final Provider<FxApplicationWindows> appWindowsProvider;

  private final Provider<FxApplicationTerminator> appTerminatorProvider;

  private final Provider<ObservableList<Vault>> vaultsProvider;

  private final Provider<Optional<TrayMenuController>> trayMenuProvider;

  public TrayMenuBuilder_Factory(
      Provider<ResourceBundle> resourceBundleProvider,
      Provider<VaultService> vaultServiceProvider,
      Provider<FxApplicationWindows> appWindowsProvider,
      Provider<FxApplicationTerminator> appTerminatorProvider,
      Provider<ObservableList<Vault>> vaultsProvider,
      Provider<Optional<TrayMenuController>> trayMenuProvider) {
    this.resourceBundleProvider = resourceBundleProvider;
    this.vaultServiceProvider = vaultServiceProvider;
    this.appWindowsProvider = appWindowsProvider;
    this.appTerminatorProvider = appTerminatorProvider;
    this.vaultsProvider = vaultsProvider;
    this.trayMenuProvider = trayMenuProvider;
  }

  @Override
  public TrayMenuBuilder get() {
    return newInstance(
        resourceBundleProvider.get(),
        vaultServiceProvider.get(),
        appWindowsProvider.get(),
        appTerminatorProvider.get(),
        vaultsProvider.get(),
        trayMenuProvider.get());
  }

  public static TrayMenuBuilder_Factory create(
      Provider<ResourceBundle> resourceBundleProvider,
      Provider<VaultService> vaultServiceProvider,
      Provider<FxApplicationWindows> appWindowsProvider,
      Provider<FxApplicationTerminator> appTerminatorProvider,
      Provider<ObservableList<Vault>> vaultsProvider,
      Provider<Optional<TrayMenuController>> trayMenuProvider) {
    return new TrayMenuBuilder_Factory(
        resourceBundleProvider,
        vaultServiceProvider,
        appWindowsProvider,
        appTerminatorProvider,
        vaultsProvider,
        trayMenuProvider);
  }

  public static TrayMenuBuilder newInstance(
      ResourceBundle resourceBundle,
      VaultService vaultService,
      FxApplicationWindows appWindows,
      FxApplicationTerminator appTerminator,
      ObservableList<Vault> vaults,
      Optional<TrayMenuController> trayMenu) {
    return new TrayMenuBuilder(
        resourceBundle, vaultService, appWindows, appTerminator, vaults, trayMenu);
  }
}
