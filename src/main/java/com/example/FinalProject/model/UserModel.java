package com.example.FinalProject.model;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class UserModel {
    private String fullName;
    private String login;
    private String password;
    private Long userRoleId;
}
