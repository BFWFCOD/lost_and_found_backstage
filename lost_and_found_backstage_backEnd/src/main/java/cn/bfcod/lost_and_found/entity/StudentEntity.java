package cn.bfcod.lost_and_found.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 学生
 * 
 * @author bfcod
 * @email 2573948452@qq.com
 * @date 2021-03-05 23:55:20
 */
@Data
@TableName("student")
public class StudentEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 * ID自增
	 */
	@TableId
	private Long id;
	/**
	 * 学号
	 */
	private Long studentNo;
	/**
	 * 姓名
	 */
	private String studentName;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 班级
	 */
	private String className;
	/**
	 * 年级
	 */
	private String specialtyName;
	/**
	 * 电话
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
	 * 原始密码（0） 修改后（1）
	 */
	private Integer isNew;
	/**
	 * 删除标识
	 */
	@TableLogic
	private Integer delStatus;

}
