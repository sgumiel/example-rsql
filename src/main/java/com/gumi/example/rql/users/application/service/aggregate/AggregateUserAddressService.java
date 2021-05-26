package com.gumi.example.rql.users.application.service.aggregate;

import java.util.List;

import com.gumi.example.rql.common.domain.RSQLQuery;
import com.gumi.example.rql.users.domain.aggregate.AggregateUserAddress;

public interface AggregateUserAddressService {

  List<AggregateUserAddress> findByRsqlQuery(RSQLQuery query);
}
