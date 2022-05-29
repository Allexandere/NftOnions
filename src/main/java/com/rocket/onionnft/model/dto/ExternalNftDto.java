package com.rocket.onionnft.model.dto;

import com.rocket.onionnft.model.entity.LayerEntity;
import lombok.Builder;
import lombok.Data;

import java.util.Set;
import java.util.UUID;

@Data
@Builder
public class ExternalNftDto {
    private UUID id;
    private UUID owner;
    private Set<ExternalLayerDto> layers;
    private Boolean onSale;
    private Double sellPrice;
    private String name;
    private String url;
}
