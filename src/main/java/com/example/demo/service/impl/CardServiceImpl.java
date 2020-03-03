package com.example.demo.service.impl;

import com.example.demo.exceptions.DuplicateDataException;
import com.example.demo.exceptions.NotFoundException;
import com.example.demo.model.Card;
import com.example.demo.model.User;
import com.example.demo.repository.CardRepository;
import com.example.demo.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service

public class CardServiceImpl implements CardService {

    @Autowired
    CardRepository cardRepository;

    @Override
    public void add(Card card) throws DuplicateDataException {
        DuplicateDataException.check(cardRepository.existsByNumber(card.getNumber()), "card.already.exist");
        cardRepository.save(card);

    }


    @Override
    public void delete(int id) throws NotFoundException {
        cardRepository.deleteById(id);
    }

    @Override
    public List<Card> getAll() {
        return cardRepository.findAll();
    }

    @Override
    public Card getById(int id) {
        return cardRepository.getById(id);
    }



    @Override
    public void update(Card card) throws DuplicateDataException {

        boolean exist = cardRepository.existsByNumberAndIdNot(card.getNumber(), card.getId());

        DuplicateDataException.check(exist, "number.already.exist");

    }


}