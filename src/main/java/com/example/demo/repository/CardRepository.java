package com.example.demo.repository;

import com.example.demo.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseStatus;

@Repository
public interface CardRepository extends JpaRepository<Card, Integer> {

    void delete(Card card);

    @Modifying
    void deleteByNumber(int number);

    boolean existsByNumber(int number);

    Card getByNumber(int number);

    Card getById(int id);

    boolean existsByNumberAndIdNot(int number, int id);
}
