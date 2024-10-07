package org.cryptomator.ui.migration;

import dagger.Lazy;
import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import javafx.beans.property.ObjectProperty;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.cryptomator.common.keychain.KeychainManager;
import org.cryptomator.common.vaults.Vault;
import org.cryptomator.cryptofs.common.FileSystemCapabilityChecker;
import org.cryptomator.ui.fxapp.FxApplicationWindows;

@ScopeMetadata("org.cryptomator.ui.migration.MigrationScoped")
@QualifierMetadata({
  "org.cryptomator.ui.migration.MigrationWindow",
  "javax.inject.Named",
  "org.cryptomator.ui.common.FxmlScene"
})
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class MigrationRunController_Factory implements Factory<MigrationRunController> {
  private final Provider<Stage> windowProvider;

  private final Provider<Vault> vaultProvider;

  private final Provider<ExecutorService> executorProvider;

  private final Provider<ScheduledExecutorService> schedulerProvider;

  private final Provider<KeychainManager> keychainProvider;

  private final Provider<ObjectProperty<FileSystemCapabilityChecker.Capability>>
      missingCapabilityProvider;

  private final Provider<Scene> startSceneProvider;

  private final Provider<Scene> successSceneProvider;

  private final Provider<Scene> capabilityErrorSceneProvider;

  private final Provider<Scene> impossibleSceneProvider;

  private final Provider<FxApplicationWindows> appWindowsProvider;

  public MigrationRunController_Factory(
      Provider<Stage> windowProvider,
      Provider<Vault> vaultProvider,
      Provider<ExecutorService> executorProvider,
      Provider<ScheduledExecutorService> schedulerProvider,
      Provider<KeychainManager> keychainProvider,
      Provider<ObjectProperty<FileSystemCapabilityChecker.Capability>> missingCapabilityProvider,
      Provider<Scene> startSceneProvider,
      Provider<Scene> successSceneProvider,
      Provider<Scene> capabilityErrorSceneProvider,
      Provider<Scene> impossibleSceneProvider,
      Provider<FxApplicationWindows> appWindowsProvider) {
    this.windowProvider = windowProvider;
    this.vaultProvider = vaultProvider;
    this.executorProvider = executorProvider;
    this.schedulerProvider = schedulerProvider;
    this.keychainProvider = keychainProvider;
    this.missingCapabilityProvider = missingCapabilityProvider;
    this.startSceneProvider = startSceneProvider;
    this.successSceneProvider = successSceneProvider;
    this.capabilityErrorSceneProvider = capabilityErrorSceneProvider;
    this.impossibleSceneProvider = impossibleSceneProvider;
    this.appWindowsProvider = appWindowsProvider;
  }

  @Override
  public MigrationRunController get() {
    return newInstance(
        windowProvider.get(),
        vaultProvider.get(),
        executorProvider.get(),
        schedulerProvider.get(),
        keychainProvider.get(),
        missingCapabilityProvider.get(),
        DoubleCheck.lazy(startSceneProvider),
        DoubleCheck.lazy(successSceneProvider),
        DoubleCheck.lazy(capabilityErrorSceneProvider),
        DoubleCheck.lazy(impossibleSceneProvider),
        appWindowsProvider.get());
  }

  public static MigrationRunController_Factory create(
      Provider<Stage> windowProvider,
      Provider<Vault> vaultProvider,
      Provider<ExecutorService> executorProvider,
      Provider<ScheduledExecutorService> schedulerProvider,
      Provider<KeychainManager> keychainProvider,
      Provider<ObjectProperty<FileSystemCapabilityChecker.Capability>> missingCapabilityProvider,
      Provider<Scene> startSceneProvider,
      Provider<Scene> successSceneProvider,
      Provider<Scene> capabilityErrorSceneProvider,
      Provider<Scene> impossibleSceneProvider,
      Provider<FxApplicationWindows> appWindowsProvider) {
    return new MigrationRunController_Factory(
        windowProvider,
        vaultProvider,
        executorProvider,
        schedulerProvider,
        keychainProvider,
        missingCapabilityProvider,
        startSceneProvider,
        successSceneProvider,
        capabilityErrorSceneProvider,
        impossibleSceneProvider,
        appWindowsProvider);
  }

  public static MigrationRunController newInstance(
      Stage window,
      Vault vault,
      ExecutorService executor,
      ScheduledExecutorService scheduler,
      KeychainManager keychain,
      ObjectProperty<FileSystemCapabilityChecker.Capability> missingCapability,
      Lazy<Scene> startScene,
      Lazy<Scene> successScene,
      Lazy<Scene> capabilityErrorScene,
      Lazy<Scene> impossibleScene,
      FxApplicationWindows appWindows) {
    return new MigrationRunController(
        window,
        vault,
        executor,
        scheduler,
        keychain,
        missingCapability,
        startScene,
        successScene,
        capabilityErrorScene,
        impossibleScene,
        appWindows);
  }
}
