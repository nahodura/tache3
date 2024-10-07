package org.cryptomator.ui.error;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javafx.scene.Scene;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.cryptomator.ui.common.FxmlLoaderFactory;

@ScopeMetadata
@QualifierMetadata("org.cryptomator.ui.common.FxmlScene")
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class ErrorModule_ProvideErrorSceneFactory implements Factory<Scene> {
  private final Provider<FxmlLoaderFactory> fxmlLoadersProvider;

  public ErrorModule_ProvideErrorSceneFactory(Provider<FxmlLoaderFactory> fxmlLoadersProvider) {
    this.fxmlLoadersProvider = fxmlLoadersProvider;
  }

  @Override
  public Scene get() {
    return provideErrorScene(fxmlLoadersProvider.get());
  }

  public static ErrorModule_ProvideErrorSceneFactory create(
      Provider<FxmlLoaderFactory> fxmlLoadersProvider) {
    return new ErrorModule_ProvideErrorSceneFactory(fxmlLoadersProvider);
  }

  public static Scene provideErrorScene(FxmlLoaderFactory fxmlLoaders) {
    return Preconditions.checkNotNullFromProvides(ErrorModule.provideErrorScene(fxmlLoaders));
  }
}
