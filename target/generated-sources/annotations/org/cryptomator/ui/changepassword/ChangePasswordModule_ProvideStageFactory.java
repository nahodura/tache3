package org.cryptomator.ui.changepassword;

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

@ScopeMetadata("org.cryptomator.ui.changepassword.ChangePasswordScoped")
@QualifierMetadata({"org.cryptomator.ui.changepassword.ChangePasswordWindow", "javax.inject.Named"})
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class ChangePasswordModule_ProvideStageFactory implements Factory<Stage> {
  private final Provider<StageFactory> factoryProvider;

  private final Provider<Stage> ownerProvider;

  private final Provider<ResourceBundle> resourceBundleProvider;

  public ChangePasswordModule_ProvideStageFactory(
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

  public static ChangePasswordModule_ProvideStageFactory create(
      Provider<StageFactory> factoryProvider,
      Provider<Stage> ownerProvider,
      Provider<ResourceBundle> resourceBundleProvider) {
    return new ChangePasswordModule_ProvideStageFactory(
        factoryProvider, ownerProvider, resourceBundleProvider);
  }

  public static Stage provideStage(
      StageFactory factory, Stage owner, ResourceBundle resourceBundle) {
    return Preconditions.checkNotNullFromProvides(
        ChangePasswordModule.provideStage(factory, owner, resourceBundle));
  }
}
