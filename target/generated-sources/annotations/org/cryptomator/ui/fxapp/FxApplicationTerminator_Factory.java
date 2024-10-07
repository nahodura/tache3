package org.cryptomator.ui.fxapp;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javafx.collections.ObservableList;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.cryptomator.common.ShutdownHook;
import org.cryptomator.common.settings.Settings;
import org.cryptomator.common.vaults.Vault;
import org.cryptomator.ui.common.VaultService;

@ScopeMetadata("org.cryptomator.ui.fxapp.FxApplicationScoped")
@QualifierMetadata
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class FxApplicationTerminator_Factory implements Factory<FxApplicationTerminator> {
  private final Provider<ObservableList<Vault>> vaultsProvider;

  private final Provider<ShutdownHook> shutdownHookProvider;

  private final Provider<FxApplicationWindows> appWindowsProvider;

  private final Provider<Settings> settingsProvider;

  private final Provider<VaultService> vaultServiceProvider;

  public FxApplicationTerminator_Factory(
      Provider<ObservableList<Vault>> vaultsProvider,
      Provider<ShutdownHook> shutdownHookProvider,
      Provider<FxApplicationWindows> appWindowsProvider,
      Provider<Settings> settingsProvider,
      Provider<VaultService> vaultServiceProvider) {
    this.vaultsProvider = vaultsProvider;
    this.shutdownHookProvider = shutdownHookProvider;
    this.appWindowsProvider = appWindowsProvider;
    this.settingsProvider = settingsProvider;
    this.vaultServiceProvider = vaultServiceProvider;
  }

  @Override
  public FxApplicationTerminator get() {
    return newInstance(
        vaultsProvider.get(),
        shutdownHookProvider.get(),
        appWindowsProvider.get(),
        settingsProvider.get(),
        vaultServiceProvider.get());
  }

  public static FxApplicationTerminator_Factory create(
      Provider<ObservableList<Vault>> vaultsProvider,
      Provider<ShutdownHook> shutdownHookProvider,
      Provider<FxApplicationWindows> appWindowsProvider,
      Provider<Settings> settingsProvider,
      Provider<VaultService> vaultServiceProvider) {
    return new FxApplicationTerminator_Factory(
        vaultsProvider,
        shutdownHookProvider,
        appWindowsProvider,
        settingsProvider,
        vaultServiceProvider);
  }

  public static FxApplicationTerminator newInstance(
      ObservableList<Vault> vaults,
      ShutdownHook shutdownHook,
      FxApplicationWindows appWindows,
      Settings settings,
      VaultService vaultService) {
    return new FxApplicationTerminator(vaults, shutdownHook, appWindows, settings, vaultService);
  }
}
