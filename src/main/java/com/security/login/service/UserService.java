//package com.security.login.service;
//
//import com.security.login.entity.Users;
//import com.security.login.repo.UserRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//
////@Service
////public class UserService {
////
////    @Autowired
////    private UserRepo repo;
////
////    @Autowired
////    private JWTService jwtService;
////
////    @Autowired
////    AuthenticationManager authManager;
////
////    private BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(12);
////
////    public Users register(Users user){
////        user.setPassword(encoder.encode(user.getPassword()));
////       return repo.save(user);
////
////    }
////
////    public String verify(Users user) {
////        Authentication authentication=
////                authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
////
////        if (authentication.isAuthenticated()){
////            String username = authentication.getName(); // Retrieve username from authentication
////            return jwtService.generateToken(username);
////        }
////        return "User not logged in";
////
////    }
////}
//@Service
//public class UserService {
//
//    @Autowired
//    private UserRepo repo;
//
//    @Autowired
//    private JWTService jwtService;
//
//    @Autowired
//    private AuthenticationManager authManager;
//
//    @Autowired
//    private BCryptPasswordEncoder encoder;
//
//    public Users register(Users user) {
//        user.setPassword(encoder.encode(user.getPassword()));
//        return repo.save(user);
//    }
//
//    public String verify(Users user) {
//        try {
//            Authentication authentication = authManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword())
//            );
//
//            if (authentication.isAuthenticated()) {
//                return jwtService.generateToken(user.getUsername());
//            }
//            return "Authentication failed";
//        } catch (BadCredentialsException e) {
//            throw new RuntimeException("Invalid username or password");
//        }
//    }
//}

package com.security.login.service;

import com.security.login.entity.Users;
import com.security.login.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo repo;

    @Autowired
    private JWTService jwtService;

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private BCryptPasswordEncoder encoder;

    public Users register(Users user) {
        user.setPassword(encoder.encode(user.getPassword()));
        return repo.save(user);
    }

    public String verify(Users user) {
        Authentication authentication = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword())
        );

        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(user.getUsername());
        }
        throw new RuntimeException("Authentication failed");
    }
}
