package com.cleartax.dao;

import com.cleartax.models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author aritra
 */
public class UserDao extends BaseDao {

  private final List<User> users;

  UserDao() {
    this.users = new ArrayList<>();
    loadUsers();
  }

  public List<User> getUsers() {
    return users;
  }

  public User getUser(Integer id) {
    for (User user : users) {
      if (Objects.equals(user.getId(), id)) {
        return user;
      }
    }

    return null;
  }

  private void loadUsers() {
    User user = new User();
    user.setId(1);
    user.setName("Aritra Saha");
    user.setEmail("aritrasaha@outlook.com");
    user.setPhone(7795765542L);
    users.add(user);

    user = new User();
    user.setId(2);
    user.setName("Chumki Saha");
    user.setEmail("chumkisaha@outlook.com");
    user.setPhone(9830574778L);
    users.add(user);

    user = new User();
    user.setId(2);
    user.setName("Anuj Saha");
    user.setEmail("anujkrsaha@outlook.com");
    user.setPhone(9432499393L);
    users.add(user);
  }

}
