package com.gumi.example.rql.users.infrastructure.rest.map;

import java.util.List;

import com.gumi.example.rql.users.domain.Address;
import com.gumi.example.rql.users.infrastructure.rest.model.AddressRestResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressRestMapper {

  AddressRestResponse toResponse(Address source);

  List<AddressRestResponse> toResponse(List<Address> source);
}
