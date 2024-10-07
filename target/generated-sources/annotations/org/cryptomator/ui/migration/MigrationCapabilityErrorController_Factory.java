package org.cryptomator.ui.migration;

import dagger.Lazy;
import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.util.ResourceBundle;
import javafx.beans.property.ObjectProperty;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.cryptomator.cryptofs.common.FileSystemCapabilityChecker;

@ScopeMetadata("org.cryptomator.ui.migration.MigrationScoped")
@QualifierMetadata({
  "org.cryptomator.ui.migration.MigrationWindow",
  "javax.inject.Named",
  "org.cryptomator.ui.common.FxmlScene"
})
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class MigrationCapabilityErrorController_Factory
    implements Factory<MigrationCapabilityErrorController> {
  private final Provider<Stage> windowProvider;

  private final Provider<ObjectProperty<FileSystemCapabilityChecker.Capability>>
      missingCapabilityProvider;

  private final Provider<ResourceBundle> localizationProvider;

  private final Provider<Scene> startSceneProvider;

  public MigrationCapabilityErrorController_Factory(
      Provider<Stage> windowProvider,
      Provider<ObjectProperty<FileSystemCapabilityChecker.Capability>> missingCapabilityProvider,
      Provider<ResourceBundle> localizationProvider,
      Provider<Scene> startSceneProvider) {
    this.windowProvider = windowProvider;
    this.missingCapabilityProvider = missingCapabilityProvider;
    this.localizationProvider = localizationProvider;
    this.startSceneProvider = startSceneProvider;
  }

  @Override
  public MigrationCapabilityErrorController get() {
    return newInstance(
        windowProvider.get(),
        missingCapabilityProvider.get(),
        localizationProvider.get(),
        DoubleCheck.lazy(startSceneProvider));
  }

  public static MigrationCapabilityErrorController_Factory create(
      Provider<Stage> windowProvider,
      Provider<ObjectProperty<FileSystemCapabilityChecker.Capability>> missingCapabilityProvider,
      Provider<ResourceBundle> localizationProvider,
      Provider<Scene> startSceneProvider) {
    return new MigrationCapabilityErrorController_Factory(
        windowProvider, missingCapabilityProvider, localizationProvider, startSceneProvider);
  }

  public static MigrationCapabilityErrorController newInstance(
      Stage window,
      ObjectProperty<FileSystemCapabilityChecker.Capability> missingCapability,
      ResourceBundle localization,
      Lazy<Scene> startScene) {
    return new MigrationCapabilityErrorController(
        window, missingCapability, localization, startScene);
  }
}
