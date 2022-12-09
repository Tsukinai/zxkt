package cn.edu.hit.zxkt.vod.service;

import java.util.Map;

public interface VodService {
    String updateVideo(String url);

    void removeVideo(String fileId);

    //Map<String, Object> getPlayAuth(Long courseId, Long videoId);
}
