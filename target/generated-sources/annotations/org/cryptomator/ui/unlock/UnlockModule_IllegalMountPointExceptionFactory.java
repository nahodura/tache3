package org.cryptomator.ui.unlock;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javafx.beans.property.ObjectProperty;
import javax.annotation.processing.Generated;
import org.cryptomator.common.mount.IllegalMountPointException;

@ScopeMetadata("org.cryptomator.ui.unlock.UnlockScoped")
@QualifierMetadata("org.cryptomator.ui.unlock.UnlockWindow")
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class UnlockModule_IllegalMountPointExceptionFactory
    implements Factory<ObjectProperty<IllegalMountPointException>> {
  @Override
  public ObjectProperty<IllegalMountPointException> get() {
    return illegalMountPointException();
  }

  public static UnlockModule_IllegalMountPointExceptionFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static ObjectProperty<IllegalMountPointException> illegalMountPointException() {
    return Preconditions.checkNotNullFromProvides(UnlockModule.illegalMountPointException());
  }

  private static final class InstanceHolder {
    private static final UnlockModule_IllegalMountPointExceptionFactory INSTANCE =
        new UnlockModule_IllegalMountPointExceptionFactory();
  }
}
