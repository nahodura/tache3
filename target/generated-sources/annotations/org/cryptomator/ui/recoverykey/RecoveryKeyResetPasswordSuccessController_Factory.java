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
public final class RecoveryKeyResetPasswordSuccessController_Factory
    implements Factory<RecoveryKeyResetPasswordSuccessController> {
  private final Provider<Stage> windowProvider;

  public RecoveryKeyResetPasswordSuccessController_Factory(Provider<Stage> windowProvider) {
    this.windowProvider = windowProvider;
  }

  @Override
  public RecoveryKeyResetPasswordSuccessController get() {
    return newInstance(windowProvider.get());
  }

  public static RecoveryKeyResetPasswordSuccessController_Factory create(
      Provider<Stage> windowProvider) {
    return new RecoveryKeyResetPasswordSuccessController_Factory(windowProvider);
  }

  public static RecoveryKeyResetPasswordSuccessController newInstance(Stage window) {
    return new RecoveryKeyResetPasswordSuccessController(window);
  }
}
