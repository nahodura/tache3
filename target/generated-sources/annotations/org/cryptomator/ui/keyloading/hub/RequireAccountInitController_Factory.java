package org.cryptomator.ui.keyloading.hub;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.util.concurrent.CompletableFuture;
import javafx.application.Application;
import javafx.stage.Stage;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("org.cryptomator.ui.keyloading.KeyLoadingScoped")
@QualifierMetadata("org.cryptomator.ui.keyloading.KeyLoading")
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class RequireAccountInitController_Factory
    implements Factory<RequireAccountInitController> {
  private final Provider<Application> applicationProvider;

  private final Provider<HubConfig> hubConfigProvider;

  private final Provider<Stage> windowProvider;

  private final Provider<CompletableFuture<ReceivedKey>> resultProvider;

  public RequireAccountInitController_Factory(
      Provider<Application> applicationProvider,
      Provider<HubConfig> hubConfigProvider,
      Provider<Stage> windowProvider,
      Provider<CompletableFuture<ReceivedKey>> resultProvider) {
    this.applicationProvider = applicationProvider;
    this.hubConfigProvider = hubConfigProvider;
    this.windowProvider = windowProvider;
    this.resultProvider = resultProvider;
  }

  @Override
  public RequireAccountInitController get() {
    return newInstance(
        applicationProvider.get(),
        hubConfigProvider.get(),
        windowProvider.get(),
        resultProvider.get());
  }

  public static RequireAccountInitController_Factory create(
      Provider<Application> applicationProvider,
      Provider<HubConfig> hubConfigProvider,
      Provider<Stage> windowProvider,
      Provider<CompletableFuture<ReceivedKey>> resultProvider) {
    return new RequireAccountInitController_Factory(
        applicationProvider, hubConfigProvider, windowProvider, resultProvider);
  }

  public static RequireAccountInitController newInstance(
      Application application,
      HubConfig hubConfig,
      Stage window,
      CompletableFuture<ReceivedKey> result) {
    return new RequireAccountInitController(application, hubConfig, window, result);
  }
}
