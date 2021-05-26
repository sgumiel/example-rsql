package com.gumi.example.rql.users.infrastructure.db.map;

import java.util.List;

import com.gumi.example.rql.users.domain.User;
import com.gumi.example.rql.users.infrastructure.db.model.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserDbMapper {

  UserEntity toEntity(User source);

  User toDomain(UserEntity source);

  List<User> toDomain(List<UserEntity> source);
}


