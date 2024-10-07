package org.cryptomator.ui.migration;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javafx.application.Application;
import javafx.stage.Stage;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.cryptomator.common.vaults.Vault;

@ScopeMetadata
@QualifierMetadata("org.cryptomator.ui.migration.MigrationWindow")
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class MigrationImpossibleController_Factory
    implements Factory<MigrationImpossibleController> {
  private final Provider<Application> applicationProvider;

  private final Provider<Stage> windowProvider;

  private final Provider<Vault> vaultProvider;

  public MigrationImpossibleController_Factory(
      Provider<Application> applicationProvider,
      Provider<Stage> windowProvider,
      Provider<Vault> vaultProvider) {
    this.applicationProvider = applicationProvider;
    this.windowProvider = windowProvider;
    this.vaultProvider = vaultProvider;
  }

  @Override
  public MigrationImpossibleController get() {
    return newInstance(applicationProvider.get(), windowProvider.get(), vaultProvider.get());
  }

  public static MigrationImpossibleController_Factory create(
      Provider<Application> applicationProvider,
      Provider<Stage> windowProvider,
      Provider<Vault> vaultProvider) {
    return new MigrationImpossibleController_Factory(
        applicationProvider, windowProvider, vaultProvider);
  }

  public static MigrationImpossibleController newInstance(
      Application application, Stage window, Vault vault) {
    return new MigrationImpossibleController(application, window, vault);
  }
}
