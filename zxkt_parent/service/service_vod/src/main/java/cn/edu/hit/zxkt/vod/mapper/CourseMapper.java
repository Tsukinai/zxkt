package cn.edu.hit.zxkt.vod.mapper;

import cn.edu.hit.zxkt.model.vod.Course;
import cn.edu.hit.zxkt.vo.vod.CoursePublishVo;
import cn.edu.hit.zxkt.vo.vod.CourseVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 课程 Mapper 接口
 * </p>
 *
 * @author Tsukinai
 * @since 2022-12-06
 */
public interface CourseMapper extends BaseMapper<Course> {

    CoursePublishVo selectCoursePublishVoById(Long id);

    CourseVo selectCourseVoById(Long courseId);
}
