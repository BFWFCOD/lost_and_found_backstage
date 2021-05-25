package cn.bfcod.lost_and_found.service;

import com.baomidou.mybatisplus.extension.service.IService;
import cn.bfcod.common.utils.PageUtils;
import cn.bfcod.lost_and_found.entity.UserxEntity;

import java.util.Map;

/**
 * 管理员
 *
 * @author bfcod
 * @email 2573948452@qq.com
 * @date 2021-03-05 23:55:19
 */
public interface UserxService extends IService<UserxEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

