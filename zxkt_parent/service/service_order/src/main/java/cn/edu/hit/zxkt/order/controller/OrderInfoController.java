package cn.edu.hit.zxkt.order.controller;


import cn.edu.hit.zxkt.model.order.OrderInfo;
import cn.edu.hit.zxkt.order.service.OrderInfoService;
import cn.edu.hit.zxkt.result.Result;
import cn.edu.hit.zxkt.vo.order.OrderInfoQueryVo;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p>
 * 订单表 订单表 前端控制器
 * </p>
 *
 * @author Tsukinai
 * @since 2022-12-07
 */
@RestController
@RequestMapping(value = "/admin/order/orderInfo")
public class OrderInfoController {

    @Autowired
    private OrderInfoService orderInfoService;

    //订单列表
    @GetMapping("{page}/{limit}")
    public Result listOrder(@PathVariable Long page, @PathVariable Long limit, OrderInfoQueryVo orderInfoQueryVo) {
        //创建page对象
        Page<OrderInfo> pageParam = new Page<>(page, limit);
        Map<String, Object> map = orderInfoService.selectOrderInfoPage(pageParam, orderInfoQueryVo);
        return Result.ok(map);
    }
}

