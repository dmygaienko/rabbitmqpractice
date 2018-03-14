package com.mygaienko.rabbitmqpractice.consumer;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

/**
 * Created by enda1n on 15.03.2018.
 */
@Service
public class ConsumerService {

    @StreamListener(ConsumerBindings.INPUT1)
    public void consume(String payload) {
        System.out.println("Received payload: " + payload);
    }
}
