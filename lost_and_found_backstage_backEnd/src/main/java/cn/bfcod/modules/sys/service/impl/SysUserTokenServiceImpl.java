

package cn.bfcod.modules.sys.service.impl;

import cn.bfcod.common.utils.R;
import cn.bfcod.modules.sys.dao.SysUserTokenDao;
import cn.bfcod.modules.sys.entity.SysUserTokenEntity;
import cn.bfcod.modules.sys.oauth2.TokenGenerator;
import cn.bfcod.modules.sys.redis.SysConfigRedis;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.bfcod.modules.sys.service.SysUserTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;


@Service("sysUserTokenService")
public class SysUserTokenServiceImpl extends ServiceImpl<SysUserTokenDao, SysUserTokenEntity> implements SysUserTokenService {
    @Autowired
    private SysConfigRedis sysConfigRedis;

    //12小时后过期
    private final static int EXPIRE = 3600 * 12;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public R createToken(long userId) {
        //生成一个token
        String token = TokenGenerator.generateValue();

        //当前时间
        Date now = new Date();
        //过期时间
        Date expireTime = new Date(now.getTime() + EXPIRE * 1000);

        //判断是否生成过token
        SysUserTokenEntity tokenEntity = this.getById(userId);
        if (tokenEntity == null) {
            tokenEntity = new SysUserTokenEntity();
            tokenEntity.setUserId(userId);
            tokenEntity.setToken(token);
            tokenEntity.setUpdateTime(now);
            tokenEntity.setExpireTime(expireTime);
            //保存token
            this.save(tokenEntity);
        } else {
            sysConfigRedis.deleteToken(tokenEntity);
            tokenEntity.setToken(token);
            tokenEntity.setUpdateTime(now);
            tokenEntity.setExpireTime(expireTime);
            //更新token
            this.updateById(tokenEntity);
        }

        sysConfigRedis.saveOrUpdateToken(tokenEntity);

        R r = R.ok().put("token", token).put("expire", EXPIRE);

        return r;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void logout(long userId) {
        sysConfigRedis.deleteToken(this.getById(userId));
        //生成一个token
        String token = TokenGenerator.generateValue();

        //修改token
        SysUserTokenEntity tokenEntity = new SysUserTokenEntity();
        tokenEntity.setUserId(userId);
        tokenEntity.setToken(token);
        this.updateById(tokenEntity);
    }
}
