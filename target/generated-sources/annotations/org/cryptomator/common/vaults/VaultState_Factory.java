package org.cryptomator.common.vaults;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("org.cryptomator.common.vaults.PerVault")
@QualifierMetadata
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class VaultState_Factory implements Factory<VaultState> {
  private final Provider<VaultState.Value> initialValueProvider;

  public VaultState_Factory(Provider<VaultState.Value> initialValueProvider) {
    this.initialValueProvider = initialValueProvider;
  }

  @Override
  public VaultState get() {
    return newInstance(initialValueProvider.get());
  }

  public static VaultState_Factory create(Provider<VaultState.Value> initialValueProvider) {
    return new VaultState_Factory(initialValueProvider);
  }

  public static VaultState newInstance(VaultState.Value initialValue) {
    return new VaultState(initialValue);
  }
}
