package org.cryptomator.ui.unlock;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.util.ResourceBundle;
import javafx.stage.Stage;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.cryptomator.common.vaults.Vault;
import org.cryptomator.ui.fxapp.FxApplicationWindows;

@ScopeMetadata("org.cryptomator.ui.unlock.UnlockScoped")
@QualifierMetadata("org.cryptomator.ui.unlock.UnlockWindow")
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class UnlockRequiresRestartController_Factory
    implements Factory<UnlockRequiresRestartController> {
  private final Provider<Stage> windowProvider;

  private final Provider<ResourceBundle> resourceBundleProvider;

  private final Provider<FxApplicationWindows> appWindowsProvider;

  private final Provider<Vault> vaultProvider;

  public UnlockRequiresRestartController_Factory(
      Provider<Stage> windowProvider,
      Provider<ResourceBundle> resourceBundleProvider,
      Provider<FxApplicationWindows> appWindowsProvider,
      Provider<Vault> vaultProvider) {
    this.windowProvider = windowProvider;
    this.resourceBundleProvider = resourceBundleProvider;
    this.appWindowsProvider = appWindowsProvider;
    this.vaultProvider = vaultProvider;
  }

  @Override
  public UnlockRequiresRestartController get() {
    return newInstance(
        windowProvider.get(),
        resourceBundleProvider.get(),
        appWindowsProvider.get(),
        vaultProvider.get());
  }

  public static UnlockRequiresRestartController_Factory create(
      Provider<Stage> windowProvider,
      Provider<ResourceBundle> resourceBundleProvider,
      Provider<FxApplicationWindows> appWindowsProvider,
      Provider<Vault> vaultProvider) {
    return new UnlockRequiresRestartController_Factory(
        windowProvider, resourceBundleProvider, appWindowsProvider, vaultProvider);
  }

  public static UnlockRequiresRestartController newInstance(
      Stage window, ResourceBundle resourceBundle, FxApplicationWindows appWindows, Vault vault) {
    return new UnlockRequiresRestartController(window, resourceBundle, appWindows, vault);
  }
}
