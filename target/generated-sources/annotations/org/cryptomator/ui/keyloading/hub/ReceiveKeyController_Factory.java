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
import org.cryptomator.common.vaults.Vault;

@ScopeMetadata("org.cryptomator.ui.keyloading.KeyLoadingScoped")
@QualifierMetadata({
  "org.cryptomator.ui.keyloading.KeyLoading",
  "javax.inject.Named",
  "org.cryptomator.ui.common.FxmlScene"
})
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class ReceiveKeyController_Factory implements Factory<ReceiveKeyController> {
  private final Provider<Vault> vaultProvider;

  private final Provider<ExecutorService> executorProvider;

  private final Provider<Stage> windowProvider;

  private final Provider<HubConfig> hubConfigProvider;

  private final Provider<String> deviceIdProvider;

  private final Provider<AtomicReference<String>> tokenRefProvider;

  private final Provider<CompletableFuture<ReceivedKey>> resultProvider;

  private final Provider<Scene> registerDeviceSceneProvider;

  private final Provider<Scene> legacyRegisterDeviceSceneProvider;

  private final Provider<Scene> unauthorizedSceneProvider;

  private final Provider<Scene> accountInitializationSceneProvider;

  private final Provider<Scene> invalidLicenseSceneProvider;

  public ReceiveKeyController_Factory(
      Provider<Vault> vaultProvider,
      Provider<ExecutorService> executorProvider,
      Provider<Stage> windowProvider,
      Provider<HubConfig> hubConfigProvider,
      Provider<String> deviceIdProvider,
      Provider<AtomicReference<String>> tokenRefProvider,
      Provider<CompletableFuture<ReceivedKey>> resultProvider,
      Provider<Scene> registerDeviceSceneProvider,
      Provider<Scene> legacyRegisterDeviceSceneProvider,
      Provider<Scene> unauthorizedSceneProvider,
      Provider<Scene> accountInitializationSceneProvider,
      Provider<Scene> invalidLicenseSceneProvider) {
    this.vaultProvider = vaultProvider;
    this.executorProvider = executorProvider;
    this.windowProvider = windowProvider;
    this.hubConfigProvider = hubConfigProvider;
    this.deviceIdProvider = deviceIdProvider;
    this.tokenRefProvider = tokenRefProvider;
    this.resultProvider = resultProvider;
    this.registerDeviceSceneProvider = registerDeviceSceneProvider;
    this.legacyRegisterDeviceSceneProvider = legacyRegisterDeviceSceneProvider;
    this.unauthorizedSceneProvider = unauthorizedSceneProvider;
    this.accountInitializationSceneProvider = accountInitializationSceneProvider;
    this.invalidLicenseSceneProvider = invalidLicenseSceneProvider;
  }

  @Override
  public ReceiveKeyController get() {
    return newInstance(
        vaultProvider.get(),
        executorProvider.get(),
        windowProvider.get(),
        hubConfigProvider.get(),
        deviceIdProvider.get(),
        tokenRefProvider.get(),
        resultProvider.get(),
        DoubleCheck.lazy(registerDeviceSceneProvider),
        DoubleCheck.lazy(legacyRegisterDeviceSceneProvider),
        DoubleCheck.lazy(unauthorizedSceneProvider),
        DoubleCheck.lazy(accountInitializationSceneProvider),
        DoubleCheck.lazy(invalidLicenseSceneProvider));
  }

  public static ReceiveKeyController_Factory create(
      Provider<Vault> vaultProvider,
      Provider<ExecutorService> executorProvider,
      Provider<Stage> windowProvider,
      Provider<HubConfig> hubConfigProvider,
      Provider<String> deviceIdProvider,
      Provider<AtomicReference<String>> tokenRefProvider,
      Provider<CompletableFuture<ReceivedKey>> resultProvider,
      Provider<Scene> registerDeviceSceneProvider,
      Provider<Scene> legacyRegisterDeviceSceneProvider,
      Provider<Scene> unauthorizedSceneProvider,
      Provider<Scene> accountInitializationSceneProvider,
      Provider<Scene> invalidLicenseSceneProvider) {
    return new ReceiveKeyController_Factory(
        vaultProvider,
        executorProvider,
        windowProvider,
        hubConfigProvider,
        deviceIdProvider,
        tokenRefProvider,
        resultProvider,
        registerDeviceSceneProvider,
        legacyRegisterDeviceSceneProvider,
        unauthorizedSceneProvider,
        accountInitializationSceneProvider,
        invalidLicenseSceneProvider);
  }

  public static ReceiveKeyController newInstance(
      Vault vault,
      ExecutorService executor,
      Stage window,
      HubConfig hubConfig,
      String deviceId,
      AtomicReference<String> tokenRef,
      CompletableFuture<ReceivedKey> result,
      Lazy<Scene> registerDeviceScene,
      Lazy<Scene> legacyRegisterDeviceScene,
      Lazy<Scene> unauthorizedScene,
      Lazy<Scene> accountInitializationScene,
      Lazy<Scene> invalidLicenseScene) {
    return new ReceiveKeyController(
        vault,
        executor,
        window,
        hubConfig,
        deviceId,
        tokenRef,
        result,
        registerDeviceScene,
        legacyRegisterDeviceScene,
        unauthorizedScene,
        accountInitializationScene,
        invalidLicenseScene);
  }
}
