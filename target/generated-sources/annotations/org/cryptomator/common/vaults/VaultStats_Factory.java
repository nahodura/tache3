package org.cryptomator.common.vaults;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.cryptomator.cryptofs.CryptoFileSystem;

@ScopeMetadata("org.cryptomator.common.vaults.PerVault")
@QualifierMetadata
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class VaultStats_Factory implements Factory<VaultStats> {
  private final Provider<AtomicReference<CryptoFileSystem>> fsProvider;

  private final Provider<VaultState> stateProvider;

  private final Provider<ExecutorService> executorProvider;

  public VaultStats_Factory(
      Provider<AtomicReference<CryptoFileSystem>> fsProvider,
      Provider<VaultState> stateProvider,
      Provider<ExecutorService> executorProvider) {
    this.fsProvider = fsProvider;
    this.stateProvider = stateProvider;
    this.executorProvider = executorProvider;
  }

  @Override
  public VaultStats get() {
    return newInstance(fsProvider.get(), stateProvider.get(), executorProvider.get());
  }

  public static VaultStats_Factory create(
      Provider<AtomicReference<CryptoFileSystem>> fsProvider,
      Provider<VaultState> stateProvider,
      Provider<ExecutorService> executorProvider) {
    return new VaultStats_Factory(fsProvider, stateProvider, executorProvider);
  }

  public static VaultStats newInstance(
      AtomicReference<CryptoFileSystem> fs, VaultState state, ExecutorService executor) {
    return new VaultStats(fs, state, executor);
  }
}
