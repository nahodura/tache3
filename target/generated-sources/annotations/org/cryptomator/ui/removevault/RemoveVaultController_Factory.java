package org.cryptomator.ui.removevault;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.cryptomator.common.vaults.Vault;

@ScopeMetadata("org.cryptomator.ui.removevault.RemoveVaultScoped")
@QualifierMetadata("org.cryptomator.ui.removevault.RemoveVaultWindow")
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class RemoveVaultController_Factory implements Factory<RemoveVaultController> {
  private final Provider<Stage> windowProvider;

  private final Provider<Vault> vaultProvider;

  private final Provider<ObservableList<Vault>> vaultsProvider;

  public RemoveVaultController_Factory(
      Provider<Stage> windowProvider,
      Provider<Vault> vaultProvider,
      Provider<ObservableList<Vault>> vaultsProvider) {
    this.windowProvider = windowProvider;
    this.vaultProvider = vaultProvider;
    this.vaultsProvider = vaultsProvider;
  }

  @Override
  public RemoveVaultController get() {
    return newInstance(windowProvider.get(), vaultProvider.get(), vaultsProvider.get());
  }

  public static RemoveVaultController_Factory create(
      Provider<Stage> windowProvider,
      Provider<Vault> vaultProvider,
      Provider<ObservableList<Vault>> vaultsProvider) {
    return new RemoveVaultController_Factory(windowProvider, vaultProvider, vaultsProvider);
  }

  public static RemoveVaultController newInstance(
      Stage window, Vault vault, ObservableList<Vault> vaults) {
    return new RemoveVaultController(window, vault, vaults);
  }
}
