package org.cryptomator.common.keychain;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.util.List;
import javafx.beans.binding.ObjectExpression;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.cryptomator.common.settings.Settings;
import org.cryptomator.integrations.keychain.KeychainAccessProvider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class KeychainModule_ProvideKeychainAccessProviderFactory
    implements Factory<ObjectExpression<KeychainAccessProvider>> {
  private final Provider<Settings> settingsProvider;

  private final Provider<List<KeychainAccessProvider>> providersProvider;

  public KeychainModule_ProvideKeychainAccessProviderFactory(
      Provider<Settings> settingsProvider,
      Provider<List<KeychainAccessProvider>> providersProvider) {
    this.settingsProvider = settingsProvider;
    this.providersProvider = providersProvider;
  }

  @Override
  public ObjectExpression<KeychainAccessProvider> get() {
    return provideKeychainAccessProvider(settingsProvider.get(), providersProvider.get());
  }

  public static KeychainModule_ProvideKeychainAccessProviderFactory create(
      Provider<Settings> settingsProvider,
      Provider<List<KeychainAccessProvider>> providersProvider) {
    return new KeychainModule_ProvideKeychainAccessProviderFactory(
        settingsProvider, providersProvider);
  }

  public static ObjectExpression<KeychainAccessProvider> provideKeychainAccessProvider(
      Settings settings, List<KeychainAccessProvider> providers) {
    return Preconditions.checkNotNullFromProvides(
        KeychainModule.provideKeychainAccessProvider(settings, providers));
  }
}
