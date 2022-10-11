package com.semicolon.quotes_generator.controller;

import com.semicolon.quotes_generator.data.model.UserQuote;
import com.semicolon.quotes_generator.dtos.requests.CreateQuoteRequest;
import com.semicolon.quotes_generator.dtos.responses.CreateQuoteResponse;
import com.semicolon.quotes_generator.service.user.UserQuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("api/user")
public class UserQuoteController {
    @Autowired
    private UserQuoteService userQuoteService;

    @PostMapping("/createQuote")
    public CreateQuoteResponse createUser(@RequestBody CreateQuoteRequest quoteRequest) {
        return userQuoteService.createUser(quoteRequest);
    }

    @GetMapping("/{quoteNumber}")
    public UserQuote findQuoteByQuoteNUmber(@PathVariable int quoteNumber) {
        return userQuoteService.findByQuoteNumber(quoteNumber);
    }

    @GetMapping("/all")
    public List<UserQuote> findAll() {
        return userQuoteService.findAll();
    }



}