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
public final class MigrationModule_ProvideMigrationStartSceneFactory implements Factory<Scene> {
  private final Provider<FxmlLoaderFactory> fxmlLoadersProvider;

  public MigrationModule_ProvideMigrationStartSceneFactory(
      Provider<FxmlLoaderFactory> fxmlLoadersProvider) {
    this.fxmlLoadersProvider = fxmlLoadersProvider;
  }

  @Override
  public Scene get() {
    return provideMigrationStartScene(fxmlLoadersProvider.get());
  }

  public static MigrationModule_ProvideMigrationStartSceneFactory create(
      Provider<FxmlLoaderFactory> fxmlLoadersProvider) {
    return new MigrationModule_ProvideMigrationStartSceneFactory(fxmlLoadersProvider);
  }

  public static Scene provideMigrationStartScene(FxmlLoaderFactory fxmlLoaders) {
    return Preconditions.checkNotNullFromProvides(
        MigrationModule.provideMigrationStartScene(fxmlLoaders));
  }
}
