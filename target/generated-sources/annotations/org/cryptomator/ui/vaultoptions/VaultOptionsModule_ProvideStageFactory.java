package org.cryptomator.ui.vaultoptions;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javafx.stage.Stage;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.cryptomator.common.vaults.Vault;
import org.cryptomator.ui.common.StageFactory;

@ScopeMetadata("org.cryptomator.ui.vaultoptions.VaultOptionsScoped")
@QualifierMetadata({
  "org.cryptomator.ui.vaultoptions.VaultOptionsWindow",
  "org.cryptomator.ui.fxapp.PrimaryStage"
})
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class VaultOptionsModule_ProvideStageFactory implements Factory<Stage> {
  private final Provider<StageFactory> factoryProvider;

  private final Provider<Stage> primaryStageProvider;

  private final Provider<Vault> vaultProvider;

  public VaultOptionsModule_ProvideStageFactory(
      Provider<StageFactory> factoryProvider,
      Provider<Stage> primaryStageProvider,
      Provider<Vault> vaultProvider) {
    this.factoryProvider = factoryProvider;
    this.primaryStageProvider = primaryStageProvider;
    this.vaultProvider = vaultProvider;
  }

  @Override
  public Stage get() {
    return provideStage(factoryProvider.get(), primaryStageProvider.get(), vaultProvider.get());
  }

  public static VaultOptionsModule_ProvideStageFactory create(
      Provider<StageFactory> factoryProvider,
      Provider<Stage> primaryStageProvider,
      Provider<Vault> vaultProvider) {
    return new VaultOptionsModule_ProvideStageFactory(
        factoryProvider, primaryStageProvider, vaultProvider);
  }

  public static Stage provideStage(StageFactory factory, Stage primaryStage, Vault vault) {
    return Preconditions.checkNotNullFromProvides(
        VaultOptionsModule.provideStage(factory, primaryStage, vault));
  }
}
