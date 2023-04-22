package CrudBoot.CRUDBootWeb.Repository;


import CrudBoot.CRUDBootWeb.models.User;

import java.util.List;

public interface UserRep {
    List<User> getAllUsers();

    void createUser(User user);

    User readUser(long id);

    void updateUser(User userOld, Long id);

    void deleteUser(long id);
}
