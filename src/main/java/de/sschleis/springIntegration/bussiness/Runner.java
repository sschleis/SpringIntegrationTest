package de.sschleis.springIntegration.bussiness;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Runner {

    @Autowired
    private MessageChannel helloChannel;

    @Scheduled(fixedRate = 500000000)
    public void poller() {
        System.out.println("Runner");
        for(int i = 0; i < 10; i++){
            final double random = Math.random();
            helloChannel.send(MessageBuilder.withPayload(String.valueOf(random)).build());
        }
        System.out.println("Stop Runner");
    }
}
