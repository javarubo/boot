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
import java.util.Optional;
import java.util.stream.Collectors;


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
        List<Card> card = cardRepository.findAll();
        card.forEach(card1 -> System.out.println(card1));
        List<Card> cardList = card.stream().filter(card1 -> card1.getId() > 5).collect(Collectors.toList());
        List<Integer> ids = card.stream()
                .filter(card1 -> card1.getId() > 10)
                .map(card1 -> card1.getId())
                .collect(Collectors.toList());
        return cardRepository.findAll();
    }

    @Override
    public Card getById(int id) throws NotFoundException {
        return cardRepository.findById(id).orElseThrow(() -> new NotFoundException("card.not.found"));
    }


    @Override
    public void update(Card card) throws DuplicateDataException {

        boolean exist = cardRepository.existsByNumberAndIdNot(card.getNumber(), card.getId());

        DuplicateDataException.check(exist, "number.already.exist");

    }


}