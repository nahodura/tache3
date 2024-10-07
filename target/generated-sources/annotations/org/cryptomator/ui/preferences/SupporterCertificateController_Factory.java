package org.cryptomator.ui.preferences;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javafx.application.Application;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.cryptomator.common.LicenseHolder;
import org.cryptomator.common.settings.Settings;

@ScopeMetadata("org.cryptomator.ui.preferences.PreferencesScoped")
@QualifierMetadata
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class SupporterCertificateController_Factory
    implements Factory<SupporterCertificateController> {
  private final Provider<Application> applicationProvider;

  private final Provider<LicenseHolder> licenseHolderProvider;

  private final Provider<Settings> settingsProvider;

  public SupporterCertificateController_Factory(
      Provider<Application> applicationProvider,
      Provider<LicenseHolder> licenseHolderProvider,
      Provider<Settings> settingsProvider) {
    this.applicationProvider = applicationProvider;
    this.licenseHolderProvider = licenseHolderProvider;
    this.settingsProvider = settingsProvider;
  }

  @Override
  public SupporterCertificateController get() {
    return newInstance(
        applicationProvider.get(), licenseHolderProvider.get(), settingsProvider.get());
  }

  public static SupporterCertificateController_Factory create(
      Provider<Application> applicationProvider,
      Provider<LicenseHolder> licenseHolderProvider,
      Provider<Settings> settingsProvider) {
    return new SupporterCertificateController_Factory(
        applicationProvider, licenseHolderProvider, settingsProvider);
  }

  public static SupporterCertificateController newInstance(
      Application application, LicenseHolder licenseHolder, Settings settings) {
    return new SupporterCertificateController(application, licenseHolder, settings);
  }
}
