package org.cryptomator.ui.lock;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.util.Map;
import java.util.ResourceBundle;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.cryptomator.ui.common.DefaultSceneFactory;
import org.cryptomator.ui.common.FxController;
import org.cryptomator.ui.common.FxmlLoaderFactory;

@ScopeMetadata("org.cryptomator.ui.lock.LockScoped")
@QualifierMetadata("org.cryptomator.ui.lock.LockWindow")
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class LockModule_ProvideFxmlLoaderFactoryFactory
    implements Factory<FxmlLoaderFactory> {
  private final Provider<Map<Class<? extends FxController>, Provider<FxController>>>
      factoriesProvider;

  private final Provider<DefaultSceneFactory> sceneFactoryProvider;

  private final Provider<ResourceBundle> resourceBundleProvider;

  public LockModule_ProvideFxmlLoaderFactoryFactory(
      Provider<Map<Class<? extends FxController>, Provider<FxController>>> factoriesProvider,
      Provider<DefaultSceneFactory> sceneFactoryProvider,
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

  public static LockModule_ProvideFxmlLoaderFactoryFactory create(
      Provider<Map<Class<? extends FxController>, Provider<FxController>>> factoriesProvider,
      Provider<DefaultSceneFactory> sceneFactoryProvider,
      Provider<ResourceBundle> resourceBundleProvider) {
    return new LockModule_ProvideFxmlLoaderFactoryFactory(
        factoriesProvider, sceneFactoryProvider, resourceBundleProvider);
  }

  public static FxmlLoaderFactory provideFxmlLoaderFactory(
      Map<Class<? extends FxController>, Provider<FxController>> factories,
      DefaultSceneFactory sceneFactory,
      ResourceBundle resourceBundle) {
    return Preconditions.checkNotNullFromProvides(
        LockModule.provideFxmlLoaderFactory(factories, sceneFactory, resourceBundle));
  }
}
