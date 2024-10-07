package org.cryptomator.common.mount;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.util.List;
import javafx.beans.value.ObservableValue;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.cryptomator.common.settings.Settings;
import org.cryptomator.integrations.mount.MountService;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class MountModule_ProvideDefaultMountServiceFactory
    implements Factory<ObservableValue<MountService>> {
  private final Provider<List<MountService>> mountProvidersProvider;

  private final Provider<Settings> settingsProvider;

  public MountModule_ProvideDefaultMountServiceFactory(
      Provider<List<MountService>> mountProvidersProvider, Provider<Settings> settingsProvider) {
    this.mountProvidersProvider = mountProvidersProvider;
    this.settingsProvider = settingsProvider;
  }

  @Override
  public ObservableValue<MountService> get() {
    return provideDefaultMountService(mountProvidersProvider.get(), settingsProvider.get());
  }

  public static MountModule_ProvideDefaultMountServiceFactory create(
      Provider<List<MountService>> mountProvidersProvider, Provider<Settings> settingsProvider) {
    return new MountModule_ProvideDefaultMountServiceFactory(
        mountProvidersProvider, settingsProvider);
  }

  public static ObservableValue<MountService> provideDefaultMountService(
      List<MountService> mountProviders, Settings settings) {
    return Preconditions.checkNotNullFromProvides(
        MountModule.provideDefaultMountService(mountProviders, settings));
  }
}
