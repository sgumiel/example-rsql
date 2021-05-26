package com.gumi.example.rql.users.infrastructure.rest.map.aggregate;

import java.util.List;

import com.gumi.example.rql.users.domain.aggregate.AggregateUserAddress;
import com.gumi.example.rql.users.infrastructure.rest.map.AddressRestMapper;
import com.gumi.example.rql.users.infrastructure.rest.model.aggregate.AggregateUserAddressRestResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {AddressRestMapper.class})
public interface AggregateUserAddressRestMapper {

  AggregateUserAddressRestResponse toResponse(AggregateUserAddress source);

  List<AggregateUserAddressRestResponse> toResponse(List<AggregateUserAddress> source);
}
