package org.cryptomator.ui.removevault;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javafx.scene.Scene;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.cryptomator.ui.common.FxmlLoaderFactory;

@ScopeMetadata("org.cryptomator.ui.removevault.RemoveVaultScoped")
@QualifierMetadata({
  "org.cryptomator.ui.common.FxmlScene",
  "org.cryptomator.ui.removevault.RemoveVaultWindow"
})
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class RemoveVaultModule_ProvideRemoveVaultSceneFactory implements Factory<Scene> {
  private final Provider<FxmlLoaderFactory> fxmlLoadersProvider;

  public RemoveVaultModule_ProvideRemoveVaultSceneFactory(
      Provider<FxmlLoaderFactory> fxmlLoadersProvider) {
    this.fxmlLoadersProvider = fxmlLoadersProvider;
  }

  @Override
  public Scene get() {
    return provideRemoveVaultScene(fxmlLoadersProvider.get());
  }

  public static RemoveVaultModule_ProvideRemoveVaultSceneFactory create(
      Provider<FxmlLoaderFactory> fxmlLoadersProvider) {
    return new RemoveVaultModule_ProvideRemoveVaultSceneFactory(fxmlLoadersProvider);
  }

  public static Scene provideRemoveVaultScene(FxmlLoaderFactory fxmlLoaders) {
    return Preconditions.checkNotNullFromProvides(
        RemoveVaultModule.provideRemoveVaultScene(fxmlLoaders));
  }
}
