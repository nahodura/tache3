package org.cryptomator.launcher;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.util.Optional;
import javax.annotation.processing.Generated;
import org.cryptomator.integrations.autostart.AutoStartProvider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class CryptomatorModule_ProvideAutostartProviderFactory
    implements Factory<Optional<AutoStartProvider>> {
  @Override
  public Optional<AutoStartProvider> get() {
    return provideAutostartProvider();
  }

  public static CryptomatorModule_ProvideAutostartProviderFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static Optional<AutoStartProvider> provideAutostartProvider() {
    return Preconditions.checkNotNullFromProvides(CryptomatorModule.provideAutostartProvider());
  }

  private static final class InstanceHolder {
    private static final CryptomatorModule_ProvideAutostartProviderFactory INSTANCE =
        new CryptomatorModule_ProvideAutostartProviderFactory();
  }
}
