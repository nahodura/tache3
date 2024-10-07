package org.cryptomator.common.vaults;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.util.concurrent.atomic.AtomicReference;
import javafx.beans.property.ObjectProperty;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.cryptomator.common.mount.Mounter;
import org.cryptomator.common.settings.Settings;
import org.cryptomator.common.settings.VaultSettings;
import org.cryptomator.cryptofs.CryptoFileSystem;

@ScopeMetadata("org.cryptomator.common.vaults.PerVault")
@QualifierMetadata("javax.inject.Named")
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class Vault_Factory implements Factory<Vault> {
  private final Provider<VaultSettings> vaultSettingsProvider;

  private final Provider<VaultConfigCache> configCacheProvider;

  private final Provider<AtomicReference<CryptoFileSystem>> cryptoFileSystemProvider;

  private final Provider<VaultState> stateProvider;

  private final Provider<ObjectProperty<Exception>> lastKnownExceptionProvider;

  private final Provider<VaultStats> statsProvider;

  private final Provider<Mounter> mounterProvider;

  private final Provider<Settings> settingsProvider;

  public Vault_Factory(
      Provider<VaultSettings> vaultSettingsProvider,
      Provider<VaultConfigCache> configCacheProvider,
      Provider<AtomicReference<CryptoFileSystem>> cryptoFileSystemProvider,
      Provider<VaultState> stateProvider,
      Provider<ObjectProperty<Exception>> lastKnownExceptionProvider,
      Provider<VaultStats> statsProvider,
      Provider<Mounter> mounterProvider,
      Provider<Settings> settingsProvider) {
    this.vaultSettingsProvider = vaultSettingsProvider;
    this.configCacheProvider = configCacheProvider;
    this.cryptoFileSystemProvider = cryptoFileSystemProvider;
    this.stateProvider = stateProvider;
    this.lastKnownExceptionProvider = lastKnownExceptionProvider;
    this.statsProvider = statsProvider;
    this.mounterProvider = mounterProvider;
    this.settingsProvider = settingsProvider;
  }

  @Override
  public Vault get() {
    return newInstance(
        vaultSettingsProvider.get(),
        configCacheProvider.get(),
        cryptoFileSystemProvider.get(),
        stateProvider.get(),
        lastKnownExceptionProvider.get(),
        statsProvider.get(),
        mounterProvider.get(),
        settingsProvider.get());
  }

  public static Vault_Factory create(
      Provider<VaultSettings> vaultSettingsProvider,
      Provider<VaultConfigCache> configCacheProvider,
      Provider<AtomicReference<CryptoFileSystem>> cryptoFileSystemProvider,
      Provider<VaultState> stateProvider,
      Provider<ObjectProperty<Exception>> lastKnownExceptionProvider,
      Provider<VaultStats> statsProvider,
      Provider<Mounter> mounterProvider,
      Provider<Settings> settingsProvider) {
    return new Vault_Factory(
        vaultSettingsProvider,
        configCacheProvider,
        cryptoFileSystemProvider,
        stateProvider,
        lastKnownExceptionProvider,
        statsProvider,
        mounterProvider,
        settingsProvider);
  }

  public static Vault newInstance(
      VaultSettings vaultSettings,
      VaultConfigCache configCache,
      AtomicReference<CryptoFileSystem> cryptoFileSystem,
      VaultState state,
      ObjectProperty<Exception> lastKnownException,
      VaultStats stats,
      Mounter mounter,
      Settings settings) {
    return new Vault(
        vaultSettings,
        configCache,
        cryptoFileSystem,
        state,
        lastKnownException,
        stats,
        mounter,
        settings);
  }
}
