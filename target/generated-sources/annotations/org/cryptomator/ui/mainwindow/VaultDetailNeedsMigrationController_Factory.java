package org.cryptomator.ui.mainwindow;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javafx.beans.property.ObjectProperty;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.cryptomator.common.vaults.Vault;
import org.cryptomator.ui.migration.MigrationComponent;

@ScopeMetadata("org.cryptomator.ui.mainwindow.MainWindowScoped")
@QualifierMetadata
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class VaultDetailNeedsMigrationController_Factory
    implements Factory<VaultDetailNeedsMigrationController> {
  private final Provider<ObjectProperty<Vault>> vaultProvider;

  private final Provider<MigrationComponent.Builder> vaultMigrationWindowProvider;

  public VaultDetailNeedsMigrationController_Factory(
      Provider<ObjectProperty<Vault>> vaultProvider,
      Provider<MigrationComponent.Builder> vaultMigrationWindowProvider) {
    this.vaultProvider = vaultProvider;
    this.vaultMigrationWindowProvider = vaultMigrationWindowProvider;
  }

  @Override
  public VaultDetailNeedsMigrationController get() {
    return newInstance(vaultProvider.get(), vaultMigrationWindowProvider.get());
  }

  public static VaultDetailNeedsMigrationController_Factory create(
      Provider<ObjectProperty<Vault>> vaultProvider,
      Provider<MigrationComponent.Builder> vaultMigrationWindowProvider) {
    return new VaultDetailNeedsMigrationController_Factory(
        vaultProvider, vaultMigrationWindowProvider);
  }

  public static VaultDetailNeedsMigrationController newInstance(
      ObjectProperty<Vault> vault, MigrationComponent.Builder vaultMigrationWindow) {
    return new VaultDetailNeedsMigrationController(vault, vaultMigrationWindow);
  }
}
