package cn.edu.hit.zxkt.vod.service.impl;

import cn.edu.hit.zxkt.model.vod.Video;
import cn.edu.hit.zxkt.vod.mapper.VideoMapper;
import cn.edu.hit.zxkt.vod.service.VideoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 课程视频 服务实现类
 * </p>
 *
 * @author Tsukinai
 * @since 2022-12-06
 */
@Service
public class VideoServiceImpl extends ServiceImpl<VideoMapper, Video> implements VideoService {

}