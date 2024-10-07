package org.cryptomator.common.vaults;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.processing.Generated;
import org.cryptomator.cryptofs.CryptoFileSystem;

@ScopeMetadata("org.cryptomator.common.vaults.PerVault")
@QualifierMetadata
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class VaultModule_ProvideCryptoFileSystemReferenceFactory
    implements Factory<AtomicReference<CryptoFileSystem>> {
  private final VaultModule module;

  public VaultModule_ProvideCryptoFileSystemReferenceFactory(VaultModule module) {
    this.module = module;
  }

  @Override
  public AtomicReference<CryptoFileSystem> get() {
    return provideCryptoFileSystemReference(module);
  }

  public static VaultModule_ProvideCryptoFileSystemReferenceFactory create(VaultModule module) {
    return new VaultModule_ProvideCryptoFileSystemReferenceFactory(module);
  }

  public static AtomicReference<CryptoFileSystem> provideCryptoFileSystemReference(
      VaultModule instance) {
    return Preconditions.checkNotNullFromProvides(instance.provideCryptoFileSystemReference());
  }
}
