package com.github.sioncheng.ecc;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;

@Component
public class ConsumerCommandLineRunner implements CommandLineRunner {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Override
    public void run(String... args) throws Exception {
        System.out.println(discoveryClient == null);

        discoveryClient.getInstances("CLIENT-SERVICE").forEach(x -> {
            System.out.println(x.getHost() + ":" + x.getPort());
        });
    }
}
