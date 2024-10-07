package org.cryptomator.common.mount;

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
public final class WindowsDriveLetters_Factory implements Factory<WindowsDriveLetters> {
  @Override
  public WindowsDriveLetters get() {
    return newInstance();
  }

  public static WindowsDriveLetters_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static WindowsDriveLetters newInstance() {
    return new WindowsDriveLetters();
  }

  private static final class InstanceHolder {
    private static final WindowsDriveLetters_Factory INSTANCE = new WindowsDriveLetters_Factory();
  }
}
