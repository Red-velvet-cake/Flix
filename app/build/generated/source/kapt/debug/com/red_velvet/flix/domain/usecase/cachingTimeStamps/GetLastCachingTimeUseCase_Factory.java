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
public final class GetLastCachingTimeUseCase_Factory implements Factory<GetLastCachingTimeUseCase> {
  private final Provider<UserRepository> userRepositoryProvider;

  public GetLastCachingTimeUseCase_Factory(Provider<UserRepository> userRepositoryProvider) {
    this.userRepositoryProvider = userRepositoryProvider;
  }

  @Override
  public GetLastCachingTimeUseCase get() {
    return newInstance(userRepositoryProvider.get());
  }

  public static GetLastCachingTimeUseCase_Factory create(
      Provider<UserRepository> userRepositoryProvider) {
    return new GetLastCachingTimeUseCase_Factory(userRepositoryProvider);
  }

  public static GetLastCachingTimeUseCase newInstance(UserRepository userRepository) {
    return new GetLastCachingTimeUseCase(userRepository);
  }
}
