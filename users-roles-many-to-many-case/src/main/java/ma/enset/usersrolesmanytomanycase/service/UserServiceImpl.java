package ma.enset.usersrolesmanytomanycase.service;

import lombok.AllArgsConstructor;
import ma.enset.usersrolesmanytomanycase.entites.Role;
import ma.enset.usersrolesmanytomanycase.entites.User;
import ma.enset.usersrolesmanytomanycase.repositories.RoleRepository;
import ma.enset.usersrolesmanytomanycase.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    @Override
    public User addNewUser(User user) {
        user.setUserId(UUID.randomUUID().toString());
        return userRepository.save(user);
    }

    @Override
    public Role addNewRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public User findUserByUserName(String username) {
        return userRepository.findByUsename(username);
    }

    @Override
    public Role findRoleByRoleName(String roleName) {
        return roleRepository.findByRoleName(roleName);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        User user = findUserByUserName(username);
        Role role = findRoleByRoleName(roleName);
        if(user.getRoles() != null && role.getUsers() != null){
            user.getRoles().add(role);
            role.getUsers().add(user);
        }
    }

    @Override
    public User authenticate(String username, String password) {
        User user = findUserByUserName(username);
        if(user == null) throw new RuntimeException("Bad Credentials !");
        if(user.getPassword().equals(password))
            return user;
        throw new RuntimeException("Bad Credentials !");
    }
}
