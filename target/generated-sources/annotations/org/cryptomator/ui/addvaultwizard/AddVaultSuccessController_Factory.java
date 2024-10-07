package org.cryptomator.ui.addvaultwizard;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javafx.beans.property.ObjectProperty;
import javafx.stage.Stage;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.cryptomator.common.vaults.Vault;
import org.cryptomator.ui.fxapp.FxApplicationWindows;

@ScopeMetadata("org.cryptomator.ui.addvaultwizard.AddVaultWizardScoped")
@QualifierMetadata("org.cryptomator.ui.addvaultwizard.AddVaultWizardWindow")
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class AddVaultSuccessController_Factory implements Factory<AddVaultSuccessController> {
  private final Provider<FxApplicationWindows> appWindowsProvider;

  private final Provider<Stage> windowProvider;

  private final Provider<ObjectProperty<Vault>> vaultProvider;

  public AddVaultSuccessController_Factory(
      Provider<FxApplicationWindows> appWindowsProvider,
      Provider<Stage> windowProvider,
      Provider<ObjectProperty<Vault>> vaultProvider) {
    this.appWindowsProvider = appWindowsProvider;
    this.windowProvider = windowProvider;
    this.vaultProvider = vaultProvider;
  }

  @Override
  public AddVaultSuccessController get() {
    return newInstance(appWindowsProvider.get(), windowProvider.get(), vaultProvider.get());
  }

  public static AddVaultSuccessController_Factory create(
      Provider<FxApplicationWindows> appWindowsProvider,
      Provider<Stage> windowProvider,
      Provider<ObjectProperty<Vault>> vaultProvider) {
    return new AddVaultSuccessController_Factory(appWindowsProvider, windowProvider, vaultProvider);
  }

  public static AddVaultSuccessController newInstance(
      FxApplicationWindows appWindows, Stage window, ObjectProperty<Vault> vault) {
    return new AddVaultSuccessController(appWindows, window, vault);
  }
}
