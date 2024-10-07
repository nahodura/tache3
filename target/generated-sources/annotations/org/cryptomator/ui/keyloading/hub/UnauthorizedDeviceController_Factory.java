package org.cryptomator.ui.keyloading.hub;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.util.concurrent.CompletableFuture;
import javafx.stage.Stage;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("org.cryptomator.ui.keyloading.KeyLoadingScoped")
@QualifierMetadata("org.cryptomator.ui.keyloading.KeyLoading")
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class UnauthorizedDeviceController_Factory
    implements Factory<UnauthorizedDeviceController> {
  private final Provider<Stage> windowProvider;

  private final Provider<CompletableFuture<ReceivedKey>> resultProvider;

  public UnauthorizedDeviceController_Factory(
      Provider<Stage> windowProvider, Provider<CompletableFuture<ReceivedKey>> resultProvider) {
    this.windowProvider = windowProvider;
    this.resultProvider = resultProvider;
  }

  @Override
  public UnauthorizedDeviceController get() {
    return newInstance(windowProvider.get(), resultProvider.get());
  }

  public static UnauthorizedDeviceController_Factory create(
      Provider<Stage> windowProvider, Provider<CompletableFuture<ReceivedKey>> resultProvider) {
    return new UnauthorizedDeviceController_Factory(windowProvider, resultProvider);
  }

  public static UnauthorizedDeviceController newInstance(
      Stage window, CompletableFuture<ReceivedKey> result) {
    return new UnauthorizedDeviceController(window, result);
  }
}
