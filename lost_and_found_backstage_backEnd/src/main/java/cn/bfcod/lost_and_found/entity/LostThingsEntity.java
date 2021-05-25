package cn.bfcod.lost_and_found.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 丢失物品
 * 
 * @author bfcod
 * @email 2573948452@qq.com
 * @date 2021-03-05 23:55:19
 */
@Data
@TableName("lost_things")
public class LostThingsEntity implements Serializable {
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
	 * 丢失地点
	 */
	private String lostPlace;
	/**
	 * 丢失时间
	 */
	private Date lostTime;
	/**
	 * 物品类型
	 */
	private String thingsType;
	/**
	 * 物品图片 可 null
	 */
	private String thingsImg;
	/**
	 * 物品描述
	 */
	private String thingsDes;
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
