package org.cryptomator.ui.mainwindow;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.cryptomator.ui.common.FxmlLoaderFactory;

@ScopeMetadata("org.cryptomator.ui.mainwindow.MainWindowScoped")
@QualifierMetadata("org.cryptomator.ui.mainwindow.MainWindow")
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class VaultListCellFactory_Factory implements Factory<VaultListCellFactory> {
  private final Provider<FxmlLoaderFactory> fxmlLoadersProvider;

  public VaultListCellFactory_Factory(Provider<FxmlLoaderFactory> fxmlLoadersProvider) {
    this.fxmlLoadersProvider = fxmlLoadersProvider;
  }

  @Override
  public VaultListCellFactory get() {
    return newInstance(fxmlLoadersProvider.get());
  }

  public static VaultListCellFactory_Factory create(
      Provider<FxmlLoaderFactory> fxmlLoadersProvider) {
    return new VaultListCellFactory_Factory(fxmlLoadersProvider);
  }

  public static VaultListCellFactory newInstance(FxmlLoaderFactory fxmlLoaders) {
    return new VaultListCellFactory(fxmlLoaders);
  }
}
