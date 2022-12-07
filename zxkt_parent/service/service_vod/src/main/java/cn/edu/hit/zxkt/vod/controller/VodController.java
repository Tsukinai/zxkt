package cn.edu.hit.zxkt.vod.controller;

import cn.edu.hit.zxkt.result.Result;
import cn.edu.hit.zxkt.vod.service.VodService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "腾讯云点播")
@RestController
@RequestMapping("/admin/vod")
@CrossOrigin
public class VodController {

    @Autowired
    private VodService vodService;

    //上传视频接口
    @PostMapping("upload")
    public Result upload() {
        String fileId = vodService.updateVideo();
        return Result.ok(fileId);
    }

    //删除视频
    @DeleteMapping("remove/{fileId}")
    public Result remove(@PathVariable String fileId) {
        vodService.removeVideo(fileId);
        return Result.ok(null);
    }

}
