package org.cryptomator.ui.fxapp;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.util.concurrent.ScheduledExecutorService;
import javafx.collections.ObservableList;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.cryptomator.common.vaults.Vault;

@ScopeMetadata("org.cryptomator.ui.fxapp.FxApplicationScoped")
@QualifierMetadata
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class AutoUnlocker_Factory implements Factory<AutoUnlocker> {
  private final Provider<ObservableList<Vault>> vaultsProvider;

  private final Provider<FxApplicationWindows> appWindowsProvider;

  private final Provider<ScheduledExecutorService> schedulerProvider;

  public AutoUnlocker_Factory(
      Provider<ObservableList<Vault>> vaultsProvider,
      Provider<FxApplicationWindows> appWindowsProvider,
      Provider<ScheduledExecutorService> schedulerProvider) {
    this.vaultsProvider = vaultsProvider;
    this.appWindowsProvider = appWindowsProvider;
    this.schedulerProvider = schedulerProvider;
  }

  @Override
  public AutoUnlocker get() {
    return newInstance(vaultsProvider.get(), appWindowsProvider.get(), schedulerProvider.get());
  }

  public static AutoUnlocker_Factory create(
      Provider<ObservableList<Vault>> vaultsProvider,
      Provider<FxApplicationWindows> appWindowsProvider,
      Provider<ScheduledExecutorService> schedulerProvider) {
    return new AutoUnlocker_Factory(vaultsProvider, appWindowsProvider, schedulerProvider);
  }

  public static AutoUnlocker newInstance(
      ObservableList<Vault> vaults,
      FxApplicationWindows appWindows,
      ScheduledExecutorService scheduler) {
    return new AutoUnlocker(vaults, appWindows, scheduler);
  }
}
