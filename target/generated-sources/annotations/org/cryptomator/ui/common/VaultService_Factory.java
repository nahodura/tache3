package org.cryptomator.ui.common;

import dagger.Lazy;
import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.util.concurrent.ExecutorService;
import javafx.application.Application;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("org.cryptomator.ui.fxapp.FxApplicationScoped")
@QualifierMetadata
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class VaultService_Factory implements Factory<VaultService> {
  private final Provider<Application> applicationProvider;

  private final Provider<ExecutorService> executorServiceProvider;

  public VaultService_Factory(
      Provider<Application> applicationProvider,
      Provider<ExecutorService> executorServiceProvider) {
    this.applicationProvider = applicationProvider;
    this.executorServiceProvider = executorServiceProvider;
  }

  @Override
  public VaultService get() {
    return newInstance(DoubleCheck.lazy(applicationProvider), executorServiceProvider.get());
  }

  public static VaultService_Factory create(
      Provider<Application> applicationProvider,
      Provider<ExecutorService> executorServiceProvider) {
    return new VaultService_Factory(applicationProvider, executorServiceProvider);
  }

  public static VaultService newInstance(
      Lazy<Application> application, ExecutorService executorService) {
    return new VaultService(application, executorService);
  }
}
