package org.cryptomator.ui.addvaultwizard;

import dagger.Lazy;
import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.nio.file.Path;
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
public final class CreateNewVaultNameController_Factory
    implements Factory<CreateNewVaultNameController> {
  private final Provider<Stage> windowProvider;

  private final Provider<Scene> chooseLocationSceneProvider;

  private final Provider<ObjectProperty<Path>> vaultPathProvider;

  private final Provider<StringProperty> vaultNameProvider;

  public CreateNewVaultNameController_Factory(
      Provider<Stage> windowProvider,
      Provider<Scene> chooseLocationSceneProvider,
      Provider<ObjectProperty<Path>> vaultPathProvider,
      Provider<StringProperty> vaultNameProvider) {
    this.windowProvider = windowProvider;
    this.chooseLocationSceneProvider = chooseLocationSceneProvider;
    this.vaultPathProvider = vaultPathProvider;
    this.vaultNameProvider = vaultNameProvider;
  }

  @Override
  public CreateNewVaultNameController get() {
    return newInstance(
        windowProvider.get(),
        DoubleCheck.lazy(chooseLocationSceneProvider),
        vaultPathProvider.get(),
        vaultNameProvider.get());
  }

  public static CreateNewVaultNameController_Factory create(
      Provider<Stage> windowProvider,
      Provider<Scene> chooseLocationSceneProvider,
      Provider<ObjectProperty<Path>> vaultPathProvider,
      Provider<StringProperty> vaultNameProvider) {
    return new CreateNewVaultNameController_Factory(
        windowProvider, chooseLocationSceneProvider, vaultPathProvider, vaultNameProvider);
  }

  public static CreateNewVaultNameController newInstance(
      Stage window,
      Lazy<Scene> chooseLocationScene,
      ObjectProperty<Path> vaultPath,
      StringProperty vaultName) {
    return new CreateNewVaultNameController(window, chooseLocationScene, vaultPath, vaultName);
  }
}
