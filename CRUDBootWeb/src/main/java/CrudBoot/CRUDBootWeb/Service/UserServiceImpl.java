package CrudBoot.CRUDBootWeb.Service;

import CrudBoot.CRUDBootWeb.Repository.UserRep;
import CrudBoot.CRUDBootWeb.models.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class UserServiceImpl implements UserService{
    private final UserRep userRepS;

    public UserServiceImpl(UserRep userRepS) {
        this.userRepS = userRepS;
    }

    @Override
    @Transactional
    public List<User> getAllUsers() {
        return userRepS.getAllUsers();
    }

    @Override
    @Transactional
    public void createUser(User user) {
    userRepS.createUser(user);
    }

    @Override
    @Transactional
    public void updateUser(User user, Long id) {
    userRepS.updateUser(user, id);
    }

    @Override
    @Transactional
    public User readUser(long id) {
        return userRepS.readUser(id);
    }

    @Override
    @Transactional
    public void deleteUser(long id) {
        userRepS.deleteUser(id);
    }
}
