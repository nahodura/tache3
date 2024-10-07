package org.cryptomator.common.vaults;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.cryptomator.common.settings.Settings;
import org.cryptomator.integrations.mount.MountService;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class VaultListManager_Factory implements Factory<VaultListManager> {
  private final Provider<ObservableList<Vault>> vaultListProvider;

  private final Provider<AutoLocker> autoLockerProvider;

  private final Provider<List<MountService>> mountServicesProvider;

  private final Provider<VaultComponent.Factory> vaultComponentFactoryProvider;

  private final Provider<ResourceBundle> resourceBundleProvider;

  private final Provider<Settings> settingsProvider;

  public VaultListManager_Factory(
      Provider<ObservableList<Vault>> vaultListProvider,
      Provider<AutoLocker> autoLockerProvider,
      Provider<List<MountService>> mountServicesProvider,
      Provider<VaultComponent.Factory> vaultComponentFactoryProvider,
      Provider<ResourceBundle> resourceBundleProvider,
      Provider<Settings> settingsProvider) {
    this.vaultListProvider = vaultListProvider;
    this.autoLockerProvider = autoLockerProvider;
    this.mountServicesProvider = mountServicesProvider;
    this.vaultComponentFactoryProvider = vaultComponentFactoryProvider;
    this.resourceBundleProvider = resourceBundleProvider;
    this.settingsProvider = settingsProvider;
  }

  @Override
  public VaultListManager get() {
    return newInstance(
        vaultListProvider.get(),
        autoLockerProvider.get(),
        mountServicesProvider.get(),
        vaultComponentFactoryProvider.get(),
        resourceBundleProvider.get(),
        settingsProvider.get());
  }

  public static VaultListManager_Factory create(
      Provider<ObservableList<Vault>> vaultListProvider,
      Provider<AutoLocker> autoLockerProvider,
      Provider<List<MountService>> mountServicesProvider,
      Provider<VaultComponent.Factory> vaultComponentFactoryProvider,
      Provider<ResourceBundle> resourceBundleProvider,
      Provider<Settings> settingsProvider) {
    return new VaultListManager_Factory(
        vaultListProvider,
        autoLockerProvider,
        mountServicesProvider,
        vaultComponentFactoryProvider,
        resourceBundleProvider,
        settingsProvider);
  }

  public static VaultListManager newInstance(
      ObservableList<Vault> vaultList,
      AutoLocker autoLocker,
      List<MountService> mountServices,
      VaultComponent.Factory vaultComponentFactory,
      ResourceBundle resourceBundle,
      Settings settings) {
    return new VaultListManager(
        vaultList, autoLocker, mountServices, vaultComponentFactory, resourceBundle, settings);
  }
}
