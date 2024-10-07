package org.cryptomator.ui.lock;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicReference;
import javafx.stage.Stage;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.cryptomator.common.vaults.Vault;

@ScopeMetadata("org.cryptomator.ui.lock.LockScoped")
@QualifierMetadata("org.cryptomator.ui.lock.LockWindow")
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class LockForcedController_Factory implements Factory<LockForcedController> {
  private final Provider<Stage> windowProvider;

  private final Provider<Vault> vaultProvider;

  private final Provider<AtomicReference<CompletableFuture<Boolean>>> forceRetryDecisionProvider;

  public LockForcedController_Factory(
      Provider<Stage> windowProvider,
      Provider<Vault> vaultProvider,
      Provider<AtomicReference<CompletableFuture<Boolean>>> forceRetryDecisionProvider) {
    this.windowProvider = windowProvider;
    this.vaultProvider = vaultProvider;
    this.forceRetryDecisionProvider = forceRetryDecisionProvider;
  }

  @Override
  public LockForcedController get() {
    return newInstance(windowProvider.get(), vaultProvider.get(), forceRetryDecisionProvider.get());
  }

  public static LockForcedController_Factory create(
      Provider<Stage> windowProvider,
      Provider<Vault> vaultProvider,
      Provider<AtomicReference<CompletableFuture<Boolean>>> forceRetryDecisionProvider) {
    return new LockForcedController_Factory(
        windowProvider, vaultProvider, forceRetryDecisionProvider);
  }

  public static LockForcedController newInstance(
      Stage window, Vault vault, AtomicReference<CompletableFuture<Boolean>> forceRetryDecision) {
    return new LockForcedController(window, vault, forceRetryDecision);
  }
}
