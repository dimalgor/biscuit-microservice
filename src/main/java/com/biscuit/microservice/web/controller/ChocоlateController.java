package com.biscuit.microservice.web.controller;

import com.biscuit.microservice.services.ChocolateService;
import com.biscuit.microservice.web.model.ChocolateDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/chocolate")
public class ChocоlateController {
    private ChocolateService chocolateService;

    public ChocоlateController(ChocolateService chocolateService) {
        this.chocolateService = chocolateService;
    }

    @GetMapping("/{chocolateId}")
    public ResponseEntity<ChocolateDto> getChocolate(@PathVariable("chocolateId") Long chocolateId) {
        return new ResponseEntity<>(chocolateService.getChocolateById(chocolateId), HttpStatus.OK);
    }
}
