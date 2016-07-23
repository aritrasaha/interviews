package com.cleartax.controllers;

import com.cleartax.views.html.IndexView;
import play.mvc.Result;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

/**
 * @author aritra
 */
public class HomeController extends BaseController {

  public CompletionStage<Result> index() {
    return CompletableFuture.supplyAsync(() -> {
      return ok(IndexView.render());
    });
  }

}
