package cn.bfcod.lost_and_found.service;

import cn.bfcod.common.utils.PageUtils;
import cn.bfcod.lost_and_found.entity.LostthingsRelationEntity;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * 失物认领关联
 *
 * @author bfcod
 * @email 2573948452@qq.com
 * @date 2021-03-05 23:55:19
 */
public interface LostthingsRelationService extends IService<LostthingsRelationEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

