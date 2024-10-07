package org.cryptomator.ui.mainwindow;

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

@ScopeMetadata("org.cryptomator.ui.mainwindow.MainWindowScoped")
@QualifierMetadata({"javax.inject.Named", "org.cryptomator.ui.mainwindow.MainWindow"})
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class MainWindowModule_ProvideErrorStageFactory implements Factory<Stage> {
  private final Provider<Stage> windowProvider;

  private final Provider<StageFactory> factoryProvider;

  private final Provider<ResourceBundle> resourceBundleProvider;

  public MainWindowModule_ProvideErrorStageFactory(
      Provider<Stage> windowProvider,
      Provider<StageFactory> factoryProvider,
      Provider<ResourceBundle> resourceBundleProvider) {
    this.windowProvider = windowProvider;
    this.factoryProvider = factoryProvider;
    this.resourceBundleProvider = resourceBundleProvider;
  }

  @Override
  public Stage get() {
    return provideErrorStage(
        windowProvider.get(), factoryProvider.get(), resourceBundleProvider.get());
  }

  public static MainWindowModule_ProvideErrorStageFactory create(
      Provider<Stage> windowProvider,
      Provider<StageFactory> factoryProvider,
      Provider<ResourceBundle> resourceBundleProvider) {
    return new MainWindowModule_ProvideErrorStageFactory(
        windowProvider, factoryProvider, resourceBundleProvider);
  }

  public static Stage provideErrorStage(
      Stage window, StageFactory factory, ResourceBundle resourceBundle) {
    return Preconditions.checkNotNullFromProvides(
        MainWindowModule.provideErrorStage(window, factory, resourceBundle));
  }
}
