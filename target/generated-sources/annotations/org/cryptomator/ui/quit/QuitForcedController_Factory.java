package org.cryptomator.ui.quit;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.awt.desktop.QuitResponse;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicReference;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.cryptomator.common.vaults.Vault;
import org.cryptomator.ui.common.VaultService;

@ScopeMetadata
@QualifierMetadata("org.cryptomator.ui.quit.QuitWindow")
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class QuitForcedController_Factory implements Factory<QuitForcedController> {
  private final Provider<Stage> windowProvider;

  private final Provider<ObservableList<Vault>> vaultsProvider;

  private final Provider<ExecutorService> executorServiceProvider;

  private final Provider<VaultService> vaultServiceProvider;

  private final Provider<AtomicReference<QuitResponse>> quitResponseProvider;

  public QuitForcedController_Factory(
      Provider<Stage> windowProvider,
      Provider<ObservableList<Vault>> vaultsProvider,
      Provider<ExecutorService> executorServiceProvider,
      Provider<VaultService> vaultServiceProvider,
      Provider<AtomicReference<QuitResponse>> quitResponseProvider) {
    this.windowProvider = windowProvider;
    this.vaultsProvider = vaultsProvider;
    this.executorServiceProvider = executorServiceProvider;
    this.vaultServiceProvider = vaultServiceProvider;
    this.quitResponseProvider = quitResponseProvider;
  }

  @Override
  public QuitForcedController get() {
    return newInstance(
        windowProvider.get(),
        vaultsProvider.get(),
        executorServiceProvider.get(),
        vaultServiceProvider.get(),
        quitResponseProvider.get());
  }

  public static QuitForcedController_Factory create(
      Provider<Stage> windowProvider,
      Provider<ObservableList<Vault>> vaultsProvider,
      Provider<ExecutorService> executorServiceProvider,
      Provider<VaultService> vaultServiceProvider,
      Provider<AtomicReference<QuitResponse>> quitResponseProvider) {
    return new QuitForcedController_Factory(
        windowProvider,
        vaultsProvider,
        executorServiceProvider,
        vaultServiceProvider,
        quitResponseProvider);
  }

  public static QuitForcedController newInstance(
      Stage window,
      ObservableList<Vault> vaults,
      ExecutorService executorService,
      VaultService vaultService,
      AtomicReference<QuitResponse> quitResponse) {
    return new QuitForcedController(window, vaults, executorService, vaultService, quitResponse);
  }
}
