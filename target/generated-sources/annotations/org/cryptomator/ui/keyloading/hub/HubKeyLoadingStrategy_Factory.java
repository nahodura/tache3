package org.cryptomator.ui.keyloading.hub;

import dagger.Lazy;
import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.util.concurrent.CompletableFuture;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.cryptomator.common.keychain.KeychainManager;
import org.cryptomator.common.settings.DeviceKey;

@ScopeMetadata
@QualifierMetadata({
  "org.cryptomator.ui.keyloading.KeyLoading",
  "org.cryptomator.ui.common.FxmlScene",
  "javax.inject.Named"
})
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class HubKeyLoadingStrategy_Factory implements Factory<HubKeyLoadingStrategy> {
  private final Provider<Stage> windowProvider;

  private final Provider<Scene> authFlowSceneProvider;

  private final Provider<Scene> noKeychainSceneProvider;

  private final Provider<CompletableFuture<ReceivedKey>> resultProvider;

  private final Provider<DeviceKey> deviceKeyProvider;

  private final Provider<KeychainManager> keychainManagerProvider;

  private final Provider<String> windowTitleProvider;

  public HubKeyLoadingStrategy_Factory(
      Provider<Stage> windowProvider,
      Provider<Scene> authFlowSceneProvider,
      Provider<Scene> noKeychainSceneProvider,
      Provider<CompletableFuture<ReceivedKey>> resultProvider,
      Provider<DeviceKey> deviceKeyProvider,
      Provider<KeychainManager> keychainManagerProvider,
      Provider<String> windowTitleProvider) {
    this.windowProvider = windowProvider;
    this.authFlowSceneProvider = authFlowSceneProvider;
    this.noKeychainSceneProvider = noKeychainSceneProvider;
    this.resultProvider = resultProvider;
    this.deviceKeyProvider = deviceKeyProvider;
    this.keychainManagerProvider = keychainManagerProvider;
    this.windowTitleProvider = windowTitleProvider;
  }

  @Override
  public HubKeyLoadingStrategy get() {
    return newInstance(
        windowProvider.get(),
        DoubleCheck.lazy(authFlowSceneProvider),
        DoubleCheck.lazy(noKeychainSceneProvider),
        resultProvider.get(),
        deviceKeyProvider.get(),
        keychainManagerProvider.get(),
        windowTitleProvider.get());
  }

  public static HubKeyLoadingStrategy_Factory create(
      Provider<Stage> windowProvider,
      Provider<Scene> authFlowSceneProvider,
      Provider<Scene> noKeychainSceneProvider,
      Provider<CompletableFuture<ReceivedKey>> resultProvider,
      Provider<DeviceKey> deviceKeyProvider,
      Provider<KeychainManager> keychainManagerProvider,
      Provider<String> windowTitleProvider) {
    return new HubKeyLoadingStrategy_Factory(
        windowProvider,
        authFlowSceneProvider,
        noKeychainSceneProvider,
        resultProvider,
        deviceKeyProvider,
        keychainManagerProvider,
        windowTitleProvider);
  }

  public static HubKeyLoadingStrategy newInstance(
      Stage window,
      Lazy<Scene> authFlowScene,
      Lazy<Scene> noKeychainScene,
      CompletableFuture<ReceivedKey> result,
      DeviceKey deviceKey,
      KeychainManager keychainManager,
      String windowTitle) {
    return new HubKeyLoadingStrategy(
        window, authFlowScene, noKeychainScene, result, deviceKey, keychainManager, windowTitle);
  }
}
