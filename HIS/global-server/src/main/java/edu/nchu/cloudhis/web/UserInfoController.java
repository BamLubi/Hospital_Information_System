package edu.nchu.cloudhis.web;

import edu.nchu.cloudhis.model.UserInfo;
import edu.nchu.cloudhis.service.UserInfoService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @PostMapping("")
    public List<UserInfo> findList(@RequestBody UserInfo userInfo){
        return userInfoService.findList(userInfo);
    }

    // 查找所有用户信息
    @GetMapping("/all")
    public List<UserInfo> findAll(){
        return userInfoService.findAll();
    }
}
