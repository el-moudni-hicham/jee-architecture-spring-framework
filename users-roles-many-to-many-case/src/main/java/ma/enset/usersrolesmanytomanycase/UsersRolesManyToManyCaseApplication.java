package ma.enset.usersrolesmanytomanycase;

import ma.enset.usersrolesmanytomanycase.entites.Role;
import ma.enset.usersrolesmanytomanycase.entites.User;
import ma.enset.usersrolesmanytomanycase.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class UsersRolesManyToManyCaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(UsersRolesManyToManyCaseApplication.class, args);
    }
    @Bean
    CommandLineRunner start(UserService userService){
        return args -> {
            Stream.of("USER1","USER2","USER3","USER4","USER5").forEach(u -> {
                User user = new User();
                user.setUsename(u);
                user.setPassword(u+"#212");
                userService.addNewUser(user);
            });
            Stream.of("STUDENT","ADMIN","USER","PROF").forEach(r -> {
                Role role = new Role();
                role.setRoleName(r);
                userService.addNewRole(role);
            });

            userService.addRoleToUser("USER1","STUDENT");
            userService.addRoleToUser("USER1","USER");
            userService.addRoleToUser("USER2","PROF");
            userService.addRoleToUser("USER2","ADMIN");
            userService.addRoleToUser("USER3","STUDENT");
            userService.addRoleToUser("USER4","ADMIN");
            userService.addRoleToUser("USER5","USER");

            try {
                User user = userService.authenticate("USER1","USER1#212");
                System.out.println(user.getUsename());
                System.out.println(user.getUserId());
                System.out.println("----- ROLES -----");
                user.getRoles().forEach(r -> {
                    System.out.println(r.toString());
                });
            }catch (Exception e){
                e.printStackTrace();
            }
        };
    }
}
