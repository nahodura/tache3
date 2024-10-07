package org.cryptomator.ui.recoverykey;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.cryptomator.common.Nullable;
import org.cryptomator.common.vaults.Vault;
import org.cryptomator.cryptofs.VaultConfig;

@ScopeMetadata("org.cryptomator.ui.recoverykey.RecoveryKeyScoped")
@QualifierMetadata("org.cryptomator.ui.recoverykey.RecoveryKeyWindow")
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class RecoveryKeyModule_VaultConfigFactory
    implements Factory<VaultConfig.UnverifiedVaultConfig> {
  private final Provider<Vault> vaultProvider;

  public RecoveryKeyModule_VaultConfigFactory(Provider<Vault> vaultProvider) {
    this.vaultProvider = vaultProvider;
  }

  @Override
  @Nullable
  public VaultConfig.UnverifiedVaultConfig get() {
    return vaultConfig(vaultProvider.get());
  }

  public static RecoveryKeyModule_VaultConfigFactory create(Provider<Vault> vaultProvider) {
    return new RecoveryKeyModule_VaultConfigFactory(vaultProvider);
  }

  @Nullable
  public static VaultConfig.UnverifiedVaultConfig vaultConfig(Vault vault) {
    return RecoveryKeyModule.vaultConfig(vault);
  }
}
