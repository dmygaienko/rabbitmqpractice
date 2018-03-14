package com.mygaienko.rabbitmqpractice.producer;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * Created by enda1n on 14.03.2018.
 */
public interface ProducerBindings {

    String OUTPUT1 = "output1";

    @Output(OUTPUT1)
    MessageChannel output1();

}
