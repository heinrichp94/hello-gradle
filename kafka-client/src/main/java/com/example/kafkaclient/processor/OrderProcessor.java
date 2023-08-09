package com.example.kafkaclient.processor;

import com.example.kafkaclient.model.Order;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.KTable;
import org.apache.kafka.streams.kstream.Printed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.stereotype.Component;

@Component
public class OrderProcessor {

    private static final Serde<String> STRING_SERDE = Serdes.String();
    private static final JsonDeserializer<Order> deserializer = new JsonDeserializer<>(Order.class);


    @Autowired
    void buildPipeline(StreamsBuilder streamsBuilder) {
        KStream<String, String> textStream = streamsBuilder
                .stream("order", Consumed.with(STRING_SERDE, STRING_SERDE));
        textStream.print(Printed.<String, String>toSysOut().withLabel("words--->"));

        KTable<String, String> orderCounts = textStream
//                .filter((key, value) -> value.getDeliveryType().equalsIgnoreCase("home-delivery"))

                .toTable();


        orderCounts.toStream().to("home-service");
    }

}
