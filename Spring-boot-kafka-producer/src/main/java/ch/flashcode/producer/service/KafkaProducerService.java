package ch.flashcode.producer.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import ch.flashcode.producer.User;

@Service
public class KafkaProducerService implements IKafkaProducerService {

    private static final Logger logger = LoggerFactory.getLogger(KafkaProducerService.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplateString;
    
    @Autowired
    private KafkaTemplate<String, List<User>> kafkaTemplateJson;

    @Value("${spring.kafka.producer.properties.topic}")
    private String topic;

    @Override
    public void send(String message) {		
        logger.info("message sent: {}", message);
        kafkaTemplateString.send("TestTopic", message);
       
    }

	@Override
	public void send(List<User> list) {
		 logger.info("message sent: {}", list);
		 kafkaTemplateJson.send(topic, list);
		
	}
}