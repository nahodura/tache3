package org.cryptomator.ui.fxapp;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.cryptomator.ui.mainwindow.MainWindowComponent;

@ScopeMetadata("org.cryptomator.ui.fxapp.FxApplicationScoped")
@QualifierMetadata
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class FxApplicationModule_ProvideMainWindowComponentFactory
    implements Factory<MainWindowComponent> {
  private final Provider<MainWindowComponent.Builder> builderProvider;

  public FxApplicationModule_ProvideMainWindowComponentFactory(
      Provider<MainWindowComponent.Builder> builderProvider) {
    this.builderProvider = builderProvider;
  }

  @Override
  public MainWindowComponent get() {
    return provideMainWindowComponent(builderProvider.get());
  }

  public static FxApplicationModule_ProvideMainWindowComponentFactory create(
      Provider<MainWindowComponent.Builder> builderProvider) {
    return new FxApplicationModule_ProvideMainWindowComponentFactory(builderProvider);
  }

  public static MainWindowComponent provideMainWindowComponent(
      MainWindowComponent.Builder builder) {
    return Preconditions.checkNotNullFromProvides(
        FxApplicationModule.provideMainWindowComponent(builder));
  }
}
