package org.cryptomator.ui.common;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("org.cryptomator.ui.fxapp.FxApplicationScoped")
@QualifierMetadata
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class StageFactory_Factory implements Factory<StageFactory> {
  private final Provider<StageInitializer> initializerProvider;

  public StageFactory_Factory(Provider<StageInitializer> initializerProvider) {
    this.initializerProvider = initializerProvider;
  }

  @Override
  public StageFactory get() {
    return newInstance(initializerProvider.get());
  }

  public static StageFactory_Factory create(Provider<StageInitializer> initializerProvider) {
    return new StageFactory_Factory(initializerProvider);
  }

  public static StageFactory newInstance(StageInitializer initializer) {
    return new StageFactory(initializer);
  }
}
