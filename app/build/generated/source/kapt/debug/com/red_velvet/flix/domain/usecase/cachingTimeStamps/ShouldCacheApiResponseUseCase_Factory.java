package com.red_velvet.flix.domain.usecase.cachingTimeStamps;

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
public final class ShouldCacheApiResponseUseCase_Factory implements Factory<ShouldCacheApiResponseUseCase> {
  private final Provider<GetLastCachingTimeUseCase> getLastCachingTimeUseCaeProvider;

  private final Provider<GetCurrentTimestampUseCase> getCurrentTimestampUseCaseProvider;

  private final Provider<RefreshLastCachingTimeStamp> refreshLastCachingTimeStampProvider;

  public ShouldCacheApiResponseUseCase_Factory(
      Provider<GetLastCachingTimeUseCase> getLastCachingTimeUseCaeProvider,
      Provider<GetCurrentTimestampUseCase> getCurrentTimestampUseCaseProvider,
      Provider<RefreshLastCachingTimeStamp> refreshLastCachingTimeStampProvider) {
    this.getLastCachingTimeUseCaeProvider = getLastCachingTimeUseCaeProvider;
    this.getCurrentTimestampUseCaseProvider = getCurrentTimestampUseCaseProvider;
    this.refreshLastCachingTimeStampProvider = refreshLastCachingTimeStampProvider;
  }

  @Override
  public ShouldCacheApiResponseUseCase get() {
    return newInstance(getLastCachingTimeUseCaeProvider.get(), getCurrentTimestampUseCaseProvider.get(), refreshLastCachingTimeStampProvider.get());
  }

  public static ShouldCacheApiResponseUseCase_Factory create(
      Provider<GetLastCachingTimeUseCase> getLastCachingTimeUseCaeProvider,
      Provider<GetCurrentTimestampUseCase> getCurrentTimestampUseCaseProvider,
      Provider<RefreshLastCachingTimeStamp> refreshLastCachingTimeStampProvider) {
    return new ShouldCacheApiResponseUseCase_Factory(getLastCachingTimeUseCaeProvider, getCurrentTimestampUseCaseProvider, refreshLastCachingTimeStampProvider);
  }

  public static ShouldCacheApiResponseUseCase newInstance(
      GetLastCachingTimeUseCase getLastCachingTimeUseCae,
      GetCurrentTimestampUseCase getCurrentTimestampUseCase,
      RefreshLastCachingTimeStamp refreshLastCachingTimeStamp) {
    return new ShouldCacheApiResponseUseCase(getLastCachingTimeUseCae, getCurrentTimestampUseCase, refreshLastCachingTimeStamp);
  }
}
