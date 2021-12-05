package com.example.FinalProject.entity;

import lombok.*;

import javax.persistence.*;

@Table(name = "users")
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class User extends BaseEntity {
    @Column(name = "full_name")
    private String fullName;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @ManyToOne
    @JoinColumn(name = "user_role_id")
    private UserRole userRole;
}
