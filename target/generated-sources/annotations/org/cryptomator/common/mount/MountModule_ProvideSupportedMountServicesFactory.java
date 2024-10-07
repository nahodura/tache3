package org.cryptomator.common.mount;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.util.List;
import javax.annotation.processing.Generated;
import org.cryptomator.integrations.mount.MountService;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class MountModule_ProvideSupportedMountServicesFactory
    implements Factory<List<MountService>> {
  @Override
  public List<MountService> get() {
    return provideSupportedMountServices();
  }

  public static MountModule_ProvideSupportedMountServicesFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static List<MountService> provideSupportedMountServices() {
    return Preconditions.checkNotNullFromProvides(MountModule.provideSupportedMountServices());
  }

  private static final class InstanceHolder {
    private static final MountModule_ProvideSupportedMountServicesFactory INSTANCE =
        new MountModule_ProvideSupportedMountServicesFactory();
  }
}
