package com.snail.ribbonclient.user.restful;

import com.snail.ribbonclient.user.service.RibbonService;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class RibbonRestful {
    @Resource
    private RibbonService ribbonService;

    @RequestMapping("/ribbon-hi")
    public String hi(@RequestParam String name){
        return ribbonService.hi(name);
    }

    /**
     * 测试LoadBalancerClient获取服务实例，负载均衡
     */
    @Resource
    private LoadBalancerClient loadBalancerClient;
    @GetMapping("/testRibbon")
    public String testRibbon(){
        ServiceInstance serviceInstance = loadBalancerClient.choose("eureka-client");
        return serviceInstance.getServiceId()+serviceInstance.getHost()+serviceInstance.getPort()+serviceInstance.getUri();
    }
}
