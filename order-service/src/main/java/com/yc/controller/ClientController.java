package com.yc.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class ClientController {
    @Autowired
    EurekaClient eurekaClient;

    @RequestMapping("/eureka-client")
    public InstanceInfo getInstanceInfo(){
        return eurekaClient.getNextServerFromEureka("account-service", true);
    }

    @Autowired
    DiscoveryClient discoveryClient;

    @RequestMapping("/discovery-client")
    public ServiceInstance getServiceInstance(){
        List<ServiceInstance> instances = discoveryClient.getInstances("account-service");
        return Optional.ofNullable(instances).map(list -> list.get(0)).get();
    }

//    @Autowired
//    RestTemplate restTemplate;
//
//    @RequestMapping("/account")
//    public String getAccount(){
//        return restTemplate.getForEntity("", String.class).getBody();
//    }

    @Autowired
    LoadBalancerClient loadBalancerClient;

    @RequestMapping("loadBalancerClient")
    public ServiceInstance getClient(){
        ServiceInstance serviceInstance = loadBalancerClient.choose("account-service");
        return serviceInstance;
    }

}
