package com.gumi.example.rql.users.infrastructure.db.map.aggregate;

import java.util.List;

import com.gumi.example.rql.users.domain.aggregate.AggregateUserAddress;
import com.gumi.example.rql.users.infrastructure.db.map.AddressDbMapper;
import com.gumi.example.rql.users.infrastructure.db.model.aggregate.AggregateUserAddressEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {AddressDbMapper.class})
public interface AggregateUserAddressDbMapper {

  AggregateUserAddress toDomain(AggregateUserAddressEntity source);

  List<AggregateUserAddress> toDomain(List<AggregateUserAddressEntity> source);
}
