package org.cryptomator.ui.health;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.processing.Generated;
import org.cryptomator.cryptolib.api.Masterkey;

@ScopeMetadata("org.cryptomator.ui.health.HealthCheckScoped")
@QualifierMetadata
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class HealthCheckModule_ProvideMasterkeyRefFactory
    implements Factory<AtomicReference<Masterkey>> {
  @Override
  public AtomicReference<Masterkey> get() {
    return provideMasterkeyRef();
  }

  public static HealthCheckModule_ProvideMasterkeyRefFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static AtomicReference<Masterkey> provideMasterkeyRef() {
    return Preconditions.checkNotNullFromProvides(HealthCheckModule.provideMasterkeyRef());
  }

  private static final class InstanceHolder {
    private static final HealthCheckModule_ProvideMasterkeyRefFactory INSTANCE =
        new HealthCheckModule_ProvideMasterkeyRefFactory();
  }
}
