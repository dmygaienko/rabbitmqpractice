package com.mygaienko.rabbitmqpractice.consumer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

/**
 * Created by enda1n on 15.03.2018.
 */
@Service
public class ConsumerService {

    private final String instanceIndex;

    public ConsumerService(@Value("${consumer.index}") String instanceIndex) {
        this.instanceIndex = instanceIndex;
    }

    @StreamListener(ConsumerBindings.INPUT1)
    public void consume1(String payload) {
        System.out.println("Consumer 1 (post1): Received payload: " + payload);
    }

    @StreamListener(ConsumerBindings.INPUT2)
    public void consume2(String payload) {
        System.out.println("Consumer 2 (post2): Received payload: " + payload);
    }

    @StreamListener(ConsumerBindings.INPUT3)
    public void consume3(String payload) {
        System.out.println("Consumer 3: Received payload: " + payload);
    }

    @StreamListener(ConsumerBindings.INPUT4)
    public void consume4(String payload) {
        System.out.println("Consumer 4: Received payload: " + payload);
    }

    @StreamListener(ConsumerBindings.INPUT5)
    public void consume5(String payload) {
        System.out.println("InstanceIndex " + instanceIndex + "; Consumer 5; Received payload: " + payload);
    }
}
