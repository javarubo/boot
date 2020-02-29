package com.example.demo.service;


import com.example.demo.exceptions.DuplicateDataException;
import com.example.demo.exceptions.NotFoundException;
import com.example.demo.model.Card;
import org.springframework.stereotype.Service;

@Service

public interface CardService {
    void add(Card card) throws DuplicateDataException;

    void delete(Card card) throws NotFoundException;
}
