package cn.edu.hit.zxkt.activity.service;

import cn.edu.hit.zxkt.model.activity.CouponInfo;
import cn.edu.hit.zxkt.model.activity.CouponUse;
import cn.edu.hit.zxkt.vo.activity.CouponUseQueryVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 优惠券信息 服务类
 * </p>
 *
 * @author Tsukinai
 * @since 2022-12-07
 */
public interface CouponInfoService extends IService<CouponInfo> {

    IPage<CouponUse> selectCouponUsePage(Page<CouponUse> pageParam, CouponUseQueryVo couponUseQueryVo);
}
