package cn.edu.hit.zxkt.vod.controller;

import cn.edu.hit.zxkt.result.Result;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/admin/vod/user")
//@CrossOrigin//跨域
public class UserLoginController {

    //login
    @PostMapping("login")
    public Result login(){
        Map<String, Object> map = new HashMap<>();
        map.put("token","admin-token");
        return Result.ok(map);
    }

    @GetMapping("info")
    public Result info(){
        Map<String, Object> map = new HashMap<>();
        /*{"code":20000,
                "data":{"roles":["admin"],
                "introduction":"I am a super administrator",
                "avatar":"https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif",
                "name":"Super Admin"}}*/
        map.put("roles", "admin");
        map.put("introduction", "I am a super administrator");
        map.put("avatar", "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        map.put("name", "Super Admin");
        return Result.ok(map);
    }
}
