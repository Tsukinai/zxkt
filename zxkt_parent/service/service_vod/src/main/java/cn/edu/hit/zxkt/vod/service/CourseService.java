package cn.edu.hit.zxkt.vod.service;

import cn.edu.hit.zxkt.model.vod.Course;
import cn.edu.hit.zxkt.vo.vod.CourseFormVo;
import cn.edu.hit.zxkt.vo.vod.CoursePublishVo;
import cn.edu.hit.zxkt.vo.vod.CourseQueryVo;
import cn.edu.hit.zxkt.vo.vod.CourseVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author Tsukinai
 * @since 2022-12-06
 */
public interface CourseService extends IService<Course> {

    Map<String, Object> findPageCourse(Page<Course> pageParam, CourseQueryVo courseQueryVo);

    Long saveCourseInfo(CourseFormVo courseFormVo);

    CourseFormVo getCourseInfoById(Long id);

    void updateCourseId(CourseFormVo courseFormVo);

    CoursePublishVo getCoursePublishVo(Long id);

    //课程最终发布
    void publishCourse(Long id);

    void removeCourseId(Long id);

    //根据课程分类查询课程列表
    Map<String,Object> findPage(Page<Course> pageParam, CourseQueryVo courseQueryVo);

    //根据课程id查询课程详情
    Map<String, Object> getInfoById(Long courseId);
}
