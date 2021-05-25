package cn.bfcod.lost_and_found.service.impl;

import cn.bfcod.common.utils.PageUtils;
import cn.bfcod.common.utils.Query;
import cn.bfcod.lost_and_found.dao.PickthingsRelationDao;
import cn.bfcod.lost_and_found.entity.PickthingsRelationEntity;
import cn.bfcod.lost_and_found.service.PickthingsRelationService;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


@Service("pickthingsRelationService")
public class PickthingsRelationServiceImpl extends ServiceImpl<PickthingsRelationDao, PickthingsRelationEntity> implements PickthingsRelationService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<PickthingsRelationEntity> page = this.page(
                new Query<PickthingsRelationEntity>().getPage(params),
                new QueryWrapper<PickthingsRelationEntity>()
        );

        return new PageUtils(page);
    }

}