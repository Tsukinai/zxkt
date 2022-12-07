package cn.edu.hit.zxkt.vod.controller;

import cn.edu.hit.zxkt.exception.ZxktException;
import cn.edu.hit.zxkt.result.Result;
import cn.edu.hit.zxkt.vod.service.VodService;
import cn.edu.hit.zxkt.vod.utils.ConstantPropertiesUtil;
import cn.edu.hit.zxkt.vod.utils.Signature;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@Api(tags = "腾讯云点播")
@RestController
@RequestMapping("/admin/vod")
@CrossOrigin
public class VodController {

    @Autowired
    private VodService vodService;

    //返回客户端上传视频签名
    @GetMapping("sign")
    public Result sign() {
        Signature sign = new Signature();
        // 设置 App 的云 API 密钥
        sign.setSecretId(ConstantPropertiesUtil.ACCESS_KEY_ID);
        sign.setSecretKey(ConstantPropertiesUtil.ACCESS_KEY_SECRET);
        sign.setCurrentTime(System.currentTimeMillis() / 1000);
        sign.setRandom(new Random().nextInt(java.lang.Integer.MAX_VALUE));
        sign.setSignValidDuration(3600 * 24 * 2); // 签名有效期：2天
        try {
            String signature = sign.getUploadSignature();
            System.out.println("signature : " + signature);
            return Result.ok(signature);
        } catch (Exception e) {
            System.out.print("获取签名失败");
            e.printStackTrace();
            throw new ZxktException(20001, "获取签名失败");
        }
    }

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
