package cn.edu.hit.zxkt.vod.controller;


import cn.edu.hit.zxkt.result.Result;
import cn.edu.hit.zxkt.vo.vod.ChapterVo;
import cn.edu.hit.zxkt.vod.service.ChapterService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 课程 前端控制器
 * </p>
 *
 * @author Tsukinai
 * @since 2022-12-06
 */
@RestController
@RequestMapping(value = "/admin/vod/chapter")
@CrossOrigin
public class ChapterController {

    @Autowired
    private ChapterService chapterService;

    //1 大纲列表
    @ApiOperation("大纲列表")
    @GetMapping("getNestedTreeList/{courseId}")
    public Result getTreeList(@PathVariable Long courseId){
        List<ChapterVo> list=chapterService.getTreeList(courseId);
        return Result.ok(list);
    }

    //2 添加章节


    //3 修改-根据id查询

    //4 修改-最终实现
}

