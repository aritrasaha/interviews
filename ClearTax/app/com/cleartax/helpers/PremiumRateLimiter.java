package com.cleartax.helpers;

import com.google.inject.Inject;
import play.Configuration;
import play.cache.CacheApi;

/**
 * @author aritra
 */
final class PremiumRateLimiter extends RateLimiter {

  private final Configuration configuration;

  @Inject
  PremiumRateLimiter(CacheApi cacheApi, Configuration configuration) {
    super(cacheApi, configuration);
    this.configuration = configuration;
  }

  @Override
  public Integer getRate() {
    return configuration.getInt("rate_limiter.premium.rate");
  }

  @Override
  protected Integer getTimeWindow() {
    return configuration.getInt("rate_limiter.premium.window");
  }

}
