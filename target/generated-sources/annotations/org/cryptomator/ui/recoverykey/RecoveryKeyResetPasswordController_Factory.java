package org.cryptomator.ui.recoverykey;

import dagger.Lazy;
import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
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
public final class RecoveryKeyResetPasswordController_Factory
    implements Factory<RecoveryKeyResetPasswordController> {
  private final Provider<Stage> windowProvider;

  private final Provider<Vault> vaultProvider;

  private final Provider<RecoveryKeyFactory> recoveryKeyFactoryProvider;

  private final Provider<ExecutorService> executorProvider;

  private final Provider<StringProperty> recoveryKeyProvider;

  private final Provider<Scene> recoverResetPasswordSuccessSceneProvider;

  private final Provider<FxApplicationWindows> appWindowsProvider;

  public RecoveryKeyResetPasswordController_Factory(
      Provider<Stage> windowProvider,
      Provider<Vault> vaultProvider,
      Provider<RecoveryKeyFactory> recoveryKeyFactoryProvider,
      Provider<ExecutorService> executorProvider,
      Provider<StringProperty> recoveryKeyProvider,
      Provider<Scene> recoverResetPasswordSuccessSceneProvider,
      Provider<FxApplicationWindows> appWindowsProvider) {
    this.windowProvider = windowProvider;
    this.vaultProvider = vaultProvider;
    this.recoveryKeyFactoryProvider = recoveryKeyFactoryProvider;
    this.executorProvider = executorProvider;
    this.recoveryKeyProvider = recoveryKeyProvider;
    this.recoverResetPasswordSuccessSceneProvider = recoverResetPasswordSuccessSceneProvider;
    this.appWindowsProvider = appWindowsProvider;
  }

  @Override
  public RecoveryKeyResetPasswordController get() {
    return newInstance(
        windowProvider.get(),
        vaultProvider.get(),
        recoveryKeyFactoryProvider.get(),
        executorProvider.get(),
        recoveryKeyProvider.get(),
        DoubleCheck.lazy(recoverResetPasswordSuccessSceneProvider),
        appWindowsProvider.get());
  }

  public static RecoveryKeyResetPasswordController_Factory create(
      Provider<Stage> windowProvider,
      Provider<Vault> vaultProvider,
      Provider<RecoveryKeyFactory> recoveryKeyFactoryProvider,
      Provider<ExecutorService> executorProvider,
      Provider<StringProperty> recoveryKeyProvider,
      Provider<Scene> recoverResetPasswordSuccessSceneProvider,
      Provider<FxApplicationWindows> appWindowsProvider) {
    return new RecoveryKeyResetPasswordController_Factory(
        windowProvider,
        vaultProvider,
        recoveryKeyFactoryProvider,
        executorProvider,
        recoveryKeyProvider,
        recoverResetPasswordSuccessSceneProvider,
        appWindowsProvider);
  }

  public static RecoveryKeyResetPasswordController newInstance(
      Stage window,
      Vault vault,
      RecoveryKeyFactory recoveryKeyFactory,
      ExecutorService executor,
      StringProperty recoveryKey,
      Lazy<Scene> recoverResetPasswordSuccessScene,
      FxApplicationWindows appWindows) {
    return new RecoveryKeyResetPasswordController(
        window,
        vault,
        recoveryKeyFactory,
        executor,
        recoveryKey,
        recoverResetPasswordSuccessScene,
        appWindows);
  }
}
