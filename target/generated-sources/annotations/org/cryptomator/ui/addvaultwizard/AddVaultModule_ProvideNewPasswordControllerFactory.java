package org.cryptomator.ui.addvaultwizard;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.util.ResourceBundle;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.cryptomator.ui.changepassword.PasswordStrengthUtil;
import org.cryptomator.ui.common.FxController;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class AddVaultModule_ProvideNewPasswordControllerFactory
    implements Factory<FxController> {
  private final Provider<ResourceBundle> resourceBundleProvider;

  private final Provider<PasswordStrengthUtil> strengthRaterProvider;

  public AddVaultModule_ProvideNewPasswordControllerFactory(
      Provider<ResourceBundle> resourceBundleProvider,
      Provider<PasswordStrengthUtil> strengthRaterProvider) {
    this.resourceBundleProvider = resourceBundleProvider;
    this.strengthRaterProvider = strengthRaterProvider;
  }

  @Override
  public FxController get() {
    return provideNewPasswordController(resourceBundleProvider.get(), strengthRaterProvider.get());
  }

  public static AddVaultModule_ProvideNewPasswordControllerFactory create(
      Provider<ResourceBundle> resourceBundleProvider,
      Provider<PasswordStrengthUtil> strengthRaterProvider) {
    return new AddVaultModule_ProvideNewPasswordControllerFactory(
        resourceBundleProvider, strengthRaterProvider);
  }

  public static FxController provideNewPasswordController(
      ResourceBundle resourceBundle, PasswordStrengthUtil strengthRater) {
    return Preconditions.checkNotNullFromProvides(
        AddVaultModule.provideNewPasswordController(resourceBundle, strengthRater));
  }
}
