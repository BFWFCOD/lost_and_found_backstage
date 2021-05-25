

package cn.bfcod.common.utils;

/**
 * Redis所有Keys
 *
 * @author Mark sunlightcs@gmail.com
 */
public class RedisKeys {

    public static String getSysConfigKey(String key){
        return "sys:config:" + key;
    }

    public static String getTokenKey(String key){
        return "backstage:token:" + key;
    }
}
