package com.mygaienko.rabbitmqpractice.consumer;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;

/**
 * Created by enda1n on 15.03.2018.
 */
@Service
public class ConsumerService {

    private final int instanceIndex;

    public ConsumerService(@Value("${consumer.index}") String instanceIndex) {
        this.instanceIndex = Integer.valueOf(instanceIndex);
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

    @StreamListener(ConsumerBindings.INPUT41)
    public void consume41(String payload) {
        System.out.println("Consumer 41: Received payload: " + payload);
    }

    @StreamListener(ConsumerBindings.INPUT42)
    public void consume42(@Payload String payload,
                          @Header(AmqpHeaders.CHANNEL) Channel channel,
                          @Header(AmqpHeaders.DELIVERY_TAG) Long deliveryTag) throws IOException {
        System.out.println("Consumer 42: Received payload: " + payload);

        Map<String, String> map = new ObjectMapper().readValue(payload, new TypeReference<Map<String, String>>() {});
        if (partitionOk(map)) {
            channel.basicAck(deliveryTag, true);
            System.out.println("Consumer 42: Ack: " + payload);
        } else {
            channel.basicNack(deliveryTag, false, true);
            System.out.println("Consumer 42: basicNack: " + payload);
        }
    }

    private boolean partitionOk(Map<String, String> map) {
        return instanceIndex == map.get("id").hashCode() % 2;
    }

    @StreamListener(ConsumerBindings.INPUT5)
    public void consume5(String payload) {
        System.out.println("InstanceIndex " + instanceIndex + "; Consumer 5; Received payload: " + payload);
    }
}
