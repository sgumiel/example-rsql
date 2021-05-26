package com.gumi.example.rql.users.infrastructure.db.repository.aggregate.impl;

import java.util.List;

import com.gumi.example.rql.common.domain.RSQLQuery;
import com.gumi.example.rql.common.infrastructure.db.CustomRsqlVisitor;
import com.gumi.example.rql.users.domain.aggregate.AggregateUserAddress;
import com.gumi.example.rql.users.domain.repository.aggregate.AggregateUserAddressRepository;
import com.gumi.example.rql.users.infrastructure.db.map.aggregate.AggregateUserAddressDbMapper;
import com.gumi.example.rql.users.infrastructure.db.model.aggregate.AggregateUserAddressEntity;
import com.gumi.example.rql.users.infrastructure.db.repository.aggregate.jpa.AggregateUserAddressJpaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AggregateUserAddressRepositoryDbImpl implements AggregateUserAddressRepository {

  private final AggregateUserAddressJpaRepository aggregateUserAddressJpaRepository;
  private final AggregateUserAddressDbMapper aggregateUserAddressDbMapper;

  @Override
  public List<AggregateUserAddress> findByRsql(RSQLQuery query) {

    final var rootNode = query.getNode();
    final Specification<AggregateUserAddressEntity> spec = rootNode.accept(new CustomRsqlVisitor<>());
    final var userEntityList = this.aggregateUserAddressJpaRepository.findAll(spec);
    return this.aggregateUserAddressDbMapper.toDomain(userEntityList);
  }
}
