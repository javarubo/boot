package com.example.demo.service.impl;

import com.example.demo.exceptions.DuplicateDataException;
import com.example.demo.exceptions.NotFoundException;
import com.example.demo.model.Car;
import com.example.demo.model.Card;
import com.example.demo.repository.CarRepository;
import com.example.demo.repository.CardRepository;
import com.example.demo.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    CarRepository carRepository;

    @Override
    public void add(Car car) throws DuplicateDataException {

        boolean exists = carRepository.existsByNumber(car.getNumber());
        DuplicateDataException.check(exists, "car.already.exist");

        carRepository.save(car);


    }

    @Override
    public void delete(Car car) throws NotFoundException {
        boolean exists = carRepository.existsByNumber(car.getNumber());

        NotFoundException.check(!exists, "car.not.found");

        carRepository.delete(car);
    }


}