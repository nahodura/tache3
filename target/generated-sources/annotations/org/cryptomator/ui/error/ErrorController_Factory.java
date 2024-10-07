package org.cryptomator.ui.error;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.util.concurrent.ExecutorService;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.cryptomator.common.Environment;
import org.cryptomator.common.ErrorCode;

@ScopeMetadata
@QualifierMetadata("javax.inject.Named")
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class ErrorController_Factory implements Factory<ErrorController> {
  private final Provider<Application> applicationProvider;

  private final Provider<String> stackTraceProvider;

  private final Provider<ErrorCode> errorCodeProvider;

  private final Provider<Scene> previousSceneProvider;

  private final Provider<Stage> windowProvider;

  private final Provider<Environment> environmentProvider;

  private final Provider<ExecutorService> executorServiceProvider;

  public ErrorController_Factory(
      Provider<Application> applicationProvider,
      Provider<String> stackTraceProvider,
      Provider<ErrorCode> errorCodeProvider,
      Provider<Scene> previousSceneProvider,
      Provider<Stage> windowProvider,
      Provider<Environment> environmentProvider,
      Provider<ExecutorService> executorServiceProvider) {
    this.applicationProvider = applicationProvider;
    this.stackTraceProvider = stackTraceProvider;
    this.errorCodeProvider = errorCodeProvider;
    this.previousSceneProvider = previousSceneProvider;
    this.windowProvider = windowProvider;
    this.environmentProvider = environmentProvider;
    this.executorServiceProvider = executorServiceProvider;
  }

  @Override
  public ErrorController get() {
    return newInstance(
        applicationProvider.get(),
        stackTraceProvider.get(),
        errorCodeProvider.get(),
        previousSceneProvider.get(),
        windowProvider.get(),
        environmentProvider.get(),
        executorServiceProvider.get());
  }

  public static ErrorController_Factory create(
      Provider<Application> applicationProvider,
      Provider<String> stackTraceProvider,
      Provider<ErrorCode> errorCodeProvider,
      Provider<Scene> previousSceneProvider,
      Provider<Stage> windowProvider,
      Provider<Environment> environmentProvider,
      Provider<ExecutorService> executorServiceProvider) {
    return new ErrorController_Factory(
        applicationProvider,
        stackTraceProvider,
        errorCodeProvider,
        previousSceneProvider,
        windowProvider,
        environmentProvider,
        executorServiceProvider);
  }

  public static ErrorController newInstance(
      Application application,
      String stackTrace,
      ErrorCode errorCode,
      Scene previousScene,
      Stage window,
      Environment environment,
      ExecutorService executorService) {
    return new ErrorController(
        application, stackTrace, errorCode, previousScene, window, environment, executorService);
  }
}
