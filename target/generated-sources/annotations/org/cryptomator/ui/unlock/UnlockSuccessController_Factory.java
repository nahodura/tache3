package org.cryptomator.ui.unlock;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.util.concurrent.ExecutorService;
import javafx.stage.Stage;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.cryptomator.common.vaults.Vault;
import org.cryptomator.ui.common.VaultService;

@ScopeMetadata("org.cryptomator.ui.unlock.UnlockScoped")
@QualifierMetadata("org.cryptomator.ui.unlock.UnlockWindow")
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class UnlockSuccessController_Factory implements Factory<UnlockSuccessController> {
  private final Provider<Stage> windowProvider;

  private final Provider<Vault> vaultProvider;

  private final Provider<ExecutorService> executorProvider;

  private final Provider<VaultService> vaultServiceProvider;

  public UnlockSuccessController_Factory(
      Provider<Stage> windowProvider,
      Provider<Vault> vaultProvider,
      Provider<ExecutorService> executorProvider,
      Provider<VaultService> vaultServiceProvider) {
    this.windowProvider = windowProvider;
    this.vaultProvider = vaultProvider;
    this.executorProvider = executorProvider;
    this.vaultServiceProvider = vaultServiceProvider;
  }

  @Override
  public UnlockSuccessController get() {
    return newInstance(
        windowProvider.get(),
        vaultProvider.get(),
        executorProvider.get(),
        vaultServiceProvider.get());
  }

  public static UnlockSuccessController_Factory create(
      Provider<Stage> windowProvider,
      Provider<Vault> vaultProvider,
      Provider<ExecutorService> executorProvider,
      Provider<VaultService> vaultServiceProvider) {
    return new UnlockSuccessController_Factory(
        windowProvider, vaultProvider, executorProvider, vaultServiceProvider);
  }

  public static UnlockSuccessController newInstance(
      Stage window, Vault vault, ExecutorService executor, VaultService vaultService) {
    return new UnlockSuccessController(window, vault, executor, vaultService);
  }
}
