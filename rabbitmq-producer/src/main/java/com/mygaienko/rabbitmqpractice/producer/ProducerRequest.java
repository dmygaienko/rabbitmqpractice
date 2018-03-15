package com.mygaienko.rabbitmqpractice.producer;

import lombok.Data;

/**
 * Created by enda1n on 14.03.2018.
 */
@Data
public class ProducerRequest {

    private Long id;

    private String value;
}
