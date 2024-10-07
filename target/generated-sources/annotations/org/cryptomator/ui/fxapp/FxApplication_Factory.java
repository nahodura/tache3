package org.cryptomator.ui.fxapp;

import dagger.Lazy;
import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.cryptomator.common.Environment;
import org.cryptomator.common.settings.Settings;
import org.cryptomator.ui.traymenu.TrayMenuComponent;

@ScopeMetadata("org.cryptomator.ui.fxapp.FxApplicationScoped")
@QualifierMetadata("javax.inject.Named")
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class FxApplication_Factory implements Factory<FxApplication> {
  private final Provider<Long> startupTimeProvider;

  private final Provider<Environment> environmentProvider;

  private final Provider<Settings> settingsProvider;

  private final Provider<AppLaunchEventHandler> launchEventHandlerProvider;

  private final Provider<TrayMenuComponent> trayMenuProvider;

  private final Provider<FxApplicationWindows> appWindowsProvider;

  private final Provider<FxApplicationStyle> applicationStyleProvider;

  private final Provider<FxApplicationTerminator> applicationTerminatorProvider;

  private final Provider<AutoUnlocker> autoUnlockerProvider;

  public FxApplication_Factory(
      Provider<Long> startupTimeProvider,
      Provider<Environment> environmentProvider,
      Provider<Settings> settingsProvider,
      Provider<AppLaunchEventHandler> launchEventHandlerProvider,
      Provider<TrayMenuComponent> trayMenuProvider,
      Provider<FxApplicationWindows> appWindowsProvider,
      Provider<FxApplicationStyle> applicationStyleProvider,
      Provider<FxApplicationTerminator> applicationTerminatorProvider,
      Provider<AutoUnlocker> autoUnlockerProvider) {
    this.startupTimeProvider = startupTimeProvider;
    this.environmentProvider = environmentProvider;
    this.settingsProvider = settingsProvider;
    this.launchEventHandlerProvider = launchEventHandlerProvider;
    this.trayMenuProvider = trayMenuProvider;
    this.appWindowsProvider = appWindowsProvider;
    this.applicationStyleProvider = applicationStyleProvider;
    this.applicationTerminatorProvider = applicationTerminatorProvider;
    this.autoUnlockerProvider = autoUnlockerProvider;
  }

  @Override
  public FxApplication get() {
    return newInstance(
        startupTimeProvider.get(),
        environmentProvider.get(),
        settingsProvider.get(),
        launchEventHandlerProvider.get(),
        DoubleCheck.lazy(trayMenuProvider),
        appWindowsProvider.get(),
        applicationStyleProvider.get(),
        applicationTerminatorProvider.get(),
        autoUnlockerProvider.get());
  }

  public static FxApplication_Factory create(
      Provider<Long> startupTimeProvider,
      Provider<Environment> environmentProvider,
      Provider<Settings> settingsProvider,
      Provider<AppLaunchEventHandler> launchEventHandlerProvider,
      Provider<TrayMenuComponent> trayMenuProvider,
      Provider<FxApplicationWindows> appWindowsProvider,
      Provider<FxApplicationStyle> applicationStyleProvider,
      Provider<FxApplicationTerminator> applicationTerminatorProvider,
      Provider<AutoUnlocker> autoUnlockerProvider) {
    return new FxApplication_Factory(
        startupTimeProvider,
        environmentProvider,
        settingsProvider,
        launchEventHandlerProvider,
        trayMenuProvider,
        appWindowsProvider,
        applicationStyleProvider,
        applicationTerminatorProvider,
        autoUnlockerProvider);
  }

  public static FxApplication newInstance(
      long startupTime,
      Environment environment,
      Settings settings,
      Object launchEventHandler,
      Lazy<TrayMenuComponent> trayMenu,
      FxApplicationWindows appWindows,
      FxApplicationStyle applicationStyle,
      FxApplicationTerminator applicationTerminator,
      AutoUnlocker autoUnlocker) {
    return new FxApplication(
        startupTime,
        environment,
        settings,
        (AppLaunchEventHandler) launchEventHandler,
        trayMenu,
        appWindows,
        applicationStyle,
        applicationTerminator,
        autoUnlocker);
  }
}
