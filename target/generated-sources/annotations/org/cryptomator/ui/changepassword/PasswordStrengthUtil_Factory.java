package org.cryptomator.ui.changepassword;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.util.ResourceBundle;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.cryptomator.common.Environment;

@ScopeMetadata("org.cryptomator.ui.fxapp.FxApplicationScoped")
@QualifierMetadata
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class PasswordStrengthUtil_Factory implements Factory<PasswordStrengthUtil> {
  private final Provider<ResourceBundle> resourceBundleProvider;

  private final Provider<Environment> environmentProvider;

  public PasswordStrengthUtil_Factory(
      Provider<ResourceBundle> resourceBundleProvider, Provider<Environment> environmentProvider) {
    this.resourceBundleProvider = resourceBundleProvider;
    this.environmentProvider = environmentProvider;
  }

  @Override
  public PasswordStrengthUtil get() {
    return newInstance(resourceBundleProvider.get(), environmentProvider.get());
  }

  public static PasswordStrengthUtil_Factory create(
      Provider<ResourceBundle> resourceBundleProvider, Provider<Environment> environmentProvider) {
    return new PasswordStrengthUtil_Factory(resourceBundleProvider, environmentProvider);
  }

  public static PasswordStrengthUtil newInstance(
      ResourceBundle resourceBundle, Environment environment) {
    return new PasswordStrengthUtil(resourceBundle, environment);
  }
}
