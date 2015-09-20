package de.sschleis.springIntegration.bussiness;

import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Component;

@Component
public class Logic {

    @ServiceActivator(inputChannel = "helloChannel")
    public void print(String string) throws InterruptedException {
        System.out.println(">" + string + "<");
        Thread.sleep(5000);
        System.out.println("WakeUp!");
    }
}
