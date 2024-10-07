package org.cryptomator.ui.keyloading.hub;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javafx.scene.Scene;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.cryptomator.ui.common.FxmlLoaderFactory;

@ScopeMetadata("org.cryptomator.ui.keyloading.KeyLoadingScoped")
@QualifierMetadata({
  "org.cryptomator.ui.common.FxmlScene",
  "org.cryptomator.ui.keyloading.KeyLoading"
})
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class HubKeyLoadingModule_ProvideHubAuthFlowSceneFactory implements Factory<Scene> {
  private final Provider<FxmlLoaderFactory> fxmlLoadersProvider;

  public HubKeyLoadingModule_ProvideHubAuthFlowSceneFactory(
      Provider<FxmlLoaderFactory> fxmlLoadersProvider) {
    this.fxmlLoadersProvider = fxmlLoadersProvider;
  }

  @Override
  public Scene get() {
    return provideHubAuthFlowScene(fxmlLoadersProvider.get());
  }

  public static HubKeyLoadingModule_ProvideHubAuthFlowSceneFactory create(
      Provider<FxmlLoaderFactory> fxmlLoadersProvider) {
    return new HubKeyLoadingModule_ProvideHubAuthFlowSceneFactory(fxmlLoadersProvider);
  }

  public static Scene provideHubAuthFlowScene(FxmlLoaderFactory fxmlLoaders) {
    return Preconditions.checkNotNullFromProvides(
        HubKeyLoadingModule.provideHubAuthFlowScene(fxmlLoaders));
  }
}
