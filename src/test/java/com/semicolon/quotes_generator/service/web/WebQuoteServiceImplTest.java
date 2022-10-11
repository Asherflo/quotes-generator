package com.semicolon.quotes_generator.service.web;

import com.semicolon.quotes_generator.QuoteGeneratorDto;
import com.semicolon.quotes_generator.data.model.WebQuote;
import com.semicolon.quotes_generator.data.repository.WebQuoteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest

class WebQuoteServiceImplTest {
    @Autowired
    private WebQuoteService webQuoteService;

    @Autowired
    private WebQuoteRepository webQuoteRepository;

    private WebQuote quoteGeneratorDto;
    @BeforeEach
    void setUp() {
//        webQuoteService = new WebQuoteServiceImpl();

        QuoteGeneratorDto quoteGeneratorDto =
                QuoteGeneratorDto.builder()
                        .quote("pay")
                        .build();


    }


    @Test
    public void canFindWebQuoteByQuoteTest(){

        assertEquals("hard work pays", quoteGeneratorDto.getQuote());

    }


    @Test
    public void canFindWebQuoteByAuthorTest(){
//        WebQuote webQuote = new WebQuote();
//        webQuote.setAuthor("author");

//        webQuoteService.findWebQuoteByQuote(quoteGeneratorDto.getQuote());
        assertEquals("author", quoteGeneratorDto.getAuthor());
    }

    @Test
    public void canFindWebQuoteByQuoteNumberTest(){

        WebQuote webQuote = new WebQuote();
//        webQuote.setQuoteNumber(1);
        webQuoteRepository.save(webQuote);
        quoteGeneratorDto = webQuoteRepository.save(webQuote);
        assertEquals(1, quoteGeneratorDto.getQuoteNumber());
    }
}