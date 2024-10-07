package org.cryptomator.ui.forgetpassword;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javafx.beans.property.BooleanProperty;
import javafx.stage.Stage;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.cryptomator.common.keychain.KeychainManager;
import org.cryptomator.common.vaults.Vault;

@ScopeMetadata("org.cryptomator.ui.forgetpassword.ForgetPasswordScoped")
@QualifierMetadata("org.cryptomator.ui.forgetpassword.ForgetPasswordWindow")
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class ForgetPasswordController_Factory implements Factory<ForgetPasswordController> {
  private final Provider<Stage> windowProvider;

  private final Provider<Vault> vaultProvider;

  private final Provider<KeychainManager> keychainProvider;

  private final Provider<BooleanProperty> confirmedResultProvider;

  public ForgetPasswordController_Factory(
      Provider<Stage> windowProvider,
      Provider<Vault> vaultProvider,
      Provider<KeychainManager> keychainProvider,
      Provider<BooleanProperty> confirmedResultProvider) {
    this.windowProvider = windowProvider;
    this.vaultProvider = vaultProvider;
    this.keychainProvider = keychainProvider;
    this.confirmedResultProvider = confirmedResultProvider;
  }

  @Override
  public ForgetPasswordController get() {
    return newInstance(
        windowProvider.get(),
        vaultProvider.get(),
        keychainProvider.get(),
        confirmedResultProvider.get());
  }

  public static ForgetPasswordController_Factory create(
      Provider<Stage> windowProvider,
      Provider<Vault> vaultProvider,
      Provider<KeychainManager> keychainProvider,
      Provider<BooleanProperty> confirmedResultProvider) {
    return new ForgetPasswordController_Factory(
        windowProvider, vaultProvider, keychainProvider, confirmedResultProvider);
  }

  public static ForgetPasswordController newInstance(
      Stage window, Vault vault, KeychainManager keychain, BooleanProperty confirmedResult) {
    return new ForgetPasswordController(window, vault, keychain, confirmedResult);
  }
}
