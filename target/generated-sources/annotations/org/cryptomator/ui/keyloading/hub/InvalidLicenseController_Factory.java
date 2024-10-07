package org.cryptomator.ui.keyloading.hub;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javafx.stage.Stage;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata("org.cryptomator.ui.keyloading.KeyLoading")
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class InvalidLicenseController_Factory implements Factory<InvalidLicenseController> {
  private final Provider<Stage> windowProvider;

  public InvalidLicenseController_Factory(Provider<Stage> windowProvider) {
    this.windowProvider = windowProvider;
  }

  @Override
  public InvalidLicenseController get() {
    return newInstance(windowProvider.get());
  }

  public static InvalidLicenseController_Factory create(Provider<Stage> windowProvider) {
    return new InvalidLicenseController_Factory(windowProvider);
  }

  public static InvalidLicenseController newInstance(Stage window) {
    return new InvalidLicenseController(window);
  }
}
