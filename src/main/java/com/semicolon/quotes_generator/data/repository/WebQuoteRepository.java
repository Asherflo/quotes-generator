package com.semicolon.quotes_generator.data.repository;

import com.semicolon.quotes_generator.data.model.WebQuote;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WebQuoteRepository extends MongoRepository<WebQuote, String> {
    Optional<WebQuote> findWebQuoteByAuthor(String author);
    Optional<WebQuote> findWebQuoteByQuote(String quote);
    Optional<WebQuote> findWebQuoteByQuoteNumber(int quoteNumber);
    boolean existsByQuote(String quote);
    Page<WebQuote> findAll(Pageable pageable);
}
