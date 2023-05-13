package ma.enset.usersrolesmanytomanycase.repositories;

import ma.enset.usersrolesmanytomanycase.entites.Role;
import ma.enset.usersrolesmanytomanycase.entites.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByRoleName(String roleName);
}
