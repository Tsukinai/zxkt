package cn.edu.hit.zxkt.user.service.impl;

import cn.edu.hit.zxkt.model.user.UserInfo;
import cn.edu.hit.zxkt.user.mapper.UserInfoMapper;
import cn.edu.hit.zxkt.user.service.UserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author Tsukinai
 * @since 2022-12-08
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {

}
