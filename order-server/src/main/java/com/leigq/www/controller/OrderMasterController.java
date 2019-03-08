package com.leigq.www.controller;

import com.leigq.common.springboot.util.RandomUtils;
import com.leigq.www.bean.OrderResp;
import com.leigq.www.client.CommodityClient;
import com.leigq.www.common.entity.Commodity;
import com.leigq.www.entity.OrderDetail;
import com.leigq.www.entity.OrderMaster;
import com.leigq.www.service.OrderDetailService;
import com.leigq.www.service.OrderMasterService;
import com.leigq.www.vo.OrderVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 订单
 * <p>
 * 创建人：LeiGQ <br>
 * 创建时间：2019-03-07 09:58 <br>
 * <p>
 * 修改人： <br>
 * 修改时间： <br>
 * 修改备注： <br>
 * </p>
 */
@RestController
public class OrderMasterController {

    @Autowired
    private OrderMasterService orderMasterService;

    @Autowired
    private OrderResp orderResp;

    @Resource
    private CommodityClient commodityClient;

    @Autowired
    private OrderDetailService orderDetailService;

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
     * @return
     */
    @PostMapping("/orders")
    public OrderResp saveOrders(OrderVO orderVO) {
        //查询商品（调用商品服务，这里做简单一点，每次买一件商品；
        // 真实项目是每次可买多件商品，而且还要扣库存，我这里就不写了，主要是熟悉Feign的使用）
        final Commodity commodity = commodityClient.getCommodities(orderVO.getCId());
        //添加订单
        OrderMaster orderMaster = new OrderMaster();
        //订单编号
        orderMaster.setCode(RandomUtils.getNanoTimeRandom(12));
        //订单金额
        orderMaster.setAmount(commodity.getPrice());
        if (orderMasterService.saveOrders(orderMaster) > 0) {
            //添加订单详情
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setCId(orderVO.getCId());
            orderDetail.setNumber(orderVO.getNumber());
            orderDetail.setOmId(orderMaster.getId());
            orderDetail.setPrice(commodity.getPrice());
            if (orderDetailService.saveOrderDetails(orderDetail) > 0) {
                orderMaster = orderMasterService.getOrders(orderMaster.getId());
                BeanUtils.copyProperties(orderMaster, orderVO);
                List<OrderDetail> orderDetails = orderDetailService.listOrderDetails(orderMaster.getId());
                orderVO.setOrderDetails(orderDetails);
                return orderResp.success("下单成功！", orderVO);
            }
        }
        return orderResp.failure("下单失败，请稍候重试！", null);
    }


}
