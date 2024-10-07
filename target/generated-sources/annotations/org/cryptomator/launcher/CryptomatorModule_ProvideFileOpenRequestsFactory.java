package org.cryptomator.launcher;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.util.concurrent.BlockingQueue;
import javax.annotation.processing.Generated;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata("javax.inject.Named")
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class CryptomatorModule_ProvideFileOpenRequestsFactory
    implements Factory<BlockingQueue<AppLaunchEvent>> {
  @Override
  public BlockingQueue<AppLaunchEvent> get() {
    return provideFileOpenRequests();
  }

  public static CryptomatorModule_ProvideFileOpenRequestsFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static BlockingQueue<AppLaunchEvent> provideFileOpenRequests() {
    return Preconditions.checkNotNullFromProvides(CryptomatorModule.provideFileOpenRequests());
  }

  private static final class InstanceHolder {
    private static final CryptomatorModule_ProvideFileOpenRequestsFactory INSTANCE =
        new CryptomatorModule_ProvideFileOpenRequestsFactory();
  }
}
