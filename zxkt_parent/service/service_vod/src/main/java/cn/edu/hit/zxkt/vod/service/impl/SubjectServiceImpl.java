package cn.edu.hit.zxkt.vod.service.impl;


import cn.edu.hit.zxkt.model.vod.Subject;
import cn.edu.hit.zxkt.vod.mapper.SubjectMapper;
import cn.edu.hit.zxkt.vod.service.SubjectService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 课程科目 服务实现类
 * </p>
 *
 * @author Tsukinai
 * @since 2022-12-06
 */
@Service
public class SubjectServiceImpl extends ServiceImpl<SubjectMapper, Subject> implements SubjectService {

    @Override
    public List<Subject> selectSubjectList(Long id) {
        QueryWrapper<Subject> wrapper = new QueryWrapper<>();
        wrapper.eq("parent_id", id);
        List<Subject> subjectList = baseMapper.selectList(wrapper);
        for (Subject subject : subjectList) {
            //获取subject的id
            Long subjectId = subject.getId();
            //查询
            boolean isChild = this.isChildren(subjectId);
            //封装到对象中
            subject.setHasChildren(isChild);
        }
        return subjectList;
    }

    //判断是否有下一层数据
    private boolean isChildren(Long subjectId) {
        QueryWrapper<Subject> wrapper = new QueryWrapper<>();
        wrapper.eq("parent_id", subjectId);
        int count = baseMapper.selectCount(wrapper);
        return count > 0;
    }
}
