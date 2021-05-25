package cn.bfcod.lost_and_found.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.bfcod.common.utils.PageUtils;
import cn.bfcod.common.utils.Query;

import cn.bfcod.lost_and_found.dao.UserxDao;
import cn.bfcod.lost_and_found.entity.UserxEntity;
import cn.bfcod.lost_and_found.service.UserxService;


@Service("userxService")
public class UserxServiceImpl extends ServiceImpl<UserxDao, UserxEntity> implements UserxService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<UserxEntity> page = this.page(
                new Query<UserxEntity>().getPage(params),
                new QueryWrapper<UserxEntity>()
        );

        return new PageUtils(page);
    }

}