package org.cryptomator.ui.unlock;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.util.ResourceBundle;
import javafx.beans.property.ObjectProperty;
import javafx.stage.Stage;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.cryptomator.common.mount.IllegalMountPointException;
import org.cryptomator.common.vaults.Vault;
import org.cryptomator.ui.fxapp.FxApplicationWindows;

@ScopeMetadata("org.cryptomator.ui.unlock.UnlockScoped")
@QualifierMetadata("org.cryptomator.ui.unlock.UnlockWindow")
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class UnlockInvalidMountPointController_Factory
    implements Factory<UnlockInvalidMountPointController> {
  private final Provider<Stage> windowProvider;

  private final Provider<Vault> vaultProvider;

  private final Provider<ObjectProperty<IllegalMountPointException>>
      illegalMountPointExceptionProvider;

  private final Provider<FxApplicationWindows> appWindowsProvider;

  private final Provider<ResourceBundle> resourceBundleProvider;

  public UnlockInvalidMountPointController_Factory(
      Provider<Stage> windowProvider,
      Provider<Vault> vaultProvider,
      Provider<ObjectProperty<IllegalMountPointException>> illegalMountPointExceptionProvider,
      Provider<FxApplicationWindows> appWindowsProvider,
      Provider<ResourceBundle> resourceBundleProvider) {
    this.windowProvider = windowProvider;
    this.vaultProvider = vaultProvider;
    this.illegalMountPointExceptionProvider = illegalMountPointExceptionProvider;
    this.appWindowsProvider = appWindowsProvider;
    this.resourceBundleProvider = resourceBundleProvider;
  }

  @Override
  public UnlockInvalidMountPointController get() {
    return newInstance(
        windowProvider.get(),
        vaultProvider.get(),
        illegalMountPointExceptionProvider.get(),
        appWindowsProvider.get(),
        resourceBundleProvider.get());
  }

  public static UnlockInvalidMountPointController_Factory create(
      Provider<Stage> windowProvider,
      Provider<Vault> vaultProvider,
      Provider<ObjectProperty<IllegalMountPointException>> illegalMountPointExceptionProvider,
      Provider<FxApplicationWindows> appWindowsProvider,
      Provider<ResourceBundle> resourceBundleProvider) {
    return new UnlockInvalidMountPointController_Factory(
        windowProvider,
        vaultProvider,
        illegalMountPointExceptionProvider,
        appWindowsProvider,
        resourceBundleProvider);
  }

  public static UnlockInvalidMountPointController newInstance(
      Stage window,
      Vault vault,
      ObjectProperty<IllegalMountPointException> illegalMountPointException,
      FxApplicationWindows appWindows,
      ResourceBundle resourceBundle) {
    return new UnlockInvalidMountPointController(
        window, vault, illegalMountPointException, appWindows, resourceBundle);
  }
}
