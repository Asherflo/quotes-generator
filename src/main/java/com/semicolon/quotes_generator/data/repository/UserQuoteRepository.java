package com.semicolon.quotes_generator.data.repository;

import com.semicolon.quotes_generator.data.model.UserQuote;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserQuoteRepository  extends MongoRepository<UserQuote, String> {
    UserQuote findByQuoteNumber(int quoteNumber);
    @NotNull Page<UserQuote> findAll(@NotNull Pageable pageable);
}
