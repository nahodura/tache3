package org.cryptomator.ui.vaultoptions;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javafx.beans.property.ObjectProperty;
import javafx.stage.Stage;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.cryptomator.common.vaults.Vault;

@ScopeMetadata("org.cryptomator.ui.vaultoptions.VaultOptionsScoped")
@QualifierMetadata("org.cryptomator.ui.vaultoptions.VaultOptionsWindow")
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class VaultOptionsController_Factory implements Factory<VaultOptionsController> {
  private final Provider<Stage> windowProvider;

  private final Provider<Vault> vaultProvider;

  private final Provider<ObjectProperty<SelectedVaultOptionsTab>> selectedTabPropertyProvider;

  public VaultOptionsController_Factory(
      Provider<Stage> windowProvider,
      Provider<Vault> vaultProvider,
      Provider<ObjectProperty<SelectedVaultOptionsTab>> selectedTabPropertyProvider) {
    this.windowProvider = windowProvider;
    this.vaultProvider = vaultProvider;
    this.selectedTabPropertyProvider = selectedTabPropertyProvider;
  }

  @Override
  public VaultOptionsController get() {
    return newInstance(
        windowProvider.get(), vaultProvider.get(), selectedTabPropertyProvider.get());
  }

  public static VaultOptionsController_Factory create(
      Provider<Stage> windowProvider,
      Provider<Vault> vaultProvider,
      Provider<ObjectProperty<SelectedVaultOptionsTab>> selectedTabPropertyProvider) {
    return new VaultOptionsController_Factory(
        windowProvider, vaultProvider, selectedTabPropertyProvider);
  }

  public static VaultOptionsController newInstance(
      Stage window, Vault vault, ObjectProperty<SelectedVaultOptionsTab> selectedTabProperty) {
    return new VaultOptionsController(window, vault, selectedTabProperty);
  }
}
