package com.rocket.onionnft.model.dto;

import com.rocket.onionnft.model.entity.LayerEntity;
import lombok.Builder;
import lombok.Data;

import java.util.Set;
import java.util.UUID;

@Data
@Builder
public class ExternalUserDto {
    private UUID id;
    private String username;
    private String password;
    private Set<ExternalLayerDto> creations;
    private Set<ExternalNftDto> ownerships;
}
