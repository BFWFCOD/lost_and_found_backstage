

package cn.bfcod.modules.sys.redis;


import cn.bfcod.common.utils.RedisKeys;
import cn.bfcod.common.utils.RedisUtils;
import cn.bfcod.modules.sys.entity.SysConfigEntity;
import cn.bfcod.modules.sys.entity.SysUserTokenEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 系统配置Redis
 *
 * @author Mark sunlightcs@gmail.com
 */
@Component
public class SysConfigRedis {
    @Autowired
    private RedisUtils redisUtils;

    public void saveOrUpdate(SysConfigEntity config) {
        if(config == null){
            return ;
        }
        String key = RedisKeys.getSysConfigKey(config.getParamKey());
        redisUtils.set(key, config);
    }

    public void delete(String configKey) {
        String key = RedisKeys.getSysConfigKey(configKey);
        redisUtils.delete(key);
    }

    public SysConfigEntity get(String configKey){
        String key = RedisKeys.getSysConfigKey(configKey);
        return redisUtils.get(key, SysConfigEntity.class);
    }

    public SysUserTokenEntity getToken(String Key){
        String key = RedisKeys.getTokenKey(Key);
        return redisUtils.get(key, SysUserTokenEntity.class);
    }

    public void saveOrUpdateToken(SysUserTokenEntity tokenEntity) {
        if(tokenEntity == null){
            return ;
        }
        String key = RedisKeys.getTokenKey(tokenEntity.getToken());
        redisUtils.set(key, tokenEntity);
    }

    public void deleteToken(SysUserTokenEntity tokenEntity) {
        String key = RedisKeys.getTokenKey(tokenEntity.getToken());
        redisUtils.delete(key);
    }
}
