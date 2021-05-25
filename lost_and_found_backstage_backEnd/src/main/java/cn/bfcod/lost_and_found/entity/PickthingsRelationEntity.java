package cn.bfcod.lost_and_found.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 寻到物品关联
 * 
 * @author bfcod
 * @email 2573948452@qq.com
 * @date 2021-03-05 23:55:19
 */
@Data
@TableName("pickthings_relation")
public class PickthingsRelationEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long id;
	/**
	 * 物品id
	 */
	private Long pickthingsId;
	/**
	 * 分类id
	 */
	private Long studentId;
	/**
	 * 
	 */
	private String lostthingsName;
	/**
	 * 
	 */
	private String studentName;

}
