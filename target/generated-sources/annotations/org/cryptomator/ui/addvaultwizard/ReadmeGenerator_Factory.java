package org.cryptomator.ui.addvaultwizard;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.util.ResourceBundle;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("org.cryptomator.ui.addvaultwizard.AddVaultWizardScoped")
@QualifierMetadata
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class ReadmeGenerator_Factory implements Factory<ReadmeGenerator> {
  private final Provider<ResourceBundle> resourceBundleProvider;

  public ReadmeGenerator_Factory(Provider<ResourceBundle> resourceBundleProvider) {
    this.resourceBundleProvider = resourceBundleProvider;
  }

  @Override
  public ReadmeGenerator get() {
    return newInstance(resourceBundleProvider.get());
  }

  public static ReadmeGenerator_Factory create(Provider<ResourceBundle> resourceBundleProvider) {
    return new ReadmeGenerator_Factory(resourceBundleProvider);
  }

  public static ReadmeGenerator newInstance(ResourceBundle resourceBundle) {
    return new ReadmeGenerator(resourceBundle);
  }
}
