package com.jj.cloud.rabbit;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class TopicRabbitConfig {

	final static String message =  "topic.message";
	final static String messages = "topic.messages";

	@Bean
	public Queue queueMessage() {
		return new Queue(TopicRabbitConfig.message);
	}

	@Bean
	public Queue queueMessages1() {
		return new Queue(TopicRabbitConfig.messages);
	}

	@Bean
	public TopicExchange exchange() {
		return new TopicExchange("topicExchange");
	}

	@Bean
	public Binding bindingExchangeMessage(Queue queueMessage, TopicExchange exchange) {
		return BindingBuilder.bind(queueMessage).to(exchange).with("topic.message");
	}

//	@Bean
//	public Binding bindingExchangeMessages(Queue queueMessages, TopicExchange exchange) {
//		return BindingBuilder.bind(queueMessages).to(exchange).with("topic.#");
//	}
}