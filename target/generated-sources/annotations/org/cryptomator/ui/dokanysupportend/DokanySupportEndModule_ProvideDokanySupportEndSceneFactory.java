package org.cryptomator.ui.dokanysupportend;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javafx.scene.Scene;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.cryptomator.ui.common.FxmlLoaderFactory;

@ScopeMetadata("org.cryptomator.ui.dokanysupportend.DokanySupportEndScoped")
@QualifierMetadata({
  "org.cryptomator.ui.common.FxmlScene",
  "org.cryptomator.ui.dokanysupportend.DokanySupportEndWindow"
})
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class DokanySupportEndModule_ProvideDokanySupportEndSceneFactory
    implements Factory<Scene> {
  private final Provider<FxmlLoaderFactory> fxmlLoadersProvider;

  public DokanySupportEndModule_ProvideDokanySupportEndSceneFactory(
      Provider<FxmlLoaderFactory> fxmlLoadersProvider) {
    this.fxmlLoadersProvider = fxmlLoadersProvider;
  }

  @Override
  public Scene get() {
    return provideDokanySupportEndScene(fxmlLoadersProvider.get());
  }

  public static DokanySupportEndModule_ProvideDokanySupportEndSceneFactory create(
      Provider<FxmlLoaderFactory> fxmlLoadersProvider) {
    return new DokanySupportEndModule_ProvideDokanySupportEndSceneFactory(fxmlLoadersProvider);
  }

  public static Scene provideDokanySupportEndScene(FxmlLoaderFactory fxmlLoaders) {
    return Preconditions.checkNotNullFromProvides(
        DokanySupportEndModule.provideDokanySupportEndScene(fxmlLoaders));
  }
}
