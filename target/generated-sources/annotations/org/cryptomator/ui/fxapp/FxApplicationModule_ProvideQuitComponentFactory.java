package org.cryptomator.ui.fxapp;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.cryptomator.ui.quit.QuitComponent;

@ScopeMetadata("org.cryptomator.ui.fxapp.FxApplicationScoped")
@QualifierMetadata
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class FxApplicationModule_ProvideQuitComponentFactory
    implements Factory<QuitComponent> {
  private final Provider<QuitComponent.Builder> builderProvider;

  public FxApplicationModule_ProvideQuitComponentFactory(
      Provider<QuitComponent.Builder> builderProvider) {
    this.builderProvider = builderProvider;
  }

  @Override
  public QuitComponent get() {
    return provideQuitComponent(builderProvider.get());
  }

  public static FxApplicationModule_ProvideQuitComponentFactory create(
      Provider<QuitComponent.Builder> builderProvider) {
    return new FxApplicationModule_ProvideQuitComponentFactory(builderProvider);
  }

  public static QuitComponent provideQuitComponent(QuitComponent.Builder builder) {
    return Preconditions.checkNotNullFromProvides(
        FxApplicationModule.provideQuitComponent(builder));
  }
}
