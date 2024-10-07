package org.cryptomator.common;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.util.Optional;
import javax.annotation.processing.Generated;
import org.cryptomator.integrations.revealpath.RevealPathService;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class CommonsModule_ProvideRevealPathServiceFactory
    implements Factory<Optional<RevealPathService>> {
  @Override
  public Optional<RevealPathService> get() {
    return provideRevealPathService();
  }

  public static CommonsModule_ProvideRevealPathServiceFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static Optional<RevealPathService> provideRevealPathService() {
    return Preconditions.checkNotNullFromProvides(CommonsModule.provideRevealPathService());
  }

  private static final class InstanceHolder {
    private static final CommonsModule_ProvideRevealPathServiceFactory INSTANCE =
        new CommonsModule_ProvideRevealPathServiceFactory();
  }
}
