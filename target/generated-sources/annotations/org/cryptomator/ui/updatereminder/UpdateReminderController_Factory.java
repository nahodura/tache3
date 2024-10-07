package org.cryptomator.ui.updatereminder;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javafx.stage.Stage;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.cryptomator.common.settings.Settings;
import org.cryptomator.ui.fxapp.UpdateChecker;

@ScopeMetadata("org.cryptomator.ui.updatereminder.UpdateReminderScoped")
@QualifierMetadata("org.cryptomator.ui.updatereminder.UpdateReminderWindow")
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class UpdateReminderController_Factory implements Factory<UpdateReminderController> {
  private final Provider<Stage> windowProvider;

  private final Provider<Settings> settingsProvider;

  private final Provider<UpdateChecker> updateCheckerProvider;

  public UpdateReminderController_Factory(
      Provider<Stage> windowProvider,
      Provider<Settings> settingsProvider,
      Provider<UpdateChecker> updateCheckerProvider) {
    this.windowProvider = windowProvider;
    this.settingsProvider = settingsProvider;
    this.updateCheckerProvider = updateCheckerProvider;
  }

  @Override
  public UpdateReminderController get() {
    return newInstance(windowProvider.get(), settingsProvider.get(), updateCheckerProvider.get());
  }

  public static UpdateReminderController_Factory create(
      Provider<Stage> windowProvider,
      Provider<Settings> settingsProvider,
      Provider<UpdateChecker> updateCheckerProvider) {
    return new UpdateReminderController_Factory(
        windowProvider, settingsProvider, updateCheckerProvider);
  }

  public static UpdateReminderController newInstance(
      Stage window, Settings settings, UpdateChecker updateChecker) {
    return new UpdateReminderController(window, settings, updateChecker);
  }
}
