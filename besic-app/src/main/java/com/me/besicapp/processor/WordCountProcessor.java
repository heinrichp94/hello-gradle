package com.me.besicapp.processor;

import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class WordCountProcessor {

    private static final Serde<String> STRING_SERDE = Serdes.String();

//    @StreamListener("input")
//    @SendTo("output")
//    public KStream<?, String> process(KStream<?, String> input) {
//        return input
//                .flatMapValues(value -> Arrays.asList(value.toLowerCase().split("\\W+")))
//                .groupBy((key, value) -> value)
//                .windowedBy(TimeWindows.of(5000))
//                .count(Materialized.as("WordCounts-multi"))
//                .toStream()
//                .map((key, value) -> new KeyValue<>(null, new WordCount(key.key(), value, new Date(key.window().start()), new Date(key.window().end()))));
//    }

    @Autowired
    void buildPipeline(StreamsBuilder streamsBuilder) {
        KStream<String, String> textStream = streamsBuilder
                .stream("my-topic", Consumed.with(STRING_SERDE, STRING_SERDE));

        textStream.print(Printed.<String, String>toSysOut().withLabel("words--->"));

        KTable<String, Long> wordCounts = textStream
                .mapValues((ValueMapper<String, String>) String::toLowerCase)
                .flatMapValues(value -> Arrays.asList(value.split("\\W+")))
                .groupBy((key, value) -> value)
                .count(Materialized.as("counts-dracula"));

        wordCounts.toStream().to("your-topic");
    }
}
