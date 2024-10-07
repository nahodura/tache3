package org.cryptomator.ui.mainwindow;

import dagger.Lazy;
import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.cryptomator.common.settings.Settings;

@ScopeMetadata("org.cryptomator.ui.mainwindow.MainWindowScoped")
@QualifierMetadata
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class MainWindowSceneFactory_Factory implements Factory<MainWindowSceneFactory> {
  private final Provider<Settings> settingsProvider;

  private final Provider<MainWindowTitleController> mainWindowTitleControllerProvider;

  private final Provider<VaultListController> vaultListControllerProvider;

  public MainWindowSceneFactory_Factory(
      Provider<Settings> settingsProvider,
      Provider<MainWindowTitleController> mainWindowTitleControllerProvider,
      Provider<VaultListController> vaultListControllerProvider) {
    this.settingsProvider = settingsProvider;
    this.mainWindowTitleControllerProvider = mainWindowTitleControllerProvider;
    this.vaultListControllerProvider = vaultListControllerProvider;
  }

  @Override
  public MainWindowSceneFactory get() {
    return newInstance(
        settingsProvider.get(),
        DoubleCheck.lazy(mainWindowTitleControllerProvider),
        DoubleCheck.lazy(vaultListControllerProvider));
  }

  public static MainWindowSceneFactory_Factory create(
      Provider<Settings> settingsProvider,
      Provider<MainWindowTitleController> mainWindowTitleControllerProvider,
      Provider<VaultListController> vaultListControllerProvider) {
    return new MainWindowSceneFactory_Factory(
        settingsProvider, mainWindowTitleControllerProvider, vaultListControllerProvider);
  }

  public static MainWindowSceneFactory newInstance(
      Settings settings,
      Lazy<MainWindowTitleController> mainWindowTitleController,
      Lazy<VaultListController> vaultListController) {
    return new MainWindowSceneFactory(settings, mainWindowTitleController, vaultListController);
  }
}
