package org.cryptomator.ui.mainwindow;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javafx.stage.Stage;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.cryptomator.ui.common.StageInitializer;

@ScopeMetadata("org.cryptomator.ui.mainwindow.MainWindowScoped")
@QualifierMetadata({
  "org.cryptomator.ui.mainwindow.MainWindow",
  "org.cryptomator.ui.fxapp.PrimaryStage"
})
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class MainWindowModule_ProvideMainWindowFactory implements Factory<Stage> {
  private final Provider<Stage> stageProvider;

  private final Provider<StageInitializer> initializerProvider;

  public MainWindowModule_ProvideMainWindowFactory(
      Provider<Stage> stageProvider, Provider<StageInitializer> initializerProvider) {
    this.stageProvider = stageProvider;
    this.initializerProvider = initializerProvider;
  }

  @Override
  public Stage get() {
    return provideMainWindow(stageProvider.get(), initializerProvider.get());
  }

  public static MainWindowModule_ProvideMainWindowFactory create(
      Provider<Stage> stageProvider, Provider<StageInitializer> initializerProvider) {
    return new MainWindowModule_ProvideMainWindowFactory(stageProvider, initializerProvider);
  }

  public static Stage provideMainWindow(Stage stage, StageInitializer initializer) {
    return Preconditions.checkNotNullFromProvides(
        MainWindowModule.provideMainWindow(stage, initializer));
  }
}
