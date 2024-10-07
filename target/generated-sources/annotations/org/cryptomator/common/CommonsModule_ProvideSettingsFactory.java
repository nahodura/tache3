package org.cryptomator.common;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.cryptomator.common.settings.Settings;
import org.cryptomator.common.settings.SettingsProvider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class CommonsModule_ProvideSettingsFactory implements Factory<Settings> {
  private final Provider<SettingsProvider> settingsProvider;

  public CommonsModule_ProvideSettingsFactory(Provider<SettingsProvider> settingsProvider) {
    this.settingsProvider = settingsProvider;
  }

  @Override
  public Settings get() {
    return provideSettings(settingsProvider.get());
  }

  public static CommonsModule_ProvideSettingsFactory create(
      Provider<SettingsProvider> settingsProvider) {
    return new CommonsModule_ProvideSettingsFactory(settingsProvider);
  }

  public static Settings provideSettings(SettingsProvider settingsProvider) {
    return Preconditions.checkNotNullFromProvides(CommonsModule.provideSettings(settingsProvider));
  }
}
