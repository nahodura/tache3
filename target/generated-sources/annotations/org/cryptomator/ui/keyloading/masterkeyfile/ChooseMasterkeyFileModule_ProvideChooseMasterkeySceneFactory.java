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

@ScopeMetadata("org.cryptomator.ui.keyloading.masterkeyfile.ChooseMasterkeyFileScoped")
@QualifierMetadata
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class ChooseMasterkeyFileModule_ProvideChooseMasterkeySceneFactory
    implements Factory<Scene> {
  private final Provider<ChooseMasterkeyFileController> controllerProvider;

  private final Provider<DefaultSceneFactory> sceneFactoryProvider;

  private final Provider<ResourceBundle> resourceBundleProvider;

  public ChooseMasterkeyFileModule_ProvideChooseMasterkeySceneFactory(
      Provider<ChooseMasterkeyFileController> controllerProvider,
      Provider<DefaultSceneFactory> sceneFactoryProvider,
      Provider<ResourceBundle> resourceBundleProvider) {
    this.controllerProvider = controllerProvider;
    this.sceneFactoryProvider = sceneFactoryProvider;
    this.resourceBundleProvider = resourceBundleProvider;
  }

  @Override
  public Scene get() {
    return provideChooseMasterkeyScene(
        controllerProvider.get(), sceneFactoryProvider.get(), resourceBundleProvider.get());
  }

  public static ChooseMasterkeyFileModule_ProvideChooseMasterkeySceneFactory create(
      Provider<ChooseMasterkeyFileController> controllerProvider,
      Provider<DefaultSceneFactory> sceneFactoryProvider,
      Provider<ResourceBundle> resourceBundleProvider) {
    return new ChooseMasterkeyFileModule_ProvideChooseMasterkeySceneFactory(
        controllerProvider, sceneFactoryProvider, resourceBundleProvider);
  }

  public static Scene provideChooseMasterkeyScene(
      ChooseMasterkeyFileController controller,
      DefaultSceneFactory sceneFactory,
      ResourceBundle resourceBundle) {
    return Preconditions.checkNotNullFromProvides(
        ChooseMasterkeyFileModule.provideChooseMasterkeyScene(
            controller, sceneFactory, resourceBundle));
  }
}
