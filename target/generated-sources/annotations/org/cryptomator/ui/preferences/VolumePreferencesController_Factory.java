package org.cryptomator.ui.preferences;

import dagger.Lazy;
import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.util.List;
import java.util.ResourceBundle;
import javafx.application.Application;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.cryptomator.common.settings.Settings;
import org.cryptomator.integrations.mount.MountService;

@ScopeMetadata("org.cryptomator.ui.preferences.PreferencesScoped")
@QualifierMetadata
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class VolumePreferencesController_Factory
    implements Factory<VolumePreferencesController> {
  private final Provider<Settings> settingsProvider;

  private final Provider<Application> applicationProvider;

  private final Provider<List<MountService>> mountProvidersProvider;

  private final Provider<ResourceBundle> resourceBundleProvider;

  public VolumePreferencesController_Factory(
      Provider<Settings> settingsProvider,
      Provider<Application> applicationProvider,
      Provider<List<MountService>> mountProvidersProvider,
      Provider<ResourceBundle> resourceBundleProvider) {
    this.settingsProvider = settingsProvider;
    this.applicationProvider = applicationProvider;
    this.mountProvidersProvider = mountProvidersProvider;
    this.resourceBundleProvider = resourceBundleProvider;
  }

  @Override
  public VolumePreferencesController get() {
    return newInstance(
        settingsProvider.get(),
        DoubleCheck.lazy(applicationProvider),
        mountProvidersProvider.get(),
        resourceBundleProvider.get());
  }

  public static VolumePreferencesController_Factory create(
      Provider<Settings> settingsProvider,
      Provider<Application> applicationProvider,
      Provider<List<MountService>> mountProvidersProvider,
      Provider<ResourceBundle> resourceBundleProvider) {
    return new VolumePreferencesController_Factory(
        settingsProvider, applicationProvider, mountProvidersProvider, resourceBundleProvider);
  }

  public static VolumePreferencesController newInstance(
      Settings settings,
      Lazy<Application> application,
      List<MountService> mountProviders,
      ResourceBundle resourceBundle) {
    return new VolumePreferencesController(settings, application, mountProviders, resourceBundle);
  }
}
