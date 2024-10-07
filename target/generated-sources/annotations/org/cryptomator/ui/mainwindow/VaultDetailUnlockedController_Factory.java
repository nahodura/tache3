package org.cryptomator.ui.mainwindow;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.beans.property.ObjectProperty;
import javafx.stage.Stage;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.cryptomator.common.vaults.Vault;
import org.cryptomator.integrations.revealpath.RevealPathService;
import org.cryptomator.ui.common.VaultService;
import org.cryptomator.ui.fxapp.FxApplicationWindows;
import org.cryptomator.ui.stats.VaultStatisticsComponent;
import org.cryptomator.ui.wrongfilealert.WrongFileAlertComponent;

@ScopeMetadata("org.cryptomator.ui.mainwindow.MainWindowScoped")
@QualifierMetadata("org.cryptomator.ui.mainwindow.MainWindow")
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class VaultDetailUnlockedController_Factory
    implements Factory<VaultDetailUnlockedController> {
  private final Provider<ObjectProperty<Vault>> vaultProvider;

  private final Provider<FxApplicationWindows> appWindowsProvider;

  private final Provider<VaultService> vaultServiceProvider;

  private final Provider<VaultStatisticsComponent.Builder> vaultStatsBuilderProvider;

  private final Provider<WrongFileAlertComponent.Builder> wrongFileAlertProvider;

  private final Provider<Stage> mainWindowProvider;

  private final Provider<Optional<RevealPathService>> revealPathServiceProvider;

  private final Provider<ResourceBundle> resourceBundleProvider;

  public VaultDetailUnlockedController_Factory(
      Provider<ObjectProperty<Vault>> vaultProvider,
      Provider<FxApplicationWindows> appWindowsProvider,
      Provider<VaultService> vaultServiceProvider,
      Provider<VaultStatisticsComponent.Builder> vaultStatsBuilderProvider,
      Provider<WrongFileAlertComponent.Builder> wrongFileAlertProvider,
      Provider<Stage> mainWindowProvider,
      Provider<Optional<RevealPathService>> revealPathServiceProvider,
      Provider<ResourceBundle> resourceBundleProvider) {
    this.vaultProvider = vaultProvider;
    this.appWindowsProvider = appWindowsProvider;
    this.vaultServiceProvider = vaultServiceProvider;
    this.vaultStatsBuilderProvider = vaultStatsBuilderProvider;
    this.wrongFileAlertProvider = wrongFileAlertProvider;
    this.mainWindowProvider = mainWindowProvider;
    this.revealPathServiceProvider = revealPathServiceProvider;
    this.resourceBundleProvider = resourceBundleProvider;
  }

  @Override
  public VaultDetailUnlockedController get() {
    return newInstance(
        vaultProvider.get(),
        appWindowsProvider.get(),
        vaultServiceProvider.get(),
        vaultStatsBuilderProvider.get(),
        wrongFileAlertProvider.get(),
        mainWindowProvider.get(),
        revealPathServiceProvider.get(),
        resourceBundleProvider.get());
  }

  public static VaultDetailUnlockedController_Factory create(
      Provider<ObjectProperty<Vault>> vaultProvider,
      Provider<FxApplicationWindows> appWindowsProvider,
      Provider<VaultService> vaultServiceProvider,
      Provider<VaultStatisticsComponent.Builder> vaultStatsBuilderProvider,
      Provider<WrongFileAlertComponent.Builder> wrongFileAlertProvider,
      Provider<Stage> mainWindowProvider,
      Provider<Optional<RevealPathService>> revealPathServiceProvider,
      Provider<ResourceBundle> resourceBundleProvider) {
    return new VaultDetailUnlockedController_Factory(
        vaultProvider,
        appWindowsProvider,
        vaultServiceProvider,
        vaultStatsBuilderProvider,
        wrongFileAlertProvider,
        mainWindowProvider,
        revealPathServiceProvider,
        resourceBundleProvider);
  }

  public static VaultDetailUnlockedController newInstance(
      ObjectProperty<Vault> vault,
      FxApplicationWindows appWindows,
      VaultService vaultService,
      VaultStatisticsComponent.Builder vaultStatsBuilder,
      WrongFileAlertComponent.Builder wrongFileAlert,
      Stage mainWindow,
      Optional<RevealPathService> revealPathService,
      ResourceBundle resourceBundle) {
    return new VaultDetailUnlockedController(
        vault,
        appWindows,
        vaultService,
        vaultStatsBuilder,
        wrongFileAlert,
        mainWindow,
        revealPathService,
        resourceBundle);
  }
}
