package com.semicolon.quotes_generator.data.repository;

import com.semicolon.quotes_generator.data.model.UserQuote;
import com.semicolon.quotes_generator.exceptions.QuoteGeneratorException;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserQuoteRepository  extends MongoRepository<UserQuote, String> {


    UserQuote findByQuoteNumber(int quoteNumber) throws QuoteGeneratorException;
}
