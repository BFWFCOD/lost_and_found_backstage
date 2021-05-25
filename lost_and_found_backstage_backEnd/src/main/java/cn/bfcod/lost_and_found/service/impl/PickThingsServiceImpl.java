package cn.bfcod.lost_and_found.service.impl;

import cn.bfcod.common.utils.PageUtils;
import cn.bfcod.common.utils.Query;
import cn.bfcod.lost_and_found.dao.PickThingsDao;
import cn.bfcod.lost_and_found.entity.PickThingsEntity;
import cn.bfcod.lost_and_found.service.PickThingsService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


@Service("pickThingsService")
public class PickThingsServiceImpl extends ServiceImpl<PickThingsDao, PickThingsEntity> implements PickThingsService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        //    获取key
        String key = (String) params.get("key");
        QueryWrapper<PickThingsEntity> queryWrapper = new QueryWrapper<>();
        if (!StringUtils.isEmpty(key)) {
            queryWrapper.eq("id", key).or().like("things_name", key).or().like("pick_place", key).or().like("things_type", key).or().like("things_des", key).or().like("storage_place", key).or().like("student_name", key);
        }
        IPage<PickThingsEntity> page = this.page(
                new Query<PickThingsEntity>().getPage(params), queryWrapper
        );
//        System.out.println(" getClass: " + page.getClass()
//                + " getPages: " + page.getPages()
//                + " getCurrent: " + page.getCurrent()
//                + " getSize: " + page.getSize()
//                + " getTotal: " + page.getTotal()
//                + " getRecords.size: " + page.getRecords().size());

        return new PageUtils(page);
    }

}