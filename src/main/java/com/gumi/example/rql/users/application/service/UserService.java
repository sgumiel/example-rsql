package com.gumi.example.rql.users.application.service;

import java.util.List;

import com.gumi.example.rql.common.domain.RSQLQuery;
import com.gumi.example.rql.users.domain.User;

public interface UserService {

  List<User> findByRsqlQuery(RSQLQuery query);
}
