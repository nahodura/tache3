package org.cryptomator.ui.lock;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.processing.Generated;

@ScopeMetadata("org.cryptomator.ui.lock.LockScoped")
@QualifierMetadata
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class LockModule_ProvideForceRetryDecisionRefFactory
    implements Factory<AtomicReference<CompletableFuture<Boolean>>> {
  @Override
  public AtomicReference<CompletableFuture<Boolean>> get() {
    return provideForceRetryDecisionRef();
  }

  public static LockModule_ProvideForceRetryDecisionRefFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static AtomicReference<CompletableFuture<Boolean>> provideForceRetryDecisionRef() {
    return Preconditions.checkNotNullFromProvides(LockModule.provideForceRetryDecisionRef());
  }

  private static final class InstanceHolder {
    private static final LockModule_ProvideForceRetryDecisionRefFactory INSTANCE =
        new LockModule_ProvideForceRetryDecisionRefFactory();
  }
}
