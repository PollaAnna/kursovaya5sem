package org.server.login;

import java.util.Objects;

public interface UserService
{
    public String login(String login, String password);
    class UserServiceImplementation implements UserService{
        UserDAO userDAO = new UserDAO.UserDAOImplementation();
        @Override
        public String login(String login, String password) {
            User user = userDAO.getUserByLogin(login);
            if(user != null)
            {
                if(Objects.equals(user.getLogin(), login) && Objects.equals(user.getPassword(), password))
                {
                    return user.getLogin();
                }
            }
            return "";
        }
    }
}
