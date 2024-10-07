package org.cryptomator.ui.preferences;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.cryptomator.common.Environment;
import org.cryptomator.ui.fxapp.UpdateChecker;

@ScopeMetadata("org.cryptomator.ui.preferences.PreferencesScoped")
@QualifierMetadata
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class AboutController_Factory implements Factory<AboutController> {
  private final Provider<UpdateChecker> updateCheckerProvider;

  private final Provider<Environment> environmentProvider;

  public AboutController_Factory(
      Provider<UpdateChecker> updateCheckerProvider, Provider<Environment> environmentProvider) {
    this.updateCheckerProvider = updateCheckerProvider;
    this.environmentProvider = environmentProvider;
  }

  @Override
  public AboutController get() {
    return newInstance(updateCheckerProvider.get(), environmentProvider.get());
  }

  public static AboutController_Factory create(
      Provider<UpdateChecker> updateCheckerProvider, Provider<Environment> environmentProvider) {
    return new AboutController_Factory(updateCheckerProvider, environmentProvider);
  }

  public static AboutController newInstance(UpdateChecker updateChecker, Environment environment) {
    return new AboutController(updateChecker, environment);
  }
}
