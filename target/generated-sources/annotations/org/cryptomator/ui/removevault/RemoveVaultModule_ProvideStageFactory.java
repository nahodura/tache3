package org.cryptomator.ui.removevault;

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

@ScopeMetadata("org.cryptomator.ui.removevault.RemoveVaultScoped")
@QualifierMetadata({
  "org.cryptomator.ui.removevault.RemoveVaultWindow",
  "org.cryptomator.ui.fxapp.PrimaryStage"
})
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class RemoveVaultModule_ProvideStageFactory implements Factory<Stage> {
  private final Provider<StageFactory> factoryProvider;

  private final Provider<Stage> primaryStageProvider;

  private final Provider<Vault> vaultProvider;

  private final Provider<ResourceBundle> resourceBundleProvider;

  public RemoveVaultModule_ProvideStageFactory(
      Provider<StageFactory> factoryProvider,
      Provider<Stage> primaryStageProvider,
      Provider<Vault> vaultProvider,
      Provider<ResourceBundle> resourceBundleProvider) {
    this.factoryProvider = factoryProvider;
    this.primaryStageProvider = primaryStageProvider;
    this.vaultProvider = vaultProvider;
    this.resourceBundleProvider = resourceBundleProvider;
  }

  @Override
  public Stage get() {
    return provideStage(
        factoryProvider.get(),
        primaryStageProvider.get(),
        vaultProvider.get(),
        resourceBundleProvider.get());
  }

  public static RemoveVaultModule_ProvideStageFactory create(
      Provider<StageFactory> factoryProvider,
      Provider<Stage> primaryStageProvider,
      Provider<Vault> vaultProvider,
      Provider<ResourceBundle> resourceBundleProvider) {
    return new RemoveVaultModule_ProvideStageFactory(
        factoryProvider, primaryStageProvider, vaultProvider, resourceBundleProvider);
  }

  public static Stage provideStage(
      StageFactory factory, Stage primaryStage, Vault vault, ResourceBundle resourceBundle) {
    return Preconditions.checkNotNullFromProvides(
        RemoveVaultModule.provideStage(factory, primaryStage, vault, resourceBundle));
  }
}
