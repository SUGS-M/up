package com.myy.up.Controller;

import com.myy.up.Service.UsersService;
import com.myy.up.Vo.UsersVo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("user/")
public class UserController {

    private final UsersService usersService;
    public UserController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("test")
    public ResponseEntity<List<UsersVo>> test(){
        return ResponseEntity.ok(usersService.findBy());
    }
}
