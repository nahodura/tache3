package org.cryptomator.ui.health;

import dagger.Lazy;
import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicReference;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.cryptomator.common.vaults.Vault;
import org.cryptomator.cryptofs.VaultConfig;
import org.cryptomator.cryptolib.api.Masterkey;
import org.cryptomator.ui.fxapp.FxApplicationWindows;
import org.cryptomator.ui.keyloading.KeyLoadingStrategy;

@ScopeMetadata("org.cryptomator.ui.health.HealthCheckScoped")
@QualifierMetadata({
  "org.cryptomator.ui.health.HealthCheckWindow",
  "org.cryptomator.ui.common.FxmlScene",
  "javax.inject.Named"
})
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class StartController_Factory implements Factory<StartController> {
  private final Provider<Stage> windowProvider;

  private final Provider<Vault> vaultProvider;

  private final Provider<KeyLoadingStrategy> keyLoadingStrategyProvider;

  private final Provider<ExecutorService> executorProvider;

  private final Provider<AtomicReference<Masterkey>> masterkeyRefProvider;

  private final Provider<AtomicReference<VaultConfig>> vaultConfigRefProvider;

  private final Provider<Scene> checkSceneProvider;

  private final Provider<FxApplicationWindows> appWindowsProvider;

  private final Provider<Stage> unlockWindowProvider;

  public StartController_Factory(
      Provider<Stage> windowProvider,
      Provider<Vault> vaultProvider,
      Provider<KeyLoadingStrategy> keyLoadingStrategyProvider,
      Provider<ExecutorService> executorProvider,
      Provider<AtomicReference<Masterkey>> masterkeyRefProvider,
      Provider<AtomicReference<VaultConfig>> vaultConfigRefProvider,
      Provider<Scene> checkSceneProvider,
      Provider<FxApplicationWindows> appWindowsProvider,
      Provider<Stage> unlockWindowProvider) {
    this.windowProvider = windowProvider;
    this.vaultProvider = vaultProvider;
    this.keyLoadingStrategyProvider = keyLoadingStrategyProvider;
    this.executorProvider = executorProvider;
    this.masterkeyRefProvider = masterkeyRefProvider;
    this.vaultConfigRefProvider = vaultConfigRefProvider;
    this.checkSceneProvider = checkSceneProvider;
    this.appWindowsProvider = appWindowsProvider;
    this.unlockWindowProvider = unlockWindowProvider;
  }

  @Override
  public StartController get() {
    return newInstance(
        windowProvider.get(),
        vaultProvider.get(),
        keyLoadingStrategyProvider.get(),
        executorProvider.get(),
        masterkeyRefProvider.get(),
        vaultConfigRefProvider.get(),
        DoubleCheck.lazy(checkSceneProvider),
        appWindowsProvider.get(),
        unlockWindowProvider.get());
  }

  public static StartController_Factory create(
      Provider<Stage> windowProvider,
      Provider<Vault> vaultProvider,
      Provider<KeyLoadingStrategy> keyLoadingStrategyProvider,
      Provider<ExecutorService> executorProvider,
      Provider<AtomicReference<Masterkey>> masterkeyRefProvider,
      Provider<AtomicReference<VaultConfig>> vaultConfigRefProvider,
      Provider<Scene> checkSceneProvider,
      Provider<FxApplicationWindows> appWindowsProvider,
      Provider<Stage> unlockWindowProvider) {
    return new StartController_Factory(
        windowProvider,
        vaultProvider,
        keyLoadingStrategyProvider,
        executorProvider,
        masterkeyRefProvider,
        vaultConfigRefProvider,
        checkSceneProvider,
        appWindowsProvider,
        unlockWindowProvider);
  }

  public static StartController newInstance(
      Stage window,
      Vault vault,
      KeyLoadingStrategy keyLoadingStrategy,
      ExecutorService executor,
      AtomicReference<Masterkey> masterkeyRef,
      AtomicReference<VaultConfig> vaultConfigRef,
      Lazy<Scene> checkScene,
      FxApplicationWindows appWindows,
      Stage unlockWindow) {
    return new StartController(
        window,
        vault,
        keyLoadingStrategy,
        executor,
        masterkeyRef,
        vaultConfigRef,
        checkScene,
        appWindows,
        unlockWindow);
  }
}
