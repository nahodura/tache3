package org.cryptomator.ui.mainwindow;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javafx.beans.property.ObjectProperty;
import javax.annotation.processing.Generated;
import org.cryptomator.common.vaults.Vault;

@ScopeMetadata("org.cryptomator.ui.mainwindow.MainWindowScoped")
@QualifierMetadata
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class MainWindowModule_ProvideSelectedVaultFactory
    implements Factory<ObjectProperty<Vault>> {
  @Override
  public ObjectProperty<Vault> get() {
    return provideSelectedVault();
  }

  public static MainWindowModule_ProvideSelectedVaultFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static ObjectProperty<Vault> provideSelectedVault() {
    return Preconditions.checkNotNullFromProvides(MainWindowModule.provideSelectedVault());
  }

  private static final class InstanceHolder {
    private static final MainWindowModule_ProvideSelectedVaultFactory INSTANCE =
        new MainWindowModule_ProvideSelectedVaultFactory();
  }
}
