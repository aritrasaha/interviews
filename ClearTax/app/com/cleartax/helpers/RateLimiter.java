package com.cleartax.helpers;

import com.cleartax.models.ApiResponse;
import com.google.inject.Inject;
import play.Configuration;
import play.cache.CacheApi;

import java.util.Date;
import java.util.LinkedList;

/**
 * @author aritra
 */
public class RateLimiter {

  private final CacheApi cacheApi;
  private final Configuration configuration;

  @Inject
  RateLimiter(CacheApi cacheApi, Configuration configuration) {
    this.cacheApi = cacheApi;
    this.configuration = configuration;
  }

  public Integer getRate() {
    return configuration.getInt("rate_limiter.default.rate");
  }

  protected Integer getTimeWindow() {
    return configuration.getInt("rate_limiter.default.window");
  }

  public ApiResponse isAllowed(String id) {
    Object rawTimestamps = cacheApi.get(id);
    LinkedList<Date> timestamps;
    ApiResponse apiResponse = new ApiResponse(getRate());

    if (rawTimestamps instanceof LinkedList) {
      try {
        timestamps = (LinkedList<Date>) rawTimestamps;
      } catch (ClassCastException cce) {
        timestamps = new LinkedList<>();
      }
    } else {
      timestamps = new LinkedList<>();
    }

    Date cutoff = new Date(System.currentTimeMillis() - (getTimeWindow() * 1000));
    Date current = new Date();

    for (Date timestamp : timestamps) {
      if (timestamp.before(cutoff)) {
        timestamps.remove(timestamp);
      }
    }

    if (timestamps.size() < getRate()) {
      timestamps.addLast(current);
      apiResponse.setCalls(Math.abs(getRate() - timestamps.size()));
    } else {
      apiResponse.setCalls(-1);
    }

    cacheApi.set(id, timestamps, getTimeWindow());
    return apiResponse;
  }

}
