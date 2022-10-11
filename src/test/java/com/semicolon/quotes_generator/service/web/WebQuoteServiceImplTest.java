package com.semicolon.quotes_generator.service.web;


import com.semicolon.quotes_generator.data.model.WebQuote;
import com.semicolon.quotes_generator.data.repository.WebQuoteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest

class WebQuoteServiceImplTest {
    @Autowired
    private WebQuoteService webQuoteService;

    @Autowired
    private WebQuoteRepository webQuoteRepository;
    @Autowired
    private RestTemplate restTemplate;

    @BeforeEach
    void setUp() {
        webQuoteService = new WebQuoteServiceImpl(restTemplate, webQuoteRepository);
    }

    @Test
    public void canFindWebQuoteByQuoteTest(){
       WebQuote foundWebQuote =  webQuoteService.findWebQuoteByQuote("Culture is the most powerful force in humanity under God");
       assertEquals(18, foundWebQuote.getQuoteNumber());
        assertNotNull(foundWebQuote);
    }


    @Test
    public void canFindWebQuoteByAuthorTest(){
        List<WebQuote> webQuoteList = webQuoteService.findWebQuoteByAuthor("Kanye West");
        assertNotNull(webQuoteList);
    }

    @Test
    public void canFindWebQuoteByQuoteNumberTest(){
        WebQuote foundWebQuote = webQuoteService.findWebQuoteByQuoteNumber(1);
        assertEquals("One day I'm gon' marry a porn star", foundWebQuote.getQuote());
    }
}