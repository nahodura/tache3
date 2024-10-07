package org.cryptomator.ui.lock;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javafx.stage.Stage;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.cryptomator.common.vaults.Vault;

@ScopeMetadata("org.cryptomator.ui.lock.LockScoped")
@QualifierMetadata("org.cryptomator.ui.lock.LockWindow")
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class LockFailedController_Factory implements Factory<LockFailedController> {
  private final Provider<Stage> windowProvider;

  private final Provider<Vault> vaultProvider;

  public LockFailedController_Factory(
      Provider<Stage> windowProvider, Provider<Vault> vaultProvider) {
    this.windowProvider = windowProvider;
    this.vaultProvider = vaultProvider;
  }

  @Override
  public LockFailedController get() {
    return newInstance(windowProvider.get(), vaultProvider.get());
  }

  public static LockFailedController_Factory create(
      Provider<Stage> windowProvider, Provider<Vault> vaultProvider) {
    return new LockFailedController_Factory(windowProvider, vaultProvider);
  }

  public static LockFailedController newInstance(Stage window, Vault vault) {
    return new LockFailedController(window, vault);
  }
}
