package org.cryptomator.common.keychain;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.util.List;
import javax.annotation.processing.Generated;
import org.cryptomator.integrations.keychain.KeychainAccessProvider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class KeychainModule_ProvideSupportedKeychainAccessProvidersFactory
    implements Factory<List<KeychainAccessProvider>> {
  @Override
  public List<KeychainAccessProvider> get() {
    return provideSupportedKeychainAccessProviders();
  }

  public static KeychainModule_ProvideSupportedKeychainAccessProvidersFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static List<KeychainAccessProvider> provideSupportedKeychainAccessProviders() {
    return Preconditions.checkNotNullFromProvides(
        KeychainModule.provideSupportedKeychainAccessProviders());
  }

  private static final class InstanceHolder {
    private static final KeychainModule_ProvideSupportedKeychainAccessProvidersFactory INSTANCE =
        new KeychainModule_ProvideSupportedKeychainAccessProvidersFactory();
  }
}
