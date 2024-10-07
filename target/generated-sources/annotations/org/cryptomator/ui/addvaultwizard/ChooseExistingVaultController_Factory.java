package org.cryptomator.ui.addvaultwizard;

import dagger.Lazy;
import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.nio.file.Path;
import java.util.ResourceBundle;
import javafx.beans.property.ObjectProperty;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.cryptomator.common.vaults.Vault;
import org.cryptomator.common.vaults.VaultListManager;
import org.cryptomator.ui.fxapp.FxApplicationStyle;
import org.cryptomator.ui.fxapp.FxApplicationWindows;

@ScopeMetadata("org.cryptomator.ui.addvaultwizard.AddVaultWizardScoped")
@QualifierMetadata({
  "org.cryptomator.ui.addvaultwizard.AddVaultWizardWindow",
  "org.cryptomator.ui.common.FxmlScene"
})
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class ChooseExistingVaultController_Factory
    implements Factory<ChooseExistingVaultController> {
  private final Provider<Stage> windowProvider;

  private final Provider<Scene> successSceneProvider;

  private final Provider<FxApplicationWindows> appWindowsProvider;

  private final Provider<ObjectProperty<Path>> vaultPathProvider;

  private final Provider<ObjectProperty<Vault>> vaultProvider;

  private final Provider<VaultListManager> vaultListManagerProvider;

  private final Provider<ResourceBundle> resourceBundleProvider;

  private final Provider<FxApplicationStyle> applicationStyleProvider;

  public ChooseExistingVaultController_Factory(
      Provider<Stage> windowProvider,
      Provider<Scene> successSceneProvider,
      Provider<FxApplicationWindows> appWindowsProvider,
      Provider<ObjectProperty<Path>> vaultPathProvider,
      Provider<ObjectProperty<Vault>> vaultProvider,
      Provider<VaultListManager> vaultListManagerProvider,
      Provider<ResourceBundle> resourceBundleProvider,
      Provider<FxApplicationStyle> applicationStyleProvider) {
    this.windowProvider = windowProvider;
    this.successSceneProvider = successSceneProvider;
    this.appWindowsProvider = appWindowsProvider;
    this.vaultPathProvider = vaultPathProvider;
    this.vaultProvider = vaultProvider;
    this.vaultListManagerProvider = vaultListManagerProvider;
    this.resourceBundleProvider = resourceBundleProvider;
    this.applicationStyleProvider = applicationStyleProvider;
  }

  @Override
  public ChooseExistingVaultController get() {
    return newInstance(
        windowProvider.get(),
        DoubleCheck.lazy(successSceneProvider),
        appWindowsProvider.get(),
        vaultPathProvider.get(),
        vaultProvider.get(),
        vaultListManagerProvider.get(),
        resourceBundleProvider.get(),
        applicationStyleProvider.get());
  }

  public static ChooseExistingVaultController_Factory create(
      Provider<Stage> windowProvider,
      Provider<Scene> successSceneProvider,
      Provider<FxApplicationWindows> appWindowsProvider,
      Provider<ObjectProperty<Path>> vaultPathProvider,
      Provider<ObjectProperty<Vault>> vaultProvider,
      Provider<VaultListManager> vaultListManagerProvider,
      Provider<ResourceBundle> resourceBundleProvider,
      Provider<FxApplicationStyle> applicationStyleProvider) {
    return new ChooseExistingVaultController_Factory(
        windowProvider,
        successSceneProvider,
        appWindowsProvider,
        vaultPathProvider,
        vaultProvider,
        vaultListManagerProvider,
        resourceBundleProvider,
        applicationStyleProvider);
  }

  public static ChooseExistingVaultController newInstance(
      Stage window,
      Lazy<Scene> successScene,
      FxApplicationWindows appWindows,
      ObjectProperty<Path> vaultPath,
      ObjectProperty<Vault> vault,
      VaultListManager vaultListManager,
      ResourceBundle resourceBundle,
      FxApplicationStyle applicationStyle) {
    return new ChooseExistingVaultController(
        window,
        successScene,
        appWindows,
        vaultPath,
        vault,
        vaultListManager,
        resourceBundle,
        applicationStyle);
  }
}
