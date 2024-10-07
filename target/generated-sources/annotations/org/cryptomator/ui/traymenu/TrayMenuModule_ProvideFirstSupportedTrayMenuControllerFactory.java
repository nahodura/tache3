package org.cryptomator.ui.traymenu;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.util.Optional;
import javax.annotation.processing.Generated;
import org.cryptomator.integrations.tray.TrayMenuController;

@ScopeMetadata("org.cryptomator.ui.traymenu.TrayMenuScoped")
@QualifierMetadata
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class TrayMenuModule_ProvideFirstSupportedTrayMenuControllerFactory
    implements Factory<Optional<TrayMenuController>> {
  @Override
  public Optional<TrayMenuController> get() {
    return provideFirstSupportedTrayMenuController();
  }

  public static TrayMenuModule_ProvideFirstSupportedTrayMenuControllerFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static Optional<TrayMenuController> provideFirstSupportedTrayMenuController() {
    return Preconditions.checkNotNullFromProvides(
        TrayMenuModule.provideFirstSupportedTrayMenuController());
  }

  private static final class InstanceHolder {
    private static final TrayMenuModule_ProvideFirstSupportedTrayMenuControllerFactory INSTANCE =
        new TrayMenuModule_ProvideFirstSupportedTrayMenuControllerFactory();
  }
}
