package com.biscuit.microservice.web.controller;

import com.biscuit.microservice.services.ChocolateService;
import com.biscuit.microservice.web.model.ChocolateDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/chocolate")
public class ChocolateController {
    private ChocolateService chocolateService;

    public ChocolateController(ChocolateService chocolateService) {
        this.chocolateService = chocolateService;
    }

    @GetMapping("/{chocolateId}")
    public ResponseEntity<ChocolateDto> getChocolate(@PathVariable("chocolateId") Long chocolateId) {
        return new ResponseEntity<>(chocolateService.getChocolateById(chocolateId), HttpStatus.OK);
    }

    @PostMapping // POST - create new chocolate
    public ResponseEntity handlePost(@RequestBody ChocolateDto chocolateDto) {
        ChocolateDto savedDto = chocolateService.saveNewChocolate(chocolateDto);
        HttpHeaders httpHeaders = new HttpHeaders();
        // todo add hostname to URL
        httpHeaders.add("Location", "api/v1/chocolate/" + savedDto.getId());
        return new ResponseEntity(httpHeaders, HttpStatus.CREATED);
    }

    @PutMapping("/{chocolateId}")
    public ResponseEntity handlePut(@PathVariable("chocolateId") Long chocolateID, @RequestBody ChocolateDto chocolateDto){
        chocolateService.updateChocolate(chocolateID, chocolateDto);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{chocolateId}")
    public void deleteChocolate(@PathVariable("chocolateId") Long chocolateId){
        chocolateService.deleteChocolate(chocolateId);
    }
}
