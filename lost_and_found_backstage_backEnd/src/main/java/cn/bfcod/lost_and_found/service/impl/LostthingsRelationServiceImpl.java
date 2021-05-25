package cn.bfcod.lost_and_found.service.impl;

import cn.bfcod.common.utils.PageUtils;
import cn.bfcod.common.utils.Query;
import cn.bfcod.lost_and_found.dao.LostthingsRelationDao;
import cn.bfcod.lost_and_found.entity.LostthingsRelationEntity;
import cn.bfcod.lost_and_found.service.LostthingsRelationService;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


@Service("lostthingsRelationService")
public class LostthingsRelationServiceImpl extends ServiceImpl<LostthingsRelationDao, LostthingsRelationEntity> implements LostthingsRelationService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<LostthingsRelationEntity> page = this.page(
                new Query<LostthingsRelationEntity>().getPage(params),
                new QueryWrapper<LostthingsRelationEntity>()
        );

        return new PageUtils(page);
    }

}