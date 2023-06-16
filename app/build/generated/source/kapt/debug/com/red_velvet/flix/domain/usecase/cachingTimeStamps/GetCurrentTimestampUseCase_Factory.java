package com.red_velvet.flix.domain.usecase.cachingTimeStamps;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.util.Date;
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
public final class GetCurrentTimestampUseCase_Factory implements Factory<GetCurrentTimestampUseCase> {
  private final Provider<Date> dateProvider;

  public GetCurrentTimestampUseCase_Factory(Provider<Date> dateProvider) {
    this.dateProvider = dateProvider;
  }

  @Override
  public GetCurrentTimestampUseCase get() {
    return newInstance(dateProvider.get());
  }

  public static GetCurrentTimestampUseCase_Factory create(Provider<Date> dateProvider) {
    return new GetCurrentTimestampUseCase_Factory(dateProvider);
  }

  public static GetCurrentTimestampUseCase newInstance(Date date) {
    return new GetCurrentTimestampUseCase(date);
  }
}
