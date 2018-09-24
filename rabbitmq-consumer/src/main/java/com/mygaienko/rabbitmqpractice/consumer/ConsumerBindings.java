package com.mygaienko.rabbitmqpractice.consumer;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * Created by enda1n on 15.03.2018.
 */
public interface ConsumerBindings {

    String INPUT1 = "input1";

    String INPUT2 = "input2";

    String INPUT3 = "input3";

    String INPUT4 = "input4";

    String INPUT41 = "input41";

    String INPUT5 = "input5Topic";

    @Input(INPUT1)
    SubscribableChannel input1();

    @Input(INPUT2)
    SubscribableChannel input2();

    @Input(INPUT3)
    SubscribableChannel input3();

    @Input(INPUT4)
    SubscribableChannel input4();

    @Input(INPUT41)
    SubscribableChannel input41();

    @Input(INPUT5)
    SubscribableChannel input5();


}
