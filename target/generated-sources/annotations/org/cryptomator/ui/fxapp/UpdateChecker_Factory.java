package org.cryptomator.ui.fxapp;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javafx.concurrent.ScheduledService;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.cryptomator.common.Environment;
import org.cryptomator.common.settings.Settings;

@ScopeMetadata("org.cryptomator.ui.fxapp.FxApplicationScoped")
@QualifierMetadata
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class UpdateChecker_Factory implements Factory<UpdateChecker> {
  private final Provider<Settings> settingsProvider;

  private final Provider<Environment> envProvider;

  private final Provider<ScheduledService<String>> updateCheckerServiceProvider;

  public UpdateChecker_Factory(
      Provider<Settings> settingsProvider,
      Provider<Environment> envProvider,
      Provider<ScheduledService<String>> updateCheckerServiceProvider) {
    this.settingsProvider = settingsProvider;
    this.envProvider = envProvider;
    this.updateCheckerServiceProvider = updateCheckerServiceProvider;
  }

  @Override
  public UpdateChecker get() {
    return newInstance(
        settingsProvider.get(), envProvider.get(), updateCheckerServiceProvider.get());
  }

  public static UpdateChecker_Factory create(
      Provider<Settings> settingsProvider,
      Provider<Environment> envProvider,
      Provider<ScheduledService<String>> updateCheckerServiceProvider) {
    return new UpdateChecker_Factory(settingsProvider, envProvider, updateCheckerServiceProvider);
  }

  public static UpdateChecker newInstance(
      Settings settings, Environment env, ScheduledService<String> updateCheckerService) {
    return new UpdateChecker(settings, env, updateCheckerService);
  }
}
