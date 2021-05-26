package com.gumi.example.rql.users.domain.repository;

import java.util.List;
import java.util.Optional;

import com.gumi.example.rql.common.domain.RSQLQuery;
import com.gumi.example.rql.users.domain.User;

public interface UserRepository {

  Optional<User> findById(Long id);

  List<User> findAll();

  List<User> findByRsql(RSQLQuery query);
}
