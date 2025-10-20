package com.githubproxy;

import com.githubproxy.controller.GithubController;
import com.githubproxy.service.GithubService;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.event.EventListener;

@EnableFeignClients
@SpringBootApplication
@Log4j2
public class GithubProxyApplication {

    public static void main(String[] args) {
        SpringApplication.run(GithubProxyApplication.class, args);
    }


}
