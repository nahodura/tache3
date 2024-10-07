package org.cryptomator.ui.health;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.processing.Generated;
import org.cryptomator.cryptofs.VaultConfig;

@ScopeMetadata("org.cryptomator.ui.health.HealthCheckScoped")
@QualifierMetadata
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class HealthCheckModule_ProvideVaultConfigRefFactory
    implements Factory<AtomicReference<VaultConfig>> {
  @Override
  public AtomicReference<VaultConfig> get() {
    return provideVaultConfigRef();
  }

  public static HealthCheckModule_ProvideVaultConfigRefFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static AtomicReference<VaultConfig> provideVaultConfigRef() {
    return Preconditions.checkNotNullFromProvides(HealthCheckModule.provideVaultConfigRef());
  }

  private static final class InstanceHolder {
    private static final HealthCheckModule_ProvideVaultConfigRefFactory INSTANCE =
        new HealthCheckModule_ProvideVaultConfigRefFactory();
  }
}
