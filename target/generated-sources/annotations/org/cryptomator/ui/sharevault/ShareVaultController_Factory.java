package org.cryptomator.ui.sharevault;

import dagger.Lazy;
import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javafx.application.Application;
import javafx.stage.Stage;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.cryptomator.common.vaults.Vault;

@ScopeMetadata("org.cryptomator.ui.sharevault.ShareVaultScoped")
@QualifierMetadata("org.cryptomator.ui.sharevault.ShareVaultWindow")
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class ShareVaultController_Factory implements Factory<ShareVaultController> {
  private final Provider<Stage> windowProvider;

  private final Provider<Application> applicationProvider;

  private final Provider<Vault> vaultProvider;

  public ShareVaultController_Factory(
      Provider<Stage> windowProvider,
      Provider<Application> applicationProvider,
      Provider<Vault> vaultProvider) {
    this.windowProvider = windowProvider;
    this.applicationProvider = applicationProvider;
    this.vaultProvider = vaultProvider;
  }

  @Override
  public ShareVaultController get() {
    return newInstance(
        windowProvider.get(), DoubleCheck.lazy(applicationProvider), vaultProvider.get());
  }

  public static ShareVaultController_Factory create(
      Provider<Stage> windowProvider,
      Provider<Application> applicationProvider,
      Provider<Vault> vaultProvider) {
    return new ShareVaultController_Factory(windowProvider, applicationProvider, vaultProvider);
  }

  public static ShareVaultController newInstance(
      Stage window, Lazy<Application> application, Vault vault) {
    return new ShareVaultController(window, application, vault);
  }
}
