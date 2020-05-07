package com.biscuit.microservice.web.controller.v2;

import com.biscuit.microservice.services.v2.ChocolateServiceV2;
import com.biscuit.microservice.web.model.v2.ChocolateDtoV2;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v2/chocolate")
public class ChocolateControllerV2 {
    private ChocolateServiceV2 chocolateServiceV2;

    public ChocolateControllerV2(ChocolateServiceV2 chocolateServiceV2) {
        this.chocolateServiceV2 = chocolateServiceV2;
    }

    @GetMapping("/{chocolateId}")
    public ResponseEntity<ChocolateDtoV2> getChocolate(@PathVariable("chocolateId") Long chocolateId) {
        return new ResponseEntity<ChocolateDtoV2>(chocolateServiceV2.getChocolateById(chocolateId), HttpStatus.OK);
    }

    @PostMapping // POST - create new chocolate
    public ResponseEntity handlePost(@RequestBody ChocolateDtoV2 chocolateDtoV2) {
        ChocolateDtoV2 savedDto = chocolateServiceV2.saveNewChocolate(chocolateDtoV2);
        HttpHeaders httpHeaders = new HttpHeaders();
        // todo add hostname to URL
        httpHeaders.add("Location", "api/v1/chocolate/" + savedDto.getId());
        return new ResponseEntity(httpHeaders, HttpStatus.CREATED);
    }

    @PutMapping("/{chocolateId}")
    public ResponseEntity handlePut(@PathVariable("chocolateId") Long chocolateID, @RequestBody ChocolateDtoV2 chocolateDtoV2) {
        chocolateServiceV2.updateChocolate(chocolateID, chocolateDtoV2);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{chocolateId}")
    public void deleteChocolate(@PathVariable("chocolateId") Long chocolateId) {
        chocolateServiceV2.deleteChocolate(chocolateId);
    }
}
