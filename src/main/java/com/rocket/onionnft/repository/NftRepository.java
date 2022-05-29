package com.rocket.onionnft.repository;

import com.rocket.onionnft.model.entity.NftEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface NftRepository extends CrudRepository<NftEntity, UUID> {
    boolean existsByName(String name);
}
