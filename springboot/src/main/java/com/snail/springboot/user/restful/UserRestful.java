package com.snail.springboot.user.restful;

import com.snail.springboot.user.entity.User;
import com.snail.springboot.user.service.UserService;
import com.snail.springboot.util.CommonUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

@Api("用户Api")
@RestController
@RequestMapping("/user")
public class UserRestful {
    @Autowired
    private UserService userService;

    @RequestMapping("/{userName}")
    public User findByUserName(@PathVariable String userName){
        return userService.findUserByName(userName);
    }

    @ApiOperation(value = "用户列表",notes = "用户列表")
    @RequestMapping(value = "/findAll",method = RequestMethod.GET)
    public List<User> findAll(){
        List<User> users = userService.findAll();
        return users;
    }

    @ApiOperation(value = "创建用户",notes = "创建用户")
    @RequestMapping(value = "/saveUser",method = RequestMethod.POST)
    public User saveUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    @ApiOperation(value = "获取用户信息",notes = "获取用户信息")
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public User findById(@PathVariable String id){
        return userService.findUserById(id);
    }

    @ApiOperation(value = "更新信息",notes = "根据url的id更新指定用户信息")
    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public User updateUser(@PathVariable String id,@RequestBody User user){
        User user1 = new User();
        user1.setId(id);
        user1.setPassword(user.getPassword());
        user1.setUsername(user.getUsername());
        return userService.updateUser(user);
    }

    @ApiOperation(value = "删除用户",notes = "根据url的id删除指定用户")
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable String id){
        userService.deleteUser(id);
        return "success";
    }

    @ApiIgnore
    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    public String jsonTest(){
        return "hi you";
    }

    @ApiOperation(value = "静态创建用户",notes = "静态创建用户")
    @RequestMapping(value = "/saveUserStatis",method = RequestMethod.GET)
    public String saveUserStatic(){
        User user = new User();
        user.setUsername(CommonUtil.getUUID());
        user.setPassword(CommonUtil.getUUID());
        user.setId(CommonUtil.getUUID());
        userService.saveUser(user);
        return "success";
    }
}
