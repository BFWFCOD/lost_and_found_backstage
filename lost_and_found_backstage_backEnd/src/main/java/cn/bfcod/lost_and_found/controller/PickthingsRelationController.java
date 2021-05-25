package cn.bfcod.lost_and_found.controller;

import java.util.Arrays;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import cn.bfcod.common.utils.PageUtils;
import cn.bfcod.common.utils.R;
import cn.bfcod.lost_and_found.entity.PickthingsRelationEntity;
import cn.bfcod.lost_and_found.service.PickthingsRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * 寻到物品关联
 *
 * @author bfcod
 * @email 2573948452@qq.com
 * @date 2021-03-05 23:55:19
 */
@RestController
@RequestMapping("lost_and_found/pickthingsrelation")
public class PickthingsRelationController {
    @Autowired
    private PickthingsRelationService pickthingsRelationService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("lost_and_found:pickthingsrelation:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = pickthingsRelationService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("lost_and_found:pickthingsrelation:info")
    public R info(@PathVariable("id") Long id){
		PickthingsRelationEntity pickthingsRelation = pickthingsRelationService.getById(id);

        return R.ok().put("pickthingsRelation", pickthingsRelation);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("lost_and_found:pickthingsrelation:save")
    public R save(@RequestBody PickthingsRelationEntity pickthingsRelation){
		pickthingsRelationService.save(pickthingsRelation);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("lost_and_found:pickthingsrelation:update")
    public R update(@RequestBody PickthingsRelationEntity pickthingsRelation){
		pickthingsRelationService.updateById(pickthingsRelation);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("lost_and_found:pickthingsrelation:delete")
    public R delete(@RequestBody Long[] ids){
		pickthingsRelationService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
