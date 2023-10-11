package com.domnyus.todo.user;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name="_users")
public class UserModel 
{
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID Id;

    @Column(unique=true)
    private String username;

    
    private String password;
    private char role;

    @CreationTimestamp
    private LocalDateTime created;
}
