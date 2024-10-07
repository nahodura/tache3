package org.cryptomator.ui.health;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.util.ResourceBundle;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class ResultListCellController_Factory implements Factory<ResultListCellController> {
  private final Provider<ResultFixApplier> fixApplierProvider;

  private final Provider<ResourceBundle> resourceBundleProvider;

  public ResultListCellController_Factory(
      Provider<ResultFixApplier> fixApplierProvider,
      Provider<ResourceBundle> resourceBundleProvider) {
    this.fixApplierProvider = fixApplierProvider;
    this.resourceBundleProvider = resourceBundleProvider;
  }

  @Override
  public ResultListCellController get() {
    return newInstance(fixApplierProvider.get(), resourceBundleProvider.get());
  }

  public static ResultListCellController_Factory create(
      Provider<ResultFixApplier> fixApplierProvider,
      Provider<ResourceBundle> resourceBundleProvider) {
    return new ResultListCellController_Factory(fixApplierProvider, resourceBundleProvider);
  }

  public static ResultListCellController newInstance(
      Object fixApplier, ResourceBundle resourceBundle) {
    return new ResultListCellController((ResultFixApplier) fixApplier, resourceBundle);
  }
}
