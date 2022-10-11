package com.semicolon.quotes_generator.controller;

import com.semicolon.quotes_generator.dtos.responses.ApiResponse;
import com.semicolon.quotes_generator.dtos.responses.LoadQuoteResponse;
import com.semicolon.quotes_generator.service.web.WebQuoteService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/web-quote")
public class WebQuoteController {
    private final WebQuoteService webQuoteService;

    @GetMapping("/load-quotes")
    public ResponseEntity<?> loadQuotesToDatabase() {
        LoadQuoteResponse response = webQuoteService.loadWebQuotesToDatabase();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{pageNo}/{noOfItems}")
    public ResponseEntity<?> getAllBooks(
            @PathVariable(value = "pageNo", required = false) @DefaultValue({"0"}) @NonNull String pageNo,
            @PathVariable(value = "noOfItems", required = false) @DefaultValue({"10"}) @NonNull String numberOfItems) {

        Map<String, Object> pageResult = webQuoteService.findAll(Integer.parseInt(pageNo), Integer.parseInt(numberOfItems));
        ApiResponse apiResponse = ApiResponse.builder()
                .status("success")
                .message("pages returned")
                .data(pageResult)
                .result((int) pageResult.get("NumberOfElementsInPage"))
                .build();
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
}
