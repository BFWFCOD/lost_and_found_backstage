

package cn.bfcod.modules.oss.service;

import cn.bfcod.modules.oss.entity.SysOssEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import cn.bfcod.common.utils.PageUtils;

import java.util.Map;

/**
 * 文件上传
 *
 * @author Mark sunlightcs@gmail.com
 */
public interface SysOssService extends IService<SysOssEntity> {

	PageUtils queryPage(Map<String, Object> params);
}
