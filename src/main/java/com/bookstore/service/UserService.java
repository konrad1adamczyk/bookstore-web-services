package com.bookstore.service;

import com.bookstore.domain.User;
import com.bookstore.domain.security.UserRole;

import java.util.Set;

public interface UserService {
    User createUser(User user, Set<UserRole> userRoles);

    User findByUsername(String username);

    User findByEmail(String userEmail);

    User save(User user);

    User findById(Long id);
}
