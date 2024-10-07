package org.cryptomator.ui.keyloading.hub;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javafx.stage.Stage;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("org.cryptomator.ui.keyloading.KeyLoadingScoped")
@QualifierMetadata("org.cryptomator.ui.keyloading.KeyLoading")
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class LegacyRegisterSuccessController_Factory
    implements Factory<LegacyRegisterSuccessController> {
  private final Provider<Stage> windowProvider;

  public LegacyRegisterSuccessController_Factory(Provider<Stage> windowProvider) {
    this.windowProvider = windowProvider;
  }

  @Override
  public LegacyRegisterSuccessController get() {
    return newInstance(windowProvider.get());
  }

  public static LegacyRegisterSuccessController_Factory create(Provider<Stage> windowProvider) {
    return new LegacyRegisterSuccessController_Factory(windowProvider);
  }

  public static LegacyRegisterSuccessController newInstance(Stage window) {
    return new LegacyRegisterSuccessController(window);
  }
}
