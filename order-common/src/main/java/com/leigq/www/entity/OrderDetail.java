package com.leigq.www.entity;

import com.leigq.common.springboot.bean.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

/**
 * 订单详情实体
 * <p>
 * 创建人：LeiGQ <br>
 * 创建时间：2019-03-06 20:45 <br>
 * <p>
 * 修改人： <br>
 * 修改时间： <br>
 * 修改备注： <br>
 * </p>
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class OrderDetail extends BaseEntity {
    /**
	* 订单Id
	*/
    private Long omId;

    /**
	* 商品Id
	*/
    private Long cId;

    /**
	* 数量
	*/
    private Short number;

    /**
	* 价格
	*/
    private BigDecimal price;
}