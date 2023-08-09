package com.example.kafkaclient.service;

import com.example.kafkaclient.model.Order;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;

@Service
public class StreamService {

//    @SendTo("order-takeaway-output-channel")
//    public KStream<String, Order> takeAway(KStream<String, Order> orderKStream) {
//        return orderKStream.filter((key, value) -> value.getDeliveryType().equalsIgnoreCase("takeaway"));
//    }
//
//    @SendTo("order-homedelivery-output-channel")
//    public KStream<String, Order> homeDelivery(KStream<String, Order> orderKStream) {
//        return orderKStream.filter((key, value) -> value.getDeliveryType().equalsIgnoreCase("homedelivery"));
//    }


}
