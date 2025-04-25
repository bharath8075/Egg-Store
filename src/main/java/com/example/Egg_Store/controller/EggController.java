package com.example.Egg_Store.controller;

import com.example.Egg_Store.exception.EggTypeNotFoundException;
import com.example.Egg_Store.exception.InvalidEggTypeException;
import com.example.Egg_Store.model.Egg;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/egg-store")
public class EggController {

    private List<Egg> eggs = new ArrayList<>();
    public EggController(){
        eggs.add(new Egg(1, "chicken", 4.0));
        eggs.add(new Egg(2, "ostrich", 100.0));
        eggs.add(new Egg(3, "duck", 20.0));
    }
    @GetMapping("/get-price/{eggType}")
    public ResponseEntity<?> getPrice(@PathVariable String eggType){

        if(eggType == null || eggType.trim().isEmpty()){
            throw new InvalidEggTypeException("Egg type must require!!");
        }
        Egg foundEgg = eggs.stream()
                .filter(egg -> egg.getEggType().toLowerCase().equals(eggType))
                .findFirst()
                .orElseThrow( () -> new EggTypeNotFoundException(eggType + " not found!!"));

        return ResponseEntity.status(HttpStatus.ACCEPTED).body("The price of "+ eggType + " is " + foundEgg.getPrice());
    }

    @GetMapping("/session-id")
    public ResponseEntity<?> sessionIdCheck(HttpServletRequest request){
        return ResponseEntity.ok("Session ID - "+ request.getSession().getId());
    }

}
