package com.semicolon.quotes_generator.data.repository;

import com.semicolon.quotes_generator.data.model.UserQuote;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserQuoteRepository  extends MongoRepository<UserQuote, String> {
}
