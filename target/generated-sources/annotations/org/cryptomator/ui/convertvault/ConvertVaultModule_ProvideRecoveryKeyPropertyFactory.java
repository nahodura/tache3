package org.cryptomator.ui.convertvault;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javafx.beans.property.StringProperty;
import javax.annotation.processing.Generated;

@ScopeMetadata("org.cryptomator.ui.convertvault.ConvertVaultScoped")
@QualifierMetadata("org.cryptomator.ui.convertvault.ConvertVaultWindow")
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class ConvertVaultModule_ProvideRecoveryKeyPropertyFactory
    implements Factory<StringProperty> {
  @Override
  public StringProperty get() {
    return provideRecoveryKeyProperty();
  }

  public static ConvertVaultModule_ProvideRecoveryKeyPropertyFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static StringProperty provideRecoveryKeyProperty() {
    return Preconditions.checkNotNullFromProvides(ConvertVaultModule.provideRecoveryKeyProperty());
  }

  private static final class InstanceHolder {
    private static final ConvertVaultModule_ProvideRecoveryKeyPropertyFactory INSTANCE =
        new ConvertVaultModule_ProvideRecoveryKeyPropertyFactory();
  }
}
