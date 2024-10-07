package org.cryptomator.ui.keyloading.hub;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.util.ResourceBundle;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.cryptomator.common.vaults.Vault;

@ScopeMetadata("org.cryptomator.ui.keyloading.KeyLoadingScoped")
@QualifierMetadata({"javax.inject.Named", "org.cryptomator.ui.keyloading.KeyLoading"})
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class HubKeyLoadingModule_ProvideWindowTitleFactory implements Factory<String> {
  private final Provider<Vault> vaultProvider;

  private final Provider<ResourceBundle> resourceBundleProvider;

  public HubKeyLoadingModule_ProvideWindowTitleFactory(
      Provider<Vault> vaultProvider, Provider<ResourceBundle> resourceBundleProvider) {
    this.vaultProvider = vaultProvider;
    this.resourceBundleProvider = resourceBundleProvider;
  }

  @Override
  public String get() {
    return provideWindowTitle(vaultProvider.get(), resourceBundleProvider.get());
  }

  public static HubKeyLoadingModule_ProvideWindowTitleFactory create(
      Provider<Vault> vaultProvider, Provider<ResourceBundle> resourceBundleProvider) {
    return new HubKeyLoadingModule_ProvideWindowTitleFactory(vaultProvider, resourceBundleProvider);
  }

  public static String provideWindowTitle(Vault vault, ResourceBundle resourceBundle) {
    return Preconditions.checkNotNullFromProvides(
        HubKeyLoadingModule.provideWindowTitle(vault, resourceBundle));
  }
}
