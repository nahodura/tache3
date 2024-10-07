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
public final class FileOpenRequestHandler_Factory implements Factory<FileOpenRequestHandler> {
  private final Provider<BlockingQueue<AppLaunchEvent>> launchEventQueueProvider;

  public FileOpenRequestHandler_Factory(
      Provider<BlockingQueue<AppLaunchEvent>> launchEventQueueProvider) {
    this.launchEventQueueProvider = launchEventQueueProvider;
  }

  @Override
  public FileOpenRequestHandler get() {
    return newInstance(launchEventQueueProvider.get());
  }

  public static FileOpenRequestHandler_Factory create(
      Provider<BlockingQueue<AppLaunchEvent>> launchEventQueueProvider) {
    return new FileOpenRequestHandler_Factory(launchEventQueueProvider);
  }

  public static FileOpenRequestHandler newInstance(BlockingQueue<AppLaunchEvent> launchEventQueue) {
    return new FileOpenRequestHandler(launchEventQueue);
  }
}
