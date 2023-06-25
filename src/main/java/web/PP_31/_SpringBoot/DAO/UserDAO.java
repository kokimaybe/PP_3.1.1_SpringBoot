package web.PP_31._SpringBoot.DAO;

import web.PP_31._SpringBoot.model.User;

import java.util.List;

public interface UserDAO {

    List<User> getAllUsers();

    void createUser(User user);

    void updateUser(User user);

    User readUser(long id);

    User deleteUser(long id);
}

