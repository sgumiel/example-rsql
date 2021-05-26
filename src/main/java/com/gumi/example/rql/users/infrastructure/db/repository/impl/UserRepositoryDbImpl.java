package com.gumi.example.rql.users.infrastructure.db.repository.impl;

import java.util.List;
import java.util.Optional;

import com.gumi.example.rql.common.domain.RSQLQuery;
import com.gumi.example.rql.common.infrastructure.db.CustomRsqlVisitor;
import com.gumi.example.rql.users.domain.User;
import com.gumi.example.rql.users.domain.repository.UserRepository;
import com.gumi.example.rql.users.infrastructure.db.map.UserDbMapper;
import com.gumi.example.rql.users.infrastructure.db.model.UserEntity;
import com.gumi.example.rql.users.infrastructure.db.repository.jpa.UserJpaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserRepositoryDbImpl implements UserRepository {

  private final UserJpaRepository userJpaRepository;
  private final UserDbMapper userDbMapper;

  @Override
  public Optional<User> findById(Long id) {
    return this.userJpaRepository.findById(id)
            .map(ue -> this.userDbMapper.toDomain(ue));
  }

  @Override
  public List<User> findAll() {
    final var listEntities = (List) this.userJpaRepository.findAll();

    final var list = this.userDbMapper.toDomain(listEntities);

    return list;
  }

  @Override
  public List<User> findByRsql(RSQLQuery query) {

    final var rootNode = query.getNode();
    final Specification<UserEntity> spec = rootNode.accept(new CustomRsqlVisitor<>());
    final var userEntityList = this.userJpaRepository.findAll(spec);
    return this.userDbMapper.toDomain(userEntityList);
  }
}
