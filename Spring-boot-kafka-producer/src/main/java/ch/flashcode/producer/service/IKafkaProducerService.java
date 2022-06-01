package ch.flashcode.producer.service;

import java.util.List;

import ch.flashcode.producer.User;

public interface IKafkaProducerService {
	void send(String message);
	void send(List<User> list);
}
