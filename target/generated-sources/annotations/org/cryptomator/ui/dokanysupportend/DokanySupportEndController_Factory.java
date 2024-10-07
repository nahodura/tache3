package org.cryptomator.ui.dokanysupportend;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javafx.stage.Stage;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.cryptomator.ui.fxapp.FxApplicationWindows;

@ScopeMetadata("org.cryptomator.ui.dokanysupportend.DokanySupportEndScoped")
@QualifierMetadata("org.cryptomator.ui.dokanysupportend.DokanySupportEndWindow")
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class DokanySupportEndController_Factory
    implements Factory<DokanySupportEndController> {
  private final Provider<Stage> windowProvider;

  private final Provider<FxApplicationWindows> applicationWindowsProvider;

  public DokanySupportEndController_Factory(
      Provider<Stage> windowProvider, Provider<FxApplicationWindows> applicationWindowsProvider) {
    this.windowProvider = windowProvider;
    this.applicationWindowsProvider = applicationWindowsProvider;
  }

  @Override
  public DokanySupportEndController get() {
    return newInstance(windowProvider.get(), applicationWindowsProvider.get());
  }

  public static DokanySupportEndController_Factory create(
      Provider<Stage> windowProvider, Provider<FxApplicationWindows> applicationWindowsProvider) {
    return new DokanySupportEndController_Factory(windowProvider, applicationWindowsProvider);
  }

  public static DokanySupportEndController newInstance(
      Stage window, FxApplicationWindows applicationWindows) {
    return new DokanySupportEndController(window, applicationWindows);
  }
}
