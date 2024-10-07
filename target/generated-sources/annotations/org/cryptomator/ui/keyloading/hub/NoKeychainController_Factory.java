package org.cryptomator.ui.keyloading.hub;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javafx.stage.Stage;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.cryptomator.ui.fxapp.FxApplicationWindows;

@ScopeMetadata
@QualifierMetadata("org.cryptomator.ui.keyloading.KeyLoading")
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class NoKeychainController_Factory implements Factory<NoKeychainController> {
  private final Provider<Stage> windowProvider;

  private final Provider<FxApplicationWindows> appWindowsProvider;

  public NoKeychainController_Factory(
      Provider<Stage> windowProvider, Provider<FxApplicationWindows> appWindowsProvider) {
    this.windowProvider = windowProvider;
    this.appWindowsProvider = appWindowsProvider;
  }

  @Override
  public NoKeychainController get() {
    return newInstance(windowProvider.get(), appWindowsProvider.get());
  }

  public static NoKeychainController_Factory create(
      Provider<Stage> windowProvider, Provider<FxApplicationWindows> appWindowsProvider) {
    return new NoKeychainController_Factory(windowProvider, appWindowsProvider);
  }

  public static NoKeychainController newInstance(Stage window, FxApplicationWindows appWindows) {
    return new NoKeychainController(window, appWindows);
  }
}
