package cn.edu.hit.zxkt.vod.controller;


import cn.edu.hit.zxkt.model.vod.Course;
import cn.edu.hit.zxkt.result.Result;
import cn.edu.hit.zxkt.vo.vod.CourseFormVo;
import cn.edu.hit.zxkt.vo.vod.CourseQueryVo;
import cn.edu.hit.zxkt.vod.service.CourseService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.Map;

/**
 * <p>
 * 课程 前端控制器
 * </p>
 *
 * @author Tsukinai
 * @since 2022-12-06
 */
@RestController
@RequestMapping(value = "/admin/vod/course")
@CrossOrigin
public class CourseController {
    @Autowired
    private CourseService courseService;

    //添加课程基本信息
    @ApiOperation("添加课程基本信息")
    @PostMapping("save")
    public Result save(@RequestBody CourseFormVo courseFormVo) {
        Long courseId = courseService.saveCourseInfo(courseFormVo);
        return Result.ok(courseId);
    }

    //点播课程列表
    @ApiOperation("点播课程列表")
    @GetMapping("{page}/{limit}")
    public Result courseList(@PathVariable Long page, @PathVariable Long limit, CourseQueryVo courseQueryVo) {
        Page<Course> pageParam = new Page<>(page, limit);
        Map<String, Object> map = courseService.findPageCourse(pageParam, courseQueryVo);
        return Result.ok(map);
    }

}

