package com.snail.eurekaclient1.user.restful;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HiRestful {
    @Value("${server.port}")
    String prot;

    @RequestMapping("/hi")
    public String hi(@RequestParam String name){
        return "hi "+name+" i am port:"+prot;
    }
}
