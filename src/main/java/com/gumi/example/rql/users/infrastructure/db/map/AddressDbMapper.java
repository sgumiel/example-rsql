package com.gumi.example.rql.users.infrastructure.db.map;

import java.util.List;

import com.gumi.example.rql.users.domain.Address;
import com.gumi.example.rql.users.domain.User;
import com.gumi.example.rql.users.infrastructure.db.model.AddressEntity;
import com.gumi.example.rql.users.infrastructure.db.model.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressDbMapper {

  AddressEntity toEntity(Address source);

  Address toDomain(AddressEntity source);

  List<Address> toDomain(List<AddressEntity> source);
}


