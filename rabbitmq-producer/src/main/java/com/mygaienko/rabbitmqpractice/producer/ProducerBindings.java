package com.mygaienko.rabbitmqpractice.producer;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * Created by enda1n on 14.03.2018.
 */
public interface ProducerBindings {

    String OUTPUT1 = "output1";

    String OUTPUT2 = "output2";

    String OUTPUT3 = "output3";

    String OUTPUT4 = "output4";

    String OUTPUT5 = "output5Topic";

    @Output(OUTPUT1)
    MessageChannel output1();

    @Output(OUTPUT2)
    MessageChannel output2();

    @Output(OUTPUT3)
    MessageChannel output3();

    @Output(OUTPUT4)
    MessageChannel output4();

    @Output(OUTPUT5)
    MessageChannel output5();

}
