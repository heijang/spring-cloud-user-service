package com.example.userservice.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestUser {
    private String email;
    private String name;
    private String pwd;
}
