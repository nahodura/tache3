package org.cryptomator.ui.preferences;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.util.List;
import java.util.Optional;
import javafx.application.Application;
import javafx.stage.Stage;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.cryptomator.common.Environment;
import org.cryptomator.common.settings.Settings;
import org.cryptomator.integrations.autostart.AutoStartProvider;
import org.cryptomator.integrations.keychain.KeychainAccessProvider;
import org.cryptomator.ui.fxapp.FxApplicationWindows;

@ScopeMetadata("org.cryptomator.ui.preferences.PreferencesScoped")
@QualifierMetadata("org.cryptomator.ui.preferences.PreferencesWindow")
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class GeneralPreferencesController_Factory
    implements Factory<GeneralPreferencesController> {
  private final Provider<Stage> windowProvider;

  private final Provider<Settings> settingsProvider;

  private final Provider<Optional<AutoStartProvider>> autoStartProvider;

  private final Provider<List<KeychainAccessProvider>> keychainAccessProvidersProvider;

  private final Provider<Application> applicationProvider;

  private final Provider<Environment> environmentProvider;

  private final Provider<FxApplicationWindows> appWindowsProvider;

  public GeneralPreferencesController_Factory(
      Provider<Stage> windowProvider,
      Provider<Settings> settingsProvider,
      Provider<Optional<AutoStartProvider>> autoStartProvider,
      Provider<List<KeychainAccessProvider>> keychainAccessProvidersProvider,
      Provider<Application> applicationProvider,
      Provider<Environment> environmentProvider,
      Provider<FxApplicationWindows> appWindowsProvider) {
    this.windowProvider = windowProvider;
    this.settingsProvider = settingsProvider;
    this.autoStartProvider = autoStartProvider;
    this.keychainAccessProvidersProvider = keychainAccessProvidersProvider;
    this.applicationProvider = applicationProvider;
    this.environmentProvider = environmentProvider;
    this.appWindowsProvider = appWindowsProvider;
  }

  @Override
  public GeneralPreferencesController get() {
    return newInstance(
        windowProvider.get(),
        settingsProvider.get(),
        autoStartProvider.get(),
        keychainAccessProvidersProvider.get(),
        applicationProvider.get(),
        environmentProvider.get(),
        appWindowsProvider.get());
  }

  public static GeneralPreferencesController_Factory create(
      Provider<Stage> windowProvider,
      Provider<Settings> settingsProvider,
      Provider<Optional<AutoStartProvider>> autoStartProvider,
      Provider<List<KeychainAccessProvider>> keychainAccessProvidersProvider,
      Provider<Application> applicationProvider,
      Provider<Environment> environmentProvider,
      Provider<FxApplicationWindows> appWindowsProvider) {
    return new GeneralPreferencesController_Factory(
        windowProvider,
        settingsProvider,
        autoStartProvider,
        keychainAccessProvidersProvider,
        applicationProvider,
        environmentProvider,
        appWindowsProvider);
  }

  public static GeneralPreferencesController newInstance(
      Stage window,
      Settings settings,
      Optional<AutoStartProvider> autoStartProvider,
      List<KeychainAccessProvider> keychainAccessProviders,
      Application application,
      Environment environment,
      FxApplicationWindows appWindows) {
    return new GeneralPreferencesController(
        window,
        settings,
        autoStartProvider,
        keychainAccessProviders,
        application,
        environment,
        appWindows);
  }
}
