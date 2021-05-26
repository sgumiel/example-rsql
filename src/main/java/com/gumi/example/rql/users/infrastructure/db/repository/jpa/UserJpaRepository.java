package com.gumi.example.rql.users.infrastructure.db.repository.jpa;

import com.gumi.example.rql.users.infrastructure.db.model.UserEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserJpaRepository extends CrudRepository<UserEntity, Long>, JpaSpecificationExecutor<UserEntity> {
}
