package org.cryptomator.ui.mainwindow;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.util.ResourceBundle;
import javafx.beans.property.ObjectProperty;
import javafx.stage.Stage;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.cryptomator.common.vaults.Vault;
import org.cryptomator.ui.removevault.RemoveVaultComponent;

@ScopeMetadata("org.cryptomator.ui.mainwindow.MainWindowScoped")
@QualifierMetadata("org.cryptomator.ui.mainwindow.MainWindow")
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class VaultDetailMissingVaultController_Factory
    implements Factory<VaultDetailMissingVaultController> {
  private final Provider<ObjectProperty<Vault>> vaultProvider;

  private final Provider<RemoveVaultComponent.Builder> removeVaultProvider;

  private final Provider<ResourceBundle> resourceBundleProvider;

  private final Provider<Stage> windowProvider;

  public VaultDetailMissingVaultController_Factory(
      Provider<ObjectProperty<Vault>> vaultProvider,
      Provider<RemoveVaultComponent.Builder> removeVaultProvider,
      Provider<ResourceBundle> resourceBundleProvider,
      Provider<Stage> windowProvider) {
    this.vaultProvider = vaultProvider;
    this.removeVaultProvider = removeVaultProvider;
    this.resourceBundleProvider = resourceBundleProvider;
    this.windowProvider = windowProvider;
  }

  @Override
  public VaultDetailMissingVaultController get() {
    return newInstance(
        vaultProvider.get(),
        removeVaultProvider.get(),
        resourceBundleProvider.get(),
        windowProvider.get());
  }

  public static VaultDetailMissingVaultController_Factory create(
      Provider<ObjectProperty<Vault>> vaultProvider,
      Provider<RemoveVaultComponent.Builder> removeVaultProvider,
      Provider<ResourceBundle> resourceBundleProvider,
      Provider<Stage> windowProvider) {
    return new VaultDetailMissingVaultController_Factory(
        vaultProvider, removeVaultProvider, resourceBundleProvider, windowProvider);
  }

  public static VaultDetailMissingVaultController newInstance(
      ObjectProperty<Vault> vault,
      RemoveVaultComponent.Builder removeVault,
      ResourceBundle resourceBundle,
      Stage window) {
    return new VaultDetailMissingVaultController(vault, removeVault, resourceBundle, window);
  }
}
