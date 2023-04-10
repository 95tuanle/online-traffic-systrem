package humber.natl.onlinetrafficsystem.onlinetrafficsystem.dao;

import humber.natl.onlinetrafficsystem.onlinetrafficsystem.models.User;

public interface UserDao {
    void create(User user);

    User readByEmail(String email);

    User getUserByEmail(String email);
}
