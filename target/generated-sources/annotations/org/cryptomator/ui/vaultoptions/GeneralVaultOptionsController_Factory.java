package org.cryptomator.ui.vaultoptions;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.util.ResourceBundle;
import javafx.stage.Stage;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.cryptomator.common.vaults.Vault;
import org.cryptomator.ui.health.HealthCheckComponent;

@ScopeMetadata("org.cryptomator.ui.vaultoptions.VaultOptionsScoped")
@QualifierMetadata("org.cryptomator.ui.vaultoptions.VaultOptionsWindow")
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class GeneralVaultOptionsController_Factory
    implements Factory<GeneralVaultOptionsController> {
  private final Provider<Stage> windowProvider;

  private final Provider<Vault> vaultProvider;

  private final Provider<HealthCheckComponent.Builder> healthCheckWindowProvider;

  private final Provider<ResourceBundle> resourceBundleProvider;

  public GeneralVaultOptionsController_Factory(
      Provider<Stage> windowProvider,
      Provider<Vault> vaultProvider,
      Provider<HealthCheckComponent.Builder> healthCheckWindowProvider,
      Provider<ResourceBundle> resourceBundleProvider) {
    this.windowProvider = windowProvider;
    this.vaultProvider = vaultProvider;
    this.healthCheckWindowProvider = healthCheckWindowProvider;
    this.resourceBundleProvider = resourceBundleProvider;
  }

  @Override
  public GeneralVaultOptionsController get() {
    return newInstance(
        windowProvider.get(),
        vaultProvider.get(),
        healthCheckWindowProvider.get(),
        resourceBundleProvider.get());
  }

  public static GeneralVaultOptionsController_Factory create(
      Provider<Stage> windowProvider,
      Provider<Vault> vaultProvider,
      Provider<HealthCheckComponent.Builder> healthCheckWindowProvider,
      Provider<ResourceBundle> resourceBundleProvider) {
    return new GeneralVaultOptionsController_Factory(
        windowProvider, vaultProvider, healthCheckWindowProvider, resourceBundleProvider);
  }

  public static GeneralVaultOptionsController newInstance(
      Stage window,
      Vault vault,
      HealthCheckComponent.Builder healthCheckWindow,
      ResourceBundle resourceBundle) {
    return new GeneralVaultOptionsController(window, vault, healthCheckWindow, resourceBundle);
  }
}
