package org.cryptomator.common;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.security.SecureRandom;
import javax.annotation.processing.Generated;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class CommonsModule_ProvideCSPRNGFactory implements Factory<SecureRandom> {
  @Override
  public SecureRandom get() {
    return provideCSPRNG();
  }

  public static CommonsModule_ProvideCSPRNGFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static SecureRandom provideCSPRNG() {
    return Preconditions.checkNotNullFromProvides(CommonsModule.provideCSPRNG());
  }

  private static final class InstanceHolder {
    private static final CommonsModule_ProvideCSPRNGFactory INSTANCE =
        new CommonsModule_ProvideCSPRNGFactory();
  }
}
