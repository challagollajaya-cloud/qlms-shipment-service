package com.microsoft.quantum.qlmsshipmentservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class QlmsShipmentServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(QlmsShipmentServiceApplication.class, args);
    }
}