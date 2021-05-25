package cn.bfcod.lost_and_found.dao;

import cn.bfcod.lost_and_found.entity.StudentEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 学生
 * 
 * @author bfcod
 * @email 2573948452@qq.com
 * @date 2021-03-05 23:55:20
 */
@Mapper
public interface StudentDao extends BaseMapper<StudentEntity> {
	
}
