package com.example.demo.service;

import com.example.demo.exceptions.DuplicateDataException;
import com.example.demo.exceptions.NotFoundException;
import com.example.demo.model.Car;
import org.springframework.stereotype.Service;

@Service
public interface CarService {



    void add(Car car) throws DuplicateDataException;

    void delete(Car car) throws NotFoundException;
}
