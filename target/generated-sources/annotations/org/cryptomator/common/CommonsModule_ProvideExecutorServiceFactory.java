package org.cryptomator.common;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.util.concurrent.ExecutorService;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class CommonsModule_ProvideExecutorServiceFactory implements Factory<ExecutorService> {
  private final Provider<ShutdownHook> shutdownHookProvider;

  public CommonsModule_ProvideExecutorServiceFactory(Provider<ShutdownHook> shutdownHookProvider) {
    this.shutdownHookProvider = shutdownHookProvider;
  }

  @Override
  public ExecutorService get() {
    return provideExecutorService(shutdownHookProvider.get());
  }

  public static CommonsModule_ProvideExecutorServiceFactory create(
      Provider<ShutdownHook> shutdownHookProvider) {
    return new CommonsModule_ProvideExecutorServiceFactory(shutdownHookProvider);
  }

  public static ExecutorService provideExecutorService(ShutdownHook shutdownHook) {
    return Preconditions.checkNotNullFromProvides(
        CommonsModule.provideExecutorService(shutdownHook));
  }
}
