package cn.edu.hit.zxkt.vod.controller;


import cn.edu.hit.zxkt.model.vod.Teacher;
import cn.edu.hit.zxkt.result.Result;
import cn.edu.hit.zxkt.vod.service.TeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author Tsukinai
 * @since 2022-12-04
 */
@Api(tags = "讲师管理接口")
@RestController
@RequestMapping("/admin/vod/teacher")
public class TeacherController {

    @Resource
    private TeacherService teacherService;

    //localhost:8301/admin/vod/teacher/findAll
    //1 查询所有讲师
    @ApiOperation("查询所有讲师")
    @GetMapping("findAll")
    public Result findAllTeacher() {
        List<Teacher> list = teacherService.list();
        return Result.ok(list);
    }

    //2 逻辑删除讲师
    @ApiOperation("逻辑删除讲师")
    @DeleteMapping("remove/{id}")
    public Result removeTeacher(@ApiParam(name = "id", value = "ID", required = true) @PathVariable String id) {
        boolean isSuccess = teacherService.removeById(id);
        if(isSuccess){
            return Result.ok(null);
        }else {
            return Result.fail(null);
        }
    }

}



