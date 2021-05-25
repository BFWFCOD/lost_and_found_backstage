package cn.bfcod.lost_and_found.controller;

import java.util.Arrays;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import cn.bfcod.common.utils.PageUtils;
import cn.bfcod.common.utils.R;
import cn.bfcod.lost_and_found.entity.LostthingsRelationEntity;
import cn.bfcod.lost_and_found.service.LostthingsRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * 失物认领关联
 *
 * @author bfcod
 * @email 2573948452@qq.com
 * @date 2021-03-05 23:55:19
 */
@RestController
@RequestMapping("lost_and_found/lostthingsrelation")
public class LostthingsRelationController {
    @Autowired
    private LostthingsRelationService lostthingsRelationService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("lost_and_found:lostthingsrelation:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = lostthingsRelationService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("lost_and_found:lostthingsrelation:info")
    public R info(@PathVariable("id") Long id){
		LostthingsRelationEntity lostthingsRelation = lostthingsRelationService.getById(id);

        return R.ok().put("lostthingsRelation", lostthingsRelation);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("lost_and_found:lostthingsrelation:save")
    public R save(@RequestBody LostthingsRelationEntity lostthingsRelation){
		lostthingsRelationService.save(lostthingsRelation);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("lost_and_found:lostthingsrelation:update")
    public R update(@RequestBody LostthingsRelationEntity lostthingsRelation){
		lostthingsRelationService.updateById(lostthingsRelation);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("lost_and_found:lostthingsrelation:delete")
    public R delete(@RequestBody Long[] ids){
		lostthingsRelationService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
