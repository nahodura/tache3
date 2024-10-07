package org.cryptomator.ui.keyloading.masterkeyfile;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.stage.Stage;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.cryptomator.common.keychain.KeychainManager;
import org.cryptomator.common.vaults.Vault;
import org.cryptomator.cryptolib.common.MasterkeyFileAccess;

@ScopeMetadata
@QualifierMetadata({"org.cryptomator.ui.keyloading.KeyLoading", "javax.inject.Named"})
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class MasterkeyFileLoadingStrategy_Factory
    implements Factory<MasterkeyFileLoadingStrategy> {
  private final Provider<Vault> vaultProvider;

  private final Provider<MasterkeyFileAccess> masterkeyFileAccessProvider;

  private final Provider<Stage> windowProvider;

  private final Provider<Optional<char[]>> savedPassphraseProvider;

  private final Provider<PassphraseEntryComponent.Builder> passphraseEntryProvider;

  private final Provider<ChooseMasterkeyFileComponent.Builder> masterkeyFileChoiceProvider;

  private final Provider<KeychainManager> keychainProvider;

  private final Provider<ResourceBundle> resourceBundleProvider;

  public MasterkeyFileLoadingStrategy_Factory(
      Provider<Vault> vaultProvider,
      Provider<MasterkeyFileAccess> masterkeyFileAccessProvider,
      Provider<Stage> windowProvider,
      Provider<Optional<char[]>> savedPassphraseProvider,
      Provider<PassphraseEntryComponent.Builder> passphraseEntryProvider,
      Provider<ChooseMasterkeyFileComponent.Builder> masterkeyFileChoiceProvider,
      Provider<KeychainManager> keychainProvider,
      Provider<ResourceBundle> resourceBundleProvider) {
    this.vaultProvider = vaultProvider;
    this.masterkeyFileAccessProvider = masterkeyFileAccessProvider;
    this.windowProvider = windowProvider;
    this.savedPassphraseProvider = savedPassphraseProvider;
    this.passphraseEntryProvider = passphraseEntryProvider;
    this.masterkeyFileChoiceProvider = masterkeyFileChoiceProvider;
    this.keychainProvider = keychainProvider;
    this.resourceBundleProvider = resourceBundleProvider;
  }

  @Override
  public MasterkeyFileLoadingStrategy get() {
    return newInstance(
        vaultProvider.get(),
        masterkeyFileAccessProvider.get(),
        windowProvider.get(),
        savedPassphraseProvider.get(),
        passphraseEntryProvider.get(),
        masterkeyFileChoiceProvider.get(),
        keychainProvider.get(),
        resourceBundleProvider.get());
  }

  public static MasterkeyFileLoadingStrategy_Factory create(
      Provider<Vault> vaultProvider,
      Provider<MasterkeyFileAccess> masterkeyFileAccessProvider,
      Provider<Stage> windowProvider,
      Provider<Optional<char[]>> savedPassphraseProvider,
      Provider<PassphraseEntryComponent.Builder> passphraseEntryProvider,
      Provider<ChooseMasterkeyFileComponent.Builder> masterkeyFileChoiceProvider,
      Provider<KeychainManager> keychainProvider,
      Provider<ResourceBundle> resourceBundleProvider) {
    return new MasterkeyFileLoadingStrategy_Factory(
        vaultProvider,
        masterkeyFileAccessProvider,
        windowProvider,
        savedPassphraseProvider,
        passphraseEntryProvider,
        masterkeyFileChoiceProvider,
        keychainProvider,
        resourceBundleProvider);
  }

  public static MasterkeyFileLoadingStrategy newInstance(
      Vault vault,
      MasterkeyFileAccess masterkeyFileAccess,
      Stage window,
      Optional<char[]> savedPassphrase,
      PassphraseEntryComponent.Builder passphraseEntry,
      ChooseMasterkeyFileComponent.Builder masterkeyFileChoice,
      KeychainManager keychain,
      ResourceBundle resourceBundle) {
    return new MasterkeyFileLoadingStrategy(
        vault,
        masterkeyFileAccess,
        window,
        savedPassphrase,
        passphraseEntry,
        masterkeyFileChoice,
        keychain,
        resourceBundle);
  }
}
