package com.leigq.www.service;

import com.leigq.www.entity.OrderMaster;
import com.leigq.www.domain.mapper.OrderMasterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 订单
 * <p>
 * 创建人：LeiGQ <br>
 * 创建时间：2019-03-06 20:45 <br>
 * <p>
 * 修改人： <br>
 * 修改时间： <br>
 * 修改备注： <br>
 * </p>
 */
@Service
@Transactional
public class OrderMasterService {

    @Autowired
    private OrderMasterMapper orderMasterMapper;

    /**
     * 添加订单
     * <br>创建人： leiGQ
     * <br>创建时间： 2019-03-07 10:16
     * <p>
     * 修改人： <br>
     * 修改时间： <br>
     * 修改备注： <br>
     * </p>
     * <br>
     * @param orderMaster 订单实体
     * @return 新增订单的主键
     */
    public Long saveOrders(OrderMaster orderMaster) {
        return orderMasterMapper.insertSelective(orderMaster);
    }

    /**
     * 获取订单
     * <br>创建人： leiGQ
     * <br>创建时间： 2019-03-07 10:21
     * <p>
     * 修改人： <br>
     * 修改时间： <br>
     * 修改备注： <br>
     * </p>
     * <br>
     * @param orderId 订单Id
     * @return 对应订单Id的订单
     */
    public OrderMaster getOrders(Long orderId) {
        return orderMasterMapper.selectByPrimaryKey(orderId);
    }
}
