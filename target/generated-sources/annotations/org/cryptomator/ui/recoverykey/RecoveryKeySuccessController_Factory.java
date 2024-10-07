package org.cryptomator.ui.recoverykey;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javafx.stage.Stage;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("org.cryptomator.ui.recoverykey.RecoveryKeyScoped")
@QualifierMetadata("org.cryptomator.ui.recoverykey.RecoveryKeyWindow")
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class RecoveryKeySuccessController_Factory
    implements Factory<RecoveryKeySuccessController> {
  private final Provider<Stage> windowProvider;

  public RecoveryKeySuccessController_Factory(Provider<Stage> windowProvider) {
    this.windowProvider = windowProvider;
  }

  @Override
  public RecoveryKeySuccessController get() {
    return newInstance(windowProvider.get());
  }

  public static RecoveryKeySuccessController_Factory create(Provider<Stage> windowProvider) {
    return new RecoveryKeySuccessController_Factory(windowProvider);
  }

  public static RecoveryKeySuccessController newInstance(Stage window) {
    return new RecoveryKeySuccessController(window);
  }
}
