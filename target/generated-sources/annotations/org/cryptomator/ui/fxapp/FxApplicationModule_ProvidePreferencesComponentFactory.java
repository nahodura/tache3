package org.cryptomator.ui.fxapp;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.cryptomator.ui.preferences.PreferencesComponent;

@ScopeMetadata("org.cryptomator.ui.fxapp.FxApplicationScoped")
@QualifierMetadata
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class FxApplicationModule_ProvidePreferencesComponentFactory
    implements Factory<PreferencesComponent> {
  private final Provider<PreferencesComponent.Builder> builderProvider;

  public FxApplicationModule_ProvidePreferencesComponentFactory(
      Provider<PreferencesComponent.Builder> builderProvider) {
    this.builderProvider = builderProvider;
  }

  @Override
  public PreferencesComponent get() {
    return providePreferencesComponent(builderProvider.get());
  }

  public static FxApplicationModule_ProvidePreferencesComponentFactory create(
      Provider<PreferencesComponent.Builder> builderProvider) {
    return new FxApplicationModule_ProvidePreferencesComponentFactory(builderProvider);
  }

  public static PreferencesComponent providePreferencesComponent(
      PreferencesComponent.Builder builder) {
    return Preconditions.checkNotNullFromProvides(
        FxApplicationModule.providePreferencesComponent(builder));
  }
}
