package org.cryptomator.ui.mainwindow;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javafx.beans.property.ObjectProperty;
import javafx.stage.Stage;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.cryptomator.common.vaults.Vault;
import org.cryptomator.ui.fxapp.FxApplicationWindows;
import org.cryptomator.ui.removevault.RemoveVaultComponent;

@ScopeMetadata("org.cryptomator.ui.mainwindow.MainWindowScoped")
@QualifierMetadata("javax.inject.Named")
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class VaultDetailUnknownErrorController_Factory
    implements Factory<VaultDetailUnknownErrorController> {
  private final Provider<ObjectProperty<Vault>> vaultProvider;

  private final Provider<FxApplicationWindows> appWindowsProvider;

  private final Provider<Stage> errorWindowProvider;

  private final Provider<RemoveVaultComponent.Builder> removeVaultProvider;

  public VaultDetailUnknownErrorController_Factory(
      Provider<ObjectProperty<Vault>> vaultProvider,
      Provider<FxApplicationWindows> appWindowsProvider,
      Provider<Stage> errorWindowProvider,
      Provider<RemoveVaultComponent.Builder> removeVaultProvider) {
    this.vaultProvider = vaultProvider;
    this.appWindowsProvider = appWindowsProvider;
    this.errorWindowProvider = errorWindowProvider;
    this.removeVaultProvider = removeVaultProvider;
  }

  @Override
  public VaultDetailUnknownErrorController get() {
    return newInstance(
        vaultProvider.get(),
        appWindowsProvider.get(),
        errorWindowProvider.get(),
        removeVaultProvider.get());
  }

  public static VaultDetailUnknownErrorController_Factory create(
      Provider<ObjectProperty<Vault>> vaultProvider,
      Provider<FxApplicationWindows> appWindowsProvider,
      Provider<Stage> errorWindowProvider,
      Provider<RemoveVaultComponent.Builder> removeVaultProvider) {
    return new VaultDetailUnknownErrorController_Factory(
        vaultProvider, appWindowsProvider, errorWindowProvider, removeVaultProvider);
  }

  public static VaultDetailUnknownErrorController newInstance(
      ObjectProperty<Vault> vault,
      FxApplicationWindows appWindows,
      Stage errorWindow,
      RemoveVaultComponent.Builder removeVault) {
    return new VaultDetailUnknownErrorController(vault, appWindows, errorWindow, removeVault);
  }
}
