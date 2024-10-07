package org.cryptomator.ui.migration;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javafx.scene.Scene;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.cryptomator.ui.common.FxmlLoaderFactory;

@ScopeMetadata("org.cryptomator.ui.migration.MigrationScoped")
@QualifierMetadata({
  "org.cryptomator.ui.common.FxmlScene",
  "org.cryptomator.ui.migration.MigrationWindow"
})
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class MigrationModule_ProvideMigrationImpossibleSceneFactory
    implements Factory<Scene> {
  private final Provider<FxmlLoaderFactory> fxmlLoadersProvider;

  public MigrationModule_ProvideMigrationImpossibleSceneFactory(
      Provider<FxmlLoaderFactory> fxmlLoadersProvider) {
    this.fxmlLoadersProvider = fxmlLoadersProvider;
  }

  @Override
  public Scene get() {
    return provideMigrationImpossibleScene(fxmlLoadersProvider.get());
  }

  public static MigrationModule_ProvideMigrationImpossibleSceneFactory create(
      Provider<FxmlLoaderFactory> fxmlLoadersProvider) {
    return new MigrationModule_ProvideMigrationImpossibleSceneFactory(fxmlLoadersProvider);
  }

  public static Scene provideMigrationImpossibleScene(FxmlLoaderFactory fxmlLoaders) {
    return Preconditions.checkNotNullFromProvides(
        MigrationModule.provideMigrationImpossibleScene(fxmlLoaders));
  }
}
