package org.cryptomator.ui.health;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.util.concurrent.atomic.AtomicReference;
import javafx.application.Application;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.cryptomator.common.Environment;
import org.cryptomator.common.vaults.Vault;
import org.cryptomator.cryptofs.VaultConfig;

@ScopeMetadata("org.cryptomator.ui.health.HealthCheckScoped")
@QualifierMetadata("org.cryptomator.ui.health.HealthCheckWindow")
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class ReportWriter_Factory implements Factory<ReportWriter> {
  private final Provider<Vault> vaultProvider;

  private final Provider<AtomicReference<VaultConfig>> vaultConfigRefProvider;

  private final Provider<Application> applicationProvider;

  private final Provider<Environment> envProvider;

  public ReportWriter_Factory(
      Provider<Vault> vaultProvider,
      Provider<AtomicReference<VaultConfig>> vaultConfigRefProvider,
      Provider<Application> applicationProvider,
      Provider<Environment> envProvider) {
    this.vaultProvider = vaultProvider;
    this.vaultConfigRefProvider = vaultConfigRefProvider;
    this.applicationProvider = applicationProvider;
    this.envProvider = envProvider;
  }

  @Override
  public ReportWriter get() {
    return newInstance(
        vaultProvider.get(),
        vaultConfigRefProvider.get(),
        applicationProvider.get(),
        envProvider.get());
  }

  public static ReportWriter_Factory create(
      Provider<Vault> vaultProvider,
      Provider<AtomicReference<VaultConfig>> vaultConfigRefProvider,
      Provider<Application> applicationProvider,
      Provider<Environment> envProvider) {
    return new ReportWriter_Factory(
        vaultProvider, vaultConfigRefProvider, applicationProvider, envProvider);
  }

  public static ReportWriter newInstance(
      Vault vault,
      AtomicReference<VaultConfig> vaultConfigRef,
      Application application,
      Environment env) {
    return new ReportWriter(vault, vaultConfigRef, application, env);
  }
}
