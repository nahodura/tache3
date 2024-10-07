package org.cryptomator.ui.addvaultwizard;

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
import org.cryptomator.ui.common.FxController;

@ScopeMetadata
@QualifierMetadata({"org.cryptomator.ui.addvaultwizard.AddVaultWizardWindow", "javax.inject.Named"})
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class AddVaultModule_ProvideRecoveryKeyDisplayControllerFactory
    implements Factory<FxController> {
  private final Provider<Stage> windowProvider;

  private final Provider<StringProperty> vaultNameProvider;

  private final Provider<StringProperty> recoveryKeyProvider;

  private final Provider<ResourceBundle> localizationProvider;

  public AddVaultModule_ProvideRecoveryKeyDisplayControllerFactory(
      Provider<Stage> windowProvider,
      Provider<StringProperty> vaultNameProvider,
      Provider<StringProperty> recoveryKeyProvider,
      Provider<ResourceBundle> localizationProvider) {
    this.windowProvider = windowProvider;
    this.vaultNameProvider = vaultNameProvider;
    this.recoveryKeyProvider = recoveryKeyProvider;
    this.localizationProvider = localizationProvider;
  }

  @Override
  public FxController get() {
    return provideRecoveryKeyDisplayController(
        windowProvider.get(),
        vaultNameProvider.get(),
        recoveryKeyProvider.get(),
        localizationProvider.get());
  }

  public static AddVaultModule_ProvideRecoveryKeyDisplayControllerFactory create(
      Provider<Stage> windowProvider,
      Provider<StringProperty> vaultNameProvider,
      Provider<StringProperty> recoveryKeyProvider,
      Provider<ResourceBundle> localizationProvider) {
    return new AddVaultModule_ProvideRecoveryKeyDisplayControllerFactory(
        windowProvider, vaultNameProvider, recoveryKeyProvider, localizationProvider);
  }

  public static FxController provideRecoveryKeyDisplayController(
      Stage window,
      StringProperty vaultName,
      StringProperty recoveryKey,
      ResourceBundle localization) {
    return Preconditions.checkNotNullFromProvides(
        AddVaultModule.provideRecoveryKeyDisplayController(
            window, vaultName, recoveryKey, localization));
  }
}
