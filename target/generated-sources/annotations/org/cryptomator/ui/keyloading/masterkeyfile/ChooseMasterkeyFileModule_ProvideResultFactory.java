package org.cryptomator.ui.keyloading.masterkeyfile;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.nio.file.Path;
import java.util.concurrent.CompletableFuture;
import javax.annotation.processing.Generated;

@ScopeMetadata("org.cryptomator.ui.keyloading.masterkeyfile.ChooseMasterkeyFileScoped")
@QualifierMetadata
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class ChooseMasterkeyFileModule_ProvideResultFactory
    implements Factory<CompletableFuture<Path>> {
  @Override
  public CompletableFuture<Path> get() {
    return provideResult();
  }

  public static ChooseMasterkeyFileModule_ProvideResultFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static CompletableFuture<Path> provideResult() {
    return Preconditions.checkNotNullFromProvides(ChooseMasterkeyFileModule.provideResult());
  }

  private static final class InstanceHolder {
    private static final ChooseMasterkeyFileModule_ProvideResultFactory INSTANCE =
        new ChooseMasterkeyFileModule_ProvideResultFactory();
  }
}
