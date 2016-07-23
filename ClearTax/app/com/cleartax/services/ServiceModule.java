package com.cleartax.services;

import com.google.inject.AbstractModule;

/**
 * @author aritra
 */
public class ServiceModule extends AbstractModule {

  @Override
  protected void configure() {
    bind(AuthorizationService.class).asEagerSingleton();
    bind(UserService.class).asEagerSingleton();
  }

}
