package org.cryptomator.ui.dokanysupportend;

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

@ScopeMetadata("org.cryptomator.ui.dokanysupportend.DokanySupportEndScoped")
@QualifierMetadata("org.cryptomator.ui.dokanysupportend.DokanySupportEndWindow")
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class DokanySupportEndModule_ProvideStageFactory implements Factory<Stage> {
  private final Provider<StageFactory> factoryProvider;

  private final Provider<ResourceBundle> resourceBundleProvider;

  public DokanySupportEndModule_ProvideStageFactory(
      Provider<StageFactory> factoryProvider, Provider<ResourceBundle> resourceBundleProvider) {
    this.factoryProvider = factoryProvider;
    this.resourceBundleProvider = resourceBundleProvider;
  }

  @Override
  public Stage get() {
    return provideStage(factoryProvider.get(), resourceBundleProvider.get());
  }

  public static DokanySupportEndModule_ProvideStageFactory create(
      Provider<StageFactory> factoryProvider, Provider<ResourceBundle> resourceBundleProvider) {
    return new DokanySupportEndModule_ProvideStageFactory(factoryProvider, resourceBundleProvider);
  }

  public static Stage provideStage(StageFactory factory, ResourceBundle resourceBundle) {
    return Preconditions.checkNotNullFromProvides(
        DokanySupportEndModule.provideStage(factory, resourceBundle));
  }
}
