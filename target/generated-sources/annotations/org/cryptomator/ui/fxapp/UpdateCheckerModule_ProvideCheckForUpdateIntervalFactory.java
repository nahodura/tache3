package org.cryptomator.ui.fxapp;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javafx.beans.binding.ObjectBinding;
import javafx.util.Duration;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.cryptomator.common.settings.Settings;

@ScopeMetadata("org.cryptomator.ui.fxapp.FxApplicationScoped")
@QualifierMetadata("javax.inject.Named")
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class UpdateCheckerModule_ProvideCheckForUpdateIntervalFactory
    implements Factory<ObjectBinding<Duration>> {
  private final Provider<Settings> settingsProvider;

  public UpdateCheckerModule_ProvideCheckForUpdateIntervalFactory(
      Provider<Settings> settingsProvider) {
    this.settingsProvider = settingsProvider;
  }

  @Override
  public ObjectBinding<Duration> get() {
    return provideCheckForUpdateInterval(settingsProvider.get());
  }

  public static UpdateCheckerModule_ProvideCheckForUpdateIntervalFactory create(
      Provider<Settings> settingsProvider) {
    return new UpdateCheckerModule_ProvideCheckForUpdateIntervalFactory(settingsProvider);
  }

  public static ObjectBinding<Duration> provideCheckForUpdateInterval(Settings settings) {
    return Preconditions.checkNotNullFromProvides(
        UpdateCheckerModule.provideCheckForUpdateInterval(settings));
  }
}
