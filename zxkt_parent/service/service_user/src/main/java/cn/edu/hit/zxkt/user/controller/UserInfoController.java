package cn.edu.hit.zxkt.user.controller;


import cn.edu.hit.zxkt.model.user.UserInfo;
import cn.edu.hit.zxkt.user.service.UserInfoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author Tsukinai
 * @since 2022-12-08
 */
@RestController
@RequestMapping(value = "/admin/user/userInfo")
public class UserInfoController {

    @Autowired
    UserInfoService userInfoService;

    @ApiOperation(value = "获取")
    @GetMapping("inner/getById/{id}")
    public UserInfo getById(@PathVariable Long id) {
        return userInfoService.getById(id);
    }
}

