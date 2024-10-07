package org.cryptomator.ui.convertvault;

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

@ScopeMetadata("org.cryptomator.ui.convertvault.ConvertVaultScoped")
@QualifierMetadata({"org.cryptomator.ui.convertvault.ConvertVaultWindow", "javax.inject.Named"})
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class ConvertVaultModule_ProvideStageFactory implements Factory<Stage> {
  private final Provider<StageFactory> factoryProvider;

  private final Provider<Stage> ownerProvider;

  private final Provider<ResourceBundle> resourceBundleProvider;

  public ConvertVaultModule_ProvideStageFactory(
      Provider<StageFactory> factoryProvider,
      Provider<Stage> ownerProvider,
      Provider<ResourceBundle> resourceBundleProvider) {
    this.factoryProvider = factoryProvider;
    this.ownerProvider = ownerProvider;
    this.resourceBundleProvider = resourceBundleProvider;
  }

  @Override
  public Stage get() {
    return provideStage(factoryProvider.get(), ownerProvider.get(), resourceBundleProvider.get());
  }

  public static ConvertVaultModule_ProvideStageFactory create(
      Provider<StageFactory> factoryProvider,
      Provider<Stage> ownerProvider,
      Provider<ResourceBundle> resourceBundleProvider) {
    return new ConvertVaultModule_ProvideStageFactory(
        factoryProvider, ownerProvider, resourceBundleProvider);
  }

  public static Stage provideStage(
      StageFactory factory, Stage owner, ResourceBundle resourceBundle) {
    return Preconditions.checkNotNullFromProvides(
        ConvertVaultModule.provideStage(factory, owner, resourceBundle));
  }
}
