package org.cryptomator.ui.addvaultwizard;

import dagger.Lazy;
import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.nio.file.Path;
import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
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
public final class CreateNewVaultExpertSettingsController_Factory
    implements Factory<CreateNewVaultExpertSettingsController> {
  private final Provider<Stage> windowProvider;

  private final Provider<Application> applicationProvider;

  private final Provider<Scene> chooseLocationSceneProvider;

  private final Provider<Scene> choosePasswordSceneProvider;

  private final Provider<StringProperty> vaultNameProvider;

  private final Provider<ObjectProperty<Path>> vaultPathProvider;

  private final Provider<IntegerProperty> shorteningThresholdProvider;

  public CreateNewVaultExpertSettingsController_Factory(
      Provider<Stage> windowProvider,
      Provider<Application> applicationProvider,
      Provider<Scene> chooseLocationSceneProvider,
      Provider<Scene> choosePasswordSceneProvider,
      Provider<StringProperty> vaultNameProvider,
      Provider<ObjectProperty<Path>> vaultPathProvider,
      Provider<IntegerProperty> shorteningThresholdProvider) {
    this.windowProvider = windowProvider;
    this.applicationProvider = applicationProvider;
    this.chooseLocationSceneProvider = chooseLocationSceneProvider;
    this.choosePasswordSceneProvider = choosePasswordSceneProvider;
    this.vaultNameProvider = vaultNameProvider;
    this.vaultPathProvider = vaultPathProvider;
    this.shorteningThresholdProvider = shorteningThresholdProvider;
  }

  @Override
  public CreateNewVaultExpertSettingsController get() {
    return newInstance(
        windowProvider.get(),
        DoubleCheck.lazy(applicationProvider),
        DoubleCheck.lazy(chooseLocationSceneProvider),
        DoubleCheck.lazy(choosePasswordSceneProvider),
        vaultNameProvider.get(),
        vaultPathProvider.get(),
        shorteningThresholdProvider.get());
  }

  public static CreateNewVaultExpertSettingsController_Factory create(
      Provider<Stage> windowProvider,
      Provider<Application> applicationProvider,
      Provider<Scene> chooseLocationSceneProvider,
      Provider<Scene> choosePasswordSceneProvider,
      Provider<StringProperty> vaultNameProvider,
      Provider<ObjectProperty<Path>> vaultPathProvider,
      Provider<IntegerProperty> shorteningThresholdProvider) {
    return new CreateNewVaultExpertSettingsController_Factory(
        windowProvider,
        applicationProvider,
        chooseLocationSceneProvider,
        choosePasswordSceneProvider,
        vaultNameProvider,
        vaultPathProvider,
        shorteningThresholdProvider);
  }

  public static CreateNewVaultExpertSettingsController newInstance(
      Stage window,
      Lazy<Application> application,
      Lazy<Scene> chooseLocationScene,
      Lazy<Scene> choosePasswordScene,
      StringProperty vaultName,
      ObjectProperty<Path> vaultPath,
      IntegerProperty shorteningThreshold) {
    return new CreateNewVaultExpertSettingsController(
        window,
        application,
        chooseLocationScene,
        choosePasswordScene,
        vaultName,
        vaultPath,
        shorteningThreshold);
  }
}
