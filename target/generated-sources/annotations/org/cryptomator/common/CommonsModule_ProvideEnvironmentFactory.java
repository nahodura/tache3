package org.cryptomator.common;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class CommonsModule_ProvideEnvironmentFactory implements Factory<Environment> {
  @Override
  public Environment get() {
    return provideEnvironment();
  }

  public static CommonsModule_ProvideEnvironmentFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static Environment provideEnvironment() {
    return Preconditions.checkNotNullFromProvides(CommonsModule.provideEnvironment());
  }

  private static final class InstanceHolder {
    private static final CommonsModule_ProvideEnvironmentFactory INSTANCE =
        new CommonsModule_ProvideEnvironmentFactory();
  }
}
