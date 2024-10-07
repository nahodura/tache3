package org.cryptomator.ui.quit;

import dagger.Lazy;
import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.awt.desktop.QuitResponse;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicReference;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.cryptomator.common.vaults.Vault;
import org.cryptomator.ui.common.VaultService;

@ScopeMetadata("org.cryptomator.ui.quit.QuitScoped")
@QualifierMetadata({"org.cryptomator.ui.quit.QuitWindow", "org.cryptomator.ui.common.FxmlScene"})
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class QuitController_Factory implements Factory<QuitController> {
  private final Provider<Stage> windowProvider;

  private final Provider<ObservableList<Vault>> vaultsProvider;

  private final Provider<ExecutorService> executorServiceProvider;

  private final Provider<VaultService> vaultServiceProvider;

  private final Provider<Scene> quitForcedSceneProvider;

  private final Provider<AtomicReference<QuitResponse>> quitResponseProvider;

  public QuitController_Factory(
      Provider<Stage> windowProvider,
      Provider<ObservableList<Vault>> vaultsProvider,
      Provider<ExecutorService> executorServiceProvider,
      Provider<VaultService> vaultServiceProvider,
      Provider<Scene> quitForcedSceneProvider,
      Provider<AtomicReference<QuitResponse>> quitResponseProvider) {
    this.windowProvider = windowProvider;
    this.vaultsProvider = vaultsProvider;
    this.executorServiceProvider = executorServiceProvider;
    this.vaultServiceProvider = vaultServiceProvider;
    this.quitForcedSceneProvider = quitForcedSceneProvider;
    this.quitResponseProvider = quitResponseProvider;
  }

  @Override
  public QuitController get() {
    return newInstance(
        windowProvider.get(),
        vaultsProvider.get(),
        executorServiceProvider.get(),
        vaultServiceProvider.get(),
        DoubleCheck.lazy(quitForcedSceneProvider),
        quitResponseProvider.get());
  }

  public static QuitController_Factory create(
      Provider<Stage> windowProvider,
      Provider<ObservableList<Vault>> vaultsProvider,
      Provider<ExecutorService> executorServiceProvider,
      Provider<VaultService> vaultServiceProvider,
      Provider<Scene> quitForcedSceneProvider,
      Provider<AtomicReference<QuitResponse>> quitResponseProvider) {
    return new QuitController_Factory(
        windowProvider,
        vaultsProvider,
        executorServiceProvider,
        vaultServiceProvider,
        quitForcedSceneProvider,
        quitResponseProvider);
  }

  public static QuitController newInstance(
      Stage window,
      ObservableList<Vault> vaults,
      ExecutorService executorService,
      VaultService vaultService,
      Lazy<Scene> quitForcedScene,
      AtomicReference<QuitResponse> quitResponse) {
    return new QuitController(
        window, vaults, executorService, vaultService, quitForcedScene, quitResponse);
  }
}
