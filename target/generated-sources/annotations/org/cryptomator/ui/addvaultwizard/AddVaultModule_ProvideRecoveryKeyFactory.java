package org.cryptomator.ui.addvaultwizard;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javafx.beans.property.StringProperty;
import javax.annotation.processing.Generated;

@ScopeMetadata("org.cryptomator.ui.addvaultwizard.AddVaultWizardScoped")
@QualifierMetadata("javax.inject.Named")
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class AddVaultModule_ProvideRecoveryKeyFactory implements Factory<StringProperty> {
  @Override
  public StringProperty get() {
    return provideRecoveryKey();
  }

  public static AddVaultModule_ProvideRecoveryKeyFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static StringProperty provideRecoveryKey() {
    return Preconditions.checkNotNullFromProvides(AddVaultModule.provideRecoveryKey());
  }

  private static final class InstanceHolder {
    private static final AddVaultModule_ProvideRecoveryKeyFactory INSTANCE =
        new AddVaultModule_ProvideRecoveryKeyFactory();
  }
}
