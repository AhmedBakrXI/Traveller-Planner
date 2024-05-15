/**
 * This class represents a user entity in the application.
 */
package com.traveller.planner.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
@Entity
public class UserModel {

    /**
     * The unique identifier (username) of the user.
     */
    @Id
    private String username;

    /**
     * The password of the user.
     */
    @Column
    private String password;

    /**
     * The city where the user resides.
     */
    @Column
    private String city;
}
