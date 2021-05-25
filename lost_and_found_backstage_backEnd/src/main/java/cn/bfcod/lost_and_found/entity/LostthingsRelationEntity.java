package cn.bfcod.lost_and_found.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 失物认领关联
 * 
 * @author bfcod
 * @email 2573948452@qq.com
 * @date 2021-03-05 23:55:19
 */
@Data
@TableName("lostthings_relation")
public class LostthingsRelationEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long id;
	/**
	 * 物品id
	 */
	private Long lostthingsId;
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
