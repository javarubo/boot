package com.example.demo.controller;


import com.example.demo.exceptions.DuplicateDataException;
import com.example.demo.exceptions.NotFoundException;
import com.example.demo.model.Card;
import com.example.demo.model.User;
import com.example.demo.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/v2/card")
@RestController

public class CardRestController {

    @Autowired
    CardService cardService;


    @PostMapping(path = "/addcard")
    public ResponseEntity addcard(@RequestBody Card card) throws DuplicateDataException {

        cardService.add(card);
        return ResponseEntity.ok().build();
    }


    @GetMapping(path = "/getcard")
    public ResponseEntity getCard() {
        List<Card> cards = cardService.getAll();


        return ResponseEntity.ok(cards);
    }


    @GetMapping("/{id}")
    public ResponseEntity getCard(@PathVariable int id) {
        Card card = cardService.getById(id);
        return ResponseEntity.ok(card);
    }




    @DeleteMapping("/{id}")
    public ResponseEntity deletecard(@PathVariable int id) throws NotFoundException {

        cardService.delete(id);
        return ResponseEntity.ok().build();


    }

    @PutMapping(path = "/update")
    public ResponseEntity updateCard( @RequestBody Card card ) throws DuplicateDataException {
        cardService.update(card);
        return ResponseEntity.ok().build();

    }


}