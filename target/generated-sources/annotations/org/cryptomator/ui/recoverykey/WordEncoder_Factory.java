package org.cryptomator.ui.recoverykey;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class WordEncoder_Factory implements Factory<WordEncoder> {
  @Override
  public WordEncoder get() {
    return newInstance();
  }

  public static WordEncoder_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static WordEncoder newInstance() {
    return new WordEncoder();
  }

  private static final class InstanceHolder {
    private static final WordEncoder_Factory INSTANCE = new WordEncoder_Factory();
  }
}
