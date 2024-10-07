package org.cryptomator.launcher;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.util.Optional;
import javax.annotation.processing.Generated;
import org.cryptomator.integrations.tray.TrayIntegrationProvider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class CryptomatorModule_ProvideTrayIntegrationProviderFactory
    implements Factory<Optional<TrayIntegrationProvider>> {
  @Override
  public Optional<TrayIntegrationProvider> get() {
    return provideTrayIntegrationProvider();
  }

  public static CryptomatorModule_ProvideTrayIntegrationProviderFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static Optional<TrayIntegrationProvider> provideTrayIntegrationProvider() {
    return Preconditions.checkNotNullFromProvides(
        CryptomatorModule.provideTrayIntegrationProvider());
  }

  private static final class InstanceHolder {
    private static final CryptomatorModule_ProvideTrayIntegrationProviderFactory INSTANCE =
        new CryptomatorModule_ProvideTrayIntegrationProviderFactory();
  }
}
