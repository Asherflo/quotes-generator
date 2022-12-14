package com.semicolon.quotes_generator.data.repository;

import com.semicolon.quotes_generator.data.model.WebQuote;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

@Repository
public interface WebQuoteRepository extends MongoRepository<WebQuote, String> {
    Optional<List<WebQuote>> findWebQuoteByAuthor(String author);
    Optional<WebQuote> findWebQuoteByQuote(String quote);
    Optional<WebQuote> findWebQuoteByQuoteNumber(int quoteNumber);
    boolean existsByQuote(String quote);
    @NotNull Page<WebQuote> findAll(@NotNull Pageable pageable);
}
