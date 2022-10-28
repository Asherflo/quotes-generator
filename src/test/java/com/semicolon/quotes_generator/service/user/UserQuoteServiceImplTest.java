package com.semicolon.quotes_generator.service.user;

import com.semicolon.quotes_generator.data.model.UserQuote;
import com.semicolon.quotes_generator.data.repository.UserQuoteRepository;
import com.semicolon.quotes_generator.dtos.requests.CreateQuoteRequest;
import com.semicolon.quotes_generator.dtos.responses.CreateQuoteResponse;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserQuoteServiceImplTest {
    @Autowired
    private UserQuoteService userQuoteService;
    @Autowired
    private UserQuoteRepository userQuoteRepository;

    private CreateQuoteRequest quoteRequest;
    private CreateQuoteResponse quoteResponse;

    @BeforeEach
    void setUp() {
        userQuoteService = new UserQuoteServiceImpl(userQuoteRepository);

        quoteRequest = new CreateQuoteRequest();
        quoteRequest.setAuthor("Lady lee");
        quoteRequest.setQuoteNumber(1);
        quoteRequest.setQuote("Down the hills ,there's a snake called Arolake,find out yourself ");
        quoteResponse = userQuoteService.createUser(quoteRequest);
    }

    @AfterEach
    void tearDown(){
        userQuoteService.deleteAll();
    }

    @Test
    @DisplayName("User can be created")
    void testUserCanBeCreated(){
        assertNotNull(quoteResponse);
        assertEquals("Down the hills ,there's a snake called Arolake,find out yourself ", quoteResponse.getUserQuote().getQuote());
    }
    @Test
    @DisplayName("test that quote can be found")
    void testToFindQuoteByQuoteNumber(){
        UserQuote userQuote = userQuoteService.findByQuoteNumber(1);
        assertEquals(1,userQuote.getQuoteNumber());
    }
    @Test
    @DisplayName("test can be deleted")
    void testToDeleteByAll(){
        userQuoteService.createUser(quoteRequest);
        userQuoteService.deleteAll();
        assertEquals(0L,userQuoteRepository.count());
    }




}
