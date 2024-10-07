package org.cryptomator.ui.changepassword;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javafx.stage.Stage;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.cryptomator.common.keychain.KeychainManager;
import org.cryptomator.common.vaults.Vault;
import org.cryptomator.cryptolib.common.MasterkeyFileAccess;
import org.cryptomator.ui.fxapp.FxApplicationWindows;

@ScopeMetadata("org.cryptomator.ui.changepassword.ChangePasswordScoped")
@QualifierMetadata("org.cryptomator.ui.changepassword.ChangePasswordWindow")
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class ChangePasswordController_Factory implements Factory<ChangePasswordController> {
  private final Provider<Stage> windowProvider;

  private final Provider<Vault> vaultProvider;

  private final Provider<FxApplicationWindows> appWindowsProvider;

  private final Provider<KeychainManager> keychainProvider;

  private final Provider<MasterkeyFileAccess> masterkeyFileAccessProvider;

  public ChangePasswordController_Factory(
      Provider<Stage> windowProvider,
      Provider<Vault> vaultProvider,
      Provider<FxApplicationWindows> appWindowsProvider,
      Provider<KeychainManager> keychainProvider,
      Provider<MasterkeyFileAccess> masterkeyFileAccessProvider) {
    this.windowProvider = windowProvider;
    this.vaultProvider = vaultProvider;
    this.appWindowsProvider = appWindowsProvider;
    this.keychainProvider = keychainProvider;
    this.masterkeyFileAccessProvider = masterkeyFileAccessProvider;
  }

  @Override
  public ChangePasswordController get() {
    return newInstance(
        windowProvider.get(),
        vaultProvider.get(),
        appWindowsProvider.get(),
        keychainProvider.get(),
        masterkeyFileAccessProvider.get());
  }

  public static ChangePasswordController_Factory create(
      Provider<Stage> windowProvider,
      Provider<Vault> vaultProvider,
      Provider<FxApplicationWindows> appWindowsProvider,
      Provider<KeychainManager> keychainProvider,
      Provider<MasterkeyFileAccess> masterkeyFileAccessProvider) {
    return new ChangePasswordController_Factory(
        windowProvider,
        vaultProvider,
        appWindowsProvider,
        keychainProvider,
        masterkeyFileAccessProvider);
  }

  public static ChangePasswordController newInstance(
      Stage window,
      Vault vault,
      FxApplicationWindows appWindows,
      KeychainManager keychain,
      MasterkeyFileAccess masterkeyFileAccess) {
    return new ChangePasswordController(window, vault, appWindows, keychain, masterkeyFileAccess);
  }
}
