package com.cleartax.services;

import com.cleartax.dao.UserDao;
import com.cleartax.models.User;
import com.google.inject.Inject;

import java.util.List;

/**
 * @author aritra
 */
public class UserService extends BaseService {

  private final UserDao userDao;

  @Inject
  UserService(UserDao userDao) {
    this.userDao = userDao;
  }

  public List<User> getUsers() {
    return userDao.getUsers();
  }

  public User getUser(Integer id) {
    return userDao.getUser(id);
  }

}
