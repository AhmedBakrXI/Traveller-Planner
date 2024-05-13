/**
 * The MyUserDetailsService class implements the Spring Security UserDetailsService interface
 * to provide custom user details retrieval for authentication purposes.
 * It interacts with the UserRepository to fetch user details from the database.
 */


package com.traveller.planner.service;

import com.traveller.planner.model.UserModel;
import com.traveller.planner.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

     /**
     * Loads user details by the given username.
     *
     * @param username The username of the user whose details are to be loaded.
     * @return UserDetails object representing the user's details.
     * @throws UsernameNotFoundException if the user with the specified username is not found.
     */

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserModel> userModelOptional = userRepository.findByUsername(username);
        if (userModelOptional.isPresent()) {
            System.out.println(userModelOptional.get().getPassword());
            var user = userModelOptional.get();
            // Building UserDetails object using the retrieved user's details
            return User.builder()
                    .username(user.getUsername())
                    .password(user.getPassword())
                    .build();
        } else {
            throw new UsernameNotFoundException("User not found");
        }
    }
}
