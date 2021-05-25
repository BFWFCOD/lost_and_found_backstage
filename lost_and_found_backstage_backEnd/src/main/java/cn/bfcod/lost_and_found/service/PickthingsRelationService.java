package cn.bfcod.lost_and_found.service;

import cn.bfcod.common.utils.PageUtils;
import com.baomidou.mybatisplus.extension.service.IService;
import cn.bfcod.lost_and_found.entity.PickthingsRelationEntity;

import java.util.Map;

/**
 * 寻到物品关联
 *
 * @author bfcod
 * @email 2573948452@qq.com
 * @date 2021-03-05 23:55:19
 */
public interface PickthingsRelationService extends IService<PickthingsRelationEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

