package de.sschleis.springIntegration.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.ExecutorChannel;
import org.springframework.messaging.MessageChannel;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Configuration
@EnableScheduling
public class IntegrationConfig {

    @Bean
    public MessageChannel helloChannel(){
        return new ExecutorChannel(new ThreadPoolExecutor(1, 1, 100, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>()));
    }
}
