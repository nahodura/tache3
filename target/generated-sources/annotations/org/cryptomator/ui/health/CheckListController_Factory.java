package org.cryptomator.ui.health;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.util.List;
import javafx.beans.property.ObjectProperty;
import javafx.stage.Stage;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.cryptomator.ui.fxapp.FxApplicationWindows;

@ScopeMetadata("org.cryptomator.ui.health.HealthCheckScoped")
@QualifierMetadata("org.cryptomator.ui.health.HealthCheckWindow")
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class CheckListController_Factory implements Factory<CheckListController> {
  private final Provider<Stage> windowProvider;

  private final Provider<List<Check>> checksProvider;

  private final Provider<CheckExecutor> checkExecutorProvider;

  private final Provider<ReportWriter> reportWriteTaskProvider;

  private final Provider<ObjectProperty<Check>> selectedCheckProvider;

  private final Provider<FxApplicationWindows> appWindowsProvider;

  private final Provider<CheckListCellFactory> listCellFactoryProvider;

  public CheckListController_Factory(
      Provider<Stage> windowProvider,
      Provider<List<Check>> checksProvider,
      Provider<CheckExecutor> checkExecutorProvider,
      Provider<ReportWriter> reportWriteTaskProvider,
      Provider<ObjectProperty<Check>> selectedCheckProvider,
      Provider<FxApplicationWindows> appWindowsProvider,
      Provider<CheckListCellFactory> listCellFactoryProvider) {
    this.windowProvider = windowProvider;
    this.checksProvider = checksProvider;
    this.checkExecutorProvider = checkExecutorProvider;
    this.reportWriteTaskProvider = reportWriteTaskProvider;
    this.selectedCheckProvider = selectedCheckProvider;
    this.appWindowsProvider = appWindowsProvider;
    this.listCellFactoryProvider = listCellFactoryProvider;
  }

  @Override
  public CheckListController get() {
    return newInstance(
        windowProvider.get(),
        checksProvider.get(),
        checkExecutorProvider.get(),
        reportWriteTaskProvider.get(),
        selectedCheckProvider.get(),
        appWindowsProvider.get(),
        listCellFactoryProvider.get());
  }

  public static CheckListController_Factory create(
      Provider<Stage> windowProvider,
      Provider<List<Check>> checksProvider,
      Provider<CheckExecutor> checkExecutorProvider,
      Provider<ReportWriter> reportWriteTaskProvider,
      Provider<ObjectProperty<Check>> selectedCheckProvider,
      Provider<FxApplicationWindows> appWindowsProvider,
      Provider<CheckListCellFactory> listCellFactoryProvider) {
    return new CheckListController_Factory(
        windowProvider,
        checksProvider,
        checkExecutorProvider,
        reportWriteTaskProvider,
        selectedCheckProvider,
        appWindowsProvider,
        listCellFactoryProvider);
  }

  public static CheckListController newInstance(
      Stage window,
      List<Check> checks,
      CheckExecutor checkExecutor,
      ReportWriter reportWriteTask,
      ObjectProperty<Check> selectedCheck,
      FxApplicationWindows appWindows,
      CheckListCellFactory listCellFactory) {
    return new CheckListController(
        window, checks, checkExecutor, reportWriteTask, selectedCheck, appWindows, listCellFactory);
  }
}
