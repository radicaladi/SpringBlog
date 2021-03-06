package com.codeup.springblog.repositories;

import com.codeup.springblog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User getUserById(long id);
    User findByUsername(String username);
}
