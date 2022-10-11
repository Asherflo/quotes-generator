package com.semicolon.quotes_generator.service.user;

import com.semicolon.quotes_generator.data.model.UserQuote;
import com.semicolon.quotes_generator.data.repository.UserQuoteRepository;
import com.semicolon.quotes_generator.dtos.requests.CreateQuoteRequest;
import com.semicolon.quotes_generator.dtos.responses.CreateQuoteResponse;
import lombok.RequiredArgsConstructor;
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

    private CreateQuoteRequest createQuoteRequest;

    @BeforeEach
    void setUp() {
        userQuoteService = new UserQuoteServiceImpl(userQuoteRepository);

        CreateQuoteRequest quoteRequest = new CreateQuoteRequest();
        quoteRequest.setAuthor("Lady lee");
        quoteRequest.setQuoteNumber(1);
        quoteRequest.setQuote("Down the hills ,there's a snake called Arolake,find out yourself ");

    }

    @Test
    @DisplayName("User can be created")
    void testUserCanBeCreated(){

        CreateQuoteRequest quoteRequest = new CreateQuoteRequest();
        quoteRequest.setAuthor("Lady lee");
        quoteRequest.setQuoteNumber(1);
        quoteRequest.setQuote("Down the hills ,there's a snake called Arolake,find out yourself ");
        CreateQuoteResponse quoteResponse = userQuoteService.createUser(quoteRequest);
        assertNotNull(quoteResponse);
    }
    @Test
    @DisplayName("test that quote can be find")
    void testToFindQuoteByQuoteNumber(){
        UserQuote userQuote = userQuoteService.findByQuoteNumber(1);
        assertEquals(1,userQuote.getQuoteNumber());
    }
    @Test
  @DisplayName("test can be deleted")
       void testToDeleteByAll(){

        CreateQuoteRequest quoteRequest = new CreateQuoteRequest();userQuoteService.createUser(quoteRequest);
        userQuoteService.deleteAll();

        assertFalse(userQuoteRepository.equals(quoteRequest));


}


    @Test
    @DisplayName("test to update")
    void testToUpdate(){

    }

}