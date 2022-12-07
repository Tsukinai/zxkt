package cn.edu.hit.zxkt.order.service;

import cn.edu.hit.zxkt.model.order.OrderInfo;
import cn.edu.hit.zxkt.vo.order.OrderInfoQueryVo;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 * 订单表 订单表 服务类
 * </p>
 *
 * @author Tsukinai
 * @since 2022-12-07
 */
public interface OrderInfoService extends IService<OrderInfo> {

    Map<String, Object> selectOrderInfoPage(Page<OrderInfo> pageParam, OrderInfoQueryVo orderInfoQueryVo);
}
