package org.cryptomator.ui.vaultoptions;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javafx.stage.Stage;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.cryptomator.common.keychain.KeychainManager;
import org.cryptomator.common.vaults.Vault;
import org.cryptomator.ui.changepassword.ChangePasswordComponent;
import org.cryptomator.ui.forgetpassword.ForgetPasswordComponent;
import org.cryptomator.ui.recoverykey.RecoveryKeyComponent;

@ScopeMetadata("org.cryptomator.ui.vaultoptions.VaultOptionsScoped")
@QualifierMetadata("org.cryptomator.ui.vaultoptions.VaultOptionsWindow")
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class MasterkeyOptionsController_Factory
    implements Factory<MasterkeyOptionsController> {
  private final Provider<Vault> vaultProvider;

  private final Provider<Stage> windowProvider;

  private final Provider<ChangePasswordComponent.Builder> changePasswordWindowProvider;

  private final Provider<RecoveryKeyComponent.Factory> recoveryKeyWindowProvider;

  private final Provider<ForgetPasswordComponent.Builder> forgetPasswordWindowProvider;

  private final Provider<KeychainManager> keychainProvider;

  public MasterkeyOptionsController_Factory(
      Provider<Vault> vaultProvider,
      Provider<Stage> windowProvider,
      Provider<ChangePasswordComponent.Builder> changePasswordWindowProvider,
      Provider<RecoveryKeyComponent.Factory> recoveryKeyWindowProvider,
      Provider<ForgetPasswordComponent.Builder> forgetPasswordWindowProvider,
      Provider<KeychainManager> keychainProvider) {
    this.vaultProvider = vaultProvider;
    this.windowProvider = windowProvider;
    this.changePasswordWindowProvider = changePasswordWindowProvider;
    this.recoveryKeyWindowProvider = recoveryKeyWindowProvider;
    this.forgetPasswordWindowProvider = forgetPasswordWindowProvider;
    this.keychainProvider = keychainProvider;
  }

  @Override
  public MasterkeyOptionsController get() {
    return newInstance(
        vaultProvider.get(),
        windowProvider.get(),
        changePasswordWindowProvider.get(),
        recoveryKeyWindowProvider.get(),
        forgetPasswordWindowProvider.get(),
        keychainProvider.get());
  }

  public static MasterkeyOptionsController_Factory create(
      Provider<Vault> vaultProvider,
      Provider<Stage> windowProvider,
      Provider<ChangePasswordComponent.Builder> changePasswordWindowProvider,
      Provider<RecoveryKeyComponent.Factory> recoveryKeyWindowProvider,
      Provider<ForgetPasswordComponent.Builder> forgetPasswordWindowProvider,
      Provider<KeychainManager> keychainProvider) {
    return new MasterkeyOptionsController_Factory(
        vaultProvider,
        windowProvider,
        changePasswordWindowProvider,
        recoveryKeyWindowProvider,
        forgetPasswordWindowProvider,
        keychainProvider);
  }

  public static MasterkeyOptionsController newInstance(
      Vault vault,
      Stage window,
      ChangePasswordComponent.Builder changePasswordWindow,
      RecoveryKeyComponent.Factory recoveryKeyWindow,
      ForgetPasswordComponent.Builder forgetPasswordWindow,
      KeychainManager keychain) {
    return new MasterkeyOptionsController(
        vault, window, changePasswordWindow, recoveryKeyWindow, forgetPasswordWindow, keychain);
  }
}
