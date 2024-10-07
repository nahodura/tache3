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
public final class AddVaultModule_ProvideVaultNameFactory implements Factory<StringProperty> {
  @Override
  public StringProperty get() {
    return provideVaultName();
  }

  public static AddVaultModule_ProvideVaultNameFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static StringProperty provideVaultName() {
    return Preconditions.checkNotNullFromProvides(AddVaultModule.provideVaultName());
  }

  private static final class InstanceHolder {
    private static final AddVaultModule_ProvideVaultNameFactory INSTANCE =
        new AddVaultModule_ProvideVaultNameFactory();
  }
}
