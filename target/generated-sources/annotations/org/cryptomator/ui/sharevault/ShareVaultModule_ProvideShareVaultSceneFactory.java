package org.cryptomator.ui.sharevault;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javafx.scene.Scene;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.cryptomator.ui.common.FxmlLoaderFactory;

@ScopeMetadata("org.cryptomator.ui.sharevault.ShareVaultScoped")
@QualifierMetadata({
  "org.cryptomator.ui.common.FxmlScene",
  "org.cryptomator.ui.sharevault.ShareVaultWindow"
})
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class ShareVaultModule_ProvideShareVaultSceneFactory implements Factory<Scene> {
  private final Provider<FxmlLoaderFactory> fxmlLoadersProvider;

  public ShareVaultModule_ProvideShareVaultSceneFactory(
      Provider<FxmlLoaderFactory> fxmlLoadersProvider) {
    this.fxmlLoadersProvider = fxmlLoadersProvider;
  }

  @Override
  public Scene get() {
    return provideShareVaultScene(fxmlLoadersProvider.get());
  }

  public static ShareVaultModule_ProvideShareVaultSceneFactory create(
      Provider<FxmlLoaderFactory> fxmlLoadersProvider) {
    return new ShareVaultModule_ProvideShareVaultSceneFactory(fxmlLoadersProvider);
  }

  public static Scene provideShareVaultScene(FxmlLoaderFactory fxmlLoaders) {
    return Preconditions.checkNotNullFromProvides(
        ShareVaultModule.provideShareVaultScene(fxmlLoaders));
  }
}
