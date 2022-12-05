package cn.edu.hit.zxkt.vod.controller;


import cn.edu.hit.zxkt.model.vod.Teacher;
import cn.edu.hit.zxkt.vod.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
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
@RestController
@RequestMapping("/admin/vod/teacher")
public class TeacherController {

    @Resource
    private TeacherService teacherService;

    //localhost:8301/admin/vod/teacher/findAll
    //1 查询所有讲师
    @GetMapping("findAll")
    public List<Teacher> findAllTeacher() {
        List<Teacher> list = teacherService.list();
        return list;
    }

    //2 逻辑删除讲师
    @DeleteMapping("remove/{id}")
    public boolean removeTeacher(@PathVariable Long id) {
        boolean isSuccess = teacherService.removeById(id);
        return isSuccess;
    }

}

