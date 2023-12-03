package com.pbl.pt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class PtManagementWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(PtManagementWebApplication.class, args);
    }

}
