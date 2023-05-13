package ma.enset.usersrolesmanytomanycase.repositories;

import ma.enset.usersrolesmanytomanycase.entites.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    User findByUsename(String username);
}

