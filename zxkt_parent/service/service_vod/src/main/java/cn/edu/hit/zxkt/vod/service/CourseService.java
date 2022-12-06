package cn.edu.hit.zxkt.vod.service;

import cn.edu.hit.zxkt.model.vod.Course;
import cn.edu.hit.zxkt.vo.vod.CourseFormVo;
import cn.edu.hit.zxkt.vo.vod.CourseQueryVo;
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

    void updateCourse(CourseFormVo courseFormVo);
}
