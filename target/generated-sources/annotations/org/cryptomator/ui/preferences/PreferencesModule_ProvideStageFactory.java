package org.cryptomator.ui.preferences;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.util.ResourceBundle;
import javafx.stage.Stage;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.cryptomator.ui.common.StageFactory;

@ScopeMetadata("org.cryptomator.ui.preferences.PreferencesScoped")
@QualifierMetadata("org.cryptomator.ui.preferences.PreferencesWindow")
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class PreferencesModule_ProvideStageFactory implements Factory<Stage> {
  private final Provider<StageFactory> factoryProvider;

  private final Provider<ResourceBundle> resourceBundleProvider;

  public PreferencesModule_ProvideStageFactory(
      Provider<StageFactory> factoryProvider, Provider<ResourceBundle> resourceBundleProvider) {
    this.factoryProvider = factoryProvider;
    this.resourceBundleProvider = resourceBundleProvider;
  }

  @Override
  public Stage get() {
    return provideStage(factoryProvider.get(), resourceBundleProvider.get());
  }

  public static PreferencesModule_ProvideStageFactory create(
      Provider<StageFactory> factoryProvider, Provider<ResourceBundle> resourceBundleProvider) {
    return new PreferencesModule_ProvideStageFactory(factoryProvider, resourceBundleProvider);
  }

  public static Stage provideStage(StageFactory factory, ResourceBundle resourceBundle) {
    return Preconditions.checkNotNullFromProvides(
        PreferencesModule.provideStage(factory, resourceBundle));
  }
}
