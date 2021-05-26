package com.gumi.example.rql.users.infrastructure.rest.map;

import java.util.List;

import com.gumi.example.rql.users.domain.User;
import com.gumi.example.rql.users.infrastructure.rest.model.UserRestResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserRestMapper {

  UserRestResponse toResponse(User source);

  List<UserRestResponse> toResponse(List<User> source);
}
