package org.cryptomator.ui.mainwindow;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.cryptomator.common.vaults.Vault;

@ScopeMetadata("org.cryptomator.ui.mainwindow.MainWindowScoped")
@QualifierMetadata
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class WelcomeController_Factory implements Factory<WelcomeController> {
  private final Provider<Application> applicationProvider;

  private final Provider<ObservableList<Vault>> vaultsProvider;

  public WelcomeController_Factory(
      Provider<Application> applicationProvider, Provider<ObservableList<Vault>> vaultsProvider) {
    this.applicationProvider = applicationProvider;
    this.vaultsProvider = vaultsProvider;
  }

  @Override
  public WelcomeController get() {
    return newInstance(applicationProvider.get(), vaultsProvider.get());
  }

  public static WelcomeController_Factory create(
      Provider<Application> applicationProvider, Provider<ObservableList<Vault>> vaultsProvider) {
    return new WelcomeController_Factory(applicationProvider, vaultsProvider);
  }

  public static WelcomeController newInstance(
      Application application, ObservableList<Vault> vaults) {
    return new WelcomeController(application, vaults);
  }
}
