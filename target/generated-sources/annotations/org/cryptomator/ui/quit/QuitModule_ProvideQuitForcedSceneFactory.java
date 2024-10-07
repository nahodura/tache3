package org.cryptomator.ui.quit;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javafx.scene.Scene;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.cryptomator.ui.common.FxmlLoaderFactory;

@ScopeMetadata("org.cryptomator.ui.quit.QuitScoped")
@QualifierMetadata({"org.cryptomator.ui.common.FxmlScene", "org.cryptomator.ui.quit.QuitWindow"})
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class QuitModule_ProvideQuitForcedSceneFactory implements Factory<Scene> {
  private final Provider<FxmlLoaderFactory> fxmlLoadersProvider;

  public QuitModule_ProvideQuitForcedSceneFactory(Provider<FxmlLoaderFactory> fxmlLoadersProvider) {
    this.fxmlLoadersProvider = fxmlLoadersProvider;
  }

  @Override
  public Scene get() {
    return provideQuitForcedScene(fxmlLoadersProvider.get());
  }

  public static QuitModule_ProvideQuitForcedSceneFactory create(
      Provider<FxmlLoaderFactory> fxmlLoadersProvider) {
    return new QuitModule_ProvideQuitForcedSceneFactory(fxmlLoadersProvider);
  }

  public static Scene provideQuitForcedScene(FxmlLoaderFactory fxmlLoaders) {
    return Preconditions.checkNotNullFromProvides(QuitModule.provideQuitForcedScene(fxmlLoaders));
  }
}
