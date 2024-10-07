package org.cryptomator.ui.health;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.cryptomator.ui.common.FxmlLoaderFactory;

@ScopeMetadata
@QualifierMetadata("org.cryptomator.ui.health.HealthCheckWindow")
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class CheckListCellFactory_Factory implements Factory<CheckListCellFactory> {
  private final Provider<FxmlLoaderFactory> fxmlLoadersProvider;

  public CheckListCellFactory_Factory(Provider<FxmlLoaderFactory> fxmlLoadersProvider) {
    this.fxmlLoadersProvider = fxmlLoadersProvider;
  }

  @Override
  public CheckListCellFactory get() {
    return newInstance(fxmlLoadersProvider.get());
  }

  public static CheckListCellFactory_Factory create(
      Provider<FxmlLoaderFactory> fxmlLoadersProvider) {
    return new CheckListCellFactory_Factory(fxmlLoadersProvider);
  }

  public static CheckListCellFactory newInstance(FxmlLoaderFactory fxmlLoaders) {
    return new CheckListCellFactory(fxmlLoaders);
  }
}
