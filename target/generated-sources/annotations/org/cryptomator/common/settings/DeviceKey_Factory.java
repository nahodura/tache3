package org.cryptomator.common.settings;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.security.SecureRandom;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.cryptomator.common.Environment;
import org.cryptomator.common.keychain.KeychainManager;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class DeviceKey_Factory implements Factory<DeviceKey> {
  private final Provider<KeychainManager> keychainManagerProvider;

  private final Provider<Environment> envProvider;

  private final Provider<SecureRandom> csprngProvider;

  public DeviceKey_Factory(
      Provider<KeychainManager> keychainManagerProvider,
      Provider<Environment> envProvider,
      Provider<SecureRandom> csprngProvider) {
    this.keychainManagerProvider = keychainManagerProvider;
    this.envProvider = envProvider;
    this.csprngProvider = csprngProvider;
  }

  @Override
  public DeviceKey get() {
    return newInstance(keychainManagerProvider.get(), envProvider.get(), csprngProvider.get());
  }

  public static DeviceKey_Factory create(
      Provider<KeychainManager> keychainManagerProvider,
      Provider<Environment> envProvider,
      Provider<SecureRandom> csprngProvider) {
    return new DeviceKey_Factory(keychainManagerProvider, envProvider, csprngProvider);
  }

  public static DeviceKey newInstance(
      KeychainManager keychainManager, Environment env, SecureRandom csprng) {
    return new DeviceKey(keychainManager, env, csprng);
  }
}
