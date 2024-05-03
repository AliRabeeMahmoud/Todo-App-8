package com.ali.java.todo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
@Data
public class User  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String userName;

    private String password;

    private String role;

    private String ageType;  //child, teenager, adult, old

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Category> category;
}
