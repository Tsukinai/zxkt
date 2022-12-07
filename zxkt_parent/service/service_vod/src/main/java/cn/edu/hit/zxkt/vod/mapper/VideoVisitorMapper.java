package cn.edu.hit.zxkt.vod.mapper;

import cn.edu.hit.zxkt.model.vod.VideoVisitor;
import cn.edu.hit.zxkt.vo.vod.VideoVisitorCountVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 视频来访者记录表 Mapper 接口
 * </p>
 *
 * @author Tsukinai
 * @since 2022-12-07
 */
public interface VideoVisitorMapper extends BaseMapper<VideoVisitor> {

    List<VideoVisitorCountVo> findCount(@Param("courseId") Long courseId, @Param("startDate") String startDate, @Param("endDate") String endDate);
}
