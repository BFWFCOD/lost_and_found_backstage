package cn.bfcod.lost_and_found.dao;

import cn.bfcod.lost_and_found.entity.PickThingsEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 寻到物品
 * 
 * @author bfcod
 * @email 2573948452@qq.com
 * @date 2021-03-05 23:55:20
 */
@Mapper
public interface PickThingsDao extends BaseMapper<PickThingsEntity> {
	
}
