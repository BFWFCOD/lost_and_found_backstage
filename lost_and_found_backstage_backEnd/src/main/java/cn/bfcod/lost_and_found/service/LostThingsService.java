package cn.bfcod.lost_and_found.service;

import cn.bfcod.common.utils.PageUtils;
import cn.bfcod.lost_and_found.entity.LostThingsEntity;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * 丢失物品
 *
 * @author bfcod
 * @email 2573948452@qq.com
 * @date 2021-03-05 23:55:19
 */
public interface LostThingsService extends IService<LostThingsEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

