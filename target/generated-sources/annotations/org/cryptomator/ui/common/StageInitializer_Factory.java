package org.cryptomator.ui.common;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

@ScopeMetadata("org.cryptomator.ui.fxapp.FxApplicationScoped")
@QualifierMetadata
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class StageInitializer_Factory implements Factory<StageInitializer> {
  @Override
  public StageInitializer get() {
    return newInstance();
  }

  public static StageInitializer_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static StageInitializer newInstance() {
    return new StageInitializer();
  }

  private static final class InstanceHolder {
    private static final StageInitializer_Factory INSTANCE = new StageInitializer_Factory();
  }
}
