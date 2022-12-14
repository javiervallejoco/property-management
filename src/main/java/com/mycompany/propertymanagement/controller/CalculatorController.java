package com.mycompany.propertymanagement.controller;

import com.mycompany.propertymanagement.dto.CalculatorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/calculator")
public class CalculatorController {

    @GetMapping("/add")
    public Double add(
            @RequestParam("num1") Double num1,
            @RequestParam("num2") Double num2
            ) {
        return num1 + num2;
    }

    @GetMapping("/subtract/{num1}/{num2}")
    public Double subtract(
            @PathVariable("num1") Double num1,
            @PathVariable("num2") Double num2
            ) {
        var result = 0.0;

        if (num1 > num2) {
            result = num1 - num2;
        } else {
            result = num2 - num1;
        }

        return result;
    }

    @PostMapping("/multiply")
    public ResponseEntity<Double> multiply(
            @RequestBody CalculatorDTO dto
            ) {
        return new ResponseEntity<Double>(dto.getNum1() * dto.getNum2(), HttpStatus.CREATED);
    }

}
