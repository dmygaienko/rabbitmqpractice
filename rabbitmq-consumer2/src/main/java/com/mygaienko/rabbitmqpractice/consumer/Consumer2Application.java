package com.mygaienko.rabbitmqpractice.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

@SpringBootApplication
@EnableBinding(ConsumerBindings.class)
public class Consumer2Application {

	public static void main(String[] args) {
		SpringApplication.run(Consumer2Application.class, args);
	}
}
