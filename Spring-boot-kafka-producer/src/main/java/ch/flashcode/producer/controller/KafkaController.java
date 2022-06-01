package ch.flashcode.producer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.flashcode.exception.BeanBadRequestException;
import ch.flashcode.producer.User;
import ch.flashcode.producer.service.KafkaProducerService;

@RestController
@CrossOrigin
@RequestMapping("/api/v1")
public class KafkaController {

	@Autowired
	private KafkaProducerService kafkaProducerService;

	@PostMapping
	public ResponseEntity<List<User>> sendMessage(@RequestBody List<User> list) {

		kafkaProducerService.send(list);

		return new ResponseEntity<List<User>>(list, HttpStatus.OK);
	}

	@PutMapping("/users/{id}")
	public ResponseEntity<List<User>> putMessage(@PathVariable(name = "id") Integer id, 
			@RequestBody List<User> list) throws BeanBadRequestException {
	//	int idM = id;
		kafkaProducerService.send(list);

		return new ResponseEntity<List<User>>(list, HttpStatus.OK);
	}

}
