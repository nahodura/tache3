package org.cryptomator.ui.vaultoptions;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javafx.stage.Stage;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.cryptomator.common.vaults.Vault;
import org.cryptomator.ui.convertvault.ConvertVaultComponent;

@ScopeMetadata
@QualifierMetadata("org.cryptomator.ui.vaultoptions.VaultOptionsWindow")
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class HubOptionsController_Factory implements Factory<HubOptionsController> {
  private final Provider<Vault> vaultProvider;

  private final Provider<Stage> windowProvider;

  private final Provider<ConvertVaultComponent.Factory> convertVaultFactoryProvider;

  public HubOptionsController_Factory(
      Provider<Vault> vaultProvider,
      Provider<Stage> windowProvider,
      Provider<ConvertVaultComponent.Factory> convertVaultFactoryProvider) {
    this.vaultProvider = vaultProvider;
    this.windowProvider = windowProvider;
    this.convertVaultFactoryProvider = convertVaultFactoryProvider;
  }

  @Override
  public HubOptionsController get() {
    return newInstance(
        vaultProvider.get(), windowProvider.get(), convertVaultFactoryProvider.get());
  }

  public static HubOptionsController_Factory create(
      Provider<Vault> vaultProvider,
      Provider<Stage> windowProvider,
      Provider<ConvertVaultComponent.Factory> convertVaultFactoryProvider) {
    return new HubOptionsController_Factory(
        vaultProvider, windowProvider, convertVaultFactoryProvider);
  }

  public static HubOptionsController newInstance(
      Vault vault, Stage window, ConvertVaultComponent.Factory convertVaultFactory) {
    return new HubOptionsController(vault, window, convertVaultFactory);
  }
}
