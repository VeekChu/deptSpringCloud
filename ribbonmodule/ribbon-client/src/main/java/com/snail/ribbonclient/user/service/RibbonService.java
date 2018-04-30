package com.snail.ribbonclient.user.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Service
public class RibbonService {
    @Resource
    private RestTemplate restTemplate;

    /**
     * 负载均衡调用远程rest接口
     * @param name
     * @return
     */
    public String hi(String name){
        return restTemplate.getForObject("http://eureka-client/hi?name="+name,String.class);
    }
}
