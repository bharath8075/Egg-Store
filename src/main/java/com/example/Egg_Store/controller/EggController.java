package com.example.Egg_Store.controller;

import com.example.Egg_Store.exception.EggTypeNotFoundException;
import com.example.Egg_Store.exception.InvalidEggTypeException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/egg-store")
public class EggController {
    private static final Map<String, Double> EGG_PRIZE = Map.of(
            "regular", 5.0,
            "organic", 8.0,
            "free-size", 6.5
    );

    @GetMapping("/get-price/{eggType}")
    public ResponseEntity<?> getPrice(@PathVariable String eggType){

        if(eggType == null || eggType.trim().isEmpty()){
            throw new InvalidEggTypeException("Egg type must require!!");
        }
        Double price = EGG_PRIZE.get(eggType.toLowerCase());
        if(price == null){
            throw new EggTypeNotFoundException(eggType + " is not valid Egg type!!");
        }

        return ResponseEntity.status(HttpStatus.ACCEPTED).body("The price of "+ eggType + " is " + price);
    }

}
