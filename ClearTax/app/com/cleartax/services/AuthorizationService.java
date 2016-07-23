package com.cleartax.services;

import com.cleartax.helpers.RateLimiter;
import com.cleartax.models.ApiResponse;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import play.mvc.Http;


/**
 * @author aritra
 */
public class AuthorizationService {

  public static final String USER_ID = "user_id";
  public static final String TRACKER = "api_tracker";

  private final RateLimiter defaultRateLimiter;
  private final RateLimiter normalRateLimiter;
  private final RateLimiter premiumRateLimiter;

  @Inject
  AuthorizationService(RateLimiter defaultRateLimiter,
                       @Named("normal") RateLimiter normalRateLimiter,
                       @Named("premium") RateLimiter premiumRateLimiter) {
    this.defaultRateLimiter = defaultRateLimiter;
    this.normalRateLimiter = normalRateLimiter;
    this.premiumRateLimiter = premiumRateLimiter;
  }

  public ApiResponse isAuthorized(Http.RequestHeader rh, String tracker) {
    Http.Cookie rawUserId = rh.cookie(USER_ID);
    String userId = rawUserId != null ? rawUserId.value() : null;

    if (userId != null && !userId.isEmpty()) {
      if (isPremium(userId)) {
        return premiumRateLimiter.isAllowed(userId);
      } else {
        return normalRateLimiter.isAllowed(userId);
      }
    }

    return defaultRateLimiter.isAllowed(tracker);
  }

  private boolean isPremium(String userId) {
    return userId.length() > 4;
  }

}
