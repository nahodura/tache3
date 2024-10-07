package org.cryptomator.ui.stats;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javafx.scene.Scene;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.cryptomator.ui.common.FxmlLoaderFactory;

@ScopeMetadata("org.cryptomator.ui.stats.VaultStatisticsScoped")
@QualifierMetadata({
  "org.cryptomator.ui.common.FxmlScene",
  "org.cryptomator.ui.stats.VaultStatisticsWindow"
})
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class VaultStatisticsModule_ProvideVaultStatisticsSceneFactory
    implements Factory<Scene> {
  private final Provider<FxmlLoaderFactory> fxmlLoadersProvider;

  public VaultStatisticsModule_ProvideVaultStatisticsSceneFactory(
      Provider<FxmlLoaderFactory> fxmlLoadersProvider) {
    this.fxmlLoadersProvider = fxmlLoadersProvider;
  }

  @Override
  public Scene get() {
    return provideVaultStatisticsScene(fxmlLoadersProvider.get());
  }

  public static VaultStatisticsModule_ProvideVaultStatisticsSceneFactory create(
      Provider<FxmlLoaderFactory> fxmlLoadersProvider) {
    return new VaultStatisticsModule_ProvideVaultStatisticsSceneFactory(fxmlLoadersProvider);
  }

  public static Scene provideVaultStatisticsScene(FxmlLoaderFactory fxmlLoaders) {
    return Preconditions.checkNotNullFromProvides(
        VaultStatisticsModule.provideVaultStatisticsScene(fxmlLoaders));
  }
}
