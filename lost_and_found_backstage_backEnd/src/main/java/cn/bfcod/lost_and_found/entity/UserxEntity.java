package cn.bfcod.lost_and_found.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 管理员
 * 
 * @author bfcod
 * @email 2573948452@qq.com
 * @date 2021-03-05 23:55:19
 */
@Data
@TableName("user")
public class UserxEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * ID自增
	 */
	@TableId
	private Long id;
	/**
	 * 用户名
	 */
	private String userName;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 昵称
	 */
	private String nickName;
	/**
	 * 状态
	 */
	private Integer status;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 原始密码（0） 修改后（1）
	 */
	private Integer isNew;
	/**
	 * 最后一次登录时间
	 */
	private Date lastloginTime;

}
