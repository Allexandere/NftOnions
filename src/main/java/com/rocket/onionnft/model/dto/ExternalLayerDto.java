package com.rocket.onionnft.model.dto;

import com.rocket.onionnft.model.entity.LayerEntity;
import com.rocket.onionnft.model.entity.NftEntity;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.Set;
import java.util.UUID;

@Data
@Builder
public class ExternalLayerDto {
    private UUID id;
    private UUID creator;
    private Date createDate;
    private UUID parentNft;
    private Double price;
    private String url;
}
