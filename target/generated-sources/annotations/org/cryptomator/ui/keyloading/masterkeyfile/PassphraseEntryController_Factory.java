package org.cryptomator.ui.keyloading.masterkeyfile;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.util.concurrent.CompletableFuture;
import javafx.stage.Stage;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.cryptomator.common.Passphrase;
import org.cryptomator.common.keychain.KeychainManager;
import org.cryptomator.common.vaults.Vault;
import org.cryptomator.ui.forgetpassword.ForgetPasswordComponent;

@ScopeMetadata("org.cryptomator.ui.keyloading.masterkeyfile.PassphraseEntryScoped")
@QualifierMetadata({"org.cryptomator.ui.keyloading.KeyLoading", "javax.inject.Named"})
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class PassphraseEntryController_Factory implements Factory<PassphraseEntryController> {
  private final Provider<Stage> windowProvider;

  private final Provider<Vault> vaultProvider;

  private final Provider<CompletableFuture<PassphraseEntryResult>> resultProvider;

  private final Provider<Passphrase> savedPasswordProvider;

  private final Provider<ForgetPasswordComponent.Builder> forgetPasswordProvider;

  private final Provider<KeychainManager> keychainProvider;

  public PassphraseEntryController_Factory(
      Provider<Stage> windowProvider,
      Provider<Vault> vaultProvider,
      Provider<CompletableFuture<PassphraseEntryResult>> resultProvider,
      Provider<Passphrase> savedPasswordProvider,
      Provider<ForgetPasswordComponent.Builder> forgetPasswordProvider,
      Provider<KeychainManager> keychainProvider) {
    this.windowProvider = windowProvider;
    this.vaultProvider = vaultProvider;
    this.resultProvider = resultProvider;
    this.savedPasswordProvider = savedPasswordProvider;
    this.forgetPasswordProvider = forgetPasswordProvider;
    this.keychainProvider = keychainProvider;
  }

  @Override
  public PassphraseEntryController get() {
    return newInstance(
        windowProvider.get(),
        vaultProvider.get(),
        resultProvider.get(),
        savedPasswordProvider.get(),
        forgetPasswordProvider.get(),
        keychainProvider.get());
  }

  public static PassphraseEntryController_Factory create(
      Provider<Stage> windowProvider,
      Provider<Vault> vaultProvider,
      Provider<CompletableFuture<PassphraseEntryResult>> resultProvider,
      Provider<Passphrase> savedPasswordProvider,
      Provider<ForgetPasswordComponent.Builder> forgetPasswordProvider,
      Provider<KeychainManager> keychainProvider) {
    return new PassphraseEntryController_Factory(
        windowProvider,
        vaultProvider,
        resultProvider,
        savedPasswordProvider,
        forgetPasswordProvider,
        keychainProvider);
  }

  public static PassphraseEntryController newInstance(
      Stage window,
      Vault vault,
      CompletableFuture<PassphraseEntryResult> result,
      Passphrase savedPassword,
      ForgetPasswordComponent.Builder forgetPassword,
      KeychainManager keychain) {
    return new PassphraseEntryController(
        window, vault, result, savedPassword, forgetPassword, keychain);
  }
}
