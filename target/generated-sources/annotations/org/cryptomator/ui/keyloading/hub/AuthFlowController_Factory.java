package org.cryptomator.ui.keyloading.hub;

import dagger.Lazy;
import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicReference;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("org.cryptomator.ui.keyloading.KeyLoadingScoped")
@QualifierMetadata({
  "org.cryptomator.ui.keyloading.KeyLoading",
  "javax.inject.Named",
  "org.cryptomator.ui.common.FxmlScene"
})
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class AuthFlowController_Factory implements Factory<AuthFlowController> {
  private final Provider<Application> applicationProvider;

  private final Provider<Stage> windowProvider;

  private final Provider<ExecutorService> executorProvider;

  private final Provider<String> deviceIdProvider;

  private final Provider<HubConfig> hubConfigProvider;

  private final Provider<AtomicReference<String>> tokenRefProvider;

  private final Provider<CompletableFuture<ReceivedKey>> resultProvider;

  private final Provider<Scene> receiveKeySceneProvider;

  public AuthFlowController_Factory(
      Provider<Application> applicationProvider,
      Provider<Stage> windowProvider,
      Provider<ExecutorService> executorProvider,
      Provider<String> deviceIdProvider,
      Provider<HubConfig> hubConfigProvider,
      Provider<AtomicReference<String>> tokenRefProvider,
      Provider<CompletableFuture<ReceivedKey>> resultProvider,
      Provider<Scene> receiveKeySceneProvider) {
    this.applicationProvider = applicationProvider;
    this.windowProvider = windowProvider;
    this.executorProvider = executorProvider;
    this.deviceIdProvider = deviceIdProvider;
    this.hubConfigProvider = hubConfigProvider;
    this.tokenRefProvider = tokenRefProvider;
    this.resultProvider = resultProvider;
    this.receiveKeySceneProvider = receiveKeySceneProvider;
  }

  @Override
  public AuthFlowController get() {
    return newInstance(
        applicationProvider.get(),
        windowProvider.get(),
        executorProvider.get(),
        deviceIdProvider.get(),
        hubConfigProvider.get(),
        tokenRefProvider.get(),
        resultProvider.get(),
        DoubleCheck.lazy(receiveKeySceneProvider));
  }

  public static AuthFlowController_Factory create(
      Provider<Application> applicationProvider,
      Provider<Stage> windowProvider,
      Provider<ExecutorService> executorProvider,
      Provider<String> deviceIdProvider,
      Provider<HubConfig> hubConfigProvider,
      Provider<AtomicReference<String>> tokenRefProvider,
      Provider<CompletableFuture<ReceivedKey>> resultProvider,
      Provider<Scene> receiveKeySceneProvider) {
    return new AuthFlowController_Factory(
        applicationProvider,
        windowProvider,
        executorProvider,
        deviceIdProvider,
        hubConfigProvider,
        tokenRefProvider,
        resultProvider,
        receiveKeySceneProvider);
  }

  public static AuthFlowController newInstance(
      Application application,
      Stage window,
      ExecutorService executor,
      String deviceId,
      HubConfig hubConfig,
      AtomicReference<String> tokenRef,
      CompletableFuture<ReceivedKey> result,
      Lazy<Scene> receiveKeyScene) {
    return new AuthFlowController(
        application, window, executor, deviceId, hubConfig, tokenRef, result, receiveKeyScene);
  }
}
