package org.cryptomator.ui.mainwindow;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.util.ResourceBundle;
import javafx.beans.property.ObjectProperty;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.cryptomator.common.vaults.Vault;
import org.cryptomator.common.vaults.VaultListManager;
import org.cryptomator.ui.addvaultwizard.AddVaultWizardComponent;
import org.cryptomator.ui.common.VaultService;
import org.cryptomator.ui.fxapp.FxApplicationWindows;
import org.cryptomator.ui.removevault.RemoveVaultComponent;

@ScopeMetadata("org.cryptomator.ui.mainwindow.MainWindowScoped")
@QualifierMetadata("org.cryptomator.ui.mainwindow.MainWindow")
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class VaultListController_Factory implements Factory<VaultListController> {
  private final Provider<Stage> mainWindowProvider;

  private final Provider<ObservableList<Vault>> vaultsProvider;

  private final Provider<ObjectProperty<Vault>> selectedVaultProvider;

  private final Provider<VaultListCellFactory> cellFactoryProvider;

  private final Provider<VaultService> vaultServiceProvider;

  private final Provider<AddVaultWizardComponent.Builder> addVaultWizardProvider;

  private final Provider<RemoveVaultComponent.Builder> removeVaultDialogueProvider;

  private final Provider<VaultListManager> vaultListManagerProvider;

  private final Provider<ResourceBundle> resourceBundleProvider;

  private final Provider<FxApplicationWindows> appWindowsProvider;

  public VaultListController_Factory(
      Provider<Stage> mainWindowProvider,
      Provider<ObservableList<Vault>> vaultsProvider,
      Provider<ObjectProperty<Vault>> selectedVaultProvider,
      Provider<VaultListCellFactory> cellFactoryProvider,
      Provider<VaultService> vaultServiceProvider,
      Provider<AddVaultWizardComponent.Builder> addVaultWizardProvider,
      Provider<RemoveVaultComponent.Builder> removeVaultDialogueProvider,
      Provider<VaultListManager> vaultListManagerProvider,
      Provider<ResourceBundle> resourceBundleProvider,
      Provider<FxApplicationWindows> appWindowsProvider) {
    this.mainWindowProvider = mainWindowProvider;
    this.vaultsProvider = vaultsProvider;
    this.selectedVaultProvider = selectedVaultProvider;
    this.cellFactoryProvider = cellFactoryProvider;
    this.vaultServiceProvider = vaultServiceProvider;
    this.addVaultWizardProvider = addVaultWizardProvider;
    this.removeVaultDialogueProvider = removeVaultDialogueProvider;
    this.vaultListManagerProvider = vaultListManagerProvider;
    this.resourceBundleProvider = resourceBundleProvider;
    this.appWindowsProvider = appWindowsProvider;
  }

  @Override
  public VaultListController get() {
    return newInstance(
        mainWindowProvider.get(),
        vaultsProvider.get(),
        selectedVaultProvider.get(),
        cellFactoryProvider.get(),
        vaultServiceProvider.get(),
        addVaultWizardProvider.get(),
        removeVaultDialogueProvider.get(),
        vaultListManagerProvider.get(),
        resourceBundleProvider.get(),
        appWindowsProvider.get());
  }

  public static VaultListController_Factory create(
      Provider<Stage> mainWindowProvider,
      Provider<ObservableList<Vault>> vaultsProvider,
      Provider<ObjectProperty<Vault>> selectedVaultProvider,
      Provider<VaultListCellFactory> cellFactoryProvider,
      Provider<VaultService> vaultServiceProvider,
      Provider<AddVaultWizardComponent.Builder> addVaultWizardProvider,
      Provider<RemoveVaultComponent.Builder> removeVaultDialogueProvider,
      Provider<VaultListManager> vaultListManagerProvider,
      Provider<ResourceBundle> resourceBundleProvider,
      Provider<FxApplicationWindows> appWindowsProvider) {
    return new VaultListController_Factory(
        mainWindowProvider,
        vaultsProvider,
        selectedVaultProvider,
        cellFactoryProvider,
        vaultServiceProvider,
        addVaultWizardProvider,
        removeVaultDialogueProvider,
        vaultListManagerProvider,
        resourceBundleProvider,
        appWindowsProvider);
  }

  public static VaultListController newInstance(
      Stage mainWindow,
      ObservableList<Vault> vaults,
      ObjectProperty<Vault> selectedVault,
      VaultListCellFactory cellFactory,
      VaultService vaultService,
      AddVaultWizardComponent.Builder addVaultWizard,
      RemoveVaultComponent.Builder removeVaultDialogue,
      VaultListManager vaultListManager,
      ResourceBundle resourceBundle,
      FxApplicationWindows appWindows) {
    return new VaultListController(
        mainWindow,
        vaults,
        selectedVault,
        cellFactory,
        vaultService,
        addVaultWizard,
        removeVaultDialogue,
        vaultListManager,
        resourceBundle,
        appWindows);
  }
}
