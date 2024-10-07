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
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.cryptomator.common.settings.DeviceKey;

@ScopeMetadata("org.cryptomator.ui.keyloading.KeyLoadingScoped")
@QualifierMetadata({
  "org.cryptomator.ui.keyloading.KeyLoading",
  "javax.inject.Named",
  "org.cryptomator.ui.common.FxmlScene"
})
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class LegacyRegisterDeviceController_Factory
    implements Factory<LegacyRegisterDeviceController> {
  private final Provider<Stage> windowProvider;

  private final Provider<ExecutorService> executorProvider;

  private final Provider<HubConfig> hubConfigProvider;

  private final Provider<String> deviceIdProvider;

  private final Provider<DeviceKey> deviceKeyProvider;

  private final Provider<CompletableFuture<ReceivedKey>> resultProvider;

  private final Provider<AtomicReference<String>> bearerTokenProvider;

  private final Provider<Scene> registerSuccessSceneProvider;

  private final Provider<Scene> registerFailedSceneProvider;

  public LegacyRegisterDeviceController_Factory(
      Provider<Stage> windowProvider,
      Provider<ExecutorService> executorProvider,
      Provider<HubConfig> hubConfigProvider,
      Provider<String> deviceIdProvider,
      Provider<DeviceKey> deviceKeyProvider,
      Provider<CompletableFuture<ReceivedKey>> resultProvider,
      Provider<AtomicReference<String>> bearerTokenProvider,
      Provider<Scene> registerSuccessSceneProvider,
      Provider<Scene> registerFailedSceneProvider) {
    this.windowProvider = windowProvider;
    this.executorProvider = executorProvider;
    this.hubConfigProvider = hubConfigProvider;
    this.deviceIdProvider = deviceIdProvider;
    this.deviceKeyProvider = deviceKeyProvider;
    this.resultProvider = resultProvider;
    this.bearerTokenProvider = bearerTokenProvider;
    this.registerSuccessSceneProvider = registerSuccessSceneProvider;
    this.registerFailedSceneProvider = registerFailedSceneProvider;
  }

  @Override
  public LegacyRegisterDeviceController get() {
    return newInstance(
        windowProvider.get(),
        executorProvider.get(),
        hubConfigProvider.get(),
        deviceIdProvider.get(),
        deviceKeyProvider.get(),
        resultProvider.get(),
        bearerTokenProvider.get(),
        DoubleCheck.lazy(registerSuccessSceneProvider),
        DoubleCheck.lazy(registerFailedSceneProvider));
  }

  public static LegacyRegisterDeviceController_Factory create(
      Provider<Stage> windowProvider,
      Provider<ExecutorService> executorProvider,
      Provider<HubConfig> hubConfigProvider,
      Provider<String> deviceIdProvider,
      Provider<DeviceKey> deviceKeyProvider,
      Provider<CompletableFuture<ReceivedKey>> resultProvider,
      Provider<AtomicReference<String>> bearerTokenProvider,
      Provider<Scene> registerSuccessSceneProvider,
      Provider<Scene> registerFailedSceneProvider) {
    return new LegacyRegisterDeviceController_Factory(
        windowProvider,
        executorProvider,
        hubConfigProvider,
        deviceIdProvider,
        deviceKeyProvider,
        resultProvider,
        bearerTokenProvider,
        registerSuccessSceneProvider,
        registerFailedSceneProvider);
  }

  public static LegacyRegisterDeviceController newInstance(
      Stage window,
      ExecutorService executor,
      HubConfig hubConfig,
      String deviceId,
      DeviceKey deviceKey,
      CompletableFuture<ReceivedKey> result,
      AtomicReference<String> bearerToken,
      Lazy<Scene> registerSuccessScene,
      Lazy<Scene> registerFailedScene) {
    return new LegacyRegisterDeviceController(
        window,
        executor,
        hubConfig,
        deviceId,
        deviceKey,
        result,
        bearerToken,
        registerSuccessScene,
        registerFailedScene);
  }
}
