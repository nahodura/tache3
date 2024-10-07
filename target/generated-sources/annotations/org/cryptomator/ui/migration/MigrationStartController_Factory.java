package org.cryptomator.ui.migration;

import dagger.Lazy;
import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.cryptomator.common.vaults.Vault;

@ScopeMetadata("org.cryptomator.ui.migration.MigrationScoped")
@QualifierMetadata({
  "org.cryptomator.ui.migration.MigrationWindow",
  "org.cryptomator.ui.common.FxmlScene"
})
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class MigrationStartController_Factory implements Factory<MigrationStartController> {
  private final Provider<Stage> windowProvider;

  private final Provider<Vault> vaultProvider;

  private final Provider<Scene> runMigrationSceneProvider;

  public MigrationStartController_Factory(
      Provider<Stage> windowProvider,
      Provider<Vault> vaultProvider,
      Provider<Scene> runMigrationSceneProvider) {
    this.windowProvider = windowProvider;
    this.vaultProvider = vaultProvider;
    this.runMigrationSceneProvider = runMigrationSceneProvider;
  }

  @Override
  public MigrationStartController get() {
    return newInstance(
        windowProvider.get(), vaultProvider.get(), DoubleCheck.lazy(runMigrationSceneProvider));
  }

  public static MigrationStartController_Factory create(
      Provider<Stage> windowProvider,
      Provider<Vault> vaultProvider,
      Provider<Scene> runMigrationSceneProvider) {
    return new MigrationStartController_Factory(
        windowProvider, vaultProvider, runMigrationSceneProvider);
  }

  public static MigrationStartController newInstance(
      Stage window, Vault vault, Lazy<Scene> runMigrationScene) {
    return new MigrationStartController(window, vault, runMigrationScene);
  }
}
