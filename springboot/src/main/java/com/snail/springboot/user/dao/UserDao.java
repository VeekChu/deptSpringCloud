package com.snail.springboot.user.dao;

import com.snail.springboot.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserDao extends JpaRepository<User,String>{
    public User findByUsername(String username);

    public User findByPasswordAndId(String password,String id);

    public User findByPassword(String password);
}
