package org.cryptomator.ui.keyloading.masterkeyfile;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.util.concurrent.CompletableFuture;
import javax.annotation.processing.Generated;

@ScopeMetadata("org.cryptomator.ui.keyloading.masterkeyfile.PassphraseEntryScoped")
@QualifierMetadata
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class PassphraseEntryModule_ProvideResultFactory
    implements Factory<CompletableFuture<PassphraseEntryResult>> {
  @Override
  public CompletableFuture<PassphraseEntryResult> get() {
    return provideResult();
  }

  public static PassphraseEntryModule_ProvideResultFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static CompletableFuture<PassphraseEntryResult> provideResult() {
    return Preconditions.checkNotNullFromProvides(PassphraseEntryModule.provideResult());
  }

  private static final class InstanceHolder {
    private static final PassphraseEntryModule_ProvideResultFactory INSTANCE =
        new PassphraseEntryModule_ProvideResultFactory();
  }
}
