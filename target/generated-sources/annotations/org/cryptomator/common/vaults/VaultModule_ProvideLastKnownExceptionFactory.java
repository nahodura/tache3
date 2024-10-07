package org.cryptomator.common.vaults;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javafx.beans.property.ObjectProperty;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("org.cryptomator.common.vaults.PerVault")
@QualifierMetadata("javax.inject.Named")
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class VaultModule_ProvideLastKnownExceptionFactory
    implements Factory<ObjectProperty<Exception>> {
  private final VaultModule module;

  private final Provider<Exception> initialErrorCauseProvider;

  public VaultModule_ProvideLastKnownExceptionFactory(
      VaultModule module, Provider<Exception> initialErrorCauseProvider) {
    this.module = module;
    this.initialErrorCauseProvider = initialErrorCauseProvider;
  }

  @Override
  public ObjectProperty<Exception> get() {
    return provideLastKnownException(module, initialErrorCauseProvider.get());
  }

  public static VaultModule_ProvideLastKnownExceptionFactory create(
      VaultModule module, Provider<Exception> initialErrorCauseProvider) {
    return new VaultModule_ProvideLastKnownExceptionFactory(module, initialErrorCauseProvider);
  }

  public static ObjectProperty<Exception> provideLastKnownException(
      VaultModule instance, Exception initialErrorCause) {
    return Preconditions.checkNotNullFromProvides(
        instance.provideLastKnownException(initialErrorCause));
  }
}
