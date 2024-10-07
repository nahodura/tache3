package org.cryptomator.ui.recoverykey;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javafx.stage.Stage;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.cryptomator.ui.common.StageFactory;

@ScopeMetadata("org.cryptomator.ui.recoverykey.RecoveryKeyScoped")
@QualifierMetadata({"org.cryptomator.ui.recoverykey.RecoveryKeyWindow", "javax.inject.Named"})
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class RecoveryKeyModule_ProvideStageFactory implements Factory<Stage> {
  private final Provider<StageFactory> factoryProvider;

  private final Provider<Stage> ownerProvider;

  public RecoveryKeyModule_ProvideStageFactory(
      Provider<StageFactory> factoryProvider, Provider<Stage> ownerProvider) {
    this.factoryProvider = factoryProvider;
    this.ownerProvider = ownerProvider;
  }

  @Override
  public Stage get() {
    return provideStage(factoryProvider.get(), ownerProvider.get());
  }

  public static RecoveryKeyModule_ProvideStageFactory create(
      Provider<StageFactory> factoryProvider, Provider<Stage> ownerProvider) {
    return new RecoveryKeyModule_ProvideStageFactory(factoryProvider, ownerProvider);
  }

  public static Stage provideStage(StageFactory factory, Stage owner) {
    return Preconditions.checkNotNullFromProvides(RecoveryKeyModule.provideStage(factory, owner));
  }
}
