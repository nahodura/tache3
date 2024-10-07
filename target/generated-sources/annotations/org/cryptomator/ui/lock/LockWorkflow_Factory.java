package org.cryptomator.ui.lock;

import dagger.Lazy;
import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicReference;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.cryptomator.common.vaults.Vault;
import org.cryptomator.ui.fxapp.FxApplicationWindows;

@ScopeMetadata
@QualifierMetadata({"org.cryptomator.ui.lock.LockWindow", "org.cryptomator.ui.common.FxmlScene"})
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class LockWorkflow_Factory implements Factory<LockWorkflow> {
  private final Provider<Stage> lockWindowProvider;

  private final Provider<Vault> vaultProvider;

  private final Provider<AtomicReference<CompletableFuture<Boolean>>> forceRetryDecisionProvider;

  private final Provider<Scene> lockForcedSceneProvider;

  private final Provider<Scene> lockFailedSceneProvider;

  private final Provider<FxApplicationWindows> appWindowsProvider;

  public LockWorkflow_Factory(
      Provider<Stage> lockWindowProvider,
      Provider<Vault> vaultProvider,
      Provider<AtomicReference<CompletableFuture<Boolean>>> forceRetryDecisionProvider,
      Provider<Scene> lockForcedSceneProvider,
      Provider<Scene> lockFailedSceneProvider,
      Provider<FxApplicationWindows> appWindowsProvider) {
    this.lockWindowProvider = lockWindowProvider;
    this.vaultProvider = vaultProvider;
    this.forceRetryDecisionProvider = forceRetryDecisionProvider;
    this.lockForcedSceneProvider = lockForcedSceneProvider;
    this.lockFailedSceneProvider = lockFailedSceneProvider;
    this.appWindowsProvider = appWindowsProvider;
  }

  @Override
  public LockWorkflow get() {
    return newInstance(
        lockWindowProvider.get(),
        vaultProvider.get(),
        forceRetryDecisionProvider.get(),
        DoubleCheck.lazy(lockForcedSceneProvider),
        DoubleCheck.lazy(lockFailedSceneProvider),
        appWindowsProvider.get());
  }

  public static LockWorkflow_Factory create(
      Provider<Stage> lockWindowProvider,
      Provider<Vault> vaultProvider,
      Provider<AtomicReference<CompletableFuture<Boolean>>> forceRetryDecisionProvider,
      Provider<Scene> lockForcedSceneProvider,
      Provider<Scene> lockFailedSceneProvider,
      Provider<FxApplicationWindows> appWindowsProvider) {
    return new LockWorkflow_Factory(
        lockWindowProvider,
        vaultProvider,
        forceRetryDecisionProvider,
        lockForcedSceneProvider,
        lockFailedSceneProvider,
        appWindowsProvider);
  }

  public static LockWorkflow newInstance(
      Stage lockWindow,
      Vault vault,
      AtomicReference<CompletableFuture<Boolean>> forceRetryDecision,
      Lazy<Scene> lockForcedScene,
      Lazy<Scene> lockFailedScene,
      FxApplicationWindows appWindows) {
    return new LockWorkflow(
        lockWindow, vault, forceRetryDecision, lockForcedScene, lockFailedScene, appWindows);
  }
}
