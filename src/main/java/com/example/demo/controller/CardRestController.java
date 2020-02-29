package com.example.demo.controller;


import com.example.demo.exceptions.DuplicateDataException;
import com.example.demo.exceptions.NotFoundException;
import com.example.demo.model.Card;
import com.example.demo.model.User;
import com.example.demo.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/v2/card")
@RestController

public class CardRestController {

    @Autowired
    CardService cardService;


    @RequestMapping(method = RequestMethod.POST, path = "/addcard")
    public ResponseEntity addcard(@RequestBody Card card) throws DuplicateDataException {

        cardService.add(card);
        return ResponseEntity.ok().build();
    }


    @RequestMapping(method = RequestMethod.GET, path = "/deletecard")
    public ResponseEntity deletecard(@RequestBody Card card) throws NotFoundException {

        cardService.delete(card);
        return ResponseEntity.ok().build();


    }
}