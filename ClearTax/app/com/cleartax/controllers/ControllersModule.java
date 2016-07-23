package com.cleartax.controllers;

import com.google.inject.AbstractModule;

/**
 * @author aritra
 */
public class ControllersModule extends AbstractModule {

  @Override
  protected void configure() {
    bind(HomeController.class).asEagerSingleton();
    bind(UserController.class).asEagerSingleton();
  }

}
