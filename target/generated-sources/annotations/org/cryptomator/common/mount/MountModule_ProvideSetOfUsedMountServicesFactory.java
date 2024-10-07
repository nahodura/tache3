package org.cryptomator.common.mount;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.cryptomator.integrations.mount.MountService;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata("javax.inject.Named")
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class MountModule_ProvideSetOfUsedMountServicesFactory
    implements Factory<Set<MountService>> {
  @Override
  public Set<MountService> get() {
    return provideSetOfUsedMountServices();
  }

  public static MountModule_ProvideSetOfUsedMountServicesFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static Set<MountService> provideSetOfUsedMountServices() {
    return Preconditions.checkNotNullFromProvides(MountModule.provideSetOfUsedMountServices());
  }

  private static final class InstanceHolder {
    private static final MountModule_ProvideSetOfUsedMountServicesFactory INSTANCE =
        new MountModule_ProvideSetOfUsedMountServicesFactory();
  }
}
