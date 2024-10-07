package org.cryptomator.ui.mainwindow;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.util.Map;
import java.util.ResourceBundle;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.cryptomator.ui.common.FxController;
import org.cryptomator.ui.common.FxmlLoaderFactory;

@ScopeMetadata("org.cryptomator.ui.mainwindow.MainWindowScoped")
@QualifierMetadata("org.cryptomator.ui.mainwindow.MainWindow")
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class MainWindowModule_ProvideFxmlLoaderFactoryFactory
    implements Factory<FxmlLoaderFactory> {
  private final Provider<Map<Class<? extends FxController>, Provider<FxController>>>
      factoriesProvider;

  private final Provider<MainWindowSceneFactory> sceneFactoryProvider;

  private final Provider<ResourceBundle> resourceBundleProvider;

  public MainWindowModule_ProvideFxmlLoaderFactoryFactory(
      Provider<Map<Class<? extends FxController>, Provider<FxController>>> factoriesProvider,
      Provider<MainWindowSceneFactory> sceneFactoryProvider,
      Provider<ResourceBundle> resourceBundleProvider) {
    this.factoriesProvider = factoriesProvider;
    this.sceneFactoryProvider = sceneFactoryProvider;
    this.resourceBundleProvider = resourceBundleProvider;
  }

  @Override
  public FxmlLoaderFactory get() {
    return provideFxmlLoaderFactory(
        factoriesProvider.get(), sceneFactoryProvider.get(), resourceBundleProvider.get());
  }

  public static MainWindowModule_ProvideFxmlLoaderFactoryFactory create(
      Provider<Map<Class<? extends FxController>, Provider<FxController>>> factoriesProvider,
      Provider<MainWindowSceneFactory> sceneFactoryProvider,
      Provider<ResourceBundle> resourceBundleProvider) {
    return new MainWindowModule_ProvideFxmlLoaderFactoryFactory(
        factoriesProvider, sceneFactoryProvider, resourceBundleProvider);
  }

  public static FxmlLoaderFactory provideFxmlLoaderFactory(
      Map<Class<? extends FxController>, Provider<FxController>> factories,
      MainWindowSceneFactory sceneFactory,
      ResourceBundle resourceBundle) {
    return Preconditions.checkNotNullFromProvides(
        MainWindowModule.provideFxmlLoaderFactory(factories, sceneFactory, resourceBundle));
  }
}
