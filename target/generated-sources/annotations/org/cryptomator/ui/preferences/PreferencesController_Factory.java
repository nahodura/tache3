package org.cryptomator.ui.preferences;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javafx.beans.property.ObjectProperty;
import javafx.stage.Stage;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.cryptomator.common.Environment;
import org.cryptomator.ui.fxapp.UpdateChecker;

@ScopeMetadata("org.cryptomator.ui.preferences.PreferencesScoped")
@QualifierMetadata("org.cryptomator.ui.preferences.PreferencesWindow")
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class PreferencesController_Factory implements Factory<PreferencesController> {
  private final Provider<Environment> envProvider;

  private final Provider<Stage> windowProvider;

  private final Provider<ObjectProperty<SelectedPreferencesTab>> selectedTabPropertyProvider;

  private final Provider<UpdateChecker> updateCheckerProvider;

  public PreferencesController_Factory(
      Provider<Environment> envProvider,
      Provider<Stage> windowProvider,
      Provider<ObjectProperty<SelectedPreferencesTab>> selectedTabPropertyProvider,
      Provider<UpdateChecker> updateCheckerProvider) {
    this.envProvider = envProvider;
    this.windowProvider = windowProvider;
    this.selectedTabPropertyProvider = selectedTabPropertyProvider;
    this.updateCheckerProvider = updateCheckerProvider;
  }

  @Override
  public PreferencesController get() {
    return newInstance(
        envProvider.get(),
        windowProvider.get(),
        selectedTabPropertyProvider.get(),
        updateCheckerProvider.get());
  }

  public static PreferencesController_Factory create(
      Provider<Environment> envProvider,
      Provider<Stage> windowProvider,
      Provider<ObjectProperty<SelectedPreferencesTab>> selectedTabPropertyProvider,
      Provider<UpdateChecker> updateCheckerProvider) {
    return new PreferencesController_Factory(
        envProvider, windowProvider, selectedTabPropertyProvider, updateCheckerProvider);
  }

  public static PreferencesController newInstance(
      Environment env,
      Stage window,
      ObjectProperty<SelectedPreferencesTab> selectedTabProperty,
      UpdateChecker updateChecker) {
    return new PreferencesController(env, window, selectedTabProperty, updateChecker);
  }
}
