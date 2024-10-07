package org.cryptomator.ui.vaultoptions;

import dagger.Lazy;
import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.util.List;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.stage.Stage;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.cryptomator.common.mount.Mounter;
import org.cryptomator.common.mount.WindowsDriveLetters;
import org.cryptomator.common.vaults.Vault;
import org.cryptomator.integrations.mount.MountService;
import org.cryptomator.ui.fxapp.FxApplicationWindows;

@ScopeMetadata("org.cryptomator.ui.vaultoptions.VaultOptionsScoped")
@QualifierMetadata("org.cryptomator.ui.vaultoptions.VaultOptionsWindow")
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class MountOptionsController_Factory implements Factory<MountOptionsController> {
  private final Provider<Stage> windowProvider;

  private final Provider<Vault> vaultProvider;

  private final Provider<WindowsDriveLetters> windowsDriveLettersProvider;

  private final Provider<ResourceBundle> resourceBundleProvider;

  private final Provider<FxApplicationWindows> applicationWindowsProvider;

  private final Provider<Application> applicationProvider;

  private final Provider<List<MountService>> mountProvidersProvider;

  private final Provider<Mounter> mounterProvider;

  private final Provider<ObservableValue<MountService>> defaultMountServiceProvider;

  public MountOptionsController_Factory(
      Provider<Stage> windowProvider,
      Provider<Vault> vaultProvider,
      Provider<WindowsDriveLetters> windowsDriveLettersProvider,
      Provider<ResourceBundle> resourceBundleProvider,
      Provider<FxApplicationWindows> applicationWindowsProvider,
      Provider<Application> applicationProvider,
      Provider<List<MountService>> mountProvidersProvider,
      Provider<Mounter> mounterProvider,
      Provider<ObservableValue<MountService>> defaultMountServiceProvider) {
    this.windowProvider = windowProvider;
    this.vaultProvider = vaultProvider;
    this.windowsDriveLettersProvider = windowsDriveLettersProvider;
    this.resourceBundleProvider = resourceBundleProvider;
    this.applicationWindowsProvider = applicationWindowsProvider;
    this.applicationProvider = applicationProvider;
    this.mountProvidersProvider = mountProvidersProvider;
    this.mounterProvider = mounterProvider;
    this.defaultMountServiceProvider = defaultMountServiceProvider;
  }

  @Override
  public MountOptionsController get() {
    return newInstance(
        windowProvider.get(),
        vaultProvider.get(),
        windowsDriveLettersProvider.get(),
        resourceBundleProvider.get(),
        applicationWindowsProvider.get(),
        DoubleCheck.lazy(applicationProvider),
        mountProvidersProvider.get(),
        mounterProvider.get(),
        defaultMountServiceProvider.get());
  }

  public static MountOptionsController_Factory create(
      Provider<Stage> windowProvider,
      Provider<Vault> vaultProvider,
      Provider<WindowsDriveLetters> windowsDriveLettersProvider,
      Provider<ResourceBundle> resourceBundleProvider,
      Provider<FxApplicationWindows> applicationWindowsProvider,
      Provider<Application> applicationProvider,
      Provider<List<MountService>> mountProvidersProvider,
      Provider<Mounter> mounterProvider,
      Provider<ObservableValue<MountService>> defaultMountServiceProvider) {
    return new MountOptionsController_Factory(
        windowProvider,
        vaultProvider,
        windowsDriveLettersProvider,
        resourceBundleProvider,
        applicationWindowsProvider,
        applicationProvider,
        mountProvidersProvider,
        mounterProvider,
        defaultMountServiceProvider);
  }

  public static MountOptionsController newInstance(
      Stage window,
      Vault vault,
      WindowsDriveLetters windowsDriveLetters,
      ResourceBundle resourceBundle,
      FxApplicationWindows applicationWindows,
      Lazy<Application> application,
      List<MountService> mountProviders,
      Mounter mounter,
      ObservableValue<MountService> defaultMountService) {
    return new MountOptionsController(
        window,
        vault,
        windowsDriveLetters,
        resourceBundle,
        applicationWindows,
        application,
        mountProviders,
        mounter,
        defaultMountService);
  }
}
