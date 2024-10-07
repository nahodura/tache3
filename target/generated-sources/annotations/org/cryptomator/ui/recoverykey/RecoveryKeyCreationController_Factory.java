package org.cryptomator.ui.recoverykey;

import dagger.Lazy;
import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutorService;
import javafx.beans.property.StringProperty;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.cryptomator.common.vaults.Vault;
import org.cryptomator.ui.fxapp.FxApplicationWindows;

@ScopeMetadata("org.cryptomator.ui.recoverykey.RecoveryKeyScoped")
@QualifierMetadata({
  "org.cryptomator.ui.recoverykey.RecoveryKeyWindow",
  "org.cryptomator.ui.common.FxmlScene"
})
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class RecoveryKeyCreationController_Factory
    implements Factory<RecoveryKeyCreationController> {
  private final Provider<Stage> windowProvider;

  private final Provider<Scene> successSceneProvider;

  private final Provider<Vault> vaultProvider;

  private final Provider<RecoveryKeyFactory> recoveryKeyFactoryProvider;

  private final Provider<ExecutorService> executorProvider;

  private final Provider<StringProperty> recoveryKeyProvider;

  private final Provider<FxApplicationWindows> appWindowsProvider;

  private final Provider<ResourceBundle> resourceBundleProvider;

  public RecoveryKeyCreationController_Factory(
      Provider<Stage> windowProvider,
      Provider<Scene> successSceneProvider,
      Provider<Vault> vaultProvider,
      Provider<RecoveryKeyFactory> recoveryKeyFactoryProvider,
      Provider<ExecutorService> executorProvider,
      Provider<StringProperty> recoveryKeyProvider,
      Provider<FxApplicationWindows> appWindowsProvider,
      Provider<ResourceBundle> resourceBundleProvider) {
    this.windowProvider = windowProvider;
    this.successSceneProvider = successSceneProvider;
    this.vaultProvider = vaultProvider;
    this.recoveryKeyFactoryProvider = recoveryKeyFactoryProvider;
    this.executorProvider = executorProvider;
    this.recoveryKeyProvider = recoveryKeyProvider;
    this.appWindowsProvider = appWindowsProvider;
    this.resourceBundleProvider = resourceBundleProvider;
  }

  @Override
  public RecoveryKeyCreationController get() {
    return newInstance(
        windowProvider.get(),
        DoubleCheck.lazy(successSceneProvider),
        vaultProvider.get(),
        recoveryKeyFactoryProvider.get(),
        executorProvider.get(),
        recoveryKeyProvider.get(),
        appWindowsProvider.get(),
        resourceBundleProvider.get());
  }

  public static RecoveryKeyCreationController_Factory create(
      Provider<Stage> windowProvider,
      Provider<Scene> successSceneProvider,
      Provider<Vault> vaultProvider,
      Provider<RecoveryKeyFactory> recoveryKeyFactoryProvider,
      Provider<ExecutorService> executorProvider,
      Provider<StringProperty> recoveryKeyProvider,
      Provider<FxApplicationWindows> appWindowsProvider,
      Provider<ResourceBundle> resourceBundleProvider) {
    return new RecoveryKeyCreationController_Factory(
        windowProvider,
        successSceneProvider,
        vaultProvider,
        recoveryKeyFactoryProvider,
        executorProvider,
        recoveryKeyProvider,
        appWindowsProvider,
        resourceBundleProvider);
  }

  public static RecoveryKeyCreationController newInstance(
      Stage window,
      Lazy<Scene> successScene,
      Vault vault,
      RecoveryKeyFactory recoveryKeyFactory,
      ExecutorService executor,
      StringProperty recoveryKey,
      FxApplicationWindows appWindows,
      ResourceBundle resourceBundle) {
    return new RecoveryKeyCreationController(
        window,
        successScene,
        vault,
        recoveryKeyFactory,
        executor,
        recoveryKey,
        appWindows,
        resourceBundle);
  }
}
