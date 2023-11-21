package org.server.login;

import org.server.SessionUtils;

public interface UserDAO {
    public User getUserByLogin(String login);
     class UserDAOImplementation implements UserDAO
     {
         @Override
         public User getUserByLogin(String login)
         {
             return SessionUtils.find(User.class, login, "login");
         }
     }
}
