package com.example.userservice.jpa;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Getter
@Setter
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(nullable = false, length = 50, unique = false)
    private String email;

    @Column(nullable = false, length = 50, unique = false)
    private String pwd;

    @Column(nullable = false, length = 50, unique = false)
    private String name;

    @Column(nullable = false, unique = false)
    private String userId;

    @Column(nullable = false, unique = false)
    private String encryptedPwd;
}
