package org.cryptomator.ui.wrongfilealert;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.util.ResourceBundle;
import javafx.stage.Stage;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.cryptomator.ui.common.StageFactory;

@ScopeMetadata("org.cryptomator.ui.wrongfilealert.WrongFileAlertScoped")
@QualifierMetadata({
  "org.cryptomator.ui.wrongfilealert.WrongFileAlertWindow",
  "org.cryptomator.ui.fxapp.PrimaryStage"
})
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class WrongFileAlertModule_ProvideStageFactory implements Factory<Stage> {
  private final Provider<StageFactory> factoryProvider;

  private final Provider<Stage> primaryStageProvider;

  private final Provider<ResourceBundle> resourceBundleProvider;

  public WrongFileAlertModule_ProvideStageFactory(
      Provider<StageFactory> factoryProvider,
      Provider<Stage> primaryStageProvider,
      Provider<ResourceBundle> resourceBundleProvider) {
    this.factoryProvider = factoryProvider;
    this.primaryStageProvider = primaryStageProvider;
    this.resourceBundleProvider = resourceBundleProvider;
  }

  @Override
  public Stage get() {
    return provideStage(
        factoryProvider.get(), primaryStageProvider.get(), resourceBundleProvider.get());
  }

  public static WrongFileAlertModule_ProvideStageFactory create(
      Provider<StageFactory> factoryProvider,
      Provider<Stage> primaryStageProvider,
      Provider<ResourceBundle> resourceBundleProvider) {
    return new WrongFileAlertModule_ProvideStageFactory(
        factoryProvider, primaryStageProvider, resourceBundleProvider);
  }

  public static Stage provideStage(
      StageFactory factory, Stage primaryStage, ResourceBundle resourceBundle) {
    return Preconditions.checkNotNullFromProvides(
        WrongFileAlertModule.provideStage(factory, primaryStage, resourceBundle));
  }
}
