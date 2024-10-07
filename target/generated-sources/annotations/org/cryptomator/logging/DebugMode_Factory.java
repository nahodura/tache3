package org.cryptomator.logging;

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
public final class DebugMode_Factory implements Factory<DebugMode> {
  private final Provider<Settings> settingsProvider;

  public DebugMode_Factory(Provider<Settings> settingsProvider) {
    this.settingsProvider = settingsProvider;
  }

  @Override
  public DebugMode get() {
    return newInstance(settingsProvider.get());
  }

  public static DebugMode_Factory create(Provider<Settings> settingsProvider) {
    return new DebugMode_Factory(settingsProvider);
  }

  public static DebugMode newInstance(Settings settings) {
    return new DebugMode(settings);
  }
}
