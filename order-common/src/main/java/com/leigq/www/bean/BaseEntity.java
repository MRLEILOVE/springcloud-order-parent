package com.leigq.www.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 实体类基类
 * <p>
 * 创建人：LeiGQ <br>
 * 创建时间：2019-03-06 20:08 <br>
 * <p>
 * 修改人： <br>
 * 修改时间： <br>
 * 修改备注： <br>
 * </p>
 */
@Data
public abstract class BaseEntity implements Serializable{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -1308319624577045638L;

	private Long id;

	private Date createTime;
	
	private Date updateTime;
	

}
