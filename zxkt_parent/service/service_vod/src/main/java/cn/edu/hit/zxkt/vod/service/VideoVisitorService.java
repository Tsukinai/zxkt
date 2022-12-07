package cn.edu.hit.zxkt.vod.service;

import cn.edu.hit.zxkt.model.vod.VideoVisitor;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 * 视频来访者记录表 服务类
 * </p>
 *
 * @author Tsukinai
 * @since 2022-12-07
 */
public interface VideoVisitorService extends IService<VideoVisitor> {

    Map<String, Object> findCount(Long courseId, String startDate, String endDate);
}
