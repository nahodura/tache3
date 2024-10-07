package org.cryptomator.ui.stats;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javafx.stage.Stage;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.cryptomator.common.vaults.Vault;

@ScopeMetadata("org.cryptomator.ui.stats.VaultStatisticsScoped")
@QualifierMetadata("org.cryptomator.ui.stats.VaultStatisticsWindow")
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class VaultStatisticsController_Factory implements Factory<VaultStatisticsController> {
  private final Provider<VaultStatisticsComponent> componentProvider;

  private final Provider<Stage> windowProvider;

  private final Provider<Vault> vaultProvider;

  public VaultStatisticsController_Factory(
      Provider<VaultStatisticsComponent> componentProvider,
      Provider<Stage> windowProvider,
      Provider<Vault> vaultProvider) {
    this.componentProvider = componentProvider;
    this.windowProvider = windowProvider;
    this.vaultProvider = vaultProvider;
  }

  @Override
  public VaultStatisticsController get() {
    return newInstance(componentProvider.get(), windowProvider.get(), vaultProvider.get());
  }

  public static VaultStatisticsController_Factory create(
      Provider<VaultStatisticsComponent> componentProvider,
      Provider<Stage> windowProvider,
      Provider<Vault> vaultProvider) {
    return new VaultStatisticsController_Factory(componentProvider, windowProvider, vaultProvider);
  }

  public static VaultStatisticsController newInstance(
      VaultStatisticsComponent component, Stage window, Vault vault) {
    return new VaultStatisticsController(component, window, vault);
  }
}
