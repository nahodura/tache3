package org.cryptomator.ui.mainwindow;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javafx.stage.Stage;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.cryptomator.common.settings.Settings;

@ScopeMetadata
@QualifierMetadata("org.cryptomator.ui.mainwindow.MainWindow")
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class ResizeController_Factory implements Factory<ResizeController> {
  private final Provider<Stage> windowProvider;

  private final Provider<Settings> settingsProvider;

  public ResizeController_Factory(
      Provider<Stage> windowProvider, Provider<Settings> settingsProvider) {
    this.windowProvider = windowProvider;
    this.settingsProvider = settingsProvider;
  }

  @Override
  public ResizeController get() {
    return newInstance(windowProvider.get(), settingsProvider.get());
  }

  public static ResizeController_Factory create(
      Provider<Stage> windowProvider, Provider<Settings> settingsProvider) {
    return new ResizeController_Factory(windowProvider, settingsProvider);
  }

  public static ResizeController newInstance(Stage window, Settings settings) {
    return new ResizeController(window, settings);
  }
}
