package org.cryptomator.launcher;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.util.ResourceBundle;
import javax.annotation.processing.Generated;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class CryptomatorModule_ProvideLocalizationFactory implements Factory<ResourceBundle> {
  @Override
  public ResourceBundle get() {
    return provideLocalization();
  }

  public static CryptomatorModule_ProvideLocalizationFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static ResourceBundle provideLocalization() {
    return Preconditions.checkNotNullFromProvides(CryptomatorModule.provideLocalization());
  }

  private static final class InstanceHolder {
    private static final CryptomatorModule_ProvideLocalizationFactory INSTANCE =
        new CryptomatorModule_ProvideLocalizationFactory();
  }
}
