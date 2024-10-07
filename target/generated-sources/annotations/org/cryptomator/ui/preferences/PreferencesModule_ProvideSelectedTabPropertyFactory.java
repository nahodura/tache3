package org.cryptomator.ui.preferences;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javafx.beans.property.ObjectProperty;
import javax.annotation.processing.Generated;

@ScopeMetadata("org.cryptomator.ui.preferences.PreferencesScoped")
@QualifierMetadata
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class PreferencesModule_ProvideSelectedTabPropertyFactory
    implements Factory<ObjectProperty<SelectedPreferencesTab>> {
  @Override
  public ObjectProperty<SelectedPreferencesTab> get() {
    return provideSelectedTabProperty();
  }

  public static PreferencesModule_ProvideSelectedTabPropertyFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static ObjectProperty<SelectedPreferencesTab> provideSelectedTabProperty() {
    return Preconditions.checkNotNullFromProvides(PreferencesModule.provideSelectedTabProperty());
  }

  private static final class InstanceHolder {
    private static final PreferencesModule_ProvideSelectedTabPropertyFactory INSTANCE =
        new PreferencesModule_ProvideSelectedTabPropertyFactory();
  }
}
