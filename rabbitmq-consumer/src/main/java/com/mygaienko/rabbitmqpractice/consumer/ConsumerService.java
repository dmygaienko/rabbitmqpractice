package com.mygaienko.rabbitmqpractice.consumer;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

/**
 * Created by enda1n on 15.03.2018.
 */
@Service
public class ConsumerService {

    @StreamListener(ConsumerBindings.INPUT1)
    public void consume1(String payload) {
        System.out.println("Consumer 1: Received payload: " + payload);
    }

    @StreamListener(ConsumerBindings.INPUT2)
    public void consume2(String payload) {
        System.out.println("Consumer 2: Received payload: " + payload);
    }
}