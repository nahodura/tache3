package org.cryptomator.ui.convertvault;

import dagger.Lazy;
import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata({
  "org.cryptomator.ui.convertvault.ConvertVaultWindow",
  "org.cryptomator.ui.common.FxmlScene"
})
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class HubToPasswordStartController_Factory
    implements Factory<HubToPasswordStartController> {
  private final Provider<Stage> windowProvider;

  private final Provider<Scene> convertSceneProvider;

  public HubToPasswordStartController_Factory(
      Provider<Stage> windowProvider, Provider<Scene> convertSceneProvider) {
    this.windowProvider = windowProvider;
    this.convertSceneProvider = convertSceneProvider;
  }

  @Override
  public HubToPasswordStartController get() {
    return newInstance(windowProvider.get(), DoubleCheck.lazy(convertSceneProvider));
  }

  public static HubToPasswordStartController_Factory create(
      Provider<Stage> windowProvider, Provider<Scene> convertSceneProvider) {
    return new HubToPasswordStartController_Factory(windowProvider, convertSceneProvider);
  }

  public static HubToPasswordStartController newInstance(Stage window, Lazy<Scene> convertScene) {
    return new HubToPasswordStartController(window, convertScene);
  }
}
