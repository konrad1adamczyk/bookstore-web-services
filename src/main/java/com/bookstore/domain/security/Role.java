package com.bookstore.domain.security;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class Role implements Serializable {
    private static final long serialVersionUID = 890245234L;

    @Id
    private int roleId;

    private String name;

    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<UserRole> uerRoles = new HashSet<>();

    public Role() {

    }

}
