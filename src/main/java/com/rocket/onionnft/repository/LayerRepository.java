package com.rocket.onionnft.repository;

import com.rocket.onionnft.model.entity.LayerEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LayerRepository extends CrudRepository<LayerEntity, UUID> {
}
