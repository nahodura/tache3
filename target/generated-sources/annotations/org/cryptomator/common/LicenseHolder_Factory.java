package org.cryptomator.common;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.cryptomator.common.settings.Settings;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class LicenseHolder_Factory implements Factory<LicenseHolder> {
  private final Provider<LicenseChecker> licenseCheckerProvider;

  private final Provider<Settings> settingsProvider;

  public LicenseHolder_Factory(
      Provider<LicenseChecker> licenseCheckerProvider, Provider<Settings> settingsProvider) {
    this.licenseCheckerProvider = licenseCheckerProvider;
    this.settingsProvider = settingsProvider;
  }

  @Override
  public LicenseHolder get() {
    return newInstance(licenseCheckerProvider.get(), settingsProvider.get());
  }

  public static LicenseHolder_Factory create(
      Provider<LicenseChecker> licenseCheckerProvider, Provider<Settings> settingsProvider) {
    return new LicenseHolder_Factory(licenseCheckerProvider, settingsProvider);
  }

  public static LicenseHolder newInstance(Object licenseChecker, Settings settings) {
    return new LicenseHolder((LicenseChecker) licenseChecker, settings);
  }
}
