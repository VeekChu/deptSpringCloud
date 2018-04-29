package com.snail.springboot.user.service;

import com.snail.springboot.user.dao.UserDao;
import com.snail.springboot.user.entity.User;
import com.snail.springboot.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    /**
     * 用户名称模糊查询用户
     * @param userName
     * @return
     */
    public User findUserByName(String userName){
        return userDao.findByUsername(userName);
    }

    /**
     * 根据密码查询用户
     * @param password
     * @return
     */
    public User findByPassword(String password){
        return userDao.findByPassword(password);
    }

    /**
     * 根据密码和id查询用户
     * @param password
     * @param id
     * @return
     */
    public User findByPasswordAndId(String password,String id){
        return userDao.findByPasswordAndId(password,id);
    }

    /**
     * 查询全部用户
     * @return
     */
    public List<User> findAll(){
        return userDao.findAll();
    }

    /**
     * 保存用户
     * @param user
     * @return
     */
    public User saveUser(User user){
        user.setId(CommonUtil.getUUID());
        return userDao.save(user);
    }

    /**
     * id查询用户
     * @param id
     * @return
     */
    public User findUserById(String id){
        return userDao.findById(id).get();
    }

    /**
     * 更新用户信息
     * @param user
     * @return
     */
    public User updateUser(User user){
        return userDao.saveAndFlush(user);
    }

    /**
     * 删除用户
     * @param id
     */
    public void deleteUser(String id){
        userDao.deleteById(id);
    }
}
