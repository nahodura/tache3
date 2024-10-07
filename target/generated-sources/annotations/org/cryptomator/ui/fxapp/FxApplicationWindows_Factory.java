package org.cryptomator.ui.fxapp;

import dagger.Lazy;
import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.util.Optional;
import java.util.concurrent.ExecutorService;
import javafx.stage.Stage;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.cryptomator.integrations.tray.TrayIntegrationProvider;
import org.cryptomator.ui.dokanysupportend.DokanySupportEndComponent;
import org.cryptomator.ui.error.ErrorComponent;
import org.cryptomator.ui.lock.LockComponent;
import org.cryptomator.ui.mainwindow.MainWindowComponent;
import org.cryptomator.ui.preferences.PreferencesComponent;
import org.cryptomator.ui.quit.QuitComponent;
import org.cryptomator.ui.sharevault.ShareVaultComponent;
import org.cryptomator.ui.unlock.UnlockComponent;
import org.cryptomator.ui.updatereminder.UpdateReminderComponent;
import org.cryptomator.ui.vaultoptions.VaultOptionsComponent;

@ScopeMetadata("org.cryptomator.ui.fxapp.FxApplicationScoped")
@QualifierMetadata("org.cryptomator.ui.fxapp.PrimaryStage")
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class FxApplicationWindows_Factory implements Factory<FxApplicationWindows> {
  private final Provider<Stage> primaryStageProvider;

  private final Provider<Optional<TrayIntegrationProvider>> trayIntegrationProvider;

  private final Provider<MainWindowComponent> mainWindowProvider;

  private final Provider<PreferencesComponent> preferencesWindowProvider;

  private final Provider<QuitComponent.Builder> quitWindowBuilderProvider;

  private final Provider<UnlockComponent.Factory> unlockWorkflowFactoryProvider;

  private final Provider<UpdateReminderComponent.Factory> updateReminderWindowBuilderProvider;

  private final Provider<DokanySupportEndComponent.Factory> dokanySupportEndWindowBuilderProvider;

  private final Provider<LockComponent.Factory> lockWorkflowFactoryProvider;

  private final Provider<ErrorComponent.Factory> errorWindowFactoryProvider;

  private final Provider<VaultOptionsComponent.Factory> vaultOptionsWindowProvider;

  private final Provider<ShareVaultComponent.Factory> shareVaultWindowProvider;

  private final Provider<ExecutorService> executorProvider;

  public FxApplicationWindows_Factory(
      Provider<Stage> primaryStageProvider,
      Provider<Optional<TrayIntegrationProvider>> trayIntegrationProvider,
      Provider<MainWindowComponent> mainWindowProvider,
      Provider<PreferencesComponent> preferencesWindowProvider,
      Provider<QuitComponent.Builder> quitWindowBuilderProvider,
      Provider<UnlockComponent.Factory> unlockWorkflowFactoryProvider,
      Provider<UpdateReminderComponent.Factory> updateReminderWindowBuilderProvider,
      Provider<DokanySupportEndComponent.Factory> dokanySupportEndWindowBuilderProvider,
      Provider<LockComponent.Factory> lockWorkflowFactoryProvider,
      Provider<ErrorComponent.Factory> errorWindowFactoryProvider,
      Provider<VaultOptionsComponent.Factory> vaultOptionsWindowProvider,
      Provider<ShareVaultComponent.Factory> shareVaultWindowProvider,
      Provider<ExecutorService> executorProvider) {
    this.primaryStageProvider = primaryStageProvider;
    this.trayIntegrationProvider = trayIntegrationProvider;
    this.mainWindowProvider = mainWindowProvider;
    this.preferencesWindowProvider = preferencesWindowProvider;
    this.quitWindowBuilderProvider = quitWindowBuilderProvider;
    this.unlockWorkflowFactoryProvider = unlockWorkflowFactoryProvider;
    this.updateReminderWindowBuilderProvider = updateReminderWindowBuilderProvider;
    this.dokanySupportEndWindowBuilderProvider = dokanySupportEndWindowBuilderProvider;
    this.lockWorkflowFactoryProvider = lockWorkflowFactoryProvider;
    this.errorWindowFactoryProvider = errorWindowFactoryProvider;
    this.vaultOptionsWindowProvider = vaultOptionsWindowProvider;
    this.shareVaultWindowProvider = shareVaultWindowProvider;
    this.executorProvider = executorProvider;
  }

  @Override
  public FxApplicationWindows get() {
    return newInstance(
        primaryStageProvider.get(),
        trayIntegrationProvider.get(),
        DoubleCheck.lazy(mainWindowProvider),
        DoubleCheck.lazy(preferencesWindowProvider),
        quitWindowBuilderProvider.get(),
        unlockWorkflowFactoryProvider.get(),
        updateReminderWindowBuilderProvider.get(),
        dokanySupportEndWindowBuilderProvider.get(),
        lockWorkflowFactoryProvider.get(),
        errorWindowFactoryProvider.get(),
        vaultOptionsWindowProvider.get(),
        shareVaultWindowProvider.get(),
        executorProvider.get());
  }

  public static FxApplicationWindows_Factory create(
      Provider<Stage> primaryStageProvider,
      Provider<Optional<TrayIntegrationProvider>> trayIntegrationProvider,
      Provider<MainWindowComponent> mainWindowProvider,
      Provider<PreferencesComponent> preferencesWindowProvider,
      Provider<QuitComponent.Builder> quitWindowBuilderProvider,
      Provider<UnlockComponent.Factory> unlockWorkflowFactoryProvider,
      Provider<UpdateReminderComponent.Factory> updateReminderWindowBuilderProvider,
      Provider<DokanySupportEndComponent.Factory> dokanySupportEndWindowBuilderProvider,
      Provider<LockComponent.Factory> lockWorkflowFactoryProvider,
      Provider<ErrorComponent.Factory> errorWindowFactoryProvider,
      Provider<VaultOptionsComponent.Factory> vaultOptionsWindowProvider,
      Provider<ShareVaultComponent.Factory> shareVaultWindowProvider,
      Provider<ExecutorService> executorProvider) {
    return new FxApplicationWindows_Factory(
        primaryStageProvider,
        trayIntegrationProvider,
        mainWindowProvider,
        preferencesWindowProvider,
        quitWindowBuilderProvider,
        unlockWorkflowFactoryProvider,
        updateReminderWindowBuilderProvider,
        dokanySupportEndWindowBuilderProvider,
        lockWorkflowFactoryProvider,
        errorWindowFactoryProvider,
        vaultOptionsWindowProvider,
        shareVaultWindowProvider,
        executorProvider);
  }

  public static FxApplicationWindows newInstance(
      Stage primaryStage,
      Optional<TrayIntegrationProvider> trayIntegration,
      Lazy<MainWindowComponent> mainWindow,
      Lazy<PreferencesComponent> preferencesWindow,
      QuitComponent.Builder quitWindowBuilder,
      UnlockComponent.Factory unlockWorkflowFactory,
      UpdateReminderComponent.Factory updateReminderWindowBuilder,
      DokanySupportEndComponent.Factory dokanySupportEndWindowBuilder,
      LockComponent.Factory lockWorkflowFactory,
      ErrorComponent.Factory errorWindowFactory,
      VaultOptionsComponent.Factory vaultOptionsWindow,
      ShareVaultComponent.Factory shareVaultWindow,
      ExecutorService executor) {
    return new FxApplicationWindows(
        primaryStage,
        trayIntegration,
        mainWindow,
        preferencesWindow,
        quitWindowBuilder,
        unlockWorkflowFactory,
        updateReminderWindowBuilder,
        dokanySupportEndWindowBuilder,
        lockWorkflowFactory,
        errorWindowFactory,
        vaultOptionsWindow,
        shareVaultWindow,
        executor);
  }
}
