package com.example.kafkaproducer.controller;

import com.example.kafkaproducer.model.Order;
import com.example.kafkaproducer.service.KafkaProducerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    private final KafkaProducerService kafkaProducerService;

    public OrderController(KafkaProducerService kafkaProducerService) {
        this.kafkaProducerService = kafkaProducerService;
    }

    @PostMapping("/post")
    public void order(@RequestBody Order order) {
        kafkaProducerService.send(order);

    }
}
