package cn.edu.hit.zxkt.vod.service.impl;

import cn.edu.hit.zxkt.model.vod.Course;
import cn.edu.hit.zxkt.model.vod.Subject;
import cn.edu.hit.zxkt.model.vod.Teacher;
import cn.edu.hit.zxkt.vo.vod.CourseQueryVo;
import cn.edu.hit.zxkt.vod.mapper.CourseMapper;
import cn.edu.hit.zxkt.vod.service.CourseService;
import cn.edu.hit.zxkt.vod.service.SubjectService;
import cn.edu.hit.zxkt.vod.service.TeacherService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 课程 服务实现类
 * </p>
 *
 * @author Tsukinai
 * @since 2022-12-06
 */
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements CourseService {

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private SubjectService subjectService;
    //点播课程列表
    @Override
    public Map<String, Object> findPageCourse(Page<Course> pageParam, CourseQueryVo courseQueryVo) {
        //获取条件值
        String title = courseQueryVo.getTitle();
        Long subjectId = courseQueryVo.getSubjectId();
        Long subjectParentId = courseQueryVo.getSubjectParentId();
        Long teacherId = courseQueryVo.getTeacherId();
        //判断条件为空,封装条件
        QueryWrapper<Course> wrapper = new QueryWrapper<>();
        if (!StringUtils.isEmpty(title)) {
            wrapper.like("title", title);
        }
        if (!StringUtils.isEmpty(subjectId)) {
            wrapper.eq("subject_id", subjectId);
        }
        if (!StringUtils.isEmpty(subjectParentId)) {
            wrapper.eq("subject_parent_id", subjectParentId);
        }
        if (!StringUtils.isEmpty(teacherId)) {
            wrapper.eq("teacher_id", teacherId);
        }

        //调用方法实现条件查询分页
        Page<Course> pages = baseMapper.selectPage(pageParam, wrapper);
        long totalCount = pages.getTotal();
        long totalPage = pages.getPages();
        List<Course> list = pages.getRecords();

        //讲师id 课程id
        //获取id对应名称进行封装
        list.stream().forEach(item -> {
            this.getNameById(item);
        });

        //封装数据
        Map<String, Object> map = new HashMap<>();
        map.put("totalCount", totalCount);
        map.put("totalPage", totalPage);
        map.put("records", list);
        return map;
    }

    //获取这些id对应名称进行封装,最终显示
    private Course getNameById(Course course) {
        //根据讲师id获取讲师名称
        Teacher teacher = teacherService.getById(course.getTeacherId());
        if(teacher!=null){
            String name = teacher.getName();
            course.getParam().put("teacherName",name);
        }

        //根据课程分类id获取课程分类名称
        Subject subjectOne=subjectService.getById(course.getSubjectParentId());
        if(subjectOne!=null){
            course.getParam().put("subjectParentTitle",subjectOne.getTitle());
        }
        Subject subjectTwo=subjectService.getById(course.getSubjectParentId());
        if(subjectTwo!=null){
            course.getParam().put("subjectParentTitle",subjectTwo.getTitle());
        }
        return course;
    }
}