package org.cryptomator.launcher;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.util.concurrent.BlockingQueue;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata("javax.inject.Named")
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class IpcMessageHandler_Factory implements Factory<IpcMessageHandler> {
  private final Provider<FileOpenRequestHandler> fileOpenRequestHandlerProvider;

  private final Provider<BlockingQueue<AppLaunchEvent>> launchEventQueueProvider;

  public IpcMessageHandler_Factory(
      Provider<FileOpenRequestHandler> fileOpenRequestHandlerProvider,
      Provider<BlockingQueue<AppLaunchEvent>> launchEventQueueProvider) {
    this.fileOpenRequestHandlerProvider = fileOpenRequestHandlerProvider;
    this.launchEventQueueProvider = launchEventQueueProvider;
  }

  @Override
  public IpcMessageHandler get() {
    return newInstance(fileOpenRequestHandlerProvider.get(), launchEventQueueProvider.get());
  }

  public static IpcMessageHandler_Factory create(
      Provider<FileOpenRequestHandler> fileOpenRequestHandlerProvider,
      Provider<BlockingQueue<AppLaunchEvent>> launchEventQueueProvider) {
    return new IpcMessageHandler_Factory(fileOpenRequestHandlerProvider, launchEventQueueProvider);
  }

  public static IpcMessageHandler newInstance(
      Object fileOpenRequestHandler, BlockingQueue<AppLaunchEvent> launchEventQueue) {
    return new IpcMessageHandler((FileOpenRequestHandler) fileOpenRequestHandler, launchEventQueue);
  }
}
