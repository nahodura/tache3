package org.cryptomator.common;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class ShutdownHook_Factory implements Factory<ShutdownHook> {
  @Override
  public ShutdownHook get() {
    return newInstance();
  }

  public static ShutdownHook_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static ShutdownHook newInstance() {
    return new ShutdownHook();
  }

  private static final class InstanceHolder {
    private static final ShutdownHook_Factory INSTANCE = new ShutdownHook_Factory();
  }
}
