package org.cryptomator.ui.keyloading;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.util.Map;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.cryptomator.common.vaults.Vault;

@ScopeMetadata("org.cryptomator.ui.keyloading.KeyLoadingScoped")
@QualifierMetadata("org.cryptomator.ui.keyloading.KeyLoading")
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class KeyLoadingModule_ProvideKeyLoadingStrategyFactory
    implements Factory<KeyLoadingStrategy> {
  private final Provider<Vault> vaultProvider;

  private final Provider<Map<String, Provider<KeyLoadingStrategy>>> strategiesProvider;

  public KeyLoadingModule_ProvideKeyLoadingStrategyFactory(
      Provider<Vault> vaultProvider,
      Provider<Map<String, Provider<KeyLoadingStrategy>>> strategiesProvider) {
    this.vaultProvider = vaultProvider;
    this.strategiesProvider = strategiesProvider;
  }

  @Override
  public KeyLoadingStrategy get() {
    return provideKeyLoadingStrategy(vaultProvider.get(), strategiesProvider.get());
  }

  public static KeyLoadingModule_ProvideKeyLoadingStrategyFactory create(
      Provider<Vault> vaultProvider,
      Provider<Map<String, Provider<KeyLoadingStrategy>>> strategiesProvider) {
    return new KeyLoadingModule_ProvideKeyLoadingStrategyFactory(vaultProvider, strategiesProvider);
  }

  public static KeyLoadingStrategy provideKeyLoadingStrategy(
      Vault vault, Map<String, Provider<KeyLoadingStrategy>> strategies) {
    return Preconditions.checkNotNullFromProvides(
        KeyLoadingModule.provideKeyLoadingStrategy(vault, strategies));
  }
}
