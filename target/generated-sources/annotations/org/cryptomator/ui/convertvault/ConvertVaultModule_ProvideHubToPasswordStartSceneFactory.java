package org.cryptomator.ui.convertvault;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javafx.scene.Scene;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.cryptomator.ui.common.FxmlLoaderFactory;

@ScopeMetadata("org.cryptomator.ui.convertvault.ConvertVaultScoped")
@QualifierMetadata({
  "org.cryptomator.ui.common.FxmlScene",
  "org.cryptomator.ui.convertvault.ConvertVaultWindow"
})
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class ConvertVaultModule_ProvideHubToPasswordStartSceneFactory
    implements Factory<Scene> {
  private final Provider<FxmlLoaderFactory> fxmlLoadersProvider;

  public ConvertVaultModule_ProvideHubToPasswordStartSceneFactory(
      Provider<FxmlLoaderFactory> fxmlLoadersProvider) {
    this.fxmlLoadersProvider = fxmlLoadersProvider;
  }

  @Override
  public Scene get() {
    return provideHubToPasswordStartScene(fxmlLoadersProvider.get());
  }

  public static ConvertVaultModule_ProvideHubToPasswordStartSceneFactory create(
      Provider<FxmlLoaderFactory> fxmlLoadersProvider) {
    return new ConvertVaultModule_ProvideHubToPasswordStartSceneFactory(fxmlLoadersProvider);
  }

  public static Scene provideHubToPasswordStartScene(FxmlLoaderFactory fxmlLoaders) {
    return Preconditions.checkNotNullFromProvides(
        ConvertVaultModule.provideHubToPasswordStartScene(fxmlLoaders));
  }
}
