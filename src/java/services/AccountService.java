package services;

import models.User;

/**
 *
 * @author 855474
 */
public class AccountService {

    public User login(String username, String password) {
        if ((username.equals("adam") || username.equals("barb")) && password.equals("password")) {
            return new User(username, null);
        }
        return null;
    }
}
