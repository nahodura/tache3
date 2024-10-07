package org.cryptomator.ui.recoverykey;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javafx.beans.property.StringProperty;
import javax.annotation.processing.Generated;

@ScopeMetadata("org.cryptomator.ui.recoverykey.RecoveryKeyScoped")
@QualifierMetadata("org.cryptomator.ui.recoverykey.RecoveryKeyWindow")
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class RecoveryKeyModule_ProvideRecoveryKeyPropertyFactory
    implements Factory<StringProperty> {
  @Override
  public StringProperty get() {
    return provideRecoveryKeyProperty();
  }

  public static RecoveryKeyModule_ProvideRecoveryKeyPropertyFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static StringProperty provideRecoveryKeyProperty() {
    return Preconditions.checkNotNullFromProvides(RecoveryKeyModule.provideRecoveryKeyProperty());
  }

  private static final class InstanceHolder {
    private static final RecoveryKeyModule_ProvideRecoveryKeyPropertyFactory INSTANCE =
        new RecoveryKeyModule_ProvideRecoveryKeyPropertyFactory();
  }
}
