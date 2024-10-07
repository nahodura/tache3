package org.cryptomator.ui.mainwindow;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javafx.application.Application;
import javafx.beans.property.ObjectProperty;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.cryptomator.common.vaults.Vault;

@ScopeMetadata("org.cryptomator.ui.mainwindow.MainWindowScoped")
@QualifierMetadata
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class VaultDetailController_Factory implements Factory<VaultDetailController> {
  private final Provider<ObjectProperty<Vault>> vaultProvider;

  private final Provider<Application> applicationProvider;

  public VaultDetailController_Factory(
      Provider<ObjectProperty<Vault>> vaultProvider, Provider<Application> applicationProvider) {
    this.vaultProvider = vaultProvider;
    this.applicationProvider = applicationProvider;
  }

  @Override
  public VaultDetailController get() {
    return newInstance(vaultProvider.get(), applicationProvider.get());
  }

  public static VaultDetailController_Factory create(
      Provider<ObjectProperty<Vault>> vaultProvider, Provider<Application> applicationProvider) {
    return new VaultDetailController_Factory(vaultProvider, applicationProvider);
  }

  public static VaultDetailController newInstance(
      ObjectProperty<Vault> vault, Application application) {
    return new VaultDetailController(vault, application);
  }
}
