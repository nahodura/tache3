package org.cryptomator.ui.addvaultwizard;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javafx.scene.Scene;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.cryptomator.ui.common.FxmlLoaderFactory;

@ScopeMetadata("org.cryptomator.ui.addvaultwizard.AddVaultWizardScoped")
@QualifierMetadata({
  "org.cryptomator.ui.common.FxmlScene",
  "org.cryptomator.ui.addvaultwizard.AddVaultWizardWindow"
})
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class AddVaultModule_ProvideCreateNewVaultExpertSettingsSceneFactory
    implements Factory<Scene> {
  private final Provider<FxmlLoaderFactory> fxmlLoadersProvider;

  public AddVaultModule_ProvideCreateNewVaultExpertSettingsSceneFactory(
      Provider<FxmlLoaderFactory> fxmlLoadersProvider) {
    this.fxmlLoadersProvider = fxmlLoadersProvider;
  }

  @Override
  public Scene get() {
    return provideCreateNewVaultExpertSettingsScene(fxmlLoadersProvider.get());
  }

  public static AddVaultModule_ProvideCreateNewVaultExpertSettingsSceneFactory create(
      Provider<FxmlLoaderFactory> fxmlLoadersProvider) {
    return new AddVaultModule_ProvideCreateNewVaultExpertSettingsSceneFactory(fxmlLoadersProvider);
  }

  public static Scene provideCreateNewVaultExpertSettingsScene(FxmlLoaderFactory fxmlLoaders) {
    return Preconditions.checkNotNullFromProvides(
        AddVaultModule.provideCreateNewVaultExpertSettingsScene(fxmlLoaders));
  }
}
