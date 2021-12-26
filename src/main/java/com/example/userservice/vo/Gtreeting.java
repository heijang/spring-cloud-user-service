package com.example.userservice.vo;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class Gtreeting {
    @Value("${greeting.message}")
    private String message;
}
