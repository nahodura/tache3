package org.cryptomator.ui.recoverykey;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.cryptomator.cryptolib.common.MasterkeyFileAccess;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class RecoveryKeyFactory_Factory implements Factory<RecoveryKeyFactory> {
  private final Provider<WordEncoder> wordEncoderProvider;

  private final Provider<MasterkeyFileAccess> masterkeyFileAccessProvider;

  public RecoveryKeyFactory_Factory(
      Provider<WordEncoder> wordEncoderProvider,
      Provider<MasterkeyFileAccess> masterkeyFileAccessProvider) {
    this.wordEncoderProvider = wordEncoderProvider;
    this.masterkeyFileAccessProvider = masterkeyFileAccessProvider;
  }

  @Override
  public RecoveryKeyFactory get() {
    return newInstance(wordEncoderProvider.get(), masterkeyFileAccessProvider.get());
  }

  public static RecoveryKeyFactory_Factory create(
      Provider<WordEncoder> wordEncoderProvider,
      Provider<MasterkeyFileAccess> masterkeyFileAccessProvider) {
    return new RecoveryKeyFactory_Factory(wordEncoderProvider, masterkeyFileAccessProvider);
  }

  public static RecoveryKeyFactory newInstance(
      Object wordEncoder, MasterkeyFileAccess masterkeyFileAccess) {
    return new RecoveryKeyFactory((WordEncoder) wordEncoder, masterkeyFileAccess);
  }
}
