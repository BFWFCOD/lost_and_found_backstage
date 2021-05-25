package cn.bfcod.lost_and_found.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 寻到物品
 * 
 * @author bfcod
 * @email 2573948452@qq.com
 * @date 2021-03-05 23:55:20
 */
@Data
@TableName("pick_things")
public class PickThingsEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * LostThings ID 自增
	 */
	@TableId
	private Long id;
	/**
	 * 物品名称
	 */
	private String thingsName;
	/**
	 * 寻到地点
	 */
	private String pickPlace;
	/**
	 * 寻到时间
	 */
	private Date pickTime;
	/**
	 * 物品类型
	 */
	private String thingsType;
	/**
	 * 物品图片
	 */
	private String thingsImg;
	/**
	 * 物品描述
	 */
	private String thingsDes;
	/**
	 * 暂存地点
	 */
	private String storagePlace;
	/**
	 * 联系电话
	 */
	private String phone;
	/**
	 * qq
	 */
	private String qq;
	/**
	 * 邮箱
	 */
	private String email;
	/**
	 * 发布时间
	 */
	private Date publishTime;
	/**
	 * 状态
	 */
	private Integer status;
	/**
	 * 用户名
	 */
	private String studentName;
	/**
	 * 用户编号
	 */
	private Long studentNo;
	/**
	 * 删除标识
	 */
	@TableLogic
	private Integer delStatus;

}
