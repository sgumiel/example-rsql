package com.gumi.example.rql.users.application.service.aggregate.impl;

import javax.transaction.Transactional;
import java.util.List;

import com.gumi.example.rql.common.domain.RSQLQuery;
import com.gumi.example.rql.users.application.service.aggregate.AggregateUserAddressService;
import com.gumi.example.rql.users.domain.aggregate.AggregateUserAddress;
import com.gumi.example.rql.users.domain.repository.aggregate.AggregateUserAddressRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AggregateUserAddressServiceImpl implements AggregateUserAddressService {

  private final AggregateUserAddressRepository aggregateUserAddressRepository;

  @Transactional
  @Override
  public List<AggregateUserAddress> findByRsqlQuery(RSQLQuery query) {

    log.debug("RSQLQuery: {}", query);
    return this.aggregateUserAddressRepository.findByRsql(query);
  }
}
