package org.cryptomator.common.mount;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.util.List;
import java.util.Set;
import javafx.beans.value.ObservableValue;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.cryptomator.common.Environment;
import org.cryptomator.common.settings.Settings;
import org.cryptomator.integrations.mount.MountService;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata("javax.inject.Named")
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class Mounter_Factory implements Factory<Mounter> {
  private final Provider<Environment> envProvider;

  private final Provider<Settings> settingsProvider;

  private final Provider<WindowsDriveLetters> driveLettersProvider;

  private final Provider<List<MountService>> mountProvidersProvider;

  private final Provider<Set<MountService>> usedMountServicesProvider;

  private final Provider<ObservableValue<MountService>> defaultMountServiceProvider;

  public Mounter_Factory(
      Provider<Environment> envProvider,
      Provider<Settings> settingsProvider,
      Provider<WindowsDriveLetters> driveLettersProvider,
      Provider<List<MountService>> mountProvidersProvider,
      Provider<Set<MountService>> usedMountServicesProvider,
      Provider<ObservableValue<MountService>> defaultMountServiceProvider) {
    this.envProvider = envProvider;
    this.settingsProvider = settingsProvider;
    this.driveLettersProvider = driveLettersProvider;
    this.mountProvidersProvider = mountProvidersProvider;
    this.usedMountServicesProvider = usedMountServicesProvider;
    this.defaultMountServiceProvider = defaultMountServiceProvider;
  }

  @Override
  public Mounter get() {
    return newInstance(
        envProvider.get(),
        settingsProvider.get(),
        driveLettersProvider.get(),
        mountProvidersProvider.get(),
        usedMountServicesProvider.get(),
        defaultMountServiceProvider.get());
  }

  public static Mounter_Factory create(
      Provider<Environment> envProvider,
      Provider<Settings> settingsProvider,
      Provider<WindowsDriveLetters> driveLettersProvider,
      Provider<List<MountService>> mountProvidersProvider,
      Provider<Set<MountService>> usedMountServicesProvider,
      Provider<ObservableValue<MountService>> defaultMountServiceProvider) {
    return new Mounter_Factory(
        envProvider,
        settingsProvider,
        driveLettersProvider,
        mountProvidersProvider,
        usedMountServicesProvider,
        defaultMountServiceProvider);
  }

  public static Mounter newInstance(
      Environment env,
      Settings settings,
      WindowsDriveLetters driveLetters,
      List<MountService> mountProviders,
      Set<MountService> usedMountServices,
      ObservableValue<MountService> defaultMountService) {
    return new Mounter(
        env, settings, driveLetters, mountProviders, usedMountServices, defaultMountService);
  }
}
