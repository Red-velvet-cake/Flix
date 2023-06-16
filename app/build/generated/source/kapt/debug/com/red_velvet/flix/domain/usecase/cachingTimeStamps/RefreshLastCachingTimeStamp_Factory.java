package com.red_velvet.flix.domain.usecase.cachingTimeStamps;

import com.red_velvet.flix.domain.repository.UserRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class RefreshLastCachingTimeStamp_Factory implements Factory<RefreshLastCachingTimeStamp> {
  private final Provider<UserRepository> userRepositoryProvider;

  private final Provider<GetCurrentTimestampUseCase> getCurrentTimestampUseCaseProvider;

  public RefreshLastCachingTimeStamp_Factory(Provider<UserRepository> userRepositoryProvider,
      Provider<GetCurrentTimestampUseCase> getCurrentTimestampUseCaseProvider) {
    this.userRepositoryProvider = userRepositoryProvider;
    this.getCurrentTimestampUseCaseProvider = getCurrentTimestampUseCaseProvider;
  }

  @Override
  public RefreshLastCachingTimeStamp get() {
    return newInstance(userRepositoryProvider.get(), getCurrentTimestampUseCaseProvider.get());
  }

  public static RefreshLastCachingTimeStamp_Factory create(
      Provider<UserRepository> userRepositoryProvider,
      Provider<GetCurrentTimestampUseCase> getCurrentTimestampUseCaseProvider) {
    return new RefreshLastCachingTimeStamp_Factory(userRepositoryProvider, getCurrentTimestampUseCaseProvider);
  }

  public static RefreshLastCachingTimeStamp newInstance(UserRepository userRepository,
      GetCurrentTimestampUseCase getCurrentTimestampUseCase) {
    return new RefreshLastCachingTimeStamp(userRepository, getCurrentTimestampUseCase);
  }
}
