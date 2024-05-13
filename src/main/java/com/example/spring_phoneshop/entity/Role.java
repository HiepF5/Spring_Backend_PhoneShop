package com.example.spring_phoneshop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "roleId", nullable = false, unique = true)
    private Integer roleId;
    @Column(name = "roleName", nullable = false)
    private String roleName;

//    @ManyToMany(mappedBy = "roles")
//    private Set<User> user;
}

