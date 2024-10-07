package org.cryptomator.ui.keyloading.hub;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.processing.Generated;

@ScopeMetadata("org.cryptomator.ui.keyloading.KeyLoadingScoped")
@QualifierMetadata("javax.inject.Named")
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class HubKeyLoadingModule_ProvideBearerTokenRefFactory
    implements Factory<AtomicReference<String>> {
  @Override
  public AtomicReference<String> get() {
    return provideBearerTokenRef();
  }

  public static HubKeyLoadingModule_ProvideBearerTokenRefFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static AtomicReference<String> provideBearerTokenRef() {
    return Preconditions.checkNotNullFromProvides(HubKeyLoadingModule.provideBearerTokenRef());
  }

  private static final class InstanceHolder {
    private static final HubKeyLoadingModule_ProvideBearerTokenRefFactory INSTANCE =
        new HubKeyLoadingModule_ProvideBearerTokenRefFactory();
  }
}
