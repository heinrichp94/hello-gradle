package com.me.besicapp.controller;

import com.me.besicapp.service.KafkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WordsController {
    @Autowired
    private KafkaService kafkaService;

//    @GetMapping("/count/{word}")
//    public Long getWordCount(@PathVariable String word) {
//        return kafkaService.getWordCount(word);
//    }

    @GetMapping("/get")
    public String getHelpCount() {
        return "Yeah";
    }

}
