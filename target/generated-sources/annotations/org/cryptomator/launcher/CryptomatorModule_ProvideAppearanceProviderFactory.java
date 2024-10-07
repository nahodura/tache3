package org.cryptomator.launcher;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.util.Optional;
import javax.annotation.processing.Generated;
import org.cryptomator.integrations.uiappearance.UiAppearanceProvider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class CryptomatorModule_ProvideAppearanceProviderFactory
    implements Factory<Optional<UiAppearanceProvider>> {
  @Override
  public Optional<UiAppearanceProvider> get() {
    return provideAppearanceProvider();
  }

  public static CryptomatorModule_ProvideAppearanceProviderFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static Optional<UiAppearanceProvider> provideAppearanceProvider() {
    return Preconditions.checkNotNullFromProvides(CryptomatorModule.provideAppearanceProvider());
  }

  private static final class InstanceHolder {
    private static final CryptomatorModule_ProvideAppearanceProviderFactory INSTANCE =
        new CryptomatorModule_ProvideAppearanceProviderFactory();
  }
}
