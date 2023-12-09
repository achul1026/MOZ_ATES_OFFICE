package com.moz.ates.traffic.office;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.moz.ates.traffic.office","com.moz.ates.traffic.common"})
public class OfficeApplication {

    public static void main(String[] args) {
        SpringApplication.run(OfficeApplication.class, args);
    }

}
