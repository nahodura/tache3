package org.cryptomator.ui.lock;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javafx.scene.Scene;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.cryptomator.ui.common.FxmlLoaderFactory;

@ScopeMetadata("org.cryptomator.ui.lock.LockScoped")
@QualifierMetadata({"org.cryptomator.ui.common.FxmlScene", "org.cryptomator.ui.lock.LockWindow"})
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class LockModule_ProvideLockFailedSceneFactory implements Factory<Scene> {
  private final Provider<FxmlLoaderFactory> fxmlLoadersProvider;

  public LockModule_ProvideLockFailedSceneFactory(Provider<FxmlLoaderFactory> fxmlLoadersProvider) {
    this.fxmlLoadersProvider = fxmlLoadersProvider;
  }

  @Override
  public Scene get() {
    return provideLockFailedScene(fxmlLoadersProvider.get());
  }

  public static LockModule_ProvideLockFailedSceneFactory create(
      Provider<FxmlLoaderFactory> fxmlLoadersProvider) {
    return new LockModule_ProvideLockFailedSceneFactory(fxmlLoadersProvider);
  }

  public static Scene provideLockFailedScene(FxmlLoaderFactory fxmlLoaders) {
    return Preconditions.checkNotNullFromProvides(LockModule.provideLockFailedScene(fxmlLoaders));
  }
}
