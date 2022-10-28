package com.semicolon.quotes_generator.controller;

import com.semicolon.quotes_generator.data.model.UserQuote;
import com.semicolon.quotes_generator.dtos.requests.CreateQuoteRequest;
import com.semicolon.quotes_generator.dtos.responses.ApiResponse;
import com.semicolon.quotes_generator.dtos.responses.CreateQuoteResponse;
import com.semicolon.quotes_generator.service.user.UserQuoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.Map;

@RestController

@RequestMapping("api/user")
@RequiredArgsConstructor
public class UserQuoteController {

    private final UserQuoteService userQuoteService;

    @PostMapping("/createQuote")
    public CreateQuoteResponse createUser(@RequestBody CreateQuoteRequest quoteRequest) {
        return userQuoteService.createUser(quoteRequest);
    }

    @GetMapping("/{quoteNumber}")
    public UserQuote findQuoteByQuoteNUmber(@PathVariable int quoteNumber) {
        return userQuoteService.findByQuoteNumber(quoteNumber);
    }

    @GetMapping("all/{pageNo}/{noOfItems}")
    public ResponseEntity<?> getAllBooks(
            @PathVariable(value = "pageNo", required = false) @DefaultValue({"0"}) @NotNull String pageNo,
            @PathVariable(value = "noOfItems", required = false) @DefaultValue({"10"}) @NotNull String numberOfItems){

        Map<String, Object> pageResult = userQuoteService.findAll(Integer.parseInt(pageNo), Integer.parseInt(numberOfItems));
        ApiResponse apiResponse = ApiResponse.builder()
                .status("success")
                .message("pages returned")
                .data(pageResult)
                .result((int)pageResult.get("NumberOfElementsInPage"))
                .build();
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }



}