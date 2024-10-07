package org.cryptomator.ui.recoverykey;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javafx.scene.Scene;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.cryptomator.ui.common.FxmlLoaderFactory;

@ScopeMetadata("org.cryptomator.ui.recoverykey.RecoveryKeyScoped")
@QualifierMetadata({
  "org.cryptomator.ui.common.FxmlScene",
  "org.cryptomator.ui.recoverykey.RecoveryKeyWindow"
})
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class RecoveryKeyModule_ProvideRecoveryKeyCreationSceneFactory
    implements Factory<Scene> {
  private final Provider<FxmlLoaderFactory> fxmlLoadersProvider;

  public RecoveryKeyModule_ProvideRecoveryKeyCreationSceneFactory(
      Provider<FxmlLoaderFactory> fxmlLoadersProvider) {
    this.fxmlLoadersProvider = fxmlLoadersProvider;
  }

  @Override
  public Scene get() {
    return provideRecoveryKeyCreationScene(fxmlLoadersProvider.get());
  }

  public static RecoveryKeyModule_ProvideRecoveryKeyCreationSceneFactory create(
      Provider<FxmlLoaderFactory> fxmlLoadersProvider) {
    return new RecoveryKeyModule_ProvideRecoveryKeyCreationSceneFactory(fxmlLoadersProvider);
  }

  public static Scene provideRecoveryKeyCreationScene(FxmlLoaderFactory fxmlLoaders) {
    return Preconditions.checkNotNullFromProvides(
        RecoveryKeyModule.provideRecoveryKeyCreationScene(fxmlLoaders));
  }
}
