package cn.bfcod.lost_and_found.controller;

import java.util.Arrays;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import cn.bfcod.common.utils.PageUtils;
import cn.bfcod.common.utils.R;
import cn.bfcod.lost_and_found.entity.StudentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.bfcod.lost_and_found.service.StudentService;


/**
 * 学生
 *
 * @author bfcod
 * @email 2573948452@qq.com
 * @date 2021-03-05 23:55:20
 */
@RestController
@RequestMapping("lost_and_found/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("lost_and_found:student:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = studentService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("lost_and_found:student:info")
    public R info(@PathVariable("id") String id){
		StudentEntity student = studentService.getById(id);

        return R.ok().put("student", student);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("lost_and_found:student:save")
    public R save(@RequestBody StudentEntity student){
		studentService.save(student);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("lost_and_found:student:update")
    public R update(@RequestBody StudentEntity student){
		studentService.updateById(student);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("lost_and_found:student:delete")
    public R delete(@RequestBody String[] studentNos){
		studentService.removeByIds(Arrays.asList(studentNos));

        return R.ok();
    }

}
