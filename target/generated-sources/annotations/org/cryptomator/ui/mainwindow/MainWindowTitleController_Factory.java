package org.cryptomator.ui.mainwindow;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javafx.stage.Stage;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.cryptomator.common.LicenseHolder;
import org.cryptomator.common.settings.Settings;
import org.cryptomator.ui.fxapp.FxApplicationTerminator;
import org.cryptomator.ui.fxapp.FxApplicationWindows;
import org.cryptomator.ui.fxapp.UpdateChecker;
import org.cryptomator.ui.traymenu.TrayMenuComponent;

@ScopeMetadata("org.cryptomator.ui.mainwindow.MainWindowScoped")
@QualifierMetadata("org.cryptomator.ui.mainwindow.MainWindow")
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class MainWindowTitleController_Factory implements Factory<MainWindowTitleController> {
  private final Provider<Stage> windowProvider;

  private final Provider<FxApplicationTerminator> terminatorProvider;

  private final Provider<FxApplicationWindows> appWindowsProvider;

  private final Provider<TrayMenuComponent> trayMenuProvider;

  private final Provider<UpdateChecker> updateCheckerProvider;

  private final Provider<LicenseHolder> licenseHolderProvider;

  private final Provider<Settings> settingsProvider;

  public MainWindowTitleController_Factory(
      Provider<Stage> windowProvider,
      Provider<FxApplicationTerminator> terminatorProvider,
      Provider<FxApplicationWindows> appWindowsProvider,
      Provider<TrayMenuComponent> trayMenuProvider,
      Provider<UpdateChecker> updateCheckerProvider,
      Provider<LicenseHolder> licenseHolderProvider,
      Provider<Settings> settingsProvider) {
    this.windowProvider = windowProvider;
    this.terminatorProvider = terminatorProvider;
    this.appWindowsProvider = appWindowsProvider;
    this.trayMenuProvider = trayMenuProvider;
    this.updateCheckerProvider = updateCheckerProvider;
    this.licenseHolderProvider = licenseHolderProvider;
    this.settingsProvider = settingsProvider;
  }

  @Override
  public MainWindowTitleController get() {
    return newInstance(
        windowProvider.get(),
        terminatorProvider.get(),
        appWindowsProvider.get(),
        trayMenuProvider.get(),
        updateCheckerProvider.get(),
        licenseHolderProvider.get(),
        settingsProvider.get());
  }

  public static MainWindowTitleController_Factory create(
      Provider<Stage> windowProvider,
      Provider<FxApplicationTerminator> terminatorProvider,
      Provider<FxApplicationWindows> appWindowsProvider,
      Provider<TrayMenuComponent> trayMenuProvider,
      Provider<UpdateChecker> updateCheckerProvider,
      Provider<LicenseHolder> licenseHolderProvider,
      Provider<Settings> settingsProvider) {
    return new MainWindowTitleController_Factory(
        windowProvider,
        terminatorProvider,
        appWindowsProvider,
        trayMenuProvider,
        updateCheckerProvider,
        licenseHolderProvider,
        settingsProvider);
  }

  public static MainWindowTitleController newInstance(
      Stage window,
      FxApplicationTerminator terminator,
      FxApplicationWindows appWindows,
      TrayMenuComponent trayMenu,
      UpdateChecker updateChecker,
      LicenseHolder licenseHolder,
      Settings settings) {
    return new MainWindowTitleController(
        window, terminator, appWindows, trayMenu, updateChecker, licenseHolder, settings);
  }
}
