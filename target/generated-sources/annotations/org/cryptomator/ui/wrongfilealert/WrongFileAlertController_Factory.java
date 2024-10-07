package org.cryptomator.ui.wrongfilealert;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javafx.application.Application;
import javafx.stage.Stage;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("org.cryptomator.ui.wrongfilealert.WrongFileAlertScoped")
@QualifierMetadata("org.cryptomator.ui.wrongfilealert.WrongFileAlertWindow")
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class WrongFileAlertController_Factory implements Factory<WrongFileAlertController> {
  private final Provider<Stage> windowProvider;

  private final Provider<Application> appProvider;

  public WrongFileAlertController_Factory(
      Provider<Stage> windowProvider, Provider<Application> appProvider) {
    this.windowProvider = windowProvider;
    this.appProvider = appProvider;
  }

  @Override
  public WrongFileAlertController get() {
    return newInstance(windowProvider.get(), appProvider.get());
  }

  public static WrongFileAlertController_Factory create(
      Provider<Stage> windowProvider, Provider<Application> appProvider) {
    return new WrongFileAlertController_Factory(windowProvider, appProvider);
  }

  public static WrongFileAlertController newInstance(Stage window, Application app) {
    return new WrongFileAlertController(window, app);
  }
}
