package cn.edu.hit.zxkt.order.service.impl;

import cn.edu.hit.zxkt.model.order.OrderInfo;
import cn.edu.hit.zxkt.order.mapper.OrderInfoMapper;
import cn.edu.hit.zxkt.order.service.OrderInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单表 订单表 服务实现类
 * </p>
 *
 * @author Tsukinai
 * @since 2022-12-07
 */
@Service
public class OrderInfoServiceImpl extends ServiceImpl<OrderInfoMapper, OrderInfo> implements OrderInfoService {

}
