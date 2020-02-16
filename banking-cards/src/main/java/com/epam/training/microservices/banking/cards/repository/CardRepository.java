package com.epam.training.microservices.banking.cards.repository;

import com.epam.training.microservices.banking.cards.entity.Card;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path = "cards")
public interface CardRepository extends PagingAndSortingRepository<Card, Long> {
  List<Card> findAllByAccountId(@Param("accountId") Long accountId);
}
