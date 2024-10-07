package org.cryptomator.ui.unlock;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javafx.stage.Stage;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.cryptomator.common.vaults.Vault;
import org.cryptomator.ui.keyloading.KeyLoadingComponent;
import org.cryptomator.ui.keyloading.KeyLoadingStrategy;

@ScopeMetadata("org.cryptomator.ui.unlock.UnlockScoped")
@QualifierMetadata("org.cryptomator.ui.unlock.UnlockWindow")
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class UnlockModule_ProvideKeyLoadingStrategyFactory
    implements Factory<KeyLoadingStrategy> {
  private final Provider<KeyLoadingComponent.Builder> compBuilderProvider;

  private final Provider<Vault> vaultProvider;

  private final Provider<Stage> windowProvider;

  public UnlockModule_ProvideKeyLoadingStrategyFactory(
      Provider<KeyLoadingComponent.Builder> compBuilderProvider,
      Provider<Vault> vaultProvider,
      Provider<Stage> windowProvider) {
    this.compBuilderProvider = compBuilderProvider;
    this.vaultProvider = vaultProvider;
    this.windowProvider = windowProvider;
  }

  @Override
  public KeyLoadingStrategy get() {
    return provideKeyLoadingStrategy(
        compBuilderProvider.get(), vaultProvider.get(), windowProvider.get());
  }

  public static UnlockModule_ProvideKeyLoadingStrategyFactory create(
      Provider<KeyLoadingComponent.Builder> compBuilderProvider,
      Provider<Vault> vaultProvider,
      Provider<Stage> windowProvider) {
    return new UnlockModule_ProvideKeyLoadingStrategyFactory(
        compBuilderProvider, vaultProvider, windowProvider);
  }

  public static KeyLoadingStrategy provideKeyLoadingStrategy(
      KeyLoadingComponent.Builder compBuilder, Vault vault, Stage window) {
    return Preconditions.checkNotNullFromProvides(
        UnlockModule.provideKeyLoadingStrategy(compBuilder, vault, window));
  }
}
