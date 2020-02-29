package com.example.demo.controller;

import com.example.demo.exceptions.DuplicateDataException;
import com.example.demo.exceptions.NotFoundException;
import com.example.demo.model.Car;
import com.example.demo.model.Card;
import com.example.demo.service.CarService;
import com.example.demo.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/v2/car")
@RestController
public class CarRestController {




    @Autowired
    CarService carService;


    @RequestMapping(method = RequestMethod.POST, path = "/addcar")
    public ResponseEntity addcar(@RequestBody Car car) throws DuplicateDataException {

        carService.add(car);
        return ResponseEntity.ok().build();
    }


    @RequestMapping(method = RequestMethod.GET, path = "/deletecar")
    public ResponseEntity deletecar(@RequestBody Car car) throws NotFoundException {

        carService.delete(car);
        return ResponseEntity.ok().build();


    }

}
