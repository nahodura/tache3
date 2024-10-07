package org.cryptomator.ui.forgetpassword;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javafx.beans.property.BooleanProperty;
import javax.annotation.processing.Generated;

@ScopeMetadata("org.cryptomator.ui.forgetpassword.ForgetPasswordScoped")
@QualifierMetadata("org.cryptomator.ui.forgetpassword.ForgetPasswordWindow")
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class ForgetPasswordModule_ProvideConfirmedPropertyFactory
    implements Factory<BooleanProperty> {
  @Override
  public BooleanProperty get() {
    return provideConfirmedProperty();
  }

  public static ForgetPasswordModule_ProvideConfirmedPropertyFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static BooleanProperty provideConfirmedProperty() {
    return Preconditions.checkNotNullFromProvides(ForgetPasswordModule.provideConfirmedProperty());
  }

  private static final class InstanceHolder {
    private static final ForgetPasswordModule_ProvideConfirmedPropertyFactory INSTANCE =
        new ForgetPasswordModule_ProvideConfirmedPropertyFactory();
  }
}
