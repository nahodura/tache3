package org.cryptomator.ui.fxapp;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.cryptomator.common.vaults.VaultListManager;
import org.cryptomator.launcher.AppLaunchEvent;
import org.cryptomator.ui.common.VaultService;

@ScopeMetadata("org.cryptomator.ui.fxapp.FxApplicationScoped")
@QualifierMetadata("javax.inject.Named")
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class AppLaunchEventHandler_Factory implements Factory<AppLaunchEventHandler> {
  private final Provider<BlockingQueue<AppLaunchEvent>> launchEventQueueProvider;

  private final Provider<ExecutorService> executorServiceProvider;

  private final Provider<FxApplicationWindows> appWindowsProvider;

  private final Provider<VaultListManager> vaultListManagerProvider;

  private final Provider<VaultService> vaultServiceProvider;

  public AppLaunchEventHandler_Factory(
      Provider<BlockingQueue<AppLaunchEvent>> launchEventQueueProvider,
      Provider<ExecutorService> executorServiceProvider,
      Provider<FxApplicationWindows> appWindowsProvider,
      Provider<VaultListManager> vaultListManagerProvider,
      Provider<VaultService> vaultServiceProvider) {
    this.launchEventQueueProvider = launchEventQueueProvider;
    this.executorServiceProvider = executorServiceProvider;
    this.appWindowsProvider = appWindowsProvider;
    this.vaultListManagerProvider = vaultListManagerProvider;
    this.vaultServiceProvider = vaultServiceProvider;
  }

  @Override
  public AppLaunchEventHandler get() {
    return newInstance(
        launchEventQueueProvider.get(),
        executorServiceProvider.get(),
        appWindowsProvider.get(),
        vaultListManagerProvider.get(),
        vaultServiceProvider.get());
  }

  public static AppLaunchEventHandler_Factory create(
      Provider<BlockingQueue<AppLaunchEvent>> launchEventQueueProvider,
      Provider<ExecutorService> executorServiceProvider,
      Provider<FxApplicationWindows> appWindowsProvider,
      Provider<VaultListManager> vaultListManagerProvider,
      Provider<VaultService> vaultServiceProvider) {
    return new AppLaunchEventHandler_Factory(
        launchEventQueueProvider,
        executorServiceProvider,
        appWindowsProvider,
        vaultListManagerProvider,
        vaultServiceProvider);
  }

  public static AppLaunchEventHandler newInstance(
      BlockingQueue<AppLaunchEvent> launchEventQueue,
      ExecutorService executorService,
      FxApplicationWindows appWindows,
      VaultListManager vaultListManager,
      VaultService vaultService) {
    return new AppLaunchEventHandler(
        launchEventQueue, executorService, appWindows, vaultListManager, vaultService);
  }
}
