package com.me.besicapp.service;

import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.state.QueryableStoreTypes;
import org.apache.kafka.streams.state.ReadOnlyKeyValueStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.config.StreamsBuilderFactoryBean;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {
//
//    @Autowired
//    StreamsBuilderFactoryBean factoryBean;
//
//    public Long getWordCount(String word) {
//        System.out.println(word);
//
//        KafkaStreams kafkaStreams = factoryBean.getKafkaStreams();
//        ReadOnlyKeyValueStore<String, Long> counts = kafkaStreams.store(
//                "counts", QueryableStoreTypes.keyValueStore()
//        );
//        return counts.get(word);
//    }

}
