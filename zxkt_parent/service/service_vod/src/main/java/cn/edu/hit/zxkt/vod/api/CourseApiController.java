package cn.edu.hit.zxkt.vod.api;

import cn.edu.hit.zxkt.model.vod.Course;
import cn.edu.hit.zxkt.result.Result;
import cn.edu.hit.zxkt.vo.vod.CourseQueryVo;
import cn.edu.hit.zxkt.vo.vod.CourseVo;
import cn.edu.hit.zxkt.vod.service.CourseService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/api/user/wechat")
public class CourseApiController {

    @Autowired
    private CourseService courseService;

    //根据课程分类查询课程列表（分页）
    @ApiOperation("根据课程分类查询课程列表")
    @GetMapping("{subjectParentId}/{page}/{limit}")
    public Result findPageCourse(@ApiParam(value = "课程一级分类ID", required = true)
                                 @PathVariable Long subjectParentId,
                                 @ApiParam(name = "page",value = "当前页码",required = true)
                                 @PathVariable Long page,
                                 @ApiParam(name = "limit", value = "每页记录数",required = true)
                                 @PathVariable Long limit){
        //封装条件
        CourseQueryVo courseQueryVo = new CourseQueryVo();
        courseQueryVo.setSubjectParentId(subjectParentId);
        Page<Course> pageParam = new Page<>(page,limit);
        Map<String,Object> pageModel = courseService.findPage(pageParam,courseQueryVo);
        return Result.ok(pageModel);
    }

    //根据课程id查询课程详情
    @ApiOperation("根据课程id查询课程详情")
    @GetMapping("getInfo/{courseId}")
    public Result getInfo(@PathVariable Long courseId){
        Map<String,Object> map = courseService.getInfoById(courseId);
        return Result.ok(map);
    }

    @ApiOperation("根据关键字查询课程")
    @GetMapping("inner/findByKeyword/{keyword}")
    public List<Course> findByKeyword(
            @ApiParam(value = "关键字", required = true)
            @PathVariable String keyword){
        QueryWrapper<Course> wrapper = new QueryWrapper<>();
        wrapper.like("title",keyword);
        List<Course> list = courseService.list(wrapper);
        return list;
    }
}
