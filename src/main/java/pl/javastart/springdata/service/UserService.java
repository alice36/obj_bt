package pl.javastart.springdata.service;

import org.springframework.stereotype.Service;
import pl.javastart.springdata.model.User;
import pl.javastart.springdata.model.UserRole;
import pl.javastart.springdata.repository.UserRepository;
import pl.javastart.springdata.repository.UserRoleRepository;
//import org.springframework.security.crypto.password.PasswordEncoder;

//@Service
//public class UserService {
//    private UserRepository userRepository;
//    private UserRoleRepository userRoleRepository;
//    private PasswordEncoder passwordEncoder;
//
//    public UserService(UserRepository userRepository, UserRoleRepository userRoleRepository, PasswordEncoder passwordEncoder) {
//        this.userRepository = userRepository;
//        this.userRoleRepository = userRoleRepository;
//        this.passwordEncoder = passwordEncoder;
//    }
//
//    public void saveUser(String username, String password){
//
//        User user = new User();
//        user.setUsername(username);
//        user.setPassword(passwordEncoder.encode(password));
//        user.setEnabled(true);
//        userRepository.save(user);
//
//        UserRole userRole = new UserRole();
//        userRole.setUsername(username);
//        userRole.setRole("ROLE_USER");
//        userRoleRepository.save(userRole);
//
//    }
//}
