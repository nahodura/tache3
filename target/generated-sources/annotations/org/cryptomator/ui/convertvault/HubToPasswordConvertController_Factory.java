package org.cryptomator.ui.convertvault;

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
import org.cryptomator.cryptolib.common.MasterkeyFileAccess;
import org.cryptomator.ui.fxapp.FxApplicationWindows;
import org.cryptomator.ui.recoverykey.RecoveryKeyFactory;

@ScopeMetadata
@QualifierMetadata({
  "org.cryptomator.ui.convertvault.ConvertVaultWindow",
  "org.cryptomator.ui.common.FxmlScene"
})
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class HubToPasswordConvertController_Factory
    implements Factory<HubToPasswordConvertController> {
  private final Provider<Stage> windowProvider;

  private final Provider<Scene> successSceneProvider;

  private final Provider<FxApplicationWindows> applicationWindowsProvider;

  private final Provider<Vault> vaultProvider;

  private final Provider<StringProperty> recoveryKeyProvider;

  private final Provider<RecoveryKeyFactory> recoveryKeyFactoryProvider;

  private final Provider<MasterkeyFileAccess> masterkeyFileAccessProvider;

  private final Provider<ExecutorService> backgroundExecutorServiceProvider;

  private final Provider<ResourceBundle> resourceBundleProvider;

  public HubToPasswordConvertController_Factory(
      Provider<Stage> windowProvider,
      Provider<Scene> successSceneProvider,
      Provider<FxApplicationWindows> applicationWindowsProvider,
      Provider<Vault> vaultProvider,
      Provider<StringProperty> recoveryKeyProvider,
      Provider<RecoveryKeyFactory> recoveryKeyFactoryProvider,
      Provider<MasterkeyFileAccess> masterkeyFileAccessProvider,
      Provider<ExecutorService> backgroundExecutorServiceProvider,
      Provider<ResourceBundle> resourceBundleProvider) {
    this.windowProvider = windowProvider;
    this.successSceneProvider = successSceneProvider;
    this.applicationWindowsProvider = applicationWindowsProvider;
    this.vaultProvider = vaultProvider;
    this.recoveryKeyProvider = recoveryKeyProvider;
    this.recoveryKeyFactoryProvider = recoveryKeyFactoryProvider;
    this.masterkeyFileAccessProvider = masterkeyFileAccessProvider;
    this.backgroundExecutorServiceProvider = backgroundExecutorServiceProvider;
    this.resourceBundleProvider = resourceBundleProvider;
  }

  @Override
  public HubToPasswordConvertController get() {
    return newInstance(
        windowProvider.get(),
        DoubleCheck.lazy(successSceneProvider),
        applicationWindowsProvider.get(),
        vaultProvider.get(),
        recoveryKeyProvider.get(),
        recoveryKeyFactoryProvider.get(),
        masterkeyFileAccessProvider.get(),
        backgroundExecutorServiceProvider.get(),
        resourceBundleProvider.get());
  }

  public static HubToPasswordConvertController_Factory create(
      Provider<Stage> windowProvider,
      Provider<Scene> successSceneProvider,
      Provider<FxApplicationWindows> applicationWindowsProvider,
      Provider<Vault> vaultProvider,
      Provider<StringProperty> recoveryKeyProvider,
      Provider<RecoveryKeyFactory> recoveryKeyFactoryProvider,
      Provider<MasterkeyFileAccess> masterkeyFileAccessProvider,
      Provider<ExecutorService> backgroundExecutorServiceProvider,
      Provider<ResourceBundle> resourceBundleProvider) {
    return new HubToPasswordConvertController_Factory(
        windowProvider,
        successSceneProvider,
        applicationWindowsProvider,
        vaultProvider,
        recoveryKeyProvider,
        recoveryKeyFactoryProvider,
        masterkeyFileAccessProvider,
        backgroundExecutorServiceProvider,
        resourceBundleProvider);
  }

  public static HubToPasswordConvertController newInstance(
      Stage window,
      Lazy<Scene> successScene,
      FxApplicationWindows applicationWindows,
      Vault vault,
      StringProperty recoveryKey,
      RecoveryKeyFactory recoveryKeyFactory,
      MasterkeyFileAccess masterkeyFileAccess,
      ExecutorService backgroundExecutorService,
      ResourceBundle resourceBundle) {
    return new HubToPasswordConvertController(
        window,
        successScene,
        applicationWindows,
        vault,
        recoveryKey,
        recoveryKeyFactory,
        masterkeyFileAccess,
        backgroundExecutorService,
        resourceBundle);
  }
}
