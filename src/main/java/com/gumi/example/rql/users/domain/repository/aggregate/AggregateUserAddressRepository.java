package com.gumi.example.rql.users.domain.repository.aggregate;

import java.util.List;

import com.gumi.example.rql.common.domain.RSQLQuery;
import com.gumi.example.rql.users.domain.aggregate.AggregateUserAddress;

public interface AggregateUserAddressRepository {

  List<AggregateUserAddress> findByRsql(RSQLQuery query);
}
