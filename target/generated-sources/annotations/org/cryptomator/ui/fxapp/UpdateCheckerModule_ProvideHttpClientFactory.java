package org.cryptomator.ui.fxapp;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.net.http.HttpClient;
import java.util.Optional;
import javax.annotation.processing.Generated;

@ScopeMetadata("org.cryptomator.ui.fxapp.FxApplicationScoped")
@QualifierMetadata
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class UpdateCheckerModule_ProvideHttpClientFactory
    implements Factory<Optional<HttpClient>> {
  @Override
  public Optional<HttpClient> get() {
    return provideHttpClient();
  }

  public static UpdateCheckerModule_ProvideHttpClientFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static Optional<HttpClient> provideHttpClient() {
    return Preconditions.checkNotNullFromProvides(UpdateCheckerModule.provideHttpClient());
  }

  private static final class InstanceHolder {
    private static final UpdateCheckerModule_ProvideHttpClientFactory INSTANCE =
        new UpdateCheckerModule_ProvideHttpClientFactory();
  }
}
