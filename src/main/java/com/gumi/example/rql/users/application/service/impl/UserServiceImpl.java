package com.gumi.example.rql.users.application.service.impl;

import java.util.List;

import com.gumi.example.rql.common.domain.RSQLQuery;
import com.gumi.example.rql.users.application.service.UserService;
import com.gumi.example.rql.users.domain.User;
import com.gumi.example.rql.users.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;

  @Override
  public List<User> findByRsqlQuery(RSQLQuery query) {

    log.debug("RSQLQuery: {}", query);
    return this.userRepository.findByRsql(query);
  }
}
