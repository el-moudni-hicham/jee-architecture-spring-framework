package ma.enset.usersrolesmanytomanycase.service;

import ma.enset.usersrolesmanytomanycase.entites.Role;
import ma.enset.usersrolesmanytomanycase.entites.User;

public interface UserService {
    User addNewUser(User user);
    Role addNewRole(Role role);
    User findUserByUserName(String username);
    Role findRoleByRoleName(String roleName);
    void addRoleToUser(String username, String roleName);
    User authenticate(String username, String password);
}
