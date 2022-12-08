package cn.edu.hit.zxkt.wechat.service;

import cn.edu.hit.zxkt.model.wechat.Menu;
import cn.edu.hit.zxkt.vo.wechat.MenuVo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 订单明细 订单明细 服务类
 * </p>
 *
 * @author Tsukinai
 * @since 2022-12-08
 */
public interface MenuService extends IService<Menu> {

    //获取所有菜单
    List<MenuVo> findMenuInfo();

    //获取所有一级菜单
    List<Menu> findMenuOneInfo();

    //同步菜单方法
    void syncMenu();

    void removeMenu();
}
