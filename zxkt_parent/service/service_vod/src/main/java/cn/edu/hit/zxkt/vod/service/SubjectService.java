package cn.edu.hit.zxkt.vod.service;


import cn.edu.hit.zxkt.model.vod.Subject;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 课程科目 服务类
 * </p>
 *
 * @author Tsukinai
 * @since 2022-12-06
 */
public interface SubjectService extends IService<Subject> {

    List<Subject> selectSubjectList(Long id);

}
