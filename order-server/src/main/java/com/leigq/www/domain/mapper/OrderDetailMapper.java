package com.leigq.www.domain.mapper;

import com.leigq.www.entity.OrderDetail;
import org.apache.ibatis.annotations.Mapper;import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 订单详情
 * <p>
 * 创建人：LeiGQ <br>
 * 创建时间：2019-03-06 20:45 <br>
 * <p>
 * 修改人： <br>
 * 修改时间： <br>
 * 修改备注： <br>
 * </p>
 */
@Mapper
public interface OrderDetailMapper {
    int deleteByPrimaryKey(Long id);

    int insert(OrderDetail record);

    Long insertSelective(OrderDetail record);

    OrderDetail selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(OrderDetail record);

    int updateByPrimaryKey(OrderDetail record);

    /**
     * 根据订单id获取订单明细
     * <br>创建人： leiGQ
     * <br>创建时间： 2019-03-07 17:13
     * <p>
     * 修改人： <br>
     * 修改时间： <br>
     * 修改备注： <br>
     * </p>
     * <br>
     *
     * @param orderId 订单id
     * @return 订单明细
     */
    List<OrderDetail> listOrderDetails(@Param("orderId") Long orderId);
}