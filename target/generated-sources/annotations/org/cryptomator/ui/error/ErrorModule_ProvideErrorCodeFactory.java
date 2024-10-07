package org.cryptomator.ui.error;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.cryptomator.common.ErrorCode;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class ErrorModule_ProvideErrorCodeFactory implements Factory<ErrorCode> {
  private final Provider<Throwable> causeProvider;

  public ErrorModule_ProvideErrorCodeFactory(Provider<Throwable> causeProvider) {
    this.causeProvider = causeProvider;
  }

  @Override
  public ErrorCode get() {
    return provideErrorCode(causeProvider.get());
  }

  public static ErrorModule_ProvideErrorCodeFactory create(Provider<Throwable> causeProvider) {
    return new ErrorModule_ProvideErrorCodeFactory(causeProvider);
  }

  public static ErrorCode provideErrorCode(Throwable cause) {
    return Preconditions.checkNotNullFromProvides(ErrorModule.provideErrorCode(cause));
  }
}
