package org.cryptomator.ui.convertvault;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javafx.stage.Stage;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.cryptomator.common.vaults.Vault;

@ScopeMetadata
@QualifierMetadata("org.cryptomator.ui.convertvault.ConvertVaultWindow")
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class HubToPasswordSuccessController_Factory
    implements Factory<HubToPasswordSuccessController> {
  private final Provider<Stage> windowProvider;

  private final Provider<Vault> vaultProvider;

  public HubToPasswordSuccessController_Factory(
      Provider<Stage> windowProvider, Provider<Vault> vaultProvider) {
    this.windowProvider = windowProvider;
    this.vaultProvider = vaultProvider;
  }

  @Override
  public HubToPasswordSuccessController get() {
    return newInstance(windowProvider.get(), vaultProvider.get());
  }

  public static HubToPasswordSuccessController_Factory create(
      Provider<Stage> windowProvider, Provider<Vault> vaultProvider) {
    return new HubToPasswordSuccessController_Factory(windowProvider, vaultProvider);
  }

  public static HubToPasswordSuccessController newInstance(Stage window, Vault vault) {
    return new HubToPasswordSuccessController(window, vault);
  }
}
