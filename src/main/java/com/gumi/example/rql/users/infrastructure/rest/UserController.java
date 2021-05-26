package com.gumi.example.rql.users.infrastructure.rest;

import java.util.List;

import com.gumi.example.rql.common.domain.RSQLQuery;
import com.gumi.example.rql.users.application.service.UserService;
import com.gumi.example.rql.users.domain.repository.UserRepository;
import com.gumi.example.rql.users.infrastructure.rest.map.UserRestMapper;
import com.gumi.example.rql.users.infrastructure.rest.model.UserRestResponse;
import com.sun.istack.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {

  private final UserRepository userRepository;
  private final UserRestMapper userRestMapper;
  private final UserService userService;

  @GetMapping
  public ResponseEntity<List<UserRestResponse>> findAll() {

    final var list = this.userRepository.findAll();
    final var listResponse = this.userRestMapper.toResponse(list);
    return ResponseEntity.ok(listResponse);
  }

  @GetMapping("/rsql")
  public ResponseEntity<List<UserRestResponse>> findByRsql(@NotNull @RequestParam("filter") String filter) {

    log.debug("RSQL Filter: {}", filter);
    final var rsqlQuery = new RSQLQuery(filter);
    final var list = this.userService.findByRsqlQuery(rsqlQuery);
    final var listResponse = this.userRestMapper.toResponse(list);
    return ResponseEntity.ok(listResponse);
  }
}
