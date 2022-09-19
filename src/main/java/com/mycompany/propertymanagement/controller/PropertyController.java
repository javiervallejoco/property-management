package com.mycompany.propertymanagement.controller;

import com.mycompany.propertymanagement.dto.PropertyDTO;
import com.mycompany.propertymanagement.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class PropertyController {

    @Value("${pms.greeting:}")
    private String greeting;

    @Autowired
    PropertyService service;

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, World!";
    }

    @PostMapping("/properties")
    public ResponseEntity<PropertyDTO> save(
            @RequestBody PropertyDTO dto
    ) {
        dto = service.save(dto);
        return new ResponseEntity<PropertyDTO>(dto, HttpStatus.CREATED);
    }

    @GetMapping("/properties")
    public ResponseEntity<List<PropertyDTO>> getAll() {
        System.out.println(greeting);
        System.out.println("Git test");
        List<PropertyDTO> dtoList = service.getAllProperties();
        return new ResponseEntity<List<PropertyDTO>>(dtoList, HttpStatus.OK);
    }

    @PutMapping("/properties/{id}")
    public ResponseEntity<PropertyDTO> update(
            @RequestBody PropertyDTO dto,
            @PathVariable Long id
    ) {
        return new ResponseEntity<PropertyDTO>(service.update(dto, id), HttpStatus.CREATED);
    }

    @PatchMapping("/properties/description/{id}")
    public ResponseEntity<PropertyDTO> updateDescription(
            @RequestBody PropertyDTO dto,
            @PathVariable Long id
    ) {
        return new ResponseEntity<PropertyDTO>(service.updateDescription(dto, id), HttpStatus.OK);
    }

    @PatchMapping("/properties/price/{id}")
    public ResponseEntity<PropertyDTO> updatePrice(
            @RequestBody PropertyDTO dto,
            @PathVariable Long id
    ) {
        return new ResponseEntity<PropertyDTO>(service.updatePrice(dto, id), HttpStatus.OK);
    }

    @DeleteMapping("/properties/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable Long id
    ) {
        service.delete(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
