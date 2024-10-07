package org.cryptomator.common;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata("javax.inject.Named")
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class LicenseChecker_Factory implements Factory<LicenseChecker> {
  private final Provider<String> pemEncodedPublicKeyProvider;

  public LicenseChecker_Factory(Provider<String> pemEncodedPublicKeyProvider) {
    this.pemEncodedPublicKeyProvider = pemEncodedPublicKeyProvider;
  }

  @Override
  public LicenseChecker get() {
    return newInstance(pemEncodedPublicKeyProvider.get());
  }

  public static LicenseChecker_Factory create(Provider<String> pemEncodedPublicKeyProvider) {
    return new LicenseChecker_Factory(pemEncodedPublicKeyProvider);
  }

  public static LicenseChecker newInstance(String pemEncodedPublicKey) {
    return new LicenseChecker(pemEncodedPublicKey);
  }
}
