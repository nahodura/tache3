package org.cryptomator.ui.health;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.util.ResourceBundle;
import javafx.beans.property.ObjectProperty;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("org.cryptomator.ui.health.HealthCheckScoped")
@QualifierMetadata
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class CheckDetailController_Factory implements Factory<CheckDetailController> {
  private final Provider<ObjectProperty<Check>> selectedTaskProvider;

  private final Provider<ResultListCellFactory> resultListCellFactoryProvider;

  private final Provider<ResultFixApplier> resultFixApplierProvider;

  private final Provider<ResourceBundle> resourceBundleProvider;

  public CheckDetailController_Factory(
      Provider<ObjectProperty<Check>> selectedTaskProvider,
      Provider<ResultListCellFactory> resultListCellFactoryProvider,
      Provider<ResultFixApplier> resultFixApplierProvider,
      Provider<ResourceBundle> resourceBundleProvider) {
    this.selectedTaskProvider = selectedTaskProvider;
    this.resultListCellFactoryProvider = resultListCellFactoryProvider;
    this.resultFixApplierProvider = resultFixApplierProvider;
    this.resourceBundleProvider = resourceBundleProvider;
  }

  @Override
  public CheckDetailController get() {
    return newInstance(
        selectedTaskProvider.get(),
        resultListCellFactoryProvider.get(),
        resultFixApplierProvider.get(),
        resourceBundleProvider.get());
  }

  public static CheckDetailController_Factory create(
      Provider<ObjectProperty<Check>> selectedTaskProvider,
      Provider<ResultListCellFactory> resultListCellFactoryProvider,
      Provider<ResultFixApplier> resultFixApplierProvider,
      Provider<ResourceBundle> resourceBundleProvider) {
    return new CheckDetailController_Factory(
        selectedTaskProvider,
        resultListCellFactoryProvider,
        resultFixApplierProvider,
        resourceBundleProvider);
  }

  public static CheckDetailController newInstance(
      ObjectProperty<Check> selectedTask,
      ResultListCellFactory resultListCellFactory,
      Object resultFixApplier,
      ResourceBundle resourceBundle) {
    return new CheckDetailController(
        selectedTask, resultListCellFactory, (ResultFixApplier) resultFixApplier, resourceBundle);
  }
}
