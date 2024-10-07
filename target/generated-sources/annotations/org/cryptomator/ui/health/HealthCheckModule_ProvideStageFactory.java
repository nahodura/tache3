package org.cryptomator.ui.health;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.stage.Stage;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.cryptomator.common.vaults.Vault;
import org.cryptomator.ui.common.StageFactory;

@ScopeMetadata("org.cryptomator.ui.health.HealthCheckScoped")
@QualifierMetadata({"org.cryptomator.ui.health.HealthCheckWindow", "javax.inject.Named"})
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class HealthCheckModule_ProvideStageFactory implements Factory<Stage> {
  private final Provider<StageFactory> factoryProvider;

  private final Provider<Stage> ownerProvider;

  private final Provider<Vault> vaultProvider;

  private final Provider<ChangeListener<Boolean>> showingListenerProvider;

  private final Provider<ResourceBundle> resourceBundleProvider;

  public HealthCheckModule_ProvideStageFactory(
      Provider<StageFactory> factoryProvider,
      Provider<Stage> ownerProvider,
      Provider<Vault> vaultProvider,
      Provider<ChangeListener<Boolean>> showingListenerProvider,
      Provider<ResourceBundle> resourceBundleProvider) {
    this.factoryProvider = factoryProvider;
    this.ownerProvider = ownerProvider;
    this.vaultProvider = vaultProvider;
    this.showingListenerProvider = showingListenerProvider;
    this.resourceBundleProvider = resourceBundleProvider;
  }

  @Override
  public Stage get() {
    return provideStage(
        factoryProvider.get(),
        ownerProvider.get(),
        vaultProvider.get(),
        showingListenerProvider.get(),
        resourceBundleProvider.get());
  }

  public static HealthCheckModule_ProvideStageFactory create(
      Provider<StageFactory> factoryProvider,
      Provider<Stage> ownerProvider,
      Provider<Vault> vaultProvider,
      Provider<ChangeListener<Boolean>> showingListenerProvider,
      Provider<ResourceBundle> resourceBundleProvider) {
    return new HealthCheckModule_ProvideStageFactory(
        factoryProvider,
        ownerProvider,
        vaultProvider,
        showingListenerProvider,
        resourceBundleProvider);
  }

  public static Stage provideStage(
      StageFactory factory,
      Stage owner,
      Vault vault,
      ChangeListener<Boolean> showingListener,
      ResourceBundle resourceBundle) {
    return Preconditions.checkNotNullFromProvides(
        HealthCheckModule.provideStage(factory, owner, vault, showingListener, resourceBundle));
  }
}
