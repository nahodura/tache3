package org.cryptomator.ui.addvaultwizard;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javafx.stage.Stage;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.cryptomator.ui.common.StageFactory;

@ScopeMetadata("org.cryptomator.ui.addvaultwizard.AddVaultWizardScoped")
@QualifierMetadata({
  "org.cryptomator.ui.addvaultwizard.AddVaultWizardWindow",
  "org.cryptomator.ui.fxapp.PrimaryStage"
})
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class AddVaultModule_ProvideStageFactory implements Factory<Stage> {
  private final Provider<StageFactory> factoryProvider;

  private final Provider<Stage> primaryStageProvider;

  public AddVaultModule_ProvideStageFactory(
      Provider<StageFactory> factoryProvider, Provider<Stage> primaryStageProvider) {
    this.factoryProvider = factoryProvider;
    this.primaryStageProvider = primaryStageProvider;
  }

  @Override
  public Stage get() {
    return provideStage(factoryProvider.get(), primaryStageProvider.get());
  }

  public static AddVaultModule_ProvideStageFactory create(
      Provider<StageFactory> factoryProvider, Provider<Stage> primaryStageProvider) {
    return new AddVaultModule_ProvideStageFactory(factoryProvider, primaryStageProvider);
  }

  public static Stage provideStage(StageFactory factory, Stage primaryStage) {
    return Preconditions.checkNotNullFromProvides(
        AddVaultModule.provideStage(factory, primaryStage));
  }
}
