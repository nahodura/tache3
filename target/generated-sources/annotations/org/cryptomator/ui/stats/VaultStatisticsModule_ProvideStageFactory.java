package org.cryptomator.ui.stats;

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

@ScopeMetadata("org.cryptomator.ui.stats.VaultStatisticsScoped")
@QualifierMetadata("org.cryptomator.ui.stats.VaultStatisticsWindow")
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class VaultStatisticsModule_ProvideStageFactory implements Factory<Stage> {
  private final Provider<StageFactory> factoryProvider;

  private final Provider<ResourceBundle> resourceBundleProvider;

  private final Provider<Vault> vaultProvider;

  public VaultStatisticsModule_ProvideStageFactory(
      Provider<StageFactory> factoryProvider,
      Provider<ResourceBundle> resourceBundleProvider,
      Provider<Vault> vaultProvider) {
    this.factoryProvider = factoryProvider;
    this.resourceBundleProvider = resourceBundleProvider;
    this.vaultProvider = vaultProvider;
  }

  @Override
  public Stage get() {
    return provideStage(factoryProvider.get(), resourceBundleProvider.get(), vaultProvider.get());
  }

  public static VaultStatisticsModule_ProvideStageFactory create(
      Provider<StageFactory> factoryProvider,
      Provider<ResourceBundle> resourceBundleProvider,
      Provider<Vault> vaultProvider) {
    return new VaultStatisticsModule_ProvideStageFactory(
        factoryProvider, resourceBundleProvider, vaultProvider);
  }

  public static Stage provideStage(
      StageFactory factory, ResourceBundle resourceBundle, Vault vault) {
    return Preconditions.checkNotNullFromProvides(
        VaultStatisticsModule.provideStage(factory, resourceBundle, vault));
  }
}
