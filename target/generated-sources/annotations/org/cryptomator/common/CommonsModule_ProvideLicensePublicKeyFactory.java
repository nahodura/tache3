package org.cryptomator.common;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata("javax.inject.Named")
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class CommonsModule_ProvideLicensePublicKeyFactory implements Factory<String> {
  @Override
  public String get() {
    return provideLicensePublicKey();
  }

  public static CommonsModule_ProvideLicensePublicKeyFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static String provideLicensePublicKey() {
    return Preconditions.checkNotNullFromProvides(CommonsModule.provideLicensePublicKey());
  }

  private static final class InstanceHolder {
    private static final CommonsModule_ProvideLicensePublicKeyFactory INSTANCE =
        new CommonsModule_ProvideLicensePublicKeyFactory();
  }
}
