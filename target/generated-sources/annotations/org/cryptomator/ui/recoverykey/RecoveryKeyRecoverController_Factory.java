package org.cryptomator.ui.recoverykey;

import dagger.Lazy;
import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.util.ResourceBundle;
import javafx.beans.property.StringProperty;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.cryptomator.common.vaults.Vault;

@ScopeMetadata("org.cryptomator.ui.recoverykey.RecoveryKeyScoped")
@QualifierMetadata({
  "org.cryptomator.ui.recoverykey.RecoveryKeyWindow",
  "org.cryptomator.ui.common.FxmlScene"
})
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class RecoveryKeyRecoverController_Factory
    implements Factory<RecoveryKeyRecoverController> {
  private final Provider<Stage> windowProvider;

  private final Provider<Vault> vaultProvider;

  private final Provider<StringProperty> recoveryKeyProvider;

  private final Provider<Scene> resetPasswordSceneProvider;

  private final Provider<ResourceBundle> resourceBundleProvider;

  public RecoveryKeyRecoverController_Factory(
      Provider<Stage> windowProvider,
      Provider<Vault> vaultProvider,
      Provider<StringProperty> recoveryKeyProvider,
      Provider<Scene> resetPasswordSceneProvider,
      Provider<ResourceBundle> resourceBundleProvider) {
    this.windowProvider = windowProvider;
    this.vaultProvider = vaultProvider;
    this.recoveryKeyProvider = recoveryKeyProvider;
    this.resetPasswordSceneProvider = resetPasswordSceneProvider;
    this.resourceBundleProvider = resourceBundleProvider;
  }

  @Override
  public RecoveryKeyRecoverController get() {
    return newInstance(
        windowProvider.get(),
        vaultProvider.get(),
        recoveryKeyProvider.get(),
        DoubleCheck.lazy(resetPasswordSceneProvider),
        resourceBundleProvider.get());
  }

  public static RecoveryKeyRecoverController_Factory create(
      Provider<Stage> windowProvider,
      Provider<Vault> vaultProvider,
      Provider<StringProperty> recoveryKeyProvider,
      Provider<Scene> resetPasswordSceneProvider,
      Provider<ResourceBundle> resourceBundleProvider) {
    return new RecoveryKeyRecoverController_Factory(
        windowProvider,
        vaultProvider,
        recoveryKeyProvider,
        resetPasswordSceneProvider,
        resourceBundleProvider);
  }

  public static RecoveryKeyRecoverController newInstance(
      Stage window,
      Vault vault,
      StringProperty recoveryKey,
      Lazy<Scene> resetPasswordScene,
      ResourceBundle resourceBundle) {
    return new RecoveryKeyRecoverController(
        window, vault, recoveryKey, resetPasswordScene, resourceBundle);
  }
}
