package org.cryptomator.ui.health;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.util.ResourceBundle;
import javafx.stage.Stage;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.cryptomator.common.vaults.Vault;
import org.cryptomator.ui.common.StageFactory;

@ScopeMetadata("org.cryptomator.ui.health.HealthCheckScoped")
@QualifierMetadata({"javax.inject.Named", "org.cryptomator.ui.health.HealthCheckWindow"})
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class HealthCheckModule_ProvideUnlockWindowFactory implements Factory<Stage> {
  private final Provider<Stage> windowProvider;

  private final Provider<Vault> vaultProvider;

  private final Provider<StageFactory> factoryProvider;

  private final Provider<ResourceBundle> resourceBundleProvider;

  public HealthCheckModule_ProvideUnlockWindowFactory(
      Provider<Stage> windowProvider,
      Provider<Vault> vaultProvider,
      Provider<StageFactory> factoryProvider,
      Provider<ResourceBundle> resourceBundleProvider) {
    this.windowProvider = windowProvider;
    this.vaultProvider = vaultProvider;
    this.factoryProvider = factoryProvider;
    this.resourceBundleProvider = resourceBundleProvider;
  }

  @Override
  public Stage get() {
    return provideUnlockWindow(
        windowProvider.get(),
        vaultProvider.get(),
        factoryProvider.get(),
        resourceBundleProvider.get());
  }

  public static HealthCheckModule_ProvideUnlockWindowFactory create(
      Provider<Stage> windowProvider,
      Provider<Vault> vaultProvider,
      Provider<StageFactory> factoryProvider,
      Provider<ResourceBundle> resourceBundleProvider) {
    return new HealthCheckModule_ProvideUnlockWindowFactory(
        windowProvider, vaultProvider, factoryProvider, resourceBundleProvider);
  }

  public static Stage provideUnlockWindow(
      Stage window, Vault vault, StageFactory factory, ResourceBundle resourceBundle) {
    return Preconditions.checkNotNullFromProvides(
        HealthCheckModule.provideUnlockWindow(window, vault, factory, resourceBundle));
  }
}
