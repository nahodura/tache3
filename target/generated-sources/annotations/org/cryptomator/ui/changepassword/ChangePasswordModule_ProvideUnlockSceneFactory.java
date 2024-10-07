package org.cryptomator.ui.changepassword;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javafx.scene.Scene;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.cryptomator.ui.common.FxmlLoaderFactory;

@ScopeMetadata("org.cryptomator.ui.changepassword.ChangePasswordScoped")
@QualifierMetadata({
  "org.cryptomator.ui.common.FxmlScene",
  "org.cryptomator.ui.changepassword.ChangePasswordWindow"
})
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class ChangePasswordModule_ProvideUnlockSceneFactory implements Factory<Scene> {
  private final Provider<FxmlLoaderFactory> fxmlLoadersProvider;

  public ChangePasswordModule_ProvideUnlockSceneFactory(
      Provider<FxmlLoaderFactory> fxmlLoadersProvider) {
    this.fxmlLoadersProvider = fxmlLoadersProvider;
  }

  @Override
  public Scene get() {
    return provideUnlockScene(fxmlLoadersProvider.get());
  }

  public static ChangePasswordModule_ProvideUnlockSceneFactory create(
      Provider<FxmlLoaderFactory> fxmlLoadersProvider) {
    return new ChangePasswordModule_ProvideUnlockSceneFactory(fxmlLoadersProvider);
  }

  public static Scene provideUnlockScene(FxmlLoaderFactory fxmlLoaders) {
    return Preconditions.checkNotNullFromProvides(
        ChangePasswordModule.provideUnlockScene(fxmlLoaders));
  }
}
