package org.cryptomator.ui.addvaultwizard;

import dagger.Lazy;
import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.nio.file.Path;
import java.security.SecureRandom;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutorService;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.cryptomator.common.vaults.Vault;
import org.cryptomator.common.vaults.VaultListManager;
import org.cryptomator.cryptolib.common.MasterkeyFileAccess;
import org.cryptomator.ui.fxapp.FxApplicationWindows;
import org.cryptomator.ui.recoverykey.RecoveryKeyFactory;

@ScopeMetadata("org.cryptomator.ui.addvaultwizard.AddVaultWizardScoped")
@QualifierMetadata({
  "org.cryptomator.ui.addvaultwizard.AddVaultWizardWindow",
  "org.cryptomator.ui.common.FxmlScene",
  "javax.inject.Named"
})
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class CreateNewVaultPasswordController_Factory
    implements Factory<CreateNewVaultPasswordController> {
  private final Provider<Stage> windowProvider;

  private final Provider<Scene> chooseExpertSettingsSceneProvider;

  private final Provider<Scene> recoveryKeySceneProvider;

  private final Provider<Scene> successSceneProvider;

  private final Provider<FxApplicationWindows> appWindowsProvider;

  private final Provider<ExecutorService> executorProvider;

  private final Provider<RecoveryKeyFactory> recoveryKeyFactoryProvider;

  private final Provider<StringProperty> vaultNameProvider;

  private final Provider<ObjectProperty<Path>> vaultPathProvider;

  private final Provider<ObjectProperty<Vault>> vaultProvider;

  private final Provider<StringProperty> recoveryKeyProvider;

  private final Provider<VaultListManager> vaultListManagerProvider;

  private final Provider<ResourceBundle> resourceBundleProvider;

  private final Provider<IntegerProperty> shorteningThresholdProvider;

  private final Provider<ReadmeGenerator> readmeGeneratorProvider;

  private final Provider<SecureRandom> csprngProvider;

  private final Provider<MasterkeyFileAccess> masterkeyFileAccessProvider;

  public CreateNewVaultPasswordController_Factory(
      Provider<Stage> windowProvider,
      Provider<Scene> chooseExpertSettingsSceneProvider,
      Provider<Scene> recoveryKeySceneProvider,
      Provider<Scene> successSceneProvider,
      Provider<FxApplicationWindows> appWindowsProvider,
      Provider<ExecutorService> executorProvider,
      Provider<RecoveryKeyFactory> recoveryKeyFactoryProvider,
      Provider<StringProperty> vaultNameProvider,
      Provider<ObjectProperty<Path>> vaultPathProvider,
      Provider<ObjectProperty<Vault>> vaultProvider,
      Provider<StringProperty> recoveryKeyProvider,
      Provider<VaultListManager> vaultListManagerProvider,
      Provider<ResourceBundle> resourceBundleProvider,
      Provider<IntegerProperty> shorteningThresholdProvider,
      Provider<ReadmeGenerator> readmeGeneratorProvider,
      Provider<SecureRandom> csprngProvider,
      Provider<MasterkeyFileAccess> masterkeyFileAccessProvider) {
    this.windowProvider = windowProvider;
    this.chooseExpertSettingsSceneProvider = chooseExpertSettingsSceneProvider;
    this.recoveryKeySceneProvider = recoveryKeySceneProvider;
    this.successSceneProvider = successSceneProvider;
    this.appWindowsProvider = appWindowsProvider;
    this.executorProvider = executorProvider;
    this.recoveryKeyFactoryProvider = recoveryKeyFactoryProvider;
    this.vaultNameProvider = vaultNameProvider;
    this.vaultPathProvider = vaultPathProvider;
    this.vaultProvider = vaultProvider;
    this.recoveryKeyProvider = recoveryKeyProvider;
    this.vaultListManagerProvider = vaultListManagerProvider;
    this.resourceBundleProvider = resourceBundleProvider;
    this.shorteningThresholdProvider = shorteningThresholdProvider;
    this.readmeGeneratorProvider = readmeGeneratorProvider;
    this.csprngProvider = csprngProvider;
    this.masterkeyFileAccessProvider = masterkeyFileAccessProvider;
  }

  @Override
  public CreateNewVaultPasswordController get() {
    return newInstance(
        windowProvider.get(),
        DoubleCheck.lazy(chooseExpertSettingsSceneProvider),
        DoubleCheck.lazy(recoveryKeySceneProvider),
        DoubleCheck.lazy(successSceneProvider),
        appWindowsProvider.get(),
        executorProvider.get(),
        recoveryKeyFactoryProvider.get(),
        vaultNameProvider.get(),
        vaultPathProvider.get(),
        vaultProvider.get(),
        recoveryKeyProvider.get(),
        vaultListManagerProvider.get(),
        resourceBundleProvider.get(),
        shorteningThresholdProvider.get(),
        readmeGeneratorProvider.get(),
        csprngProvider.get(),
        masterkeyFileAccessProvider.get());
  }

  public static CreateNewVaultPasswordController_Factory create(
      Provider<Stage> windowProvider,
      Provider<Scene> chooseExpertSettingsSceneProvider,
      Provider<Scene> recoveryKeySceneProvider,
      Provider<Scene> successSceneProvider,
      Provider<FxApplicationWindows> appWindowsProvider,
      Provider<ExecutorService> executorProvider,
      Provider<RecoveryKeyFactory> recoveryKeyFactoryProvider,
      Provider<StringProperty> vaultNameProvider,
      Provider<ObjectProperty<Path>> vaultPathProvider,
      Provider<ObjectProperty<Vault>> vaultProvider,
      Provider<StringProperty> recoveryKeyProvider,
      Provider<VaultListManager> vaultListManagerProvider,
      Provider<ResourceBundle> resourceBundleProvider,
      Provider<IntegerProperty> shorteningThresholdProvider,
      Provider<ReadmeGenerator> readmeGeneratorProvider,
      Provider<SecureRandom> csprngProvider,
      Provider<MasterkeyFileAccess> masterkeyFileAccessProvider) {
    return new CreateNewVaultPasswordController_Factory(
        windowProvider,
        chooseExpertSettingsSceneProvider,
        recoveryKeySceneProvider,
        successSceneProvider,
        appWindowsProvider,
        executorProvider,
        recoveryKeyFactoryProvider,
        vaultNameProvider,
        vaultPathProvider,
        vaultProvider,
        recoveryKeyProvider,
        vaultListManagerProvider,
        resourceBundleProvider,
        shorteningThresholdProvider,
        readmeGeneratorProvider,
        csprngProvider,
        masterkeyFileAccessProvider);
  }

  public static CreateNewVaultPasswordController newInstance(
      Stage window,
      Lazy<Scene> chooseExpertSettingsScene,
      Lazy<Scene> recoveryKeyScene,
      Lazy<Scene> successScene,
      FxApplicationWindows appWindows,
      ExecutorService executor,
      RecoveryKeyFactory recoveryKeyFactory,
      StringProperty vaultName,
      ObjectProperty<Path> vaultPath,
      ObjectProperty<Vault> vault,
      StringProperty recoveryKey,
      VaultListManager vaultListManager,
      ResourceBundle resourceBundle,
      IntegerProperty shorteningThreshold,
      ReadmeGenerator readmeGenerator,
      SecureRandom csprng,
      MasterkeyFileAccess masterkeyFileAccess) {
    return new CreateNewVaultPasswordController(
        window,
        chooseExpertSettingsScene,
        recoveryKeyScene,
        successScene,
        appWindows,
        executor,
        recoveryKeyFactory,
        vaultName,
        vaultPath,
        vault,
        recoveryKey,
        vaultListManager,
        resourceBundle,
        shorteningThreshold,
        readmeGenerator,
        csprng,
        masterkeyFileAccess);
  }
}
