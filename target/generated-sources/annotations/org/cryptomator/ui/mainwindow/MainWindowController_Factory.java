package org.cryptomator.ui.mainwindow;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javafx.beans.property.ObjectProperty;
import javafx.stage.Stage;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.cryptomator.common.vaults.Vault;

@ScopeMetadata("org.cryptomator.ui.mainwindow.MainWindowScoped")
@QualifierMetadata("org.cryptomator.ui.mainwindow.MainWindow")
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class MainWindowController_Factory implements Factory<MainWindowController> {
  private final Provider<Stage> windowProvider;

  private final Provider<ObjectProperty<Vault>> selectedVaultProvider;

  public MainWindowController_Factory(
      Provider<Stage> windowProvider, Provider<ObjectProperty<Vault>> selectedVaultProvider) {
    this.windowProvider = windowProvider;
    this.selectedVaultProvider = selectedVaultProvider;
  }

  @Override
  public MainWindowController get() {
    return newInstance(windowProvider.get(), selectedVaultProvider.get());
  }

  public static MainWindowController_Factory create(
      Provider<Stage> windowProvider, Provider<ObjectProperty<Vault>> selectedVaultProvider) {
    return new MainWindowController_Factory(windowProvider, selectedVaultProvider);
  }

  public static MainWindowController newInstance(
      Stage window, ObjectProperty<Vault> selectedVault) {
    return new MainWindowController(window, selectedVault);
  }
}
