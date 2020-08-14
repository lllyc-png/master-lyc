package com.example.demo.controller;

import com.example.demo.controller.vo.ResponseVo;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class OneController {

    /*private User user = new User(1,"zs","wqfdqhfhfshq113123");
    @PostMapping("/getCode")
    public ResponseVo getCode(@RequestParam int id){
        if(user.getId()==id){
            System.out.println("出去了");
            return ResponseVo.ok(user.getCode());
        }

        return ResponseVo.ok(null);
    }

    @PostMapping("/showUser")
    public ResponseVo showUser(@RequestParam String code){
        System.out.println("进来了");
        return ResponseVo.ok("成功了");
    }*/

    @Autowired
    UserMapper userMapper;

    @PostMapping("/getCode")
    public ResponseVo getCode(@RequestParam String id){
        System.out.println(id);
        String code = userMapper.getCode(id);

        System.out.println(code);

        return ResponseVo.ok(code);
    }

    @PostMapping("/getId")
    public ResponseVo getId(@RequestParam String code){
        System.out.println(code);
        Integer id = userMapper.getId(code);
        System.out.println(id);
        return ResponseVo.ok(id);
    }
}
