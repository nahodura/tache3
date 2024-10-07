package org.cryptomator.ui.addvaultwizard;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javafx.beans.property.ObjectProperty;
import javax.annotation.processing.Generated;
import org.cryptomator.common.vaults.Vault;

@ScopeMetadata("org.cryptomator.ui.addvaultwizard.AddVaultWizardScoped")
@QualifierMetadata("org.cryptomator.ui.addvaultwizard.AddVaultWizardWindow")
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class AddVaultModule_ProvideVaultFactory implements Factory<ObjectProperty<Vault>> {
  @Override
  public ObjectProperty<Vault> get() {
    return provideVault();
  }

  public static AddVaultModule_ProvideVaultFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static ObjectProperty<Vault> provideVault() {
    return Preconditions.checkNotNullFromProvides(AddVaultModule.provideVault());
  }

  private static final class InstanceHolder {
    private static final AddVaultModule_ProvideVaultFactory INSTANCE =
        new AddVaultModule_ProvideVaultFactory();
  }
}
