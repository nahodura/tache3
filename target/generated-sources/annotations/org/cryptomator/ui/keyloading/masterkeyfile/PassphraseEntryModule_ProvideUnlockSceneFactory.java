package org.cryptomator.ui.keyloading.masterkeyfile;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.util.ResourceBundle;
import javafx.scene.Scene;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.cryptomator.ui.common.DefaultSceneFactory;

@ScopeMetadata("org.cryptomator.ui.keyloading.masterkeyfile.PassphraseEntryScoped")
@QualifierMetadata
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class PassphraseEntryModule_ProvideUnlockSceneFactory implements Factory<Scene> {
  private final Provider<PassphraseEntryController> controllerProvider;

  private final Provider<DefaultSceneFactory> sceneFactoryProvider;

  private final Provider<ResourceBundle> resourceBundleProvider;

  public PassphraseEntryModule_ProvideUnlockSceneFactory(
      Provider<PassphraseEntryController> controllerProvider,
      Provider<DefaultSceneFactory> sceneFactoryProvider,
      Provider<ResourceBundle> resourceBundleProvider) {
    this.controllerProvider = controllerProvider;
    this.sceneFactoryProvider = sceneFactoryProvider;
    this.resourceBundleProvider = resourceBundleProvider;
  }

  @Override
  public Scene get() {
    return provideUnlockScene(
        controllerProvider.get(), sceneFactoryProvider.get(), resourceBundleProvider.get());
  }

  public static PassphraseEntryModule_ProvideUnlockSceneFactory create(
      Provider<PassphraseEntryController> controllerProvider,
      Provider<DefaultSceneFactory> sceneFactoryProvider,
      Provider<ResourceBundle> resourceBundleProvider) {
    return new PassphraseEntryModule_ProvideUnlockSceneFactory(
        controllerProvider, sceneFactoryProvider, resourceBundleProvider);
  }

  public static Scene provideUnlockScene(
      PassphraseEntryController controller,
      DefaultSceneFactory sceneFactory,
      ResourceBundle resourceBundle) {
    return Preconditions.checkNotNullFromProvides(
        PassphraseEntryModule.provideUnlockScene(controller, sceneFactory, resourceBundle));
  }
}
