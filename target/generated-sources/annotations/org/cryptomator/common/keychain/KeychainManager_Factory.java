package org.cryptomator.common.keychain;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javafx.beans.binding.ObjectExpression;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.cryptomator.integrations.keychain.KeychainAccessProvider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class KeychainManager_Factory implements Factory<KeychainManager> {
  private final Provider<ObjectExpression<KeychainAccessProvider>> selectedKeychainProvider;

  public KeychainManager_Factory(
      Provider<ObjectExpression<KeychainAccessProvider>> selectedKeychainProvider) {
    this.selectedKeychainProvider = selectedKeychainProvider;
  }

  @Override
  public KeychainManager get() {
    return newInstance(selectedKeychainProvider.get());
  }

  public static KeychainManager_Factory create(
      Provider<ObjectExpression<KeychainAccessProvider>> selectedKeychainProvider) {
    return new KeychainManager_Factory(selectedKeychainProvider);
  }

  public static KeychainManager newInstance(
      ObjectExpression<KeychainAccessProvider> selectedKeychain) {
    return new KeychainManager(selectedKeychain);
  }
}
