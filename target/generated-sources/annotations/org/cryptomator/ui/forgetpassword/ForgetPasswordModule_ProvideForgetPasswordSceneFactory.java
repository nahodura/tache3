package org.cryptomator.ui.forgetpassword;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javafx.scene.Scene;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.cryptomator.ui.common.FxmlLoaderFactory;

@ScopeMetadata("org.cryptomator.ui.forgetpassword.ForgetPasswordScoped")
@QualifierMetadata({
  "org.cryptomator.ui.common.FxmlScene",
  "org.cryptomator.ui.forgetpassword.ForgetPasswordWindow"
})
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class ForgetPasswordModule_ProvideForgetPasswordSceneFactory
    implements Factory<Scene> {
  private final Provider<FxmlLoaderFactory> fxmlLoadersProvider;

  public ForgetPasswordModule_ProvideForgetPasswordSceneFactory(
      Provider<FxmlLoaderFactory> fxmlLoadersProvider) {
    this.fxmlLoadersProvider = fxmlLoadersProvider;
  }

  @Override
  public Scene get() {
    return provideForgetPasswordScene(fxmlLoadersProvider.get());
  }

  public static ForgetPasswordModule_ProvideForgetPasswordSceneFactory create(
      Provider<FxmlLoaderFactory> fxmlLoadersProvider) {
    return new ForgetPasswordModule_ProvideForgetPasswordSceneFactory(fxmlLoadersProvider);
  }

  public static Scene provideForgetPasswordScene(FxmlLoaderFactory fxmlLoaders) {
    return Preconditions.checkNotNullFromProvides(
        ForgetPasswordModule.provideForgetPasswordScene(fxmlLoaders));
  }
}
