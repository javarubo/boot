package com.example.demo.service.impl;

import com.example.demo.exceptions.DuplicateDataException;
import com.example.demo.exceptions.NotFoundException;
import com.example.demo.model.Card;
import com.example.demo.model.User;
import com.example.demo.repository.CardRepository;
import com.example.demo.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service

public class CardServiceImpl implements CardService {

    @Autowired
    CardRepository cardRepository;

    @Override
    public void add(Card card) throws DuplicateDataException {

        boolean exists = cardRepository.existsByNumber(card.getNumber());
        DuplicateDataException.check(exists, "card.already.exist");

        cardRepository.save(card);

    }

    @Override
    public void delete(Card card) throws NotFoundException {
        boolean exists = cardRepository.existsByNumber(card.getNumber());

        NotFoundException.check(!exists, "card.not.found");

        cardRepository.delete(card);
    }


}