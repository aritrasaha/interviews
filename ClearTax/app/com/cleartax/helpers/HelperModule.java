package com.cleartax.helpers;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

/**
 * @author aritra
 */
public class HelperModule extends AbstractModule {

  @Override
  protected void configure() {
    bind(RateLimiter.class).asEagerSingleton();
    bind(RateLimiter.class).annotatedWith(Names.named("normal")).to(NormalRateLimiter.class).asEagerSingleton();
    bind(RateLimiter.class).annotatedWith(Names.named("premium")).to(PremiumRateLimiter.class).asEagerSingleton();
  }

}
