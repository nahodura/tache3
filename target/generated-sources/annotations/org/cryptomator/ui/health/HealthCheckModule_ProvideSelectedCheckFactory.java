package org.cryptomator.ui.health;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javafx.beans.property.ObjectProperty;
import javax.annotation.processing.Generated;

@ScopeMetadata("org.cryptomator.ui.health.HealthCheckScoped")
@QualifierMetadata
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class HealthCheckModule_ProvideSelectedCheckFactory
    implements Factory<ObjectProperty<Check>> {
  @Override
  public ObjectProperty<Check> get() {
    return provideSelectedCheck();
  }

  public static HealthCheckModule_ProvideSelectedCheckFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static ObjectProperty<Check> provideSelectedCheck() {
    return Preconditions.checkNotNullFromProvides(HealthCheckModule.provideSelectedCheck());
  }

  private static final class InstanceHolder {
    private static final HealthCheckModule_ProvideSelectedCheckFactory INSTANCE =
        new HealthCheckModule_ProvideSelectedCheckFactory();
  }
}
