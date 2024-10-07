package org.cryptomator.ui.updatereminder;

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

@ScopeMetadata("org.cryptomator.ui.updatereminder.UpdateReminderScoped")
@QualifierMetadata("org.cryptomator.ui.updatereminder.UpdateReminderWindow")
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class UpdateReminderModule_ProvideStageFactory implements Factory<Stage> {
  private final Provider<StageFactory> factoryProvider;

  private final Provider<ResourceBundle> resourceBundleProvider;

  public UpdateReminderModule_ProvideStageFactory(
      Provider<StageFactory> factoryProvider, Provider<ResourceBundle> resourceBundleProvider) {
    this.factoryProvider = factoryProvider;
    this.resourceBundleProvider = resourceBundleProvider;
  }

  @Override
  public Stage get() {
    return provideStage(factoryProvider.get(), resourceBundleProvider.get());
  }

  public static UpdateReminderModule_ProvideStageFactory create(
      Provider<StageFactory> factoryProvider, Provider<ResourceBundle> resourceBundleProvider) {
    return new UpdateReminderModule_ProvideStageFactory(factoryProvider, resourceBundleProvider);
  }

  public static Stage provideStage(StageFactory factory, ResourceBundle resourceBundle) {
    return Preconditions.checkNotNullFromProvides(
        UpdateReminderModule.provideStage(factory, resourceBundle));
  }
}
