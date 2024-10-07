package org.cryptomator.launcher;

import com.google.common.collect.ImmutableMap;
import dagger.Lazy;
import dagger.internal.DaggerGenerated;
import dagger.internal.DelegateFactory;
import dagger.internal.DoubleCheck;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
import java.awt.desktop.QuitResponse;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.nio.file.Path;
import java.security.SecureRandom;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicReference;
import javafx.application.Application;
import javafx.beans.binding.ObjectBinding;
import javafx.beans.binding.ObjectExpression;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ReadOnlyBooleanProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.concurrent.ScheduledService;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.annotation.processing.Generated;
import org.cryptomator.common.CommonsModule_ProvideCSPRNGFactory;
import org.cryptomator.common.CommonsModule_ProvideEnvironmentFactory;
import org.cryptomator.common.CommonsModule_ProvideExecutorServiceFactory;
import org.cryptomator.common.CommonsModule_ProvideLicensePublicKeyFactory;
import org.cryptomator.common.CommonsModule_ProvideMasterkeyFileAccessFactory;
import org.cryptomator.common.CommonsModule_ProvideRevealPathServiceFactory;
import org.cryptomator.common.CommonsModule_ProvideScheduledExecutorServiceFactory;
import org.cryptomator.common.CommonsModule_ProvideSettingsFactory;
import org.cryptomator.common.Environment;
import org.cryptomator.common.ErrorCode;
import org.cryptomator.common.LicenseChecker_Factory;
import org.cryptomator.common.LicenseHolder;
import org.cryptomator.common.LicenseHolder_Factory;
import org.cryptomator.common.Passphrase;
import org.cryptomator.common.ShutdownHook;
import org.cryptomator.common.ShutdownHook_Factory;
import org.cryptomator.common.keychain.KeychainManager;
import org.cryptomator.common.keychain.KeychainManager_Factory;
import org.cryptomator.common.keychain.KeychainModule_ProvideKeychainAccessProviderFactory;
import org.cryptomator.common.keychain.KeychainModule_ProvideSupportedKeychainAccessProvidersFactory;
import org.cryptomator.common.mount.IllegalMountPointException;
import org.cryptomator.common.mount.MountModule_ProvideDefaultMountServiceFactory;
import org.cryptomator.common.mount.MountModule_ProvideSetOfUsedMountServicesFactory;
import org.cryptomator.common.mount.MountModule_ProvideSupportedMountServicesFactory;
import org.cryptomator.common.mount.Mounter;
import org.cryptomator.common.mount.WindowsDriveLetters;
import org.cryptomator.common.settings.DeviceKey;
import org.cryptomator.common.settings.Settings;
import org.cryptomator.common.settings.SettingsProvider;
import org.cryptomator.common.settings.VaultSettings;
import org.cryptomator.common.vaults.AutoLocker;
import org.cryptomator.common.vaults.Vault;
import org.cryptomator.common.vaults.VaultComponent;
import org.cryptomator.common.vaults.VaultConfigCache;
import org.cryptomator.common.vaults.VaultListManager;
import org.cryptomator.common.vaults.VaultListModule;
import org.cryptomator.common.vaults.VaultListModule_ProvideVaultListFactory;
import org.cryptomator.common.vaults.VaultModule;
import org.cryptomator.common.vaults.VaultModule_ProvideCryptoFileSystemReferenceFactory;
import org.cryptomator.common.vaults.VaultModule_ProvideLastKnownExceptionFactory;
import org.cryptomator.common.vaults.VaultState;
import org.cryptomator.common.vaults.VaultStats;
import org.cryptomator.common.vaults.VaultStats_Factory;
import org.cryptomator.common.vaults.Vault_Factory;
import org.cryptomator.cryptofs.CryptoFileSystem;
import org.cryptomator.cryptofs.VaultConfig;
import org.cryptomator.cryptofs.common.FileSystemCapabilityChecker;
import org.cryptomator.cryptolib.api.Masterkey;
import org.cryptomator.cryptolib.common.MasterkeyFileAccess;
import org.cryptomator.integrations.autostart.AutoStartProvider;
import org.cryptomator.integrations.keychain.KeychainAccessProvider;
import org.cryptomator.integrations.mount.MountService;
import org.cryptomator.integrations.revealpath.RevealPathService;
import org.cryptomator.integrations.tray.TrayIntegrationProvider;
import org.cryptomator.integrations.tray.TrayMenuController;
import org.cryptomator.integrations.uiappearance.UiAppearanceProvider;
import org.cryptomator.logging.DebugMode;
import org.cryptomator.ui.addvaultwizard.AddVaultModule_ProvideChooseExistingVaultSceneFactory;
import org.cryptomator.ui.addvaultwizard.AddVaultModule_ProvideCreateNewVaultExpertSettingsSceneFactory;
import org.cryptomator.ui.addvaultwizard.AddVaultModule_ProvideCreateNewVaultLocationSceneFactory;
import org.cryptomator.ui.addvaultwizard.AddVaultModule_ProvideCreateNewVaultNameSceneFactory;
import org.cryptomator.ui.addvaultwizard.AddVaultModule_ProvideCreateNewVaultPasswordSceneFactory;
import org.cryptomator.ui.addvaultwizard.AddVaultModule_ProvideCreateNewVaultRecoveryKeySceneFactory;
import org.cryptomator.ui.addvaultwizard.AddVaultModule_ProvideCreateNewVaultSuccessSceneFactory;
import org.cryptomator.ui.addvaultwizard.AddVaultModule_ProvideFxmlLoaderFactoryFactory;
import org.cryptomator.ui.addvaultwizard.AddVaultModule_ProvideNewPasswordControllerFactory;
import org.cryptomator.ui.addvaultwizard.AddVaultModule_ProvideRecoveryKeyDisplayControllerFactory;
import org.cryptomator.ui.addvaultwizard.AddVaultModule_ProvideRecoveryKeyFactory;
import org.cryptomator.ui.addvaultwizard.AddVaultModule_ProvideShorteningThresholdFactory;
import org.cryptomator.ui.addvaultwizard.AddVaultModule_ProvideStageFactory;
import org.cryptomator.ui.addvaultwizard.AddVaultModule_ProvideVaultFactory;
import org.cryptomator.ui.addvaultwizard.AddVaultModule_ProvideVaultNameFactory;
import org.cryptomator.ui.addvaultwizard.AddVaultModule_ProvideVaultPathFactory;
import org.cryptomator.ui.addvaultwizard.AddVaultSuccessController;
import org.cryptomator.ui.addvaultwizard.AddVaultSuccessController_Factory;
import org.cryptomator.ui.addvaultwizard.AddVaultWizardComponent;
import org.cryptomator.ui.addvaultwizard.ChooseExistingVaultController;
import org.cryptomator.ui.addvaultwizard.ChooseExistingVaultController_Factory;
import org.cryptomator.ui.addvaultwizard.CreateNewVaultExpertSettingsController;
import org.cryptomator.ui.addvaultwizard.CreateNewVaultExpertSettingsController_Factory;
import org.cryptomator.ui.addvaultwizard.CreateNewVaultLocationController;
import org.cryptomator.ui.addvaultwizard.CreateNewVaultLocationController_Factory;
import org.cryptomator.ui.addvaultwizard.CreateNewVaultNameController;
import org.cryptomator.ui.addvaultwizard.CreateNewVaultNameController_Factory;
import org.cryptomator.ui.addvaultwizard.CreateNewVaultPasswordController;
import org.cryptomator.ui.addvaultwizard.CreateNewVaultPasswordController_Factory;
import org.cryptomator.ui.addvaultwizard.CreateNewVaultRecoveryKeyController;
import org.cryptomator.ui.addvaultwizard.CreateNewVaultRecoveryKeyController_Factory;
import org.cryptomator.ui.addvaultwizard.ReadmeGenerator;
import org.cryptomator.ui.changepassword.ChangePasswordComponent;
import org.cryptomator.ui.changepassword.ChangePasswordController;
import org.cryptomator.ui.changepassword.ChangePasswordModule_ProvideFxmlLoaderFactoryFactory;
import org.cryptomator.ui.changepassword.ChangePasswordModule_ProvideNewPasswordControllerFactory;
import org.cryptomator.ui.changepassword.ChangePasswordModule_ProvideStageFactory;
import org.cryptomator.ui.changepassword.ChangePasswordModule_ProvideUnlockSceneFactory;
import org.cryptomator.ui.changepassword.NewPasswordController;
import org.cryptomator.ui.changepassword.PasswordStrengthUtil;
import org.cryptomator.ui.common.DefaultSceneFactory;
import org.cryptomator.ui.common.FxController;
import org.cryptomator.ui.common.FxmlLoaderFactory;
import org.cryptomator.ui.common.StageFactory;
import org.cryptomator.ui.common.StageInitializer;
import org.cryptomator.ui.common.VaultService;
import org.cryptomator.ui.convertvault.ConvertVaultComponent;
import org.cryptomator.ui.convertvault.ConvertVaultModule_BindRecoveryKeyValidateControllerFactory;
import org.cryptomator.ui.convertvault.ConvertVaultModule_ProvideFxmlLoaderFactoryFactory;
import org.cryptomator.ui.convertvault.ConvertVaultModule_ProvideHubToPasswordConvertSceneFactory;
import org.cryptomator.ui.convertvault.ConvertVaultModule_ProvideHubToPasswordStartSceneFactory;
import org.cryptomator.ui.convertvault.ConvertVaultModule_ProvideHubToPasswordSuccessSceneFactory;
import org.cryptomator.ui.convertvault.ConvertVaultModule_ProvideNewPasswordControllerFactory;
import org.cryptomator.ui.convertvault.ConvertVaultModule_ProvideRecoveryKeyPropertyFactory;
import org.cryptomator.ui.convertvault.ConvertVaultModule_ProvideStageFactory;
import org.cryptomator.ui.convertvault.ConvertVaultModule_VaultConfigFactory;
import org.cryptomator.ui.convertvault.HubToPasswordConvertController;
import org.cryptomator.ui.convertvault.HubToPasswordStartController;
import org.cryptomator.ui.convertvault.HubToPasswordSuccessController;
import org.cryptomator.ui.convertvault.HubToPasswordSuccessController_Factory;
import org.cryptomator.ui.dokanysupportend.DokanySupportEndComponent;
import org.cryptomator.ui.dokanysupportend.DokanySupportEndController;
import org.cryptomator.ui.dokanysupportend.DokanySupportEndController_Factory;
import org.cryptomator.ui.dokanysupportend.DokanySupportEndModule_ProvideDokanySupportEndSceneFactory;
import org.cryptomator.ui.dokanysupportend.DokanySupportEndModule_ProvideFxmlLoaderFactoryFactory;
import org.cryptomator.ui.dokanysupportend.DokanySupportEndModule_ProvideStageFactory;
import org.cryptomator.ui.error.ErrorComponent;
import org.cryptomator.ui.error.ErrorController;
import org.cryptomator.ui.error.ErrorController_Factory;
import org.cryptomator.ui.error.ErrorModule_ProvideErrorCodeFactory;
import org.cryptomator.ui.error.ErrorModule_ProvideErrorSceneFactory;
import org.cryptomator.ui.error.ErrorModule_ProvideFxmlLoaderFactoryFactory;
import org.cryptomator.ui.error.ErrorModule_ProvideStackTraceFactory;
import org.cryptomator.ui.forgetpassword.ForgetPasswordComponent;
import org.cryptomator.ui.forgetpassword.ForgetPasswordController;
import org.cryptomator.ui.forgetpassword.ForgetPasswordModule_ProvideConfirmedPropertyFactory;
import org.cryptomator.ui.forgetpassword.ForgetPasswordModule_ProvideForgetPasswordSceneFactory;
import org.cryptomator.ui.forgetpassword.ForgetPasswordModule_ProvideFxmlLoaderFactoryFactory;
import org.cryptomator.ui.forgetpassword.ForgetPasswordModule_ProvideStageFactory;
import org.cryptomator.ui.fxapp.AppLaunchEventHandler_Factory;
import org.cryptomator.ui.fxapp.AutoUnlocker;
import org.cryptomator.ui.fxapp.FxApplication;
import org.cryptomator.ui.fxapp.FxApplicationComponent;
import org.cryptomator.ui.fxapp.FxApplicationModule_ProvideMainWindowComponentFactory;
import org.cryptomator.ui.fxapp.FxApplicationModule_ProvidePreferencesComponentFactory;
import org.cryptomator.ui.fxapp.FxApplicationModule_ProvideTrayMenuComponentFactory;
import org.cryptomator.ui.fxapp.FxApplicationStyle;
import org.cryptomator.ui.fxapp.FxApplicationTerminator;
import org.cryptomator.ui.fxapp.FxApplicationWindows;
import org.cryptomator.ui.fxapp.FxApplication_Factory;
import org.cryptomator.ui.fxapp.UpdateChecker;
import org.cryptomator.ui.fxapp.UpdateCheckerModule_ProvideCheckForUpdateIntervalFactory;
import org.cryptomator.ui.fxapp.UpdateCheckerModule_ProvideCheckForUpdatesRequestFactory;
import org.cryptomator.ui.fxapp.UpdateCheckerModule_ProvideCheckForUpdatesServiceFactory;
import org.cryptomator.ui.fxapp.UpdateCheckerModule_ProvideHttpClientFactory;
import org.cryptomator.ui.fxapp.UpdateChecker_Factory;
import org.cryptomator.ui.health.Check;
import org.cryptomator.ui.health.CheckDetailController;
import org.cryptomator.ui.health.CheckDetailController_Factory;
import org.cryptomator.ui.health.CheckExecutor;
import org.cryptomator.ui.health.CheckListCellController;
import org.cryptomator.ui.health.CheckListCellFactory;
import org.cryptomator.ui.health.CheckListCellFactory_Factory;
import org.cryptomator.ui.health.CheckListController;
import org.cryptomator.ui.health.HealthCheckComponent;
import org.cryptomator.ui.health.HealthCheckModule_ProvideAvailableChecksFactory;
import org.cryptomator.ui.health.HealthCheckModule_ProvideFxmlLoaderFactoryFactory;
import org.cryptomator.ui.health.HealthCheckModule_ProvideHealthCheckListSceneFactory;
import org.cryptomator.ui.health.HealthCheckModule_ProvideHealthStartSceneFactory;
import org.cryptomator.ui.health.HealthCheckModule_ProvideKeyLoadingStrategyFactory;
import org.cryptomator.ui.health.HealthCheckModule_ProvideMasterkeyRefFactory;
import org.cryptomator.ui.health.HealthCheckModule_ProvideSelectedCheckFactory;
import org.cryptomator.ui.health.HealthCheckModule_ProvideStageFactory;
import org.cryptomator.ui.health.HealthCheckModule_ProvideUnlockWindowFactory;
import org.cryptomator.ui.health.HealthCheckModule_ProvideVaultConfigRefFactory;
import org.cryptomator.ui.health.HealthCheckModule_ProvideWindowShowingChangeListenerFactory;
import org.cryptomator.ui.health.ReportWriter;
import org.cryptomator.ui.health.ResultFixApplier_Factory;
import org.cryptomator.ui.health.ResultListCellController;
import org.cryptomator.ui.health.ResultListCellController_Factory;
import org.cryptomator.ui.health.ResultListCellFactory;
import org.cryptomator.ui.health.ResultListCellFactory_Factory;
import org.cryptomator.ui.health.StartController;
import org.cryptomator.ui.keyloading.KeyLoadingComponent;
import org.cryptomator.ui.keyloading.KeyLoadingModule_ProvideFxmlLoaderFactoryFactory;
import org.cryptomator.ui.keyloading.KeyLoadingModule_ProvideKeyLoadingStrategyFactory;
import org.cryptomator.ui.keyloading.KeyLoadingStrategy;
import org.cryptomator.ui.keyloading.hub.AuthFlowController;
import org.cryptomator.ui.keyloading.hub.HubConfig;
import org.cryptomator.ui.keyloading.hub.HubKeyLoadingModule_ProvideBearerTokenRefFactory;
import org.cryptomator.ui.keyloading.hub.HubKeyLoadingModule_ProvideDeviceIdFactory;
import org.cryptomator.ui.keyloading.hub.HubKeyLoadingModule_ProvideHubAuthFlowSceneFactory;
import org.cryptomator.ui.keyloading.hub.HubKeyLoadingModule_ProvideHubConfigFactory;
import org.cryptomator.ui.keyloading.hub.HubKeyLoadingModule_ProvideHubLegacyRegisterDeviceSceneFactory;
import org.cryptomator.ui.keyloading.hub.HubKeyLoadingModule_ProvideHubLegacyRegisterSuccessSceneFactory;
import org.cryptomator.ui.keyloading.hub.HubKeyLoadingModule_ProvideHubNoKeychainSceneFactory;
import org.cryptomator.ui.keyloading.hub.HubKeyLoadingModule_ProvideHubReceiveKeySceneFactory;
import org.cryptomator.ui.keyloading.hub.HubKeyLoadingModule_ProvideHubRegisterDeviceAlreadyExistsSceneFactory;
import org.cryptomator.ui.keyloading.hub.HubKeyLoadingModule_ProvideHubRegisterDeviceSceneFactory;
import org.cryptomator.ui.keyloading.hub.HubKeyLoadingModule_ProvideHubRegisterFailedSceneFactory;
import org.cryptomator.ui.keyloading.hub.HubKeyLoadingModule_ProvideHubRegisterSuccessSceneFactory;
import org.cryptomator.ui.keyloading.hub.HubKeyLoadingModule_ProvideHubUnauthorizedDeviceSceneFactory;
import org.cryptomator.ui.keyloading.hub.HubKeyLoadingModule_ProvideInvalidLicenseSceneFactory;
import org.cryptomator.ui.keyloading.hub.HubKeyLoadingModule_ProvideRequireAccountInitSceneFactory;
import org.cryptomator.ui.keyloading.hub.HubKeyLoadingModule_ProvideResultFactory;
import org.cryptomator.ui.keyloading.hub.HubKeyLoadingModule_ProvideWindowTitleFactory;
import org.cryptomator.ui.keyloading.hub.HubKeyLoadingStrategy;
import org.cryptomator.ui.keyloading.hub.InvalidLicenseController;
import org.cryptomator.ui.keyloading.hub.LegacyRegisterDeviceController;
import org.cryptomator.ui.keyloading.hub.LegacyRegisterSuccessController;
import org.cryptomator.ui.keyloading.hub.NoKeychainController;
import org.cryptomator.ui.keyloading.hub.ReceiveKeyController;
import org.cryptomator.ui.keyloading.hub.RegisterDeviceController;
import org.cryptomator.ui.keyloading.hub.RegisterFailedController;
import org.cryptomator.ui.keyloading.hub.RegisterSuccessController;
import org.cryptomator.ui.keyloading.hub.RequireAccountInitController;
import org.cryptomator.ui.keyloading.hub.UnauthorizedDeviceController;
import org.cryptomator.ui.keyloading.masterkeyfile.ChooseMasterkeyFileComponent;
import org.cryptomator.ui.keyloading.masterkeyfile.ChooseMasterkeyFileController;
import org.cryptomator.ui.keyloading.masterkeyfile.ChooseMasterkeyFileModule_ProvideChooseMasterkeySceneFactory;
import org.cryptomator.ui.keyloading.masterkeyfile.ChooseMasterkeyFileModule_ProvideResultFactory;
import org.cryptomator.ui.keyloading.masterkeyfile.MasterkeyFileLoadingModule_ProvideStoredPasswordFactory;
import org.cryptomator.ui.keyloading.masterkeyfile.MasterkeyFileLoadingStrategy;
import org.cryptomator.ui.keyloading.masterkeyfile.PassphraseEntryComponent;
import org.cryptomator.ui.keyloading.masterkeyfile.PassphraseEntryController;
import org.cryptomator.ui.keyloading.masterkeyfile.PassphraseEntryModule_ProvideResultFactory;
import org.cryptomator.ui.keyloading.masterkeyfile.PassphraseEntryModule_ProvideUnlockSceneFactory;
import org.cryptomator.ui.keyloading.masterkeyfile.PassphraseEntryResult;
import org.cryptomator.ui.lock.LockComponent;
import org.cryptomator.ui.lock.LockFailedController;
import org.cryptomator.ui.lock.LockForcedController;
import org.cryptomator.ui.lock.LockModule_ProvideForceLockSceneFactory;
import org.cryptomator.ui.lock.LockModule_ProvideForceRetryDecisionRefFactory;
import org.cryptomator.ui.lock.LockModule_ProvideFxmlLoaderFactoryFactory;
import org.cryptomator.ui.lock.LockModule_ProvideLockFailedSceneFactory;
import org.cryptomator.ui.lock.LockModule_ProvideWindowFactory;
import org.cryptomator.ui.lock.LockWorkflow;
import org.cryptomator.ui.mainwindow.MainWindowComponent;
import org.cryptomator.ui.mainwindow.MainWindowController;
import org.cryptomator.ui.mainwindow.MainWindowModule_ProvideErrorStageFactory;
import org.cryptomator.ui.mainwindow.MainWindowModule_ProvideFxmlLoaderFactoryFactory;
import org.cryptomator.ui.mainwindow.MainWindowModule_ProvideMainSceneFactory;
import org.cryptomator.ui.mainwindow.MainWindowModule_ProvideMainWindowFactory;
import org.cryptomator.ui.mainwindow.MainWindowModule_ProvideSelectedVaultFactory;
import org.cryptomator.ui.mainwindow.MainWindowSceneFactory;
import org.cryptomator.ui.mainwindow.MainWindowTitleController;
import org.cryptomator.ui.mainwindow.MainWindowTitleController_Factory;
import org.cryptomator.ui.mainwindow.ResizeController;
import org.cryptomator.ui.mainwindow.ResizeController_Factory;
import org.cryptomator.ui.mainwindow.VaultDetailController;
import org.cryptomator.ui.mainwindow.VaultDetailController_Factory;
import org.cryptomator.ui.mainwindow.VaultDetailLockedController;
import org.cryptomator.ui.mainwindow.VaultDetailLockedController_Factory;
import org.cryptomator.ui.mainwindow.VaultDetailMissingVaultController;
import org.cryptomator.ui.mainwindow.VaultDetailNeedsMigrationController;
import org.cryptomator.ui.mainwindow.VaultDetailUnknownErrorController;
import org.cryptomator.ui.mainwindow.VaultDetailUnlockedController;
import org.cryptomator.ui.mainwindow.VaultListCellController;
import org.cryptomator.ui.mainwindow.VaultListCellController_Factory;
import org.cryptomator.ui.mainwindow.VaultListCellFactory;
import org.cryptomator.ui.mainwindow.VaultListCellFactory_Factory;
import org.cryptomator.ui.mainwindow.VaultListContextMenuController;
import org.cryptomator.ui.mainwindow.VaultListContextMenuController_Factory;
import org.cryptomator.ui.mainwindow.VaultListController;
import org.cryptomator.ui.mainwindow.VaultListController_Factory;
import org.cryptomator.ui.mainwindow.WelcomeController;
import org.cryptomator.ui.migration.MigrationCapabilityErrorController;
import org.cryptomator.ui.migration.MigrationCapabilityErrorController_Factory;
import org.cryptomator.ui.migration.MigrationComponent;
import org.cryptomator.ui.migration.MigrationImpossibleController;
import org.cryptomator.ui.migration.MigrationImpossibleController_Factory;
import org.cryptomator.ui.migration.MigrationModule_ProvideCapabilityErrorCauseFactory;
import org.cryptomator.ui.migration.MigrationModule_ProvideFxmlLoaderFactoryFactory;
import org.cryptomator.ui.migration.MigrationModule_ProvideMigrationCapabilityErrorSceneFactory;
import org.cryptomator.ui.migration.MigrationModule_ProvideMigrationImpossibleSceneFactory;
import org.cryptomator.ui.migration.MigrationModule_ProvideMigrationRunSceneFactory;
import org.cryptomator.ui.migration.MigrationModule_ProvideMigrationStartSceneFactory;
import org.cryptomator.ui.migration.MigrationModule_ProvideMigrationSuccessSceneFactory;
import org.cryptomator.ui.migration.MigrationModule_ProvideStageFactory;
import org.cryptomator.ui.migration.MigrationRunController;
import org.cryptomator.ui.migration.MigrationStartController;
import org.cryptomator.ui.migration.MigrationSuccessController;
import org.cryptomator.ui.migration.MigrationSuccessController_Factory;
import org.cryptomator.ui.preferences.AboutController;
import org.cryptomator.ui.preferences.AboutController_Factory;
import org.cryptomator.ui.preferences.GeneralPreferencesController;
import org.cryptomator.ui.preferences.GeneralPreferencesController_Factory;
import org.cryptomator.ui.preferences.InterfacePreferencesController;
import org.cryptomator.ui.preferences.InterfacePreferencesController_Factory;
import org.cryptomator.ui.preferences.PreferencesComponent;
import org.cryptomator.ui.preferences.PreferencesController;
import org.cryptomator.ui.preferences.PreferencesModule_ProvideFxmlLoaderFactoryFactory;
import org.cryptomator.ui.preferences.PreferencesModule_ProvidePreferencesSceneFactory;
import org.cryptomator.ui.preferences.PreferencesModule_ProvideSelectedTabPropertyFactory;
import org.cryptomator.ui.preferences.PreferencesModule_ProvideStageFactory;
import org.cryptomator.ui.preferences.SelectedPreferencesTab;
import org.cryptomator.ui.preferences.SupporterCertificateController;
import org.cryptomator.ui.preferences.SupporterCertificateController_Factory;
import org.cryptomator.ui.preferences.UpdatesPreferencesController;
import org.cryptomator.ui.preferences.UpdatesPreferencesController_Factory;
import org.cryptomator.ui.preferences.VolumePreferencesController;
import org.cryptomator.ui.preferences.VolumePreferencesController_Factory;
import org.cryptomator.ui.quit.QuitComponent;
import org.cryptomator.ui.quit.QuitController;
import org.cryptomator.ui.quit.QuitController_Factory;
import org.cryptomator.ui.quit.QuitForcedController;
import org.cryptomator.ui.quit.QuitForcedController_Factory;
import org.cryptomator.ui.quit.QuitModule_ProvideFxmlLoaderFactoryFactory;
import org.cryptomator.ui.quit.QuitModule_ProvideQuitForcedSceneFactory;
import org.cryptomator.ui.quit.QuitModule_ProvideQuitResponseFactory;
import org.cryptomator.ui.quit.QuitModule_ProvideQuitSceneFactory;
import org.cryptomator.ui.quit.QuitModule_ProvideStageFactory;
import org.cryptomator.ui.recoverykey.RecoveryKeyComponent;
import org.cryptomator.ui.recoverykey.RecoveryKeyCreationController;
import org.cryptomator.ui.recoverykey.RecoveryKeyDisplayController;
import org.cryptomator.ui.recoverykey.RecoveryKeyFactory;
import org.cryptomator.ui.recoverykey.RecoveryKeyFactory_Factory;
import org.cryptomator.ui.recoverykey.RecoveryKeyModule_BindRecoveryKeyValidateControllerFactory;
import org.cryptomator.ui.recoverykey.RecoveryKeyModule_ProvideFxmlLoaderFactoryFactory;
import org.cryptomator.ui.recoverykey.RecoveryKeyModule_ProvideNewPasswordControllerFactory;
import org.cryptomator.ui.recoverykey.RecoveryKeyModule_ProvideRecoveryKeyCreationSceneFactory;
import org.cryptomator.ui.recoverykey.RecoveryKeyModule_ProvideRecoveryKeyDisplayControllerFactory;
import org.cryptomator.ui.recoverykey.RecoveryKeyModule_ProvideRecoveryKeyPropertyFactory;
import org.cryptomator.ui.recoverykey.RecoveryKeyModule_ProvideRecoveryKeyRecoverSceneFactory;
import org.cryptomator.ui.recoverykey.RecoveryKeyModule_ProvideRecoveryKeyResetPasswordSceneFactory;
import org.cryptomator.ui.recoverykey.RecoveryKeyModule_ProvideRecoveryKeyResetPasswordSuccessSceneFactory;
import org.cryptomator.ui.recoverykey.RecoveryKeyModule_ProvideRecoveryKeySuccessSceneFactory;
import org.cryptomator.ui.recoverykey.RecoveryKeyModule_ProvideStageFactory;
import org.cryptomator.ui.recoverykey.RecoveryKeyModule_VaultConfigFactory;
import org.cryptomator.ui.recoverykey.RecoveryKeyRecoverController;
import org.cryptomator.ui.recoverykey.RecoveryKeyResetPasswordController;
import org.cryptomator.ui.recoverykey.RecoveryKeyResetPasswordSuccessController;
import org.cryptomator.ui.recoverykey.RecoveryKeySuccessController;
import org.cryptomator.ui.recoverykey.RecoveryKeyValidateController;
import org.cryptomator.ui.recoverykey.WordEncoder_Factory;
import org.cryptomator.ui.removevault.RemoveVaultComponent;
import org.cryptomator.ui.removevault.RemoveVaultController;
import org.cryptomator.ui.removevault.RemoveVaultModule_ProvideFxmlLoaderFactoryFactory;
import org.cryptomator.ui.removevault.RemoveVaultModule_ProvideRemoveVaultSceneFactory;
import org.cryptomator.ui.removevault.RemoveVaultModule_ProvideStageFactory;
import org.cryptomator.ui.sharevault.ShareVaultComponent;
import org.cryptomator.ui.sharevault.ShareVaultController;
import org.cryptomator.ui.sharevault.ShareVaultController_Factory;
import org.cryptomator.ui.sharevault.ShareVaultModule_ProvideFxmlLoaderFactoryFactory;
import org.cryptomator.ui.sharevault.ShareVaultModule_ProvideShareVaultSceneFactory;
import org.cryptomator.ui.sharevault.ShareVaultModule_ProvideStageFactory;
import org.cryptomator.ui.stats.VaultStatisticsComponent;
import org.cryptomator.ui.stats.VaultStatisticsController;
import org.cryptomator.ui.stats.VaultStatisticsModule_ProvideFxmlLoaderFactoryFactory;
import org.cryptomator.ui.stats.VaultStatisticsModule_ProvideStageFactory;
import org.cryptomator.ui.stats.VaultStatisticsModule_ProvideVaultStatisticsSceneFactory;
import org.cryptomator.ui.traymenu.TrayMenuBuilder;
import org.cryptomator.ui.traymenu.TrayMenuBuilder_Factory;
import org.cryptomator.ui.traymenu.TrayMenuComponent;
import org.cryptomator.ui.traymenu.TrayMenuModule_ProvideFirstSupportedTrayMenuControllerFactory;
import org.cryptomator.ui.unlock.UnlockComponent;
import org.cryptomator.ui.unlock.UnlockInvalidMountPointController;
import org.cryptomator.ui.unlock.UnlockInvalidMountPointController_Factory;
import org.cryptomator.ui.unlock.UnlockModule_IllegalMountPointExceptionFactory;
import org.cryptomator.ui.unlock.UnlockModule_ProvideFxmlLoaderFactoryFactory;
import org.cryptomator.ui.unlock.UnlockModule_ProvideInvalidMountPointSceneFactory;
import org.cryptomator.ui.unlock.UnlockModule_ProvideKeyLoadingStrategyFactory;
import org.cryptomator.ui.unlock.UnlockModule_ProvideRestartRequiredSceneFactory;
import org.cryptomator.ui.unlock.UnlockModule_ProvideStageFactory;
import org.cryptomator.ui.unlock.UnlockModule_ProvideUnlockSuccessSceneFactory;
import org.cryptomator.ui.unlock.UnlockRequiresRestartController;
import org.cryptomator.ui.unlock.UnlockRequiresRestartController_Factory;
import org.cryptomator.ui.unlock.UnlockSuccessController;
import org.cryptomator.ui.unlock.UnlockWorkflow;
import org.cryptomator.ui.unlock.UnlockWorkflow_Factory;
import org.cryptomator.ui.updatereminder.UpdateReminderComponent;
import org.cryptomator.ui.updatereminder.UpdateReminderController;
import org.cryptomator.ui.updatereminder.UpdateReminderController_Factory;
import org.cryptomator.ui.updatereminder.UpdateReminderModule_ProvideFxmlLoaderFactoryFactory;
import org.cryptomator.ui.updatereminder.UpdateReminderModule_ProvideStageFactory;
import org.cryptomator.ui.updatereminder.UpdateReminderModule_ProvideUpdateReminderSceneFactory;
import org.cryptomator.ui.vaultoptions.GeneralVaultOptionsController;
import org.cryptomator.ui.vaultoptions.GeneralVaultOptionsController_Factory;
import org.cryptomator.ui.vaultoptions.HubOptionsController;
import org.cryptomator.ui.vaultoptions.MasterkeyOptionsController;
import org.cryptomator.ui.vaultoptions.MasterkeyOptionsController_Factory;
import org.cryptomator.ui.vaultoptions.MountOptionsController;
import org.cryptomator.ui.vaultoptions.MountOptionsController_Factory;
import org.cryptomator.ui.vaultoptions.SelectedVaultOptionsTab;
import org.cryptomator.ui.vaultoptions.VaultOptionsComponent;
import org.cryptomator.ui.vaultoptions.VaultOptionsController;
import org.cryptomator.ui.vaultoptions.VaultOptionsController_Factory;
import org.cryptomator.ui.vaultoptions.VaultOptionsModule_ProvideFxmlLoaderFactoryFactory;
import org.cryptomator.ui.vaultoptions.VaultOptionsModule_ProvideSelectedTabPropertyFactory;
import org.cryptomator.ui.vaultoptions.VaultOptionsModule_ProvideStageFactory;
import org.cryptomator.ui.vaultoptions.VaultOptionsModule_ProvideVaultOptionsSceneFactory;
import org.cryptomator.ui.wrongfilealert.WrongFileAlertComponent;
import org.cryptomator.ui.wrongfilealert.WrongFileAlertController;
import org.cryptomator.ui.wrongfilealert.WrongFileAlertModule_ProvideFxmlLoaderFactoryFactory;
import org.cryptomator.ui.wrongfilealert.WrongFileAlertModule_ProvideStageFactory;
import org.cryptomator.ui.wrongfilealert.WrongFileAlertModule_ProvideWrongFileAlertSceneFactory;

@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class DaggerCryptomatorComponent {
  private DaggerCryptomatorComponent() {}

  public static CryptomatorComponent.Factory factory() {
    return new Factory();
  }

  private static final class Factory implements CryptomatorComponent.Factory {
    @Override
    public CryptomatorComponent create(long startupTime) {
      Preconditions.checkNotNull(startupTime);
      return new CryptomatorComponentImpl(new VaultListModule(), startupTime);
    }
  }

  private static final class FxApplicationComponentBuilder
      implements FxApplicationComponent.Builder {
    private final CryptomatorComponentImpl cryptomatorComponentImpl;

    private Application fxApplication;

    private Stage primaryStage;

    private FxApplicationComponentBuilder(CryptomatorComponentImpl cryptomatorComponentImpl) {
      this.cryptomatorComponentImpl = cryptomatorComponentImpl;
    }

    @Override
    public FxApplicationComponentBuilder fxApplication(Application arg0) {
      this.fxApplication = Preconditions.checkNotNull(arg0);
      return this;
    }

    @Override
    public FxApplicationComponentBuilder primaryStage(Stage arg0) {
      this.primaryStage = Preconditions.checkNotNull(arg0);
      return this;
    }

    @Override
    public FxApplicationComponent build() {
      Preconditions.checkBuilderRequirement(fxApplication, Application.class);
      Preconditions.checkBuilderRequirement(primaryStage, Stage.class);
      return new FxApplicationComponentImpl(cryptomatorComponentImpl, fxApplication, primaryStage);
    }
  }

  private static final class MainWindowComponentBuilder implements MainWindowComponent.Builder {
    private final CryptomatorComponentImpl cryptomatorComponentImpl;

    private final FxApplicationComponentImpl fxApplicationComponentImpl;

    private MainWindowComponentBuilder(
        CryptomatorComponentImpl cryptomatorComponentImpl,
        FxApplicationComponentImpl fxApplicationComponentImpl) {
      this.cryptomatorComponentImpl = cryptomatorComponentImpl;
      this.fxApplicationComponentImpl = fxApplicationComponentImpl;
    }

    @Override
    public MainWindowComponent build() {
      return new MainWindowComponentImpl(cryptomatorComponentImpl, fxApplicationComponentImpl);
    }
  }

  private static final class RemoveVaultComponentBuilder implements RemoveVaultComponent.Builder {
    private final CryptomatorComponentImpl cryptomatorComponentImpl;

    private final FxApplicationComponentImpl fxApplicationComponentImpl;

    private final MainWindowComponentImpl mainWindowComponentImpl;

    private Vault vault;

    private RemoveVaultComponentBuilder(
        CryptomatorComponentImpl cryptomatorComponentImpl,
        FxApplicationComponentImpl fxApplicationComponentImpl,
        MainWindowComponentImpl mainWindowComponentImpl) {
      this.cryptomatorComponentImpl = cryptomatorComponentImpl;
      this.fxApplicationComponentImpl = fxApplicationComponentImpl;
      this.mainWindowComponentImpl = mainWindowComponentImpl;
    }

    @Override
    public RemoveVaultComponentBuilder vault(Vault arg0) {
      this.vault = Preconditions.checkNotNull(arg0);
      return this;
    }

    @Override
    public RemoveVaultComponent build() {
      Preconditions.checkBuilderRequirement(vault, Vault.class);
      return new RemoveVaultComponentImpl(
          cryptomatorComponentImpl, fxApplicationComponentImpl, mainWindowComponentImpl, vault);
    }
  }

  private static final class MigrationComponentBuilder implements MigrationComponent.Builder {
    private final CryptomatorComponentImpl cryptomatorComponentImpl;

    private final FxApplicationComponentImpl fxApplicationComponentImpl;

    private final MainWindowComponentImpl mainWindowComponentImpl;

    private Vault vault;

    private MigrationComponentBuilder(
        CryptomatorComponentImpl cryptomatorComponentImpl,
        FxApplicationComponentImpl fxApplicationComponentImpl,
        MainWindowComponentImpl mainWindowComponentImpl) {
      this.cryptomatorComponentImpl = cryptomatorComponentImpl;
      this.fxApplicationComponentImpl = fxApplicationComponentImpl;
      this.mainWindowComponentImpl = mainWindowComponentImpl;
    }

    @Override
    public MigrationComponentBuilder vault(Vault arg0) {
      this.vault = Preconditions.checkNotNull(arg0);
      return this;
    }

    @Override
    public MigrationComponent build() {
      Preconditions.checkBuilderRequirement(vault, Vault.class);
      return new MigrationComponentImpl(
          cryptomatorComponentImpl, fxApplicationComponentImpl, mainWindowComponentImpl, vault);
    }
  }

  private static final class VaultStatisticsComponentBuilder
      implements VaultStatisticsComponent.Builder {
    private final CryptomatorComponentImpl cryptomatorComponentImpl;

    private final FxApplicationComponentImpl fxApplicationComponentImpl;

    private final MainWindowComponentImpl mainWindowComponentImpl;

    private Vault vault;

    private VaultStatisticsComponentBuilder(
        CryptomatorComponentImpl cryptomatorComponentImpl,
        FxApplicationComponentImpl fxApplicationComponentImpl,
        MainWindowComponentImpl mainWindowComponentImpl) {
      this.cryptomatorComponentImpl = cryptomatorComponentImpl;
      this.fxApplicationComponentImpl = fxApplicationComponentImpl;
      this.mainWindowComponentImpl = mainWindowComponentImpl;
    }

    @Override
    public VaultStatisticsComponentBuilder vault(Vault arg0) {
      this.vault = Preconditions.checkNotNull(arg0);
      return this;
    }

    @Override
    public VaultStatisticsComponent build() {
      Preconditions.checkBuilderRequirement(vault, Vault.class);
      return new VaultStatisticsComponentImpl(
          cryptomatorComponentImpl, fxApplicationComponentImpl, mainWindowComponentImpl, vault);
    }
  }

  private static final class WrongFileAlertComponentBuilder
      implements WrongFileAlertComponent.Builder {
    private final CryptomatorComponentImpl cryptomatorComponentImpl;

    private final FxApplicationComponentImpl fxApplicationComponentImpl;

    private final MainWindowComponentImpl mainWindowComponentImpl;

    private WrongFileAlertComponentBuilder(
        CryptomatorComponentImpl cryptomatorComponentImpl,
        FxApplicationComponentImpl fxApplicationComponentImpl,
        MainWindowComponentImpl mainWindowComponentImpl) {
      this.cryptomatorComponentImpl = cryptomatorComponentImpl;
      this.fxApplicationComponentImpl = fxApplicationComponentImpl;
      this.mainWindowComponentImpl = mainWindowComponentImpl;
    }

    @Override
    public WrongFileAlertComponent build() {
      return new WrongFileAlertComponentImpl(
          cryptomatorComponentImpl, fxApplicationComponentImpl, mainWindowComponentImpl);
    }
  }

  private static final class AddVaultWizardComponentBuilder
      implements AddVaultWizardComponent.Builder {
    private final CryptomatorComponentImpl cryptomatorComponentImpl;

    private final FxApplicationComponentImpl fxApplicationComponentImpl;

    private final MainWindowComponentImpl mainWindowComponentImpl;

    private AddVaultWizardComponentBuilder(
        CryptomatorComponentImpl cryptomatorComponentImpl,
        FxApplicationComponentImpl fxApplicationComponentImpl,
        MainWindowComponentImpl mainWindowComponentImpl) {
      this.cryptomatorComponentImpl = cryptomatorComponentImpl;
      this.fxApplicationComponentImpl = fxApplicationComponentImpl;
      this.mainWindowComponentImpl = mainWindowComponentImpl;
    }

    @Override
    public AddVaultWizardComponent build() {
      return new AddVaultWizardComponentImpl(
          cryptomatorComponentImpl, fxApplicationComponentImpl, mainWindowComponentImpl);
    }
  }

  private static final class PreferencesComponentBuilder implements PreferencesComponent.Builder {
    private final CryptomatorComponentImpl cryptomatorComponentImpl;

    private final FxApplicationComponentImpl fxApplicationComponentImpl;

    private PreferencesComponentBuilder(
        CryptomatorComponentImpl cryptomatorComponentImpl,
        FxApplicationComponentImpl fxApplicationComponentImpl) {
      this.cryptomatorComponentImpl = cryptomatorComponentImpl;
      this.fxApplicationComponentImpl = fxApplicationComponentImpl;
    }

    @Override
    public PreferencesComponent build() {
      return new PreferencesComponentImpl(cryptomatorComponentImpl, fxApplicationComponentImpl);
    }
  }

  private static final class QuitComponentBuilder implements QuitComponent.Builder {
    private final CryptomatorComponentImpl cryptomatorComponentImpl;

    private final FxApplicationComponentImpl fxApplicationComponentImpl;

    private QuitComponentBuilder(
        CryptomatorComponentImpl cryptomatorComponentImpl,
        FxApplicationComponentImpl fxApplicationComponentImpl) {
      this.cryptomatorComponentImpl = cryptomatorComponentImpl;
      this.fxApplicationComponentImpl = fxApplicationComponentImpl;
    }

    @Override
    public QuitComponent build() {
      return new QuitComponentImpl(cryptomatorComponentImpl, fxApplicationComponentImpl);
    }
  }

  private static final class UnlockComponentFactory implements UnlockComponent.Factory {
    private final CryptomatorComponentImpl cryptomatorComponentImpl;

    private final FxApplicationComponentImpl fxApplicationComponentImpl;

    private UnlockComponentFactory(
        CryptomatorComponentImpl cryptomatorComponentImpl,
        FxApplicationComponentImpl fxApplicationComponentImpl) {
      this.cryptomatorComponentImpl = cryptomatorComponentImpl;
      this.fxApplicationComponentImpl = fxApplicationComponentImpl;
    }

    @Override
    public UnlockComponent create(Vault arg0, Stage arg1) {
      Preconditions.checkNotNull(arg0);
      return new UnlockComponentImpl(
          cryptomatorComponentImpl, fxApplicationComponentImpl, arg0, arg1);
    }
  }

  private static final class ocuk_KeyLoadingComponentBuilder
      implements KeyLoadingComponent.Builder {
    private final CryptomatorComponentImpl cryptomatorComponentImpl;

    private final FxApplicationComponentImpl fxApplicationComponentImpl;

    private final UnlockComponentImpl unlockComponentImpl;

    private Vault vault;

    private Stage window;

    private ocuk_KeyLoadingComponentBuilder(
        CryptomatorComponentImpl cryptomatorComponentImpl,
        FxApplicationComponentImpl fxApplicationComponentImpl,
        UnlockComponentImpl unlockComponentImpl) {
      this.cryptomatorComponentImpl = cryptomatorComponentImpl;
      this.fxApplicationComponentImpl = fxApplicationComponentImpl;
      this.unlockComponentImpl = unlockComponentImpl;
    }

    @Override
    public ocuk_KeyLoadingComponentBuilder vault(Vault arg0) {
      this.vault = Preconditions.checkNotNull(arg0);
      return this;
    }

    @Override
    public ocuk_KeyLoadingComponentBuilder window(Stage arg0) {
      this.window = Preconditions.checkNotNull(arg0);
      return this;
    }

    @Override
    public KeyLoadingComponent build() {
      Preconditions.checkBuilderRequirement(vault, Vault.class);
      Preconditions.checkBuilderRequirement(window, Stage.class);
      return new ocuk_KeyLoadingComponentImpl(
          cryptomatorComponentImpl, fxApplicationComponentImpl, unlockComponentImpl, vault, window);
    }
  }

  private static final class ocukm_PassphraseEntryComponentBuilder
      implements PassphraseEntryComponent.Builder {
    private final CryptomatorComponentImpl cryptomatorComponentImpl;

    private final FxApplicationComponentImpl fxApplicationComponentImpl;

    private final UnlockComponentImpl unlockComponentImpl;

    private final ocuk_KeyLoadingComponentImpl _ocuk_KeyLoadingComponentImpl;

    private Passphrase savedPassword;

    private ocukm_PassphraseEntryComponentBuilder(
        CryptomatorComponentImpl cryptomatorComponentImpl,
        FxApplicationComponentImpl fxApplicationComponentImpl,
        UnlockComponentImpl unlockComponentImpl,
        ocuk_KeyLoadingComponentImpl _ocuk_KeyLoadingComponentImpl) {
      this.cryptomatorComponentImpl = cryptomatorComponentImpl;
      this.fxApplicationComponentImpl = fxApplicationComponentImpl;
      this.unlockComponentImpl = unlockComponentImpl;
      this._ocuk_KeyLoadingComponentImpl = _ocuk_KeyLoadingComponentImpl;
    }

    @Override
    public ocukm_PassphraseEntryComponentBuilder savedPassword(Passphrase arg0) {
      this.savedPassword = arg0;
      return this;
    }

    @Override
    public PassphraseEntryComponent build() {
      return new ocukm_PassphraseEntryComponentImpl(
          cryptomatorComponentImpl,
          fxApplicationComponentImpl,
          unlockComponentImpl,
          _ocuk_KeyLoadingComponentImpl,
          savedPassword);
    }
  }

  private static final class ocukm_ChooseMasterkeyFileComponentBuilder
      implements ChooseMasterkeyFileComponent.Builder {
    private final CryptomatorComponentImpl cryptomatorComponentImpl;

    private final FxApplicationComponentImpl fxApplicationComponentImpl;

    private final UnlockComponentImpl unlockComponentImpl;

    private final ocuk_KeyLoadingComponentImpl _ocuk_KeyLoadingComponentImpl;

    private ocukm_ChooseMasterkeyFileComponentBuilder(
        CryptomatorComponentImpl cryptomatorComponentImpl,
        FxApplicationComponentImpl fxApplicationComponentImpl,
        UnlockComponentImpl unlockComponentImpl,
        ocuk_KeyLoadingComponentImpl _ocuk_KeyLoadingComponentImpl) {
      this.cryptomatorComponentImpl = cryptomatorComponentImpl;
      this.fxApplicationComponentImpl = fxApplicationComponentImpl;
      this.unlockComponentImpl = unlockComponentImpl;
      this._ocuk_KeyLoadingComponentImpl = _ocuk_KeyLoadingComponentImpl;
    }

    @Override
    public ChooseMasterkeyFileComponent build() {
      return new ocukm_ChooseMasterkeyFileComponentImpl(
          cryptomatorComponentImpl,
          fxApplicationComponentImpl,
          unlockComponentImpl,
          _ocuk_KeyLoadingComponentImpl);
    }
  }

  private static final class ocuf_ForgetPasswordComponentBuilder
      implements ForgetPasswordComponent.Builder {
    private final CryptomatorComponentImpl cryptomatorComponentImpl;

    private final FxApplicationComponentImpl fxApplicationComponentImpl;

    private final UnlockComponentImpl unlockComponentImpl;

    private final ocuk_KeyLoadingComponentImpl _ocuk_KeyLoadingComponentImpl;

    private Stage owner;

    private Vault vault;

    private ocuf_ForgetPasswordComponentBuilder(
        CryptomatorComponentImpl cryptomatorComponentImpl,
        FxApplicationComponentImpl fxApplicationComponentImpl,
        UnlockComponentImpl unlockComponentImpl,
        ocuk_KeyLoadingComponentImpl _ocuk_KeyLoadingComponentImpl) {
      this.cryptomatorComponentImpl = cryptomatorComponentImpl;
      this.fxApplicationComponentImpl = fxApplicationComponentImpl;
      this.unlockComponentImpl = unlockComponentImpl;
      this._ocuk_KeyLoadingComponentImpl = _ocuk_KeyLoadingComponentImpl;
    }

    @Override
    public ocuf_ForgetPasswordComponentBuilder owner(Stage arg0) {
      this.owner = Preconditions.checkNotNull(arg0);
      return this;
    }

    @Override
    public ocuf_ForgetPasswordComponentBuilder vault(Vault arg0) {
      this.vault = Preconditions.checkNotNull(arg0);
      return this;
    }

    @Override
    public ForgetPasswordComponent build() {
      Preconditions.checkBuilderRequirement(owner, Stage.class);
      Preconditions.checkBuilderRequirement(vault, Vault.class);
      return new ocuf_ForgetPasswordComponentImpl(
          cryptomatorComponentImpl,
          fxApplicationComponentImpl,
          unlockComponentImpl,
          _ocuk_KeyLoadingComponentImpl,
          owner,
          vault);
    }
  }

  private static final class UpdateReminderComponentFactory
      implements UpdateReminderComponent.Factory {
    private final CryptomatorComponentImpl cryptomatorComponentImpl;

    private final FxApplicationComponentImpl fxApplicationComponentImpl;

    private UpdateReminderComponentFactory(
        CryptomatorComponentImpl cryptomatorComponentImpl,
        FxApplicationComponentImpl fxApplicationComponentImpl) {
      this.cryptomatorComponentImpl = cryptomatorComponentImpl;
      this.fxApplicationComponentImpl = fxApplicationComponentImpl;
    }

    @Override
    public UpdateReminderComponent create() {
      return new UpdateReminderComponentImpl(cryptomatorComponentImpl, fxApplicationComponentImpl);
    }
  }

  private static final class DokanySupportEndComponentFactory
      implements DokanySupportEndComponent.Factory {
    private final CryptomatorComponentImpl cryptomatorComponentImpl;

    private final FxApplicationComponentImpl fxApplicationComponentImpl;

    private DokanySupportEndComponentFactory(
        CryptomatorComponentImpl cryptomatorComponentImpl,
        FxApplicationComponentImpl fxApplicationComponentImpl) {
      this.cryptomatorComponentImpl = cryptomatorComponentImpl;
      this.fxApplicationComponentImpl = fxApplicationComponentImpl;
    }

    @Override
    public DokanySupportEndComponent create() {
      return new DokanySupportEndComponentImpl(
          cryptomatorComponentImpl, fxApplicationComponentImpl);
    }
  }

  private static final class LockComponentFactory implements LockComponent.Factory {
    private final CryptomatorComponentImpl cryptomatorComponentImpl;

    private final FxApplicationComponentImpl fxApplicationComponentImpl;

    private LockComponentFactory(
        CryptomatorComponentImpl cryptomatorComponentImpl,
        FxApplicationComponentImpl fxApplicationComponentImpl) {
      this.cryptomatorComponentImpl = cryptomatorComponentImpl;
      this.fxApplicationComponentImpl = fxApplicationComponentImpl;
    }

    @Override
    public LockComponent create(Vault arg0, Stage arg1) {
      Preconditions.checkNotNull(arg0);
      return new LockComponentImpl(
          cryptomatorComponentImpl, fxApplicationComponentImpl, arg0, arg1);
    }
  }

  private static final class ErrorComponentFactory implements ErrorComponent.Factory {
    private final CryptomatorComponentImpl cryptomatorComponentImpl;

    private final FxApplicationComponentImpl fxApplicationComponentImpl;

    private ErrorComponentFactory(
        CryptomatorComponentImpl cryptomatorComponentImpl,
        FxApplicationComponentImpl fxApplicationComponentImpl) {
      this.cryptomatorComponentImpl = cryptomatorComponentImpl;
      this.fxApplicationComponentImpl = fxApplicationComponentImpl;
    }

    @Override
    public ErrorComponent create(Throwable arg0, Stage arg1, Scene arg2) {
      Preconditions.checkNotNull(arg0);
      Preconditions.checkNotNull(arg1);
      return new ErrorComponentImpl(
          cryptomatorComponentImpl, fxApplicationComponentImpl, arg0, arg1, arg2);
    }
  }

  private static final class VaultOptionsComponentFactory implements VaultOptionsComponent.Factory {
    private final CryptomatorComponentImpl cryptomatorComponentImpl;

    private final FxApplicationComponentImpl fxApplicationComponentImpl;

    private VaultOptionsComponentFactory(
        CryptomatorComponentImpl cryptomatorComponentImpl,
        FxApplicationComponentImpl fxApplicationComponentImpl) {
      this.cryptomatorComponentImpl = cryptomatorComponentImpl;
      this.fxApplicationComponentImpl = fxApplicationComponentImpl;
    }

    @Override
    public VaultOptionsComponent create(Vault arg0) {
      Preconditions.checkNotNull(arg0);
      return new VaultOptionsComponentImpl(
          cryptomatorComponentImpl, fxApplicationComponentImpl, arg0);
    }
  }

  private static final class ConvertVaultComponentFactory implements ConvertVaultComponent.Factory {
    private final CryptomatorComponentImpl cryptomatorComponentImpl;

    private final FxApplicationComponentImpl fxApplicationComponentImpl;

    private final VaultOptionsComponentImpl vaultOptionsComponentImpl;

    private ConvertVaultComponentFactory(
        CryptomatorComponentImpl cryptomatorComponentImpl,
        FxApplicationComponentImpl fxApplicationComponentImpl,
        VaultOptionsComponentImpl vaultOptionsComponentImpl) {
      this.cryptomatorComponentImpl = cryptomatorComponentImpl;
      this.fxApplicationComponentImpl = fxApplicationComponentImpl;
      this.vaultOptionsComponentImpl = vaultOptionsComponentImpl;
    }

    @Override
    public ConvertVaultComponent create(Vault arg0, Stage arg1) {
      Preconditions.checkNotNull(arg0);
      Preconditions.checkNotNull(arg1);
      return new ConvertVaultComponentImpl(
          cryptomatorComponentImpl,
          fxApplicationComponentImpl,
          vaultOptionsComponentImpl,
          arg0,
          arg1);
    }
  }

  private static final class ChangePasswordComponentBuilder
      implements ChangePasswordComponent.Builder {
    private final CryptomatorComponentImpl cryptomatorComponentImpl;

    private final FxApplicationComponentImpl fxApplicationComponentImpl;

    private final VaultOptionsComponentImpl vaultOptionsComponentImpl;

    private Stage owner;

    private Vault vault;

    private ChangePasswordComponentBuilder(
        CryptomatorComponentImpl cryptomatorComponentImpl,
        FxApplicationComponentImpl fxApplicationComponentImpl,
        VaultOptionsComponentImpl vaultOptionsComponentImpl) {
      this.cryptomatorComponentImpl = cryptomatorComponentImpl;
      this.fxApplicationComponentImpl = fxApplicationComponentImpl;
      this.vaultOptionsComponentImpl = vaultOptionsComponentImpl;
    }

    @Override
    public ChangePasswordComponentBuilder owner(Stage arg0) {
      this.owner = Preconditions.checkNotNull(arg0);
      return this;
    }

    @Override
    public ChangePasswordComponentBuilder vault(Vault arg0) {
      this.vault = Preconditions.checkNotNull(arg0);
      return this;
    }

    @Override
    public ChangePasswordComponent build() {
      Preconditions.checkBuilderRequirement(owner, Stage.class);
      Preconditions.checkBuilderRequirement(vault, Vault.class);
      return new ChangePasswordComponentImpl(
          cryptomatorComponentImpl,
          fxApplicationComponentImpl,
          vaultOptionsComponentImpl,
          owner,
          vault);
    }
  }

  private static final class RecoveryKeyComponentFactory implements RecoveryKeyComponent.Factory {
    private final CryptomatorComponentImpl cryptomatorComponentImpl;

    private final FxApplicationComponentImpl fxApplicationComponentImpl;

    private final VaultOptionsComponentImpl vaultOptionsComponentImpl;

    private RecoveryKeyComponentFactory(
        CryptomatorComponentImpl cryptomatorComponentImpl,
        FxApplicationComponentImpl fxApplicationComponentImpl,
        VaultOptionsComponentImpl vaultOptionsComponentImpl) {
      this.cryptomatorComponentImpl = cryptomatorComponentImpl;
      this.fxApplicationComponentImpl = fxApplicationComponentImpl;
      this.vaultOptionsComponentImpl = vaultOptionsComponentImpl;
    }

    @Override
    public RecoveryKeyComponent create(Vault arg0, Stage arg1) {
      Preconditions.checkNotNull(arg0);
      Preconditions.checkNotNull(arg1);
      return new RecoveryKeyComponentImpl(
          cryptomatorComponentImpl,
          fxApplicationComponentImpl,
          vaultOptionsComponentImpl,
          arg0,
          arg1);
    }
  }

  private static final class ocuf2_ForgetPasswordComponentBuilder
      implements ForgetPasswordComponent.Builder {
    private final CryptomatorComponentImpl cryptomatorComponentImpl;

    private final FxApplicationComponentImpl fxApplicationComponentImpl;

    private final VaultOptionsComponentImpl vaultOptionsComponentImpl;

    private Stage owner;

    private Vault vault;

    private ocuf2_ForgetPasswordComponentBuilder(
        CryptomatorComponentImpl cryptomatorComponentImpl,
        FxApplicationComponentImpl fxApplicationComponentImpl,
        VaultOptionsComponentImpl vaultOptionsComponentImpl) {
      this.cryptomatorComponentImpl = cryptomatorComponentImpl;
      this.fxApplicationComponentImpl = fxApplicationComponentImpl;
      this.vaultOptionsComponentImpl = vaultOptionsComponentImpl;
    }

    @Override
    public ocuf2_ForgetPasswordComponentBuilder owner(Stage arg0) {
      this.owner = Preconditions.checkNotNull(arg0);
      return this;
    }

    @Override
    public ocuf2_ForgetPasswordComponentBuilder vault(Vault arg0) {
      this.vault = Preconditions.checkNotNull(arg0);
      return this;
    }

    @Override
    public ForgetPasswordComponent build() {
      Preconditions.checkBuilderRequirement(owner, Stage.class);
      Preconditions.checkBuilderRequirement(vault, Vault.class);
      return new ocuf2_ForgetPasswordComponentImpl(
          cryptomatorComponentImpl,
          fxApplicationComponentImpl,
          vaultOptionsComponentImpl,
          owner,
          vault);
    }
  }

  private static final class ShareVaultComponentFactory implements ShareVaultComponent.Factory {
    private final CryptomatorComponentImpl cryptomatorComponentImpl;

    private final FxApplicationComponentImpl fxApplicationComponentImpl;

    private ShareVaultComponentFactory(
        CryptomatorComponentImpl cryptomatorComponentImpl,
        FxApplicationComponentImpl fxApplicationComponentImpl) {
      this.cryptomatorComponentImpl = cryptomatorComponentImpl;
      this.fxApplicationComponentImpl = fxApplicationComponentImpl;
    }

    @Override
    public ShareVaultComponent create(Vault arg0) {
      Preconditions.checkNotNull(arg0);
      return new ShareVaultComponentImpl(
          cryptomatorComponentImpl, fxApplicationComponentImpl, arg0);
    }
  }

  private static final class TrayMenuComponentBuilder implements TrayMenuComponent.Builder {
    private final CryptomatorComponentImpl cryptomatorComponentImpl;

    private final FxApplicationComponentImpl fxApplicationComponentImpl;

    private TrayMenuComponentBuilder(
        CryptomatorComponentImpl cryptomatorComponentImpl,
        FxApplicationComponentImpl fxApplicationComponentImpl) {
      this.cryptomatorComponentImpl = cryptomatorComponentImpl;
      this.fxApplicationComponentImpl = fxApplicationComponentImpl;
    }

    @Override
    public TrayMenuComponent build() {
      return new TrayMenuComponentImpl(cryptomatorComponentImpl, fxApplicationComponentImpl);
    }
  }

  private static final class HealthCheckComponentBuilder implements HealthCheckComponent.Builder {
    private final CryptomatorComponentImpl cryptomatorComponentImpl;

    private final FxApplicationComponentImpl fxApplicationComponentImpl;

    private Stage owner;

    private Vault vault;

    private HealthCheckComponentBuilder(
        CryptomatorComponentImpl cryptomatorComponentImpl,
        FxApplicationComponentImpl fxApplicationComponentImpl) {
      this.cryptomatorComponentImpl = cryptomatorComponentImpl;
      this.fxApplicationComponentImpl = fxApplicationComponentImpl;
    }

    @Override
    public HealthCheckComponentBuilder owner(Stage arg0) {
      this.owner = Preconditions.checkNotNull(arg0);
      return this;
    }

    @Override
    public HealthCheckComponentBuilder vault(Vault arg0) {
      this.vault = Preconditions.checkNotNull(arg0);
      return this;
    }

    @Override
    public HealthCheckComponent build() {
      Preconditions.checkBuilderRequirement(owner, Stage.class);
      Preconditions.checkBuilderRequirement(vault, Vault.class);
      return new HealthCheckComponentImpl(
          cryptomatorComponentImpl, fxApplicationComponentImpl, owner, vault);
    }
  }

  private static final class ocuk2_KeyLoadingComponentBuilder
      implements KeyLoadingComponent.Builder {
    private final CryptomatorComponentImpl cryptomatorComponentImpl;

    private final FxApplicationComponentImpl fxApplicationComponentImpl;

    private final HealthCheckComponentImpl healthCheckComponentImpl;

    private Vault vault;

    private Stage window;

    private ocuk2_KeyLoadingComponentBuilder(
        CryptomatorComponentImpl cryptomatorComponentImpl,
        FxApplicationComponentImpl fxApplicationComponentImpl,
        HealthCheckComponentImpl healthCheckComponentImpl) {
      this.cryptomatorComponentImpl = cryptomatorComponentImpl;
      this.fxApplicationComponentImpl = fxApplicationComponentImpl;
      this.healthCheckComponentImpl = healthCheckComponentImpl;
    }

    @Override
    public ocuk2_KeyLoadingComponentBuilder vault(Vault arg0) {
      this.vault = Preconditions.checkNotNull(arg0);
      return this;
    }

    @Override
    public ocuk2_KeyLoadingComponentBuilder window(Stage arg0) {
      this.window = Preconditions.checkNotNull(arg0);
      return this;
    }

    @Override
    public KeyLoadingComponent build() {
      Preconditions.checkBuilderRequirement(vault, Vault.class);
      Preconditions.checkBuilderRequirement(window, Stage.class);
      return new ocuk2_KeyLoadingComponentImpl(
          cryptomatorComponentImpl,
          fxApplicationComponentImpl,
          healthCheckComponentImpl,
          vault,
          window);
    }
  }

  private static final class ocukm2_PassphraseEntryComponentBuilder
      implements PassphraseEntryComponent.Builder {
    private final CryptomatorComponentImpl cryptomatorComponentImpl;

    private final FxApplicationComponentImpl fxApplicationComponentImpl;

    private final HealthCheckComponentImpl healthCheckComponentImpl;

    private final ocuk2_KeyLoadingComponentImpl _ocuk2_KeyLoadingComponentImpl;

    private Passphrase savedPassword;

    private ocukm2_PassphraseEntryComponentBuilder(
        CryptomatorComponentImpl cryptomatorComponentImpl,
        FxApplicationComponentImpl fxApplicationComponentImpl,
        HealthCheckComponentImpl healthCheckComponentImpl,
        ocuk2_KeyLoadingComponentImpl _ocuk2_KeyLoadingComponentImpl) {
      this.cryptomatorComponentImpl = cryptomatorComponentImpl;
      this.fxApplicationComponentImpl = fxApplicationComponentImpl;
      this.healthCheckComponentImpl = healthCheckComponentImpl;
      this._ocuk2_KeyLoadingComponentImpl = _ocuk2_KeyLoadingComponentImpl;
    }

    @Override
    public ocukm2_PassphraseEntryComponentBuilder savedPassword(Passphrase arg0) {
      this.savedPassword = arg0;
      return this;
    }

    @Override
    public PassphraseEntryComponent build() {
      return new ocukm2_PassphraseEntryComponentImpl(
          cryptomatorComponentImpl,
          fxApplicationComponentImpl,
          healthCheckComponentImpl,
          _ocuk2_KeyLoadingComponentImpl,
          savedPassword);
    }
  }

  private static final class ocukm2_ChooseMasterkeyFileComponentBuilder
      implements ChooseMasterkeyFileComponent.Builder {
    private final CryptomatorComponentImpl cryptomatorComponentImpl;

    private final FxApplicationComponentImpl fxApplicationComponentImpl;

    private final HealthCheckComponentImpl healthCheckComponentImpl;

    private final ocuk2_KeyLoadingComponentImpl _ocuk2_KeyLoadingComponentImpl;

    private ocukm2_ChooseMasterkeyFileComponentBuilder(
        CryptomatorComponentImpl cryptomatorComponentImpl,
        FxApplicationComponentImpl fxApplicationComponentImpl,
        HealthCheckComponentImpl healthCheckComponentImpl,
        ocuk2_KeyLoadingComponentImpl _ocuk2_KeyLoadingComponentImpl) {
      this.cryptomatorComponentImpl = cryptomatorComponentImpl;
      this.fxApplicationComponentImpl = fxApplicationComponentImpl;
      this.healthCheckComponentImpl = healthCheckComponentImpl;
      this._ocuk2_KeyLoadingComponentImpl = _ocuk2_KeyLoadingComponentImpl;
    }

    @Override
    public ChooseMasterkeyFileComponent build() {
      return new ocukm2_ChooseMasterkeyFileComponentImpl(
          cryptomatorComponentImpl,
          fxApplicationComponentImpl,
          healthCheckComponentImpl,
          _ocuk2_KeyLoadingComponentImpl);
    }
  }

  private static final class ocuf3_ForgetPasswordComponentBuilder
      implements ForgetPasswordComponent.Builder {
    private final CryptomatorComponentImpl cryptomatorComponentImpl;

    private final FxApplicationComponentImpl fxApplicationComponentImpl;

    private final HealthCheckComponentImpl healthCheckComponentImpl;

    private final ocuk2_KeyLoadingComponentImpl _ocuk2_KeyLoadingComponentImpl;

    private Stage owner;

    private Vault vault;

    private ocuf3_ForgetPasswordComponentBuilder(
        CryptomatorComponentImpl cryptomatorComponentImpl,
        FxApplicationComponentImpl fxApplicationComponentImpl,
        HealthCheckComponentImpl healthCheckComponentImpl,
        ocuk2_KeyLoadingComponentImpl _ocuk2_KeyLoadingComponentImpl) {
      this.cryptomatorComponentImpl = cryptomatorComponentImpl;
      this.fxApplicationComponentImpl = fxApplicationComponentImpl;
      this.healthCheckComponentImpl = healthCheckComponentImpl;
      this._ocuk2_KeyLoadingComponentImpl = _ocuk2_KeyLoadingComponentImpl;
    }

    @Override
    public ocuf3_ForgetPasswordComponentBuilder owner(Stage arg0) {
      this.owner = Preconditions.checkNotNull(arg0);
      return this;
    }

    @Override
    public ocuf3_ForgetPasswordComponentBuilder vault(Vault arg0) {
      this.vault = Preconditions.checkNotNull(arg0);
      return this;
    }

    @Override
    public ForgetPasswordComponent build() {
      Preconditions.checkBuilderRequirement(owner, Stage.class);
      Preconditions.checkBuilderRequirement(vault, Vault.class);
      return new ocuf3_ForgetPasswordComponentImpl(
          cryptomatorComponentImpl,
          fxApplicationComponentImpl,
          healthCheckComponentImpl,
          _ocuk2_KeyLoadingComponentImpl,
          owner,
          vault);
    }
  }

  private static final class VaultComponentFactory implements VaultComponent.Factory {
    private final CryptomatorComponentImpl cryptomatorComponentImpl;

    private VaultComponentFactory(CryptomatorComponentImpl cryptomatorComponentImpl) {
      this.cryptomatorComponentImpl = cryptomatorComponentImpl;
    }

    @Override
    public VaultComponent create(
        VaultSettings arg0, VaultConfigCache arg1, VaultState.Value arg2, Exception arg3) {
      Preconditions.checkNotNull(arg0);
      Preconditions.checkNotNull(arg1);
      Preconditions.checkNotNull(arg2);
      return new VaultComponentImpl(
          cryptomatorComponentImpl, new VaultModule(), arg0, arg1, arg2, arg3);
    }
  }

  private static final class RemoveVaultComponentImpl implements RemoveVaultComponent {
    private final Vault vault;

    private final CryptomatorComponentImpl cryptomatorComponentImpl;

    private final FxApplicationComponentImpl fxApplicationComponentImpl;

    private final MainWindowComponentImpl mainWindowComponentImpl;

    private final RemoveVaultComponentImpl removeVaultComponentImpl = this;

    private Provider<Stage> provideStageProvider;

    private Provider<RemoveVaultController> removeVaultControllerProvider;

    private Provider<FxmlLoaderFactory> provideFxmlLoaderFactoryProvider;

    private Provider<Scene> provideRemoveVaultSceneProvider;

    private RemoveVaultComponentImpl(
        CryptomatorComponentImpl cryptomatorComponentImpl,
        FxApplicationComponentImpl fxApplicationComponentImpl,
        MainWindowComponentImpl mainWindowComponentImpl,
        Vault vaultParam) {
      this.cryptomatorComponentImpl = cryptomatorComponentImpl;
      this.fxApplicationComponentImpl = fxApplicationComponentImpl;
      this.mainWindowComponentImpl = mainWindowComponentImpl;
      this.vault = vaultParam;
      initialize(vaultParam);
    }

    private Map<Class<? extends FxController>, javax.inject.Provider<FxController>>
        mapOfClassOfAndProviderOfFxController() {
      return ImmutableMap
          .<Class<? extends FxController>, javax.inject.Provider<FxController>>
              builderWithExpectedSize(14)
          .put(
              MainWindowController.class,
              ((Provider) mainWindowComponentImpl.mainWindowControllerProvider))
          .put(
              MainWindowTitleController.class,
              ((Provider) mainWindowComponentImpl.mainWindowTitleControllerProvider))
          .put(
              ResizeController.class, ((Provider) mainWindowComponentImpl.resizeControllerProvider))
          .put(
              VaultDetailController.class,
              ((Provider) mainWindowComponentImpl.vaultDetailControllerProvider))
          .put(
              VaultDetailLockedController.class,
              ((Provider) mainWindowComponentImpl.vaultDetailLockedControllerProvider))
          .put(
              VaultDetailMissingVaultController.class,
              ((Provider) mainWindowComponentImpl.vaultDetailMissingVaultControllerProvider))
          .put(
              VaultDetailNeedsMigrationController.class,
              ((Provider) mainWindowComponentImpl.vaultDetailNeedsMigrationControllerProvider))
          .put(
              VaultDetailUnknownErrorController.class,
              ((Provider) mainWindowComponentImpl.vaultDetailUnknownErrorControllerProvider))
          .put(
              VaultDetailUnlockedController.class,
              ((Provider) mainWindowComponentImpl.vaultDetailUnlockedControllerProvider))
          .put(
              VaultListCellController.class,
              ((Provider) mainWindowComponentImpl.vaultListCellControllerProvider))
          .put(
              VaultListContextMenuController.class,
              ((Provider) mainWindowComponentImpl.vaultListContextMenuControllerProvider))
          .put(
              VaultListController.class,
              ((Provider) mainWindowComponentImpl.vaultListControllerProvider))
          .put(
              WelcomeController.class,
              ((Provider) mainWindowComponentImpl.welcomeControllerProvider))
          .put(RemoveVaultController.class, ((Provider) removeVaultControllerProvider))
          .build();
    }

    @SuppressWarnings("unchecked")
    private void initialize(final Vault vaultParam) {
      this.provideStageProvider =
          DoubleCheck.provider(
              new SwitchingProvider<Stage>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  mainWindowComponentImpl,
                  removeVaultComponentImpl,
                  3));
      this.removeVaultControllerProvider =
          DoubleCheck.provider(
              new SwitchingProvider<RemoveVaultController>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  mainWindowComponentImpl,
                  removeVaultComponentImpl,
                  2));
      this.provideFxmlLoaderFactoryProvider =
          DoubleCheck.provider(
              new SwitchingProvider<FxmlLoaderFactory>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  mainWindowComponentImpl,
                  removeVaultComponentImpl,
                  1));
      this.provideRemoveVaultSceneProvider =
          DoubleCheck.provider(
              new SwitchingProvider<Scene>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  mainWindowComponentImpl,
                  removeVaultComponentImpl,
                  0));
    }

    @Override
    public Lazy<Scene> scene() {
      return DoubleCheck.lazy(provideRemoveVaultSceneProvider);
    }

    @Override
    public Stage window() {
      return provideStageProvider.get();
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final CryptomatorComponentImpl cryptomatorComponentImpl;

      private final FxApplicationComponentImpl fxApplicationComponentImpl;

      private final MainWindowComponentImpl mainWindowComponentImpl;

      private final RemoveVaultComponentImpl removeVaultComponentImpl;

      private final int id;

      SwitchingProvider(
          CryptomatorComponentImpl cryptomatorComponentImpl,
          FxApplicationComponentImpl fxApplicationComponentImpl,
          MainWindowComponentImpl mainWindowComponentImpl,
          RemoveVaultComponentImpl removeVaultComponentImpl,
          int id) {
        this.cryptomatorComponentImpl = cryptomatorComponentImpl;
        this.fxApplicationComponentImpl = fxApplicationComponentImpl;
        this.mainWindowComponentImpl = mainWindowComponentImpl;
        this.removeVaultComponentImpl = removeVaultComponentImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // @org.cryptomator.ui.common.FxmlScene(REMOVE_VAULT) javafx.scene.Scene
            return (T)
                RemoveVaultModule_ProvideRemoveVaultSceneFactory.provideRemoveVaultScene(
                    removeVaultComponentImpl.provideFxmlLoaderFactoryProvider.get());

          case 1: // @org.cryptomator.ui.removevault.RemoveVaultWindow
                  // org.cryptomator.ui.common.FxmlLoaderFactory
            return (T)
                RemoveVaultModule_ProvideFxmlLoaderFactoryFactory.provideFxmlLoaderFactory(
                    removeVaultComponentImpl.mapOfClassOfAndProviderOfFxController(),
                    fxApplicationComponentImpl.defaultSceneFactoryProvider.get(),
                    cryptomatorComponentImpl.provideLocalizationProvider.get());

          case 2: // org.cryptomator.ui.removevault.RemoveVaultController
            return (T)
                new RemoveVaultController(
                    removeVaultComponentImpl.provideStageProvider.get(),
                    removeVaultComponentImpl.vault,
                    cryptomatorComponentImpl.provideVaultListProvider.get());

          case 3: // @org.cryptomator.ui.removevault.RemoveVaultWindow javafx.stage.Stage
            return (T)
                RemoveVaultModule_ProvideStageFactory.provideStage(
                    fxApplicationComponentImpl.stageFactoryProvider.get(),
                    fxApplicationComponentImpl.primaryStage,
                    removeVaultComponentImpl.vault,
                    cryptomatorComponentImpl.provideLocalizationProvider.get());

          default:
            throw new AssertionError(id);
        }
      }
    }
  }

  private static final class MigrationComponentImpl implements MigrationComponent {
    private final Vault vault;

    private final CryptomatorComponentImpl cryptomatorComponentImpl;

    private final FxApplicationComponentImpl fxApplicationComponentImpl;

    private final MainWindowComponentImpl mainWindowComponentImpl;

    private final MigrationComponentImpl migrationComponentImpl = this;

    private Provider<Stage> provideStageProvider;

    private Provider<ObjectProperty<FileSystemCapabilityChecker.Capability>>
        provideCapabilityErrorCauseProvider;

    private Provider<Scene> provideMigrationStartSceneProvider;

    private Provider<MigrationCapabilityErrorController> migrationCapabilityErrorControllerProvider;

    private Provider<MigrationImpossibleController> migrationImpossibleControllerProvider;

    private Provider<FxmlLoaderFactory> provideFxmlLoaderFactoryProvider;

    private Provider<Scene> provideMigrationSuccessSceneProvider;

    private Provider<Scene> provideMigrationCapabilityErrorSceneProvider;

    private Provider<Scene> provideMigrationImpossibleSceneProvider;

    private Provider<MigrationRunController> migrationRunControllerProvider;

    private Provider<Scene> provideMigrationRunSceneProvider;

    private Provider<MigrationStartController> migrationStartControllerProvider;

    private Provider<MigrationSuccessController> migrationSuccessControllerProvider;

    private MigrationComponentImpl(
        CryptomatorComponentImpl cryptomatorComponentImpl,
        FxApplicationComponentImpl fxApplicationComponentImpl,
        MainWindowComponentImpl mainWindowComponentImpl,
        Vault vaultParam) {
      this.cryptomatorComponentImpl = cryptomatorComponentImpl;
      this.fxApplicationComponentImpl = fxApplicationComponentImpl;
      this.mainWindowComponentImpl = mainWindowComponentImpl;
      this.vault = vaultParam;
      initialize(vaultParam);
    }

    private Map<Class<? extends FxController>, javax.inject.Provider<FxController>>
        mapOfClassOfAndProviderOfFxController() {
      return ImmutableMap
          .<Class<? extends FxController>, javax.inject.Provider<FxController>>
              builderWithExpectedSize(18)
          .put(
              MainWindowController.class,
              ((Provider) mainWindowComponentImpl.mainWindowControllerProvider))
          .put(
              MainWindowTitleController.class,
              ((Provider) mainWindowComponentImpl.mainWindowTitleControllerProvider))
          .put(
              ResizeController.class, ((Provider) mainWindowComponentImpl.resizeControllerProvider))
          .put(
              VaultDetailController.class,
              ((Provider) mainWindowComponentImpl.vaultDetailControllerProvider))
          .put(
              VaultDetailLockedController.class,
              ((Provider) mainWindowComponentImpl.vaultDetailLockedControllerProvider))
          .put(
              VaultDetailMissingVaultController.class,
              ((Provider) mainWindowComponentImpl.vaultDetailMissingVaultControllerProvider))
          .put(
              VaultDetailNeedsMigrationController.class,
              ((Provider) mainWindowComponentImpl.vaultDetailNeedsMigrationControllerProvider))
          .put(
              VaultDetailUnknownErrorController.class,
              ((Provider) mainWindowComponentImpl.vaultDetailUnknownErrorControllerProvider))
          .put(
              VaultDetailUnlockedController.class,
              ((Provider) mainWindowComponentImpl.vaultDetailUnlockedControllerProvider))
          .put(
              VaultListCellController.class,
              ((Provider) mainWindowComponentImpl.vaultListCellControllerProvider))
          .put(
              VaultListContextMenuController.class,
              ((Provider) mainWindowComponentImpl.vaultListContextMenuControllerProvider))
          .put(
              VaultListController.class,
              ((Provider) mainWindowComponentImpl.vaultListControllerProvider))
          .put(
              WelcomeController.class,
              ((Provider) mainWindowComponentImpl.welcomeControllerProvider))
          .put(
              MigrationCapabilityErrorController.class,
              ((Provider) migrationCapabilityErrorControllerProvider))
          .put(
              MigrationImpossibleController.class,
              ((Provider) migrationImpossibleControllerProvider))
          .put(MigrationRunController.class, ((Provider) migrationRunControllerProvider))
          .put(MigrationStartController.class, ((Provider) migrationStartControllerProvider))
          .put(MigrationSuccessController.class, ((Provider) migrationSuccessControllerProvider))
          .build();
    }

    @SuppressWarnings("unchecked")
    private void initialize(final Vault vaultParam) {
      this.provideStageProvider =
          DoubleCheck.provider(
              new SwitchingProvider<Stage>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  mainWindowComponentImpl,
                  migrationComponentImpl,
                  3));
      this.provideCapabilityErrorCauseProvider =
          DoubleCheck.provider(
              new SwitchingProvider<ObjectProperty<FileSystemCapabilityChecker.Capability>>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  mainWindowComponentImpl,
                  migrationComponentImpl,
                  4));
      this.provideMigrationStartSceneProvider = new DelegateFactory<>();
      this.migrationCapabilityErrorControllerProvider =
          DoubleCheck.provider(
              new SwitchingProvider<MigrationCapabilityErrorController>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  mainWindowComponentImpl,
                  migrationComponentImpl,
                  2));
      this.migrationImpossibleControllerProvider =
          new SwitchingProvider<>(
              cryptomatorComponentImpl,
              fxApplicationComponentImpl,
              mainWindowComponentImpl,
              migrationComponentImpl,
              5);
      this.provideFxmlLoaderFactoryProvider = new DelegateFactory<>();
      this.provideMigrationSuccessSceneProvider =
          DoubleCheck.provider(
              new SwitchingProvider<Scene>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  mainWindowComponentImpl,
                  migrationComponentImpl,
                  7));
      this.provideMigrationCapabilityErrorSceneProvider =
          DoubleCheck.provider(
              new SwitchingProvider<Scene>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  mainWindowComponentImpl,
                  migrationComponentImpl,
                  8));
      this.provideMigrationImpossibleSceneProvider =
          DoubleCheck.provider(
              new SwitchingProvider<Scene>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  mainWindowComponentImpl,
                  migrationComponentImpl,
                  9));
      this.migrationRunControllerProvider =
          DoubleCheck.provider(
              new SwitchingProvider<MigrationRunController>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  mainWindowComponentImpl,
                  migrationComponentImpl,
                  6));
      this.provideMigrationRunSceneProvider =
          DoubleCheck.provider(
              new SwitchingProvider<Scene>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  mainWindowComponentImpl,
                  migrationComponentImpl,
                  11));
      this.migrationStartControllerProvider =
          DoubleCheck.provider(
              new SwitchingProvider<MigrationStartController>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  mainWindowComponentImpl,
                  migrationComponentImpl,
                  10));
      this.migrationSuccessControllerProvider =
          DoubleCheck.provider(
              new SwitchingProvider<MigrationSuccessController>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  mainWindowComponentImpl,
                  migrationComponentImpl,
                  12));
      DelegateFactory.setDelegate(
          provideFxmlLoaderFactoryProvider,
          DoubleCheck.provider(
              new SwitchingProvider<FxmlLoaderFactory>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  mainWindowComponentImpl,
                  migrationComponentImpl,
                  1)));
      DelegateFactory.setDelegate(
          provideMigrationStartSceneProvider,
          DoubleCheck.provider(
              new SwitchingProvider<Scene>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  mainWindowComponentImpl,
                  migrationComponentImpl,
                  0)));
    }

    @Override
    public Lazy<Scene> scene() {
      return DoubleCheck.lazy(provideMigrationStartSceneProvider);
    }

    @Override
    public Stage window() {
      return provideStageProvider.get();
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final CryptomatorComponentImpl cryptomatorComponentImpl;

      private final FxApplicationComponentImpl fxApplicationComponentImpl;

      private final MainWindowComponentImpl mainWindowComponentImpl;

      private final MigrationComponentImpl migrationComponentImpl;

      private final int id;

      SwitchingProvider(
          CryptomatorComponentImpl cryptomatorComponentImpl,
          FxApplicationComponentImpl fxApplicationComponentImpl,
          MainWindowComponentImpl mainWindowComponentImpl,
          MigrationComponentImpl migrationComponentImpl,
          int id) {
        this.cryptomatorComponentImpl = cryptomatorComponentImpl;
        this.fxApplicationComponentImpl = fxApplicationComponentImpl;
        this.mainWindowComponentImpl = mainWindowComponentImpl;
        this.migrationComponentImpl = migrationComponentImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // @org.cryptomator.ui.common.FxmlScene(MIGRATION_START) javafx.scene.Scene
            return (T)
                MigrationModule_ProvideMigrationStartSceneFactory.provideMigrationStartScene(
                    migrationComponentImpl.provideFxmlLoaderFactoryProvider.get());

          case 1: // @org.cryptomator.ui.migration.MigrationWindow
                  // org.cryptomator.ui.common.FxmlLoaderFactory
            return (T)
                MigrationModule_ProvideFxmlLoaderFactoryFactory.provideFxmlLoaderFactory(
                    migrationComponentImpl.mapOfClassOfAndProviderOfFxController(),
                    fxApplicationComponentImpl.defaultSceneFactoryProvider.get(),
                    cryptomatorComponentImpl.provideLocalizationProvider.get());

          case 2: // org.cryptomator.ui.migration.MigrationCapabilityErrorController
            return (T)
                MigrationCapabilityErrorController_Factory.newInstance(
                    migrationComponentImpl.provideStageProvider.get(),
                    migrationComponentImpl.provideCapabilityErrorCauseProvider.get(),
                    cryptomatorComponentImpl.provideLocalizationProvider.get(),
                    DoubleCheck.lazy(migrationComponentImpl.provideMigrationStartSceneProvider));

          case 3: // @org.cryptomator.ui.migration.MigrationWindow javafx.stage.Stage
            return (T)
                MigrationModule_ProvideStageFactory.provideStage(
                    fxApplicationComponentImpl.stageFactoryProvider.get(),
                    fxApplicationComponentImpl.primaryStage,
                    cryptomatorComponentImpl.provideLocalizationProvider.get());

          case 4: // @javax.inject.Named("capabilityErrorCause")
                  // javafx.beans.property.ObjectProperty<org.cryptomator.cryptofs.common.FileSystemCapabilityChecker.Capability>
            return (T)
                MigrationModule_ProvideCapabilityErrorCauseFactory.provideCapabilityErrorCause();

          case 5: // org.cryptomator.ui.migration.MigrationImpossibleController
            return (T)
                MigrationImpossibleController_Factory.newInstance(
                    fxApplicationComponentImpl.fxApplicationProvider.get(),
                    migrationComponentImpl.provideStageProvider.get(),
                    migrationComponentImpl.vault);

          case 6: // org.cryptomator.ui.migration.MigrationRunController
            return (T)
                new MigrationRunController(
                    migrationComponentImpl.provideStageProvider.get(),
                    migrationComponentImpl.vault,
                    cryptomatorComponentImpl.provideExecutorServiceProvider.get(),
                    cryptomatorComponentImpl.provideScheduledExecutorServiceProvider.get(),
                    cryptomatorComponentImpl.keychainManagerProvider.get(),
                    migrationComponentImpl.provideCapabilityErrorCauseProvider.get(),
                    DoubleCheck.lazy(migrationComponentImpl.provideMigrationStartSceneProvider),
                    DoubleCheck.lazy(migrationComponentImpl.provideMigrationSuccessSceneProvider),
                    DoubleCheck.lazy(
                        migrationComponentImpl.provideMigrationCapabilityErrorSceneProvider),
                    DoubleCheck.lazy(
                        migrationComponentImpl.provideMigrationImpossibleSceneProvider),
                    fxApplicationComponentImpl.fxApplicationWindowsProvider.get());

          case 7: // @org.cryptomator.ui.common.FxmlScene(MIGRATION_SUCCESS) javafx.scene.Scene
            return (T)
                MigrationModule_ProvideMigrationSuccessSceneFactory.provideMigrationSuccessScene(
                    migrationComponentImpl.provideFxmlLoaderFactoryProvider.get());

          case 8: // @org.cryptomator.ui.common.FxmlScene(MIGRATION_CAPABILITY_ERROR)
                  // javafx.scene.Scene
            return (T)
                MigrationModule_ProvideMigrationCapabilityErrorSceneFactory
                    .provideMigrationCapabilityErrorScene(
                        migrationComponentImpl.provideFxmlLoaderFactoryProvider.get());

          case 9: // @org.cryptomator.ui.common.FxmlScene(MIGRATION_IMPOSSIBLE) javafx.scene.Scene
            return (T)
                MigrationModule_ProvideMigrationImpossibleSceneFactory
                    .provideMigrationImpossibleScene(
                        migrationComponentImpl.provideFxmlLoaderFactoryProvider.get());

          case 10: // org.cryptomator.ui.migration.MigrationStartController
            return (T)
                new MigrationStartController(
                    migrationComponentImpl.provideStageProvider.get(),
                    migrationComponentImpl.vault,
                    DoubleCheck.lazy(migrationComponentImpl.provideMigrationRunSceneProvider));

          case 11: // @org.cryptomator.ui.common.FxmlScene(MIGRATION_RUN) javafx.scene.Scene
            return (T)
                MigrationModule_ProvideMigrationRunSceneFactory.provideMigrationRunScene(
                    migrationComponentImpl.provideFxmlLoaderFactoryProvider.get());

          case 12: // org.cryptomator.ui.migration.MigrationSuccessController
            return (T)
                MigrationSuccessController_Factory.newInstance(
                    fxApplicationComponentImpl.fxApplicationWindowsProvider.get(),
                    migrationComponentImpl.provideStageProvider.get(),
                    migrationComponentImpl.vault,
                    fxApplicationComponentImpl.primaryStage);

          default:
            throw new AssertionError(id);
        }
      }
    }
  }

  private static final class VaultStatisticsComponentImpl implements VaultStatisticsComponent {
    private final Vault vault;

    private final CryptomatorComponentImpl cryptomatorComponentImpl;

    private final FxApplicationComponentImpl fxApplicationComponentImpl;

    private final MainWindowComponentImpl mainWindowComponentImpl;

    private final VaultStatisticsComponentImpl vaultStatisticsComponentImpl = this;

    private Provider<Stage> provideStageProvider;

    private Provider<VaultStatisticsController> vaultStatisticsControllerProvider;

    private Provider<FxmlLoaderFactory> provideFxmlLoaderFactoryProvider;

    private Provider<Scene> provideVaultStatisticsSceneProvider;

    private VaultStatisticsComponentImpl(
        CryptomatorComponentImpl cryptomatorComponentImpl,
        FxApplicationComponentImpl fxApplicationComponentImpl,
        MainWindowComponentImpl mainWindowComponentImpl,
        Vault vaultParam) {
      this.cryptomatorComponentImpl = cryptomatorComponentImpl;
      this.fxApplicationComponentImpl = fxApplicationComponentImpl;
      this.mainWindowComponentImpl = mainWindowComponentImpl;
      this.vault = vaultParam;
      initialize(vaultParam);
    }

    private Map<Class<? extends FxController>, javax.inject.Provider<FxController>>
        mapOfClassOfAndProviderOfFxController() {
      return ImmutableMap
          .<Class<? extends FxController>, javax.inject.Provider<FxController>>
              builderWithExpectedSize(14)
          .put(
              MainWindowController.class,
              ((Provider) mainWindowComponentImpl.mainWindowControllerProvider))
          .put(
              MainWindowTitleController.class,
              ((Provider) mainWindowComponentImpl.mainWindowTitleControllerProvider))
          .put(
              ResizeController.class, ((Provider) mainWindowComponentImpl.resizeControllerProvider))
          .put(
              VaultDetailController.class,
              ((Provider) mainWindowComponentImpl.vaultDetailControllerProvider))
          .put(
              VaultDetailLockedController.class,
              ((Provider) mainWindowComponentImpl.vaultDetailLockedControllerProvider))
          .put(
              VaultDetailMissingVaultController.class,
              ((Provider) mainWindowComponentImpl.vaultDetailMissingVaultControllerProvider))
          .put(
              VaultDetailNeedsMigrationController.class,
              ((Provider) mainWindowComponentImpl.vaultDetailNeedsMigrationControllerProvider))
          .put(
              VaultDetailUnknownErrorController.class,
              ((Provider) mainWindowComponentImpl.vaultDetailUnknownErrorControllerProvider))
          .put(
              VaultDetailUnlockedController.class,
              ((Provider) mainWindowComponentImpl.vaultDetailUnlockedControllerProvider))
          .put(
              VaultListCellController.class,
              ((Provider) mainWindowComponentImpl.vaultListCellControllerProvider))
          .put(
              VaultListContextMenuController.class,
              ((Provider) mainWindowComponentImpl.vaultListContextMenuControllerProvider))
          .put(
              VaultListController.class,
              ((Provider) mainWindowComponentImpl.vaultListControllerProvider))
          .put(
              WelcomeController.class,
              ((Provider) mainWindowComponentImpl.welcomeControllerProvider))
          .put(VaultStatisticsController.class, ((Provider) vaultStatisticsControllerProvider))
          .build();
    }

    @SuppressWarnings("unchecked")
    private void initialize(final Vault vaultParam) {
      this.provideStageProvider =
          DoubleCheck.provider(
              new SwitchingProvider<Stage>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  mainWindowComponentImpl,
                  vaultStatisticsComponentImpl,
                  3));
      this.vaultStatisticsControllerProvider =
          DoubleCheck.provider(
              new SwitchingProvider<VaultStatisticsController>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  mainWindowComponentImpl,
                  vaultStatisticsComponentImpl,
                  2));
      this.provideFxmlLoaderFactoryProvider =
          DoubleCheck.provider(
              new SwitchingProvider<FxmlLoaderFactory>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  mainWindowComponentImpl,
                  vaultStatisticsComponentImpl,
                  1));
      this.provideVaultStatisticsSceneProvider =
          DoubleCheck.provider(
              new SwitchingProvider<Scene>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  mainWindowComponentImpl,
                  vaultStatisticsComponentImpl,
                  0));
    }

    @Override
    public Lazy<Scene> scene() {
      return DoubleCheck.lazy(provideVaultStatisticsSceneProvider);
    }

    @Override
    public Stage window() {
      return provideStageProvider.get();
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final CryptomatorComponentImpl cryptomatorComponentImpl;

      private final FxApplicationComponentImpl fxApplicationComponentImpl;

      private final MainWindowComponentImpl mainWindowComponentImpl;

      private final VaultStatisticsComponentImpl vaultStatisticsComponentImpl;

      private final int id;

      SwitchingProvider(
          CryptomatorComponentImpl cryptomatorComponentImpl,
          FxApplicationComponentImpl fxApplicationComponentImpl,
          MainWindowComponentImpl mainWindowComponentImpl,
          VaultStatisticsComponentImpl vaultStatisticsComponentImpl,
          int id) {
        this.cryptomatorComponentImpl = cryptomatorComponentImpl;
        this.fxApplicationComponentImpl = fxApplicationComponentImpl;
        this.mainWindowComponentImpl = mainWindowComponentImpl;
        this.vaultStatisticsComponentImpl = vaultStatisticsComponentImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // @org.cryptomator.ui.common.FxmlScene(VAULT_STATISTICS) javafx.scene.Scene
            return (T)
                VaultStatisticsModule_ProvideVaultStatisticsSceneFactory
                    .provideVaultStatisticsScene(
                        vaultStatisticsComponentImpl.provideFxmlLoaderFactoryProvider.get());

          case 1: // @org.cryptomator.ui.stats.VaultStatisticsWindow
                  // org.cryptomator.ui.common.FxmlLoaderFactory
            return (T)
                VaultStatisticsModule_ProvideFxmlLoaderFactoryFactory.provideFxmlLoaderFactory(
                    vaultStatisticsComponentImpl.mapOfClassOfAndProviderOfFxController(),
                    fxApplicationComponentImpl.defaultSceneFactoryProvider.get(),
                    cryptomatorComponentImpl.provideLocalizationProvider.get());

          case 2: // org.cryptomator.ui.stats.VaultStatisticsController
            return (T)
                new VaultStatisticsController(
                    vaultStatisticsComponentImpl,
                    vaultStatisticsComponentImpl.provideStageProvider.get(),
                    vaultStatisticsComponentImpl.vault);

          case 3: // @org.cryptomator.ui.stats.VaultStatisticsWindow javafx.stage.Stage
            return (T)
                VaultStatisticsModule_ProvideStageFactory.provideStage(
                    fxApplicationComponentImpl.stageFactoryProvider.get(),
                    cryptomatorComponentImpl.provideLocalizationProvider.get(),
                    vaultStatisticsComponentImpl.vault);

          default:
            throw new AssertionError(id);
        }
      }
    }
  }

  private static final class WrongFileAlertComponentImpl implements WrongFileAlertComponent {
    private final CryptomatorComponentImpl cryptomatorComponentImpl;

    private final FxApplicationComponentImpl fxApplicationComponentImpl;

    private final MainWindowComponentImpl mainWindowComponentImpl;

    private final WrongFileAlertComponentImpl wrongFileAlertComponentImpl = this;

    private Provider<Stage> provideStageProvider;

    private Provider<WrongFileAlertController> wrongFileAlertControllerProvider;

    private Provider<FxmlLoaderFactory> provideFxmlLoaderFactoryProvider;

    private Provider<Scene> provideWrongFileAlertSceneProvider;

    private WrongFileAlertComponentImpl(
        CryptomatorComponentImpl cryptomatorComponentImpl,
        FxApplicationComponentImpl fxApplicationComponentImpl,
        MainWindowComponentImpl mainWindowComponentImpl) {
      this.cryptomatorComponentImpl = cryptomatorComponentImpl;
      this.fxApplicationComponentImpl = fxApplicationComponentImpl;
      this.mainWindowComponentImpl = mainWindowComponentImpl;

      initialize();
    }

    private Map<Class<? extends FxController>, javax.inject.Provider<FxController>>
        mapOfClassOfAndProviderOfFxController() {
      return ImmutableMap
          .<Class<? extends FxController>, javax.inject.Provider<FxController>>
              builderWithExpectedSize(14)
          .put(
              MainWindowController.class,
              ((Provider) mainWindowComponentImpl.mainWindowControllerProvider))
          .put(
              MainWindowTitleController.class,
              ((Provider) mainWindowComponentImpl.mainWindowTitleControllerProvider))
          .put(
              ResizeController.class, ((Provider) mainWindowComponentImpl.resizeControllerProvider))
          .put(
              VaultDetailController.class,
              ((Provider) mainWindowComponentImpl.vaultDetailControllerProvider))
          .put(
              VaultDetailLockedController.class,
              ((Provider) mainWindowComponentImpl.vaultDetailLockedControllerProvider))
          .put(
              VaultDetailMissingVaultController.class,
              ((Provider) mainWindowComponentImpl.vaultDetailMissingVaultControllerProvider))
          .put(
              VaultDetailNeedsMigrationController.class,
              ((Provider) mainWindowComponentImpl.vaultDetailNeedsMigrationControllerProvider))
          .put(
              VaultDetailUnknownErrorController.class,
              ((Provider) mainWindowComponentImpl.vaultDetailUnknownErrorControllerProvider))
          .put(
              VaultDetailUnlockedController.class,
              ((Provider) mainWindowComponentImpl.vaultDetailUnlockedControllerProvider))
          .put(
              VaultListCellController.class,
              ((Provider) mainWindowComponentImpl.vaultListCellControllerProvider))
          .put(
              VaultListContextMenuController.class,
              ((Provider) mainWindowComponentImpl.vaultListContextMenuControllerProvider))
          .put(
              VaultListController.class,
              ((Provider) mainWindowComponentImpl.vaultListControllerProvider))
          .put(
              WelcomeController.class,
              ((Provider) mainWindowComponentImpl.welcomeControllerProvider))
          .put(WrongFileAlertController.class, ((Provider) wrongFileAlertControllerProvider))
          .build();
    }

    @SuppressWarnings("unchecked")
    private void initialize() {
      this.provideStageProvider =
          DoubleCheck.provider(
              new SwitchingProvider<Stage>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  mainWindowComponentImpl,
                  wrongFileAlertComponentImpl,
                  3));
      this.wrongFileAlertControllerProvider =
          DoubleCheck.provider(
              new SwitchingProvider<WrongFileAlertController>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  mainWindowComponentImpl,
                  wrongFileAlertComponentImpl,
                  2));
      this.provideFxmlLoaderFactoryProvider =
          DoubleCheck.provider(
              new SwitchingProvider<FxmlLoaderFactory>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  mainWindowComponentImpl,
                  wrongFileAlertComponentImpl,
                  1));
      this.provideWrongFileAlertSceneProvider =
          DoubleCheck.provider(
              new SwitchingProvider<Scene>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  mainWindowComponentImpl,
                  wrongFileAlertComponentImpl,
                  0));
    }

    @Override
    public Lazy<Scene> scene() {
      return DoubleCheck.lazy(provideWrongFileAlertSceneProvider);
    }

    @Override
    public Stage window() {
      return provideStageProvider.get();
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final CryptomatorComponentImpl cryptomatorComponentImpl;

      private final FxApplicationComponentImpl fxApplicationComponentImpl;

      private final MainWindowComponentImpl mainWindowComponentImpl;

      private final WrongFileAlertComponentImpl wrongFileAlertComponentImpl;

      private final int id;

      SwitchingProvider(
          CryptomatorComponentImpl cryptomatorComponentImpl,
          FxApplicationComponentImpl fxApplicationComponentImpl,
          MainWindowComponentImpl mainWindowComponentImpl,
          WrongFileAlertComponentImpl wrongFileAlertComponentImpl,
          int id) {
        this.cryptomatorComponentImpl = cryptomatorComponentImpl;
        this.fxApplicationComponentImpl = fxApplicationComponentImpl;
        this.mainWindowComponentImpl = mainWindowComponentImpl;
        this.wrongFileAlertComponentImpl = wrongFileAlertComponentImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // @org.cryptomator.ui.common.FxmlScene(WRONGFILEALERT) javafx.scene.Scene
            return (T)
                WrongFileAlertModule_ProvideWrongFileAlertSceneFactory.provideWrongFileAlertScene(
                    wrongFileAlertComponentImpl.provideFxmlLoaderFactoryProvider.get());

          case 1: // @org.cryptomator.ui.wrongfilealert.WrongFileAlertWindow
                  // org.cryptomator.ui.common.FxmlLoaderFactory
            return (T)
                WrongFileAlertModule_ProvideFxmlLoaderFactoryFactory.provideFxmlLoaderFactory(
                    wrongFileAlertComponentImpl.mapOfClassOfAndProviderOfFxController(),
                    fxApplicationComponentImpl.defaultSceneFactoryProvider.get(),
                    cryptomatorComponentImpl.provideLocalizationProvider.get());

          case 2: // org.cryptomator.ui.wrongfilealert.WrongFileAlertController
            return (T)
                new WrongFileAlertController(
                    wrongFileAlertComponentImpl.provideStageProvider.get(),
                    fxApplicationComponentImpl.fxApplicationProvider.get());

          case 3: // @org.cryptomator.ui.wrongfilealert.WrongFileAlertWindow javafx.stage.Stage
            return (T)
                WrongFileAlertModule_ProvideStageFactory.provideStage(
                    fxApplicationComponentImpl.stageFactoryProvider.get(),
                    fxApplicationComponentImpl.primaryStage,
                    cryptomatorComponentImpl.provideLocalizationProvider.get());

          default:
            throw new AssertionError(id);
        }
      }
    }
  }

  private static final class AddVaultWizardComponentImpl implements AddVaultWizardComponent {
    private final CryptomatorComponentImpl cryptomatorComponentImpl;

    private final FxApplicationComponentImpl fxApplicationComponentImpl;

    private final MainWindowComponentImpl mainWindowComponentImpl;

    private final AddVaultWizardComponentImpl addVaultWizardComponentImpl = this;

    private Provider<FxController> provideNewPasswordControllerProvider;

    private Provider<Stage> provideStageProvider;

    private Provider<StringProperty> provideVaultNameProvider;

    private Provider<StringProperty> provideRecoveryKeyProvider;

    private Provider<FxController> provideRecoveryKeyDisplayControllerProvider;

    private Provider<ObjectProperty<Vault>> provideVaultProvider;

    private Provider<AddVaultSuccessController> addVaultSuccessControllerProvider;

    private Provider<FxmlLoaderFactory> provideFxmlLoaderFactoryProvider;

    private Provider<Scene> provideCreateNewVaultSuccessSceneProvider;

    private Provider<ObjectProperty<Path>> provideVaultPathProvider;

    private Provider<ChooseExistingVaultController> chooseExistingVaultControllerProvider;

    private Provider<Scene> provideCreateNewVaultLocationSceneProvider;

    private Provider<Scene> provideCreateNewVaultPasswordSceneProvider;

    private Provider<IntegerProperty> provideShorteningThresholdProvider;

    private Provider<CreateNewVaultExpertSettingsController>
        createNewVaultExpertSettingsControllerProvider;

    private Provider<Scene> provideCreateNewVaultNameSceneProvider;

    private Provider<Scene> provideCreateNewVaultExpertSettingsSceneProvider;

    private Provider<CreateNewVaultLocationController> createNewVaultLocationControllerProvider;

    private Provider<CreateNewVaultNameController> createNewVaultNameControllerProvider;

    private Provider<Scene> provideCreateNewVaultRecoveryKeySceneProvider;

    private Provider<ReadmeGenerator> readmeGeneratorProvider;

    private Provider<CreateNewVaultPasswordController> createNewVaultPasswordControllerProvider;

    private Provider<CreateNewVaultRecoveryKeyController>
        createNewVaultRecoveryKeyControllerProvider;

    private Provider<Scene> provideChooseExistingVaultSceneProvider;

    private AddVaultWizardComponentImpl(
        CryptomatorComponentImpl cryptomatorComponentImpl,
        FxApplicationComponentImpl fxApplicationComponentImpl,
        MainWindowComponentImpl mainWindowComponentImpl) {
      this.cryptomatorComponentImpl = cryptomatorComponentImpl;
      this.fxApplicationComponentImpl = fxApplicationComponentImpl;
      this.mainWindowComponentImpl = mainWindowComponentImpl;

      initialize();
    }

    private Map<Class<? extends FxController>, javax.inject.Provider<FxController>>
        mapOfClassOfAndProviderOfFxController() {
      return ImmutableMap
          .<Class<? extends FxController>, javax.inject.Provider<FxController>>
              builderWithExpectedSize(22)
          .put(
              MainWindowController.class,
              ((Provider) mainWindowComponentImpl.mainWindowControllerProvider))
          .put(
              MainWindowTitleController.class,
              ((Provider) mainWindowComponentImpl.mainWindowTitleControllerProvider))
          .put(
              ResizeController.class, ((Provider) mainWindowComponentImpl.resizeControllerProvider))
          .put(
              VaultDetailController.class,
              ((Provider) mainWindowComponentImpl.vaultDetailControllerProvider))
          .put(
              VaultDetailLockedController.class,
              ((Provider) mainWindowComponentImpl.vaultDetailLockedControllerProvider))
          .put(
              VaultDetailMissingVaultController.class,
              ((Provider) mainWindowComponentImpl.vaultDetailMissingVaultControllerProvider))
          .put(
              VaultDetailNeedsMigrationController.class,
              ((Provider) mainWindowComponentImpl.vaultDetailNeedsMigrationControllerProvider))
          .put(
              VaultDetailUnknownErrorController.class,
              ((Provider) mainWindowComponentImpl.vaultDetailUnknownErrorControllerProvider))
          .put(
              VaultDetailUnlockedController.class,
              ((Provider) mainWindowComponentImpl.vaultDetailUnlockedControllerProvider))
          .put(
              VaultListCellController.class,
              ((Provider) mainWindowComponentImpl.vaultListCellControllerProvider))
          .put(
              VaultListContextMenuController.class,
              ((Provider) mainWindowComponentImpl.vaultListContextMenuControllerProvider))
          .put(
              VaultListController.class,
              ((Provider) mainWindowComponentImpl.vaultListControllerProvider))
          .put(
              WelcomeController.class,
              ((Provider) mainWindowComponentImpl.welcomeControllerProvider))
          .put(NewPasswordController.class, provideNewPasswordControllerProvider)
          .put(RecoveryKeyDisplayController.class, provideRecoveryKeyDisplayControllerProvider)
          .put(AddVaultSuccessController.class, ((Provider) addVaultSuccessControllerProvider))
          .put(
              ChooseExistingVaultController.class,
              ((Provider) chooseExistingVaultControllerProvider))
          .put(
              CreateNewVaultExpertSettingsController.class,
              ((Provider) createNewVaultExpertSettingsControllerProvider))
          .put(
              CreateNewVaultLocationController.class,
              ((Provider) createNewVaultLocationControllerProvider))
          .put(
              CreateNewVaultNameController.class, ((Provider) createNewVaultNameControllerProvider))
          .put(
              CreateNewVaultPasswordController.class,
              ((Provider) createNewVaultPasswordControllerProvider))
          .put(
              CreateNewVaultRecoveryKeyController.class,
              ((Provider) createNewVaultRecoveryKeyControllerProvider))
          .build();
    }

    @SuppressWarnings("unchecked")
    private void initialize() {
      this.provideNewPasswordControllerProvider =
          new SwitchingProvider<>(
              cryptomatorComponentImpl,
              fxApplicationComponentImpl,
              mainWindowComponentImpl,
              addVaultWizardComponentImpl,
              2);
      this.provideStageProvider =
          DoubleCheck.provider(
              new SwitchingProvider<Stage>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  mainWindowComponentImpl,
                  addVaultWizardComponentImpl,
                  4));
      this.provideVaultNameProvider =
          DoubleCheck.provider(
              new SwitchingProvider<StringProperty>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  mainWindowComponentImpl,
                  addVaultWizardComponentImpl,
                  5));
      this.provideRecoveryKeyProvider =
          DoubleCheck.provider(
              new SwitchingProvider<StringProperty>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  mainWindowComponentImpl,
                  addVaultWizardComponentImpl,
                  6));
      this.provideRecoveryKeyDisplayControllerProvider =
          new SwitchingProvider<>(
              cryptomatorComponentImpl,
              fxApplicationComponentImpl,
              mainWindowComponentImpl,
              addVaultWizardComponentImpl,
              3);
      this.provideVaultProvider =
          DoubleCheck.provider(
              new SwitchingProvider<ObjectProperty<Vault>>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  mainWindowComponentImpl,
                  addVaultWizardComponentImpl,
                  8));
      this.addVaultSuccessControllerProvider =
          DoubleCheck.provider(
              new SwitchingProvider<AddVaultSuccessController>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  mainWindowComponentImpl,
                  addVaultWizardComponentImpl,
                  7));
      this.provideFxmlLoaderFactoryProvider = new DelegateFactory<>();
      this.provideCreateNewVaultSuccessSceneProvider =
          DoubleCheck.provider(
              new SwitchingProvider<Scene>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  mainWindowComponentImpl,
                  addVaultWizardComponentImpl,
                  10));
      this.provideVaultPathProvider =
          DoubleCheck.provider(
              new SwitchingProvider<ObjectProperty<Path>>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  mainWindowComponentImpl,
                  addVaultWizardComponentImpl,
                  11));
      this.chooseExistingVaultControllerProvider =
          DoubleCheck.provider(
              new SwitchingProvider<ChooseExistingVaultController>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  mainWindowComponentImpl,
                  addVaultWizardComponentImpl,
                  9));
      this.provideCreateNewVaultLocationSceneProvider =
          DoubleCheck.provider(
              new SwitchingProvider<Scene>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  mainWindowComponentImpl,
                  addVaultWizardComponentImpl,
                  13));
      this.provideCreateNewVaultPasswordSceneProvider =
          DoubleCheck.provider(
              new SwitchingProvider<Scene>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  mainWindowComponentImpl,
                  addVaultWizardComponentImpl,
                  14));
      this.provideShorteningThresholdProvider =
          DoubleCheck.provider(
              new SwitchingProvider<IntegerProperty>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  mainWindowComponentImpl,
                  addVaultWizardComponentImpl,
                  15));
      this.createNewVaultExpertSettingsControllerProvider =
          DoubleCheck.provider(
              new SwitchingProvider<CreateNewVaultExpertSettingsController>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  mainWindowComponentImpl,
                  addVaultWizardComponentImpl,
                  12));
      this.provideCreateNewVaultNameSceneProvider =
          DoubleCheck.provider(
              new SwitchingProvider<Scene>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  mainWindowComponentImpl,
                  addVaultWizardComponentImpl,
                  17));
      this.provideCreateNewVaultExpertSettingsSceneProvider =
          DoubleCheck.provider(
              new SwitchingProvider<Scene>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  mainWindowComponentImpl,
                  addVaultWizardComponentImpl,
                  18));
      this.createNewVaultLocationControllerProvider =
          DoubleCheck.provider(
              new SwitchingProvider<CreateNewVaultLocationController>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  mainWindowComponentImpl,
                  addVaultWizardComponentImpl,
                  16));
      this.createNewVaultNameControllerProvider =
          DoubleCheck.provider(
              new SwitchingProvider<CreateNewVaultNameController>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  mainWindowComponentImpl,
                  addVaultWizardComponentImpl,
                  19));
      this.provideCreateNewVaultRecoveryKeySceneProvider =
          DoubleCheck.provider(
              new SwitchingProvider<Scene>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  mainWindowComponentImpl,
                  addVaultWizardComponentImpl,
                  21));
      this.readmeGeneratorProvider =
          DoubleCheck.provider(
              new SwitchingProvider<ReadmeGenerator>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  mainWindowComponentImpl,
                  addVaultWizardComponentImpl,
                  22));
      this.createNewVaultPasswordControllerProvider =
          DoubleCheck.provider(
              new SwitchingProvider<CreateNewVaultPasswordController>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  mainWindowComponentImpl,
                  addVaultWizardComponentImpl,
                  20));
      this.createNewVaultRecoveryKeyControllerProvider =
          new SwitchingProvider<>(
              cryptomatorComponentImpl,
              fxApplicationComponentImpl,
              mainWindowComponentImpl,
              addVaultWizardComponentImpl,
              23);
      DelegateFactory.setDelegate(
          provideFxmlLoaderFactoryProvider,
          DoubleCheck.provider(
              new SwitchingProvider<FxmlLoaderFactory>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  mainWindowComponentImpl,
                  addVaultWizardComponentImpl,
                  1)));
      this.provideChooseExistingVaultSceneProvider =
          DoubleCheck.provider(
              new SwitchingProvider<Scene>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  mainWindowComponentImpl,
                  addVaultWizardComponentImpl,
                  0));
    }

    @Override
    public Lazy<Scene> sceneExisting() {
      return DoubleCheck.lazy(provideChooseExistingVaultSceneProvider);
    }

    @Override
    public Lazy<Scene> sceneNew() {
      return DoubleCheck.lazy(provideCreateNewVaultNameSceneProvider);
    }

    @Override
    public Stage window() {
      return provideStageProvider.get();
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final CryptomatorComponentImpl cryptomatorComponentImpl;

      private final FxApplicationComponentImpl fxApplicationComponentImpl;

      private final MainWindowComponentImpl mainWindowComponentImpl;

      private final AddVaultWizardComponentImpl addVaultWizardComponentImpl;

      private final int id;

      SwitchingProvider(
          CryptomatorComponentImpl cryptomatorComponentImpl,
          FxApplicationComponentImpl fxApplicationComponentImpl,
          MainWindowComponentImpl mainWindowComponentImpl,
          AddVaultWizardComponentImpl addVaultWizardComponentImpl,
          int id) {
        this.cryptomatorComponentImpl = cryptomatorComponentImpl;
        this.fxApplicationComponentImpl = fxApplicationComponentImpl;
        this.mainWindowComponentImpl = mainWindowComponentImpl;
        this.addVaultWizardComponentImpl = addVaultWizardComponentImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // @org.cryptomator.ui.common.FxmlScene(ADDVAULT_EXISTING) javafx.scene.Scene
            return (T)
                AddVaultModule_ProvideChooseExistingVaultSceneFactory
                    .provideChooseExistingVaultScene(
                        addVaultWizardComponentImpl.provideFxmlLoaderFactoryProvider.get());

          case 1: // @org.cryptomator.ui.addvaultwizard.AddVaultWizardWindow
                  // org.cryptomator.ui.common.FxmlLoaderFactory
            return (T)
                AddVaultModule_ProvideFxmlLoaderFactoryFactory.provideFxmlLoaderFactory(
                    addVaultWizardComponentImpl.mapOfClassOfAndProviderOfFxController(),
                    fxApplicationComponentImpl.defaultSceneFactoryProvider.get(),
                    cryptomatorComponentImpl.provideLocalizationProvider.get());

          case 2: // java.util.Map<java.lang.Class<? extends
                  // org.cryptomator.ui.common.FxController>,javax.inject.Provider<org.cryptomator.ui.common.FxController>> org.cryptomator.ui.addvaultwizard.AddVaultModule#provideNewPasswordController
            return (T)
                AddVaultModule_ProvideNewPasswordControllerFactory.provideNewPasswordController(
                    cryptomatorComponentImpl.provideLocalizationProvider.get(),
                    fxApplicationComponentImpl.passwordStrengthUtilProvider.get());

          case 3: // java.util.Map<java.lang.Class<? extends
                  // org.cryptomator.ui.common.FxController>,javax.inject.Provider<org.cryptomator.ui.common.FxController>> org.cryptomator.ui.addvaultwizard.AddVaultModule#provideRecoveryKeyDisplayController
            return (T)
                AddVaultModule_ProvideRecoveryKeyDisplayControllerFactory
                    .provideRecoveryKeyDisplayController(
                        addVaultWizardComponentImpl.provideStageProvider.get(),
                        addVaultWizardComponentImpl.provideVaultNameProvider.get(),
                        addVaultWizardComponentImpl.provideRecoveryKeyProvider.get(),
                        cryptomatorComponentImpl.provideLocalizationProvider.get());

          case 4: // @org.cryptomator.ui.addvaultwizard.AddVaultWizardWindow javafx.stage.Stage
            return (T)
                AddVaultModule_ProvideStageFactory.provideStage(
                    fxApplicationComponentImpl.stageFactoryProvider.get(),
                    fxApplicationComponentImpl.primaryStage);

          case 5: // @javax.inject.Named("vaultName") javafx.beans.property.StringProperty
            return (T) AddVaultModule_ProvideVaultNameFactory.provideVaultName();

          case 6: // @javax.inject.Named("recoveryKey") javafx.beans.property.StringProperty
            return (T) AddVaultModule_ProvideRecoveryKeyFactory.provideRecoveryKey();

          case 7: // org.cryptomator.ui.addvaultwizard.AddVaultSuccessController
            return (T)
                AddVaultSuccessController_Factory.newInstance(
                    fxApplicationComponentImpl.fxApplicationWindowsProvider.get(),
                    addVaultWizardComponentImpl.provideStageProvider.get(),
                    addVaultWizardComponentImpl.provideVaultProvider.get());

          case 8: // @org.cryptomator.ui.addvaultwizard.AddVaultWizardWindow
                  // javafx.beans.property.ObjectProperty<org.cryptomator.common.vaults.Vault>
            return (T) AddVaultModule_ProvideVaultFactory.provideVault();

          case 9: // org.cryptomator.ui.addvaultwizard.ChooseExistingVaultController
            return (T)
                ChooseExistingVaultController_Factory.newInstance(
                    addVaultWizardComponentImpl.provideStageProvider.get(),
                    DoubleCheck.lazy(
                        addVaultWizardComponentImpl.provideCreateNewVaultSuccessSceneProvider),
                    fxApplicationComponentImpl.fxApplicationWindowsProvider.get(),
                    addVaultWizardComponentImpl.provideVaultPathProvider.get(),
                    addVaultWizardComponentImpl.provideVaultProvider.get(),
                    cryptomatorComponentImpl.vaultListManagerProvider.get(),
                    cryptomatorComponentImpl.provideLocalizationProvider.get(),
                    fxApplicationComponentImpl.fxApplicationStyleProvider.get());

          case 10: // @org.cryptomator.ui.common.FxmlScene(ADDVAULT_SUCCESS) javafx.scene.Scene
            return (T)
                AddVaultModule_ProvideCreateNewVaultSuccessSceneFactory
                    .provideCreateNewVaultSuccessScene(
                        addVaultWizardComponentImpl.provideFxmlLoaderFactoryProvider.get());

          case 11: // javafx.beans.property.ObjectProperty<java.nio.file.Path>
            return (T) AddVaultModule_ProvideVaultPathFactory.provideVaultPath();

          case 12: // org.cryptomator.ui.addvaultwizard.CreateNewVaultExpertSettingsController
            return (T)
                CreateNewVaultExpertSettingsController_Factory.newInstance(
                    addVaultWizardComponentImpl.provideStageProvider.get(),
                    DoubleCheck.lazy(fxApplicationComponentImpl.fxApplicationProvider),
                    DoubleCheck.lazy(
                        addVaultWizardComponentImpl.provideCreateNewVaultLocationSceneProvider),
                    DoubleCheck.lazy(
                        addVaultWizardComponentImpl.provideCreateNewVaultPasswordSceneProvider),
                    addVaultWizardComponentImpl.provideVaultNameProvider.get(),
                    addVaultWizardComponentImpl.provideVaultPathProvider.get(),
                    addVaultWizardComponentImpl.provideShorteningThresholdProvider.get());

          case 13: // @org.cryptomator.ui.common.FxmlScene(ADDVAULT_NEW_LOCATION) javafx.scene.Scene
            return (T)
                AddVaultModule_ProvideCreateNewVaultLocationSceneFactory
                    .provideCreateNewVaultLocationScene(
                        addVaultWizardComponentImpl.provideFxmlLoaderFactoryProvider.get());

          case 14: // @org.cryptomator.ui.common.FxmlScene(ADDVAULT_NEW_PASSWORD) javafx.scene.Scene
            return (T)
                AddVaultModule_ProvideCreateNewVaultPasswordSceneFactory
                    .provideCreateNewVaultPasswordScene(
                        addVaultWizardComponentImpl.provideFxmlLoaderFactoryProvider.get());

          case 15: // @javax.inject.Named("shorteningThreshold")
                   // javafx.beans.property.IntegerProperty
            return (T)
                AddVaultModule_ProvideShorteningThresholdFactory.provideShorteningThreshold();

          case 16: // org.cryptomator.ui.addvaultwizard.CreateNewVaultLocationController
            return (T)
                CreateNewVaultLocationController_Factory.newInstance(
                    addVaultWizardComponentImpl.provideStageProvider.get(),
                    DoubleCheck.lazy(
                        addVaultWizardComponentImpl.provideCreateNewVaultNameSceneProvider),
                    DoubleCheck.lazy(
                        addVaultWizardComponentImpl
                            .provideCreateNewVaultExpertSettingsSceneProvider),
                    addVaultWizardComponentImpl.provideVaultPathProvider.get(),
                    addVaultWizardComponentImpl.provideVaultNameProvider.get(),
                    cryptomatorComponentImpl.provideExecutorServiceProvider.get(),
                    cryptomatorComponentImpl.provideLocalizationProvider.get());

          case 17: // @org.cryptomator.ui.common.FxmlScene(ADDVAULT_NEW_NAME) javafx.scene.Scene
            return (T)
                AddVaultModule_ProvideCreateNewVaultNameSceneFactory.provideCreateNewVaultNameScene(
                    addVaultWizardComponentImpl.provideFxmlLoaderFactoryProvider.get());

          case 18: // @org.cryptomator.ui.common.FxmlScene(ADDVAULT_NEW_EXPERT_SETTINGS)
                   // javafx.scene.Scene
            return (T)
                AddVaultModule_ProvideCreateNewVaultExpertSettingsSceneFactory
                    .provideCreateNewVaultExpertSettingsScene(
                        addVaultWizardComponentImpl.provideFxmlLoaderFactoryProvider.get());

          case 19: // org.cryptomator.ui.addvaultwizard.CreateNewVaultNameController
            return (T)
                CreateNewVaultNameController_Factory.newInstance(
                    addVaultWizardComponentImpl.provideStageProvider.get(),
                    DoubleCheck.lazy(
                        addVaultWizardComponentImpl.provideCreateNewVaultLocationSceneProvider),
                    addVaultWizardComponentImpl.provideVaultPathProvider.get(),
                    addVaultWizardComponentImpl.provideVaultNameProvider.get());

          case 20: // org.cryptomator.ui.addvaultwizard.CreateNewVaultPasswordController
            return (T)
                CreateNewVaultPasswordController_Factory.newInstance(
                    addVaultWizardComponentImpl.provideStageProvider.get(),
                    DoubleCheck.lazy(
                        addVaultWizardComponentImpl
                            .provideCreateNewVaultExpertSettingsSceneProvider),
                    DoubleCheck.lazy(
                        addVaultWizardComponentImpl.provideCreateNewVaultRecoveryKeySceneProvider),
                    DoubleCheck.lazy(
                        addVaultWizardComponentImpl.provideCreateNewVaultSuccessSceneProvider),
                    fxApplicationComponentImpl.fxApplicationWindowsProvider.get(),
                    cryptomatorComponentImpl.provideExecutorServiceProvider.get(),
                    cryptomatorComponentImpl.recoveryKeyFactoryProvider.get(),
                    addVaultWizardComponentImpl.provideVaultNameProvider.get(),
                    addVaultWizardComponentImpl.provideVaultPathProvider.get(),
                    addVaultWizardComponentImpl.provideVaultProvider.get(),
                    addVaultWizardComponentImpl.provideRecoveryKeyProvider.get(),
                    cryptomatorComponentImpl.vaultListManagerProvider.get(),
                    cryptomatorComponentImpl.provideLocalizationProvider.get(),
                    addVaultWizardComponentImpl.provideShorteningThresholdProvider.get(),
                    addVaultWizardComponentImpl.readmeGeneratorProvider.get(),
                    cryptomatorComponentImpl.provideCSPRNGProvider.get(),
                    cryptomatorComponentImpl.provideMasterkeyFileAccessProvider.get());

          case 21: // @org.cryptomator.ui.common.FxmlScene(ADDVAULT_NEW_RECOVERYKEY)
                   // javafx.scene.Scene
            return (T)
                AddVaultModule_ProvideCreateNewVaultRecoveryKeySceneFactory
                    .provideCreateNewVaultRecoveryKeyScene(
                        addVaultWizardComponentImpl.provideFxmlLoaderFactoryProvider.get());

          case 22: // org.cryptomator.ui.addvaultwizard.ReadmeGenerator
            return (T)
                new ReadmeGenerator(cryptomatorComponentImpl.provideLocalizationProvider.get());

          case 23: // org.cryptomator.ui.addvaultwizard.CreateNewVaultRecoveryKeyController
            return (T)
                CreateNewVaultRecoveryKeyController_Factory.newInstance(
                    addVaultWizardComponentImpl.provideStageProvider.get(),
                    DoubleCheck.lazy(
                        addVaultWizardComponentImpl.provideCreateNewVaultSuccessSceneProvider));

          default:
            throw new AssertionError(id);
        }
      }
    }
  }

  private static final class MainWindowComponentImpl implements MainWindowComponent {
    private final CryptomatorComponentImpl cryptomatorComponentImpl;

    private final FxApplicationComponentImpl fxApplicationComponentImpl;

    private final MainWindowComponentImpl mainWindowComponentImpl = this;

    private Provider<Stage> provideMainWindowProvider;

    private Provider<ObjectProperty<Vault>> provideSelectedVaultProvider;

    private Provider<MainWindowController> mainWindowControllerProvider;

    private Provider<MainWindowTitleController> mainWindowTitleControllerProvider;

    private Provider<ResizeController> resizeControllerProvider;

    private Provider<VaultDetailController> vaultDetailControllerProvider;

    private Provider<VaultDetailLockedController> vaultDetailLockedControllerProvider;

    private Provider<VaultDetailMissingVaultController> vaultDetailMissingVaultControllerProvider;

    private Provider<VaultDetailNeedsMigrationController>
        vaultDetailNeedsMigrationControllerProvider;

    private Provider<Stage> provideErrorStageProvider;

    private Provider<VaultDetailUnknownErrorController> vaultDetailUnknownErrorControllerProvider;

    private Provider<VaultDetailUnlockedController> vaultDetailUnlockedControllerProvider;

    private Provider<VaultListCellController> vaultListCellControllerProvider;

    private Provider<VaultListContextMenuController> vaultListContextMenuControllerProvider;

    private Provider<FxmlLoaderFactory> provideFxmlLoaderFactoryProvider;

    private Provider<VaultListCellFactory> vaultListCellFactoryProvider;

    private Provider<VaultListController> vaultListControllerProvider;

    private Provider<WelcomeController> welcomeControllerProvider;

    private Provider<MainWindowSceneFactory> mainWindowSceneFactoryProvider;

    private Provider<Scene> provideMainSceneProvider;

    private MainWindowComponentImpl(
        CryptomatorComponentImpl cryptomatorComponentImpl,
        FxApplicationComponentImpl fxApplicationComponentImpl) {
      this.cryptomatorComponentImpl = cryptomatorComponentImpl;
      this.fxApplicationComponentImpl = fxApplicationComponentImpl;

      initialize();
    }

    private Map<Class<? extends FxController>, javax.inject.Provider<FxController>>
        mapOfClassOfAndProviderOfFxController() {
      return ImmutableMap
          .<Class<? extends FxController>, javax.inject.Provider<FxController>>
              builderWithExpectedSize(13)
          .put(MainWindowController.class, ((Provider) mainWindowControllerProvider))
          .put(MainWindowTitleController.class, ((Provider) mainWindowTitleControllerProvider))
          .put(ResizeController.class, ((Provider) resizeControllerProvider))
          .put(VaultDetailController.class, ((Provider) vaultDetailControllerProvider))
          .put(VaultDetailLockedController.class, ((Provider) vaultDetailLockedControllerProvider))
          .put(
              VaultDetailMissingVaultController.class,
              ((Provider) vaultDetailMissingVaultControllerProvider))
          .put(
              VaultDetailNeedsMigrationController.class,
              ((Provider) vaultDetailNeedsMigrationControllerProvider))
          .put(
              VaultDetailUnknownErrorController.class,
              ((Provider) vaultDetailUnknownErrorControllerProvider))
          .put(
              VaultDetailUnlockedController.class,
              ((Provider) vaultDetailUnlockedControllerProvider))
          .put(VaultListCellController.class, ((Provider) vaultListCellControllerProvider))
          .put(
              VaultListContextMenuController.class,
              ((Provider) vaultListContextMenuControllerProvider))
          .put(VaultListController.class, ((Provider) vaultListControllerProvider))
          .put(WelcomeController.class, ((Provider) welcomeControllerProvider))
          .build();
    }

    @SuppressWarnings("unchecked")
    private void initialize() {
      this.provideMainWindowProvider =
          DoubleCheck.provider(
              new SwitchingProvider<Stage>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  mainWindowComponentImpl,
                  3));
      this.provideSelectedVaultProvider =
          DoubleCheck.provider(
              new SwitchingProvider<ObjectProperty<Vault>>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  mainWindowComponentImpl,
                  4));
      this.mainWindowControllerProvider =
          DoubleCheck.provider(
              new SwitchingProvider<MainWindowController>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  mainWindowComponentImpl,
                  2));
      this.mainWindowTitleControllerProvider =
          DoubleCheck.provider(
              new SwitchingProvider<MainWindowTitleController>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  mainWindowComponentImpl,
                  5));
      this.resizeControllerProvider =
          new SwitchingProvider<>(
              cryptomatorComponentImpl, fxApplicationComponentImpl, mainWindowComponentImpl, 6);
      this.vaultDetailControllerProvider =
          DoubleCheck.provider(
              new SwitchingProvider<VaultDetailController>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  mainWindowComponentImpl,
                  7));
      this.vaultDetailLockedControllerProvider =
          DoubleCheck.provider(
              new SwitchingProvider<VaultDetailLockedController>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  mainWindowComponentImpl,
                  8));
      this.vaultDetailMissingVaultControllerProvider =
          DoubleCheck.provider(
              new SwitchingProvider<VaultDetailMissingVaultController>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  mainWindowComponentImpl,
                  9));
      this.vaultDetailNeedsMigrationControllerProvider =
          DoubleCheck.provider(
              new SwitchingProvider<VaultDetailNeedsMigrationController>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  mainWindowComponentImpl,
                  10));
      this.provideErrorStageProvider =
          DoubleCheck.provider(
              new SwitchingProvider<Stage>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  mainWindowComponentImpl,
                  12));
      this.vaultDetailUnknownErrorControllerProvider =
          DoubleCheck.provider(
              new SwitchingProvider<VaultDetailUnknownErrorController>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  mainWindowComponentImpl,
                  11));
      this.vaultDetailUnlockedControllerProvider =
          DoubleCheck.provider(
              new SwitchingProvider<VaultDetailUnlockedController>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  mainWindowComponentImpl,
                  13));
      this.vaultListCellControllerProvider =
          new SwitchingProvider<>(
              cryptomatorComponentImpl, fxApplicationComponentImpl, mainWindowComponentImpl, 14);
      this.vaultListContextMenuControllerProvider =
          DoubleCheck.provider(
              new SwitchingProvider<VaultListContextMenuController>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  mainWindowComponentImpl,
                  15));
      this.provideFxmlLoaderFactoryProvider = new DelegateFactory<>();
      this.vaultListCellFactoryProvider =
          DoubleCheck.provider(
              new SwitchingProvider<VaultListCellFactory>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  mainWindowComponentImpl,
                  17));
      this.vaultListControllerProvider =
          DoubleCheck.provider(
              new SwitchingProvider<VaultListController>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  mainWindowComponentImpl,
                  16));
      this.welcomeControllerProvider =
          DoubleCheck.provider(
              new SwitchingProvider<WelcomeController>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  mainWindowComponentImpl,
                  18));
      this.mainWindowSceneFactoryProvider =
          DoubleCheck.provider(
              new SwitchingProvider<MainWindowSceneFactory>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  mainWindowComponentImpl,
                  19));
      DelegateFactory.setDelegate(
          provideFxmlLoaderFactoryProvider,
          DoubleCheck.provider(
              new SwitchingProvider<FxmlLoaderFactory>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  mainWindowComponentImpl,
                  1)));
      this.provideMainSceneProvider =
          DoubleCheck.provider(
              new SwitchingProvider<Scene>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  mainWindowComponentImpl,
                  0));
    }

    @Override
    public Lazy<Scene> scene() {
      return DoubleCheck.lazy(provideMainSceneProvider);
    }

    @Override
    public Stage window() {
      return provideMainWindowProvider.get();
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final CryptomatorComponentImpl cryptomatorComponentImpl;

      private final FxApplicationComponentImpl fxApplicationComponentImpl;

      private final MainWindowComponentImpl mainWindowComponentImpl;

      private final int id;

      SwitchingProvider(
          CryptomatorComponentImpl cryptomatorComponentImpl,
          FxApplicationComponentImpl fxApplicationComponentImpl,
          MainWindowComponentImpl mainWindowComponentImpl,
          int id) {
        this.cryptomatorComponentImpl = cryptomatorComponentImpl;
        this.fxApplicationComponentImpl = fxApplicationComponentImpl;
        this.mainWindowComponentImpl = mainWindowComponentImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // @org.cryptomator.ui.common.FxmlScene(MAIN_WINDOW) javafx.scene.Scene
            return (T)
                MainWindowModule_ProvideMainSceneFactory.provideMainScene(
                    mainWindowComponentImpl.provideFxmlLoaderFactoryProvider.get());

          case 1: // @org.cryptomator.ui.mainwindow.MainWindow
                  // org.cryptomator.ui.common.FxmlLoaderFactory
            return (T)
                MainWindowModule_ProvideFxmlLoaderFactoryFactory.provideFxmlLoaderFactory(
                    mainWindowComponentImpl.mapOfClassOfAndProviderOfFxController(),
                    mainWindowComponentImpl.mainWindowSceneFactoryProvider.get(),
                    cryptomatorComponentImpl.provideLocalizationProvider.get());

          case 2: // org.cryptomator.ui.mainwindow.MainWindowController
            return (T)
                new MainWindowController(
                    mainWindowComponentImpl.provideMainWindowProvider.get(),
                    mainWindowComponentImpl.provideSelectedVaultProvider.get());

          case 3: // @org.cryptomator.ui.mainwindow.MainWindow javafx.stage.Stage
            return (T)
                MainWindowModule_ProvideMainWindowFactory.provideMainWindow(
                    fxApplicationComponentImpl.primaryStage,
                    fxApplicationComponentImpl.stageInitializerProvider.get());

          case 4: // javafx.beans.property.ObjectProperty<org.cryptomator.common.vaults.Vault>
            return (T) MainWindowModule_ProvideSelectedVaultFactory.provideSelectedVault();

          case 5: // org.cryptomator.ui.mainwindow.MainWindowTitleController
            return (T)
                MainWindowTitleController_Factory.newInstance(
                    mainWindowComponentImpl.provideMainWindowProvider.get(),
                    fxApplicationComponentImpl.fxApplicationTerminatorProvider.get(),
                    fxApplicationComponentImpl.fxApplicationWindowsProvider.get(),
                    fxApplicationComponentImpl.provideTrayMenuComponentProvider.get(),
                    fxApplicationComponentImpl.updateCheckerProvider.get(),
                    cryptomatorComponentImpl.licenseHolderProvider.get(),
                    cryptomatorComponentImpl.provideSettingsProvider.get());

          case 6: // org.cryptomator.ui.mainwindow.ResizeController
            return (T)
                ResizeController_Factory.newInstance(
                    mainWindowComponentImpl.provideMainWindowProvider.get(),
                    cryptomatorComponentImpl.provideSettingsProvider.get());

          case 7: // org.cryptomator.ui.mainwindow.VaultDetailController
            return (T)
                VaultDetailController_Factory.newInstance(
                    mainWindowComponentImpl.provideSelectedVaultProvider.get(),
                    fxApplicationComponentImpl.fxApplicationProvider.get());

          case 8: // org.cryptomator.ui.mainwindow.VaultDetailLockedController
            return (T)
                VaultDetailLockedController_Factory.newInstance(
                    mainWindowComponentImpl.provideSelectedVaultProvider.get(),
                    fxApplicationComponentImpl.fxApplicationWindowsProvider.get(),
                    new VaultOptionsComponentFactory(
                        cryptomatorComponentImpl, fxApplicationComponentImpl),
                    cryptomatorComponentImpl.keychainManagerProvider.get(),
                    mainWindowComponentImpl.provideMainWindowProvider.get());

          case 9: // org.cryptomator.ui.mainwindow.VaultDetailMissingVaultController
            return (T)
                new VaultDetailMissingVaultController(
                    mainWindowComponentImpl.provideSelectedVaultProvider.get(),
                    new RemoveVaultComponentBuilder(
                        cryptomatorComponentImpl,
                        fxApplicationComponentImpl,
                        mainWindowComponentImpl),
                    cryptomatorComponentImpl.provideLocalizationProvider.get(),
                    mainWindowComponentImpl.provideMainWindowProvider.get());

          case 10: // org.cryptomator.ui.mainwindow.VaultDetailNeedsMigrationController
            return (T)
                new VaultDetailNeedsMigrationController(
                    mainWindowComponentImpl.provideSelectedVaultProvider.get(),
                    new MigrationComponentBuilder(
                        cryptomatorComponentImpl,
                        fxApplicationComponentImpl,
                        mainWindowComponentImpl));

          case 11: // org.cryptomator.ui.mainwindow.VaultDetailUnknownErrorController
            return (T)
                new VaultDetailUnknownErrorController(
                    mainWindowComponentImpl.provideSelectedVaultProvider.get(),
                    fxApplicationComponentImpl.fxApplicationWindowsProvider.get(),
                    mainWindowComponentImpl.provideErrorStageProvider.get(),
                    new RemoveVaultComponentBuilder(
                        cryptomatorComponentImpl,
                        fxApplicationComponentImpl,
                        mainWindowComponentImpl));

          case 12: // @javax.inject.Named("errorWindow") javafx.stage.Stage
            return (T)
                MainWindowModule_ProvideErrorStageFactory.provideErrorStage(
                    mainWindowComponentImpl.provideMainWindowProvider.get(),
                    fxApplicationComponentImpl.stageFactoryProvider.get(),
                    cryptomatorComponentImpl.provideLocalizationProvider.get());

          case 13: // org.cryptomator.ui.mainwindow.VaultDetailUnlockedController
            return (T)
                new VaultDetailUnlockedController(
                    mainWindowComponentImpl.provideSelectedVaultProvider.get(),
                    fxApplicationComponentImpl.fxApplicationWindowsProvider.get(),
                    fxApplicationComponentImpl.vaultServiceProvider.get(),
                    new VaultStatisticsComponentBuilder(
                        cryptomatorComponentImpl,
                        fxApplicationComponentImpl,
                        mainWindowComponentImpl),
                    new WrongFileAlertComponentBuilder(
                        cryptomatorComponentImpl,
                        fxApplicationComponentImpl,
                        mainWindowComponentImpl),
                    mainWindowComponentImpl.provideMainWindowProvider.get(),
                    cryptomatorComponentImpl.provideRevealPathServiceProvider.get(),
                    cryptomatorComponentImpl.provideLocalizationProvider.get());

          case 14: // org.cryptomator.ui.mainwindow.VaultListCellController
            return (T) VaultListCellController_Factory.newInstance();

          case 15: // org.cryptomator.ui.mainwindow.VaultListContextMenuController
            return (T)
                VaultListContextMenuController_Factory.newInstance(
                    mainWindowComponentImpl.provideSelectedVaultProvider.get(),
                    mainWindowComponentImpl.provideMainWindowProvider.get(),
                    fxApplicationComponentImpl.fxApplicationWindowsProvider.get(),
                    fxApplicationComponentImpl.vaultServiceProvider.get(),
                    cryptomatorComponentImpl.keychainManagerProvider.get(),
                    new RemoveVaultComponentBuilder(
                        cryptomatorComponentImpl,
                        fxApplicationComponentImpl,
                        mainWindowComponentImpl),
                    new VaultOptionsComponentFactory(
                        cryptomatorComponentImpl, fxApplicationComponentImpl));

          case 16: // org.cryptomator.ui.mainwindow.VaultListController
            return (T)
                VaultListController_Factory.newInstance(
                    mainWindowComponentImpl.provideMainWindowProvider.get(),
                    cryptomatorComponentImpl.provideVaultListProvider.get(),
                    mainWindowComponentImpl.provideSelectedVaultProvider.get(),
                    mainWindowComponentImpl.vaultListCellFactoryProvider.get(),
                    fxApplicationComponentImpl.vaultServiceProvider.get(),
                    new AddVaultWizardComponentBuilder(
                        cryptomatorComponentImpl,
                        fxApplicationComponentImpl,
                        mainWindowComponentImpl),
                    new RemoveVaultComponentBuilder(
                        cryptomatorComponentImpl,
                        fxApplicationComponentImpl,
                        mainWindowComponentImpl),
                    cryptomatorComponentImpl.vaultListManagerProvider.get(),
                    cryptomatorComponentImpl.provideLocalizationProvider.get(),
                    fxApplicationComponentImpl.fxApplicationWindowsProvider.get());

          case 17: // org.cryptomator.ui.mainwindow.VaultListCellFactory
            return (T)
                VaultListCellFactory_Factory.newInstance(
                    mainWindowComponentImpl.provideFxmlLoaderFactoryProvider.get());

          case 18: // org.cryptomator.ui.mainwindow.WelcomeController
            return (T)
                new WelcomeController(
                    fxApplicationComponentImpl.fxApplicationProvider.get(),
                    cryptomatorComponentImpl.provideVaultListProvider.get());

          case 19: // org.cryptomator.ui.mainwindow.MainWindowSceneFactory
            return (T)
                new MainWindowSceneFactory(
                    cryptomatorComponentImpl.provideSettingsProvider.get(),
                    DoubleCheck.lazy(mainWindowComponentImpl.mainWindowTitleControllerProvider),
                    DoubleCheck.lazy(mainWindowComponentImpl.vaultListControllerProvider));

          default:
            throw new AssertionError(id);
        }
      }
    }
  }

  private static final class PreferencesComponentImpl implements PreferencesComponent {
    private final CryptomatorComponentImpl cryptomatorComponentImpl;

    private final FxApplicationComponentImpl fxApplicationComponentImpl;

    private final PreferencesComponentImpl preferencesComponentImpl = this;

    private Provider<AboutController> aboutControllerProvider;

    private Provider<Stage> provideStageProvider;

    private Provider<GeneralPreferencesController> generalPreferencesControllerProvider;

    private Provider<ObjectProperty<SelectedPreferencesTab>> provideSelectedTabPropertyProvider;

    private Provider<InterfacePreferencesController> interfacePreferencesControllerProvider;

    private Provider<PreferencesController> preferencesControllerProvider;

    private Provider<SupporterCertificateController> supporterCertificateControllerProvider;

    private Provider<UpdatesPreferencesController> updatesPreferencesControllerProvider;

    private Provider<VolumePreferencesController> volumePreferencesControllerProvider;

    private Provider<FxmlLoaderFactory> provideFxmlLoaderFactoryProvider;

    private Provider<Scene> providePreferencesSceneProvider;

    private PreferencesComponentImpl(
        CryptomatorComponentImpl cryptomatorComponentImpl,
        FxApplicationComponentImpl fxApplicationComponentImpl) {
      this.cryptomatorComponentImpl = cryptomatorComponentImpl;
      this.fxApplicationComponentImpl = fxApplicationComponentImpl;

      initialize();
    }

    private Map<Class<? extends FxController>, javax.inject.Provider<FxController>>
        mapOfClassOfAndProviderOfFxController() {
      return ImmutableMap
          .<Class<? extends FxController>, javax.inject.Provider<FxController>>
              builderWithExpectedSize(7)
          .put(AboutController.class, ((Provider) aboutControllerProvider))
          .put(
              GeneralPreferencesController.class, ((Provider) generalPreferencesControllerProvider))
          .put(
              InterfacePreferencesController.class,
              ((Provider) interfacePreferencesControllerProvider))
          .put(PreferencesController.class, ((Provider) preferencesControllerProvider))
          .put(
              SupporterCertificateController.class,
              ((Provider) supporterCertificateControllerProvider))
          .put(
              UpdatesPreferencesController.class, ((Provider) updatesPreferencesControllerProvider))
          .put(VolumePreferencesController.class, ((Provider) volumePreferencesControllerProvider))
          .build();
    }

    @SuppressWarnings("unchecked")
    private void initialize() {
      this.aboutControllerProvider =
          DoubleCheck.provider(
              new SwitchingProvider<AboutController>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  preferencesComponentImpl,
                  2));
      this.provideStageProvider =
          DoubleCheck.provider(
              new SwitchingProvider<Stage>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  preferencesComponentImpl,
                  4));
      this.generalPreferencesControllerProvider =
          DoubleCheck.provider(
              new SwitchingProvider<GeneralPreferencesController>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  preferencesComponentImpl,
                  3));
      this.provideSelectedTabPropertyProvider =
          DoubleCheck.provider(
              new SwitchingProvider<ObjectProperty<SelectedPreferencesTab>>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  preferencesComponentImpl,
                  6));
      this.interfacePreferencesControllerProvider =
          DoubleCheck.provider(
              new SwitchingProvider<InterfacePreferencesController>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  preferencesComponentImpl,
                  5));
      this.preferencesControllerProvider =
          DoubleCheck.provider(
              new SwitchingProvider<PreferencesController>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  preferencesComponentImpl,
                  7));
      this.supporterCertificateControllerProvider =
          DoubleCheck.provider(
              new SwitchingProvider<SupporterCertificateController>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  preferencesComponentImpl,
                  8));
      this.updatesPreferencesControllerProvider =
          DoubleCheck.provider(
              new SwitchingProvider<UpdatesPreferencesController>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  preferencesComponentImpl,
                  9));
      this.volumePreferencesControllerProvider =
          DoubleCheck.provider(
              new SwitchingProvider<VolumePreferencesController>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  preferencesComponentImpl,
                  10));
      this.provideFxmlLoaderFactoryProvider =
          DoubleCheck.provider(
              new SwitchingProvider<FxmlLoaderFactory>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  preferencesComponentImpl,
                  1));
      this.providePreferencesSceneProvider =
          DoubleCheck.provider(
              new SwitchingProvider<Scene>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  preferencesComponentImpl,
                  0));
    }

    @Override
    public Lazy<Scene> scene() {
      return DoubleCheck.lazy(providePreferencesSceneProvider);
    }

    @Override
    public ObjectProperty<SelectedPreferencesTab> selectedTabProperty() {
      return provideSelectedTabPropertyProvider.get();
    }

    @Override
    public Stage window() {
      return provideStageProvider.get();
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final CryptomatorComponentImpl cryptomatorComponentImpl;

      private final FxApplicationComponentImpl fxApplicationComponentImpl;

      private final PreferencesComponentImpl preferencesComponentImpl;

      private final int id;

      SwitchingProvider(
          CryptomatorComponentImpl cryptomatorComponentImpl,
          FxApplicationComponentImpl fxApplicationComponentImpl,
          PreferencesComponentImpl preferencesComponentImpl,
          int id) {
        this.cryptomatorComponentImpl = cryptomatorComponentImpl;
        this.fxApplicationComponentImpl = fxApplicationComponentImpl;
        this.preferencesComponentImpl = preferencesComponentImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // @org.cryptomator.ui.common.FxmlScene(PREFERENCES) javafx.scene.Scene
            return (T)
                PreferencesModule_ProvidePreferencesSceneFactory.providePreferencesScene(
                    preferencesComponentImpl.provideFxmlLoaderFactoryProvider.get());

          case 1: // @org.cryptomator.ui.preferences.PreferencesWindow
                  // org.cryptomator.ui.common.FxmlLoaderFactory
            return (T)
                PreferencesModule_ProvideFxmlLoaderFactoryFactory.provideFxmlLoaderFactory(
                    preferencesComponentImpl.mapOfClassOfAndProviderOfFxController(),
                    fxApplicationComponentImpl.defaultSceneFactoryProvider.get(),
                    cryptomatorComponentImpl.provideLocalizationProvider.get());

          case 2: // org.cryptomator.ui.preferences.AboutController
            return (T)
                AboutController_Factory.newInstance(
                    fxApplicationComponentImpl.updateCheckerProvider.get(),
                    cryptomatorComponentImpl.provideEnvironmentProvider.get());

          case 3: // org.cryptomator.ui.preferences.GeneralPreferencesController
            return (T)
                GeneralPreferencesController_Factory.newInstance(
                    preferencesComponentImpl.provideStageProvider.get(),
                    cryptomatorComponentImpl.provideSettingsProvider.get(),
                    cryptomatorComponentImpl.provideAutostartProvider.get(),
                    cryptomatorComponentImpl.provideSupportedKeychainAccessProvidersProvider.get(),
                    fxApplicationComponentImpl.fxApplicationProvider.get(),
                    cryptomatorComponentImpl.provideEnvironmentProvider.get(),
                    fxApplicationComponentImpl.fxApplicationWindowsProvider.get());

          case 4: // @org.cryptomator.ui.preferences.PreferencesWindow javafx.stage.Stage
            return (T)
                PreferencesModule_ProvideStageFactory.provideStage(
                    fxApplicationComponentImpl.stageFactoryProvider.get(),
                    cryptomatorComponentImpl.provideLocalizationProvider.get());

          case 5: // org.cryptomator.ui.preferences.InterfacePreferencesController
            return (T)
                InterfacePreferencesController_Factory.newInstance(
                    cryptomatorComponentImpl.provideSettingsProvider.get(),
                    cryptomatorComponentImpl.supportedLanguagesProvider.get(),
                    fxApplicationComponentImpl.provideTrayMenuComponentProvider.get(),
                    preferencesComponentImpl.provideSelectedTabPropertyProvider.get(),
                    cryptomatorComponentImpl.licenseHolderProvider.get(),
                    cryptomatorComponentImpl.provideLocalizationProvider.get());

          case 6: // javafx.beans.property.ObjectProperty<org.cryptomator.ui.preferences.SelectedPreferencesTab>
            return (T)
                PreferencesModule_ProvideSelectedTabPropertyFactory.provideSelectedTabProperty();

          case 7: // org.cryptomator.ui.preferences.PreferencesController
            return (T)
                new PreferencesController(
                    cryptomatorComponentImpl.provideEnvironmentProvider.get(),
                    preferencesComponentImpl.provideStageProvider.get(),
                    preferencesComponentImpl.provideSelectedTabPropertyProvider.get(),
                    fxApplicationComponentImpl.updateCheckerProvider.get());

          case 8: // org.cryptomator.ui.preferences.SupporterCertificateController
            return (T)
                SupporterCertificateController_Factory.newInstance(
                    fxApplicationComponentImpl.fxApplicationProvider.get(),
                    cryptomatorComponentImpl.licenseHolderProvider.get(),
                    cryptomatorComponentImpl.provideSettingsProvider.get());

          case 9: // org.cryptomator.ui.preferences.UpdatesPreferencesController
            return (T)
                UpdatesPreferencesController_Factory.newInstance(
                    fxApplicationComponentImpl.fxApplicationProvider.get(),
                    cryptomatorComponentImpl.provideEnvironmentProvider.get(),
                    cryptomatorComponentImpl.provideLocalizationProvider.get(),
                    cryptomatorComponentImpl.provideSettingsProvider.get(),
                    fxApplicationComponentImpl.updateCheckerProvider.get());

          case 10: // org.cryptomator.ui.preferences.VolumePreferencesController
            return (T)
                VolumePreferencesController_Factory.newInstance(
                    cryptomatorComponentImpl.provideSettingsProvider.get(),
                    DoubleCheck.lazy(fxApplicationComponentImpl.fxApplicationProvider),
                    cryptomatorComponentImpl.provideSupportedMountServicesProvider.get(),
                    cryptomatorComponentImpl.provideLocalizationProvider.get());

          default:
            throw new AssertionError(id);
        }
      }
    }
  }

  private static final class QuitComponentImpl implements QuitComponent {
    private final CryptomatorComponentImpl cryptomatorComponentImpl;

    private final FxApplicationComponentImpl fxApplicationComponentImpl;

    private final QuitComponentImpl quitComponentImpl = this;

    private Provider<Stage> provideStageProvider;

    private Provider<Scene> provideQuitForcedSceneProvider;

    private Provider<AtomicReference<QuitResponse>> provideQuitResponseProvider;

    private Provider<QuitController> quitControllerProvider;

    private Provider<QuitForcedController> quitForcedControllerProvider;

    private Provider<FxmlLoaderFactory> provideFxmlLoaderFactoryProvider;

    private Provider<Scene> provideQuitSceneProvider;

    private QuitComponentImpl(
        CryptomatorComponentImpl cryptomatorComponentImpl,
        FxApplicationComponentImpl fxApplicationComponentImpl) {
      this.cryptomatorComponentImpl = cryptomatorComponentImpl;
      this.fxApplicationComponentImpl = fxApplicationComponentImpl;

      initialize();
    }

    private Map<Class<? extends FxController>, javax.inject.Provider<FxController>>
        mapOfClassOfAndProviderOfFxController() {
      return ImmutableMap.<Class<? extends FxController>, javax.inject.Provider<FxController>>of(
          QuitController.class,
          ((Provider) quitControllerProvider),
          QuitForcedController.class,
          ((Provider) quitForcedControllerProvider));
    }

    @SuppressWarnings("unchecked")
    private void initialize() {
      this.provideStageProvider =
          DoubleCheck.provider(
              new SwitchingProvider<Stage>(
                  cryptomatorComponentImpl, fxApplicationComponentImpl, quitComponentImpl, 3));
      this.provideQuitForcedSceneProvider = new DelegateFactory<>();
      this.provideQuitResponseProvider =
          DoubleCheck.provider(
              new SwitchingProvider<AtomicReference<QuitResponse>>(
                  cryptomatorComponentImpl, fxApplicationComponentImpl, quitComponentImpl, 4));
      this.quitControllerProvider =
          DoubleCheck.provider(
              new SwitchingProvider<QuitController>(
                  cryptomatorComponentImpl, fxApplicationComponentImpl, quitComponentImpl, 2));
      this.quitForcedControllerProvider =
          new SwitchingProvider<>(
              cryptomatorComponentImpl, fxApplicationComponentImpl, quitComponentImpl, 5);
      this.provideFxmlLoaderFactoryProvider =
          DoubleCheck.provider(
              new SwitchingProvider<FxmlLoaderFactory>(
                  cryptomatorComponentImpl, fxApplicationComponentImpl, quitComponentImpl, 1));
      DelegateFactory.setDelegate(
          provideQuitForcedSceneProvider,
          DoubleCheck.provider(
              new SwitchingProvider<Scene>(
                  cryptomatorComponentImpl, fxApplicationComponentImpl, quitComponentImpl, 0)));
      this.provideQuitSceneProvider =
          DoubleCheck.provider(
              new SwitchingProvider<Scene>(
                  cryptomatorComponentImpl, fxApplicationComponentImpl, quitComponentImpl, 6));
    }

    @Override
    public Lazy<Scene> quitForcedScene() {
      return DoubleCheck.lazy(provideQuitForcedSceneProvider);
    }

    @Override
    public AtomicReference<QuitResponse> quitResponse() {
      return provideQuitResponseProvider.get();
    }

    @Override
    public Lazy<Scene> quitScene() {
      return DoubleCheck.lazy(provideQuitSceneProvider);
    }

    @Override
    public Stage window() {
      return provideStageProvider.get();
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final CryptomatorComponentImpl cryptomatorComponentImpl;

      private final FxApplicationComponentImpl fxApplicationComponentImpl;

      private final QuitComponentImpl quitComponentImpl;

      private final int id;

      SwitchingProvider(
          CryptomatorComponentImpl cryptomatorComponentImpl,
          FxApplicationComponentImpl fxApplicationComponentImpl,
          QuitComponentImpl quitComponentImpl,
          int id) {
        this.cryptomatorComponentImpl = cryptomatorComponentImpl;
        this.fxApplicationComponentImpl = fxApplicationComponentImpl;
        this.quitComponentImpl = quitComponentImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // @org.cryptomator.ui.common.FxmlScene(QUIT_FORCED) javafx.scene.Scene
            return (T)
                QuitModule_ProvideQuitForcedSceneFactory.provideQuitForcedScene(
                    quitComponentImpl.provideFxmlLoaderFactoryProvider.get());

          case 1: // @org.cryptomator.ui.quit.QuitWindow org.cryptomator.ui.common.FxmlLoaderFactory
            return (T)
                QuitModule_ProvideFxmlLoaderFactoryFactory.provideFxmlLoaderFactory(
                    quitComponentImpl.mapOfClassOfAndProviderOfFxController(),
                    fxApplicationComponentImpl.defaultSceneFactoryProvider.get(),
                    cryptomatorComponentImpl.provideLocalizationProvider.get());

          case 2: // org.cryptomator.ui.quit.QuitController
            return (T)
                QuitController_Factory.newInstance(
                    quitComponentImpl.provideStageProvider.get(),
                    cryptomatorComponentImpl.provideVaultListProvider.get(),
                    cryptomatorComponentImpl.provideExecutorServiceProvider.get(),
                    fxApplicationComponentImpl.vaultServiceProvider.get(),
                    DoubleCheck.lazy(quitComponentImpl.provideQuitForcedSceneProvider),
                    quitComponentImpl.provideQuitResponseProvider.get());

          case 3: // @org.cryptomator.ui.quit.QuitWindow javafx.stage.Stage
            return (T)
                QuitModule_ProvideStageFactory.provideStage(
                    fxApplicationComponentImpl.stageFactoryProvider.get(),
                    cryptomatorComponentImpl.provideLocalizationProvider.get());

          case 4: // @org.cryptomator.ui.quit.QuitWindow
                  // java.util.concurrent.atomic.AtomicReference<java.awt.desktop.QuitResponse>
            return (T) QuitModule_ProvideQuitResponseFactory.provideQuitResponse();

          case 5: // org.cryptomator.ui.quit.QuitForcedController
            return (T)
                QuitForcedController_Factory.newInstance(
                    quitComponentImpl.provideStageProvider.get(),
                    cryptomatorComponentImpl.provideVaultListProvider.get(),
                    cryptomatorComponentImpl.provideExecutorServiceProvider.get(),
                    fxApplicationComponentImpl.vaultServiceProvider.get(),
                    quitComponentImpl.provideQuitResponseProvider.get());

          case 6: // @org.cryptomator.ui.common.FxmlScene(QUIT) javafx.scene.Scene
            return (T)
                QuitModule_ProvideQuitSceneFactory.provideQuitScene(
                    quitComponentImpl.provideFxmlLoaderFactoryProvider.get());

          default:
            throw new AssertionError(id);
        }
      }
    }
  }

  private static final class ocukm_PassphraseEntryComponentImpl
      implements PassphraseEntryComponent {
    private final Passphrase savedPassword;

    private final CryptomatorComponentImpl cryptomatorComponentImpl;

    private final FxApplicationComponentImpl fxApplicationComponentImpl;

    private final UnlockComponentImpl unlockComponentImpl;

    private final ocuk_KeyLoadingComponentImpl _ocuk_KeyLoadingComponentImpl;

    private final ocukm_PassphraseEntryComponentImpl _ocukm_PassphraseEntryComponentImpl = this;

    private Provider<CompletableFuture<PassphraseEntryResult>> provideResultProvider;

    private Provider<PassphraseEntryController> passphraseEntryControllerProvider;

    private Provider<Scene> provideUnlockSceneProvider;

    private ocukm_PassphraseEntryComponentImpl(
        CryptomatorComponentImpl cryptomatorComponentImpl,
        FxApplicationComponentImpl fxApplicationComponentImpl,
        UnlockComponentImpl unlockComponentImpl,
        ocuk_KeyLoadingComponentImpl _ocuk_KeyLoadingComponentImpl,
        Passphrase savedPasswordParam) {
      this.cryptomatorComponentImpl = cryptomatorComponentImpl;
      this.fxApplicationComponentImpl = fxApplicationComponentImpl;
      this.unlockComponentImpl = unlockComponentImpl;
      this._ocuk_KeyLoadingComponentImpl = _ocuk_KeyLoadingComponentImpl;
      this.savedPassword = savedPasswordParam;
      initialize(savedPasswordParam);
    }

    @SuppressWarnings("unchecked")
    private void initialize(final Passphrase savedPasswordParam) {
      this.provideResultProvider =
          DoubleCheck.provider(
              new SwitchingProvider<CompletableFuture<PassphraseEntryResult>>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  unlockComponentImpl,
                  _ocuk_KeyLoadingComponentImpl,
                  _ocukm_PassphraseEntryComponentImpl,
                  2));
      this.passphraseEntryControllerProvider =
          DoubleCheck.provider(
              new SwitchingProvider<PassphraseEntryController>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  unlockComponentImpl,
                  _ocuk_KeyLoadingComponentImpl,
                  _ocukm_PassphraseEntryComponentImpl,
                  1));
      this.provideUnlockSceneProvider =
          DoubleCheck.provider(
              new SwitchingProvider<Scene>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  unlockComponentImpl,
                  _ocuk_KeyLoadingComponentImpl,
                  _ocukm_PassphraseEntryComponentImpl,
                  0));
    }

    @Override
    public Scene passphraseEntryScene() {
      return provideUnlockSceneProvider.get();
    }

    @Override
    public CompletableFuture<PassphraseEntryResult> result() {
      return provideResultProvider.get();
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final CryptomatorComponentImpl cryptomatorComponentImpl;

      private final FxApplicationComponentImpl fxApplicationComponentImpl;

      private final UnlockComponentImpl unlockComponentImpl;

      private final ocuk_KeyLoadingComponentImpl _ocuk_KeyLoadingComponentImpl;

      private final ocukm_PassphraseEntryComponentImpl _ocukm_PassphraseEntryComponentImpl;

      private final int id;

      SwitchingProvider(
          CryptomatorComponentImpl cryptomatorComponentImpl,
          FxApplicationComponentImpl fxApplicationComponentImpl,
          UnlockComponentImpl unlockComponentImpl,
          ocuk_KeyLoadingComponentImpl _ocuk_KeyLoadingComponentImpl,
          ocukm_PassphraseEntryComponentImpl _ocukm_PassphraseEntryComponentImpl,
          int id) {
        this.cryptomatorComponentImpl = cryptomatorComponentImpl;
        this.fxApplicationComponentImpl = fxApplicationComponentImpl;
        this.unlockComponentImpl = unlockComponentImpl;
        this._ocuk_KeyLoadingComponentImpl = _ocuk_KeyLoadingComponentImpl;
        this._ocukm_PassphraseEntryComponentImpl = _ocukm_PassphraseEntryComponentImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // javafx.scene.Scene
            return (T)
                PassphraseEntryModule_ProvideUnlockSceneFactory.provideUnlockScene(
                    _ocukm_PassphraseEntryComponentImpl.passphraseEntryControllerProvider.get(),
                    fxApplicationComponentImpl.defaultSceneFactoryProvider.get(),
                    cryptomatorComponentImpl.provideLocalizationProvider.get());

          case 1: // org.cryptomator.ui.keyloading.masterkeyfile.PassphraseEntryController
            return (T)
                new PassphraseEntryController(
                    _ocuk_KeyLoadingComponentImpl.window,
                    _ocuk_KeyLoadingComponentImpl.vault,
                    _ocukm_PassphraseEntryComponentImpl.provideResultProvider.get(),
                    _ocukm_PassphraseEntryComponentImpl.savedPassword,
                    new ocuf_ForgetPasswordComponentBuilder(
                        cryptomatorComponentImpl,
                        fxApplicationComponentImpl,
                        unlockComponentImpl,
                        _ocuk_KeyLoadingComponentImpl),
                    cryptomatorComponentImpl.keychainManagerProvider.get());

          case 2: // java.util.concurrent.CompletableFuture<org.cryptomator.ui.keyloading.masterkeyfile.PassphraseEntryResult>
            return (T) PassphraseEntryModule_ProvideResultFactory.provideResult();

          default:
            throw new AssertionError(id);
        }
      }
    }
  }

  private static final class ocukm_ChooseMasterkeyFileComponentImpl
      implements ChooseMasterkeyFileComponent {
    private final CryptomatorComponentImpl cryptomatorComponentImpl;

    private final FxApplicationComponentImpl fxApplicationComponentImpl;

    private final UnlockComponentImpl unlockComponentImpl;

    private final ocuk_KeyLoadingComponentImpl _ocuk_KeyLoadingComponentImpl;

    private final ocukm_ChooseMasterkeyFileComponentImpl _ocukm_ChooseMasterkeyFileComponentImpl =
        this;

    private Provider<CompletableFuture<Path>> provideResultProvider;

    private Provider<ChooseMasterkeyFileController> chooseMasterkeyFileControllerProvider;

    private Provider<Scene> provideChooseMasterkeySceneProvider;

    private ocukm_ChooseMasterkeyFileComponentImpl(
        CryptomatorComponentImpl cryptomatorComponentImpl,
        FxApplicationComponentImpl fxApplicationComponentImpl,
        UnlockComponentImpl unlockComponentImpl,
        ocuk_KeyLoadingComponentImpl _ocuk_KeyLoadingComponentImpl) {
      this.cryptomatorComponentImpl = cryptomatorComponentImpl;
      this.fxApplicationComponentImpl = fxApplicationComponentImpl;
      this.unlockComponentImpl = unlockComponentImpl;
      this._ocuk_KeyLoadingComponentImpl = _ocuk_KeyLoadingComponentImpl;

      initialize();
    }

    @SuppressWarnings("unchecked")
    private void initialize() {
      this.provideResultProvider =
          DoubleCheck.provider(
              new SwitchingProvider<CompletableFuture<Path>>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  unlockComponentImpl,
                  _ocuk_KeyLoadingComponentImpl,
                  _ocukm_ChooseMasterkeyFileComponentImpl,
                  2));
      this.chooseMasterkeyFileControllerProvider =
          DoubleCheck.provider(
              new SwitchingProvider<ChooseMasterkeyFileController>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  unlockComponentImpl,
                  _ocuk_KeyLoadingComponentImpl,
                  _ocukm_ChooseMasterkeyFileComponentImpl,
                  1));
      this.provideChooseMasterkeySceneProvider =
          DoubleCheck.provider(
              new SwitchingProvider<Scene>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  unlockComponentImpl,
                  _ocuk_KeyLoadingComponentImpl,
                  _ocukm_ChooseMasterkeyFileComponentImpl,
                  0));
    }

    @Override
    public Scene chooseMasterkeyScene() {
      return provideChooseMasterkeySceneProvider.get();
    }

    @Override
    public CompletableFuture<Path> result() {
      return provideResultProvider.get();
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final CryptomatorComponentImpl cryptomatorComponentImpl;

      private final FxApplicationComponentImpl fxApplicationComponentImpl;

      private final UnlockComponentImpl unlockComponentImpl;

      private final ocuk_KeyLoadingComponentImpl _ocuk_KeyLoadingComponentImpl;

      private final ocukm_ChooseMasterkeyFileComponentImpl _ocukm_ChooseMasterkeyFileComponentImpl;

      private final int id;

      SwitchingProvider(
          CryptomatorComponentImpl cryptomatorComponentImpl,
          FxApplicationComponentImpl fxApplicationComponentImpl,
          UnlockComponentImpl unlockComponentImpl,
          ocuk_KeyLoadingComponentImpl _ocuk_KeyLoadingComponentImpl,
          ocukm_ChooseMasterkeyFileComponentImpl _ocukm_ChooseMasterkeyFileComponentImpl,
          int id) {
        this.cryptomatorComponentImpl = cryptomatorComponentImpl;
        this.fxApplicationComponentImpl = fxApplicationComponentImpl;
        this.unlockComponentImpl = unlockComponentImpl;
        this._ocuk_KeyLoadingComponentImpl = _ocuk_KeyLoadingComponentImpl;
        this._ocukm_ChooseMasterkeyFileComponentImpl = _ocukm_ChooseMasterkeyFileComponentImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // javafx.scene.Scene
            return (T)
                ChooseMasterkeyFileModule_ProvideChooseMasterkeySceneFactory
                    .provideChooseMasterkeyScene(
                        _ocukm_ChooseMasterkeyFileComponentImpl
                            .chooseMasterkeyFileControllerProvider.get(),
                        fxApplicationComponentImpl.defaultSceneFactoryProvider.get(),
                        cryptomatorComponentImpl.provideLocalizationProvider.get());

          case 1: // org.cryptomator.ui.keyloading.masterkeyfile.ChooseMasterkeyFileController
            return (T)
                new ChooseMasterkeyFileController(
                    _ocuk_KeyLoadingComponentImpl.window,
                    _ocuk_KeyLoadingComponentImpl.vault,
                    _ocukm_ChooseMasterkeyFileComponentImpl.provideResultProvider.get(),
                    cryptomatorComponentImpl.provideLocalizationProvider.get());

          case 2: // java.util.concurrent.CompletableFuture<java.nio.file.Path>
            return (T) ChooseMasterkeyFileModule_ProvideResultFactory.provideResult();

          default:
            throw new AssertionError(id);
        }
      }
    }
  }

  private static final class ocuf_ForgetPasswordComponentImpl implements ForgetPasswordComponent {
    private final Stage owner;

    private final Vault vault;

    private final CryptomatorComponentImpl cryptomatorComponentImpl;

    private final FxApplicationComponentImpl fxApplicationComponentImpl;

    private final UnlockComponentImpl unlockComponentImpl;

    private final ocuk_KeyLoadingComponentImpl _ocuk_KeyLoadingComponentImpl;

    private final ocuf_ForgetPasswordComponentImpl _ocuf_ForgetPasswordComponentImpl = this;

    private Provider<BooleanProperty> provideConfirmedPropertyProvider;

    private Provider<Stage> provideStageProvider;

    private Provider<ForgetPasswordController> forgetPasswordControllerProvider;

    private Provider<FxmlLoaderFactory> provideFxmlLoaderFactoryProvider;

    private Provider<Scene> provideForgetPasswordSceneProvider;

    private ocuf_ForgetPasswordComponentImpl(
        CryptomatorComponentImpl cryptomatorComponentImpl,
        FxApplicationComponentImpl fxApplicationComponentImpl,
        UnlockComponentImpl unlockComponentImpl,
        ocuk_KeyLoadingComponentImpl _ocuk_KeyLoadingComponentImpl,
        Stage ownerParam,
        Vault vaultParam) {
      this.cryptomatorComponentImpl = cryptomatorComponentImpl;
      this.fxApplicationComponentImpl = fxApplicationComponentImpl;
      this.unlockComponentImpl = unlockComponentImpl;
      this._ocuk_KeyLoadingComponentImpl = _ocuk_KeyLoadingComponentImpl;
      this.owner = ownerParam;
      this.vault = vaultParam;
      initialize(ownerParam, vaultParam);
    }

    private Map<Class<? extends FxController>, javax.inject.Provider<FxController>>
        mapOfClassOfAndProviderOfFxController() {
      return ImmutableMap
          .<Class<? extends FxController>, javax.inject.Provider<FxController>>
              builderWithExpectedSize(15)
          .put(
              UnlockInvalidMountPointController.class,
              ((Provider) unlockComponentImpl.unlockInvalidMountPointControllerProvider))
          .put(
              UnlockRequiresRestartController.class,
              ((Provider) unlockComponentImpl.unlockRequiresRestartControllerProvider))
          .put(
              UnlockSuccessController.class,
              ((Provider) unlockComponentImpl.unlockSuccessControllerProvider))
          .put(
              AuthFlowController.class,
              ((Provider) _ocuk_KeyLoadingComponentImpl.authFlowControllerProvider))
          .put(
              InvalidLicenseController.class,
              ((Provider) _ocuk_KeyLoadingComponentImpl.invalidLicenseControllerProvider))
          .put(
              LegacyRegisterDeviceController.class,
              ((Provider) _ocuk_KeyLoadingComponentImpl.legacyRegisterDeviceControllerProvider))
          .put(
              LegacyRegisterSuccessController.class,
              ((Provider) _ocuk_KeyLoadingComponentImpl.legacyRegisterSuccessControllerProvider))
          .put(
              NoKeychainController.class,
              ((Provider) _ocuk_KeyLoadingComponentImpl.noKeychainControllerProvider))
          .put(
              ReceiveKeyController.class,
              ((Provider) _ocuk_KeyLoadingComponentImpl.receiveKeyControllerProvider))
          .put(
              RegisterDeviceController.class,
              ((Provider) _ocuk_KeyLoadingComponentImpl.registerDeviceControllerProvider))
          .put(
              RegisterFailedController.class,
              ((Provider) _ocuk_KeyLoadingComponentImpl.registerFailedControllerProvider))
          .put(
              RegisterSuccessController.class,
              ((Provider) _ocuk_KeyLoadingComponentImpl.registerSuccessControllerProvider))
          .put(
              RequireAccountInitController.class,
              ((Provider) _ocuk_KeyLoadingComponentImpl.requireAccountInitControllerProvider))
          .put(
              UnauthorizedDeviceController.class,
              ((Provider) _ocuk_KeyLoadingComponentImpl.unauthorizedDeviceControllerProvider))
          .put(ForgetPasswordController.class, ((Provider) forgetPasswordControllerProvider))
          .build();
    }

    @SuppressWarnings("unchecked")
    private void initialize(final Stage ownerParam, final Vault vaultParam) {
      this.provideConfirmedPropertyProvider =
          DoubleCheck.provider(
              new SwitchingProvider<BooleanProperty>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  unlockComponentImpl,
                  _ocuk_KeyLoadingComponentImpl,
                  _ocuf_ForgetPasswordComponentImpl,
                  0));
      this.provideStageProvider =
          DoubleCheck.provider(
              new SwitchingProvider<Stage>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  unlockComponentImpl,
                  _ocuk_KeyLoadingComponentImpl,
                  _ocuf_ForgetPasswordComponentImpl,
                  4));
      this.forgetPasswordControllerProvider =
          DoubleCheck.provider(
              new SwitchingProvider<ForgetPasswordController>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  unlockComponentImpl,
                  _ocuk_KeyLoadingComponentImpl,
                  _ocuf_ForgetPasswordComponentImpl,
                  3));
      this.provideFxmlLoaderFactoryProvider =
          DoubleCheck.provider(
              new SwitchingProvider<FxmlLoaderFactory>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  unlockComponentImpl,
                  _ocuk_KeyLoadingComponentImpl,
                  _ocuf_ForgetPasswordComponentImpl,
                  2));
      this.provideForgetPasswordSceneProvider =
          DoubleCheck.provider(
              new SwitchingProvider<Scene>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  unlockComponentImpl,
                  _ocuk_KeyLoadingComponentImpl,
                  _ocuf_ForgetPasswordComponentImpl,
                  1));
    }

    @Override
    public ReadOnlyBooleanProperty confirmedProperty() {
      return provideConfirmedPropertyProvider.get();
    }

    @Override
    public Lazy<Scene> scene() {
      return DoubleCheck.lazy(provideForgetPasswordSceneProvider);
    }

    @Override
    public Stage window() {
      return provideStageProvider.get();
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final CryptomatorComponentImpl cryptomatorComponentImpl;

      private final FxApplicationComponentImpl fxApplicationComponentImpl;

      private final UnlockComponentImpl unlockComponentImpl;

      private final ocuk_KeyLoadingComponentImpl _ocuk_KeyLoadingComponentImpl;

      private final ocuf_ForgetPasswordComponentImpl _ocuf_ForgetPasswordComponentImpl;

      private final int id;

      SwitchingProvider(
          CryptomatorComponentImpl cryptomatorComponentImpl,
          FxApplicationComponentImpl fxApplicationComponentImpl,
          UnlockComponentImpl unlockComponentImpl,
          ocuk_KeyLoadingComponentImpl _ocuk_KeyLoadingComponentImpl,
          ocuf_ForgetPasswordComponentImpl _ocuf_ForgetPasswordComponentImpl,
          int id) {
        this.cryptomatorComponentImpl = cryptomatorComponentImpl;
        this.fxApplicationComponentImpl = fxApplicationComponentImpl;
        this.unlockComponentImpl = unlockComponentImpl;
        this._ocuk_KeyLoadingComponentImpl = _ocuk_KeyLoadingComponentImpl;
        this._ocuf_ForgetPasswordComponentImpl = _ocuf_ForgetPasswordComponentImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // @org.cryptomator.ui.forgetpassword.ForgetPasswordWindow
                  // javafx.beans.property.BooleanProperty
            return (T)
                ForgetPasswordModule_ProvideConfirmedPropertyFactory.provideConfirmedProperty();

          case 1: // @org.cryptomator.ui.common.FxmlScene(FORGET_PASSWORD) javafx.scene.Scene
            return (T)
                ForgetPasswordModule_ProvideForgetPasswordSceneFactory.provideForgetPasswordScene(
                    _ocuf_ForgetPasswordComponentImpl.provideFxmlLoaderFactoryProvider.get());

          case 2: // @org.cryptomator.ui.forgetpassword.ForgetPasswordWindow
                  // org.cryptomator.ui.common.FxmlLoaderFactory
            return (T)
                ForgetPasswordModule_ProvideFxmlLoaderFactoryFactory.provideFxmlLoaderFactory(
                    _ocuf_ForgetPasswordComponentImpl.mapOfClassOfAndProviderOfFxController(),
                    fxApplicationComponentImpl.defaultSceneFactoryProvider.get(),
                    cryptomatorComponentImpl.provideLocalizationProvider.get());

          case 3: // org.cryptomator.ui.forgetpassword.ForgetPasswordController
            return (T)
                new ForgetPasswordController(
                    _ocuf_ForgetPasswordComponentImpl.provideStageProvider.get(),
                    _ocuf_ForgetPasswordComponentImpl.vault,
                    cryptomatorComponentImpl.keychainManagerProvider.get(),
                    _ocuf_ForgetPasswordComponentImpl.provideConfirmedPropertyProvider.get());

          case 4: // @org.cryptomator.ui.forgetpassword.ForgetPasswordWindow javafx.stage.Stage
            return (T)
                ForgetPasswordModule_ProvideStageFactory.provideStage(
                    fxApplicationComponentImpl.stageFactoryProvider.get(),
                    cryptomatorComponentImpl.provideLocalizationProvider.get(),
                    _ocuf_ForgetPasswordComponentImpl.owner);

          default:
            throw new AssertionError(id);
        }
      }
    }
  }

  private static final class ocuk_KeyLoadingComponentImpl implements KeyLoadingComponent {
    private final Vault vault;

    private final Stage window;

    private final CryptomatorComponentImpl cryptomatorComponentImpl;

    private final FxApplicationComponentImpl fxApplicationComponentImpl;

    private final UnlockComponentImpl unlockComponentImpl;

    private final ocuk_KeyLoadingComponentImpl _ocuk_KeyLoadingComponentImpl = this;

    private Provider<Optional<char[]>> provideStoredPasswordProvider;

    private Provider<MasterkeyFileLoadingStrategy> masterkeyFileLoadingStrategyProvider;

    private Provider<KeyLoadingStrategy> bindMasterkeyFileLoadingStrategyProvider;

    private Provider<String> provideDeviceIdProvider;

    private Provider<HubConfig> provideHubConfigProvider;

    private Provider<AtomicReference<String>> provideBearerTokenRefProvider;

    @SuppressWarnings("rawtypes")
    private Provider provideResultProvider;

    private Provider<FxmlLoaderFactory> provideFxmlLoaderFactoryProvider;

    private Provider<Scene> provideHubReceiveKeySceneProvider;

    private Provider<AuthFlowController> authFlowControllerProvider;

    private Provider<InvalidLicenseController> invalidLicenseControllerProvider;

    private Provider<Scene> provideHubLegacyRegisterSuccessSceneProvider;

    private Provider<Scene> provideHubRegisterFailedSceneProvider;

    private Provider<LegacyRegisterDeviceController> legacyRegisterDeviceControllerProvider;

    private Provider<LegacyRegisterSuccessController> legacyRegisterSuccessControllerProvider;

    private Provider<NoKeychainController> noKeychainControllerProvider;

    private Provider<Scene> provideHubRegisterDeviceSceneProvider;

    private Provider<Scene> provideHubLegacyRegisterDeviceSceneProvider;

    private Provider<Scene> provideHubUnauthorizedDeviceSceneProvider;

    private Provider<Scene> provideRequireAccountInitSceneProvider;

    private Provider<Scene> provideInvalidLicenseSceneProvider;

    private Provider<ReceiveKeyController> receiveKeyControllerProvider;

    private Provider<Scene> provideHubRegisterSuccessSceneProvider;

    private Provider<Scene> provideHubRegisterDeviceAlreadyExistsSceneProvider;

    private Provider<RegisterDeviceController> registerDeviceControllerProvider;

    private Provider<RegisterFailedController> registerFailedControllerProvider;

    private Provider<RegisterSuccessController> registerSuccessControllerProvider;

    private Provider<RequireAccountInitController> requireAccountInitControllerProvider;

    private Provider<UnauthorizedDeviceController> unauthorizedDeviceControllerProvider;

    private Provider<Scene> provideHubAuthFlowSceneProvider;

    private Provider<Scene> provideHubNoKeychainSceneProvider;

    private Provider<String> provideWindowTitleProvider;

    private Provider<HubKeyLoadingStrategy> hubKeyLoadingStrategyProvider;

    private Provider<KeyLoadingStrategy> bindHubKeyLoadingStrategyToHubHttpProvider;

    private Provider<KeyLoadingStrategy> bindHubKeyLoadingStrategyToHubHttpsProvider;

    private Provider<KeyLoadingStrategy> provideKeyLoadingStrategyProvider;

    private ocuk_KeyLoadingComponentImpl(
        CryptomatorComponentImpl cryptomatorComponentImpl,
        FxApplicationComponentImpl fxApplicationComponentImpl,
        UnlockComponentImpl unlockComponentImpl,
        Vault vaultParam,
        Stage windowParam) {
      this.cryptomatorComponentImpl = cryptomatorComponentImpl;
      this.fxApplicationComponentImpl = fxApplicationComponentImpl;
      this.unlockComponentImpl = unlockComponentImpl;
      this.vault = vaultParam;
      this.window = windowParam;
      initialize(vaultParam, windowParam);
    }

    private Map<Class<? extends FxController>, javax.inject.Provider<FxController>>
        mapOfClassOfAndProviderOfFxController() {
      return ImmutableMap
          .<Class<? extends FxController>, javax.inject.Provider<FxController>>
              builderWithExpectedSize(14)
          .put(
              UnlockInvalidMountPointController.class,
              ((Provider) unlockComponentImpl.unlockInvalidMountPointControllerProvider))
          .put(
              UnlockRequiresRestartController.class,
              ((Provider) unlockComponentImpl.unlockRequiresRestartControllerProvider))
          .put(
              UnlockSuccessController.class,
              ((Provider) unlockComponentImpl.unlockSuccessControllerProvider))
          .put(AuthFlowController.class, ((Provider) authFlowControllerProvider))
          .put(InvalidLicenseController.class, ((Provider) invalidLicenseControllerProvider))
          .put(
              LegacyRegisterDeviceController.class,
              ((Provider) legacyRegisterDeviceControllerProvider))
          .put(
              LegacyRegisterSuccessController.class,
              ((Provider) legacyRegisterSuccessControllerProvider))
          .put(NoKeychainController.class, ((Provider) noKeychainControllerProvider))
          .put(ReceiveKeyController.class, ((Provider) receiveKeyControllerProvider))
          .put(RegisterDeviceController.class, ((Provider) registerDeviceControllerProvider))
          .put(RegisterFailedController.class, ((Provider) registerFailedControllerProvider))
          .put(RegisterSuccessController.class, ((Provider) registerSuccessControllerProvider))
          .put(
              RequireAccountInitController.class, ((Provider) requireAccountInitControllerProvider))
          .put(
              UnauthorizedDeviceController.class, ((Provider) unauthorizedDeviceControllerProvider))
          .build();
    }

    private Map<String, javax.inject.Provider<KeyLoadingStrategy>>
        mapOfStringAndProviderOfKeyLoadingStrategy() {
      return ImmutableMap.<String, javax.inject.Provider<KeyLoadingStrategy>>of(
          "masterkeyfile",
          bindMasterkeyFileLoadingStrategyProvider,
          "hub+http",
          bindHubKeyLoadingStrategyToHubHttpProvider,
          "hub+https",
          bindHubKeyLoadingStrategyToHubHttpsProvider);
    }

    @SuppressWarnings("unchecked")
    private void initialize(final Vault vaultParam, final Stage windowParam) {
      this.provideStoredPasswordProvider =
          DoubleCheck.provider(
              new SwitchingProvider<Optional<char[]>>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  unlockComponentImpl,
                  _ocuk_KeyLoadingComponentImpl,
                  2));
      this.masterkeyFileLoadingStrategyProvider =
          new SwitchingProvider<>(
              cryptomatorComponentImpl,
              fxApplicationComponentImpl,
              unlockComponentImpl,
              _ocuk_KeyLoadingComponentImpl,
              1);
      this.bindMasterkeyFileLoadingStrategyProvider =
          DoubleCheck.provider((Provider) masterkeyFileLoadingStrategyProvider);
      this.provideDeviceIdProvider =
          DoubleCheck.provider(
              new SwitchingProvider<String>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  unlockComponentImpl,
                  _ocuk_KeyLoadingComponentImpl,
                  7));
      this.provideHubConfigProvider =
          DoubleCheck.provider(
              new SwitchingProvider<HubConfig>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  unlockComponentImpl,
                  _ocuk_KeyLoadingComponentImpl,
                  8));
      this.provideBearerTokenRefProvider =
          DoubleCheck.provider(
              new SwitchingProvider<AtomicReference<String>>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  unlockComponentImpl,
                  _ocuk_KeyLoadingComponentImpl,
                  9));
      this.provideResultProvider =
          DoubleCheck.provider(
              new SwitchingProvider<CompletableFuture>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  unlockComponentImpl,
                  _ocuk_KeyLoadingComponentImpl,
                  10));
      this.provideFxmlLoaderFactoryProvider = new DelegateFactory<>();
      this.provideHubReceiveKeySceneProvider =
          DoubleCheck.provider(
              new SwitchingProvider<Scene>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  unlockComponentImpl,
                  _ocuk_KeyLoadingComponentImpl,
                  11));
      this.authFlowControllerProvider =
          DoubleCheck.provider(
              new SwitchingProvider<AuthFlowController>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  unlockComponentImpl,
                  _ocuk_KeyLoadingComponentImpl,
                  6));
      this.invalidLicenseControllerProvider =
          new SwitchingProvider<>(
              cryptomatorComponentImpl,
              fxApplicationComponentImpl,
              unlockComponentImpl,
              _ocuk_KeyLoadingComponentImpl,
              12);
      this.provideHubLegacyRegisterSuccessSceneProvider =
          DoubleCheck.provider(
              new SwitchingProvider<Scene>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  unlockComponentImpl,
                  _ocuk_KeyLoadingComponentImpl,
                  14));
      this.provideHubRegisterFailedSceneProvider =
          DoubleCheck.provider(
              new SwitchingProvider<Scene>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  unlockComponentImpl,
                  _ocuk_KeyLoadingComponentImpl,
                  15));
      this.legacyRegisterDeviceControllerProvider =
          DoubleCheck.provider(
              new SwitchingProvider<LegacyRegisterDeviceController>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  unlockComponentImpl,
                  _ocuk_KeyLoadingComponentImpl,
                  13));
      this.legacyRegisterSuccessControllerProvider =
          DoubleCheck.provider(
              new SwitchingProvider<LegacyRegisterSuccessController>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  unlockComponentImpl,
                  _ocuk_KeyLoadingComponentImpl,
                  16));
      this.noKeychainControllerProvider =
          new SwitchingProvider<>(
              cryptomatorComponentImpl,
              fxApplicationComponentImpl,
              unlockComponentImpl,
              _ocuk_KeyLoadingComponentImpl,
              17);
      this.provideHubRegisterDeviceSceneProvider =
          DoubleCheck.provider(
              new SwitchingProvider<Scene>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  unlockComponentImpl,
                  _ocuk_KeyLoadingComponentImpl,
                  19));
      this.provideHubLegacyRegisterDeviceSceneProvider =
          DoubleCheck.provider(
              new SwitchingProvider<Scene>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  unlockComponentImpl,
                  _ocuk_KeyLoadingComponentImpl,
                  20));
      this.provideHubUnauthorizedDeviceSceneProvider =
          DoubleCheck.provider(
              new SwitchingProvider<Scene>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  unlockComponentImpl,
                  _ocuk_KeyLoadingComponentImpl,
                  21));
      this.provideRequireAccountInitSceneProvider =
          DoubleCheck.provider(
              new SwitchingProvider<Scene>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  unlockComponentImpl,
                  _ocuk_KeyLoadingComponentImpl,
                  22));
      this.provideInvalidLicenseSceneProvider =
          DoubleCheck.provider(
              new SwitchingProvider<Scene>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  unlockComponentImpl,
                  _ocuk_KeyLoadingComponentImpl,
                  23));
      this.receiveKeyControllerProvider =
          DoubleCheck.provider(
              new SwitchingProvider<ReceiveKeyController>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  unlockComponentImpl,
                  _ocuk_KeyLoadingComponentImpl,
                  18));
      this.provideHubRegisterSuccessSceneProvider =
          DoubleCheck.provider(
              new SwitchingProvider<Scene>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  unlockComponentImpl,
                  _ocuk_KeyLoadingComponentImpl,
                  25));
      this.provideHubRegisterDeviceAlreadyExistsSceneProvider =
          DoubleCheck.provider(
              new SwitchingProvider<Scene>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  unlockComponentImpl,
                  _ocuk_KeyLoadingComponentImpl,
                  26));
      this.registerDeviceControllerProvider =
          DoubleCheck.provider(
              new SwitchingProvider<RegisterDeviceController>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  unlockComponentImpl,
                  _ocuk_KeyLoadingComponentImpl,
                  24));
      this.registerFailedControllerProvider =
          new SwitchingProvider<>(
              cryptomatorComponentImpl,
              fxApplicationComponentImpl,
              unlockComponentImpl,
              _ocuk_KeyLoadingComponentImpl,
              27);
      this.registerSuccessControllerProvider =
          new SwitchingProvider<>(
              cryptomatorComponentImpl,
              fxApplicationComponentImpl,
              unlockComponentImpl,
              _ocuk_KeyLoadingComponentImpl,
              28);
      this.requireAccountInitControllerProvider =
          DoubleCheck.provider(
              new SwitchingProvider<RequireAccountInitController>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  unlockComponentImpl,
                  _ocuk_KeyLoadingComponentImpl,
                  29));
      this.unauthorizedDeviceControllerProvider =
          DoubleCheck.provider(
              new SwitchingProvider<UnauthorizedDeviceController>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  unlockComponentImpl,
                  _ocuk_KeyLoadingComponentImpl,
                  30));
      DelegateFactory.setDelegate(
          provideFxmlLoaderFactoryProvider,
          DoubleCheck.provider(
              new SwitchingProvider<FxmlLoaderFactory>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  unlockComponentImpl,
                  _ocuk_KeyLoadingComponentImpl,
                  5)));
      this.provideHubAuthFlowSceneProvider =
          DoubleCheck.provider(
              new SwitchingProvider<Scene>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  unlockComponentImpl,
                  _ocuk_KeyLoadingComponentImpl,
                  4));
      this.provideHubNoKeychainSceneProvider =
          DoubleCheck.provider(
              new SwitchingProvider<Scene>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  unlockComponentImpl,
                  _ocuk_KeyLoadingComponentImpl,
                  31));
      this.provideWindowTitleProvider =
          DoubleCheck.provider(
              new SwitchingProvider<String>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  unlockComponentImpl,
                  _ocuk_KeyLoadingComponentImpl,
                  32));
      this.hubKeyLoadingStrategyProvider =
          new SwitchingProvider<>(
              cryptomatorComponentImpl,
              fxApplicationComponentImpl,
              unlockComponentImpl,
              _ocuk_KeyLoadingComponentImpl,
              3);
      this.bindHubKeyLoadingStrategyToHubHttpProvider =
          DoubleCheck.provider((Provider) hubKeyLoadingStrategyProvider);
      this.bindHubKeyLoadingStrategyToHubHttpsProvider =
          DoubleCheck.provider((Provider) hubKeyLoadingStrategyProvider);
      this.provideKeyLoadingStrategyProvider =
          DoubleCheck.provider(
              new SwitchingProvider<KeyLoadingStrategy>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  unlockComponentImpl,
                  _ocuk_KeyLoadingComponentImpl,
                  0));
    }

    @Override
    public KeyLoadingStrategy keyloadingStrategy() {
      return provideKeyLoadingStrategyProvider.get();
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final CryptomatorComponentImpl cryptomatorComponentImpl;

      private final FxApplicationComponentImpl fxApplicationComponentImpl;

      private final UnlockComponentImpl unlockComponentImpl;

      private final ocuk_KeyLoadingComponentImpl _ocuk_KeyLoadingComponentImpl;

      private final int id;

      SwitchingProvider(
          CryptomatorComponentImpl cryptomatorComponentImpl,
          FxApplicationComponentImpl fxApplicationComponentImpl,
          UnlockComponentImpl unlockComponentImpl,
          ocuk_KeyLoadingComponentImpl _ocuk_KeyLoadingComponentImpl,
          int id) {
        this.cryptomatorComponentImpl = cryptomatorComponentImpl;
        this.fxApplicationComponentImpl = fxApplicationComponentImpl;
        this.unlockComponentImpl = unlockComponentImpl;
        this._ocuk_KeyLoadingComponentImpl = _ocuk_KeyLoadingComponentImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // @org.cryptomator.ui.keyloading.KeyLoading
                  // org.cryptomator.ui.keyloading.KeyLoadingStrategy
            return (T)
                KeyLoadingModule_ProvideKeyLoadingStrategyFactory.provideKeyLoadingStrategy(
                    _ocuk_KeyLoadingComponentImpl.vault,
                    _ocuk_KeyLoadingComponentImpl.mapOfStringAndProviderOfKeyLoadingStrategy());

          case 1: // org.cryptomator.ui.keyloading.masterkeyfile.MasterkeyFileLoadingStrategy
            return (T)
                new MasterkeyFileLoadingStrategy(
                    _ocuk_KeyLoadingComponentImpl.vault,
                    cryptomatorComponentImpl.provideMasterkeyFileAccessProvider.get(),
                    _ocuk_KeyLoadingComponentImpl.window,
                    _ocuk_KeyLoadingComponentImpl.provideStoredPasswordProvider.get(),
                    new ocukm_PassphraseEntryComponentBuilder(
                        cryptomatorComponentImpl,
                        fxApplicationComponentImpl,
                        unlockComponentImpl,
                        _ocuk_KeyLoadingComponentImpl),
                    new ocukm_ChooseMasterkeyFileComponentBuilder(
                        cryptomatorComponentImpl,
                        fxApplicationComponentImpl,
                        unlockComponentImpl,
                        _ocuk_KeyLoadingComponentImpl),
                    cryptomatorComponentImpl.keychainManagerProvider.get(),
                    cryptomatorComponentImpl.provideLocalizationProvider.get());

          case 2: // @javax.inject.Named("savedPassword") java.util.Optional<char[]>
            return (T)
                MasterkeyFileLoadingModule_ProvideStoredPasswordFactory.provideStoredPassword(
                    cryptomatorComponentImpl.keychainManagerProvider.get(),
                    _ocuk_KeyLoadingComponentImpl.vault);

          case 3: // org.cryptomator.ui.keyloading.hub.HubKeyLoadingStrategy
            return (T)
                new HubKeyLoadingStrategy(
                    _ocuk_KeyLoadingComponentImpl.window,
                    DoubleCheck.lazy(_ocuk_KeyLoadingComponentImpl.provideHubAuthFlowSceneProvider),
                    DoubleCheck.lazy(
                        _ocuk_KeyLoadingComponentImpl.provideHubNoKeychainSceneProvider),
                    (CompletableFuture) _ocuk_KeyLoadingComponentImpl.provideResultProvider.get(),
                    cryptomatorComponentImpl.deviceKeyProvider.get(),
                    cryptomatorComponentImpl.keychainManagerProvider.get(),
                    _ocuk_KeyLoadingComponentImpl.provideWindowTitleProvider.get());

          case 4: // @org.cryptomator.ui.common.FxmlScene(HUB_AUTH_FLOW) javafx.scene.Scene
            return (T)
                HubKeyLoadingModule_ProvideHubAuthFlowSceneFactory.provideHubAuthFlowScene(
                    _ocuk_KeyLoadingComponentImpl.provideFxmlLoaderFactoryProvider.get());

          case 5: // @org.cryptomator.ui.keyloading.KeyLoading
                  // org.cryptomator.ui.common.FxmlLoaderFactory
            return (T)
                KeyLoadingModule_ProvideFxmlLoaderFactoryFactory.provideFxmlLoaderFactory(
                    _ocuk_KeyLoadingComponentImpl.mapOfClassOfAndProviderOfFxController(),
                    fxApplicationComponentImpl.defaultSceneFactoryProvider.get(),
                    cryptomatorComponentImpl.provideLocalizationProvider.get());

          case 6: // org.cryptomator.ui.keyloading.hub.AuthFlowController
            return (T)
                new AuthFlowController(
                    fxApplicationComponentImpl.fxApplicationProvider.get(),
                    _ocuk_KeyLoadingComponentImpl.window,
                    cryptomatorComponentImpl.provideExecutorServiceProvider.get(),
                    _ocuk_KeyLoadingComponentImpl.provideDeviceIdProvider.get(),
                    _ocuk_KeyLoadingComponentImpl.provideHubConfigProvider.get(),
                    _ocuk_KeyLoadingComponentImpl.provideBearerTokenRefProvider.get(),
                    (CompletableFuture) _ocuk_KeyLoadingComponentImpl.provideResultProvider.get(),
                    DoubleCheck.lazy(
                        _ocuk_KeyLoadingComponentImpl.provideHubReceiveKeySceneProvider));

          case 7: // @javax.inject.Named("deviceId") java.lang.String
            return (T)
                HubKeyLoadingModule_ProvideDeviceIdFactory.provideDeviceId(
                    cryptomatorComponentImpl.deviceKeyProvider.get());

          case 8: // org.cryptomator.ui.keyloading.hub.HubConfig
            return (T)
                HubKeyLoadingModule_ProvideHubConfigFactory.provideHubConfig(
                    _ocuk_KeyLoadingComponentImpl.vault);

          case 9: // @javax.inject.Named("bearerToken")
                  // java.util.concurrent.atomic.AtomicReference<java.lang.String>
            return (T) HubKeyLoadingModule_ProvideBearerTokenRefFactory.provideBearerTokenRef();

          case 10: // java.util.concurrent.CompletableFuture<org.cryptomator.ui.keyloading.hub.ReceivedKey>
            return (T) HubKeyLoadingModule_ProvideResultFactory.provideResult();

          case 11: // @org.cryptomator.ui.common.FxmlScene(HUB_RECEIVE_KEY) javafx.scene.Scene
            return (T)
                HubKeyLoadingModule_ProvideHubReceiveKeySceneFactory.provideHubReceiveKeyScene(
                    _ocuk_KeyLoadingComponentImpl.provideFxmlLoaderFactoryProvider.get());

          case 12: // org.cryptomator.ui.keyloading.hub.InvalidLicenseController
            return (T) new InvalidLicenseController(_ocuk_KeyLoadingComponentImpl.window);

          case 13: // org.cryptomator.ui.keyloading.hub.LegacyRegisterDeviceController
            return (T)
                new LegacyRegisterDeviceController(
                    _ocuk_KeyLoadingComponentImpl.window,
                    cryptomatorComponentImpl.provideExecutorServiceProvider.get(),
                    _ocuk_KeyLoadingComponentImpl.provideHubConfigProvider.get(),
                    _ocuk_KeyLoadingComponentImpl.provideDeviceIdProvider.get(),
                    cryptomatorComponentImpl.deviceKeyProvider.get(),
                    (CompletableFuture) _ocuk_KeyLoadingComponentImpl.provideResultProvider.get(),
                    _ocuk_KeyLoadingComponentImpl.provideBearerTokenRefProvider.get(),
                    DoubleCheck.lazy(
                        _ocuk_KeyLoadingComponentImpl.provideHubLegacyRegisterSuccessSceneProvider),
                    DoubleCheck.lazy(
                        _ocuk_KeyLoadingComponentImpl.provideHubRegisterFailedSceneProvider));

          case 14: // @org.cryptomator.ui.common.FxmlScene(HUB_LEGACY_REGISTER_SUCCESS)
                   // javafx.scene.Scene
            return (T)
                HubKeyLoadingModule_ProvideHubLegacyRegisterSuccessSceneFactory
                    .provideHubLegacyRegisterSuccessScene(
                        _ocuk_KeyLoadingComponentImpl.provideFxmlLoaderFactoryProvider.get());

          case 15: // @org.cryptomator.ui.common.FxmlScene(HUB_REGISTER_FAILED) javafx.scene.Scene
            return (T)
                HubKeyLoadingModule_ProvideHubRegisterFailedSceneFactory
                    .provideHubRegisterFailedScene(
                        _ocuk_KeyLoadingComponentImpl.provideFxmlLoaderFactoryProvider.get());

          case 16: // org.cryptomator.ui.keyloading.hub.LegacyRegisterSuccessController
            return (T) new LegacyRegisterSuccessController(_ocuk_KeyLoadingComponentImpl.window);

          case 17: // org.cryptomator.ui.keyloading.hub.NoKeychainController
            return (T)
                new NoKeychainController(
                    _ocuk_KeyLoadingComponentImpl.window,
                    fxApplicationComponentImpl.fxApplicationWindowsProvider.get());

          case 18: // org.cryptomator.ui.keyloading.hub.ReceiveKeyController
            return (T)
                new ReceiveKeyController(
                    _ocuk_KeyLoadingComponentImpl.vault,
                    cryptomatorComponentImpl.provideExecutorServiceProvider.get(),
                    _ocuk_KeyLoadingComponentImpl.window,
                    _ocuk_KeyLoadingComponentImpl.provideHubConfigProvider.get(),
                    _ocuk_KeyLoadingComponentImpl.provideDeviceIdProvider.get(),
                    _ocuk_KeyLoadingComponentImpl.provideBearerTokenRefProvider.get(),
                    (CompletableFuture) _ocuk_KeyLoadingComponentImpl.provideResultProvider.get(),
                    DoubleCheck.lazy(
                        _ocuk_KeyLoadingComponentImpl.provideHubRegisterDeviceSceneProvider),
                    DoubleCheck.lazy(
                        _ocuk_KeyLoadingComponentImpl.provideHubLegacyRegisterDeviceSceneProvider),
                    DoubleCheck.lazy(
                        _ocuk_KeyLoadingComponentImpl.provideHubUnauthorizedDeviceSceneProvider),
                    DoubleCheck.lazy(
                        _ocuk_KeyLoadingComponentImpl.provideRequireAccountInitSceneProvider),
                    DoubleCheck.lazy(
                        _ocuk_KeyLoadingComponentImpl.provideInvalidLicenseSceneProvider));

          case 19: // @org.cryptomator.ui.common.FxmlScene(HUB_REGISTER_DEVICE) javafx.scene.Scene
            return (T)
                HubKeyLoadingModule_ProvideHubRegisterDeviceSceneFactory
                    .provideHubRegisterDeviceScene(
                        _ocuk_KeyLoadingComponentImpl.provideFxmlLoaderFactoryProvider.get());

          case 20: // @org.cryptomator.ui.common.FxmlScene(HUB_LEGACY_REGISTER_DEVICE)
                   // javafx.scene.Scene
            return (T)
                HubKeyLoadingModule_ProvideHubLegacyRegisterDeviceSceneFactory
                    .provideHubLegacyRegisterDeviceScene(
                        _ocuk_KeyLoadingComponentImpl.provideFxmlLoaderFactoryProvider.get());

          case 21: // @org.cryptomator.ui.common.FxmlScene(HUB_UNAUTHORIZED_DEVICE)
                   // javafx.scene.Scene
            return (T)
                HubKeyLoadingModule_ProvideHubUnauthorizedDeviceSceneFactory
                    .provideHubUnauthorizedDeviceScene(
                        _ocuk_KeyLoadingComponentImpl.provideFxmlLoaderFactoryProvider.get());

          case 22: // @org.cryptomator.ui.common.FxmlScene(HUB_REQUIRE_ACCOUNT_INIT)
                   // javafx.scene.Scene
            return (T)
                HubKeyLoadingModule_ProvideRequireAccountInitSceneFactory
                    .provideRequireAccountInitScene(
                        _ocuk_KeyLoadingComponentImpl.provideFxmlLoaderFactoryProvider.get());

          case 23: // @org.cryptomator.ui.common.FxmlScene(HUB_INVALID_LICENSE) javafx.scene.Scene
            return (T)
                HubKeyLoadingModule_ProvideInvalidLicenseSceneFactory.provideInvalidLicenseScene(
                    _ocuk_KeyLoadingComponentImpl.provideFxmlLoaderFactoryProvider.get());

          case 24: // org.cryptomator.ui.keyloading.hub.RegisterDeviceController
            return (T)
                new RegisterDeviceController(
                    _ocuk_KeyLoadingComponentImpl.window,
                    cryptomatorComponentImpl.provideExecutorServiceProvider.get(),
                    _ocuk_KeyLoadingComponentImpl.provideHubConfigProvider.get(),
                    _ocuk_KeyLoadingComponentImpl.provideDeviceIdProvider.get(),
                    cryptomatorComponentImpl.deviceKeyProvider.get(),
                    (CompletableFuture) _ocuk_KeyLoadingComponentImpl.provideResultProvider.get(),
                    _ocuk_KeyLoadingComponentImpl.provideBearerTokenRefProvider.get(),
                    DoubleCheck.lazy(
                        _ocuk_KeyLoadingComponentImpl.provideHubRegisterSuccessSceneProvider),
                    DoubleCheck.lazy(
                        _ocuk_KeyLoadingComponentImpl.provideHubRegisterFailedSceneProvider),
                    DoubleCheck.lazy(
                        _ocuk_KeyLoadingComponentImpl
                            .provideHubRegisterDeviceAlreadyExistsSceneProvider));

          case 25: // @org.cryptomator.ui.common.FxmlScene(HUB_REGISTER_SUCCESS) javafx.scene.Scene
            return (T)
                HubKeyLoadingModule_ProvideHubRegisterSuccessSceneFactory
                    .provideHubRegisterSuccessScene(
                        _ocuk_KeyLoadingComponentImpl.provideFxmlLoaderFactoryProvider.get());

          case 26: // @org.cryptomator.ui.common.FxmlScene(HUB_REGISTER_DEVICE_ALREADY_EXISTS)
                   // javafx.scene.Scene
            return (T)
                HubKeyLoadingModule_ProvideHubRegisterDeviceAlreadyExistsSceneFactory
                    .provideHubRegisterDeviceAlreadyExistsScene(
                        _ocuk_KeyLoadingComponentImpl.provideFxmlLoaderFactoryProvider.get());

          case 27: // org.cryptomator.ui.keyloading.hub.RegisterFailedController
            return (T)
                new RegisterFailedController(
                    _ocuk_KeyLoadingComponentImpl.window,
                    (CompletableFuture) _ocuk_KeyLoadingComponentImpl.provideResultProvider.get());

          case 28: // org.cryptomator.ui.keyloading.hub.RegisterSuccessController
            return (T)
                new RegisterSuccessController(
                    _ocuk_KeyLoadingComponentImpl.window,
                    (CompletableFuture) _ocuk_KeyLoadingComponentImpl.provideResultProvider.get(),
                    DoubleCheck.lazy(
                        _ocuk_KeyLoadingComponentImpl.provideHubReceiveKeySceneProvider),
                    _ocuk_KeyLoadingComponentImpl.receiveKeyControllerProvider.get());

          case 29: // org.cryptomator.ui.keyloading.hub.RequireAccountInitController
            return (T)
                new RequireAccountInitController(
                    fxApplicationComponentImpl.fxApplicationProvider.get(),
                    _ocuk_KeyLoadingComponentImpl.provideHubConfigProvider.get(),
                    _ocuk_KeyLoadingComponentImpl.window,
                    (CompletableFuture) _ocuk_KeyLoadingComponentImpl.provideResultProvider.get());

          case 30: // org.cryptomator.ui.keyloading.hub.UnauthorizedDeviceController
            return (T)
                new UnauthorizedDeviceController(
                    _ocuk_KeyLoadingComponentImpl.window,
                    (CompletableFuture) _ocuk_KeyLoadingComponentImpl.provideResultProvider.get());

          case 31: // @org.cryptomator.ui.common.FxmlScene(HUB_NO_KEYCHAIN) javafx.scene.Scene
            return (T)
                HubKeyLoadingModule_ProvideHubNoKeychainSceneFactory.provideHubNoKeychainScene(
                    _ocuk_KeyLoadingComponentImpl.provideFxmlLoaderFactoryProvider.get());

          case 32: // @javax.inject.Named("windowTitle") java.lang.String
            return (T)
                HubKeyLoadingModule_ProvideWindowTitleFactory.provideWindowTitle(
                    _ocuk_KeyLoadingComponentImpl.vault,
                    cryptomatorComponentImpl.provideLocalizationProvider.get());

          default:
            throw new AssertionError(id);
        }
      }
    }
  }

  private static final class UnlockComponentImpl implements UnlockComponent {
    private final Vault arg0;

    private final Stage arg1;

    private final CryptomatorComponentImpl cryptomatorComponentImpl;

    private final FxApplicationComponentImpl fxApplicationComponentImpl;

    private final UnlockComponentImpl unlockComponentImpl = this;

    private Provider<Stage> provideStageProvider;

    private Provider<ObjectProperty<IllegalMountPointException>> illegalMountPointExceptionProvider;

    private Provider<UnlockInvalidMountPointController> unlockInvalidMountPointControllerProvider;

    private Provider<UnlockRequiresRestartController> unlockRequiresRestartControllerProvider;

    private Provider<UnlockSuccessController> unlockSuccessControllerProvider;

    private Provider<FxmlLoaderFactory> provideFxmlLoaderFactoryProvider;

    private Provider<Scene> provideUnlockSuccessSceneProvider;

    private Provider<Scene> provideInvalidMountPointSceneProvider;

    private Provider<Scene> provideRestartRequiredSceneProvider;

    private Provider<KeyLoadingStrategy> provideKeyLoadingStrategyProvider;

    private Provider<UnlockWorkflow> unlockWorkflowProvider;

    private UnlockComponentImpl(
        CryptomatorComponentImpl cryptomatorComponentImpl,
        FxApplicationComponentImpl fxApplicationComponentImpl,
        Vault arg0Param,
        Stage arg1Param) {
      this.cryptomatorComponentImpl = cryptomatorComponentImpl;
      this.fxApplicationComponentImpl = fxApplicationComponentImpl;
      this.arg0 = arg0Param;
      this.arg1 = arg1Param;
      initialize(arg0Param, arg1Param);
    }

    private Map<Class<? extends FxController>, javax.inject.Provider<FxController>>
        mapOfClassOfAndProviderOfFxController() {
      return ImmutableMap.<Class<? extends FxController>, javax.inject.Provider<FxController>>of(
          UnlockInvalidMountPointController.class,
          ((Provider) unlockInvalidMountPointControllerProvider),
          UnlockRequiresRestartController.class,
          ((Provider) unlockRequiresRestartControllerProvider),
          UnlockSuccessController.class,
          ((Provider) unlockSuccessControllerProvider));
    }

    @SuppressWarnings("unchecked")
    private void initialize(final Vault arg0Param, final Stage arg1Param) {
      this.provideStageProvider =
          DoubleCheck.provider(
              new SwitchingProvider<Stage>(
                  cryptomatorComponentImpl, fxApplicationComponentImpl, unlockComponentImpl, 1));
      this.illegalMountPointExceptionProvider =
          DoubleCheck.provider(
              new SwitchingProvider<ObjectProperty<IllegalMountPointException>>(
                  cryptomatorComponentImpl, fxApplicationComponentImpl, unlockComponentImpl, 5));
      this.unlockInvalidMountPointControllerProvider =
          DoubleCheck.provider(
              new SwitchingProvider<UnlockInvalidMountPointController>(
                  cryptomatorComponentImpl, fxApplicationComponentImpl, unlockComponentImpl, 4));
      this.unlockRequiresRestartControllerProvider =
          DoubleCheck.provider(
              new SwitchingProvider<UnlockRequiresRestartController>(
                  cryptomatorComponentImpl, fxApplicationComponentImpl, unlockComponentImpl, 6));
      this.unlockSuccessControllerProvider =
          DoubleCheck.provider(
              new SwitchingProvider<UnlockSuccessController>(
                  cryptomatorComponentImpl, fxApplicationComponentImpl, unlockComponentImpl, 7));
      this.provideFxmlLoaderFactoryProvider =
          DoubleCheck.provider(
              new SwitchingProvider<FxmlLoaderFactory>(
                  cryptomatorComponentImpl, fxApplicationComponentImpl, unlockComponentImpl, 3));
      this.provideUnlockSuccessSceneProvider =
          DoubleCheck.provider(
              new SwitchingProvider<Scene>(
                  cryptomatorComponentImpl, fxApplicationComponentImpl, unlockComponentImpl, 2));
      this.provideInvalidMountPointSceneProvider =
          DoubleCheck.provider(
              new SwitchingProvider<Scene>(
                  cryptomatorComponentImpl, fxApplicationComponentImpl, unlockComponentImpl, 8));
      this.provideRestartRequiredSceneProvider =
          DoubleCheck.provider(
              new SwitchingProvider<Scene>(
                  cryptomatorComponentImpl, fxApplicationComponentImpl, unlockComponentImpl, 9));
      this.provideKeyLoadingStrategyProvider =
          DoubleCheck.provider(
              new SwitchingProvider<KeyLoadingStrategy>(
                  cryptomatorComponentImpl, fxApplicationComponentImpl, unlockComponentImpl, 10));
      this.unlockWorkflowProvider =
          DoubleCheck.provider(
              new SwitchingProvider<UnlockWorkflow>(
                  cryptomatorComponentImpl, fxApplicationComponentImpl, unlockComponentImpl, 0));
    }

    @Override
    public UnlockWorkflow unlockWorkflow() {
      return unlockWorkflowProvider.get();
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final CryptomatorComponentImpl cryptomatorComponentImpl;

      private final FxApplicationComponentImpl fxApplicationComponentImpl;

      private final UnlockComponentImpl unlockComponentImpl;

      private final int id;

      SwitchingProvider(
          CryptomatorComponentImpl cryptomatorComponentImpl,
          FxApplicationComponentImpl fxApplicationComponentImpl,
          UnlockComponentImpl unlockComponentImpl,
          int id) {
        this.cryptomatorComponentImpl = cryptomatorComponentImpl;
        this.fxApplicationComponentImpl = fxApplicationComponentImpl;
        this.unlockComponentImpl = unlockComponentImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // org.cryptomator.ui.unlock.UnlockWorkflow
            return (T)
                UnlockWorkflow_Factory.newInstance(
                    fxApplicationComponentImpl.primaryStage,
                    unlockComponentImpl.provideStageProvider.get(),
                    unlockComponentImpl.arg0,
                    fxApplicationComponentImpl.vaultServiceProvider.get(),
                    DoubleCheck.lazy(unlockComponentImpl.provideUnlockSuccessSceneProvider),
                    DoubleCheck.lazy(unlockComponentImpl.provideInvalidMountPointSceneProvider),
                    DoubleCheck.lazy(unlockComponentImpl.provideRestartRequiredSceneProvider),
                    fxApplicationComponentImpl.fxApplicationWindowsProvider.get(),
                    unlockComponentImpl.provideKeyLoadingStrategyProvider.get(),
                    unlockComponentImpl.illegalMountPointExceptionProvider.get());

          case 1: // @org.cryptomator.ui.unlock.UnlockWindow javafx.stage.Stage
            return (T)
                UnlockModule_ProvideStageFactory.provideStage(
                    fxApplicationComponentImpl.stageFactoryProvider.get(),
                    unlockComponentImpl.arg0,
                    unlockComponentImpl.arg1);

          case 2: // @org.cryptomator.ui.common.FxmlScene(UNLOCK_SUCCESS) javafx.scene.Scene
            return (T)
                UnlockModule_ProvideUnlockSuccessSceneFactory.provideUnlockSuccessScene(
                    unlockComponentImpl.provideFxmlLoaderFactoryProvider.get());

          case 3: // @org.cryptomator.ui.unlock.UnlockWindow
                  // org.cryptomator.ui.common.FxmlLoaderFactory
            return (T)
                UnlockModule_ProvideFxmlLoaderFactoryFactory.provideFxmlLoaderFactory(
                    unlockComponentImpl.mapOfClassOfAndProviderOfFxController(),
                    fxApplicationComponentImpl.defaultSceneFactoryProvider.get(),
                    cryptomatorComponentImpl.provideLocalizationProvider.get());

          case 4: // org.cryptomator.ui.unlock.UnlockInvalidMountPointController
            return (T)
                UnlockInvalidMountPointController_Factory.newInstance(
                    unlockComponentImpl.provideStageProvider.get(),
                    unlockComponentImpl.arg0,
                    unlockComponentImpl.illegalMountPointExceptionProvider.get(),
                    fxApplicationComponentImpl.fxApplicationWindowsProvider.get(),
                    cryptomatorComponentImpl.provideLocalizationProvider.get());

          case 5: // @org.cryptomator.ui.unlock.UnlockWindow
                  // javafx.beans.property.ObjectProperty<org.cryptomator.common.mount.IllegalMountPointException>
            return (T) UnlockModule_IllegalMountPointExceptionFactory.illegalMountPointException();

          case 6: // org.cryptomator.ui.unlock.UnlockRequiresRestartController
            return (T)
                UnlockRequiresRestartController_Factory.newInstance(
                    unlockComponentImpl.provideStageProvider.get(),
                    cryptomatorComponentImpl.provideLocalizationProvider.get(),
                    fxApplicationComponentImpl.fxApplicationWindowsProvider.get(),
                    unlockComponentImpl.arg0);

          case 7: // org.cryptomator.ui.unlock.UnlockSuccessController
            return (T)
                new UnlockSuccessController(
                    unlockComponentImpl.provideStageProvider.get(),
                    unlockComponentImpl.arg0,
                    cryptomatorComponentImpl.provideExecutorServiceProvider.get(),
                    fxApplicationComponentImpl.vaultServiceProvider.get());

          case 8: // @org.cryptomator.ui.common.FxmlScene(UNLOCK_INVALID_MOUNT_POINT)
                  // javafx.scene.Scene
            return (T)
                UnlockModule_ProvideInvalidMountPointSceneFactory.provideInvalidMountPointScene(
                    unlockComponentImpl.provideFxmlLoaderFactoryProvider.get());

          case 9: // @org.cryptomator.ui.common.FxmlScene(UNLOCK_REQUIRES_RESTART)
                  // javafx.scene.Scene
            return (T)
                UnlockModule_ProvideRestartRequiredSceneFactory.provideRestartRequiredScene(
                    unlockComponentImpl.provideFxmlLoaderFactoryProvider.get());

          case 10: // @org.cryptomator.ui.unlock.UnlockWindow
                   // org.cryptomator.ui.keyloading.KeyLoadingStrategy
            return (T)
                UnlockModule_ProvideKeyLoadingStrategyFactory.provideKeyLoadingStrategy(
                    new ocuk_KeyLoadingComponentBuilder(
                        cryptomatorComponentImpl, fxApplicationComponentImpl, unlockComponentImpl),
                    unlockComponentImpl.arg0,
                    unlockComponentImpl.provideStageProvider.get());

          default:
            throw new AssertionError(id);
        }
      }
    }
  }

  private static final class UpdateReminderComponentImpl implements UpdateReminderComponent {
    private final CryptomatorComponentImpl cryptomatorComponentImpl;

    private final FxApplicationComponentImpl fxApplicationComponentImpl;

    private final UpdateReminderComponentImpl updateReminderComponentImpl = this;

    private Provider<Stage> provideStageProvider;

    private Provider<UpdateReminderController> updateReminderControllerProvider;

    private Provider<FxmlLoaderFactory> provideFxmlLoaderFactoryProvider;

    private Provider<Scene> provideUpdateReminderSceneProvider;

    private UpdateReminderComponentImpl(
        CryptomatorComponentImpl cryptomatorComponentImpl,
        FxApplicationComponentImpl fxApplicationComponentImpl) {
      this.cryptomatorComponentImpl = cryptomatorComponentImpl;
      this.fxApplicationComponentImpl = fxApplicationComponentImpl;

      initialize();
    }

    private Map<Class<? extends FxController>, javax.inject.Provider<FxController>>
        mapOfClassOfAndProviderOfFxController() {
      return ImmutableMap.<Class<? extends FxController>, javax.inject.Provider<FxController>>of(
          UpdateReminderController.class, ((Provider) updateReminderControllerProvider));
    }

    @SuppressWarnings("unchecked")
    private void initialize() {
      this.provideStageProvider =
          DoubleCheck.provider(
              new SwitchingProvider<Stage>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  updateReminderComponentImpl,
                  3));
      this.updateReminderControllerProvider =
          DoubleCheck.provider(
              new SwitchingProvider<UpdateReminderController>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  updateReminderComponentImpl,
                  2));
      this.provideFxmlLoaderFactoryProvider =
          DoubleCheck.provider(
              new SwitchingProvider<FxmlLoaderFactory>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  updateReminderComponentImpl,
                  1));
      this.provideUpdateReminderSceneProvider =
          DoubleCheck.provider(
              new SwitchingProvider<Scene>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  updateReminderComponentImpl,
                  0));
    }

    @Override
    public Settings settings() {
      return cryptomatorComponentImpl.provideSettingsProvider.get();
    }

    @Override
    public Lazy<Scene> updateReminderScene() {
      return DoubleCheck.lazy(provideUpdateReminderSceneProvider);
    }

    @Override
    public Stage window() {
      return provideStageProvider.get();
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final CryptomatorComponentImpl cryptomatorComponentImpl;

      private final FxApplicationComponentImpl fxApplicationComponentImpl;

      private final UpdateReminderComponentImpl updateReminderComponentImpl;

      private final int id;

      SwitchingProvider(
          CryptomatorComponentImpl cryptomatorComponentImpl,
          FxApplicationComponentImpl fxApplicationComponentImpl,
          UpdateReminderComponentImpl updateReminderComponentImpl,
          int id) {
        this.cryptomatorComponentImpl = cryptomatorComponentImpl;
        this.fxApplicationComponentImpl = fxApplicationComponentImpl;
        this.updateReminderComponentImpl = updateReminderComponentImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // @org.cryptomator.ui.common.FxmlScene(UPDATE_REMINDER) javafx.scene.Scene
            return (T)
                UpdateReminderModule_ProvideUpdateReminderSceneFactory.provideUpdateReminderScene(
                    updateReminderComponentImpl.provideFxmlLoaderFactoryProvider.get());

          case 1: // @org.cryptomator.ui.updatereminder.UpdateReminderWindow
                  // org.cryptomator.ui.common.FxmlLoaderFactory
            return (T)
                UpdateReminderModule_ProvideFxmlLoaderFactoryFactory.provideFxmlLoaderFactory(
                    updateReminderComponentImpl.mapOfClassOfAndProviderOfFxController(),
                    fxApplicationComponentImpl.defaultSceneFactoryProvider.get(),
                    cryptomatorComponentImpl.provideLocalizationProvider.get());

          case 2: // org.cryptomator.ui.updatereminder.UpdateReminderController
            return (T)
                UpdateReminderController_Factory.newInstance(
                    updateReminderComponentImpl.provideStageProvider.get(),
                    cryptomatorComponentImpl.provideSettingsProvider.get(),
                    fxApplicationComponentImpl.updateCheckerProvider.get());

          case 3: // @org.cryptomator.ui.updatereminder.UpdateReminderWindow javafx.stage.Stage
            return (T)
                UpdateReminderModule_ProvideStageFactory.provideStage(
                    fxApplicationComponentImpl.stageFactoryProvider.get(),
                    cryptomatorComponentImpl.provideLocalizationProvider.get());

          default:
            throw new AssertionError(id);
        }
      }
    }
  }

  private static final class DokanySupportEndComponentImpl implements DokanySupportEndComponent {
    private final CryptomatorComponentImpl cryptomatorComponentImpl;

    private final FxApplicationComponentImpl fxApplicationComponentImpl;

    private final DokanySupportEndComponentImpl dokanySupportEndComponentImpl = this;

    private Provider<Stage> provideStageProvider;

    private Provider<DokanySupportEndController> dokanySupportEndControllerProvider;

    private Provider<FxmlLoaderFactory> provideFxmlLoaderFactoryProvider;

    private Provider<Scene> provideDokanySupportEndSceneProvider;

    private DokanySupportEndComponentImpl(
        CryptomatorComponentImpl cryptomatorComponentImpl,
        FxApplicationComponentImpl fxApplicationComponentImpl) {
      this.cryptomatorComponentImpl = cryptomatorComponentImpl;
      this.fxApplicationComponentImpl = fxApplicationComponentImpl;

      initialize();
    }

    private Map<Class<? extends FxController>, javax.inject.Provider<FxController>>
        mapOfClassOfAndProviderOfFxController() {
      return ImmutableMap.<Class<? extends FxController>, javax.inject.Provider<FxController>>of(
          DokanySupportEndController.class, ((Provider) dokanySupportEndControllerProvider));
    }

    @SuppressWarnings("unchecked")
    private void initialize() {
      this.provideStageProvider =
          DoubleCheck.provider(
              new SwitchingProvider<Stage>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  dokanySupportEndComponentImpl,
                  3));
      this.dokanySupportEndControllerProvider =
          DoubleCheck.provider(
              new SwitchingProvider<DokanySupportEndController>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  dokanySupportEndComponentImpl,
                  2));
      this.provideFxmlLoaderFactoryProvider =
          DoubleCheck.provider(
              new SwitchingProvider<FxmlLoaderFactory>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  dokanySupportEndComponentImpl,
                  1));
      this.provideDokanySupportEndSceneProvider =
          DoubleCheck.provider(
              new SwitchingProvider<Scene>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  dokanySupportEndComponentImpl,
                  0));
    }

    @Override
    public Lazy<Scene> dokanySupportEndScene() {
      return DoubleCheck.lazy(provideDokanySupportEndSceneProvider);
    }

    @Override
    public Stage window() {
      return provideStageProvider.get();
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final CryptomatorComponentImpl cryptomatorComponentImpl;

      private final FxApplicationComponentImpl fxApplicationComponentImpl;

      private final DokanySupportEndComponentImpl dokanySupportEndComponentImpl;

      private final int id;

      SwitchingProvider(
          CryptomatorComponentImpl cryptomatorComponentImpl,
          FxApplicationComponentImpl fxApplicationComponentImpl,
          DokanySupportEndComponentImpl dokanySupportEndComponentImpl,
          int id) {
        this.cryptomatorComponentImpl = cryptomatorComponentImpl;
        this.fxApplicationComponentImpl = fxApplicationComponentImpl;
        this.dokanySupportEndComponentImpl = dokanySupportEndComponentImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // @org.cryptomator.ui.common.FxmlScene(DOKANY_SUPPORT_END) javafx.scene.Scene
            return (T)
                DokanySupportEndModule_ProvideDokanySupportEndSceneFactory
                    .provideDokanySupportEndScene(
                        dokanySupportEndComponentImpl.provideFxmlLoaderFactoryProvider.get());

          case 1: // @org.cryptomator.ui.dokanysupportend.DokanySupportEndWindow
                  // org.cryptomator.ui.common.FxmlLoaderFactory
            return (T)
                DokanySupportEndModule_ProvideFxmlLoaderFactoryFactory.provideFxmlLoaderFactory(
                    dokanySupportEndComponentImpl.mapOfClassOfAndProviderOfFxController(),
                    fxApplicationComponentImpl.defaultSceneFactoryProvider.get(),
                    cryptomatorComponentImpl.provideLocalizationProvider.get());

          case 2: // org.cryptomator.ui.dokanysupportend.DokanySupportEndController
            return (T)
                DokanySupportEndController_Factory.newInstance(
                    dokanySupportEndComponentImpl.provideStageProvider.get(),
                    fxApplicationComponentImpl.fxApplicationWindowsProvider.get());

          case 3: // @org.cryptomator.ui.dokanysupportend.DokanySupportEndWindow javafx.stage.Stage
            return (T)
                DokanySupportEndModule_ProvideStageFactory.provideStage(
                    fxApplicationComponentImpl.stageFactoryProvider.get(),
                    cryptomatorComponentImpl.provideLocalizationProvider.get());

          default:
            throw new AssertionError(id);
        }
      }
    }
  }

  private static final class LockComponentImpl implements LockComponent {
    private final Vault arg0;

    private final Stage arg1;

    private final CryptomatorComponentImpl cryptomatorComponentImpl;

    private final FxApplicationComponentImpl fxApplicationComponentImpl;

    private final LockComponentImpl lockComponentImpl = this;

    private Provider<Stage> provideWindowProvider;

    private Provider<AtomicReference<CompletableFuture<Boolean>>>
        provideForceRetryDecisionRefProvider;

    private Provider<LockFailedController> lockFailedControllerProvider;

    private Provider<LockForcedController> lockForcedControllerProvider;

    private Provider<FxmlLoaderFactory> provideFxmlLoaderFactoryProvider;

    private Provider<Scene> provideForceLockSceneProvider;

    private Provider<Scene> provideLockFailedSceneProvider;

    private LockComponentImpl(
        CryptomatorComponentImpl cryptomatorComponentImpl,
        FxApplicationComponentImpl fxApplicationComponentImpl,
        Vault arg0Param,
        Stage arg1Param) {
      this.cryptomatorComponentImpl = cryptomatorComponentImpl;
      this.fxApplicationComponentImpl = fxApplicationComponentImpl;
      this.arg0 = arg0Param;
      this.arg1 = arg1Param;
      initialize(arg0Param, arg1Param);
    }

    private Map<Class<? extends FxController>, javax.inject.Provider<FxController>>
        mapOfClassOfAndProviderOfFxController() {
      return ImmutableMap.<Class<? extends FxController>, javax.inject.Provider<FxController>>of(
          LockFailedController.class,
          ((Provider) lockFailedControllerProvider),
          LockForcedController.class,
          ((Provider) lockForcedControllerProvider));
    }

    @SuppressWarnings("unchecked")
    private void initialize(final Vault arg0Param, final Stage arg1Param) {
      this.provideWindowProvider =
          DoubleCheck.provider(
              new SwitchingProvider<Stage>(
                  cryptomatorComponentImpl, fxApplicationComponentImpl, lockComponentImpl, 0));
      this.provideForceRetryDecisionRefProvider =
          DoubleCheck.provider(
              new SwitchingProvider<AtomicReference<CompletableFuture<Boolean>>>(
                  cryptomatorComponentImpl, fxApplicationComponentImpl, lockComponentImpl, 1));
      this.lockFailedControllerProvider =
          DoubleCheck.provider(
              new SwitchingProvider<LockFailedController>(
                  cryptomatorComponentImpl, fxApplicationComponentImpl, lockComponentImpl, 4));
      this.lockForcedControllerProvider =
          DoubleCheck.provider(
              new SwitchingProvider<LockForcedController>(
                  cryptomatorComponentImpl, fxApplicationComponentImpl, lockComponentImpl, 5));
      this.provideFxmlLoaderFactoryProvider =
          DoubleCheck.provider(
              new SwitchingProvider<FxmlLoaderFactory>(
                  cryptomatorComponentImpl, fxApplicationComponentImpl, lockComponentImpl, 3));
      this.provideForceLockSceneProvider =
          DoubleCheck.provider(
              new SwitchingProvider<Scene>(
                  cryptomatorComponentImpl, fxApplicationComponentImpl, lockComponentImpl, 2));
      this.provideLockFailedSceneProvider =
          DoubleCheck.provider(
              new SwitchingProvider<Scene>(
                  cryptomatorComponentImpl, fxApplicationComponentImpl, lockComponentImpl, 6));
    }

    @Override
    public ExecutorService defaultExecutorService() {
      return cryptomatorComponentImpl.provideExecutorServiceProvider.get();
    }

    @Override
    public LockWorkflow lockWorkflow() {
      return new LockWorkflow(
          provideWindowProvider.get(),
          arg0,
          provideForceRetryDecisionRefProvider.get(),
          DoubleCheck.lazy(provideForceLockSceneProvider),
          DoubleCheck.lazy(provideLockFailedSceneProvider),
          fxApplicationComponentImpl.fxApplicationWindowsProvider.get());
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final CryptomatorComponentImpl cryptomatorComponentImpl;

      private final FxApplicationComponentImpl fxApplicationComponentImpl;

      private final LockComponentImpl lockComponentImpl;

      private final int id;

      SwitchingProvider(
          CryptomatorComponentImpl cryptomatorComponentImpl,
          FxApplicationComponentImpl fxApplicationComponentImpl,
          LockComponentImpl lockComponentImpl,
          int id) {
        this.cryptomatorComponentImpl = cryptomatorComponentImpl;
        this.fxApplicationComponentImpl = fxApplicationComponentImpl;
        this.lockComponentImpl = lockComponentImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // @org.cryptomator.ui.lock.LockWindow javafx.stage.Stage
            return (T)
                LockModule_ProvideWindowFactory.provideWindow(
                    fxApplicationComponentImpl.stageFactoryProvider.get(),
                    lockComponentImpl.arg0,
                    lockComponentImpl.arg1);

          case 1: // java.util.concurrent.atomic.AtomicReference<java.util.concurrent.CompletableFuture<java.lang.Boolean>>
            return (T)
                LockModule_ProvideForceRetryDecisionRefFactory.provideForceRetryDecisionRef();

          case 2: // @org.cryptomator.ui.common.FxmlScene(LOCK_FORCED) javafx.scene.Scene
            return (T)
                LockModule_ProvideForceLockSceneFactory.provideForceLockScene(
                    lockComponentImpl.provideFxmlLoaderFactoryProvider.get());

          case 3: // @org.cryptomator.ui.lock.LockWindow org.cryptomator.ui.common.FxmlLoaderFactory
            return (T)
                LockModule_ProvideFxmlLoaderFactoryFactory.provideFxmlLoaderFactory(
                    lockComponentImpl.mapOfClassOfAndProviderOfFxController(),
                    fxApplicationComponentImpl.defaultSceneFactoryProvider.get(),
                    cryptomatorComponentImpl.provideLocalizationProvider.get());

          case 4: // org.cryptomator.ui.lock.LockFailedController
            return (T)
                new LockFailedController(
                    lockComponentImpl.provideWindowProvider.get(), lockComponentImpl.arg0);

          case 5: // org.cryptomator.ui.lock.LockForcedController
            return (T)
                new LockForcedController(
                    lockComponentImpl.provideWindowProvider.get(),
                    lockComponentImpl.arg0,
                    lockComponentImpl.provideForceRetryDecisionRefProvider.get());

          case 6: // @org.cryptomator.ui.common.FxmlScene(LOCK_FAILED) javafx.scene.Scene
            return (T)
                LockModule_ProvideLockFailedSceneFactory.provideLockFailedScene(
                    lockComponentImpl.provideFxmlLoaderFactoryProvider.get());

          default:
            throw new AssertionError(id);
        }
      }
    }
  }

  private static final class ErrorComponentImpl implements ErrorComponent {
    private final Throwable arg0;

    private final Scene arg2;

    private final Stage arg1;

    private final CryptomatorComponentImpl cryptomatorComponentImpl;

    private final FxApplicationComponentImpl fxApplicationComponentImpl;

    private final ErrorComponentImpl errorComponentImpl = this;

    private Provider<ErrorController> errorControllerProvider;

    private ErrorComponentImpl(
        CryptomatorComponentImpl cryptomatorComponentImpl,
        FxApplicationComponentImpl fxApplicationComponentImpl,
        Throwable arg0Param,
        Stage arg1Param,
        Scene arg2Param) {
      this.cryptomatorComponentImpl = cryptomatorComponentImpl;
      this.fxApplicationComponentImpl = fxApplicationComponentImpl;
      this.arg0 = arg0Param;
      this.arg2 = arg2Param;
      this.arg1 = arg1Param;
      initialize(arg0Param, arg1Param, arg2Param);
    }

    private String namedString() {
      return ErrorModule_ProvideStackTraceFactory.provideStackTrace(arg0);
    }

    private ErrorCode errorCode() {
      return ErrorModule_ProvideErrorCodeFactory.provideErrorCode(arg0);
    }

    private Map<Class<? extends FxController>, javax.inject.Provider<FxController>>
        mapOfClassOfAndProviderOfFxController() {
      return ImmutableMap.<Class<? extends FxController>, javax.inject.Provider<FxController>>of(
          ErrorController.class, ((Provider) errorControllerProvider));
    }

    private FxmlLoaderFactory fxmlLoaderFactory() {
      return ErrorModule_ProvideFxmlLoaderFactoryFactory.provideFxmlLoaderFactory(
          mapOfClassOfAndProviderOfFxController(),
          fxApplicationComponentImpl.defaultSceneFactoryProvider.get(),
          cryptomatorComponentImpl.provideLocalizationProvider.get());
    }

    @SuppressWarnings("unchecked")
    private void initialize(
        final Throwable arg0Param, final Stage arg1Param, final Scene arg2Param) {
      this.errorControllerProvider =
          new SwitchingProvider<>(
              cryptomatorComponentImpl, fxApplicationComponentImpl, errorComponentImpl, 0);
    }

    @Override
    public Scene scene() {
      return ErrorModule_ProvideErrorSceneFactory.provideErrorScene(fxmlLoaderFactory());
    }

    @Override
    public Stage window() {
      return arg1;
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final CryptomatorComponentImpl cryptomatorComponentImpl;

      private final FxApplicationComponentImpl fxApplicationComponentImpl;

      private final ErrorComponentImpl errorComponentImpl;

      private final int id;

      SwitchingProvider(
          CryptomatorComponentImpl cryptomatorComponentImpl,
          FxApplicationComponentImpl fxApplicationComponentImpl,
          ErrorComponentImpl errorComponentImpl,
          int id) {
        this.cryptomatorComponentImpl = cryptomatorComponentImpl;
        this.fxApplicationComponentImpl = fxApplicationComponentImpl;
        this.errorComponentImpl = errorComponentImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // org.cryptomator.ui.error.ErrorController
            return (T)
                ErrorController_Factory.newInstance(
                    fxApplicationComponentImpl.fxApplicationProvider.get(),
                    errorComponentImpl.namedString(),
                    errorComponentImpl.errorCode(),
                    errorComponentImpl.arg2,
                    errorComponentImpl.arg1,
                    cryptomatorComponentImpl.provideEnvironmentProvider.get(),
                    cryptomatorComponentImpl.provideExecutorServiceProvider.get());

          default:
            throw new AssertionError(id);
        }
      }
    }
  }

  private static final class ConvertVaultComponentImpl implements ConvertVaultComponent {
    private final Vault arg0;

    private final Stage arg1;

    private final CryptomatorComponentImpl cryptomatorComponentImpl;

    private final FxApplicationComponentImpl fxApplicationComponentImpl;

    private final VaultOptionsComponentImpl vaultOptionsComponentImpl;

    private final ConvertVaultComponentImpl convertVaultComponentImpl = this;

    private Provider<VaultConfig.UnverifiedVaultConfig> vaultConfigProvider;

    private Provider<StringProperty> provideRecoveryKeyPropertyProvider;

    private Provider<FxController> bindRecoveryKeyValidateControllerProvider;

    private Provider<FxController> provideNewPasswordControllerProvider;

    private Provider<Stage> provideStageProvider;

    private Provider<FxmlLoaderFactory> provideFxmlLoaderFactoryProvider;

    private Provider<Scene> provideHubToPasswordSuccessSceneProvider;

    private Provider<HubToPasswordConvertController> hubToPasswordConvertControllerProvider;

    private Provider<Scene> provideHubToPasswordConvertSceneProvider;

    private Provider<HubToPasswordStartController> hubToPasswordStartControllerProvider;

    private Provider<HubToPasswordSuccessController> hubToPasswordSuccessControllerProvider;

    private Provider<Scene> provideHubToPasswordStartSceneProvider;

    private ConvertVaultComponentImpl(
        CryptomatorComponentImpl cryptomatorComponentImpl,
        FxApplicationComponentImpl fxApplicationComponentImpl,
        VaultOptionsComponentImpl vaultOptionsComponentImpl,
        Vault arg0Param,
        Stage arg1Param) {
      this.cryptomatorComponentImpl = cryptomatorComponentImpl;
      this.fxApplicationComponentImpl = fxApplicationComponentImpl;
      this.vaultOptionsComponentImpl = vaultOptionsComponentImpl;
      this.arg0 = arg0Param;
      this.arg1 = arg1Param;
      initialize(arg0Param, arg1Param);
    }

    private Map<Class<? extends FxController>, javax.inject.Provider<FxController>>
        mapOfClassOfAndProviderOfFxController() {
      return ImmutableMap
          .<Class<? extends FxController>, javax.inject.Provider<FxController>>
              builderWithExpectedSize(10)
          .put(
              GeneralVaultOptionsController.class,
              ((Provider) vaultOptionsComponentImpl.generalVaultOptionsControllerProvider))
          .put(
              HubOptionsController.class,
              ((Provider) vaultOptionsComponentImpl.hubOptionsControllerProvider))
          .put(
              MasterkeyOptionsController.class,
              ((Provider) vaultOptionsComponentImpl.masterkeyOptionsControllerProvider))
          .put(
              MountOptionsController.class,
              ((Provider) vaultOptionsComponentImpl.mountOptionsControllerProvider))
          .put(
              VaultOptionsController.class,
              ((Provider) vaultOptionsComponentImpl.vaultOptionsControllerProvider))
          .put(RecoveryKeyValidateController.class, bindRecoveryKeyValidateControllerProvider)
          .put(NewPasswordController.class, provideNewPasswordControllerProvider)
          .put(
              HubToPasswordConvertController.class,
              ((Provider) hubToPasswordConvertControllerProvider))
          .put(
              HubToPasswordStartController.class, ((Provider) hubToPasswordStartControllerProvider))
          .put(
              HubToPasswordSuccessController.class,
              ((Provider) hubToPasswordSuccessControllerProvider))
          .build();
    }

    @SuppressWarnings("unchecked")
    private void initialize(final Vault arg0Param, final Stage arg1Param) {
      this.vaultConfigProvider =
          DoubleCheck.provider(
              new SwitchingProvider<VaultConfig.UnverifiedVaultConfig>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  vaultOptionsComponentImpl,
                  convertVaultComponentImpl,
                  3));
      this.provideRecoveryKeyPropertyProvider =
          DoubleCheck.provider(
              new SwitchingProvider<StringProperty>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  vaultOptionsComponentImpl,
                  convertVaultComponentImpl,
                  4));
      this.bindRecoveryKeyValidateControllerProvider =
          new SwitchingProvider<>(
              cryptomatorComponentImpl,
              fxApplicationComponentImpl,
              vaultOptionsComponentImpl,
              convertVaultComponentImpl,
              2);
      this.provideNewPasswordControllerProvider =
          new SwitchingProvider<>(
              cryptomatorComponentImpl,
              fxApplicationComponentImpl,
              vaultOptionsComponentImpl,
              convertVaultComponentImpl,
              5);
      this.provideStageProvider =
          DoubleCheck.provider(
              new SwitchingProvider<Stage>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  vaultOptionsComponentImpl,
                  convertVaultComponentImpl,
                  7));
      this.provideFxmlLoaderFactoryProvider = new DelegateFactory<>();
      this.provideHubToPasswordSuccessSceneProvider =
          DoubleCheck.provider(
              new SwitchingProvider<Scene>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  vaultOptionsComponentImpl,
                  convertVaultComponentImpl,
                  8));
      this.hubToPasswordConvertControllerProvider =
          new SwitchingProvider<>(
              cryptomatorComponentImpl,
              fxApplicationComponentImpl,
              vaultOptionsComponentImpl,
              convertVaultComponentImpl,
              6);
      this.provideHubToPasswordConvertSceneProvider =
          DoubleCheck.provider(
              new SwitchingProvider<Scene>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  vaultOptionsComponentImpl,
                  convertVaultComponentImpl,
                  10));
      this.hubToPasswordStartControllerProvider =
          new SwitchingProvider<>(
              cryptomatorComponentImpl,
              fxApplicationComponentImpl,
              vaultOptionsComponentImpl,
              convertVaultComponentImpl,
              9);
      this.hubToPasswordSuccessControllerProvider =
          new SwitchingProvider<>(
              cryptomatorComponentImpl,
              fxApplicationComponentImpl,
              vaultOptionsComponentImpl,
              convertVaultComponentImpl,
              11);
      DelegateFactory.setDelegate(
          provideFxmlLoaderFactoryProvider,
          DoubleCheck.provider(
              new SwitchingProvider<FxmlLoaderFactory>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  vaultOptionsComponentImpl,
                  convertVaultComponentImpl,
                  1)));
      this.provideHubToPasswordStartSceneProvider =
          DoubleCheck.provider(
              new SwitchingProvider<Scene>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  vaultOptionsComponentImpl,
                  convertVaultComponentImpl,
                  0));
    }

    @Override
    public Lazy<Scene> hubToPasswordScene() {
      return DoubleCheck.lazy(provideHubToPasswordStartSceneProvider);
    }

    @Override
    public Stage window() {
      return provideStageProvider.get();
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final CryptomatorComponentImpl cryptomatorComponentImpl;

      private final FxApplicationComponentImpl fxApplicationComponentImpl;

      private final VaultOptionsComponentImpl vaultOptionsComponentImpl;

      private final ConvertVaultComponentImpl convertVaultComponentImpl;

      private final int id;

      SwitchingProvider(
          CryptomatorComponentImpl cryptomatorComponentImpl,
          FxApplicationComponentImpl fxApplicationComponentImpl,
          VaultOptionsComponentImpl vaultOptionsComponentImpl,
          ConvertVaultComponentImpl convertVaultComponentImpl,
          int id) {
        this.cryptomatorComponentImpl = cryptomatorComponentImpl;
        this.fxApplicationComponentImpl = fxApplicationComponentImpl;
        this.vaultOptionsComponentImpl = vaultOptionsComponentImpl;
        this.convertVaultComponentImpl = convertVaultComponentImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // @org.cryptomator.ui.common.FxmlScene(CONVERTVAULT_HUBTOPASSWORD_START)
                  // javafx.scene.Scene
            return (T)
                ConvertVaultModule_ProvideHubToPasswordStartSceneFactory
                    .provideHubToPasswordStartScene(
                        convertVaultComponentImpl.provideFxmlLoaderFactoryProvider.get());

          case 1: // @org.cryptomator.ui.convertvault.ConvertVaultWindow
                  // org.cryptomator.ui.common.FxmlLoaderFactory
            return (T)
                ConvertVaultModule_ProvideFxmlLoaderFactoryFactory.provideFxmlLoaderFactory(
                    convertVaultComponentImpl.mapOfClassOfAndProviderOfFxController(),
                    fxApplicationComponentImpl.defaultSceneFactoryProvider.get(),
                    cryptomatorComponentImpl.provideLocalizationProvider.get());

          case 2: // java.util.Map<java.lang.Class<? extends
                  // org.cryptomator.ui.common.FxController>,javax.inject.Provider<org.cryptomator.ui.common.FxController>> org.cryptomator.ui.convertvault.ConvertVaultModule#bindRecoveryKeyValidateController
            return (T)
                ConvertVaultModule_BindRecoveryKeyValidateControllerFactory
                    .bindRecoveryKeyValidateController(
                        convertVaultComponentImpl.arg0,
                        convertVaultComponentImpl.vaultConfigProvider.get(),
                        convertVaultComponentImpl.provideRecoveryKeyPropertyProvider.get(),
                        cryptomatorComponentImpl.recoveryKeyFactoryProvider.get());

          case 3: // @org.cryptomator.ui.convertvault.ConvertVaultWindow
                  // org.cryptomator.cryptofs.VaultConfig.UnverifiedVaultConfig
            return (T)
                ConvertVaultModule_VaultConfigFactory.vaultConfig(convertVaultComponentImpl.arg0);

          case 4: // @org.cryptomator.ui.convertvault.ConvertVaultWindow
                  // javafx.beans.property.StringProperty
            return (T)
                ConvertVaultModule_ProvideRecoveryKeyPropertyFactory.provideRecoveryKeyProperty();

          case 5: // java.util.Map<java.lang.Class<? extends
                  // org.cryptomator.ui.common.FxController>,javax.inject.Provider<org.cryptomator.ui.common.FxController>> org.cryptomator.ui.convertvault.ConvertVaultModule#provideNewPasswordController
            return (T)
                ConvertVaultModule_ProvideNewPasswordControllerFactory.provideNewPasswordController(
                    cryptomatorComponentImpl.provideLocalizationProvider.get(),
                    fxApplicationComponentImpl.passwordStrengthUtilProvider.get());

          case 6: // org.cryptomator.ui.convertvault.HubToPasswordConvertController
            return (T)
                new HubToPasswordConvertController(
                    convertVaultComponentImpl.provideStageProvider.get(),
                    DoubleCheck.lazy(
                        convertVaultComponentImpl.provideHubToPasswordSuccessSceneProvider),
                    fxApplicationComponentImpl.fxApplicationWindowsProvider.get(),
                    convertVaultComponentImpl.arg0,
                    convertVaultComponentImpl.provideRecoveryKeyPropertyProvider.get(),
                    cryptomatorComponentImpl.recoveryKeyFactoryProvider.get(),
                    cryptomatorComponentImpl.provideMasterkeyFileAccessProvider.get(),
                    cryptomatorComponentImpl.provideExecutorServiceProvider.get(),
                    cryptomatorComponentImpl.provideLocalizationProvider.get());

          case 7: // @org.cryptomator.ui.convertvault.ConvertVaultWindow javafx.stage.Stage
            return (T)
                ConvertVaultModule_ProvideStageFactory.provideStage(
                    fxApplicationComponentImpl.stageFactoryProvider.get(),
                    convertVaultComponentImpl.arg1,
                    cryptomatorComponentImpl.provideLocalizationProvider.get());

          case 8: // @org.cryptomator.ui.common.FxmlScene(CONVERTVAULT_HUBTOPASSWORD_SUCCESS)
                  // javafx.scene.Scene
            return (T)
                ConvertVaultModule_ProvideHubToPasswordSuccessSceneFactory
                    .provideHubToPasswordSuccessScene(
                        convertVaultComponentImpl.provideFxmlLoaderFactoryProvider.get());

          case 9: // org.cryptomator.ui.convertvault.HubToPasswordStartController
            return (T)
                new HubToPasswordStartController(
                    convertVaultComponentImpl.provideStageProvider.get(),
                    DoubleCheck.lazy(
                        convertVaultComponentImpl.provideHubToPasswordConvertSceneProvider));

          case 10: // @org.cryptomator.ui.common.FxmlScene(CONVERTVAULT_HUBTOPASSWORD_CONVERT)
                   // javafx.scene.Scene
            return (T)
                ConvertVaultModule_ProvideHubToPasswordConvertSceneFactory
                    .provideHubToPasswordConvertScene(
                        convertVaultComponentImpl.provideFxmlLoaderFactoryProvider.get());

          case 11: // org.cryptomator.ui.convertvault.HubToPasswordSuccessController
            return (T)
                HubToPasswordSuccessController_Factory.newInstance(
                    convertVaultComponentImpl.provideStageProvider.get(),
                    convertVaultComponentImpl.arg0);

          default:
            throw new AssertionError(id);
        }
      }
    }
  }

  private static final class ChangePasswordComponentImpl implements ChangePasswordComponent {
    private final Stage owner;

    private final Vault vault;

    private final CryptomatorComponentImpl cryptomatorComponentImpl;

    private final FxApplicationComponentImpl fxApplicationComponentImpl;

    private final VaultOptionsComponentImpl vaultOptionsComponentImpl;

    private final ChangePasswordComponentImpl changePasswordComponentImpl = this;

    private Provider<FxController> provideNewPasswordControllerProvider;

    private Provider<Stage> provideStageProvider;

    private Provider<ChangePasswordController> changePasswordControllerProvider;

    private Provider<FxmlLoaderFactory> provideFxmlLoaderFactoryProvider;

    private Provider<Scene> provideUnlockSceneProvider;

    private ChangePasswordComponentImpl(
        CryptomatorComponentImpl cryptomatorComponentImpl,
        FxApplicationComponentImpl fxApplicationComponentImpl,
        VaultOptionsComponentImpl vaultOptionsComponentImpl,
        Stage ownerParam,
        Vault vaultParam) {
      this.cryptomatorComponentImpl = cryptomatorComponentImpl;
      this.fxApplicationComponentImpl = fxApplicationComponentImpl;
      this.vaultOptionsComponentImpl = vaultOptionsComponentImpl;
      this.owner = ownerParam;
      this.vault = vaultParam;
      initialize(ownerParam, vaultParam);
    }

    private Map<Class<? extends FxController>, javax.inject.Provider<FxController>>
        mapOfClassOfAndProviderOfFxController() {
      return ImmutableMap
          .<Class<? extends FxController>, javax.inject.Provider<FxController>>
              builderWithExpectedSize(7)
          .put(
              GeneralVaultOptionsController.class,
              ((Provider) vaultOptionsComponentImpl.generalVaultOptionsControllerProvider))
          .put(
              HubOptionsController.class,
              ((Provider) vaultOptionsComponentImpl.hubOptionsControllerProvider))
          .put(
              MasterkeyOptionsController.class,
              ((Provider) vaultOptionsComponentImpl.masterkeyOptionsControllerProvider))
          .put(
              MountOptionsController.class,
              ((Provider) vaultOptionsComponentImpl.mountOptionsControllerProvider))
          .put(
              VaultOptionsController.class,
              ((Provider) vaultOptionsComponentImpl.vaultOptionsControllerProvider))
          .put(NewPasswordController.class, provideNewPasswordControllerProvider)
          .put(ChangePasswordController.class, ((Provider) changePasswordControllerProvider))
          .build();
    }

    @SuppressWarnings("unchecked")
    private void initialize(final Stage ownerParam, final Vault vaultParam) {
      this.provideNewPasswordControllerProvider =
          new SwitchingProvider<>(
              cryptomatorComponentImpl,
              fxApplicationComponentImpl,
              vaultOptionsComponentImpl,
              changePasswordComponentImpl,
              2);
      this.provideStageProvider =
          DoubleCheck.provider(
              new SwitchingProvider<Stage>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  vaultOptionsComponentImpl,
                  changePasswordComponentImpl,
                  4));
      this.changePasswordControllerProvider =
          DoubleCheck.provider(
              new SwitchingProvider<ChangePasswordController>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  vaultOptionsComponentImpl,
                  changePasswordComponentImpl,
                  3));
      this.provideFxmlLoaderFactoryProvider =
          DoubleCheck.provider(
              new SwitchingProvider<FxmlLoaderFactory>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  vaultOptionsComponentImpl,
                  changePasswordComponentImpl,
                  1));
      this.provideUnlockSceneProvider =
          DoubleCheck.provider(
              new SwitchingProvider<Scene>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  vaultOptionsComponentImpl,
                  changePasswordComponentImpl,
                  0));
    }

    @Override
    public Lazy<Scene> scene() {
      return DoubleCheck.lazy(provideUnlockSceneProvider);
    }

    @Override
    public Stage window() {
      return provideStageProvider.get();
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final CryptomatorComponentImpl cryptomatorComponentImpl;

      private final FxApplicationComponentImpl fxApplicationComponentImpl;

      private final VaultOptionsComponentImpl vaultOptionsComponentImpl;

      private final ChangePasswordComponentImpl changePasswordComponentImpl;

      private final int id;

      SwitchingProvider(
          CryptomatorComponentImpl cryptomatorComponentImpl,
          FxApplicationComponentImpl fxApplicationComponentImpl,
          VaultOptionsComponentImpl vaultOptionsComponentImpl,
          ChangePasswordComponentImpl changePasswordComponentImpl,
          int id) {
        this.cryptomatorComponentImpl = cryptomatorComponentImpl;
        this.fxApplicationComponentImpl = fxApplicationComponentImpl;
        this.vaultOptionsComponentImpl = vaultOptionsComponentImpl;
        this.changePasswordComponentImpl = changePasswordComponentImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // @org.cryptomator.ui.common.FxmlScene(CHANGEPASSWORD) javafx.scene.Scene
            return (T)
                ChangePasswordModule_ProvideUnlockSceneFactory.provideUnlockScene(
                    changePasswordComponentImpl.provideFxmlLoaderFactoryProvider.get());

          case 1: // @org.cryptomator.ui.changepassword.ChangePasswordWindow
                  // org.cryptomator.ui.common.FxmlLoaderFactory
            return (T)
                ChangePasswordModule_ProvideFxmlLoaderFactoryFactory.provideFxmlLoaderFactory(
                    changePasswordComponentImpl.mapOfClassOfAndProviderOfFxController(),
                    fxApplicationComponentImpl.defaultSceneFactoryProvider.get(),
                    cryptomatorComponentImpl.provideLocalizationProvider.get());

          case 2: // java.util.Map<java.lang.Class<? extends
                  // org.cryptomator.ui.common.FxController>,javax.inject.Provider<org.cryptomator.ui.common.FxController>> org.cryptomator.ui.changepassword.ChangePasswordModule#provideNewPasswordController
            return (T)
                ChangePasswordModule_ProvideNewPasswordControllerFactory
                    .provideNewPasswordController(
                        cryptomatorComponentImpl.provideLocalizationProvider.get(),
                        fxApplicationComponentImpl.passwordStrengthUtilProvider.get());

          case 3: // org.cryptomator.ui.changepassword.ChangePasswordController
            return (T)
                new ChangePasswordController(
                    changePasswordComponentImpl.provideStageProvider.get(),
                    changePasswordComponentImpl.vault,
                    fxApplicationComponentImpl.fxApplicationWindowsProvider.get(),
                    cryptomatorComponentImpl.keychainManagerProvider.get(),
                    cryptomatorComponentImpl.provideMasterkeyFileAccessProvider.get());

          case 4: // @org.cryptomator.ui.changepassword.ChangePasswordWindow javafx.stage.Stage
            return (T)
                ChangePasswordModule_ProvideStageFactory.provideStage(
                    fxApplicationComponentImpl.stageFactoryProvider.get(),
                    changePasswordComponentImpl.owner,
                    cryptomatorComponentImpl.provideLocalizationProvider.get());

          default:
            throw new AssertionError(id);
        }
      }
    }
  }

  private static final class RecoveryKeyComponentImpl implements RecoveryKeyComponent {
    private final Vault arg0;

    private final Stage arg1;

    private final CryptomatorComponentImpl cryptomatorComponentImpl;

    private final FxApplicationComponentImpl fxApplicationComponentImpl;

    private final VaultOptionsComponentImpl vaultOptionsComponentImpl;

    private final RecoveryKeyComponentImpl recoveryKeyComponentImpl = this;

    private Provider<VaultConfig.UnverifiedVaultConfig> vaultConfigProvider;

    private Provider<StringProperty> provideRecoveryKeyPropertyProvider;

    private Provider<FxController> bindRecoveryKeyValidateControllerProvider;

    private Provider<FxController> provideNewPasswordControllerProvider;

    private Provider<Stage> provideStageProvider;

    private Provider<FxController> provideRecoveryKeyDisplayControllerProvider;

    private Provider<FxmlLoaderFactory> provideFxmlLoaderFactoryProvider;

    private Provider<Scene> provideRecoveryKeySuccessSceneProvider;

    private Provider<RecoveryKeyCreationController> recoveryKeyCreationControllerProvider;

    private Provider<Scene> provideRecoveryKeyResetPasswordSuccessSceneProvider;

    private Provider<RecoveryKeyResetPasswordController> recoveryKeyResetPasswordControllerProvider;

    private Provider<RecoveryKeyResetPasswordSuccessController>
        recoveryKeyResetPasswordSuccessControllerProvider;

    private Provider<RecoveryKeySuccessController> recoveryKeySuccessControllerProvider;

    private Provider<Scene> provideRecoveryKeyResetPasswordSceneProvider;

    private Provider<RecoveryKeyRecoverController> recoveryKeyRecoverControllerProvider;

    private Provider<Scene> provideRecoveryKeyCreationSceneProvider;

    private Provider<Scene> provideRecoveryKeyRecoverSceneProvider;

    private RecoveryKeyComponentImpl(
        CryptomatorComponentImpl cryptomatorComponentImpl,
        FxApplicationComponentImpl fxApplicationComponentImpl,
        VaultOptionsComponentImpl vaultOptionsComponentImpl,
        Vault arg0Param,
        Stage arg1Param) {
      this.cryptomatorComponentImpl = cryptomatorComponentImpl;
      this.fxApplicationComponentImpl = fxApplicationComponentImpl;
      this.vaultOptionsComponentImpl = vaultOptionsComponentImpl;
      this.arg0 = arg0Param;
      this.arg1 = arg1Param;
      initialize(arg0Param, arg1Param);
    }

    private Map<Class<? extends FxController>, javax.inject.Provider<FxController>>
        mapOfClassOfAndProviderOfFxController() {
      return ImmutableMap
          .<Class<? extends FxController>, javax.inject.Provider<FxController>>
              builderWithExpectedSize(13)
          .put(
              GeneralVaultOptionsController.class,
              ((Provider) vaultOptionsComponentImpl.generalVaultOptionsControllerProvider))
          .put(
              HubOptionsController.class,
              ((Provider) vaultOptionsComponentImpl.hubOptionsControllerProvider))
          .put(
              MasterkeyOptionsController.class,
              ((Provider) vaultOptionsComponentImpl.masterkeyOptionsControllerProvider))
          .put(
              MountOptionsController.class,
              ((Provider) vaultOptionsComponentImpl.mountOptionsControllerProvider))
          .put(
              VaultOptionsController.class,
              ((Provider) vaultOptionsComponentImpl.vaultOptionsControllerProvider))
          .put(RecoveryKeyValidateController.class, bindRecoveryKeyValidateControllerProvider)
          .put(NewPasswordController.class, provideNewPasswordControllerProvider)
          .put(RecoveryKeyDisplayController.class, provideRecoveryKeyDisplayControllerProvider)
          .put(
              RecoveryKeyCreationController.class,
              ((Provider) recoveryKeyCreationControllerProvider))
          .put(
              RecoveryKeyResetPasswordController.class,
              ((Provider) recoveryKeyResetPasswordControllerProvider))
          .put(
              RecoveryKeyResetPasswordSuccessController.class,
              ((Provider) recoveryKeyResetPasswordSuccessControllerProvider))
          .put(
              RecoveryKeySuccessController.class, ((Provider) recoveryKeySuccessControllerProvider))
          .put(
              RecoveryKeyRecoverController.class, ((Provider) recoveryKeyRecoverControllerProvider))
          .build();
    }

    @SuppressWarnings("unchecked")
    private void initialize(final Vault arg0Param, final Stage arg1Param) {
      this.vaultConfigProvider =
          DoubleCheck.provider(
              new SwitchingProvider<VaultConfig.UnverifiedVaultConfig>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  vaultOptionsComponentImpl,
                  recoveryKeyComponentImpl,
                  3));
      this.provideRecoveryKeyPropertyProvider =
          DoubleCheck.provider(
              new SwitchingProvider<StringProperty>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  vaultOptionsComponentImpl,
                  recoveryKeyComponentImpl,
                  4));
      this.bindRecoveryKeyValidateControllerProvider =
          new SwitchingProvider<>(
              cryptomatorComponentImpl,
              fxApplicationComponentImpl,
              vaultOptionsComponentImpl,
              recoveryKeyComponentImpl,
              2);
      this.provideNewPasswordControllerProvider =
          new SwitchingProvider<>(
              cryptomatorComponentImpl,
              fxApplicationComponentImpl,
              vaultOptionsComponentImpl,
              recoveryKeyComponentImpl,
              5);
      this.provideStageProvider =
          DoubleCheck.provider(
              new SwitchingProvider<Stage>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  vaultOptionsComponentImpl,
                  recoveryKeyComponentImpl,
                  7));
      this.provideRecoveryKeyDisplayControllerProvider =
          new SwitchingProvider<>(
              cryptomatorComponentImpl,
              fxApplicationComponentImpl,
              vaultOptionsComponentImpl,
              recoveryKeyComponentImpl,
              6);
      this.provideFxmlLoaderFactoryProvider = new DelegateFactory<>();
      this.provideRecoveryKeySuccessSceneProvider =
          DoubleCheck.provider(
              new SwitchingProvider<Scene>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  vaultOptionsComponentImpl,
                  recoveryKeyComponentImpl,
                  9));
      this.recoveryKeyCreationControllerProvider =
          DoubleCheck.provider(
              new SwitchingProvider<RecoveryKeyCreationController>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  vaultOptionsComponentImpl,
                  recoveryKeyComponentImpl,
                  8));
      this.provideRecoveryKeyResetPasswordSuccessSceneProvider =
          DoubleCheck.provider(
              new SwitchingProvider<Scene>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  vaultOptionsComponentImpl,
                  recoveryKeyComponentImpl,
                  11));
      this.recoveryKeyResetPasswordControllerProvider =
          DoubleCheck.provider(
              new SwitchingProvider<RecoveryKeyResetPasswordController>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  vaultOptionsComponentImpl,
                  recoveryKeyComponentImpl,
                  10));
      this.recoveryKeyResetPasswordSuccessControllerProvider =
          DoubleCheck.provider(
              new SwitchingProvider<RecoveryKeyResetPasswordSuccessController>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  vaultOptionsComponentImpl,
                  recoveryKeyComponentImpl,
                  12));
      this.recoveryKeySuccessControllerProvider =
          DoubleCheck.provider(
              new SwitchingProvider<RecoveryKeySuccessController>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  vaultOptionsComponentImpl,
                  recoveryKeyComponentImpl,
                  13));
      this.provideRecoveryKeyResetPasswordSceneProvider =
          DoubleCheck.provider(
              new SwitchingProvider<Scene>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  vaultOptionsComponentImpl,
                  recoveryKeyComponentImpl,
                  15));
      this.recoveryKeyRecoverControllerProvider =
          DoubleCheck.provider(
              new SwitchingProvider<RecoveryKeyRecoverController>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  vaultOptionsComponentImpl,
                  recoveryKeyComponentImpl,
                  14));
      DelegateFactory.setDelegate(
          provideFxmlLoaderFactoryProvider,
          DoubleCheck.provider(
              new SwitchingProvider<FxmlLoaderFactory>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  vaultOptionsComponentImpl,
                  recoveryKeyComponentImpl,
                  1)));
      this.provideRecoveryKeyCreationSceneProvider =
          DoubleCheck.provider(
              new SwitchingProvider<Scene>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  vaultOptionsComponentImpl,
                  recoveryKeyComponentImpl,
                  0));
      this.provideRecoveryKeyRecoverSceneProvider =
          DoubleCheck.provider(
              new SwitchingProvider<Scene>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  vaultOptionsComponentImpl,
                  recoveryKeyComponentImpl,
                  16));
    }

    @Override
    public Lazy<Scene> creationScene() {
      return DoubleCheck.lazy(provideRecoveryKeyCreationSceneProvider);
    }

    @Override
    public Lazy<Scene> recoverScene() {
      return DoubleCheck.lazy(provideRecoveryKeyRecoverSceneProvider);
    }

    @Override
    public Stage window() {
      return provideStageProvider.get();
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final CryptomatorComponentImpl cryptomatorComponentImpl;

      private final FxApplicationComponentImpl fxApplicationComponentImpl;

      private final VaultOptionsComponentImpl vaultOptionsComponentImpl;

      private final RecoveryKeyComponentImpl recoveryKeyComponentImpl;

      private final int id;

      SwitchingProvider(
          CryptomatorComponentImpl cryptomatorComponentImpl,
          FxApplicationComponentImpl fxApplicationComponentImpl,
          VaultOptionsComponentImpl vaultOptionsComponentImpl,
          RecoveryKeyComponentImpl recoveryKeyComponentImpl,
          int id) {
        this.cryptomatorComponentImpl = cryptomatorComponentImpl;
        this.fxApplicationComponentImpl = fxApplicationComponentImpl;
        this.vaultOptionsComponentImpl = vaultOptionsComponentImpl;
        this.recoveryKeyComponentImpl = recoveryKeyComponentImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // @org.cryptomator.ui.common.FxmlScene(RECOVERYKEY_CREATE) javafx.scene.Scene
            return (T)
                RecoveryKeyModule_ProvideRecoveryKeyCreationSceneFactory
                    .provideRecoveryKeyCreationScene(
                        recoveryKeyComponentImpl.provideFxmlLoaderFactoryProvider.get());

          case 1: // @org.cryptomator.ui.recoverykey.RecoveryKeyWindow
                  // org.cryptomator.ui.common.FxmlLoaderFactory
            return (T)
                RecoveryKeyModule_ProvideFxmlLoaderFactoryFactory.provideFxmlLoaderFactory(
                    recoveryKeyComponentImpl.mapOfClassOfAndProviderOfFxController(),
                    fxApplicationComponentImpl.defaultSceneFactoryProvider.get(),
                    cryptomatorComponentImpl.provideLocalizationProvider.get());

          case 2: // java.util.Map<java.lang.Class<? extends
                  // org.cryptomator.ui.common.FxController>,javax.inject.Provider<org.cryptomator.ui.common.FxController>> org.cryptomator.ui.recoverykey.RecoveryKeyModule#bindRecoveryKeyValidateController
            return (T)
                RecoveryKeyModule_BindRecoveryKeyValidateControllerFactory
                    .bindRecoveryKeyValidateController(
                        recoveryKeyComponentImpl.arg0,
                        recoveryKeyComponentImpl.vaultConfigProvider.get(),
                        recoveryKeyComponentImpl.provideRecoveryKeyPropertyProvider.get(),
                        cryptomatorComponentImpl.recoveryKeyFactoryProvider.get());

          case 3: // @org.cryptomator.ui.recoverykey.RecoveryKeyWindow
                  // org.cryptomator.cryptofs.VaultConfig.UnverifiedVaultConfig
            return (T)
                RecoveryKeyModule_VaultConfigFactory.vaultConfig(recoveryKeyComponentImpl.arg0);

          case 4: // @org.cryptomator.ui.recoverykey.RecoveryKeyWindow
                  // javafx.beans.property.StringProperty
            return (T)
                RecoveryKeyModule_ProvideRecoveryKeyPropertyFactory.provideRecoveryKeyProperty();

          case 5: // java.util.Map<java.lang.Class<? extends
                  // org.cryptomator.ui.common.FxController>,javax.inject.Provider<org.cryptomator.ui.common.FxController>> org.cryptomator.ui.recoverykey.RecoveryKeyModule#provideNewPasswordController
            return (T)
                RecoveryKeyModule_ProvideNewPasswordControllerFactory.provideNewPasswordController(
                    cryptomatorComponentImpl.provideLocalizationProvider.get(),
                    fxApplicationComponentImpl.passwordStrengthUtilProvider.get());

          case 6: // java.util.Map<java.lang.Class<? extends
                  // org.cryptomator.ui.common.FxController>,javax.inject.Provider<org.cryptomator.ui.common.FxController>> org.cryptomator.ui.recoverykey.RecoveryKeyModule#provideRecoveryKeyDisplayController
            return (T)
                RecoveryKeyModule_ProvideRecoveryKeyDisplayControllerFactory
                    .provideRecoveryKeyDisplayController(
                        recoveryKeyComponentImpl.provideStageProvider.get(),
                        recoveryKeyComponentImpl.arg0,
                        recoveryKeyComponentImpl.provideRecoveryKeyPropertyProvider.get(),
                        cryptomatorComponentImpl.provideLocalizationProvider.get());

          case 7: // @org.cryptomator.ui.recoverykey.RecoveryKeyWindow javafx.stage.Stage
            return (T)
                RecoveryKeyModule_ProvideStageFactory.provideStage(
                    fxApplicationComponentImpl.stageFactoryProvider.get(),
                    recoveryKeyComponentImpl.arg1);

          case 8: // org.cryptomator.ui.recoverykey.RecoveryKeyCreationController
            return (T)
                new RecoveryKeyCreationController(
                    recoveryKeyComponentImpl.provideStageProvider.get(),
                    DoubleCheck.lazy(
                        recoveryKeyComponentImpl.provideRecoveryKeySuccessSceneProvider),
                    recoveryKeyComponentImpl.arg0,
                    cryptomatorComponentImpl.recoveryKeyFactoryProvider.get(),
                    cryptomatorComponentImpl.provideExecutorServiceProvider.get(),
                    recoveryKeyComponentImpl.provideRecoveryKeyPropertyProvider.get(),
                    fxApplicationComponentImpl.fxApplicationWindowsProvider.get(),
                    cryptomatorComponentImpl.provideLocalizationProvider.get());

          case 9: // @org.cryptomator.ui.common.FxmlScene(RECOVERYKEY_SUCCESS) javafx.scene.Scene
            return (T)
                RecoveryKeyModule_ProvideRecoveryKeySuccessSceneFactory
                    .provideRecoveryKeySuccessScene(
                        recoveryKeyComponentImpl.provideFxmlLoaderFactoryProvider.get());

          case 10: // org.cryptomator.ui.recoverykey.RecoveryKeyResetPasswordController
            return (T)
                new RecoveryKeyResetPasswordController(
                    recoveryKeyComponentImpl.provideStageProvider.get(),
                    recoveryKeyComponentImpl.arg0,
                    cryptomatorComponentImpl.recoveryKeyFactoryProvider.get(),
                    cryptomatorComponentImpl.provideExecutorServiceProvider.get(),
                    recoveryKeyComponentImpl.provideRecoveryKeyPropertyProvider.get(),
                    DoubleCheck.lazy(
                        recoveryKeyComponentImpl
                            .provideRecoveryKeyResetPasswordSuccessSceneProvider),
                    fxApplicationComponentImpl.fxApplicationWindowsProvider.get());

          case 11: // @org.cryptomator.ui.common.FxmlScene(RECOVERYKEY_RESET_PASSWORD_SUCCESS)
                   // javafx.scene.Scene
            return (T)
                RecoveryKeyModule_ProvideRecoveryKeyResetPasswordSuccessSceneFactory
                    .provideRecoveryKeyResetPasswordSuccessScene(
                        recoveryKeyComponentImpl.provideFxmlLoaderFactoryProvider.get());

          case 12: // org.cryptomator.ui.recoverykey.RecoveryKeyResetPasswordSuccessController
            return (T)
                new RecoveryKeyResetPasswordSuccessController(
                    recoveryKeyComponentImpl.provideStageProvider.get());

          case 13: // org.cryptomator.ui.recoverykey.RecoveryKeySuccessController
            return (T)
                new RecoveryKeySuccessController(
                    recoveryKeyComponentImpl.provideStageProvider.get());

          case 14: // org.cryptomator.ui.recoverykey.RecoveryKeyRecoverController
            return (T)
                new RecoveryKeyRecoverController(
                    recoveryKeyComponentImpl.provideStageProvider.get(),
                    recoveryKeyComponentImpl.arg0,
                    recoveryKeyComponentImpl.provideRecoveryKeyPropertyProvider.get(),
                    DoubleCheck.lazy(
                        recoveryKeyComponentImpl.provideRecoveryKeyResetPasswordSceneProvider),
                    cryptomatorComponentImpl.provideLocalizationProvider.get());

          case 15: // @org.cryptomator.ui.common.FxmlScene(RECOVERYKEY_RESET_PASSWORD)
                   // javafx.scene.Scene
            return (T)
                RecoveryKeyModule_ProvideRecoveryKeyResetPasswordSceneFactory
                    .provideRecoveryKeyResetPasswordScene(
                        recoveryKeyComponentImpl.provideFxmlLoaderFactoryProvider.get());

          case 16: // @org.cryptomator.ui.common.FxmlScene(RECOVERYKEY_RECOVER) javafx.scene.Scene
            return (T)
                RecoveryKeyModule_ProvideRecoveryKeyRecoverSceneFactory
                    .provideRecoveryKeyRecoverScene(
                        recoveryKeyComponentImpl.provideFxmlLoaderFactoryProvider.get());

          default:
            throw new AssertionError(id);
        }
      }
    }
  }

  private static final class ocuf2_ForgetPasswordComponentImpl implements ForgetPasswordComponent {
    private final Stage owner;

    private final Vault vault;

    private final CryptomatorComponentImpl cryptomatorComponentImpl;

    private final FxApplicationComponentImpl fxApplicationComponentImpl;

    private final VaultOptionsComponentImpl vaultOptionsComponentImpl;

    private final ocuf2_ForgetPasswordComponentImpl _ocuf2_ForgetPasswordComponentImpl = this;

    private Provider<BooleanProperty> provideConfirmedPropertyProvider;

    private Provider<Stage> provideStageProvider;

    private Provider<ForgetPasswordController> forgetPasswordControllerProvider;

    private Provider<FxmlLoaderFactory> provideFxmlLoaderFactoryProvider;

    private Provider<Scene> provideForgetPasswordSceneProvider;

    private ocuf2_ForgetPasswordComponentImpl(
        CryptomatorComponentImpl cryptomatorComponentImpl,
        FxApplicationComponentImpl fxApplicationComponentImpl,
        VaultOptionsComponentImpl vaultOptionsComponentImpl,
        Stage ownerParam,
        Vault vaultParam) {
      this.cryptomatorComponentImpl = cryptomatorComponentImpl;
      this.fxApplicationComponentImpl = fxApplicationComponentImpl;
      this.vaultOptionsComponentImpl = vaultOptionsComponentImpl;
      this.owner = ownerParam;
      this.vault = vaultParam;
      initialize(ownerParam, vaultParam);
    }

    private Map<Class<? extends FxController>, javax.inject.Provider<FxController>>
        mapOfClassOfAndProviderOfFxController() {
      return ImmutableMap
          .<Class<? extends FxController>, javax.inject.Provider<FxController>>
              builderWithExpectedSize(6)
          .put(
              GeneralVaultOptionsController.class,
              ((Provider) vaultOptionsComponentImpl.generalVaultOptionsControllerProvider))
          .put(
              HubOptionsController.class,
              ((Provider) vaultOptionsComponentImpl.hubOptionsControllerProvider))
          .put(
              MasterkeyOptionsController.class,
              ((Provider) vaultOptionsComponentImpl.masterkeyOptionsControllerProvider))
          .put(
              MountOptionsController.class,
              ((Provider) vaultOptionsComponentImpl.mountOptionsControllerProvider))
          .put(
              VaultOptionsController.class,
              ((Provider) vaultOptionsComponentImpl.vaultOptionsControllerProvider))
          .put(ForgetPasswordController.class, ((Provider) forgetPasswordControllerProvider))
          .build();
    }

    @SuppressWarnings("unchecked")
    private void initialize(final Stage ownerParam, final Vault vaultParam) {
      this.provideConfirmedPropertyProvider =
          DoubleCheck.provider(
              new SwitchingProvider<BooleanProperty>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  vaultOptionsComponentImpl,
                  _ocuf2_ForgetPasswordComponentImpl,
                  0));
      this.provideStageProvider =
          DoubleCheck.provider(
              new SwitchingProvider<Stage>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  vaultOptionsComponentImpl,
                  _ocuf2_ForgetPasswordComponentImpl,
                  4));
      this.forgetPasswordControllerProvider =
          DoubleCheck.provider(
              new SwitchingProvider<ForgetPasswordController>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  vaultOptionsComponentImpl,
                  _ocuf2_ForgetPasswordComponentImpl,
                  3));
      this.provideFxmlLoaderFactoryProvider =
          DoubleCheck.provider(
              new SwitchingProvider<FxmlLoaderFactory>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  vaultOptionsComponentImpl,
                  _ocuf2_ForgetPasswordComponentImpl,
                  2));
      this.provideForgetPasswordSceneProvider =
          DoubleCheck.provider(
              new SwitchingProvider<Scene>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  vaultOptionsComponentImpl,
                  _ocuf2_ForgetPasswordComponentImpl,
                  1));
    }

    @Override
    public ReadOnlyBooleanProperty confirmedProperty() {
      return provideConfirmedPropertyProvider.get();
    }

    @Override
    public Lazy<Scene> scene() {
      return DoubleCheck.lazy(provideForgetPasswordSceneProvider);
    }

    @Override
    public Stage window() {
      return provideStageProvider.get();
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final CryptomatorComponentImpl cryptomatorComponentImpl;

      private final FxApplicationComponentImpl fxApplicationComponentImpl;

      private final VaultOptionsComponentImpl vaultOptionsComponentImpl;

      private final ocuf2_ForgetPasswordComponentImpl _ocuf2_ForgetPasswordComponentImpl;

      private final int id;

      SwitchingProvider(
          CryptomatorComponentImpl cryptomatorComponentImpl,
          FxApplicationComponentImpl fxApplicationComponentImpl,
          VaultOptionsComponentImpl vaultOptionsComponentImpl,
          ocuf2_ForgetPasswordComponentImpl _ocuf2_ForgetPasswordComponentImpl,
          int id) {
        this.cryptomatorComponentImpl = cryptomatorComponentImpl;
        this.fxApplicationComponentImpl = fxApplicationComponentImpl;
        this.vaultOptionsComponentImpl = vaultOptionsComponentImpl;
        this._ocuf2_ForgetPasswordComponentImpl = _ocuf2_ForgetPasswordComponentImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // @org.cryptomator.ui.forgetpassword.ForgetPasswordWindow
                  // javafx.beans.property.BooleanProperty
            return (T)
                ForgetPasswordModule_ProvideConfirmedPropertyFactory.provideConfirmedProperty();

          case 1: // @org.cryptomator.ui.common.FxmlScene(FORGET_PASSWORD) javafx.scene.Scene
            return (T)
                ForgetPasswordModule_ProvideForgetPasswordSceneFactory.provideForgetPasswordScene(
                    _ocuf2_ForgetPasswordComponentImpl.provideFxmlLoaderFactoryProvider.get());

          case 2: // @org.cryptomator.ui.forgetpassword.ForgetPasswordWindow
                  // org.cryptomator.ui.common.FxmlLoaderFactory
            return (T)
                ForgetPasswordModule_ProvideFxmlLoaderFactoryFactory.provideFxmlLoaderFactory(
                    _ocuf2_ForgetPasswordComponentImpl.mapOfClassOfAndProviderOfFxController(),
                    fxApplicationComponentImpl.defaultSceneFactoryProvider.get(),
                    cryptomatorComponentImpl.provideLocalizationProvider.get());

          case 3: // org.cryptomator.ui.forgetpassword.ForgetPasswordController
            return (T)
                new ForgetPasswordController(
                    _ocuf2_ForgetPasswordComponentImpl.provideStageProvider.get(),
                    _ocuf2_ForgetPasswordComponentImpl.vault,
                    cryptomatorComponentImpl.keychainManagerProvider.get(),
                    _ocuf2_ForgetPasswordComponentImpl.provideConfirmedPropertyProvider.get());

          case 4: // @org.cryptomator.ui.forgetpassword.ForgetPasswordWindow javafx.stage.Stage
            return (T)
                ForgetPasswordModule_ProvideStageFactory.provideStage(
                    fxApplicationComponentImpl.stageFactoryProvider.get(),
                    cryptomatorComponentImpl.provideLocalizationProvider.get(),
                    _ocuf2_ForgetPasswordComponentImpl.owner);

          default:
            throw new AssertionError(id);
        }
      }
    }
  }

  private static final class VaultOptionsComponentImpl implements VaultOptionsComponent {
    private final Vault arg0;

    private final CryptomatorComponentImpl cryptomatorComponentImpl;

    private final FxApplicationComponentImpl fxApplicationComponentImpl;

    private final VaultOptionsComponentImpl vaultOptionsComponentImpl = this;

    private Provider<Stage> provideStageProvider;

    private Provider<GeneralVaultOptionsController> generalVaultOptionsControllerProvider;

    private Provider<HubOptionsController> hubOptionsControllerProvider;

    private Provider<MasterkeyOptionsController> masterkeyOptionsControllerProvider;

    private Provider<MountOptionsController> mountOptionsControllerProvider;

    private Provider<ObjectProperty<SelectedVaultOptionsTab>> provideSelectedTabPropertyProvider;

    private Provider<VaultOptionsController> vaultOptionsControllerProvider;

    private Provider<FxmlLoaderFactory> provideFxmlLoaderFactoryProvider;

    private Provider<Scene> provideVaultOptionsSceneProvider;

    private VaultOptionsComponentImpl(
        CryptomatorComponentImpl cryptomatorComponentImpl,
        FxApplicationComponentImpl fxApplicationComponentImpl,
        Vault arg0Param) {
      this.cryptomatorComponentImpl = cryptomatorComponentImpl;
      this.fxApplicationComponentImpl = fxApplicationComponentImpl;
      this.arg0 = arg0Param;
      initialize(arg0Param);
    }

    private Map<Class<? extends FxController>, javax.inject.Provider<FxController>>
        mapOfClassOfAndProviderOfFxController() {
      return ImmutableMap.<Class<? extends FxController>, javax.inject.Provider<FxController>>of(
          GeneralVaultOptionsController.class,
          ((Provider) generalVaultOptionsControllerProvider),
          HubOptionsController.class,
          ((Provider) hubOptionsControllerProvider),
          MasterkeyOptionsController.class,
          ((Provider) masterkeyOptionsControllerProvider),
          MountOptionsController.class,
          ((Provider) mountOptionsControllerProvider),
          VaultOptionsController.class,
          ((Provider) vaultOptionsControllerProvider));
    }

    @SuppressWarnings("unchecked")
    private void initialize(final Vault arg0Param) {
      this.provideStageProvider =
          DoubleCheck.provider(
              new SwitchingProvider<Stage>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  vaultOptionsComponentImpl,
                  3));
      this.generalVaultOptionsControllerProvider =
          DoubleCheck.provider(
              new SwitchingProvider<GeneralVaultOptionsController>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  vaultOptionsComponentImpl,
                  2));
      this.hubOptionsControllerProvider =
          new SwitchingProvider<>(
              cryptomatorComponentImpl, fxApplicationComponentImpl, vaultOptionsComponentImpl, 4);
      this.masterkeyOptionsControllerProvider =
          DoubleCheck.provider(
              new SwitchingProvider<MasterkeyOptionsController>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  vaultOptionsComponentImpl,
                  5));
      this.mountOptionsControllerProvider =
          DoubleCheck.provider(
              new SwitchingProvider<MountOptionsController>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  vaultOptionsComponentImpl,
                  6));
      this.provideSelectedTabPropertyProvider =
          DoubleCheck.provider(
              new SwitchingProvider<ObjectProperty<SelectedVaultOptionsTab>>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  vaultOptionsComponentImpl,
                  8));
      this.vaultOptionsControllerProvider =
          DoubleCheck.provider(
              new SwitchingProvider<VaultOptionsController>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  vaultOptionsComponentImpl,
                  7));
      this.provideFxmlLoaderFactoryProvider =
          DoubleCheck.provider(
              new SwitchingProvider<FxmlLoaderFactory>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  vaultOptionsComponentImpl,
                  1));
      this.provideVaultOptionsSceneProvider =
          DoubleCheck.provider(
              new SwitchingProvider<Scene>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  vaultOptionsComponentImpl,
                  0));
    }

    @Override
    public Lazy<Scene> scene() {
      return DoubleCheck.lazy(provideVaultOptionsSceneProvider);
    }

    @Override
    public ObjectProperty<SelectedVaultOptionsTab> selectedTabProperty() {
      return provideSelectedTabPropertyProvider.get();
    }

    @Override
    public Stage window() {
      return provideStageProvider.get();
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final CryptomatorComponentImpl cryptomatorComponentImpl;

      private final FxApplicationComponentImpl fxApplicationComponentImpl;

      private final VaultOptionsComponentImpl vaultOptionsComponentImpl;

      private final int id;

      SwitchingProvider(
          CryptomatorComponentImpl cryptomatorComponentImpl,
          FxApplicationComponentImpl fxApplicationComponentImpl,
          VaultOptionsComponentImpl vaultOptionsComponentImpl,
          int id) {
        this.cryptomatorComponentImpl = cryptomatorComponentImpl;
        this.fxApplicationComponentImpl = fxApplicationComponentImpl;
        this.vaultOptionsComponentImpl = vaultOptionsComponentImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // @org.cryptomator.ui.common.FxmlScene(VAULT_OPTIONS) javafx.scene.Scene
            return (T)
                VaultOptionsModule_ProvideVaultOptionsSceneFactory.provideVaultOptionsScene(
                    vaultOptionsComponentImpl.provideFxmlLoaderFactoryProvider.get());

          case 1: // @org.cryptomator.ui.vaultoptions.VaultOptionsWindow
                  // org.cryptomator.ui.common.FxmlLoaderFactory
            return (T)
                VaultOptionsModule_ProvideFxmlLoaderFactoryFactory.provideFxmlLoaderFactory(
                    vaultOptionsComponentImpl.mapOfClassOfAndProviderOfFxController(),
                    fxApplicationComponentImpl.defaultSceneFactoryProvider.get(),
                    cryptomatorComponentImpl.provideLocalizationProvider.get());

          case 2: // org.cryptomator.ui.vaultoptions.GeneralVaultOptionsController
            return (T)
                GeneralVaultOptionsController_Factory.newInstance(
                    vaultOptionsComponentImpl.provideStageProvider.get(),
                    vaultOptionsComponentImpl.arg0,
                    new HealthCheckComponentBuilder(
                        cryptomatorComponentImpl, fxApplicationComponentImpl),
                    cryptomatorComponentImpl.provideLocalizationProvider.get());

          case 3: // @org.cryptomator.ui.vaultoptions.VaultOptionsWindow javafx.stage.Stage
            return (T)
                VaultOptionsModule_ProvideStageFactory.provideStage(
                    fxApplicationComponentImpl.stageFactoryProvider.get(),
                    fxApplicationComponentImpl.primaryStage,
                    vaultOptionsComponentImpl.arg0);

          case 4: // org.cryptomator.ui.vaultoptions.HubOptionsController
            return (T)
                new HubOptionsController(
                    vaultOptionsComponentImpl.arg0,
                    vaultOptionsComponentImpl.provideStageProvider.get(),
                    new ConvertVaultComponentFactory(
                        cryptomatorComponentImpl,
                        fxApplicationComponentImpl,
                        vaultOptionsComponentImpl));

          case 5: // org.cryptomator.ui.vaultoptions.MasterkeyOptionsController
            return (T)
                MasterkeyOptionsController_Factory.newInstance(
                    vaultOptionsComponentImpl.arg0,
                    vaultOptionsComponentImpl.provideStageProvider.get(),
                    new ChangePasswordComponentBuilder(
                        cryptomatorComponentImpl,
                        fxApplicationComponentImpl,
                        vaultOptionsComponentImpl),
                    new RecoveryKeyComponentFactory(
                        cryptomatorComponentImpl,
                        fxApplicationComponentImpl,
                        vaultOptionsComponentImpl),
                    new ocuf2_ForgetPasswordComponentBuilder(
                        cryptomatorComponentImpl,
                        fxApplicationComponentImpl,
                        vaultOptionsComponentImpl),
                    cryptomatorComponentImpl.keychainManagerProvider.get());

          case 6: // org.cryptomator.ui.vaultoptions.MountOptionsController
            return (T)
                MountOptionsController_Factory.newInstance(
                    vaultOptionsComponentImpl.provideStageProvider.get(),
                    vaultOptionsComponentImpl.arg0,
                    cryptomatorComponentImpl.windowsDriveLettersProvider.get(),
                    cryptomatorComponentImpl.provideLocalizationProvider.get(),
                    fxApplicationComponentImpl.fxApplicationWindowsProvider.get(),
                    DoubleCheck.lazy(fxApplicationComponentImpl.fxApplicationProvider),
                    cryptomatorComponentImpl.provideSupportedMountServicesProvider.get(),
                    cryptomatorComponentImpl.mounterProvider.get(),
                    cryptomatorComponentImpl.provideDefaultMountServiceProvider.get());

          case 7: // org.cryptomator.ui.vaultoptions.VaultOptionsController
            return (T)
                VaultOptionsController_Factory.newInstance(
                    vaultOptionsComponentImpl.provideStageProvider.get(),
                    vaultOptionsComponentImpl.arg0,
                    vaultOptionsComponentImpl.provideSelectedTabPropertyProvider.get());

          case 8: // javafx.beans.property.ObjectProperty<org.cryptomator.ui.vaultoptions.SelectedVaultOptionsTab>
            return (T)
                VaultOptionsModule_ProvideSelectedTabPropertyFactory.provideSelectedTabProperty();

          default:
            throw new AssertionError(id);
        }
      }
    }
  }

  private static final class ShareVaultComponentImpl implements ShareVaultComponent {
    private final Vault arg0;

    private final CryptomatorComponentImpl cryptomatorComponentImpl;

    private final FxApplicationComponentImpl fxApplicationComponentImpl;

    private final ShareVaultComponentImpl shareVaultComponentImpl = this;

    private Provider<Stage> provideStageProvider;

    private Provider<ShareVaultController> shareVaultControllerProvider;

    private Provider<FxmlLoaderFactory> provideFxmlLoaderFactoryProvider;

    private Provider<Scene> provideShareVaultSceneProvider;

    private ShareVaultComponentImpl(
        CryptomatorComponentImpl cryptomatorComponentImpl,
        FxApplicationComponentImpl fxApplicationComponentImpl,
        Vault arg0Param) {
      this.cryptomatorComponentImpl = cryptomatorComponentImpl;
      this.fxApplicationComponentImpl = fxApplicationComponentImpl;
      this.arg0 = arg0Param;
      initialize(arg0Param);
    }

    private Map<Class<? extends FxController>, javax.inject.Provider<FxController>>
        mapOfClassOfAndProviderOfFxController() {
      return ImmutableMap.<Class<? extends FxController>, javax.inject.Provider<FxController>>of(
          ShareVaultController.class, ((Provider) shareVaultControllerProvider));
    }

    @SuppressWarnings("unchecked")
    private void initialize(final Vault arg0Param) {
      this.provideStageProvider =
          DoubleCheck.provider(
              new SwitchingProvider<Stage>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  shareVaultComponentImpl,
                  3));
      this.shareVaultControllerProvider =
          DoubleCheck.provider(
              new SwitchingProvider<ShareVaultController>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  shareVaultComponentImpl,
                  2));
      this.provideFxmlLoaderFactoryProvider =
          DoubleCheck.provider(
              new SwitchingProvider<FxmlLoaderFactory>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  shareVaultComponentImpl,
                  1));
      this.provideShareVaultSceneProvider =
          DoubleCheck.provider(
              new SwitchingProvider<Scene>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  shareVaultComponentImpl,
                  0));
    }

    @Override
    public Lazy<Scene> scene() {
      return DoubleCheck.lazy(provideShareVaultSceneProvider);
    }

    @Override
    public Stage window() {
      return provideStageProvider.get();
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final CryptomatorComponentImpl cryptomatorComponentImpl;

      private final FxApplicationComponentImpl fxApplicationComponentImpl;

      private final ShareVaultComponentImpl shareVaultComponentImpl;

      private final int id;

      SwitchingProvider(
          CryptomatorComponentImpl cryptomatorComponentImpl,
          FxApplicationComponentImpl fxApplicationComponentImpl,
          ShareVaultComponentImpl shareVaultComponentImpl,
          int id) {
        this.cryptomatorComponentImpl = cryptomatorComponentImpl;
        this.fxApplicationComponentImpl = fxApplicationComponentImpl;
        this.shareVaultComponentImpl = shareVaultComponentImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // @org.cryptomator.ui.common.FxmlScene(SHARE_VAULT) javafx.scene.Scene
            return (T)
                ShareVaultModule_ProvideShareVaultSceneFactory.provideShareVaultScene(
                    shareVaultComponentImpl.provideFxmlLoaderFactoryProvider.get());

          case 1: // @org.cryptomator.ui.sharevault.ShareVaultWindow
                  // org.cryptomator.ui.common.FxmlLoaderFactory
            return (T)
                ShareVaultModule_ProvideFxmlLoaderFactoryFactory.provideFxmlLoaderFactory(
                    shareVaultComponentImpl.mapOfClassOfAndProviderOfFxController(),
                    fxApplicationComponentImpl.defaultSceneFactoryProvider.get(),
                    cryptomatorComponentImpl.provideLocalizationProvider.get());

          case 2: // org.cryptomator.ui.sharevault.ShareVaultController
            return (T)
                ShareVaultController_Factory.newInstance(
                    shareVaultComponentImpl.provideStageProvider.get(),
                    DoubleCheck.lazy(fxApplicationComponentImpl.fxApplicationProvider),
                    shareVaultComponentImpl.arg0);

          case 3: // @org.cryptomator.ui.sharevault.ShareVaultWindow javafx.stage.Stage
            return (T)
                ShareVaultModule_ProvideStageFactory.provideStage(
                    fxApplicationComponentImpl.stageFactoryProvider.get(),
                    cryptomatorComponentImpl.provideLocalizationProvider.get());

          default:
            throw new AssertionError(id);
        }
      }
    }
  }

  private static final class TrayMenuComponentImpl implements TrayMenuComponent {
    private final CryptomatorComponentImpl cryptomatorComponentImpl;

    private final FxApplicationComponentImpl fxApplicationComponentImpl;

    private final TrayMenuComponentImpl trayMenuComponentImpl = this;

    private Provider<Optional<TrayMenuController>> provideFirstSupportedTrayMenuControllerProvider;

    private Provider<TrayMenuBuilder> trayMenuBuilderProvider;

    private TrayMenuComponentImpl(
        CryptomatorComponentImpl cryptomatorComponentImpl,
        FxApplicationComponentImpl fxApplicationComponentImpl) {
      this.cryptomatorComponentImpl = cryptomatorComponentImpl;
      this.fxApplicationComponentImpl = fxApplicationComponentImpl;

      initialize();
    }

    @SuppressWarnings("unchecked")
    private void initialize() {
      this.provideFirstSupportedTrayMenuControllerProvider =
          DoubleCheck.provider(
              new SwitchingProvider<Optional<TrayMenuController>>(
                  cryptomatorComponentImpl, fxApplicationComponentImpl, trayMenuComponentImpl, 1));
      this.trayMenuBuilderProvider =
          DoubleCheck.provider(
              new SwitchingProvider<TrayMenuBuilder>(
                  cryptomatorComponentImpl, fxApplicationComponentImpl, trayMenuComponentImpl, 0));
    }

    @Override
    public TrayMenuBuilder trayMenuBuilder() {
      return trayMenuBuilderProvider.get();
    }

    @Override
    public Optional<TrayMenuController> trayMenuController() {
      return provideFirstSupportedTrayMenuControllerProvider.get();
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final CryptomatorComponentImpl cryptomatorComponentImpl;

      private final FxApplicationComponentImpl fxApplicationComponentImpl;

      private final TrayMenuComponentImpl trayMenuComponentImpl;

      private final int id;

      SwitchingProvider(
          CryptomatorComponentImpl cryptomatorComponentImpl,
          FxApplicationComponentImpl fxApplicationComponentImpl,
          TrayMenuComponentImpl trayMenuComponentImpl,
          int id) {
        this.cryptomatorComponentImpl = cryptomatorComponentImpl;
        this.fxApplicationComponentImpl = fxApplicationComponentImpl;
        this.trayMenuComponentImpl = trayMenuComponentImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // org.cryptomator.ui.traymenu.TrayMenuBuilder
            return (T)
                TrayMenuBuilder_Factory.newInstance(
                    cryptomatorComponentImpl.provideLocalizationProvider.get(),
                    fxApplicationComponentImpl.vaultServiceProvider.get(),
                    fxApplicationComponentImpl.fxApplicationWindowsProvider.get(),
                    fxApplicationComponentImpl.fxApplicationTerminatorProvider.get(),
                    cryptomatorComponentImpl.provideVaultListProvider.get(),
                    trayMenuComponentImpl.provideFirstSupportedTrayMenuControllerProvider.get());

          case 1: // java.util.Optional<org.cryptomator.integrations.tray.TrayMenuController>
            return (T)
                TrayMenuModule_ProvideFirstSupportedTrayMenuControllerFactory
                    .provideFirstSupportedTrayMenuController();

          default:
            throw new AssertionError(id);
        }
      }
    }
  }

  private static final class ocukm2_PassphraseEntryComponentImpl
      implements PassphraseEntryComponent {
    private final Passphrase savedPassword;

    private final CryptomatorComponentImpl cryptomatorComponentImpl;

    private final FxApplicationComponentImpl fxApplicationComponentImpl;

    private final HealthCheckComponentImpl healthCheckComponentImpl;

    private final ocuk2_KeyLoadingComponentImpl _ocuk2_KeyLoadingComponentImpl;

    private final ocukm2_PassphraseEntryComponentImpl _ocukm2_PassphraseEntryComponentImpl = this;

    private Provider<CompletableFuture<PassphraseEntryResult>> provideResultProvider;

    private Provider<PassphraseEntryController> passphraseEntryControllerProvider;

    private Provider<Scene> provideUnlockSceneProvider;

    private ocukm2_PassphraseEntryComponentImpl(
        CryptomatorComponentImpl cryptomatorComponentImpl,
        FxApplicationComponentImpl fxApplicationComponentImpl,
        HealthCheckComponentImpl healthCheckComponentImpl,
        ocuk2_KeyLoadingComponentImpl _ocuk2_KeyLoadingComponentImpl,
        Passphrase savedPasswordParam) {
      this.cryptomatorComponentImpl = cryptomatorComponentImpl;
      this.fxApplicationComponentImpl = fxApplicationComponentImpl;
      this.healthCheckComponentImpl = healthCheckComponentImpl;
      this._ocuk2_KeyLoadingComponentImpl = _ocuk2_KeyLoadingComponentImpl;
      this.savedPassword = savedPasswordParam;
      initialize(savedPasswordParam);
    }

    @SuppressWarnings("unchecked")
    private void initialize(final Passphrase savedPasswordParam) {
      this.provideResultProvider =
          DoubleCheck.provider(
              new SwitchingProvider<CompletableFuture<PassphraseEntryResult>>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  healthCheckComponentImpl,
                  _ocuk2_KeyLoadingComponentImpl,
                  _ocukm2_PassphraseEntryComponentImpl,
                  2));
      this.passphraseEntryControllerProvider =
          DoubleCheck.provider(
              new SwitchingProvider<PassphraseEntryController>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  healthCheckComponentImpl,
                  _ocuk2_KeyLoadingComponentImpl,
                  _ocukm2_PassphraseEntryComponentImpl,
                  1));
      this.provideUnlockSceneProvider =
          DoubleCheck.provider(
              new SwitchingProvider<Scene>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  healthCheckComponentImpl,
                  _ocuk2_KeyLoadingComponentImpl,
                  _ocukm2_PassphraseEntryComponentImpl,
                  0));
    }

    @Override
    public Scene passphraseEntryScene() {
      return provideUnlockSceneProvider.get();
    }

    @Override
    public CompletableFuture<PassphraseEntryResult> result() {
      return provideResultProvider.get();
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final CryptomatorComponentImpl cryptomatorComponentImpl;

      private final FxApplicationComponentImpl fxApplicationComponentImpl;

      private final HealthCheckComponentImpl healthCheckComponentImpl;

      private final ocuk2_KeyLoadingComponentImpl _ocuk2_KeyLoadingComponentImpl;

      private final ocukm2_PassphraseEntryComponentImpl _ocukm2_PassphraseEntryComponentImpl;

      private final int id;

      SwitchingProvider(
          CryptomatorComponentImpl cryptomatorComponentImpl,
          FxApplicationComponentImpl fxApplicationComponentImpl,
          HealthCheckComponentImpl healthCheckComponentImpl,
          ocuk2_KeyLoadingComponentImpl _ocuk2_KeyLoadingComponentImpl,
          ocukm2_PassphraseEntryComponentImpl _ocukm2_PassphraseEntryComponentImpl,
          int id) {
        this.cryptomatorComponentImpl = cryptomatorComponentImpl;
        this.fxApplicationComponentImpl = fxApplicationComponentImpl;
        this.healthCheckComponentImpl = healthCheckComponentImpl;
        this._ocuk2_KeyLoadingComponentImpl = _ocuk2_KeyLoadingComponentImpl;
        this._ocukm2_PassphraseEntryComponentImpl = _ocukm2_PassphraseEntryComponentImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // javafx.scene.Scene
            return (T)
                PassphraseEntryModule_ProvideUnlockSceneFactory.provideUnlockScene(
                    _ocukm2_PassphraseEntryComponentImpl.passphraseEntryControllerProvider.get(),
                    fxApplicationComponentImpl.defaultSceneFactoryProvider.get(),
                    cryptomatorComponentImpl.provideLocalizationProvider.get());

          case 1: // org.cryptomator.ui.keyloading.masterkeyfile.PassphraseEntryController
            return (T)
                new PassphraseEntryController(
                    _ocuk2_KeyLoadingComponentImpl.window,
                    _ocuk2_KeyLoadingComponentImpl.vault,
                    _ocukm2_PassphraseEntryComponentImpl.provideResultProvider.get(),
                    _ocukm2_PassphraseEntryComponentImpl.savedPassword,
                    new ocuf3_ForgetPasswordComponentBuilder(
                        cryptomatorComponentImpl,
                        fxApplicationComponentImpl,
                        healthCheckComponentImpl,
                        _ocuk2_KeyLoadingComponentImpl),
                    cryptomatorComponentImpl.keychainManagerProvider.get());

          case 2: // java.util.concurrent.CompletableFuture<org.cryptomator.ui.keyloading.masterkeyfile.PassphraseEntryResult>
            return (T) PassphraseEntryModule_ProvideResultFactory.provideResult();

          default:
            throw new AssertionError(id);
        }
      }
    }
  }

  private static final class ocukm2_ChooseMasterkeyFileComponentImpl
      implements ChooseMasterkeyFileComponent {
    private final CryptomatorComponentImpl cryptomatorComponentImpl;

    private final FxApplicationComponentImpl fxApplicationComponentImpl;

    private final HealthCheckComponentImpl healthCheckComponentImpl;

    private final ocuk2_KeyLoadingComponentImpl _ocuk2_KeyLoadingComponentImpl;

    private final ocukm2_ChooseMasterkeyFileComponentImpl _ocukm2_ChooseMasterkeyFileComponentImpl =
        this;

    private Provider<CompletableFuture<Path>> provideResultProvider;

    private Provider<ChooseMasterkeyFileController> chooseMasterkeyFileControllerProvider;

    private Provider<Scene> provideChooseMasterkeySceneProvider;

    private ocukm2_ChooseMasterkeyFileComponentImpl(
        CryptomatorComponentImpl cryptomatorComponentImpl,
        FxApplicationComponentImpl fxApplicationComponentImpl,
        HealthCheckComponentImpl healthCheckComponentImpl,
        ocuk2_KeyLoadingComponentImpl _ocuk2_KeyLoadingComponentImpl) {
      this.cryptomatorComponentImpl = cryptomatorComponentImpl;
      this.fxApplicationComponentImpl = fxApplicationComponentImpl;
      this.healthCheckComponentImpl = healthCheckComponentImpl;
      this._ocuk2_KeyLoadingComponentImpl = _ocuk2_KeyLoadingComponentImpl;

      initialize();
    }

    @SuppressWarnings("unchecked")
    private void initialize() {
      this.provideResultProvider =
          DoubleCheck.provider(
              new SwitchingProvider<CompletableFuture<Path>>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  healthCheckComponentImpl,
                  _ocuk2_KeyLoadingComponentImpl,
                  _ocukm2_ChooseMasterkeyFileComponentImpl,
                  2));
      this.chooseMasterkeyFileControllerProvider =
          DoubleCheck.provider(
              new SwitchingProvider<ChooseMasterkeyFileController>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  healthCheckComponentImpl,
                  _ocuk2_KeyLoadingComponentImpl,
                  _ocukm2_ChooseMasterkeyFileComponentImpl,
                  1));
      this.provideChooseMasterkeySceneProvider =
          DoubleCheck.provider(
              new SwitchingProvider<Scene>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  healthCheckComponentImpl,
                  _ocuk2_KeyLoadingComponentImpl,
                  _ocukm2_ChooseMasterkeyFileComponentImpl,
                  0));
    }

    @Override
    public Scene chooseMasterkeyScene() {
      return provideChooseMasterkeySceneProvider.get();
    }

    @Override
    public CompletableFuture<Path> result() {
      return provideResultProvider.get();
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final CryptomatorComponentImpl cryptomatorComponentImpl;

      private final FxApplicationComponentImpl fxApplicationComponentImpl;

      private final HealthCheckComponentImpl healthCheckComponentImpl;

      private final ocuk2_KeyLoadingComponentImpl _ocuk2_KeyLoadingComponentImpl;

      private final ocukm2_ChooseMasterkeyFileComponentImpl
          _ocukm2_ChooseMasterkeyFileComponentImpl;

      private final int id;

      SwitchingProvider(
          CryptomatorComponentImpl cryptomatorComponentImpl,
          FxApplicationComponentImpl fxApplicationComponentImpl,
          HealthCheckComponentImpl healthCheckComponentImpl,
          ocuk2_KeyLoadingComponentImpl _ocuk2_KeyLoadingComponentImpl,
          ocukm2_ChooseMasterkeyFileComponentImpl _ocukm2_ChooseMasterkeyFileComponentImpl,
          int id) {
        this.cryptomatorComponentImpl = cryptomatorComponentImpl;
        this.fxApplicationComponentImpl = fxApplicationComponentImpl;
        this.healthCheckComponentImpl = healthCheckComponentImpl;
        this._ocuk2_KeyLoadingComponentImpl = _ocuk2_KeyLoadingComponentImpl;
        this._ocukm2_ChooseMasterkeyFileComponentImpl = _ocukm2_ChooseMasterkeyFileComponentImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // javafx.scene.Scene
            return (T)
                ChooseMasterkeyFileModule_ProvideChooseMasterkeySceneFactory
                    .provideChooseMasterkeyScene(
                        _ocukm2_ChooseMasterkeyFileComponentImpl
                            .chooseMasterkeyFileControllerProvider.get(),
                        fxApplicationComponentImpl.defaultSceneFactoryProvider.get(),
                        cryptomatorComponentImpl.provideLocalizationProvider.get());

          case 1: // org.cryptomator.ui.keyloading.masterkeyfile.ChooseMasterkeyFileController
            return (T)
                new ChooseMasterkeyFileController(
                    _ocuk2_KeyLoadingComponentImpl.window,
                    _ocuk2_KeyLoadingComponentImpl.vault,
                    _ocukm2_ChooseMasterkeyFileComponentImpl.provideResultProvider.get(),
                    cryptomatorComponentImpl.provideLocalizationProvider.get());

          case 2: // java.util.concurrent.CompletableFuture<java.nio.file.Path>
            return (T) ChooseMasterkeyFileModule_ProvideResultFactory.provideResult();

          default:
            throw new AssertionError(id);
        }
      }
    }
  }

  private static final class ocuf3_ForgetPasswordComponentImpl implements ForgetPasswordComponent {
    private final Stage owner;

    private final Vault vault;

    private final CryptomatorComponentImpl cryptomatorComponentImpl;

    private final FxApplicationComponentImpl fxApplicationComponentImpl;

    private final HealthCheckComponentImpl healthCheckComponentImpl;

    private final ocuk2_KeyLoadingComponentImpl _ocuk2_KeyLoadingComponentImpl;

    private final ocuf3_ForgetPasswordComponentImpl _ocuf3_ForgetPasswordComponentImpl = this;

    private Provider<BooleanProperty> provideConfirmedPropertyProvider;

    private Provider<Stage> provideStageProvider;

    private Provider<ForgetPasswordController> forgetPasswordControllerProvider;

    private Provider<FxmlLoaderFactory> provideFxmlLoaderFactoryProvider;

    private Provider<Scene> provideForgetPasswordSceneProvider;

    private ocuf3_ForgetPasswordComponentImpl(
        CryptomatorComponentImpl cryptomatorComponentImpl,
        FxApplicationComponentImpl fxApplicationComponentImpl,
        HealthCheckComponentImpl healthCheckComponentImpl,
        ocuk2_KeyLoadingComponentImpl _ocuk2_KeyLoadingComponentImpl,
        Stage ownerParam,
        Vault vaultParam) {
      this.cryptomatorComponentImpl = cryptomatorComponentImpl;
      this.fxApplicationComponentImpl = fxApplicationComponentImpl;
      this.healthCheckComponentImpl = healthCheckComponentImpl;
      this._ocuk2_KeyLoadingComponentImpl = _ocuk2_KeyLoadingComponentImpl;
      this.owner = ownerParam;
      this.vault = vaultParam;
      initialize(ownerParam, vaultParam);
    }

    private Map<Class<? extends FxController>, javax.inject.Provider<FxController>>
        mapOfClassOfAndProviderOfFxController() {
      return ImmutableMap
          .<Class<? extends FxController>, javax.inject.Provider<FxController>>
              builderWithExpectedSize(17)
          .put(
              CheckListController.class,
              ((Provider) healthCheckComponentImpl.checkListControllerProvider))
          .put(
              CheckDetailController.class,
              ((Provider) healthCheckComponentImpl.checkDetailControllerProvider))
          .put(
              CheckListCellController.class,
              ((Provider) healthCheckComponentImpl.checkListCellControllerProvider))
          .put(
              ResultListCellController.class,
              ((Provider) healthCheckComponentImpl.resultListCellControllerProvider))
          .put(StartController.class, ((Provider) healthCheckComponentImpl.startControllerProvider))
          .put(
              AuthFlowController.class,
              ((Provider) _ocuk2_KeyLoadingComponentImpl.authFlowControllerProvider))
          .put(
              InvalidLicenseController.class,
              ((Provider) _ocuk2_KeyLoadingComponentImpl.invalidLicenseControllerProvider))
          .put(
              LegacyRegisterDeviceController.class,
              ((Provider) _ocuk2_KeyLoadingComponentImpl.legacyRegisterDeviceControllerProvider))
          .put(
              LegacyRegisterSuccessController.class,
              ((Provider) _ocuk2_KeyLoadingComponentImpl.legacyRegisterSuccessControllerProvider))
          .put(
              NoKeychainController.class,
              ((Provider) _ocuk2_KeyLoadingComponentImpl.noKeychainControllerProvider))
          .put(
              ReceiveKeyController.class,
              ((Provider) _ocuk2_KeyLoadingComponentImpl.receiveKeyControllerProvider))
          .put(
              RegisterDeviceController.class,
              ((Provider) _ocuk2_KeyLoadingComponentImpl.registerDeviceControllerProvider))
          .put(
              RegisterFailedController.class,
              ((Provider) _ocuk2_KeyLoadingComponentImpl.registerFailedControllerProvider))
          .put(
              RegisterSuccessController.class,
              ((Provider) _ocuk2_KeyLoadingComponentImpl.registerSuccessControllerProvider))
          .put(
              RequireAccountInitController.class,
              ((Provider) _ocuk2_KeyLoadingComponentImpl.requireAccountInitControllerProvider))
          .put(
              UnauthorizedDeviceController.class,
              ((Provider) _ocuk2_KeyLoadingComponentImpl.unauthorizedDeviceControllerProvider))
          .put(ForgetPasswordController.class, ((Provider) forgetPasswordControllerProvider))
          .build();
    }

    @SuppressWarnings("unchecked")
    private void initialize(final Stage ownerParam, final Vault vaultParam) {
      this.provideConfirmedPropertyProvider =
          DoubleCheck.provider(
              new SwitchingProvider<BooleanProperty>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  healthCheckComponentImpl,
                  _ocuk2_KeyLoadingComponentImpl,
                  _ocuf3_ForgetPasswordComponentImpl,
                  0));
      this.provideStageProvider =
          DoubleCheck.provider(
              new SwitchingProvider<Stage>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  healthCheckComponentImpl,
                  _ocuk2_KeyLoadingComponentImpl,
                  _ocuf3_ForgetPasswordComponentImpl,
                  4));
      this.forgetPasswordControllerProvider =
          DoubleCheck.provider(
              new SwitchingProvider<ForgetPasswordController>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  healthCheckComponentImpl,
                  _ocuk2_KeyLoadingComponentImpl,
                  _ocuf3_ForgetPasswordComponentImpl,
                  3));
      this.provideFxmlLoaderFactoryProvider =
          DoubleCheck.provider(
              new SwitchingProvider<FxmlLoaderFactory>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  healthCheckComponentImpl,
                  _ocuk2_KeyLoadingComponentImpl,
                  _ocuf3_ForgetPasswordComponentImpl,
                  2));
      this.provideForgetPasswordSceneProvider =
          DoubleCheck.provider(
              new SwitchingProvider<Scene>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  healthCheckComponentImpl,
                  _ocuk2_KeyLoadingComponentImpl,
                  _ocuf3_ForgetPasswordComponentImpl,
                  1));
    }

    @Override
    public ReadOnlyBooleanProperty confirmedProperty() {
      return provideConfirmedPropertyProvider.get();
    }

    @Override
    public Lazy<Scene> scene() {
      return DoubleCheck.lazy(provideForgetPasswordSceneProvider);
    }

    @Override
    public Stage window() {
      return provideStageProvider.get();
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final CryptomatorComponentImpl cryptomatorComponentImpl;

      private final FxApplicationComponentImpl fxApplicationComponentImpl;

      private final HealthCheckComponentImpl healthCheckComponentImpl;

      private final ocuk2_KeyLoadingComponentImpl _ocuk2_KeyLoadingComponentImpl;

      private final ocuf3_ForgetPasswordComponentImpl _ocuf3_ForgetPasswordComponentImpl;

      private final int id;

      SwitchingProvider(
          CryptomatorComponentImpl cryptomatorComponentImpl,
          FxApplicationComponentImpl fxApplicationComponentImpl,
          HealthCheckComponentImpl healthCheckComponentImpl,
          ocuk2_KeyLoadingComponentImpl _ocuk2_KeyLoadingComponentImpl,
          ocuf3_ForgetPasswordComponentImpl _ocuf3_ForgetPasswordComponentImpl,
          int id) {
        this.cryptomatorComponentImpl = cryptomatorComponentImpl;
        this.fxApplicationComponentImpl = fxApplicationComponentImpl;
        this.healthCheckComponentImpl = healthCheckComponentImpl;
        this._ocuk2_KeyLoadingComponentImpl = _ocuk2_KeyLoadingComponentImpl;
        this._ocuf3_ForgetPasswordComponentImpl = _ocuf3_ForgetPasswordComponentImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // @org.cryptomator.ui.forgetpassword.ForgetPasswordWindow
                  // javafx.beans.property.BooleanProperty
            return (T)
                ForgetPasswordModule_ProvideConfirmedPropertyFactory.provideConfirmedProperty();

          case 1: // @org.cryptomator.ui.common.FxmlScene(FORGET_PASSWORD) javafx.scene.Scene
            return (T)
                ForgetPasswordModule_ProvideForgetPasswordSceneFactory.provideForgetPasswordScene(
                    _ocuf3_ForgetPasswordComponentImpl.provideFxmlLoaderFactoryProvider.get());

          case 2: // @org.cryptomator.ui.forgetpassword.ForgetPasswordWindow
                  // org.cryptomator.ui.common.FxmlLoaderFactory
            return (T)
                ForgetPasswordModule_ProvideFxmlLoaderFactoryFactory.provideFxmlLoaderFactory(
                    _ocuf3_ForgetPasswordComponentImpl.mapOfClassOfAndProviderOfFxController(),
                    fxApplicationComponentImpl.defaultSceneFactoryProvider.get(),
                    cryptomatorComponentImpl.provideLocalizationProvider.get());

          case 3: // org.cryptomator.ui.forgetpassword.ForgetPasswordController
            return (T)
                new ForgetPasswordController(
                    _ocuf3_ForgetPasswordComponentImpl.provideStageProvider.get(),
                    _ocuf3_ForgetPasswordComponentImpl.vault,
                    cryptomatorComponentImpl.keychainManagerProvider.get(),
                    _ocuf3_ForgetPasswordComponentImpl.provideConfirmedPropertyProvider.get());

          case 4: // @org.cryptomator.ui.forgetpassword.ForgetPasswordWindow javafx.stage.Stage
            return (T)
                ForgetPasswordModule_ProvideStageFactory.provideStage(
                    fxApplicationComponentImpl.stageFactoryProvider.get(),
                    cryptomatorComponentImpl.provideLocalizationProvider.get(),
                    _ocuf3_ForgetPasswordComponentImpl.owner);

          default:
            throw new AssertionError(id);
        }
      }
    }
  }

  private static final class ocuk2_KeyLoadingComponentImpl implements KeyLoadingComponent {
    private final Vault vault;

    private final Stage window;

    private final CryptomatorComponentImpl cryptomatorComponentImpl;

    private final FxApplicationComponentImpl fxApplicationComponentImpl;

    private final HealthCheckComponentImpl healthCheckComponentImpl;

    private final ocuk2_KeyLoadingComponentImpl _ocuk2_KeyLoadingComponentImpl = this;

    private Provider<Optional<char[]>> provideStoredPasswordProvider;

    private Provider<MasterkeyFileLoadingStrategy> masterkeyFileLoadingStrategyProvider;

    private Provider<KeyLoadingStrategy> bindMasterkeyFileLoadingStrategyProvider;

    private Provider<String> provideDeviceIdProvider;

    private Provider<HubConfig> provideHubConfigProvider;

    private Provider<AtomicReference<String>> provideBearerTokenRefProvider;

    @SuppressWarnings("rawtypes")
    private Provider provideResultProvider;

    private Provider<FxmlLoaderFactory> provideFxmlLoaderFactoryProvider;

    private Provider<Scene> provideHubReceiveKeySceneProvider;

    private Provider<AuthFlowController> authFlowControllerProvider;

    private Provider<InvalidLicenseController> invalidLicenseControllerProvider;

    private Provider<Scene> provideHubLegacyRegisterSuccessSceneProvider;

    private Provider<Scene> provideHubRegisterFailedSceneProvider;

    private Provider<LegacyRegisterDeviceController> legacyRegisterDeviceControllerProvider;

    private Provider<LegacyRegisterSuccessController> legacyRegisterSuccessControllerProvider;

    private Provider<NoKeychainController> noKeychainControllerProvider;

    private Provider<Scene> provideHubRegisterDeviceSceneProvider;

    private Provider<Scene> provideHubLegacyRegisterDeviceSceneProvider;

    private Provider<Scene> provideHubUnauthorizedDeviceSceneProvider;

    private Provider<Scene> provideRequireAccountInitSceneProvider;

    private Provider<Scene> provideInvalidLicenseSceneProvider;

    private Provider<ReceiveKeyController> receiveKeyControllerProvider;

    private Provider<Scene> provideHubRegisterSuccessSceneProvider;

    private Provider<Scene> provideHubRegisterDeviceAlreadyExistsSceneProvider;

    private Provider<RegisterDeviceController> registerDeviceControllerProvider;

    private Provider<RegisterFailedController> registerFailedControllerProvider;

    private Provider<RegisterSuccessController> registerSuccessControllerProvider;

    private Provider<RequireAccountInitController> requireAccountInitControllerProvider;

    private Provider<UnauthorizedDeviceController> unauthorizedDeviceControllerProvider;

    private Provider<Scene> provideHubAuthFlowSceneProvider;

    private Provider<Scene> provideHubNoKeychainSceneProvider;

    private Provider<String> provideWindowTitleProvider;

    private Provider<HubKeyLoadingStrategy> hubKeyLoadingStrategyProvider;

    private Provider<KeyLoadingStrategy> bindHubKeyLoadingStrategyToHubHttpProvider;

    private Provider<KeyLoadingStrategy> bindHubKeyLoadingStrategyToHubHttpsProvider;

    private Provider<KeyLoadingStrategy> provideKeyLoadingStrategyProvider;

    private ocuk2_KeyLoadingComponentImpl(
        CryptomatorComponentImpl cryptomatorComponentImpl,
        FxApplicationComponentImpl fxApplicationComponentImpl,
        HealthCheckComponentImpl healthCheckComponentImpl,
        Vault vaultParam,
        Stage windowParam) {
      this.cryptomatorComponentImpl = cryptomatorComponentImpl;
      this.fxApplicationComponentImpl = fxApplicationComponentImpl;
      this.healthCheckComponentImpl = healthCheckComponentImpl;
      this.vault = vaultParam;
      this.window = windowParam;
      initialize(vaultParam, windowParam);
    }

    private Map<Class<? extends FxController>, javax.inject.Provider<FxController>>
        mapOfClassOfAndProviderOfFxController() {
      return ImmutableMap
          .<Class<? extends FxController>, javax.inject.Provider<FxController>>
              builderWithExpectedSize(16)
          .put(
              CheckListController.class,
              ((Provider) healthCheckComponentImpl.checkListControllerProvider))
          .put(
              CheckDetailController.class,
              ((Provider) healthCheckComponentImpl.checkDetailControllerProvider))
          .put(
              CheckListCellController.class,
              ((Provider) healthCheckComponentImpl.checkListCellControllerProvider))
          .put(
              ResultListCellController.class,
              ((Provider) healthCheckComponentImpl.resultListCellControllerProvider))
          .put(StartController.class, ((Provider) healthCheckComponentImpl.startControllerProvider))
          .put(AuthFlowController.class, ((Provider) authFlowControllerProvider))
          .put(InvalidLicenseController.class, ((Provider) invalidLicenseControllerProvider))
          .put(
              LegacyRegisterDeviceController.class,
              ((Provider) legacyRegisterDeviceControllerProvider))
          .put(
              LegacyRegisterSuccessController.class,
              ((Provider) legacyRegisterSuccessControllerProvider))
          .put(NoKeychainController.class, ((Provider) noKeychainControllerProvider))
          .put(ReceiveKeyController.class, ((Provider) receiveKeyControllerProvider))
          .put(RegisterDeviceController.class, ((Provider) registerDeviceControllerProvider))
          .put(RegisterFailedController.class, ((Provider) registerFailedControllerProvider))
          .put(RegisterSuccessController.class, ((Provider) registerSuccessControllerProvider))
          .put(
              RequireAccountInitController.class, ((Provider) requireAccountInitControllerProvider))
          .put(
              UnauthorizedDeviceController.class, ((Provider) unauthorizedDeviceControllerProvider))
          .build();
    }

    private Map<String, javax.inject.Provider<KeyLoadingStrategy>>
        mapOfStringAndProviderOfKeyLoadingStrategy() {
      return ImmutableMap.<String, javax.inject.Provider<KeyLoadingStrategy>>of(
          "masterkeyfile",
          bindMasterkeyFileLoadingStrategyProvider,
          "hub+http",
          bindHubKeyLoadingStrategyToHubHttpProvider,
          "hub+https",
          bindHubKeyLoadingStrategyToHubHttpsProvider);
    }

    @SuppressWarnings("unchecked")
    private void initialize(final Vault vaultParam, final Stage windowParam) {
      this.provideStoredPasswordProvider =
          DoubleCheck.provider(
              new SwitchingProvider<Optional<char[]>>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  healthCheckComponentImpl,
                  _ocuk2_KeyLoadingComponentImpl,
                  2));
      this.masterkeyFileLoadingStrategyProvider =
          new SwitchingProvider<>(
              cryptomatorComponentImpl,
              fxApplicationComponentImpl,
              healthCheckComponentImpl,
              _ocuk2_KeyLoadingComponentImpl,
              1);
      this.bindMasterkeyFileLoadingStrategyProvider =
          DoubleCheck.provider((Provider) masterkeyFileLoadingStrategyProvider);
      this.provideDeviceIdProvider =
          DoubleCheck.provider(
              new SwitchingProvider<String>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  healthCheckComponentImpl,
                  _ocuk2_KeyLoadingComponentImpl,
                  7));
      this.provideHubConfigProvider =
          DoubleCheck.provider(
              new SwitchingProvider<HubConfig>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  healthCheckComponentImpl,
                  _ocuk2_KeyLoadingComponentImpl,
                  8));
      this.provideBearerTokenRefProvider =
          DoubleCheck.provider(
              new SwitchingProvider<AtomicReference<String>>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  healthCheckComponentImpl,
                  _ocuk2_KeyLoadingComponentImpl,
                  9));
      this.provideResultProvider =
          DoubleCheck.provider(
              new SwitchingProvider<CompletableFuture>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  healthCheckComponentImpl,
                  _ocuk2_KeyLoadingComponentImpl,
                  10));
      this.provideFxmlLoaderFactoryProvider = new DelegateFactory<>();
      this.provideHubReceiveKeySceneProvider =
          DoubleCheck.provider(
              new SwitchingProvider<Scene>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  healthCheckComponentImpl,
                  _ocuk2_KeyLoadingComponentImpl,
                  11));
      this.authFlowControllerProvider =
          DoubleCheck.provider(
              new SwitchingProvider<AuthFlowController>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  healthCheckComponentImpl,
                  _ocuk2_KeyLoadingComponentImpl,
                  6));
      this.invalidLicenseControllerProvider =
          new SwitchingProvider<>(
              cryptomatorComponentImpl,
              fxApplicationComponentImpl,
              healthCheckComponentImpl,
              _ocuk2_KeyLoadingComponentImpl,
              12);
      this.provideHubLegacyRegisterSuccessSceneProvider =
          DoubleCheck.provider(
              new SwitchingProvider<Scene>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  healthCheckComponentImpl,
                  _ocuk2_KeyLoadingComponentImpl,
                  14));
      this.provideHubRegisterFailedSceneProvider =
          DoubleCheck.provider(
              new SwitchingProvider<Scene>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  healthCheckComponentImpl,
                  _ocuk2_KeyLoadingComponentImpl,
                  15));
      this.legacyRegisterDeviceControllerProvider =
          DoubleCheck.provider(
              new SwitchingProvider<LegacyRegisterDeviceController>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  healthCheckComponentImpl,
                  _ocuk2_KeyLoadingComponentImpl,
                  13));
      this.legacyRegisterSuccessControllerProvider =
          DoubleCheck.provider(
              new SwitchingProvider<LegacyRegisterSuccessController>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  healthCheckComponentImpl,
                  _ocuk2_KeyLoadingComponentImpl,
                  16));
      this.noKeychainControllerProvider =
          new SwitchingProvider<>(
              cryptomatorComponentImpl,
              fxApplicationComponentImpl,
              healthCheckComponentImpl,
              _ocuk2_KeyLoadingComponentImpl,
              17);
      this.provideHubRegisterDeviceSceneProvider =
          DoubleCheck.provider(
              new SwitchingProvider<Scene>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  healthCheckComponentImpl,
                  _ocuk2_KeyLoadingComponentImpl,
                  19));
      this.provideHubLegacyRegisterDeviceSceneProvider =
          DoubleCheck.provider(
              new SwitchingProvider<Scene>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  healthCheckComponentImpl,
                  _ocuk2_KeyLoadingComponentImpl,
                  20));
      this.provideHubUnauthorizedDeviceSceneProvider =
          DoubleCheck.provider(
              new SwitchingProvider<Scene>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  healthCheckComponentImpl,
                  _ocuk2_KeyLoadingComponentImpl,
                  21));
      this.provideRequireAccountInitSceneProvider =
          DoubleCheck.provider(
              new SwitchingProvider<Scene>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  healthCheckComponentImpl,
                  _ocuk2_KeyLoadingComponentImpl,
                  22));
      this.provideInvalidLicenseSceneProvider =
          DoubleCheck.provider(
              new SwitchingProvider<Scene>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  healthCheckComponentImpl,
                  _ocuk2_KeyLoadingComponentImpl,
                  23));
      this.receiveKeyControllerProvider =
          DoubleCheck.provider(
              new SwitchingProvider<ReceiveKeyController>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  healthCheckComponentImpl,
                  _ocuk2_KeyLoadingComponentImpl,
                  18));
      this.provideHubRegisterSuccessSceneProvider =
          DoubleCheck.provider(
              new SwitchingProvider<Scene>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  healthCheckComponentImpl,
                  _ocuk2_KeyLoadingComponentImpl,
                  25));
      this.provideHubRegisterDeviceAlreadyExistsSceneProvider =
          DoubleCheck.provider(
              new SwitchingProvider<Scene>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  healthCheckComponentImpl,
                  _ocuk2_KeyLoadingComponentImpl,
                  26));
      this.registerDeviceControllerProvider =
          DoubleCheck.provider(
              new SwitchingProvider<RegisterDeviceController>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  healthCheckComponentImpl,
                  _ocuk2_KeyLoadingComponentImpl,
                  24));
      this.registerFailedControllerProvider =
          new SwitchingProvider<>(
              cryptomatorComponentImpl,
              fxApplicationComponentImpl,
              healthCheckComponentImpl,
              _ocuk2_KeyLoadingComponentImpl,
              27);
      this.registerSuccessControllerProvider =
          new SwitchingProvider<>(
              cryptomatorComponentImpl,
              fxApplicationComponentImpl,
              healthCheckComponentImpl,
              _ocuk2_KeyLoadingComponentImpl,
              28);
      this.requireAccountInitControllerProvider =
          DoubleCheck.provider(
              new SwitchingProvider<RequireAccountInitController>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  healthCheckComponentImpl,
                  _ocuk2_KeyLoadingComponentImpl,
                  29));
      this.unauthorizedDeviceControllerProvider =
          DoubleCheck.provider(
              new SwitchingProvider<UnauthorizedDeviceController>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  healthCheckComponentImpl,
                  _ocuk2_KeyLoadingComponentImpl,
                  30));
      DelegateFactory.setDelegate(
          provideFxmlLoaderFactoryProvider,
          DoubleCheck.provider(
              new SwitchingProvider<FxmlLoaderFactory>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  healthCheckComponentImpl,
                  _ocuk2_KeyLoadingComponentImpl,
                  5)));
      this.provideHubAuthFlowSceneProvider =
          DoubleCheck.provider(
              new SwitchingProvider<Scene>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  healthCheckComponentImpl,
                  _ocuk2_KeyLoadingComponentImpl,
                  4));
      this.provideHubNoKeychainSceneProvider =
          DoubleCheck.provider(
              new SwitchingProvider<Scene>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  healthCheckComponentImpl,
                  _ocuk2_KeyLoadingComponentImpl,
                  31));
      this.provideWindowTitleProvider =
          DoubleCheck.provider(
              new SwitchingProvider<String>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  healthCheckComponentImpl,
                  _ocuk2_KeyLoadingComponentImpl,
                  32));
      this.hubKeyLoadingStrategyProvider =
          new SwitchingProvider<>(
              cryptomatorComponentImpl,
              fxApplicationComponentImpl,
              healthCheckComponentImpl,
              _ocuk2_KeyLoadingComponentImpl,
              3);
      this.bindHubKeyLoadingStrategyToHubHttpProvider =
          DoubleCheck.provider((Provider) hubKeyLoadingStrategyProvider);
      this.bindHubKeyLoadingStrategyToHubHttpsProvider =
          DoubleCheck.provider((Provider) hubKeyLoadingStrategyProvider);
      this.provideKeyLoadingStrategyProvider =
          DoubleCheck.provider(
              new SwitchingProvider<KeyLoadingStrategy>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  healthCheckComponentImpl,
                  _ocuk2_KeyLoadingComponentImpl,
                  0));
    }

    @Override
    public KeyLoadingStrategy keyloadingStrategy() {
      return provideKeyLoadingStrategyProvider.get();
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final CryptomatorComponentImpl cryptomatorComponentImpl;

      private final FxApplicationComponentImpl fxApplicationComponentImpl;

      private final HealthCheckComponentImpl healthCheckComponentImpl;

      private final ocuk2_KeyLoadingComponentImpl _ocuk2_KeyLoadingComponentImpl;

      private final int id;

      SwitchingProvider(
          CryptomatorComponentImpl cryptomatorComponentImpl,
          FxApplicationComponentImpl fxApplicationComponentImpl,
          HealthCheckComponentImpl healthCheckComponentImpl,
          ocuk2_KeyLoadingComponentImpl _ocuk2_KeyLoadingComponentImpl,
          int id) {
        this.cryptomatorComponentImpl = cryptomatorComponentImpl;
        this.fxApplicationComponentImpl = fxApplicationComponentImpl;
        this.healthCheckComponentImpl = healthCheckComponentImpl;
        this._ocuk2_KeyLoadingComponentImpl = _ocuk2_KeyLoadingComponentImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // @org.cryptomator.ui.keyloading.KeyLoading
                  // org.cryptomator.ui.keyloading.KeyLoadingStrategy
            return (T)
                KeyLoadingModule_ProvideKeyLoadingStrategyFactory.provideKeyLoadingStrategy(
                    _ocuk2_KeyLoadingComponentImpl.vault,
                    _ocuk2_KeyLoadingComponentImpl.mapOfStringAndProviderOfKeyLoadingStrategy());

          case 1: // org.cryptomator.ui.keyloading.masterkeyfile.MasterkeyFileLoadingStrategy
            return (T)
                new MasterkeyFileLoadingStrategy(
                    _ocuk2_KeyLoadingComponentImpl.vault,
                    cryptomatorComponentImpl.provideMasterkeyFileAccessProvider.get(),
                    _ocuk2_KeyLoadingComponentImpl.window,
                    _ocuk2_KeyLoadingComponentImpl.provideStoredPasswordProvider.get(),
                    new ocukm2_PassphraseEntryComponentBuilder(
                        cryptomatorComponentImpl,
                        fxApplicationComponentImpl,
                        healthCheckComponentImpl,
                        _ocuk2_KeyLoadingComponentImpl),
                    new ocukm2_ChooseMasterkeyFileComponentBuilder(
                        cryptomatorComponentImpl,
                        fxApplicationComponentImpl,
                        healthCheckComponentImpl,
                        _ocuk2_KeyLoadingComponentImpl),
                    cryptomatorComponentImpl.keychainManagerProvider.get(),
                    cryptomatorComponentImpl.provideLocalizationProvider.get());

          case 2: // @javax.inject.Named("savedPassword") java.util.Optional<char[]>
            return (T)
                MasterkeyFileLoadingModule_ProvideStoredPasswordFactory.provideStoredPassword(
                    cryptomatorComponentImpl.keychainManagerProvider.get(),
                    _ocuk2_KeyLoadingComponentImpl.vault);

          case 3: // org.cryptomator.ui.keyloading.hub.HubKeyLoadingStrategy
            return (T)
                new HubKeyLoadingStrategy(
                    _ocuk2_KeyLoadingComponentImpl.window,
                    DoubleCheck.lazy(
                        _ocuk2_KeyLoadingComponentImpl.provideHubAuthFlowSceneProvider),
                    DoubleCheck.lazy(
                        _ocuk2_KeyLoadingComponentImpl.provideHubNoKeychainSceneProvider),
                    (CompletableFuture) _ocuk2_KeyLoadingComponentImpl.provideResultProvider.get(),
                    cryptomatorComponentImpl.deviceKeyProvider.get(),
                    cryptomatorComponentImpl.keychainManagerProvider.get(),
                    _ocuk2_KeyLoadingComponentImpl.provideWindowTitleProvider.get());

          case 4: // @org.cryptomator.ui.common.FxmlScene(HUB_AUTH_FLOW) javafx.scene.Scene
            return (T)
                HubKeyLoadingModule_ProvideHubAuthFlowSceneFactory.provideHubAuthFlowScene(
                    _ocuk2_KeyLoadingComponentImpl.provideFxmlLoaderFactoryProvider.get());

          case 5: // @org.cryptomator.ui.keyloading.KeyLoading
                  // org.cryptomator.ui.common.FxmlLoaderFactory
            return (T)
                KeyLoadingModule_ProvideFxmlLoaderFactoryFactory.provideFxmlLoaderFactory(
                    _ocuk2_KeyLoadingComponentImpl.mapOfClassOfAndProviderOfFxController(),
                    fxApplicationComponentImpl.defaultSceneFactoryProvider.get(),
                    cryptomatorComponentImpl.provideLocalizationProvider.get());

          case 6: // org.cryptomator.ui.keyloading.hub.AuthFlowController
            return (T)
                new AuthFlowController(
                    fxApplicationComponentImpl.fxApplicationProvider.get(),
                    _ocuk2_KeyLoadingComponentImpl.window,
                    cryptomatorComponentImpl.provideExecutorServiceProvider.get(),
                    _ocuk2_KeyLoadingComponentImpl.provideDeviceIdProvider.get(),
                    _ocuk2_KeyLoadingComponentImpl.provideHubConfigProvider.get(),
                    _ocuk2_KeyLoadingComponentImpl.provideBearerTokenRefProvider.get(),
                    (CompletableFuture) _ocuk2_KeyLoadingComponentImpl.provideResultProvider.get(),
                    DoubleCheck.lazy(
                        _ocuk2_KeyLoadingComponentImpl.provideHubReceiveKeySceneProvider));

          case 7: // @javax.inject.Named("deviceId") java.lang.String
            return (T)
                HubKeyLoadingModule_ProvideDeviceIdFactory.provideDeviceId(
                    cryptomatorComponentImpl.deviceKeyProvider.get());

          case 8: // org.cryptomator.ui.keyloading.hub.HubConfig
            return (T)
                HubKeyLoadingModule_ProvideHubConfigFactory.provideHubConfig(
                    _ocuk2_KeyLoadingComponentImpl.vault);

          case 9: // @javax.inject.Named("bearerToken")
                  // java.util.concurrent.atomic.AtomicReference<java.lang.String>
            return (T) HubKeyLoadingModule_ProvideBearerTokenRefFactory.provideBearerTokenRef();

          case 10: // java.util.concurrent.CompletableFuture<org.cryptomator.ui.keyloading.hub.ReceivedKey>
            return (T) HubKeyLoadingModule_ProvideResultFactory.provideResult();

          case 11: // @org.cryptomator.ui.common.FxmlScene(HUB_RECEIVE_KEY) javafx.scene.Scene
            return (T)
                HubKeyLoadingModule_ProvideHubReceiveKeySceneFactory.provideHubReceiveKeyScene(
                    _ocuk2_KeyLoadingComponentImpl.provideFxmlLoaderFactoryProvider.get());

          case 12: // org.cryptomator.ui.keyloading.hub.InvalidLicenseController
            return (T) new InvalidLicenseController(_ocuk2_KeyLoadingComponentImpl.window);

          case 13: // org.cryptomator.ui.keyloading.hub.LegacyRegisterDeviceController
            return (T)
                new LegacyRegisterDeviceController(
                    _ocuk2_KeyLoadingComponentImpl.window,
                    cryptomatorComponentImpl.provideExecutorServiceProvider.get(),
                    _ocuk2_KeyLoadingComponentImpl.provideHubConfigProvider.get(),
                    _ocuk2_KeyLoadingComponentImpl.provideDeviceIdProvider.get(),
                    cryptomatorComponentImpl.deviceKeyProvider.get(),
                    (CompletableFuture) _ocuk2_KeyLoadingComponentImpl.provideResultProvider.get(),
                    _ocuk2_KeyLoadingComponentImpl.provideBearerTokenRefProvider.get(),
                    DoubleCheck.lazy(
                        _ocuk2_KeyLoadingComponentImpl
                            .provideHubLegacyRegisterSuccessSceneProvider),
                    DoubleCheck.lazy(
                        _ocuk2_KeyLoadingComponentImpl.provideHubRegisterFailedSceneProvider));

          case 14: // @org.cryptomator.ui.common.FxmlScene(HUB_LEGACY_REGISTER_SUCCESS)
                   // javafx.scene.Scene
            return (T)
                HubKeyLoadingModule_ProvideHubLegacyRegisterSuccessSceneFactory
                    .provideHubLegacyRegisterSuccessScene(
                        _ocuk2_KeyLoadingComponentImpl.provideFxmlLoaderFactoryProvider.get());

          case 15: // @org.cryptomator.ui.common.FxmlScene(HUB_REGISTER_FAILED) javafx.scene.Scene
            return (T)
                HubKeyLoadingModule_ProvideHubRegisterFailedSceneFactory
                    .provideHubRegisterFailedScene(
                        _ocuk2_KeyLoadingComponentImpl.provideFxmlLoaderFactoryProvider.get());

          case 16: // org.cryptomator.ui.keyloading.hub.LegacyRegisterSuccessController
            return (T) new LegacyRegisterSuccessController(_ocuk2_KeyLoadingComponentImpl.window);

          case 17: // org.cryptomator.ui.keyloading.hub.NoKeychainController
            return (T)
                new NoKeychainController(
                    _ocuk2_KeyLoadingComponentImpl.window,
                    fxApplicationComponentImpl.fxApplicationWindowsProvider.get());

          case 18: // org.cryptomator.ui.keyloading.hub.ReceiveKeyController
            return (T)
                new ReceiveKeyController(
                    _ocuk2_KeyLoadingComponentImpl.vault,
                    cryptomatorComponentImpl.provideExecutorServiceProvider.get(),
                    _ocuk2_KeyLoadingComponentImpl.window,
                    _ocuk2_KeyLoadingComponentImpl.provideHubConfigProvider.get(),
                    _ocuk2_KeyLoadingComponentImpl.provideDeviceIdProvider.get(),
                    _ocuk2_KeyLoadingComponentImpl.provideBearerTokenRefProvider.get(),
                    (CompletableFuture) _ocuk2_KeyLoadingComponentImpl.provideResultProvider.get(),
                    DoubleCheck.lazy(
                        _ocuk2_KeyLoadingComponentImpl.provideHubRegisterDeviceSceneProvider),
                    DoubleCheck.lazy(
                        _ocuk2_KeyLoadingComponentImpl.provideHubLegacyRegisterDeviceSceneProvider),
                    DoubleCheck.lazy(
                        _ocuk2_KeyLoadingComponentImpl.provideHubUnauthorizedDeviceSceneProvider),
                    DoubleCheck.lazy(
                        _ocuk2_KeyLoadingComponentImpl.provideRequireAccountInitSceneProvider),
                    DoubleCheck.lazy(
                        _ocuk2_KeyLoadingComponentImpl.provideInvalidLicenseSceneProvider));

          case 19: // @org.cryptomator.ui.common.FxmlScene(HUB_REGISTER_DEVICE) javafx.scene.Scene
            return (T)
                HubKeyLoadingModule_ProvideHubRegisterDeviceSceneFactory
                    .provideHubRegisterDeviceScene(
                        _ocuk2_KeyLoadingComponentImpl.provideFxmlLoaderFactoryProvider.get());

          case 20: // @org.cryptomator.ui.common.FxmlScene(HUB_LEGACY_REGISTER_DEVICE)
                   // javafx.scene.Scene
            return (T)
                HubKeyLoadingModule_ProvideHubLegacyRegisterDeviceSceneFactory
                    .provideHubLegacyRegisterDeviceScene(
                        _ocuk2_KeyLoadingComponentImpl.provideFxmlLoaderFactoryProvider.get());

          case 21: // @org.cryptomator.ui.common.FxmlScene(HUB_UNAUTHORIZED_DEVICE)
                   // javafx.scene.Scene
            return (T)
                HubKeyLoadingModule_ProvideHubUnauthorizedDeviceSceneFactory
                    .provideHubUnauthorizedDeviceScene(
                        _ocuk2_KeyLoadingComponentImpl.provideFxmlLoaderFactoryProvider.get());

          case 22: // @org.cryptomator.ui.common.FxmlScene(HUB_REQUIRE_ACCOUNT_INIT)
                   // javafx.scene.Scene
            return (T)
                HubKeyLoadingModule_ProvideRequireAccountInitSceneFactory
                    .provideRequireAccountInitScene(
                        _ocuk2_KeyLoadingComponentImpl.provideFxmlLoaderFactoryProvider.get());

          case 23: // @org.cryptomator.ui.common.FxmlScene(HUB_INVALID_LICENSE) javafx.scene.Scene
            return (T)
                HubKeyLoadingModule_ProvideInvalidLicenseSceneFactory.provideInvalidLicenseScene(
                    _ocuk2_KeyLoadingComponentImpl.provideFxmlLoaderFactoryProvider.get());

          case 24: // org.cryptomator.ui.keyloading.hub.RegisterDeviceController
            return (T)
                new RegisterDeviceController(
                    _ocuk2_KeyLoadingComponentImpl.window,
                    cryptomatorComponentImpl.provideExecutorServiceProvider.get(),
                    _ocuk2_KeyLoadingComponentImpl.provideHubConfigProvider.get(),
                    _ocuk2_KeyLoadingComponentImpl.provideDeviceIdProvider.get(),
                    cryptomatorComponentImpl.deviceKeyProvider.get(),
                    (CompletableFuture) _ocuk2_KeyLoadingComponentImpl.provideResultProvider.get(),
                    _ocuk2_KeyLoadingComponentImpl.provideBearerTokenRefProvider.get(),
                    DoubleCheck.lazy(
                        _ocuk2_KeyLoadingComponentImpl.provideHubRegisterSuccessSceneProvider),
                    DoubleCheck.lazy(
                        _ocuk2_KeyLoadingComponentImpl.provideHubRegisterFailedSceneProvider),
                    DoubleCheck.lazy(
                        _ocuk2_KeyLoadingComponentImpl
                            .provideHubRegisterDeviceAlreadyExistsSceneProvider));

          case 25: // @org.cryptomator.ui.common.FxmlScene(HUB_REGISTER_SUCCESS) javafx.scene.Scene
            return (T)
                HubKeyLoadingModule_ProvideHubRegisterSuccessSceneFactory
                    .provideHubRegisterSuccessScene(
                        _ocuk2_KeyLoadingComponentImpl.provideFxmlLoaderFactoryProvider.get());

          case 26: // @org.cryptomator.ui.common.FxmlScene(HUB_REGISTER_DEVICE_ALREADY_EXISTS)
                   // javafx.scene.Scene
            return (T)
                HubKeyLoadingModule_ProvideHubRegisterDeviceAlreadyExistsSceneFactory
                    .provideHubRegisterDeviceAlreadyExistsScene(
                        _ocuk2_KeyLoadingComponentImpl.provideFxmlLoaderFactoryProvider.get());

          case 27: // org.cryptomator.ui.keyloading.hub.RegisterFailedController
            return (T)
                new RegisterFailedController(
                    _ocuk2_KeyLoadingComponentImpl.window,
                    (CompletableFuture) _ocuk2_KeyLoadingComponentImpl.provideResultProvider.get());

          case 28: // org.cryptomator.ui.keyloading.hub.RegisterSuccessController
            return (T)
                new RegisterSuccessController(
                    _ocuk2_KeyLoadingComponentImpl.window,
                    (CompletableFuture) _ocuk2_KeyLoadingComponentImpl.provideResultProvider.get(),
                    DoubleCheck.lazy(
                        _ocuk2_KeyLoadingComponentImpl.provideHubReceiveKeySceneProvider),
                    _ocuk2_KeyLoadingComponentImpl.receiveKeyControllerProvider.get());

          case 29: // org.cryptomator.ui.keyloading.hub.RequireAccountInitController
            return (T)
                new RequireAccountInitController(
                    fxApplicationComponentImpl.fxApplicationProvider.get(),
                    _ocuk2_KeyLoadingComponentImpl.provideHubConfigProvider.get(),
                    _ocuk2_KeyLoadingComponentImpl.window,
                    (CompletableFuture) _ocuk2_KeyLoadingComponentImpl.provideResultProvider.get());

          case 30: // org.cryptomator.ui.keyloading.hub.UnauthorizedDeviceController
            return (T)
                new UnauthorizedDeviceController(
                    _ocuk2_KeyLoadingComponentImpl.window,
                    (CompletableFuture) _ocuk2_KeyLoadingComponentImpl.provideResultProvider.get());

          case 31: // @org.cryptomator.ui.common.FxmlScene(HUB_NO_KEYCHAIN) javafx.scene.Scene
            return (T)
                HubKeyLoadingModule_ProvideHubNoKeychainSceneFactory.provideHubNoKeychainScene(
                    _ocuk2_KeyLoadingComponentImpl.provideFxmlLoaderFactoryProvider.get());

          case 32: // @javax.inject.Named("windowTitle") java.lang.String
            return (T)
                HubKeyLoadingModule_ProvideWindowTitleFactory.provideWindowTitle(
                    _ocuk2_KeyLoadingComponentImpl.vault,
                    cryptomatorComponentImpl.provideLocalizationProvider.get());

          default:
            throw new AssertionError(id);
        }
      }
    }
  }

  private static final class HealthCheckComponentImpl implements HealthCheckComponent {
    private final Stage owner;

    private final Vault vault;

    private final CryptomatorComponentImpl cryptomatorComponentImpl;

    private final FxApplicationComponentImpl fxApplicationComponentImpl;

    private final HealthCheckComponentImpl healthCheckComponentImpl = this;

    private Provider<AtomicReference<Masterkey>> provideMasterkeyRefProvider;

    private Provider<ChangeListener<Boolean>> provideWindowShowingChangeListenerProvider;

    private Provider<Stage> provideStageProvider;

    private Provider<List<Check>> provideAvailableChecksProvider;

    private Provider<AtomicReference<VaultConfig>> provideVaultConfigRefProvider;

    private Provider<CheckExecutor> checkExecutorProvider;

    private Provider<ReportWriter> reportWriterProvider;

    private Provider<ObjectProperty<Check>> provideSelectedCheckProvider;

    private Provider<FxmlLoaderFactory> provideFxmlLoaderFactoryProvider;

    private Provider<CheckListController> checkListControllerProvider;

    private Provider<ResultListCellFactory> resultListCellFactoryProvider;

    @SuppressWarnings("rawtypes")
    private Provider resultFixApplierProvider;

    private Provider<CheckDetailController> checkDetailControllerProvider;

    private Provider<CheckListCellController> checkListCellControllerProvider;

    private Provider<ResultListCellController> resultListCellControllerProvider;

    private Provider<Stage> provideUnlockWindowProvider;

    private Provider<KeyLoadingStrategy> provideKeyLoadingStrategyProvider;

    private Provider<Scene> provideHealthCheckListSceneProvider;

    private Provider<StartController> startControllerProvider;

    private Provider<Scene> provideHealthStartSceneProvider;

    private HealthCheckComponentImpl(
        CryptomatorComponentImpl cryptomatorComponentImpl,
        FxApplicationComponentImpl fxApplicationComponentImpl,
        Stage ownerParam,
        Vault vaultParam) {
      this.cryptomatorComponentImpl = cryptomatorComponentImpl;
      this.fxApplicationComponentImpl = fxApplicationComponentImpl;
      this.owner = ownerParam;
      this.vault = vaultParam;
      initialize(ownerParam, vaultParam);
    }

    private CheckListCellFactory checkListCellFactory() {
      return CheckListCellFactory_Factory.newInstance(provideFxmlLoaderFactoryProvider.get());
    }

    private Map<Class<? extends FxController>, javax.inject.Provider<FxController>>
        mapOfClassOfAndProviderOfFxController() {
      return ImmutableMap.<Class<? extends FxController>, javax.inject.Provider<FxController>>of(
          CheckListController.class,
          ((Provider) checkListControllerProvider),
          CheckDetailController.class,
          ((Provider) checkDetailControllerProvider),
          CheckListCellController.class,
          ((Provider) checkListCellControllerProvider),
          ResultListCellController.class,
          ((Provider) resultListCellControllerProvider),
          StartController.class,
          ((Provider) startControllerProvider));
    }

    @SuppressWarnings("unchecked")
    private void initialize(final Stage ownerParam, final Vault vaultParam) {
      this.provideMasterkeyRefProvider =
          DoubleCheck.provider(
              new SwitchingProvider<AtomicReference<Masterkey>>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  healthCheckComponentImpl,
                  5));
      this.provideWindowShowingChangeListenerProvider =
          DoubleCheck.provider(
              new SwitchingProvider<ChangeListener<Boolean>>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  healthCheckComponentImpl,
                  4));
      this.provideStageProvider =
          DoubleCheck.provider(
              new SwitchingProvider<Stage>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  healthCheckComponentImpl,
                  3));
      this.provideAvailableChecksProvider =
          DoubleCheck.provider(
              new SwitchingProvider<List<Check>>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  healthCheckComponentImpl,
                  6));
      this.provideVaultConfigRefProvider =
          DoubleCheck.provider(
              new SwitchingProvider<AtomicReference<VaultConfig>>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  healthCheckComponentImpl,
                  8));
      this.checkExecutorProvider =
          DoubleCheck.provider(
              new SwitchingProvider<CheckExecutor>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  healthCheckComponentImpl,
                  7));
      this.reportWriterProvider =
          DoubleCheck.provider(
              new SwitchingProvider<ReportWriter>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  healthCheckComponentImpl,
                  9));
      this.provideSelectedCheckProvider =
          DoubleCheck.provider(
              new SwitchingProvider<ObjectProperty<Check>>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  healthCheckComponentImpl,
                  10));
      this.provideFxmlLoaderFactoryProvider = new DelegateFactory<>();
      this.checkListControllerProvider =
          DoubleCheck.provider(
              new SwitchingProvider<CheckListController>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  healthCheckComponentImpl,
                  2));
      this.resultListCellFactoryProvider =
          DoubleCheck.provider(
              new SwitchingProvider<ResultListCellFactory>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  healthCheckComponentImpl,
                  12));
      this.resultFixApplierProvider =
          DoubleCheck.provider(
              new SwitchingProvider<Object>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  healthCheckComponentImpl,
                  13));
      this.checkDetailControllerProvider =
          DoubleCheck.provider(
              new SwitchingProvider<CheckDetailController>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  healthCheckComponentImpl,
                  11));
      this.checkListCellControllerProvider =
          new SwitchingProvider<>(
              cryptomatorComponentImpl, fxApplicationComponentImpl, healthCheckComponentImpl, 14);
      this.resultListCellControllerProvider =
          new SwitchingProvider<>(
              cryptomatorComponentImpl, fxApplicationComponentImpl, healthCheckComponentImpl, 15);
      this.provideUnlockWindowProvider =
          DoubleCheck.provider(
              new SwitchingProvider<Stage>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  healthCheckComponentImpl,
                  18));
      this.provideKeyLoadingStrategyProvider =
          DoubleCheck.provider(
              new SwitchingProvider<KeyLoadingStrategy>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  healthCheckComponentImpl,
                  17));
      this.provideHealthCheckListSceneProvider =
          DoubleCheck.provider(
              new SwitchingProvider<Scene>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  healthCheckComponentImpl,
                  19));
      this.startControllerProvider =
          DoubleCheck.provider(
              new SwitchingProvider<StartController>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  healthCheckComponentImpl,
                  16));
      DelegateFactory.setDelegate(
          provideFxmlLoaderFactoryProvider,
          DoubleCheck.provider(
              new SwitchingProvider<FxmlLoaderFactory>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  healthCheckComponentImpl,
                  1)));
      this.provideHealthStartSceneProvider =
          DoubleCheck.provider(
              new SwitchingProvider<Scene>(
                  cryptomatorComponentImpl,
                  fxApplicationComponentImpl,
                  healthCheckComponentImpl,
                  0));
    }

    @Override
    public Lazy<Scene> startScene() {
      return DoubleCheck.lazy(provideHealthStartSceneProvider);
    }

    @Override
    public Stage window() {
      return provideStageProvider.get();
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final CryptomatorComponentImpl cryptomatorComponentImpl;

      private final FxApplicationComponentImpl fxApplicationComponentImpl;

      private final HealthCheckComponentImpl healthCheckComponentImpl;

      private final int id;

      SwitchingProvider(
          CryptomatorComponentImpl cryptomatorComponentImpl,
          FxApplicationComponentImpl fxApplicationComponentImpl,
          HealthCheckComponentImpl healthCheckComponentImpl,
          int id) {
        this.cryptomatorComponentImpl = cryptomatorComponentImpl;
        this.fxApplicationComponentImpl = fxApplicationComponentImpl;
        this.healthCheckComponentImpl = healthCheckComponentImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // @org.cryptomator.ui.common.FxmlScene(HEALTH_START) javafx.scene.Scene
            return (T)
                HealthCheckModule_ProvideHealthStartSceneFactory.provideHealthStartScene(
                    healthCheckComponentImpl.provideFxmlLoaderFactoryProvider.get());

          case 1: // @org.cryptomator.ui.health.HealthCheckWindow
                  // org.cryptomator.ui.common.FxmlLoaderFactory
            return (T)
                HealthCheckModule_ProvideFxmlLoaderFactoryFactory.provideFxmlLoaderFactory(
                    healthCheckComponentImpl.mapOfClassOfAndProviderOfFxController(),
                    fxApplicationComponentImpl.defaultSceneFactoryProvider.get(),
                    cryptomatorComponentImpl.provideLocalizationProvider.get());

          case 2: // org.cryptomator.ui.health.CheckListController
            return (T)
                new CheckListController(
                    healthCheckComponentImpl.provideStageProvider.get(),
                    healthCheckComponentImpl.provideAvailableChecksProvider.get(),
                    healthCheckComponentImpl.checkExecutorProvider.get(),
                    healthCheckComponentImpl.reportWriterProvider.get(),
                    healthCheckComponentImpl.provideSelectedCheckProvider.get(),
                    fxApplicationComponentImpl.fxApplicationWindowsProvider.get(),
                    healthCheckComponentImpl.checkListCellFactory());

          case 3: // @org.cryptomator.ui.health.HealthCheckWindow javafx.stage.Stage
            return (T)
                HealthCheckModule_ProvideStageFactory.provideStage(
                    fxApplicationComponentImpl.stageFactoryProvider.get(),
                    healthCheckComponentImpl.owner,
                    healthCheckComponentImpl.vault,
                    healthCheckComponentImpl.provideWindowShowingChangeListenerProvider.get(),
                    cryptomatorComponentImpl.provideLocalizationProvider.get());

          case 4: // javafx.beans.value.ChangeListener<java.lang.Boolean>
            return (T)
                HealthCheckModule_ProvideWindowShowingChangeListenerFactory
                    .provideWindowShowingChangeListener(
                        healthCheckComponentImpl.provideMasterkeyRefProvider.get());

          case 5: // java.util.concurrent.atomic.AtomicReference<org.cryptomator.cryptolib.api.Masterkey>
            return (T) HealthCheckModule_ProvideMasterkeyRefFactory.provideMasterkeyRef();

          case 6: // java.util.List<org.cryptomator.ui.health.Check>
            return (T) HealthCheckModule_ProvideAvailableChecksFactory.provideAvailableChecks();

          case 7: // org.cryptomator.ui.health.CheckExecutor
            return (T)
                new CheckExecutor(
                    healthCheckComponentImpl.vault,
                    healthCheckComponentImpl.provideMasterkeyRefProvider.get(),
                    healthCheckComponentImpl.provideVaultConfigRefProvider.get(),
                    cryptomatorComponentImpl.provideCSPRNGProvider.get());

          case 8: // java.util.concurrent.atomic.AtomicReference<org.cryptomator.cryptofs.VaultConfig>
            return (T) HealthCheckModule_ProvideVaultConfigRefFactory.provideVaultConfigRef();

          case 9: // org.cryptomator.ui.health.ReportWriter
            return (T)
                new ReportWriter(
                    healthCheckComponentImpl.vault,
                    healthCheckComponentImpl.provideVaultConfigRefProvider.get(),
                    fxApplicationComponentImpl.fxApplicationProvider.get(),
                    cryptomatorComponentImpl.provideEnvironmentProvider.get());

          case 10: // javafx.beans.property.ObjectProperty<org.cryptomator.ui.health.Check>
            return (T) HealthCheckModule_ProvideSelectedCheckFactory.provideSelectedCheck();

          case 11: // org.cryptomator.ui.health.CheckDetailController
            return (T)
                CheckDetailController_Factory.newInstance(
                    healthCheckComponentImpl.provideSelectedCheckProvider.get(),
                    healthCheckComponentImpl.resultListCellFactoryProvider.get(),
                    healthCheckComponentImpl.resultFixApplierProvider.get(),
                    cryptomatorComponentImpl.provideLocalizationProvider.get());

          case 12: // org.cryptomator.ui.health.ResultListCellFactory
            return (T)
                ResultListCellFactory_Factory.newInstance(
                    healthCheckComponentImpl.provideFxmlLoaderFactoryProvider.get());

          case 13: // org.cryptomator.ui.health.ResultFixApplier
            return (T)
                ResultFixApplier_Factory.newInstance(
                    healthCheckComponentImpl.vault,
                    healthCheckComponentImpl.provideMasterkeyRefProvider.get(),
                    healthCheckComponentImpl.provideVaultConfigRefProvider.get(),
                    cryptomatorComponentImpl.provideCSPRNGProvider.get());

          case 14: // org.cryptomator.ui.health.CheckListCellController
            return (T) new CheckListCellController();

          case 15: // org.cryptomator.ui.health.ResultListCellController
            return (T)
                ResultListCellController_Factory.newInstance(
                    healthCheckComponentImpl.resultFixApplierProvider.get(),
                    cryptomatorComponentImpl.provideLocalizationProvider.get());

          case 16: // org.cryptomator.ui.health.StartController
            return (T)
                new StartController(
                    healthCheckComponentImpl.provideStageProvider.get(),
                    healthCheckComponentImpl.vault,
                    healthCheckComponentImpl.provideKeyLoadingStrategyProvider.get(),
                    cryptomatorComponentImpl.provideExecutorServiceProvider.get(),
                    healthCheckComponentImpl.provideMasterkeyRefProvider.get(),
                    healthCheckComponentImpl.provideVaultConfigRefProvider.get(),
                    DoubleCheck.lazy(healthCheckComponentImpl.provideHealthCheckListSceneProvider),
                    fxApplicationComponentImpl.fxApplicationWindowsProvider.get(),
                    healthCheckComponentImpl.provideUnlockWindowProvider.get());

          case 17: // @org.cryptomator.ui.health.HealthCheckWindow
                   // org.cryptomator.ui.keyloading.KeyLoadingStrategy
            return (T)
                HealthCheckModule_ProvideKeyLoadingStrategyFactory.provideKeyLoadingStrategy(
                    new ocuk2_KeyLoadingComponentBuilder(
                        cryptomatorComponentImpl,
                        fxApplicationComponentImpl,
                        healthCheckComponentImpl),
                    healthCheckComponentImpl.vault,
                    healthCheckComponentImpl.provideUnlockWindowProvider.get());

          case 18: // @javax.inject.Named("unlockWindow") javafx.stage.Stage
            return (T)
                HealthCheckModule_ProvideUnlockWindowFactory.provideUnlockWindow(
                    healthCheckComponentImpl.provideStageProvider.get(),
                    healthCheckComponentImpl.vault,
                    fxApplicationComponentImpl.stageFactoryProvider.get(),
                    cryptomatorComponentImpl.provideLocalizationProvider.get());

          case 19: // @org.cryptomator.ui.common.FxmlScene(HEALTH_CHECK_LIST) javafx.scene.Scene
            return (T)
                HealthCheckModule_ProvideHealthCheckListSceneFactory.provideHealthCheckListScene(
                    healthCheckComponentImpl.provideFxmlLoaderFactoryProvider.get());

          default:
            throw new AssertionError(id);
        }
      }
    }
  }

  private static final class FxApplicationComponentImpl implements FxApplicationComponent {
    private final Stage primaryStage;

    private final CryptomatorComponentImpl cryptomatorComponentImpl;

    private final FxApplicationComponentImpl fxApplicationComponentImpl = this;

    private Provider<MainWindowComponent> provideMainWindowComponentProvider;

    private Provider<PreferencesComponent> providePreferencesComponentProvider;

    private Provider<FxApplicationWindows> fxApplicationWindowsProvider;

    private Provider<Application> fxApplicationProvider;

    private Provider<VaultService> vaultServiceProvider;

    @SuppressWarnings("rawtypes")
    private Provider appLaunchEventHandlerProvider;

    private Provider<TrayMenuComponent> provideTrayMenuComponentProvider;

    private Provider<FxApplicationStyle> fxApplicationStyleProvider;

    private Provider<FxApplicationTerminator> fxApplicationTerminatorProvider;

    private Provider<AutoUnlocker> autoUnlockerProvider;

    private Provider<FxApplication> fxApplicationProvider2;

    private Provider<StageInitializer> stageInitializerProvider;

    private Provider<Optional<HttpClient>> provideHttpClientProvider;

    private Provider<HttpRequest> provideCheckForUpdatesRequestProvider;

    private Provider<ObjectBinding<Duration>> provideCheckForUpdateIntervalProvider;

    private Provider<ScheduledService<String>> provideCheckForUpdatesServiceProvider;

    private Provider<UpdateChecker> updateCheckerProvider;

    private Provider<StageFactory> stageFactoryProvider;

    private Provider<DefaultSceneFactory> defaultSceneFactoryProvider;

    private Provider<PasswordStrengthUtil> passwordStrengthUtilProvider;

    private FxApplicationComponentImpl(
        CryptomatorComponentImpl cryptomatorComponentImpl,
        Application fxApplicationParam,
        Stage primaryStageParam) {
      this.cryptomatorComponentImpl = cryptomatorComponentImpl;
      this.primaryStage = primaryStageParam;
      initialize(fxApplicationParam, primaryStageParam);
    }

    @SuppressWarnings("unchecked")
    private void initialize(final Application fxApplicationParam, final Stage primaryStageParam) {
      this.provideMainWindowComponentProvider =
          DoubleCheck.provider(
              new SwitchingProvider<MainWindowComponent>(
                  cryptomatorComponentImpl, fxApplicationComponentImpl, 3));
      this.providePreferencesComponentProvider =
          DoubleCheck.provider(
              new SwitchingProvider<PreferencesComponent>(
                  cryptomatorComponentImpl, fxApplicationComponentImpl, 4));
      this.fxApplicationWindowsProvider =
          DoubleCheck.provider(
              new SwitchingProvider<FxApplicationWindows>(
                  cryptomatorComponentImpl, fxApplicationComponentImpl, 2));
      this.fxApplicationProvider = InstanceFactory.create(fxApplicationParam);
      this.vaultServiceProvider =
          DoubleCheck.provider(
              new SwitchingProvider<VaultService>(
                  cryptomatorComponentImpl, fxApplicationComponentImpl, 5));
      this.appLaunchEventHandlerProvider =
          DoubleCheck.provider(
              new SwitchingProvider<Object>(
                  cryptomatorComponentImpl, fxApplicationComponentImpl, 1));
      this.provideTrayMenuComponentProvider =
          DoubleCheck.provider(
              new SwitchingProvider<TrayMenuComponent>(
                  cryptomatorComponentImpl, fxApplicationComponentImpl, 6));
      this.fxApplicationStyleProvider =
          DoubleCheck.provider(
              new SwitchingProvider<FxApplicationStyle>(
                  cryptomatorComponentImpl, fxApplicationComponentImpl, 7));
      this.fxApplicationTerminatorProvider =
          DoubleCheck.provider(
              new SwitchingProvider<FxApplicationTerminator>(
                  cryptomatorComponentImpl, fxApplicationComponentImpl, 8));
      this.autoUnlockerProvider =
          DoubleCheck.provider(
              new SwitchingProvider<AutoUnlocker>(
                  cryptomatorComponentImpl, fxApplicationComponentImpl, 9));
      this.fxApplicationProvider2 =
          DoubleCheck.provider(
              new SwitchingProvider<FxApplication>(
                  cryptomatorComponentImpl, fxApplicationComponentImpl, 0));
      this.stageInitializerProvider =
          DoubleCheck.provider(
              new SwitchingProvider<StageInitializer>(
                  cryptomatorComponentImpl, fxApplicationComponentImpl, 10));
      this.provideHttpClientProvider =
          DoubleCheck.provider(
              new SwitchingProvider<Optional<HttpClient>>(
                  cryptomatorComponentImpl, fxApplicationComponentImpl, 13));
      this.provideCheckForUpdatesRequestProvider =
          DoubleCheck.provider(
              new SwitchingProvider<HttpRequest>(
                  cryptomatorComponentImpl, fxApplicationComponentImpl, 14));
      this.provideCheckForUpdateIntervalProvider =
          DoubleCheck.provider(
              new SwitchingProvider<ObjectBinding<Duration>>(
                  cryptomatorComponentImpl, fxApplicationComponentImpl, 15));
      this.provideCheckForUpdatesServiceProvider =
          DoubleCheck.provider(
              new SwitchingProvider<ScheduledService<String>>(
                  cryptomatorComponentImpl, fxApplicationComponentImpl, 12));
      this.updateCheckerProvider =
          DoubleCheck.provider(
              new SwitchingProvider<UpdateChecker>(
                  cryptomatorComponentImpl, fxApplicationComponentImpl, 11));
      this.stageFactoryProvider =
          DoubleCheck.provider(
              new SwitchingProvider<StageFactory>(
                  cryptomatorComponentImpl, fxApplicationComponentImpl, 16));
      this.defaultSceneFactoryProvider =
          DoubleCheck.provider(
              new SwitchingProvider<DefaultSceneFactory>(
                  cryptomatorComponentImpl, fxApplicationComponentImpl, 17));
      this.passwordStrengthUtilProvider =
          DoubleCheck.provider(
              new SwitchingProvider<PasswordStrengthUtil>(
                  cryptomatorComponentImpl, fxApplicationComponentImpl, 18));
    }

    @Override
    public FxApplication application() {
      return fxApplicationProvider2.get();
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final CryptomatorComponentImpl cryptomatorComponentImpl;

      private final FxApplicationComponentImpl fxApplicationComponentImpl;

      private final int id;

      SwitchingProvider(
          CryptomatorComponentImpl cryptomatorComponentImpl,
          FxApplicationComponentImpl fxApplicationComponentImpl,
          int id) {
        this.cryptomatorComponentImpl = cryptomatorComponentImpl;
        this.fxApplicationComponentImpl = fxApplicationComponentImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // org.cryptomator.ui.fxapp.FxApplication
            return (T)
                FxApplication_Factory.newInstance(
                    cryptomatorComponentImpl.startupTime,
                    cryptomatorComponentImpl.provideEnvironmentProvider.get(),
                    cryptomatorComponentImpl.provideSettingsProvider.get(),
                    fxApplicationComponentImpl.appLaunchEventHandlerProvider.get(),
                    DoubleCheck.lazy(fxApplicationComponentImpl.provideTrayMenuComponentProvider),
                    fxApplicationComponentImpl.fxApplicationWindowsProvider.get(),
                    fxApplicationComponentImpl.fxApplicationStyleProvider.get(),
                    fxApplicationComponentImpl.fxApplicationTerminatorProvider.get(),
                    fxApplicationComponentImpl.autoUnlockerProvider.get());

          case 1: // org.cryptomator.ui.fxapp.AppLaunchEventHandler
            return (T)
                AppLaunchEventHandler_Factory.newInstance(
                    cryptomatorComponentImpl.provideFileOpenRequestsProvider.get(),
                    cryptomatorComponentImpl.provideExecutorServiceProvider.get(),
                    fxApplicationComponentImpl.fxApplicationWindowsProvider.get(),
                    cryptomatorComponentImpl.vaultListManagerProvider.get(),
                    fxApplicationComponentImpl.vaultServiceProvider.get());

          case 2: // org.cryptomator.ui.fxapp.FxApplicationWindows
            return (T)
                new FxApplicationWindows(
                    fxApplicationComponentImpl.primaryStage,
                    cryptomatorComponentImpl.provideTrayIntegrationProvider.get(),
                    DoubleCheck.lazy(fxApplicationComponentImpl.provideMainWindowComponentProvider),
                    DoubleCheck.lazy(
                        fxApplicationComponentImpl.providePreferencesComponentProvider),
                    new QuitComponentBuilder(cryptomatorComponentImpl, fxApplicationComponentImpl),
                    new UnlockComponentFactory(
                        cryptomatorComponentImpl, fxApplicationComponentImpl),
                    new UpdateReminderComponentFactory(
                        cryptomatorComponentImpl, fxApplicationComponentImpl),
                    new DokanySupportEndComponentFactory(
                        cryptomatorComponentImpl, fxApplicationComponentImpl),
                    new LockComponentFactory(cryptomatorComponentImpl, fxApplicationComponentImpl),
                    new ErrorComponentFactory(cryptomatorComponentImpl, fxApplicationComponentImpl),
                    new VaultOptionsComponentFactory(
                        cryptomatorComponentImpl, fxApplicationComponentImpl),
                    new ShareVaultComponentFactory(
                        cryptomatorComponentImpl, fxApplicationComponentImpl),
                    cryptomatorComponentImpl.provideExecutorServiceProvider.get());

          case 3: // org.cryptomator.ui.mainwindow.MainWindowComponent
            return (T)
                FxApplicationModule_ProvideMainWindowComponentFactory.provideMainWindowComponent(
                    new MainWindowComponentBuilder(
                        cryptomatorComponentImpl, fxApplicationComponentImpl));

          case 4: // org.cryptomator.ui.preferences.PreferencesComponent
            return (T)
                FxApplicationModule_ProvidePreferencesComponentFactory.providePreferencesComponent(
                    new PreferencesComponentBuilder(
                        cryptomatorComponentImpl, fxApplicationComponentImpl));

          case 5: // org.cryptomator.ui.common.VaultService
            return (T)
                new VaultService(
                    DoubleCheck.lazy(fxApplicationComponentImpl.fxApplicationProvider),
                    cryptomatorComponentImpl.provideExecutorServiceProvider.get());

          case 6: // org.cryptomator.ui.traymenu.TrayMenuComponent
            return (T)
                FxApplicationModule_ProvideTrayMenuComponentFactory.provideTrayMenuComponent(
                    new TrayMenuComponentBuilder(
                        cryptomatorComponentImpl, fxApplicationComponentImpl));

          case 7: // org.cryptomator.ui.fxapp.FxApplicationStyle
            return (T)
                new FxApplicationStyle(
                    cryptomatorComponentImpl.provideSettingsProvider.get(),
                    cryptomatorComponentImpl.provideAppearanceProvider.get(),
                    cryptomatorComponentImpl.licenseHolderProvider.get());

          case 8: // org.cryptomator.ui.fxapp.FxApplicationTerminator
            return (T)
                new FxApplicationTerminator(
                    cryptomatorComponentImpl.provideVaultListProvider.get(),
                    cryptomatorComponentImpl.shutdownHookProvider.get(),
                    fxApplicationComponentImpl.fxApplicationWindowsProvider.get(),
                    cryptomatorComponentImpl.provideSettingsProvider.get(),
                    fxApplicationComponentImpl.vaultServiceProvider.get());

          case 9: // org.cryptomator.ui.fxapp.AutoUnlocker
            return (T)
                new AutoUnlocker(
                    cryptomatorComponentImpl.provideVaultListProvider.get(),
                    fxApplicationComponentImpl.fxApplicationWindowsProvider.get(),
                    cryptomatorComponentImpl.provideScheduledExecutorServiceProvider.get());

          case 10: // org.cryptomator.ui.common.StageInitializer
            return (T) new StageInitializer();

          case 11: // org.cryptomator.ui.fxapp.UpdateChecker
            return (T)
                UpdateChecker_Factory.newInstance(
                    cryptomatorComponentImpl.provideSettingsProvider.get(),
                    cryptomatorComponentImpl.provideEnvironmentProvider.get(),
                    fxApplicationComponentImpl.provideCheckForUpdatesServiceProvider.get());

          case 12: // javafx.concurrent.ScheduledService<java.lang.String>
            return (T)
                UpdateCheckerModule_ProvideCheckForUpdatesServiceFactory
                    .provideCheckForUpdatesService(
                        cryptomatorComponentImpl.provideExecutorServiceProvider.get(),
                        fxApplicationComponentImpl.provideHttpClientProvider.get(),
                        fxApplicationComponentImpl.provideCheckForUpdatesRequestProvider.get(),
                        fxApplicationComponentImpl.provideCheckForUpdateIntervalProvider.get());

          case 13: // java.util.Optional<java.net.http.HttpClient>
            return (T) UpdateCheckerModule_ProvideHttpClientFactory.provideHttpClient();

          case 14: // java.net.http.HttpRequest
            return (T)
                UpdateCheckerModule_ProvideCheckForUpdatesRequestFactory
                    .provideCheckForUpdatesRequest(
                        cryptomatorComponentImpl.provideEnvironmentProvider.get());

          case 15: // @javax.inject.Named("checkForUpdatesInterval")
                   // javafx.beans.binding.ObjectBinding<javafx.util.Duration>
            return (T)
                UpdateCheckerModule_ProvideCheckForUpdateIntervalFactory
                    .provideCheckForUpdateInterval(
                        cryptomatorComponentImpl.provideSettingsProvider.get());

          case 16: // org.cryptomator.ui.common.StageFactory
            return (T) new StageFactory(fxApplicationComponentImpl.stageInitializerProvider.get());

          case 17: // org.cryptomator.ui.common.DefaultSceneFactory
            return (T)
                new DefaultSceneFactory(cryptomatorComponentImpl.provideSettingsProvider.get());

          case 18: // org.cryptomator.ui.changepassword.PasswordStrengthUtil
            return (T)
                new PasswordStrengthUtil(
                    cryptomatorComponentImpl.provideLocalizationProvider.get(),
                    cryptomatorComponentImpl.provideEnvironmentProvider.get());

          default:
            throw new AssertionError(id);
        }
      }
    }
  }

  private static final class VaultComponentImpl implements VaultComponent {
    private final VaultSettings arg0;

    private final VaultConfigCache arg1;

    private final VaultModule vaultModule;

    private final VaultState.Value arg2;

    private final Exception arg3;

    private final CryptomatorComponentImpl cryptomatorComponentImpl;

    private final VaultComponentImpl vaultComponentImpl = this;

    private Provider<AtomicReference<CryptoFileSystem>> provideCryptoFileSystemReferenceProvider;

    private Provider<VaultState> vaultStateProvider;

    private Provider<ObjectProperty<Exception>> provideLastKnownExceptionProvider;

    private Provider<VaultStats> vaultStatsProvider;

    private Provider<Vault> vaultProvider;

    private VaultComponentImpl(
        CryptomatorComponentImpl cryptomatorComponentImpl,
        VaultModule vaultModuleParam,
        VaultSettings arg0Param,
        VaultConfigCache arg1Param,
        VaultState.Value arg2Param,
        Exception arg3Param) {
      this.cryptomatorComponentImpl = cryptomatorComponentImpl;
      this.arg0 = arg0Param;
      this.arg1 = arg1Param;
      this.vaultModule = vaultModuleParam;
      this.arg2 = arg2Param;
      this.arg3 = arg3Param;
      initialize(vaultModuleParam, arg0Param, arg1Param, arg2Param, arg3Param);
    }

    @SuppressWarnings("unchecked")
    private void initialize(
        final VaultModule vaultModuleParam,
        final VaultSettings arg0Param,
        final VaultConfigCache arg1Param,
        final VaultState.Value arg2Param,
        final Exception arg3Param) {
      this.provideCryptoFileSystemReferenceProvider =
          DoubleCheck.provider(
              new SwitchingProvider<AtomicReference<CryptoFileSystem>>(
                  cryptomatorComponentImpl, vaultComponentImpl, 1));
      this.vaultStateProvider =
          DoubleCheck.provider(
              new SwitchingProvider<VaultState>(cryptomatorComponentImpl, vaultComponentImpl, 2));
      this.provideLastKnownExceptionProvider =
          DoubleCheck.provider(
              new SwitchingProvider<ObjectProperty<Exception>>(
                  cryptomatorComponentImpl, vaultComponentImpl, 3));
      this.vaultStatsProvider =
          DoubleCheck.provider(
              new SwitchingProvider<VaultStats>(cryptomatorComponentImpl, vaultComponentImpl, 4));
      this.vaultProvider =
          DoubleCheck.provider(
              new SwitchingProvider<Vault>(cryptomatorComponentImpl, vaultComponentImpl, 0));
    }

    @Override
    public Vault vault() {
      return vaultProvider.get();
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final CryptomatorComponentImpl cryptomatorComponentImpl;

      private final VaultComponentImpl vaultComponentImpl;

      private final int id;

      SwitchingProvider(
          CryptomatorComponentImpl cryptomatorComponentImpl,
          VaultComponentImpl vaultComponentImpl,
          int id) {
        this.cryptomatorComponentImpl = cryptomatorComponentImpl;
        this.vaultComponentImpl = vaultComponentImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // org.cryptomator.common.vaults.Vault
            return (T)
                Vault_Factory.newInstance(
                    vaultComponentImpl.arg0,
                    vaultComponentImpl.arg1,
                    vaultComponentImpl.provideCryptoFileSystemReferenceProvider.get(),
                    vaultComponentImpl.vaultStateProvider.get(),
                    vaultComponentImpl.provideLastKnownExceptionProvider.get(),
                    vaultComponentImpl.vaultStatsProvider.get(),
                    cryptomatorComponentImpl.mounterProvider.get(),
                    cryptomatorComponentImpl.provideSettingsProvider.get());

          case 1: // java.util.concurrent.atomic.AtomicReference<org.cryptomator.cryptofs.CryptoFileSystem>
            return (T)
                VaultModule_ProvideCryptoFileSystemReferenceFactory
                    .provideCryptoFileSystemReference(vaultComponentImpl.vaultModule);

          case 2: // org.cryptomator.common.vaults.VaultState
            return (T) new VaultState(vaultComponentImpl.arg2);

          case 3: // @javax.inject.Named("lastKnownException")
                  // javafx.beans.property.ObjectProperty<java.lang.Exception>
            return (T)
                VaultModule_ProvideLastKnownExceptionFactory.provideLastKnownException(
                    vaultComponentImpl.vaultModule, vaultComponentImpl.arg3);

          case 4: // org.cryptomator.common.vaults.VaultStats
            return (T)
                VaultStats_Factory.newInstance(
                    vaultComponentImpl.provideCryptoFileSystemReferenceProvider.get(),
                    vaultComponentImpl.vaultStateProvider.get(),
                    cryptomatorComponentImpl.provideExecutorServiceProvider.get());

          default:
            throw new AssertionError(id);
        }
      }
    }
  }

  private static final class CryptomatorComponentImpl implements CryptomatorComponent {
    private final Long startupTime;

    private final VaultListModule vaultListModule;

    private final CryptomatorComponentImpl cryptomatorComponentImpl = this;

    private Provider<Environment> provideEnvironmentProvider;

    private Provider<ShutdownHook> shutdownHookProvider;

    private Provider<ScheduledExecutorService> provideScheduledExecutorServiceProvider;

    private Provider<SettingsProvider> settingsProvider;

    private Provider<Settings> provideSettingsProvider;

    private Provider<DebugMode> debugModeProvider;

    private Provider<SupportedLanguages> supportedLanguagesProvider;

    private Provider<BlockingQueue<AppLaunchEvent>> provideFileOpenRequestsProvider;

    private Provider<FileOpenRequestHandler> fileOpenRequestHandlerProvider;

    private Provider<IpcMessageHandler> ipcMessageHandlerProvider;

    private Provider<Cryptomator> cryptomatorProvider;

    private Provider<ExecutorService> provideExecutorServiceProvider;

    private Provider<Optional<TrayIntegrationProvider>> provideTrayIntegrationProvider;

    private Provider<ObservableList<Vault>> provideVaultListProvider;

    private Provider<AutoLocker> autoLockerProvider;

    private Provider<List<MountService>> provideSupportedMountServicesProvider;

    private Provider<ResourceBundle> provideLocalizationProvider;

    private Provider<VaultListManager> vaultListManagerProvider;

    private Provider<Optional<UiAppearanceProvider>> provideAppearanceProvider;

    private Provider<String> provideLicensePublicKeyProvider;

    @SuppressWarnings("rawtypes")
    private Provider licenseCheckerProvider;

    private Provider<LicenseHolder> licenseHolderProvider;

    private Provider<List<KeychainAccessProvider>> provideSupportedKeychainAccessProvidersProvider;

    private Provider<ObjectExpression<KeychainAccessProvider>> provideKeychainAccessProvider;

    private Provider<KeychainManager> keychainManagerProvider;

    private Provider<Optional<RevealPathService>> provideRevealPathServiceProvider;

    @SuppressWarnings("rawtypes")
    private Provider wordEncoderProvider;

    private Provider<SecureRandom> provideCSPRNGProvider;

    private Provider<MasterkeyFileAccess> provideMasterkeyFileAccessProvider;

    private Provider<RecoveryKeyFactory> recoveryKeyFactoryProvider;

    private Provider<Optional<AutoStartProvider>> provideAutostartProvider;

    private Provider<DeviceKey> deviceKeyProvider;

    private Provider<WindowsDriveLetters> windowsDriveLettersProvider;

    private Provider<Set<MountService>> provideSetOfUsedMountServicesProvider;

    private Provider<ObservableValue<MountService>> provideDefaultMountServiceProvider;

    private Provider<Mounter> mounterProvider;

    private CryptomatorComponentImpl(VaultListModule vaultListModuleParam, Long startupTimeParam) {
      this.startupTime = startupTimeParam;
      this.vaultListModule = vaultListModuleParam;
      initialize(vaultListModuleParam, startupTimeParam);
    }

    @SuppressWarnings("unchecked")
    private void initialize(
        final VaultListModule vaultListModuleParam, final Long startupTimeParam) {
      this.provideEnvironmentProvider =
          DoubleCheck.provider(new SwitchingProvider<Environment>(cryptomatorComponentImpl, 4));
      this.shutdownHookProvider =
          DoubleCheck.provider(new SwitchingProvider<ShutdownHook>(cryptomatorComponentImpl, 6));
      this.provideScheduledExecutorServiceProvider =
          DoubleCheck.provider(
              new SwitchingProvider<ScheduledExecutorService>(cryptomatorComponentImpl, 5));
      this.settingsProvider =
          DoubleCheck.provider(
              new SwitchingProvider<SettingsProvider>(cryptomatorComponentImpl, 3));
      this.provideSettingsProvider =
          DoubleCheck.provider(new SwitchingProvider<Settings>(cryptomatorComponentImpl, 2));
      this.debugModeProvider =
          DoubleCheck.provider(new SwitchingProvider<DebugMode>(cryptomatorComponentImpl, 1));
      this.supportedLanguagesProvider =
          DoubleCheck.provider(
              new SwitchingProvider<SupportedLanguages>(cryptomatorComponentImpl, 7));
      this.provideFileOpenRequestsProvider =
          DoubleCheck.provider(
              new SwitchingProvider<BlockingQueue<AppLaunchEvent>>(cryptomatorComponentImpl, 10));
      this.fileOpenRequestHandlerProvider =
          DoubleCheck.provider(
              new SwitchingProvider<FileOpenRequestHandler>(cryptomatorComponentImpl, 9));
      this.ipcMessageHandlerProvider =
          DoubleCheck.provider(
              new SwitchingProvider<IpcMessageHandler>(cryptomatorComponentImpl, 8));
      this.cryptomatorProvider =
          DoubleCheck.provider(new SwitchingProvider<Cryptomator>(cryptomatorComponentImpl, 0));
      this.provideExecutorServiceProvider =
          DoubleCheck.provider(
              new SwitchingProvider<ExecutorService>(cryptomatorComponentImpl, 11));
      this.provideTrayIntegrationProvider =
          DoubleCheck.provider(
              new SwitchingProvider<Optional<TrayIntegrationProvider>>(
                  cryptomatorComponentImpl, 12));
      this.provideVaultListProvider =
          DoubleCheck.provider(
              new SwitchingProvider<ObservableList<Vault>>(cryptomatorComponentImpl, 14));
      this.autoLockerProvider =
          DoubleCheck.provider(new SwitchingProvider<AutoLocker>(cryptomatorComponentImpl, 15));
      this.provideSupportedMountServicesProvider =
          DoubleCheck.provider(
              new SwitchingProvider<List<MountService>>(cryptomatorComponentImpl, 16));
      this.provideLocalizationProvider =
          DoubleCheck.provider(new SwitchingProvider<ResourceBundle>(cryptomatorComponentImpl, 17));
      this.vaultListManagerProvider =
          DoubleCheck.provider(
              new SwitchingProvider<VaultListManager>(cryptomatorComponentImpl, 13));
      this.provideAppearanceProvider =
          DoubleCheck.provider(
              new SwitchingProvider<Optional<UiAppearanceProvider>>(cryptomatorComponentImpl, 18));
      this.provideLicensePublicKeyProvider =
          DoubleCheck.provider(new SwitchingProvider<String>(cryptomatorComponentImpl, 21));
      this.licenseCheckerProvider =
          DoubleCheck.provider(new SwitchingProvider<Object>(cryptomatorComponentImpl, 20));
      this.licenseHolderProvider =
          DoubleCheck.provider(new SwitchingProvider<LicenseHolder>(cryptomatorComponentImpl, 19));
      this.provideSupportedKeychainAccessProvidersProvider =
          DoubleCheck.provider(
              new SwitchingProvider<List<KeychainAccessProvider>>(cryptomatorComponentImpl, 24));
      this.provideKeychainAccessProvider =
          DoubleCheck.provider(
              new SwitchingProvider<ObjectExpression<KeychainAccessProvider>>(
                  cryptomatorComponentImpl, 23));
      this.keychainManagerProvider =
          DoubleCheck.provider(
              new SwitchingProvider<KeychainManager>(cryptomatorComponentImpl, 22));
      this.provideRevealPathServiceProvider =
          DoubleCheck.provider(
              new SwitchingProvider<Optional<RevealPathService>>(cryptomatorComponentImpl, 25));
      this.wordEncoderProvider =
          DoubleCheck.provider(new SwitchingProvider<Object>(cryptomatorComponentImpl, 27));
      this.provideCSPRNGProvider =
          DoubleCheck.provider(new SwitchingProvider<SecureRandom>(cryptomatorComponentImpl, 29));
      this.provideMasterkeyFileAccessProvider =
          DoubleCheck.provider(
              new SwitchingProvider<MasterkeyFileAccess>(cryptomatorComponentImpl, 28));
      this.recoveryKeyFactoryProvider =
          DoubleCheck.provider(
              new SwitchingProvider<RecoveryKeyFactory>(cryptomatorComponentImpl, 26));
      this.provideAutostartProvider =
          DoubleCheck.provider(
              new SwitchingProvider<Optional<AutoStartProvider>>(cryptomatorComponentImpl, 30));
      this.deviceKeyProvider =
          DoubleCheck.provider(new SwitchingProvider<DeviceKey>(cryptomatorComponentImpl, 31));
      this.windowsDriveLettersProvider =
          DoubleCheck.provider(
              new SwitchingProvider<WindowsDriveLetters>(cryptomatorComponentImpl, 32));
      this.provideSetOfUsedMountServicesProvider =
          DoubleCheck.provider(
              new SwitchingProvider<Set<MountService>>(cryptomatorComponentImpl, 34));
      this.provideDefaultMountServiceProvider =
          DoubleCheck.provider(
              new SwitchingProvider<ObservableValue<MountService>>(cryptomatorComponentImpl, 35));
      this.mounterProvider =
          DoubleCheck.provider(new SwitchingProvider<Mounter>(cryptomatorComponentImpl, 33));
    }

    @Override
    public Cryptomator application() {
      return cryptomatorProvider.get();
    }

    @Override
    public FxApplicationComponent.Builder fxAppComponentBuilder() {
      return new FxApplicationComponentBuilder(cryptomatorComponentImpl);
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final CryptomatorComponentImpl cryptomatorComponentImpl;

      private final int id;

      SwitchingProvider(CryptomatorComponentImpl cryptomatorComponentImpl, int id) {
        this.cryptomatorComponentImpl = cryptomatorComponentImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // org.cryptomator.launcher.Cryptomator
            return (T)
                new Cryptomator(
                    cryptomatorComponentImpl.debugModeProvider.get(),
                    cryptomatorComponentImpl.supportedLanguagesProvider.get(),
                    cryptomatorComponentImpl.provideEnvironmentProvider.get(),
                    DoubleCheck.lazy(cryptomatorComponentImpl.ipcMessageHandlerProvider),
                    cryptomatorComponentImpl.shutdownHookProvider.get());

          case 1: // org.cryptomator.logging.DebugMode
            return (T) new DebugMode(cryptomatorComponentImpl.provideSettingsProvider.get());

          case 2: // org.cryptomator.common.settings.Settings
            return (T)
                CommonsModule_ProvideSettingsFactory.provideSettings(
                    cryptomatorComponentImpl.settingsProvider.get());

          case 3: // org.cryptomator.common.settings.SettingsProvider
            return (T)
                new SettingsProvider(
                    cryptomatorComponentImpl.provideEnvironmentProvider.get(),
                    cryptomatorComponentImpl.provideScheduledExecutorServiceProvider.get());

          case 4: // org.cryptomator.common.Environment
            return (T) CommonsModule_ProvideEnvironmentFactory.provideEnvironment();

          case 5: // java.util.concurrent.ScheduledExecutorService
            return (T)
                CommonsModule_ProvideScheduledExecutorServiceFactory
                    .provideScheduledExecutorService(
                        cryptomatorComponentImpl.shutdownHookProvider.get());

          case 6: // org.cryptomator.common.ShutdownHook
            return (T) ShutdownHook_Factory.newInstance();

          case 7: // org.cryptomator.launcher.SupportedLanguages
            return (T)
                new SupportedLanguages(cryptomatorComponentImpl.provideSettingsProvider.get());

          case 8: // org.cryptomator.launcher.IpcMessageHandler
            return (T)
                new IpcMessageHandler(
                    cryptomatorComponentImpl.fileOpenRequestHandlerProvider.get(),
                    cryptomatorComponentImpl.provideFileOpenRequestsProvider.get());

          case 9: // org.cryptomator.launcher.FileOpenRequestHandler
            return (T)
                new FileOpenRequestHandler(
                    cryptomatorComponentImpl.provideFileOpenRequestsProvider.get());

          case 10: // @javax.inject.Named("launchEventQueue")
                   // java.util.concurrent.BlockingQueue<org.cryptomator.launcher.AppLaunchEvent>
            return (T) CryptomatorModule_ProvideFileOpenRequestsFactory.provideFileOpenRequests();

          case 11: // java.util.concurrent.ExecutorService
            return (T)
                CommonsModule_ProvideExecutorServiceFactory.provideExecutorService(
                    cryptomatorComponentImpl.shutdownHookProvider.get());

          case 12: // java.util.Optional<org.cryptomator.integrations.tray.TrayIntegrationProvider>
            return (T)
                CryptomatorModule_ProvideTrayIntegrationProviderFactory
                    .provideTrayIntegrationProvider();

          case 13: // org.cryptomator.common.vaults.VaultListManager
            return (T)
                new VaultListManager(
                    cryptomatorComponentImpl.provideVaultListProvider.get(),
                    cryptomatorComponentImpl.autoLockerProvider.get(),
                    cryptomatorComponentImpl.provideSupportedMountServicesProvider.get(),
                    new VaultComponentFactory(cryptomatorComponentImpl),
                    cryptomatorComponentImpl.provideLocalizationProvider.get(),
                    cryptomatorComponentImpl.provideSettingsProvider.get());

          case 14: // javafx.collections.ObservableList<org.cryptomator.common.vaults.Vault>
            return (T)
                VaultListModule_ProvideVaultListFactory.provideVaultList(
                    cryptomatorComponentImpl.vaultListModule);

          case 15: // org.cryptomator.common.vaults.AutoLocker
            return (T)
                new AutoLocker(
                    cryptomatorComponentImpl.provideScheduledExecutorServiceProvider.get(),
                    cryptomatorComponentImpl.provideVaultListProvider.get());

          case 16: // java.util.List<org.cryptomator.integrations.mount.MountService>
            return (T)
                MountModule_ProvideSupportedMountServicesFactory.provideSupportedMountServices();

          case 17: // java.util.ResourceBundle
            return (T) CryptomatorModule_ProvideLocalizationFactory.provideLocalization();

          case 18: // java.util.Optional<org.cryptomator.integrations.uiappearance.UiAppearanceProvider>
            return (T)
                CryptomatorModule_ProvideAppearanceProviderFactory.provideAppearanceProvider();

          case 19: // org.cryptomator.common.LicenseHolder
            return (T)
                LicenseHolder_Factory.newInstance(
                    cryptomatorComponentImpl.licenseCheckerProvider.get(),
                    cryptomatorComponentImpl.provideSettingsProvider.get());

          case 20: // org.cryptomator.common.LicenseChecker
            return (T)
                LicenseChecker_Factory.newInstance(
                    cryptomatorComponentImpl.provideLicensePublicKeyProvider.get());

          case 21: // @javax.inject.Named("licensePublicKey") java.lang.String
            return (T) CommonsModule_ProvideLicensePublicKeyFactory.provideLicensePublicKey();

          case 22: // org.cryptomator.common.keychain.KeychainManager
            return (T)
                KeychainManager_Factory.newInstance(
                    cryptomatorComponentImpl.provideKeychainAccessProvider.get());

          case 23: // javafx.beans.binding.ObjectExpression<org.cryptomator.integrations.keychain.KeychainAccessProvider>
            return (T)
                KeychainModule_ProvideKeychainAccessProviderFactory.provideKeychainAccessProvider(
                    cryptomatorComponentImpl.provideSettingsProvider.get(),
                    cryptomatorComponentImpl.provideSupportedKeychainAccessProvidersProvider.get());

          case 24: // java.util.List<org.cryptomator.integrations.keychain.KeychainAccessProvider>
            return (T)
                KeychainModule_ProvideSupportedKeychainAccessProvidersFactory
                    .provideSupportedKeychainAccessProviders();

          case 25: // java.util.Optional<org.cryptomator.integrations.revealpath.RevealPathService>
            return (T) CommonsModule_ProvideRevealPathServiceFactory.provideRevealPathService();

          case 26: // org.cryptomator.ui.recoverykey.RecoveryKeyFactory
            return (T)
                RecoveryKeyFactory_Factory.newInstance(
                    cryptomatorComponentImpl.wordEncoderProvider.get(),
                    cryptomatorComponentImpl.provideMasterkeyFileAccessProvider.get());

          case 27: // org.cryptomator.ui.recoverykey.WordEncoder
            return (T) WordEncoder_Factory.newInstance();

          case 28: // org.cryptomator.cryptolib.common.MasterkeyFileAccess
            return (T)
                CommonsModule_ProvideMasterkeyFileAccessFactory.provideMasterkeyFileAccess(
                    cryptomatorComponentImpl.provideCSPRNGProvider.get());

          case 29: // java.security.SecureRandom
            return (T) CommonsModule_ProvideCSPRNGFactory.provideCSPRNG();

          case 30: // java.util.Optional<org.cryptomator.integrations.autostart.AutoStartProvider>
            return (T) CryptomatorModule_ProvideAutostartProviderFactory.provideAutostartProvider();

          case 31: // org.cryptomator.common.settings.DeviceKey
            return (T)
                new DeviceKey(
                    cryptomatorComponentImpl.keychainManagerProvider.get(),
                    cryptomatorComponentImpl.provideEnvironmentProvider.get(),
                    cryptomatorComponentImpl.provideCSPRNGProvider.get());

          case 32: // org.cryptomator.common.mount.WindowsDriveLetters
            return (T) new WindowsDriveLetters();

          case 33: // org.cryptomator.common.mount.Mounter
            return (T)
                new Mounter(
                    cryptomatorComponentImpl.provideEnvironmentProvider.get(),
                    cryptomatorComponentImpl.provideSettingsProvider.get(),
                    cryptomatorComponentImpl.windowsDriveLettersProvider.get(),
                    cryptomatorComponentImpl.provideSupportedMountServicesProvider.get(),
                    cryptomatorComponentImpl.provideSetOfUsedMountServicesProvider.get(),
                    cryptomatorComponentImpl.provideDefaultMountServiceProvider.get());

          case 34: // @javax.inject.Named("usedMountServices")
                   // java.util.Set<org.cryptomator.integrations.mount.MountService>
            return (T)
                MountModule_ProvideSetOfUsedMountServicesFactory.provideSetOfUsedMountServices();

          case 35: // javafx.beans.value.ObservableValue<org.cryptomator.integrations.mount.MountService>
            return (T)
                MountModule_ProvideDefaultMountServiceFactory.provideDefaultMountService(
                    cryptomatorComponentImpl.provideSupportedMountServicesProvider.get(),
                    cryptomatorComponentImpl.provideSettingsProvider.get());

          default:
            throw new AssertionError(id);
        }
      }
    }
  }
}
