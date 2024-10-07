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
public final class CheckExecutor_Factory implements Factory<CheckExecutor> {
  private final Provider<Vault> vaultProvider;

  private final Provider<AtomicReference<Masterkey>> masterkeyRefProvider;

  private final Provider<AtomicReference<VaultConfig>> vaultConfigRefProvider;

  private final Provider<SecureRandom> csprngProvider;

  public CheckExecutor_Factory(
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
  public CheckExecutor get() {
    return newInstance(
        vaultProvider.get(),
        masterkeyRefProvider.get(),
        vaultConfigRefProvider.get(),
        csprngProvider.get());
  }

  public static CheckExecutor_Factory create(
      Provider<Vault> vaultProvider,
      Provider<AtomicReference<Masterkey>> masterkeyRefProvider,
      Provider<AtomicReference<VaultConfig>> vaultConfigRefProvider,
      Provider<SecureRandom> csprngProvider) {
    return new CheckExecutor_Factory(
        vaultProvider, masterkeyRefProvider, vaultConfigRefProvider, csprngProvider);
  }

  public static CheckExecutor newInstance(
      Vault vault,
      AtomicReference<Masterkey> masterkeyRef,
      AtomicReference<VaultConfig> vaultConfigRef,
      SecureRandom csprng) {
    return new CheckExecutor(vault, masterkeyRef, vaultConfigRef, csprng);
  }
}
