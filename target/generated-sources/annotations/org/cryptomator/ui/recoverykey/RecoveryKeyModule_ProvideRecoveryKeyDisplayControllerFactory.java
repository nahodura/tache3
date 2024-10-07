package org.cryptomator.ui.recoverykey;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.util.ResourceBundle;
import javafx.beans.property.StringProperty;
import javafx.stage.Stage;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.cryptomator.common.vaults.Vault;
import org.cryptomator.ui.common.FxController;

@ScopeMetadata
@QualifierMetadata("org.cryptomator.ui.recoverykey.RecoveryKeyWindow")
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class RecoveryKeyModule_ProvideRecoveryKeyDisplayControllerFactory
    implements Factory<FxController> {
  private final Provider<Stage> windowProvider;

  private final Provider<Vault> vaultProvider;

  private final Provider<StringProperty> recoveryKeyProvider;

  private final Provider<ResourceBundle> localizationProvider;

  public RecoveryKeyModule_ProvideRecoveryKeyDisplayControllerFactory(
      Provider<Stage> windowProvider,
      Provider<Vault> vaultProvider,
      Provider<StringProperty> recoveryKeyProvider,
      Provider<ResourceBundle> localizationProvider) {
    this.windowProvider = windowProvider;
    this.vaultProvider = vaultProvider;
    this.recoveryKeyProvider = recoveryKeyProvider;
    this.localizationProvider = localizationProvider;
  }

  @Override
  public FxController get() {
    return provideRecoveryKeyDisplayController(
        windowProvider.get(),
        vaultProvider.get(),
        recoveryKeyProvider.get(),
        localizationProvider.get());
  }

  public static RecoveryKeyModule_ProvideRecoveryKeyDisplayControllerFactory create(
      Provider<Stage> windowProvider,
      Provider<Vault> vaultProvider,
      Provider<StringProperty> recoveryKeyProvider,
      Provider<ResourceBundle> localizationProvider) {
    return new RecoveryKeyModule_ProvideRecoveryKeyDisplayControllerFactory(
        windowProvider, vaultProvider, recoveryKeyProvider, localizationProvider);
  }

  public static FxController provideRecoveryKeyDisplayController(
      Stage window, Vault vault, StringProperty recoveryKey, ResourceBundle localization) {
    return Preconditions.checkNotNullFromProvides(
        RecoveryKeyModule.provideRecoveryKeyDisplayController(
            window, vault, recoveryKey, localization));
  }
}
