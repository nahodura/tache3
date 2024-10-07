package org.cryptomator.launcher;

import dagger.Lazy;
import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.cryptomator.common.Environment;
import org.cryptomator.common.ShutdownHook;
import org.cryptomator.logging.DebugMode;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
@Generated(value = "dagger.internal.codegen.ComponentProcessor", comments = "https://dagger.dev")
@SuppressWarnings({"unchecked", "rawtypes", "KotlinInternal", "KotlinInternalInJava", "cast"})
public final class Cryptomator_Factory implements Factory<Cryptomator> {
  private final Provider<DebugMode> debugModeProvider;

  private final Provider<SupportedLanguages> supportedLanguagesProvider;

  private final Provider<Environment> envProvider;

  private final Provider<IpcMessageHandler> ipcMessageHandlerProvider;

  private final Provider<ShutdownHook> shutdownHookProvider;

  public Cryptomator_Factory(
      Provider<DebugMode> debugModeProvider,
      Provider<SupportedLanguages> supportedLanguagesProvider,
      Provider<Environment> envProvider,
      Provider<IpcMessageHandler> ipcMessageHandlerProvider,
      Provider<ShutdownHook> shutdownHookProvider) {
    this.debugModeProvider = debugModeProvider;
    this.supportedLanguagesProvider = supportedLanguagesProvider;
    this.envProvider = envProvider;
    this.ipcMessageHandlerProvider = ipcMessageHandlerProvider;
    this.shutdownHookProvider = shutdownHookProvider;
  }

  @Override
  public Cryptomator get() {
    return newInstance(
        debugModeProvider.get(),
        supportedLanguagesProvider.get(),
        envProvider.get(),
        DoubleCheck.lazy(ipcMessageHandlerProvider),
        shutdownHookProvider.get());
  }

  public static Cryptomator_Factory create(
      Provider<DebugMode> debugModeProvider,
      Provider<SupportedLanguages> supportedLanguagesProvider,
      Provider<Environment> envProvider,
      Provider<IpcMessageHandler> ipcMessageHandlerProvider,
      Provider<ShutdownHook> shutdownHookProvider) {
    return new Cryptomator_Factory(
        debugModeProvider,
        supportedLanguagesProvider,
        envProvider,
        ipcMessageHandlerProvider,
        shutdownHookProvider);
  }

  public static Cryptomator newInstance(
      DebugMode debugMode,
      SupportedLanguages supportedLanguages,
      Environment env,
      Lazy<IpcMessageHandler> ipcMessageHandler,
      ShutdownHook shutdownHook) {
    return new Cryptomator(debugMode, supportedLanguages, env, ipcMessageHandler, shutdownHook);
  }
}
