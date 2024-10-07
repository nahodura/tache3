package org.cryptomator.ui.forgetpassword;

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

@ScopeMetadata("org.cryptomator.ui.forgetpassword.ForgetPasswordScoped")
@QualifierMetadata({"org.cryptomator.ui.forgetpassword.ForgetPasswordWindow", "javax.inject.Named"})
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class ForgetPasswordModule_ProvideStageFactory implements Factory<Stage> {
  private final Provider<StageFactory> factoryProvider;

  private final Provider<ResourceBundle> resourceBundleProvider;

  private final Provider<Stage> ownerProvider;

  public ForgetPasswordModule_ProvideStageFactory(
      Provider<StageFactory> factoryProvider,
      Provider<ResourceBundle> resourceBundleProvider,
      Provider<Stage> ownerProvider) {
    this.factoryProvider = factoryProvider;
    this.resourceBundleProvider = resourceBundleProvider;
    this.ownerProvider = ownerProvider;
  }

  @Override
  public Stage get() {
    return provideStage(factoryProvider.get(), resourceBundleProvider.get(), ownerProvider.get());
  }

  public static ForgetPasswordModule_ProvideStageFactory create(
      Provider<StageFactory> factoryProvider,
      Provider<ResourceBundle> resourceBundleProvider,
      Provider<Stage> ownerProvider) {
    return new ForgetPasswordModule_ProvideStageFactory(
        factoryProvider, resourceBundleProvider, ownerProvider);
  }

  public static Stage provideStage(
      StageFactory factory, ResourceBundle resourceBundle, Stage owner) {
    return Preconditions.checkNotNullFromProvides(
        ForgetPasswordModule.provideStage(factory, resourceBundle, owner));
  }
}
