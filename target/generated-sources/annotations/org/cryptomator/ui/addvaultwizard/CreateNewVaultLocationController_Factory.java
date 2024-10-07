package org.cryptomator.ui.addvaultwizard;

import dagger.Lazy;
import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.nio.file.Path;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutorService;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("org.cryptomator.ui.addvaultwizard.AddVaultWizardScoped")
@QualifierMetadata({
  "org.cryptomator.ui.addvaultwizard.AddVaultWizardWindow",
  "org.cryptomator.ui.common.FxmlScene",
  "javax.inject.Named"
})
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class CreateNewVaultLocationController_Factory
    implements Factory<CreateNewVaultLocationController> {
  private final Provider<Stage> windowProvider;

  private final Provider<Scene> chooseNameSceneProvider;

  private final Provider<Scene> chooseExpertSettingsSceneProvider;

  private final Provider<ObjectProperty<Path>> vaultPathProvider;

  private final Provider<StringProperty> vaultNameProvider;

  private final Provider<ExecutorService> backgroundExecutorProvider;

  private final Provider<ResourceBundle> resourceBundleProvider;

  public CreateNewVaultLocationController_Factory(
      Provider<Stage> windowProvider,
      Provider<Scene> chooseNameSceneProvider,
      Provider<Scene> chooseExpertSettingsSceneProvider,
      Provider<ObjectProperty<Path>> vaultPathProvider,
      Provider<StringProperty> vaultNameProvider,
      Provider<ExecutorService> backgroundExecutorProvider,
      Provider<ResourceBundle> resourceBundleProvider) {
    this.windowProvider = windowProvider;
    this.chooseNameSceneProvider = chooseNameSceneProvider;
    this.chooseExpertSettingsSceneProvider = chooseExpertSettingsSceneProvider;
    this.vaultPathProvider = vaultPathProvider;
    this.vaultNameProvider = vaultNameProvider;
    this.backgroundExecutorProvider = backgroundExecutorProvider;
    this.resourceBundleProvider = resourceBundleProvider;
  }

  @Override
  public CreateNewVaultLocationController get() {
    return newInstance(
        windowProvider.get(),
        DoubleCheck.lazy(chooseNameSceneProvider),
        DoubleCheck.lazy(chooseExpertSettingsSceneProvider),
        vaultPathProvider.get(),
        vaultNameProvider.get(),
        backgroundExecutorProvider.get(),
        resourceBundleProvider.get());
  }

  public static CreateNewVaultLocationController_Factory create(
      Provider<Stage> windowProvider,
      Provider<Scene> chooseNameSceneProvider,
      Provider<Scene> chooseExpertSettingsSceneProvider,
      Provider<ObjectProperty<Path>> vaultPathProvider,
      Provider<StringProperty> vaultNameProvider,
      Provider<ExecutorService> backgroundExecutorProvider,
      Provider<ResourceBundle> resourceBundleProvider) {
    return new CreateNewVaultLocationController_Factory(
        windowProvider,
        chooseNameSceneProvider,
        chooseExpertSettingsSceneProvider,
        vaultPathProvider,
        vaultNameProvider,
        backgroundExecutorProvider,
        resourceBundleProvider);
  }

  public static CreateNewVaultLocationController newInstance(
      Stage window,
      Lazy<Scene> chooseNameScene,
      Lazy<Scene> chooseExpertSettingsScene,
      ObjectProperty<Path> vaultPath,
      StringProperty vaultName,
      ExecutorService backgroundExecutor,
      ResourceBundle resourceBundle) {
    return new CreateNewVaultLocationController(
        window,
        chooseNameScene,
        chooseExpertSettingsScene,
        vaultPath,
        vaultName,
        backgroundExecutor,
        resourceBundle);
  }
}
