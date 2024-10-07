package org.cryptomator.ui.addvaultwizard;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.nio.file.Path;
import javafx.beans.property.ObjectProperty;
import javax.annotation.processing.Generated;

@ScopeMetadata("org.cryptomator.ui.addvaultwizard.AddVaultWizardScoped")
@QualifierMetadata
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class AddVaultModule_ProvideVaultPathFactory implements Factory<ObjectProperty<Path>> {
  @Override
  public ObjectProperty<Path> get() {
    return provideVaultPath();
  }

  public static AddVaultModule_ProvideVaultPathFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static ObjectProperty<Path> provideVaultPath() {
    return Preconditions.checkNotNullFromProvides(AddVaultModule.provideVaultPath());
  }

  private static final class InstanceHolder {
    private static final AddVaultModule_ProvideVaultPathFactory INSTANCE =
        new AddVaultModule_ProvideVaultPathFactory();
  }
}
