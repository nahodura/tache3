package org.cryptomator.ui.keyloading.masterkeyfile;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.nio.file.Path;
import java.util.ResourceBundle;
import java.util.concurrent.CompletableFuture;
import javafx.stage.Stage;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.cryptomator.common.vaults.Vault;

@ScopeMetadata("org.cryptomator.ui.keyloading.masterkeyfile.ChooseMasterkeyFileScoped")
@QualifierMetadata("org.cryptomator.ui.keyloading.KeyLoading")
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class ChooseMasterkeyFileController_Factory
    implements Factory<ChooseMasterkeyFileController> {
  private final Provider<Stage> windowProvider;

  private final Provider<Vault> vaultProvider;

  private final Provider<CompletableFuture<Path>> resultProvider;

  private final Provider<ResourceBundle> resourceBundleProvider;

  public ChooseMasterkeyFileController_Factory(
      Provider<Stage> windowProvider,
      Provider<Vault> vaultProvider,
      Provider<CompletableFuture<Path>> resultProvider,
      Provider<ResourceBundle> resourceBundleProvider) {
    this.windowProvider = windowProvider;
    this.vaultProvider = vaultProvider;
    this.resultProvider = resultProvider;
    this.resourceBundleProvider = resourceBundleProvider;
  }

  @Override
  public ChooseMasterkeyFileController get() {
    return newInstance(
        windowProvider.get(),
        vaultProvider.get(),
        resultProvider.get(),
        resourceBundleProvider.get());
  }

  public static ChooseMasterkeyFileController_Factory create(
      Provider<Stage> windowProvider,
      Provider<Vault> vaultProvider,
      Provider<CompletableFuture<Path>> resultProvider,
      Provider<ResourceBundle> resourceBundleProvider) {
    return new ChooseMasterkeyFileController_Factory(
        windowProvider, vaultProvider, resultProvider, resourceBundleProvider);
  }

  public static ChooseMasterkeyFileController newInstance(
      Stage window, Vault vault, CompletableFuture<Path> result, ResourceBundle resourceBundle) {
    return new ChooseMasterkeyFileController(window, vault, result, resourceBundle);
  }
}
