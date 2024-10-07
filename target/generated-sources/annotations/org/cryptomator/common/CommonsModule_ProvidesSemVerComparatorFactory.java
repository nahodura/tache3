package org.cryptomator.common;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.util.Comparator;
import javax.annotation.processing.Generated;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata("javax.inject.Named")
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class CommonsModule_ProvidesSemVerComparatorFactory
    implements Factory<Comparator<String>> {
  @Override
  public Comparator<String> get() {
    return providesSemVerComparator();
  }

  public static CommonsModule_ProvidesSemVerComparatorFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static Comparator<String> providesSemVerComparator() {
    return Preconditions.checkNotNullFromProvides(CommonsModule.providesSemVerComparator());
  }

  private static final class InstanceHolder {
    private static final CommonsModule_ProvidesSemVerComparatorFactory INSTANCE =
        new CommonsModule_ProvidesSemVerComparatorFactory();
  }
}
