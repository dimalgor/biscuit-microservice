package com.biscuit.microservice.web.controller;

import com.biscuit.microservice.services.ChocolateService;
import com.biscuit.microservice.web.model.ChocolateDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping // POST - create new chocolate
    public ResponseEntity handlePost(ChocolateDto chocolateDto) {
        ChocolateDto savedDto = chocolateService.saveNewChocolate(chocolateDto);
        HttpHeaders httpHeaders = new HttpHeaders();
        // todo add hostname to URL
        httpHeaders.add("Location", "api/v1/chocolate/" + savedDto.getId());
        return new ResponseEntity(httpHeaders, HttpStatus.CREATED);
    }

    @PutMapping("/{chocolateId}")
    public ResponseEntity handlePut(@PathVariable("chocolateId") Long chocolateID, ChocolateDto chocolateDto){
        chocolateService.updateChocolate(chocolateID, chocolateDto);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }


}
