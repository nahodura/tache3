package org.cryptomator.ui.migration;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javafx.stage.Stage;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.cryptomator.common.vaults.Vault;
import org.cryptomator.ui.fxapp.FxApplicationWindows;

@ScopeMetadata("org.cryptomator.ui.migration.MigrationScoped")
@QualifierMetadata({
  "org.cryptomator.ui.migration.MigrationWindow",
  "org.cryptomator.ui.fxapp.PrimaryStage"
})
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class MigrationSuccessController_Factory
    implements Factory<MigrationSuccessController> {
  private final Provider<FxApplicationWindows> appWindowsProvider;

  private final Provider<Stage> windowProvider;

  private final Provider<Vault> vaultProvider;

  private final Provider<Stage> mainWindowProvider;

  public MigrationSuccessController_Factory(
      Provider<FxApplicationWindows> appWindowsProvider,
      Provider<Stage> windowProvider,
      Provider<Vault> vaultProvider,
      Provider<Stage> mainWindowProvider) {
    this.appWindowsProvider = appWindowsProvider;
    this.windowProvider = windowProvider;
    this.vaultProvider = vaultProvider;
    this.mainWindowProvider = mainWindowProvider;
  }

  @Override
  public MigrationSuccessController get() {
    return newInstance(
        appWindowsProvider.get(),
        windowProvider.get(),
        vaultProvider.get(),
        mainWindowProvider.get());
  }

  public static MigrationSuccessController_Factory create(
      Provider<FxApplicationWindows> appWindowsProvider,
      Provider<Stage> windowProvider,
      Provider<Vault> vaultProvider,
      Provider<Stage> mainWindowProvider) {
    return new MigrationSuccessController_Factory(
        appWindowsProvider, windowProvider, vaultProvider, mainWindowProvider);
  }

  public static MigrationSuccessController newInstance(
      FxApplicationWindows appWindows, Stage window, Vault vault, Stage mainWindow) {
    return new MigrationSuccessController(appWindows, window, vault, mainWindow);
  }
}
