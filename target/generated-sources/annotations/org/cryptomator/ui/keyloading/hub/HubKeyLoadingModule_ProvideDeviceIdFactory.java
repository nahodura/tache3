package org.cryptomator.ui.keyloading.hub;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.cryptomator.common.settings.DeviceKey;

@ScopeMetadata("org.cryptomator.ui.keyloading.KeyLoadingScoped")
@QualifierMetadata("javax.inject.Named")
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class HubKeyLoadingModule_ProvideDeviceIdFactory implements Factory<String> {
  private final Provider<DeviceKey> deviceKeyProvider;

  public HubKeyLoadingModule_ProvideDeviceIdFactory(Provider<DeviceKey> deviceKeyProvider) {
    this.deviceKeyProvider = deviceKeyProvider;
  }

  @Override
  public String get() {
    return provideDeviceId(deviceKeyProvider.get());
  }

  public static HubKeyLoadingModule_ProvideDeviceIdFactory create(
      Provider<DeviceKey> deviceKeyProvider) {
    return new HubKeyLoadingModule_ProvideDeviceIdFactory(deviceKeyProvider);
  }

  public static String provideDeviceId(DeviceKey deviceKey) {
    return Preconditions.checkNotNullFromProvides(HubKeyLoadingModule.provideDeviceId(deviceKey));
  }
}
