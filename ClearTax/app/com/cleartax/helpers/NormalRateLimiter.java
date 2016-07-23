package com.cleartax.helpers;

import com.google.inject.Inject;
import play.Configuration;
import play.cache.CacheApi;

/**
 * @author aritra
 */
final class NormalRateLimiter extends RateLimiter {

  private final Configuration configuration;

  @Inject
  NormalRateLimiter(CacheApi cacheApi, Configuration configuration) {
    super(cacheApi, configuration);
    this.configuration = configuration;
  }

  @Override
  public Integer getRate() {
    return configuration.getInt("rate_limiter.normal.rate");
  }

  @Override
  protected Integer getTimeWindow() {
    return configuration.getInt("rate_limiter.normal.window");
  }

}
