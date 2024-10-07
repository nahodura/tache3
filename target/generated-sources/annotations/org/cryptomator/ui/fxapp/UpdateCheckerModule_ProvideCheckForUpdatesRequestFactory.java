package org.cryptomator.ui.fxapp;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.net.http.HttpRequest;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.cryptomator.common.Environment;

@ScopeMetadata("org.cryptomator.ui.fxapp.FxApplicationScoped")
@QualifierMetadata
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class UpdateCheckerModule_ProvideCheckForUpdatesRequestFactory
    implements Factory<HttpRequest> {
  private final Provider<Environment> envProvider;

  public UpdateCheckerModule_ProvideCheckForUpdatesRequestFactory(
      Provider<Environment> envProvider) {
    this.envProvider = envProvider;
  }

  @Override
  public HttpRequest get() {
    return provideCheckForUpdatesRequest(envProvider.get());
  }

  public static UpdateCheckerModule_ProvideCheckForUpdatesRequestFactory create(
      Provider<Environment> envProvider) {
    return new UpdateCheckerModule_ProvideCheckForUpdatesRequestFactory(envProvider);
  }

  public static HttpRequest provideCheckForUpdatesRequest(Environment env) {
    return Preconditions.checkNotNullFromProvides(
        UpdateCheckerModule.provideCheckForUpdatesRequest(env));
  }
}
