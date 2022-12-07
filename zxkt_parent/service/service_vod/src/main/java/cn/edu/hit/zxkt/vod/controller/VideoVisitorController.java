package cn.edu.hit.zxkt.vod.controller;


import cn.edu.hit.zxkt.result.Result;
import cn.edu.hit.zxkt.vod.service.VideoVisitorService;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p>
 * 视频来访者记录表 前端控制器
 * </p>
 *
 * @author Tsukinai
 * @since 2022-12-07
 */
@RestController
@RequestMapping("/admin/vod/videoVisitor")
@CrossOrigin
public class VideoVisitorController {

    @Autowired
    private VideoVisitorService videoVisitorService;

    //课程统计的接口
    @GetMapping("findCount/{courseId}/{startDate}/{endDate}")
    public Result findCount(@ApiParam("课程id") @PathVariable Long courseId, @ApiParam("开始时间") @PathVariable String startDate, @ApiParam("结束时间") @PathVariable String endDate){
        Map<String,Object> map=videoVisitorService.findCount(courseId,startDate,endDate);
        return Result.ok(map);
    }
}

