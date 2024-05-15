/**
 * This interface represents a repository for managing users.
 * It extends JpaRepository for CRUD operations on UserModel entities.
 */
package com.traveller.planner.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.traveller.planner.model.UserModel;

public interface UserRepository extends JpaRepository<UserModel, String> {

    /**
     * Retrieves a user based on the specified username.
     *
     * @param userName The username of the user to retrieve.
     * @return An Optional containing the UserModel object representing the user with the specified username, or empty if not found.
     */
    Optional<UserModel> findByUsername(String userName);
}
