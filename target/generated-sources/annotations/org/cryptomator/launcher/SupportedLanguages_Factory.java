package org.cryptomator.launcher;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.cryptomator.common.settings.Settings;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class SupportedLanguages_Factory implements Factory<SupportedLanguages> {
  private final Provider<Settings> settingsProvider;

  public SupportedLanguages_Factory(Provider<Settings> settingsProvider) {
    this.settingsProvider = settingsProvider;
  }

  @Override
  public SupportedLanguages get() {
    return newInstance(settingsProvider.get());
  }

  public static SupportedLanguages_Factory create(Provider<Settings> settingsProvider) {
    return new SupportedLanguages_Factory(settingsProvider);
  }

  public static SupportedLanguages newInstance(Settings settings) {
    return new SupportedLanguages(settings);
  }
}
