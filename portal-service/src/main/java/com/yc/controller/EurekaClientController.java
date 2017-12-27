package com.yc.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/portal")
public class EurekaClientController {


    @Qualifier("eurekaClient")
    @Autowired
    private EurekaClient discoveryClient;

    @RequestMapping("/eureka/{service}")
    public String serviceUrl(@PathVariable String service) {
        InstanceInfo instance = discoveryClient.getNextServerFromEureka(service, false);
        return instance.getHomePageUrl();
    }

}
