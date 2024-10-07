package org.cryptomator.ui.preferences;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.util.ResourceBundle;
import javafx.beans.property.ObjectProperty;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.cryptomator.common.LicenseHolder;
import org.cryptomator.common.settings.Settings;
import org.cryptomator.launcher.SupportedLanguages;
import org.cryptomator.ui.traymenu.TrayMenuComponent;

@ScopeMetadata("org.cryptomator.ui.preferences.PreferencesScoped")
@QualifierMetadata
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class InterfacePreferencesController_Factory
    implements Factory<InterfacePreferencesController> {
  private final Provider<Settings> settingsProvider;

  private final Provider<SupportedLanguages> supportedLanguagesProvider;

  private final Provider<TrayMenuComponent> trayMenuProvider;

  private final Provider<ObjectProperty<SelectedPreferencesTab>> selectedTabPropertyProvider;

  private final Provider<LicenseHolder> licenseHolderProvider;

  private final Provider<ResourceBundle> resourceBundleProvider;

  public InterfacePreferencesController_Factory(
      Provider<Settings> settingsProvider,
      Provider<SupportedLanguages> supportedLanguagesProvider,
      Provider<TrayMenuComponent> trayMenuProvider,
      Provider<ObjectProperty<SelectedPreferencesTab>> selectedTabPropertyProvider,
      Provider<LicenseHolder> licenseHolderProvider,
      Provider<ResourceBundle> resourceBundleProvider) {
    this.settingsProvider = settingsProvider;
    this.supportedLanguagesProvider = supportedLanguagesProvider;
    this.trayMenuProvider = trayMenuProvider;
    this.selectedTabPropertyProvider = selectedTabPropertyProvider;
    this.licenseHolderProvider = licenseHolderProvider;
    this.resourceBundleProvider = resourceBundleProvider;
  }

  @Override
  public InterfacePreferencesController get() {
    return newInstance(
        settingsProvider.get(),
        supportedLanguagesProvider.get(),
        trayMenuProvider.get(),
        selectedTabPropertyProvider.get(),
        licenseHolderProvider.get(),
        resourceBundleProvider.get());
  }

  public static InterfacePreferencesController_Factory create(
      Provider<Settings> settingsProvider,
      Provider<SupportedLanguages> supportedLanguagesProvider,
      Provider<TrayMenuComponent> trayMenuProvider,
      Provider<ObjectProperty<SelectedPreferencesTab>> selectedTabPropertyProvider,
      Provider<LicenseHolder> licenseHolderProvider,
      Provider<ResourceBundle> resourceBundleProvider) {
    return new InterfacePreferencesController_Factory(
        settingsProvider,
        supportedLanguagesProvider,
        trayMenuProvider,
        selectedTabPropertyProvider,
        licenseHolderProvider,
        resourceBundleProvider);
  }

  public static InterfacePreferencesController newInstance(
      Settings settings,
      SupportedLanguages supportedLanguages,
      TrayMenuComponent trayMenu,
      ObjectProperty<SelectedPreferencesTab> selectedTabProperty,
      LicenseHolder licenseHolder,
      ResourceBundle resourceBundle) {
    return new InterfacePreferencesController(
        settings, supportedLanguages, trayMenu, selectedTabProperty, licenseHolder, resourceBundle);
  }
}
