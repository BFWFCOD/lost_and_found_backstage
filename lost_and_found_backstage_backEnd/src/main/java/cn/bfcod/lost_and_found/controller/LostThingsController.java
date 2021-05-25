package cn.bfcod.lost_and_found.controller;

import java.util.Arrays;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.bfcod.lost_and_found.entity.LostThingsEntity;
import cn.bfcod.lost_and_found.service.LostThingsService;
import cn.bfcod.common.utils.PageUtils;
import cn.bfcod.common.utils.R;



/**
 * 丢失物品
 *
 * @author bfcod
 * @email 2573948452@qq.com
 * @date 2021-03-05 23:55:19
 */
@RestController
@RequestMapping("lost_and_found/lostthings")
public class LostThingsController {
    @Autowired
    private LostThingsService lostThingsService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("lost_and_found:lostthings:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = lostThingsService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("lost_and_found:lostthings:info")
    public R info(@PathVariable("id") Long id){
		LostThingsEntity lostThings = lostThingsService.getById(id);

        return R.ok().put("lostThings", lostThings);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("lost_and_found:lostthings:save")
    public R save(@RequestBody LostThingsEntity lostThings){
		lostThingsService.save(lostThings);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("lost_and_found:lostthings:update")
    public R update(@RequestBody LostThingsEntity lostThings){
		lostThingsService.updateById(lostThings);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("lost_and_found:lostthings:delete")
    public R delete(@RequestBody Long[] ids){
		lostThingsService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
