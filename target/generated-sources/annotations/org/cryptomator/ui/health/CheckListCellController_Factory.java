package org.cryptomator.ui.health;

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
public final class CheckListCellController_Factory implements Factory<CheckListCellController> {
  @Override
  public CheckListCellController get() {
    return newInstance();
  }

  public static CheckListCellController_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static CheckListCellController newInstance() {
    return new CheckListCellController();
  }

  private static final class InstanceHolder {
    private static final CheckListCellController_Factory INSTANCE =
        new CheckListCellController_Factory();
  }
}
