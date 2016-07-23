package com.cleartax.filters;

import akka.stream.Materializer;
import play.mvc.Filter;

/**
 * @author aritra
 */
abstract class BaseFilter extends Filter {

  BaseFilter(Materializer mat) {
    super(mat);
  }

}
