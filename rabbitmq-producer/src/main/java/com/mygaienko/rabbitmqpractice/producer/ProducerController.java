package com.mygaienko.rabbitmqpractice.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by enda1n on 14.03.2018.
 */
@RequestMapping("/producer")
@RestController
public class ProducerController {

    private final ObjectMapper objectMapper;

    private final ProducerBindings bindings;

    public ProducerController(ObjectMapper objectMapper, ProducerBindings bindings) {
        this.objectMapper = objectMapper;
        this.bindings = bindings;
    }

    @PostMapping()
    public void postMessage(@RequestBody ProducerRequest producerRequest) throws JsonProcessingException {
        bindings.output1().send(new GenericMessage<>(objectMapper.writeValueAsString(producerRequest)));
    }
}
