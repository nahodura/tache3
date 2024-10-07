package org.cryptomator.ui.addvaultwizard;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javafx.beans.property.IntegerProperty;
import javax.annotation.processing.Generated;

@ScopeMetadata("org.cryptomator.ui.addvaultwizard.AddVaultWizardScoped")
@QualifierMetadata("javax.inject.Named")
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class AddVaultModule_ProvideShorteningThresholdFactory
    implements Factory<IntegerProperty> {
  @Override
  public IntegerProperty get() {
    return provideShorteningThreshold();
  }

  public static AddVaultModule_ProvideShorteningThresholdFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static IntegerProperty provideShorteningThreshold() {
    return Preconditions.checkNotNullFromProvides(AddVaultModule.provideShorteningThreshold());
  }

  private static final class InstanceHolder {
    private static final AddVaultModule_ProvideShorteningThresholdFactory INSTANCE =
        new AddVaultModule_ProvideShorteningThresholdFactory();
  }
}
