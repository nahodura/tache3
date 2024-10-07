package org.cryptomator.ui.mainwindow;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class VaultListCellController_Factory implements Factory<VaultListCellController> {
  @Override
  public VaultListCellController get() {
    return newInstance();
  }

  public static VaultListCellController_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static VaultListCellController newInstance() {
    return new VaultListCellController();
  }

  private static final class InstanceHolder {
    private static final VaultListCellController_Factory INSTANCE =
        new VaultListCellController_Factory();
  }
}
