package org.cryptomator.ui.preferences;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.util.ResourceBundle;
import javafx.application.Application;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.cryptomator.common.Environment;
import org.cryptomator.common.settings.Settings;
import org.cryptomator.ui.fxapp.UpdateChecker;

@ScopeMetadata("org.cryptomator.ui.preferences.PreferencesScoped")
@QualifierMetadata
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class UpdatesPreferencesController_Factory
    implements Factory<UpdatesPreferencesController> {
  private final Provider<Application> applicationProvider;

  private final Provider<Environment> environmentProvider;

  private final Provider<ResourceBundle> resourceBundleProvider;

  private final Provider<Settings> settingsProvider;

  private final Provider<UpdateChecker> updateCheckerProvider;

  public UpdatesPreferencesController_Factory(
      Provider<Application> applicationProvider,
      Provider<Environment> environmentProvider,
      Provider<ResourceBundle> resourceBundleProvider,
      Provider<Settings> settingsProvider,
      Provider<UpdateChecker> updateCheckerProvider) {
    this.applicationProvider = applicationProvider;
    this.environmentProvider = environmentProvider;
    this.resourceBundleProvider = resourceBundleProvider;
    this.settingsProvider = settingsProvider;
    this.updateCheckerProvider = updateCheckerProvider;
  }

  @Override
  public UpdatesPreferencesController get() {
    return newInstance(
        applicationProvider.get(),
        environmentProvider.get(),
        resourceBundleProvider.get(),
        settingsProvider.get(),
        updateCheckerProvider.get());
  }

  public static UpdatesPreferencesController_Factory create(
      Provider<Application> applicationProvider,
      Provider<Environment> environmentProvider,
      Provider<ResourceBundle> resourceBundleProvider,
      Provider<Settings> settingsProvider,
      Provider<UpdateChecker> updateCheckerProvider) {
    return new UpdatesPreferencesController_Factory(
        applicationProvider,
        environmentProvider,
        resourceBundleProvider,
        settingsProvider,
        updateCheckerProvider);
  }

  public static UpdatesPreferencesController newInstance(
      Application application,
      Environment environment,
      ResourceBundle resourceBundle,
      Settings settings,
      UpdateChecker updateChecker) {
    return new UpdatesPreferencesController(
        application, environment, resourceBundle, settings, updateChecker);
  }
}
