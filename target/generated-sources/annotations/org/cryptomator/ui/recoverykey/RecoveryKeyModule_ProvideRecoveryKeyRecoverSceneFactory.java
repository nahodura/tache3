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
public final class RecoveryKeyModule_ProvideRecoveryKeyRecoverSceneFactory
    implements Factory<Scene> {
  private final Provider<FxmlLoaderFactory> fxmlLoadersProvider;

  public RecoveryKeyModule_ProvideRecoveryKeyRecoverSceneFactory(
      Provider<FxmlLoaderFactory> fxmlLoadersProvider) {
    this.fxmlLoadersProvider = fxmlLoadersProvider;
  }

  @Override
  public Scene get() {
    return provideRecoveryKeyRecoverScene(fxmlLoadersProvider.get());
  }

  public static RecoveryKeyModule_ProvideRecoveryKeyRecoverSceneFactory create(
      Provider<FxmlLoaderFactory> fxmlLoadersProvider) {
    return new RecoveryKeyModule_ProvideRecoveryKeyRecoverSceneFactory(fxmlLoadersProvider);
  }

  public static Scene provideRecoveryKeyRecoverScene(FxmlLoaderFactory fxmlLoaders) {
    return Preconditions.checkNotNullFromProvides(
        RecoveryKeyModule.provideRecoveryKeyRecoverScene(fxmlLoaders));
  }
}
