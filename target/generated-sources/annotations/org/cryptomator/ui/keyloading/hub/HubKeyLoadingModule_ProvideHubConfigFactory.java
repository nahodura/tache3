package org.cryptomator.ui.keyloading.hub;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.cryptomator.common.vaults.Vault;

@ScopeMetadata("org.cryptomator.ui.keyloading.KeyLoadingScoped")
@QualifierMetadata("org.cryptomator.ui.keyloading.KeyLoading")
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class HubKeyLoadingModule_ProvideHubConfigFactory implements Factory<HubConfig> {
  private final Provider<Vault> vaultProvider;

  public HubKeyLoadingModule_ProvideHubConfigFactory(Provider<Vault> vaultProvider) {
    this.vaultProvider = vaultProvider;
  }

  @Override
  public HubConfig get() {
    return provideHubConfig(vaultProvider.get());
  }

  public static HubKeyLoadingModule_ProvideHubConfigFactory create(Provider<Vault> vaultProvider) {
    return new HubKeyLoadingModule_ProvideHubConfigFactory(vaultProvider);
  }

  public static HubConfig provideHubConfig(Vault vault) {
    return Preconditions.checkNotNullFromProvides(HubKeyLoadingModule.provideHubConfig(vault));
  }
}
