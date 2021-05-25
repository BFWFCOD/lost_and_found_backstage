

package cn.bfcod.modules.sys.service;


import cn.bfcod.common.utils.PageUtils;
import cn.bfcod.modules.sys.entity.SysLogEntity;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;


/**
 * 系统日志
 *
 * @author Mark sunlightcs@gmail.com
 */
public interface SysLogService extends IService<SysLogEntity> {

    PageUtils queryPage(Map<String, Object> params);

}
