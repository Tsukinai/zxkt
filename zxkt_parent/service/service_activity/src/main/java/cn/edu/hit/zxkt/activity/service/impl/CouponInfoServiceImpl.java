package cn.edu.hit.zxkt.activity.service.impl;

import cn.edu.hit.zxkt.activity.mapper.CouponInfoMapper;
import cn.edu.hit.zxkt.activity.service.CouponInfoService;
import cn.edu.hit.zxkt.activity.service.CouponUseService;
import cn.edu.hit.zxkt.client.user.UserInfoFeignClient;
import cn.edu.hit.zxkt.model.activity.CouponInfo;
import cn.edu.hit.zxkt.model.activity.CouponUse;
import cn.edu.hit.zxkt.model.user.UserInfo;
import cn.edu.hit.zxkt.vo.activity.CouponUseQueryVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * <p>
 * 优惠券信息 服务实现类
 * </p>
 *
 * @author Tsukinai
 * @since 2022-12-07
 */
@Service
public class CouponInfoServiceImpl extends ServiceImpl<CouponInfoMapper, CouponInfo> implements CouponInfoService {

    @Autowired
    private CouponUseService couponUseService;

    @Autowired
    private UserInfoFeignClient userInfoFeignClient;

    @Override
    public IPage<CouponUse> selectCouponUsePage(Page<CouponUse> pageParam, CouponUseQueryVo couponUseQueryVo) {
        //获取条件
        Long couponId = couponUseQueryVo.getCouponId();
        String couponStatus = couponUseQueryVo.getCouponStatus();
        String getTimeBegin = couponUseQueryVo.getGetTimeBegin();
        String getTimeEnd = couponUseQueryVo.getGetTimeEnd();

        QueryWrapper<CouponUse> wrapper = new QueryWrapper<>();
        if (!StringUtils.isEmpty(couponId)) {
            wrapper.eq("coupon_id", couponId);
        }
        if (!StringUtils.isEmpty(couponStatus)) {
            wrapper.eq("coupon_status", couponStatus);
        }
        if (!StringUtils.isEmpty(getTimeBegin)) {
            wrapper.ge("get_time", getTimeBegin);
        }
        if (!StringUtils.isEmpty(getTimeEnd)) {
            wrapper.le("get_time", getTimeEnd);
        }
        //调用方法查询
        IPage<CouponUse> page = couponUseService.page(pageParam, wrapper);
        //封装用户昵称和手机号
        List<CouponUse> couponUseList = page.getRecords();
        couponUseList.stream().forEach(item -> {
            this.getUserInfoById(item);
        });
        return page;
    }

    private CouponUse getUserInfoById(CouponUse couponUse) {
        Long userId = couponUse.getUserId();
        if (!StringUtils.isEmpty(userId)) {
            UserInfo userInfo = userInfoFeignClient.getById(userId);
            if (userInfo != null) {
                couponUse.getParam().put("nickName", userInfo.getNickName());
                couponUse.getParam().put("phone", userInfo.getPhone());
            }
        }
        return couponUse;
    }
}
