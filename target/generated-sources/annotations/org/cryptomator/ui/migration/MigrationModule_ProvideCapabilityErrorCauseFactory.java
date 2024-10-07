package org.cryptomator.ui.migration;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javafx.beans.property.ObjectProperty;
import javax.annotation.processing.Generated;
import org.cryptomator.cryptofs.common.FileSystemCapabilityChecker;

@ScopeMetadata("org.cryptomator.ui.migration.MigrationScoped")
@QualifierMetadata("javax.inject.Named")
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class MigrationModule_ProvideCapabilityErrorCauseFactory
    implements Factory<ObjectProperty<FileSystemCapabilityChecker.Capability>> {
  @Override
  public ObjectProperty<FileSystemCapabilityChecker.Capability> get() {
    return provideCapabilityErrorCause();
  }

  public static MigrationModule_ProvideCapabilityErrorCauseFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static ObjectProperty<FileSystemCapabilityChecker.Capability>
      provideCapabilityErrorCause() {
    return Preconditions.checkNotNullFromProvides(MigrationModule.provideCapabilityErrorCause());
  }

  private static final class InstanceHolder {
    private static final MigrationModule_ProvideCapabilityErrorCauseFactory INSTANCE =
        new MigrationModule_ProvideCapabilityErrorCauseFactory();
  }
}
