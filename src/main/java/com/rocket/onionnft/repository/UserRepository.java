package com.rocket.onionnft.repository;

import com.rocket.onionnft.model.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, UUID> {
    boolean existsByUsername(String username);
}
