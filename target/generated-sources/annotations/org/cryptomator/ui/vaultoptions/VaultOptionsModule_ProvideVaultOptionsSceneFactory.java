package org.cryptomator.ui.vaultoptions;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javafx.scene.Scene;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.cryptomator.ui.common.FxmlLoaderFactory;

@ScopeMetadata("org.cryptomator.ui.vaultoptions.VaultOptionsScoped")
@QualifierMetadata({
  "org.cryptomator.ui.common.FxmlScene",
  "org.cryptomator.ui.vaultoptions.VaultOptionsWindow"
})
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class VaultOptionsModule_ProvideVaultOptionsSceneFactory implements Factory<Scene> {
  private final Provider<FxmlLoaderFactory> fxmlLoadersProvider;

  public VaultOptionsModule_ProvideVaultOptionsSceneFactory(
      Provider<FxmlLoaderFactory> fxmlLoadersProvider) {
    this.fxmlLoadersProvider = fxmlLoadersProvider;
  }

  @Override
  public Scene get() {
    return provideVaultOptionsScene(fxmlLoadersProvider.get());
  }

  public static VaultOptionsModule_ProvideVaultOptionsSceneFactory create(
      Provider<FxmlLoaderFactory> fxmlLoadersProvider) {
    return new VaultOptionsModule_ProvideVaultOptionsSceneFactory(fxmlLoadersProvider);
  }

  public static Scene provideVaultOptionsScene(FxmlLoaderFactory fxmlLoaders) {
    return Preconditions.checkNotNullFromProvides(
        VaultOptionsModule.provideVaultOptionsScene(fxmlLoaders));
  }
}
