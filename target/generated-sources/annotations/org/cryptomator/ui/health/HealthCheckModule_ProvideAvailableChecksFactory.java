package org.cryptomator.ui.health;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.util.List;
import javax.annotation.processing.Generated;

@ScopeMetadata("org.cryptomator.ui.health.HealthCheckScoped")
@QualifierMetadata
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class HealthCheckModule_ProvideAvailableChecksFactory implements Factory<List<Check>> {
  @Override
  public List<Check> get() {
    return provideAvailableChecks();
  }

  public static HealthCheckModule_ProvideAvailableChecksFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static List<Check> provideAvailableChecks() {
    return Preconditions.checkNotNullFromProvides(HealthCheckModule.provideAvailableChecks());
  }

  private static final class InstanceHolder {
    private static final HealthCheckModule_ProvideAvailableChecksFactory INSTANCE =
        new HealthCheckModule_ProvideAvailableChecksFactory();
  }
}
