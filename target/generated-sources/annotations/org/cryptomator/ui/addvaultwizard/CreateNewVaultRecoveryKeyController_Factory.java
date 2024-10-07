package org.cryptomator.ui.addvaultwizard;

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
  "org.cryptomator.ui.addvaultwizard.AddVaultWizardWindow",
  "org.cryptomator.ui.common.FxmlScene"
})
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class CreateNewVaultRecoveryKeyController_Factory
    implements Factory<CreateNewVaultRecoveryKeyController> {
  private final Provider<Stage> windowProvider;

  private final Provider<Scene> successSceneProvider;

  public CreateNewVaultRecoveryKeyController_Factory(
      Provider<Stage> windowProvider, Provider<Scene> successSceneProvider) {
    this.windowProvider = windowProvider;
    this.successSceneProvider = successSceneProvider;
  }

  @Override
  public CreateNewVaultRecoveryKeyController get() {
    return newInstance(windowProvider.get(), DoubleCheck.lazy(successSceneProvider));
  }

  public static CreateNewVaultRecoveryKeyController_Factory create(
      Provider<Stage> windowProvider, Provider<Scene> successSceneProvider) {
    return new CreateNewVaultRecoveryKeyController_Factory(windowProvider, successSceneProvider);
  }

  public static CreateNewVaultRecoveryKeyController newInstance(
      Stage window, Lazy<Scene> successScene) {
    return new CreateNewVaultRecoveryKeyController(window, successScene);
  }
}
