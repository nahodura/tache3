package org.cryptomator.ui.fxapp;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.util.Optional;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.cryptomator.common.LicenseHolder;
import org.cryptomator.common.settings.Settings;
import org.cryptomator.integrations.uiappearance.UiAppearanceProvider;

@ScopeMetadata("org.cryptomator.ui.fxapp.FxApplicationScoped")
@QualifierMetadata
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class FxApplicationStyle_Factory implements Factory<FxApplicationStyle> {
  private final Provider<Settings> settingsProvider;

  private final Provider<Optional<UiAppearanceProvider>> appearanceProvider;

  private final Provider<LicenseHolder> licenseHolderProvider;

  public FxApplicationStyle_Factory(
      Provider<Settings> settingsProvider,
      Provider<Optional<UiAppearanceProvider>> appearanceProvider,
      Provider<LicenseHolder> licenseHolderProvider) {
    this.settingsProvider = settingsProvider;
    this.appearanceProvider = appearanceProvider;
    this.licenseHolderProvider = licenseHolderProvider;
  }

  @Override
  public FxApplicationStyle get() {
    return newInstance(
        settingsProvider.get(), appearanceProvider.get(), licenseHolderProvider.get());
  }

  public static FxApplicationStyle_Factory create(
      Provider<Settings> settingsProvider,
      Provider<Optional<UiAppearanceProvider>> appearanceProvider,
      Provider<LicenseHolder> licenseHolderProvider) {
    return new FxApplicationStyle_Factory(
        settingsProvider, appearanceProvider, licenseHolderProvider);
  }

  public static FxApplicationStyle newInstance(
      Settings settings,
      Optional<UiAppearanceProvider> appearanceProvider,
      LicenseHolder licenseHolder) {
    return new FxApplicationStyle(settings, appearanceProvider, licenseHolder);
  }
}
