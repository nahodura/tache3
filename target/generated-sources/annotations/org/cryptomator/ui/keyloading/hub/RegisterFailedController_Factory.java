package org.cryptomator.ui.keyloading.hub;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.util.concurrent.CompletableFuture;
import javafx.stage.Stage;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata("org.cryptomator.ui.keyloading.KeyLoading")
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class RegisterFailedController_Factory implements Factory<RegisterFailedController> {
  private final Provider<Stage> windowProvider;

  private final Provider<CompletableFuture<ReceivedKey>> resultProvider;

  public RegisterFailedController_Factory(
      Provider<Stage> windowProvider, Provider<CompletableFuture<ReceivedKey>> resultProvider) {
    this.windowProvider = windowProvider;
    this.resultProvider = resultProvider;
  }

  @Override
  public RegisterFailedController get() {
    return newInstance(windowProvider.get(), resultProvider.get());
  }

  public static RegisterFailedController_Factory create(
      Provider<Stage> windowProvider, Provider<CompletableFuture<ReceivedKey>> resultProvider) {
    return new RegisterFailedController_Factory(windowProvider, resultProvider);
  }

  public static RegisterFailedController newInstance(
      Stage window, CompletableFuture<ReceivedKey> result) {
    return new RegisterFailedController(window, result);
  }
}
