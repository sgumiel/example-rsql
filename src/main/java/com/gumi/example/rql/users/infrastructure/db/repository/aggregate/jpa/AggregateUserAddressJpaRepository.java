package com.gumi.example.rql.users.infrastructure.db.repository.aggregate.jpa;

import com.gumi.example.rql.users.infrastructure.db.model.aggregate.AggregateUserAddressEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AggregateUserAddressJpaRepository
        extends CrudRepository<AggregateUserAddressEntity, Long>, JpaSpecificationExecutor<AggregateUserAddressEntity> {
}
