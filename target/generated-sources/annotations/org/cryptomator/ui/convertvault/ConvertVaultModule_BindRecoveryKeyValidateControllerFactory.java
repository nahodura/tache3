package org.cryptomator.ui.convertvault;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javafx.beans.property.StringProperty;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.cryptomator.common.vaults.Vault;
import org.cryptomator.cryptofs.VaultConfig;
import org.cryptomator.ui.common.FxController;
import org.cryptomator.ui.recoverykey.RecoveryKeyFactory;

@ScopeMetadata
@QualifierMetadata("org.cryptomator.ui.convertvault.ConvertVaultWindow")
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class ConvertVaultModule_BindRecoveryKeyValidateControllerFactory
    implements Factory<FxController> {
  private final Provider<Vault> vaultProvider;

  private final Provider<VaultConfig.UnverifiedVaultConfig> vaultConfigProvider;

  private final Provider<StringProperty> recoveryKeyProvider;

  private final Provider<RecoveryKeyFactory> recoveryKeyFactoryProvider;

  public ConvertVaultModule_BindRecoveryKeyValidateControllerFactory(
      Provider<Vault> vaultProvider,
      Provider<VaultConfig.UnverifiedVaultConfig> vaultConfigProvider,
      Provider<StringProperty> recoveryKeyProvider,
      Provider<RecoveryKeyFactory> recoveryKeyFactoryProvider) {
    this.vaultProvider = vaultProvider;
    this.vaultConfigProvider = vaultConfigProvider;
    this.recoveryKeyProvider = recoveryKeyProvider;
    this.recoveryKeyFactoryProvider = recoveryKeyFactoryProvider;
  }

  @Override
  public FxController get() {
    return bindRecoveryKeyValidateController(
        vaultProvider.get(),
        vaultConfigProvider.get(),
        recoveryKeyProvider.get(),
        recoveryKeyFactoryProvider.get());
  }

  public static ConvertVaultModule_BindRecoveryKeyValidateControllerFactory create(
      Provider<Vault> vaultProvider,
      Provider<VaultConfig.UnverifiedVaultConfig> vaultConfigProvider,
      Provider<StringProperty> recoveryKeyProvider,
      Provider<RecoveryKeyFactory> recoveryKeyFactoryProvider) {
    return new ConvertVaultModule_BindRecoveryKeyValidateControllerFactory(
        vaultProvider, vaultConfigProvider, recoveryKeyProvider, recoveryKeyFactoryProvider);
  }

  public static FxController bindRecoveryKeyValidateController(
      Vault vault,
      VaultConfig.UnverifiedVaultConfig vaultConfig,
      StringProperty recoveryKey,
      RecoveryKeyFactory recoveryKeyFactory) {
    return Preconditions.checkNotNullFromProvides(
        ConvertVaultModule.bindRecoveryKeyValidateController(
            vault, vaultConfig, recoveryKey, recoveryKeyFactory));
  }
}
