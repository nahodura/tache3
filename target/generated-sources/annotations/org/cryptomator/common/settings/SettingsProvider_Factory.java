package org.cryptomator.common.settings;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.cryptomator.common.Environment;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class SettingsProvider_Factory implements Factory<SettingsProvider> {
  private final Provider<Environment> envProvider;

  private final Provider<ScheduledExecutorService> schedulerProvider;

  public SettingsProvider_Factory(
      Provider<Environment> envProvider, Provider<ScheduledExecutorService> schedulerProvider) {
    this.envProvider = envProvider;
    this.schedulerProvider = schedulerProvider;
  }

  @Override
  public SettingsProvider get() {
    return newInstance(envProvider.get(), schedulerProvider.get());
  }

  public static SettingsProvider_Factory create(
      Provider<Environment> envProvider, Provider<ScheduledExecutorService> schedulerProvider) {
    return new SettingsProvider_Factory(envProvider, schedulerProvider);
  }

  public static SettingsProvider newInstance(Environment env, ScheduledExecutorService scheduler) {
    return new SettingsProvider(env, scheduler);
  }
}
