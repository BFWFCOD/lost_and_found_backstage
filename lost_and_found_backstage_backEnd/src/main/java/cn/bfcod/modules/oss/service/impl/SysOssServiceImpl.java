

package cn.bfcod.modules.oss.service.impl;

import cn.bfcod.modules.oss.dao.SysOssDao;
import cn.bfcod.modules.oss.entity.SysOssEntity;
import cn.bfcod.modules.oss.service.SysOssService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.bfcod.common.utils.PageUtils;
import cn.bfcod.common.utils.Query;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("sysOssService")
public class SysOssServiceImpl extends ServiceImpl<SysOssDao, SysOssEntity> implements SysOssService {

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		IPage<SysOssEntity> page = this.page(
			new Query<SysOssEntity>().getPage(params)
		);

		return new PageUtils(page);
	}
	
}
