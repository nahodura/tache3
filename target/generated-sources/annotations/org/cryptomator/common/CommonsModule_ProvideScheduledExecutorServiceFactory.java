package org.cryptomator.common;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class CommonsModule_ProvideScheduledExecutorServiceFactory
    implements Factory<ScheduledExecutorService> {
  private final Provider<ShutdownHook> shutdownHookProvider;

  public CommonsModule_ProvideScheduledExecutorServiceFactory(
      Provider<ShutdownHook> shutdownHookProvider) {
    this.shutdownHookProvider = shutdownHookProvider;
  }

  @Override
  public ScheduledExecutorService get() {
    return provideScheduledExecutorService(shutdownHookProvider.get());
  }

  public static CommonsModule_ProvideScheduledExecutorServiceFactory create(
      Provider<ShutdownHook> shutdownHookProvider) {
    return new CommonsModule_ProvideScheduledExecutorServiceFactory(shutdownHookProvider);
  }

  public static ScheduledExecutorService provideScheduledExecutorService(
      ShutdownHook shutdownHook) {
    return Preconditions.checkNotNullFromProvides(
        CommonsModule.provideScheduledExecutorService(shutdownHook));
  }
}
