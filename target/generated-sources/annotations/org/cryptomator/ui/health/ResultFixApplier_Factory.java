package org.cryptomator.ui.health;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.security.SecureRandom;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.cryptomator.common.vaults.Vault;
import org.cryptomator.cryptofs.VaultConfig;
import org.cryptomator.cryptolib.api.Masterkey;

@ScopeMetadata("org.cryptomator.ui.health.HealthCheckScoped")
@QualifierMetadata("org.cryptomator.ui.health.HealthCheckWindow")
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class ResultFixApplier_Factory implements Factory<ResultFixApplier> {
  private final Provider<Vault> vaultProvider;

  private final Provider<AtomicReference<Masterkey>> masterkeyRefProvider;

  private final Provider<AtomicReference<VaultConfig>> vaultConfigRefProvider;

  private final Provider<SecureRandom> csprngProvider;

  public ResultFixApplier_Factory(
      Provider<Vault> vaultProvider,
      Provider<AtomicReference<Masterkey>> masterkeyRefProvider,
      Provider<AtomicReference<VaultConfig>> vaultConfigRefProvider,
      Provider<SecureRandom> csprngProvider) {
    this.vaultProvider = vaultProvider;
    this.masterkeyRefProvider = masterkeyRefProvider;
    this.vaultConfigRefProvider = vaultConfigRefProvider;
    this.csprngProvider = csprngProvider;
  }

  @Override
  public ResultFixApplier get() {
    return newInstance(
        vaultProvider.get(),
        masterkeyRefProvider.get(),
        vaultConfigRefProvider.get(),
        csprngProvider.get());
  }

  public static ResultFixApplier_Factory create(
      Provider<Vault> vaultProvider,
      Provider<AtomicReference<Masterkey>> masterkeyRefProvider,
      Provider<AtomicReference<VaultConfig>> vaultConfigRefProvider,
      Provider<SecureRandom> csprngProvider) {
    return new ResultFixApplier_Factory(
        vaultProvider, masterkeyRefProvider, vaultConfigRefProvider, csprngProvider);
  }

  public static ResultFixApplier newInstance(
      Vault vault,
      AtomicReference<Masterkey> masterkeyRef,
      AtomicReference<VaultConfig> vaultConfigRef,
      SecureRandom csprng) {
    return new ResultFixApplier(vault, masterkeyRef, vaultConfigRef, csprng);
  }
}
