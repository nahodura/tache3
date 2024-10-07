package org.cryptomator.ui.keyloading.hub;

import dagger.Lazy;
import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.util.concurrent.CompletableFuture;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata({
  "org.cryptomator.ui.keyloading.KeyLoading",
  "org.cryptomator.ui.common.FxmlScene"
})
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class RegisterSuccessController_Factory implements Factory<RegisterSuccessController> {
  private final Provider<Stage> windowProvider;

  private final Provider<CompletableFuture<ReceivedKey>> resultProvider;

  private final Provider<Scene> receiveKeySceneProvider;

  private final Provider<ReceiveKeyController> receiveKeyControllerProvider;

  public RegisterSuccessController_Factory(
      Provider<Stage> windowProvider,
      Provider<CompletableFuture<ReceivedKey>> resultProvider,
      Provider<Scene> receiveKeySceneProvider,
      Provider<ReceiveKeyController> receiveKeyControllerProvider) {
    this.windowProvider = windowProvider;
    this.resultProvider = resultProvider;
    this.receiveKeySceneProvider = receiveKeySceneProvider;
    this.receiveKeyControllerProvider = receiveKeyControllerProvider;
  }

  @Override
  public RegisterSuccessController get() {
    return newInstance(
        windowProvider.get(),
        resultProvider.get(),
        DoubleCheck.lazy(receiveKeySceneProvider),
        receiveKeyControllerProvider.get());
  }

  public static RegisterSuccessController_Factory create(
      Provider<Stage> windowProvider,
      Provider<CompletableFuture<ReceivedKey>> resultProvider,
      Provider<Scene> receiveKeySceneProvider,
      Provider<ReceiveKeyController> receiveKeyControllerProvider) {
    return new RegisterSuccessController_Factory(
        windowProvider, resultProvider, receiveKeySceneProvider, receiveKeyControllerProvider);
  }

  public static RegisterSuccessController newInstance(
      Stage window,
      CompletableFuture<ReceivedKey> result,
      Lazy<Scene> receiveKeyScene,
      ReceiveKeyController receiveKeyController) {
    return new RegisterSuccessController(window, result, receiveKeyScene, receiveKeyController);
  }
}
