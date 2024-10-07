package org.cryptomator.ui.keyloading.masterkeyfile;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.util.Optional;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.cryptomator.common.keychain.KeychainManager;
import org.cryptomator.common.vaults.Vault;

@ScopeMetadata("org.cryptomator.ui.keyloading.KeyLoadingScoped")
@QualifierMetadata({"javax.inject.Named", "org.cryptomator.ui.keyloading.KeyLoading"})
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class MasterkeyFileLoadingModule_ProvideStoredPasswordFactory
    implements Factory<Optional<char[]>> {
  private final Provider<KeychainManager> keychainProvider;

  private final Provider<Vault> vaultProvider;

  public MasterkeyFileLoadingModule_ProvideStoredPasswordFactory(
      Provider<KeychainManager> keychainProvider, Provider<Vault> vaultProvider) {
    this.keychainProvider = keychainProvider;
    this.vaultProvider = vaultProvider;
  }

  @Override
  public Optional<char[]> get() {
    return provideStoredPassword(keychainProvider.get(), vaultProvider.get());
  }

  public static MasterkeyFileLoadingModule_ProvideStoredPasswordFactory create(
      Provider<KeychainManager> keychainProvider, Provider<Vault> vaultProvider) {
    return new MasterkeyFileLoadingModule_ProvideStoredPasswordFactory(
        keychainProvider, vaultProvider);
  }

  public static Optional<char[]> provideStoredPassword(KeychainManager keychain, Vault vault) {
    return Preconditions.checkNotNullFromProvides(
        MasterkeyFileLoadingModule.provideStoredPassword(keychain, vault));
  }
}
