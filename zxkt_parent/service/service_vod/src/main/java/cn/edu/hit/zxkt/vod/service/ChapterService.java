package cn.edu.hit.zxkt.vod.service;

import cn.edu.hit.zxkt.model.vod.Chapter;
import cn.edu.hit.zxkt.vo.vod.ChapterVo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author Tsukinai
 * @since 2022-12-06
 */
public interface ChapterService extends IService<Chapter> {

    List<ChapterVo> getTreeList(Long courseId);

    void removeChapterByCourseId(Long id);
}
