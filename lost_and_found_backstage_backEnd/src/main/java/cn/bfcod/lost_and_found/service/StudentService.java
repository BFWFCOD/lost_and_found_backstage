package cn.bfcod.lost_and_found.service;

import cn.bfcod.common.utils.PageUtils;
import cn.bfcod.lost_and_found.entity.StudentEntity;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * 学生
 *
 * @author bfcod
 * @email 2573948452@qq.com
 * @date 2021-03-05 23:55:20
 */
public interface StudentService extends IService<StudentEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

