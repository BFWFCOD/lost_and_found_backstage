package cn.bfcod.lost_and_found.service.impl;

import cn.bfcod.common.utils.PageUtils;
import cn.bfcod.common.utils.Query;
import cn.bfcod.lost_and_found.dao.StudentDao;
import cn.bfcod.lost_and_found.entity.StudentEntity;
import cn.bfcod.lost_and_found.service.StudentService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


@Service("studentService")
public class StudentServiceImpl extends ServiceImpl<StudentDao, StudentEntity> implements StudentService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {

        //    获取key
        String key = (String) params.get("key");
        QueryWrapper<StudentEntity> queryWrapper = new QueryWrapper<>();
        if (!StringUtils.isEmpty(key)) {
            queryWrapper.eq("id", key).or().like("student_no", key).or().like("student_name", key).or().like("class_name", key).or().like("specialty_name", key).or().like("phone", key).or().like("qq", key).or().like("email", key);
        }
        IPage<StudentEntity> page = this.page(
                new Query<StudentEntity>().getPage(params), queryWrapper
        );

        return new PageUtils(page);
    }

}