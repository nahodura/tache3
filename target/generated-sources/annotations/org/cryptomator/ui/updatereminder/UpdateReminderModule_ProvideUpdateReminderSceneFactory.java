package org.cryptomator.ui.updatereminder;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javafx.scene.Scene;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.cryptomator.ui.common.FxmlLoaderFactory;

@ScopeMetadata("org.cryptomator.ui.updatereminder.UpdateReminderScoped")
@QualifierMetadata({
  "org.cryptomator.ui.common.FxmlScene",
  "org.cryptomator.ui.updatereminder.UpdateReminderWindow"
})
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class UpdateReminderModule_ProvideUpdateReminderSceneFactory
    implements Factory<Scene> {
  private final Provider<FxmlLoaderFactory> fxmlLoadersProvider;

  public UpdateReminderModule_ProvideUpdateReminderSceneFactory(
      Provider<FxmlLoaderFactory> fxmlLoadersProvider) {
    this.fxmlLoadersProvider = fxmlLoadersProvider;
  }

  @Override
  public Scene get() {
    return provideUpdateReminderScene(fxmlLoadersProvider.get());
  }

  public static UpdateReminderModule_ProvideUpdateReminderSceneFactory create(
      Provider<FxmlLoaderFactory> fxmlLoadersProvider) {
    return new UpdateReminderModule_ProvideUpdateReminderSceneFactory(fxmlLoadersProvider);
  }

  public static Scene provideUpdateReminderScene(FxmlLoaderFactory fxmlLoaders) {
    return Preconditions.checkNotNullFromProvides(
        UpdateReminderModule.provideUpdateReminderScene(fxmlLoaders));
  }
}
