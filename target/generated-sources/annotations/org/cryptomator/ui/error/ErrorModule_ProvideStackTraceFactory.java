package org.cryptomator.ui.error;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata("javax.inject.Named")
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class ErrorModule_ProvideStackTraceFactory implements Factory<String> {
  private final Provider<Throwable> causeProvider;

  public ErrorModule_ProvideStackTraceFactory(Provider<Throwable> causeProvider) {
    this.causeProvider = causeProvider;
  }

  @Override
  public String get() {
    return provideStackTrace(causeProvider.get());
  }

  public static ErrorModule_ProvideStackTraceFactory create(Provider<Throwable> causeProvider) {
    return new ErrorModule_ProvideStackTraceFactory(causeProvider);
  }

  public static String provideStackTrace(Throwable cause) {
    return Preconditions.checkNotNullFromProvides(ErrorModule.provideStackTrace(cause));
  }
}
