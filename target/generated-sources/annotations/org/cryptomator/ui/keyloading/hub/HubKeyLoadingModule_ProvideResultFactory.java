package org.cryptomator.ui.keyloading.hub;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.util.concurrent.CompletableFuture;
import javax.annotation.processing.Generated;

@ScopeMetadata("org.cryptomator.ui.keyloading.KeyLoadingScoped")
@QualifierMetadata
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class HubKeyLoadingModule_ProvideResultFactory
    implements Factory<CompletableFuture<ReceivedKey>> {
  @Override
  public CompletableFuture<ReceivedKey> get() {
    return provideResult();
  }

  public static HubKeyLoadingModule_ProvideResultFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static CompletableFuture<ReceivedKey> provideResult() {
    return Preconditions.checkNotNullFromProvides(HubKeyLoadingModule.provideResult());
  }

  private static final class InstanceHolder {
    private static final HubKeyLoadingModule_ProvideResultFactory INSTANCE =
        new HubKeyLoadingModule_ProvideResultFactory();
  }
}
