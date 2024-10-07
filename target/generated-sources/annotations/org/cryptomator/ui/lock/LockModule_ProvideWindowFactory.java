package org.cryptomator.ui.lock;

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

@ScopeMetadata("org.cryptomator.ui.lock.LockScoped")
@QualifierMetadata({"org.cryptomator.ui.lock.LockWindow", "javax.inject.Named"})
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class LockModule_ProvideWindowFactory implements Factory<Stage> {
  private final Provider<StageFactory> factoryProvider;

  private final Provider<Vault> vaultProvider;

  private final Provider<Stage> ownerProvider;

  public LockModule_ProvideWindowFactory(
      Provider<StageFactory> factoryProvider,
      Provider<Vault> vaultProvider,
      Provider<Stage> ownerProvider) {
    this.factoryProvider = factoryProvider;
    this.vaultProvider = vaultProvider;
    this.ownerProvider = ownerProvider;
  }

  @Override
  public Stage get() {
    return provideWindow(factoryProvider.get(), vaultProvider.get(), ownerProvider.get());
  }

  public static LockModule_ProvideWindowFactory create(
      Provider<StageFactory> factoryProvider,
      Provider<Vault> vaultProvider,
      Provider<Stage> ownerProvider) {
    return new LockModule_ProvideWindowFactory(factoryProvider, vaultProvider, ownerProvider);
  }

  public static Stage provideWindow(StageFactory factory, Vault vault, Stage owner) {
    return Preconditions.checkNotNullFromProvides(LockModule.provideWindow(factory, vault, owner));
  }
}
