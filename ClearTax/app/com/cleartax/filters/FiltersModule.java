package com.cleartax.filters;

import com.google.inject.Inject;
import play.filters.gzip.GzipFilter;
import play.http.HttpFilters;
import play.mvc.EssentialFilter;

/**
 * @author aritra
 */
class FiltersModule implements HttpFilters {

  private final GzipFilter gzipFilter;
  private final RateFilter rateFilter;

  @Inject
  FiltersModule(GzipFilter gzipFilter, RateFilter rateFilter) {
    this.gzipFilter = gzipFilter;
    this.rateFilter = rateFilter;
  }

  @Override
  public EssentialFilter[] filters() {
    return new EssentialFilter[]{
        gzipFilter.asJava(),
        rateFilter.asJava()
    };
  }
}
