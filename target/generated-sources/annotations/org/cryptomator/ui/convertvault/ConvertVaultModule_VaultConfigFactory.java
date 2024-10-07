package org.cryptomator.ui.convertvault;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.cryptomator.common.vaults.Vault;
import org.cryptomator.cryptofs.VaultConfig;

@ScopeMetadata("org.cryptomator.ui.convertvault.ConvertVaultScoped")
@QualifierMetadata("org.cryptomator.ui.convertvault.ConvertVaultWindow")
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class ConvertVaultModule_VaultConfigFactory
    implements Factory<VaultConfig.UnverifiedVaultConfig> {
  private final Provider<Vault> vaultProvider;

  public ConvertVaultModule_VaultConfigFactory(Provider<Vault> vaultProvider) {
    this.vaultProvider = vaultProvider;
  }

  @Override
  public VaultConfig.UnverifiedVaultConfig get() {
    return vaultConfig(vaultProvider.get());
  }

  public static ConvertVaultModule_VaultConfigFactory create(Provider<Vault> vaultProvider) {
    return new ConvertVaultModule_VaultConfigFactory(vaultProvider);
  }

  public static VaultConfig.UnverifiedVaultConfig vaultConfig(Vault vault) {
    return Preconditions.checkNotNullFromProvides(ConvertVaultModule.vaultConfig(vault));
  }
}
