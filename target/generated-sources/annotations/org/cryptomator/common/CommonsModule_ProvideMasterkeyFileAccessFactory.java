package org.cryptomator.common;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.security.SecureRandom;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.cryptomator.cryptolib.common.MasterkeyFileAccess;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class CommonsModule_ProvideMasterkeyFileAccessFactory
    implements Factory<MasterkeyFileAccess> {
  private final Provider<SecureRandom> csprngProvider;

  public CommonsModule_ProvideMasterkeyFileAccessFactory(Provider<SecureRandom> csprngProvider) {
    this.csprngProvider = csprngProvider;
  }

  @Override
  public MasterkeyFileAccess get() {
    return provideMasterkeyFileAccess(csprngProvider.get());
  }

  public static CommonsModule_ProvideMasterkeyFileAccessFactory create(
      Provider<SecureRandom> csprngProvider) {
    return new CommonsModule_ProvideMasterkeyFileAccessFactory(csprngProvider);
  }

  public static MasterkeyFileAccess provideMasterkeyFileAccess(SecureRandom csprng) {
    return Preconditions.checkNotNullFromProvides(CommonsModule.provideMasterkeyFileAccess(csprng));
  }
}
