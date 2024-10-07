package org.cryptomator.common.vaults;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.util.concurrent.ScheduledExecutorService;
import javafx.collections.ObservableList;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class AutoLocker_Factory implements Factory<AutoLocker> {
  private final Provider<ScheduledExecutorService> schedulerProvider;

  private final Provider<ObservableList<Vault>> vaultListProvider;

  public AutoLocker_Factory(
      Provider<ScheduledExecutorService> schedulerProvider,
      Provider<ObservableList<Vault>> vaultListProvider) {
    this.schedulerProvider = schedulerProvider;
    this.vaultListProvider = vaultListProvider;
  }

  @Override
  public AutoLocker get() {
    return newInstance(schedulerProvider.get(), vaultListProvider.get());
  }

  public static AutoLocker_Factory create(
      Provider<ScheduledExecutorService> schedulerProvider,
      Provider<ObservableList<Vault>> vaultListProvider) {
    return new AutoLocker_Factory(schedulerProvider, vaultListProvider);
  }

  public static AutoLocker newInstance(
      ScheduledExecutorService scheduler, ObservableList<Vault> vaultList) {
    return new AutoLocker(scheduler, vaultList);
  }
}
