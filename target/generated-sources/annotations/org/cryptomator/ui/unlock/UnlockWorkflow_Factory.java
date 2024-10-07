package org.cryptomator.ui.unlock;

import dagger.Lazy;
import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javafx.beans.property.ObjectProperty;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.cryptomator.common.mount.IllegalMountPointException;
import org.cryptomator.common.vaults.Vault;
import org.cryptomator.ui.common.VaultService;
import org.cryptomator.ui.fxapp.FxApplicationWindows;
import org.cryptomator.ui.keyloading.KeyLoadingStrategy;

@ScopeMetadata("org.cryptomator.ui.unlock.UnlockScoped")
@QualifierMetadata({
  "org.cryptomator.ui.fxapp.PrimaryStage",
  "org.cryptomator.ui.unlock.UnlockWindow",
  "org.cryptomator.ui.common.FxmlScene"
})
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class UnlockWorkflow_Factory implements Factory<UnlockWorkflow> {
  private final Provider<Stage> mainWindowProvider;

  private final Provider<Stage> windowProvider;

  private final Provider<Vault> vaultProvider;

  private final Provider<VaultService> vaultServiceProvider;

  private final Provider<Scene> successSceneProvider;

  private final Provider<Scene> invalidMountPointSceneProvider;

  private final Provider<Scene> restartRequiredSceneProvider;

  private final Provider<FxApplicationWindows> appWindowsProvider;

  private final Provider<KeyLoadingStrategy> keyLoadingStrategyProvider;

  private final Provider<ObjectProperty<IllegalMountPointException>>
      illegalMountPointExceptionProvider;

  public UnlockWorkflow_Factory(
      Provider<Stage> mainWindowProvider,
      Provider<Stage> windowProvider,
      Provider<Vault> vaultProvider,
      Provider<VaultService> vaultServiceProvider,
      Provider<Scene> successSceneProvider,
      Provider<Scene> invalidMountPointSceneProvider,
      Provider<Scene> restartRequiredSceneProvider,
      Provider<FxApplicationWindows> appWindowsProvider,
      Provider<KeyLoadingStrategy> keyLoadingStrategyProvider,
      Provider<ObjectProperty<IllegalMountPointException>> illegalMountPointExceptionProvider) {
    this.mainWindowProvider = mainWindowProvider;
    this.windowProvider = windowProvider;
    this.vaultProvider = vaultProvider;
    this.vaultServiceProvider = vaultServiceProvider;
    this.successSceneProvider = successSceneProvider;
    this.invalidMountPointSceneProvider = invalidMountPointSceneProvider;
    this.restartRequiredSceneProvider = restartRequiredSceneProvider;
    this.appWindowsProvider = appWindowsProvider;
    this.keyLoadingStrategyProvider = keyLoadingStrategyProvider;
    this.illegalMountPointExceptionProvider = illegalMountPointExceptionProvider;
  }

  @Override
  public UnlockWorkflow get() {
    return newInstance(
        mainWindowProvider.get(),
        windowProvider.get(),
        vaultProvider.get(),
        vaultServiceProvider.get(),
        DoubleCheck.lazy(successSceneProvider),
        DoubleCheck.lazy(invalidMountPointSceneProvider),
        DoubleCheck.lazy(restartRequiredSceneProvider),
        appWindowsProvider.get(),
        keyLoadingStrategyProvider.get(),
        illegalMountPointExceptionProvider.get());
  }

  public static UnlockWorkflow_Factory create(
      Provider<Stage> mainWindowProvider,
      Provider<Stage> windowProvider,
      Provider<Vault> vaultProvider,
      Provider<VaultService> vaultServiceProvider,
      Provider<Scene> successSceneProvider,
      Provider<Scene> invalidMountPointSceneProvider,
      Provider<Scene> restartRequiredSceneProvider,
      Provider<FxApplicationWindows> appWindowsProvider,
      Provider<KeyLoadingStrategy> keyLoadingStrategyProvider,
      Provider<ObjectProperty<IllegalMountPointException>> illegalMountPointExceptionProvider) {
    return new UnlockWorkflow_Factory(
        mainWindowProvider,
        windowProvider,
        vaultProvider,
        vaultServiceProvider,
        successSceneProvider,
        invalidMountPointSceneProvider,
        restartRequiredSceneProvider,
        appWindowsProvider,
        keyLoadingStrategyProvider,
        illegalMountPointExceptionProvider);
  }

  public static UnlockWorkflow newInstance(
      Stage mainWindow,
      Stage window,
      Vault vault,
      VaultService vaultService,
      Lazy<Scene> successScene,
      Lazy<Scene> invalidMountPointScene,
      Lazy<Scene> restartRequiredScene,
      FxApplicationWindows appWindows,
      KeyLoadingStrategy keyLoadingStrategy,
      ObjectProperty<IllegalMountPointException> illegalMountPointException) {
    return new UnlockWorkflow(
        mainWindow,
        window,
        vault,
        vaultService,
        successScene,
        invalidMountPointScene,
        restartRequiredScene,
        appWindows,
        keyLoadingStrategy,
        illegalMountPointException);
  }
}
