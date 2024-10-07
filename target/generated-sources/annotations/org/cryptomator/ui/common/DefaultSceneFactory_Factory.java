package org.cryptomator.ui.common;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.cryptomator.common.settings.Settings;

@ScopeMetadata("org.cryptomator.ui.fxapp.FxApplicationScoped")
@QualifierMetadata
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class DefaultSceneFactory_Factory implements Factory<DefaultSceneFactory> {
  private final Provider<Settings> settingsProvider;

  public DefaultSceneFactory_Factory(Provider<Settings> settingsProvider) {
    this.settingsProvider = settingsProvider;
  }

  @Override
  public DefaultSceneFactory get() {
    return newInstance(settingsProvider.get());
  }

  public static DefaultSceneFactory_Factory create(Provider<Settings> settingsProvider) {
    return new DefaultSceneFactory_Factory(settingsProvider);
  }

  public static DefaultSceneFactory newInstance(Settings settings) {
    return new DefaultSceneFactory(settings);
  }
}
