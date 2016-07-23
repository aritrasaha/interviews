package com.cleartax.dao;

import com.google.inject.AbstractModule;

/**
 * @author aritra
 */
public class DaoModule extends AbstractModule {

  @Override
  protected void configure() {
    bind(UserDao.class).asEagerSingleton();
  }

}
