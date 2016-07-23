package com.cleartax.controllers;

import com.cleartax.services.UserService;
import com.google.inject.Inject;
import play.libs.Json;
import play.mvc.Result;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

/**
 * @author aritra
 */
public class UserController extends BaseController {

  private final UserService userService;

  @Inject
  UserController(UserService userService) {
    this.userService = userService;
  }

  public CompletionStage<Result> getUsers() {
    return CompletableFuture.supplyAsync(() -> {
      return ok(Json.toJson(userService.getUsers()));
    });
  }

  public CompletionStage<Result> getUser(Integer id) {
    return CompletableFuture.supplyAsync(() -> {
      return ok(Json.toJson(userService.getUser(id)));
    });
  }

}
