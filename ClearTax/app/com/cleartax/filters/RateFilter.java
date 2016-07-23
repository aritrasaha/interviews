package com.cleartax.filters;

import akka.stream.Materializer;
import com.cleartax.models.ApiResponse;
import com.cleartax.services.AuthorizationService;
import com.google.inject.Inject;
import play.libs.Json;
import play.mvc.Http;
import play.mvc.Result;
import play.mvc.Results;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.function.Function;

/**
 * @author aritra
 */
class RateFilter extends BaseFilter {

  private final AuthorizationService authorizationService;

  @Inject
  public RateFilter(Materializer mat, AuthorizationService authorizationService) {
    super(mat);
    this.authorizationService = authorizationService;
  }

  @Override
  public CompletionStage<Result> apply(Function<Http.RequestHeader, CompletionStage<Result>> next, Http.RequestHeader rh) {
    Http.Cookie rawTracker = rh.cookie(AuthorizationService.TRACKER);
    String tracker = rawTracker != null ? rawTracker.value() : null;

    if (tracker == null || tracker.isEmpty()) {
      tracker = String.valueOf(System.currentTimeMillis());
    }

    Http.Cookie cookie = Http.Cookie.builder(AuthorizationService.TRACKER, tracker).build();

    ApiResponse apiResponse = authorizationService.isAuthorized(rh, tracker);

    if (apiResponse.getCalls() > -1) {
      return next.apply(rh).thenApply(result -> {
        if (cookie != null) {
          return result.withCookies(cookie);
        }

        return result;
      });
    }

    return CompletableFuture.supplyAsync(() -> {
      apiResponse.setCalls(0);
      apiResponse.setData("You are not authorized to continue. Please try after some time.");
      return Results.forbidden(Json.toJson(apiResponse));
    });
  }

}
