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
import org.cryptomator.ui.common.StageFactory;

@ScopeMetadata("org.cryptomator.ui.unlock.UnlockScoped")
@QualifierMetadata({"org.cryptomator.ui.unlock.UnlockWindow", "javax.inject.Named"})
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class UnlockModule_ProvideStageFactory implements Factory<Stage> {
  private final Provider<StageFactory> factoryProvider;

  private final Provider<Vault> vaultProvider;

  private final Provider<Stage> ownerProvider;

  public UnlockModule_ProvideStageFactory(
      Provider<StageFactory> factoryProvider,
      Provider<Vault> vaultProvider,
      Provider<Stage> ownerProvider) {
    this.factoryProvider = factoryProvider;
    this.vaultProvider = vaultProvider;
    this.ownerProvider = ownerProvider;
  }

  @Override
  public Stage get() {
    return provideStage(factoryProvider.get(), vaultProvider.get(), ownerProvider.get());
  }

  public static UnlockModule_ProvideStageFactory create(
      Provider<StageFactory> factoryProvider,
      Provider<Vault> vaultProvider,
      Provider<Stage> ownerProvider) {
    return new UnlockModule_ProvideStageFactory(factoryProvider, vaultProvider, ownerProvider);
  }

  public static Stage provideStage(StageFactory factory, Vault vault, Stage owner) {
    return Preconditions.checkNotNullFromProvides(UnlockModule.provideStage(factory, vault, owner));
  }
}
