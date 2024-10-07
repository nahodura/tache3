package org.cryptomator.ui.vaultoptions;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javafx.beans.property.ObjectProperty;
import javax.annotation.processing.Generated;

@ScopeMetadata("org.cryptomator.ui.vaultoptions.VaultOptionsScoped")
@QualifierMetadata
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class VaultOptionsModule_ProvideSelectedTabPropertyFactory
    implements Factory<ObjectProperty<SelectedVaultOptionsTab>> {
  @Override
  public ObjectProperty<SelectedVaultOptionsTab> get() {
    return provideSelectedTabProperty();
  }

  public static VaultOptionsModule_ProvideSelectedTabPropertyFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static ObjectProperty<SelectedVaultOptionsTab> provideSelectedTabProperty() {
    return Preconditions.checkNotNullFromProvides(VaultOptionsModule.provideSelectedTabProperty());
  }

  private static final class InstanceHolder {
    private static final VaultOptionsModule_ProvideSelectedTabPropertyFactory INSTANCE =
        new VaultOptionsModule_ProvideSelectedTabPropertyFactory();
  }
}
