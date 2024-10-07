package org.cryptomator.ui.health;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.util.concurrent.atomic.AtomicReference;
import javafx.beans.value.ChangeListener;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.cryptomator.cryptolib.api.Masterkey;

@ScopeMetadata("org.cryptomator.ui.health.HealthCheckScoped")
@QualifierMetadata
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class HealthCheckModule_ProvideWindowShowingChangeListenerFactory
    implements Factory<ChangeListener<Boolean>> {
  private final Provider<AtomicReference<Masterkey>> masterkeyProvider;

  public HealthCheckModule_ProvideWindowShowingChangeListenerFactory(
      Provider<AtomicReference<Masterkey>> masterkeyProvider) {
    this.masterkeyProvider = masterkeyProvider;
  }

  @Override
  public ChangeListener<Boolean> get() {
    return provideWindowShowingChangeListener(masterkeyProvider.get());
  }

  public static HealthCheckModule_ProvideWindowShowingChangeListenerFactory create(
      Provider<AtomicReference<Masterkey>> masterkeyProvider) {
    return new HealthCheckModule_ProvideWindowShowingChangeListenerFactory(masterkeyProvider);
  }

  public static ChangeListener<Boolean> provideWindowShowingChangeListener(
      AtomicReference<Masterkey> masterkey) {
    return Preconditions.checkNotNullFromProvides(
        HealthCheckModule.provideWindowShowingChangeListener(masterkey));
  }
}
