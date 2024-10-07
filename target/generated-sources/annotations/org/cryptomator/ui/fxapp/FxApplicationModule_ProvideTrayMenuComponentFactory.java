package org.cryptomator.ui.fxapp;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.cryptomator.ui.traymenu.TrayMenuComponent;

@ScopeMetadata("org.cryptomator.ui.fxapp.FxApplicationScoped")
@QualifierMetadata
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class FxApplicationModule_ProvideTrayMenuComponentFactory
    implements Factory<TrayMenuComponent> {
  private final Provider<TrayMenuComponent.Builder> builderProvider;

  public FxApplicationModule_ProvideTrayMenuComponentFactory(
      Provider<TrayMenuComponent.Builder> builderProvider) {
    this.builderProvider = builderProvider;
  }

  @Override
  public TrayMenuComponent get() {
    return provideTrayMenuComponent(builderProvider.get());
  }

  public static FxApplicationModule_ProvideTrayMenuComponentFactory create(
      Provider<TrayMenuComponent.Builder> builderProvider) {
    return new FxApplicationModule_ProvideTrayMenuComponentFactory(builderProvider);
  }

  public static TrayMenuComponent provideTrayMenuComponent(TrayMenuComponent.Builder builder) {
    return Preconditions.checkNotNullFromProvides(
        FxApplicationModule.provideTrayMenuComponent(builder));
  }
}
