package org.cryptomator.ui.quit;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.awt.desktop.QuitResponse;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.processing.Generated;

@ScopeMetadata("org.cryptomator.ui.quit.QuitScoped")
@QualifierMetadata("org.cryptomator.ui.quit.QuitWindow")
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class QuitModule_ProvideQuitResponseFactory
    implements Factory<AtomicReference<QuitResponse>> {
  @Override
  public AtomicReference<QuitResponse> get() {
    return provideQuitResponse();
  }

  public static QuitModule_ProvideQuitResponseFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static AtomicReference<QuitResponse> provideQuitResponse() {
    return Preconditions.checkNotNullFromProvides(QuitModule.provideQuitResponse());
  }

  private static final class InstanceHolder {
    private static final QuitModule_ProvideQuitResponseFactory INSTANCE =
        new QuitModule_ProvideQuitResponseFactory();
  }
}
