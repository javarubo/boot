package com.example.demo.service;


import com.example.demo.exceptions.DuplicateDataException;
import com.example.demo.exceptions.NotFoundException;
import com.example.demo.model.Card;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public interface CardService {
    void add(Card card) throws DuplicateDataException;


    void delete(int id) throws NotFoundException;

    List<Card> getAll();


    Card getById(int id) throws NotFoundException;

    void update(Card card) throws DuplicateDataException;
}
