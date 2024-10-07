package org.cryptomator.ui.fxapp;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.util.Optional;
import java.util.concurrent.ExecutorService;
import javafx.beans.binding.ObjectBinding;
import javafx.concurrent.ScheduledService;
import javafx.util.Duration;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("org.cryptomator.ui.fxapp.FxApplicationScoped")
@QualifierMetadata("javax.inject.Named")
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class UpdateCheckerModule_ProvideCheckForUpdatesServiceFactory
    implements Factory<ScheduledService<String>> {
  private final Provider<ExecutorService> executorProvider;

  private final Provider<Optional<HttpClient>> httpClientProvider;

  private final Provider<HttpRequest> checkForUpdatesRequestProvider;

  private final Provider<ObjectBinding<Duration>> periodProvider;

  public UpdateCheckerModule_ProvideCheckForUpdatesServiceFactory(
      Provider<ExecutorService> executorProvider,
      Provider<Optional<HttpClient>> httpClientProvider,
      Provider<HttpRequest> checkForUpdatesRequestProvider,
      Provider<ObjectBinding<Duration>> periodProvider) {
    this.executorProvider = executorProvider;
    this.httpClientProvider = httpClientProvider;
    this.checkForUpdatesRequestProvider = checkForUpdatesRequestProvider;
    this.periodProvider = periodProvider;
  }

  @Override
  public ScheduledService<String> get() {
    return provideCheckForUpdatesService(
        executorProvider.get(),
        httpClientProvider.get(),
        checkForUpdatesRequestProvider.get(),
        periodProvider.get());
  }

  public static UpdateCheckerModule_ProvideCheckForUpdatesServiceFactory create(
      Provider<ExecutorService> executorProvider,
      Provider<Optional<HttpClient>> httpClientProvider,
      Provider<HttpRequest> checkForUpdatesRequestProvider,
      Provider<ObjectBinding<Duration>> periodProvider) {
    return new UpdateCheckerModule_ProvideCheckForUpdatesServiceFactory(
        executorProvider, httpClientProvider, checkForUpdatesRequestProvider, periodProvider);
  }

  public static ScheduledService<String> provideCheckForUpdatesService(
      ExecutorService executor,
      Optional<HttpClient> httpClient,
      HttpRequest checkForUpdatesRequest,
      ObjectBinding<Duration> period) {
    return Preconditions.checkNotNullFromProvides(
        UpdateCheckerModule.provideCheckForUpdatesService(
            executor, httpClient, checkForUpdatesRequest, period));
  }
}
