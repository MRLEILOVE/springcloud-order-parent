package com.leigq.www.controller;

import com.leigq.www.client.CommodityClient;
import com.leigq.www.common.vo.PostFeignTestVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * 远程调用客户端端简单测试
 * <p>
 * 创建人：LeiGQ <br>
 * 创建时间：2019-03-07 13:47 <br>
 * <p>
 * 修改人： <br>
 * 修改时间： <br>
 * 修改备注： <br>
 * </p>
 */
@RestController
@Slf4j
public class ClientController {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 使用 restTemplate 远程调用客户端端简单测试
     * <br>创建人： leiGQ
     * <br>创建时间： 2019-03-07 15:28
     * <p>
     * 修改人： <br>
     * 修改时间： <br>
     * 修改备注： <br>
     * </p>
     * <br>
     * @return 远程调用结果
     */
    @GetMapping("/messages/commodity/restTemplate")
    public String getRestTemplateMsg() {
        /*
         * 使用RestTemplate调用商品端接口, 推荐使用第三种方式
         * */
        //方式 1（直接使用restTemplate， URL写死）
//        RestTemplate restTemplate = new RestTemplate();
//        final String obj1 = restTemplate.getForObject("http://localhost:8080/messages", String.class);
//        log.warn("obj1:{}", obj1);

        //方式 2（使用LoadBalancerClient通过服务名拿到对应服务的实利，动态拼接URL，再使用RestTemplate）
//        final ServiceInstance serviceInstance = loadBalancerClient.choose("COMMODITY");
//        String url = String.format("http://%s:%s", serviceInstance.getHost(), serviceInstance.getPort()) + "messages";
//        final String obj2 = restTemplate.getForObject(url, String.class);
//        log.warn("obj2:{}", obj2);

        //方式 3（使用@LoadBalanced, 可在Resttemplate里面使用应用名字）
        //下面这个restTemplate是用的上面自动注入的
        final String obj3 = restTemplate.getForObject("http://COMMODITY/messages", String.class);
        log.warn("obj3:{}", obj3);
        return obj3;
    }

    /********************************我是分割线**********************************************************************/

    @Resource
    private CommodityClient commodityClient;

    /**
     * 使用 feign 远程调用客户端端简单测试 Get 请求
     * <br>创建人： leiGQ
     * <br>创建时间： 2019-03-07 15:28
     * <p>
     * 修改人： <br>
     * 修改时间： <br>
     * 修改备注： <br>
     * </p>
     * <br>
     * @return 远程调用结果
     */
    @GetMapping("/messages/commodity/feign")
    public String getFeignMsg() {
        final String obj = commodityClient.getCommodityMessages();
        log.warn("obj:{}", obj);
        return obj;
    }


    /**
     * 使用 feign 远程调用客户端端简单测试 Get 请求
     * <br>创建人： leiGQ
     * <br>创建时间： 2019-03-07 15:28
     * <p>
     * 修改人： <br>
     * 修改时间： <br>
     * 修改备注： <br>
     * </p>
     * <br>
     * @return 远程调用结果
     */
    @PostMapping("/commodity/postFeignTest")
    public String postFeignTest() {
        PostFeignTestVO postFeignTestVO = PostFeignTestVO.builder()
                .id(1L)
                .name("postFeignTest")
                .build();
        PostFeignTestVO vo = commodityClient.postFeignTest(postFeignTestVO);
        log.warn("postFeignTest 远程调用 result : [{}]", vo);
        return "OK";
    }

}
