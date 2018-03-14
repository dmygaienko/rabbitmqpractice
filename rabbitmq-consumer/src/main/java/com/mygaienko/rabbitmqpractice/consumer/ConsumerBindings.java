package com.mygaienko.rabbitmqpractice.consumer;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * Created by enda1n on 15.03.2018.
 */
public interface ConsumerBindings {

    String INPUT1 = "input1";

    @Input(INPUT1)
    SubscribableChannel input1();
}
