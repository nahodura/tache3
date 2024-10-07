package org.cryptomator.common.vaults;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javafx.collections.ObservableList;
import javax.annotation.processing.Generated;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class VaultListModule_ProvideVaultListFactory
    implements Factory<ObservableList<Vault>> {
  private final VaultListModule module;

  public VaultListModule_ProvideVaultListFactory(VaultListModule module) {
    this.module = module;
  }

  @Override
  public ObservableList<Vault> get() {
    return provideVaultList(module);
  }

  public static VaultListModule_ProvideVaultListFactory create(VaultListModule module) {
    return new VaultListModule_ProvideVaultListFactory(module);
  }

  public static ObservableList<Vault> provideVaultList(VaultListModule instance) {
    return Preconditions.checkNotNullFromProvides(instance.provideVaultList());
  }
}
