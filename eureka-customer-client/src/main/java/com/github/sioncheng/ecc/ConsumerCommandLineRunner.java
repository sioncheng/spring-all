package com.github.sioncheng.ecc;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
@Configuration
public class ConsumerCommandLineRunner implements CommandLineRunner {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private List<RestTemplate> restTemplates = Collections.emptyList();

    @Autowired
    private List<RestTemplate> restTemplates2;

    @Override
    public void run(String... args) throws Exception {
        System.out.println(discoveryClient == null);

        List<ServiceInstance> serviceInstanceList = discoveryClient.getInstances("CLIENT-SERVICE");

        System.out.println(serviceInstanceList.isEmpty());
        serviceInstanceList.forEach(x -> System.out.println(x.getHost() + ":" + x.getPort()));


        String res = restTemplate.getForObject("http://client-service/svr1/hello", String.class);
        System.out.println(res);

        System.out.println(restTemplates.isEmpty());

        if (!restTemplates.isEmpty()) {
            restTemplates.forEach(x -> System.out.println(x == restTemplate));
        }

        System.out.println(restTemplates2.size());
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public List<RestTemplate> restTemplatesBuilder() {
        return Arrays.asList(new RestTemplate(), new RestTemplate());
    }

    @Bean
    public RestTemplate restTemplate2() {
        return new RestTemplate();
    }
}
