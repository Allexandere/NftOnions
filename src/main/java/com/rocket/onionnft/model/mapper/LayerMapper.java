package com.rocket.onionnft.model.mapper;

import com.rocket.onionnft.model.dto.ExternalLayerDto;
import com.rocket.onionnft.model.dto.ExternalUserDto;
import com.rocket.onionnft.model.entity.LayerEntity;
import com.rocket.onionnft.model.entity.UserEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class LayerMapper {
    @Autowired
    private ModelMapper modelMapper;

    public ExternalLayerDto mapLayerEntity(LayerEntity layerEntity){
        return ExternalLayerDto.builder()
                .id(layerEntity.getId())
                .createDate(layerEntity.getCreateDate())
                .creator(layerEntity.getUserEntity().getId())
                .parentNft(layerEntity.getParentNft().getId())
                .price(layerEntity.getPrice())
                .url(layerEntity.getUrl())
                .build();
    }

    public Set<ExternalLayerDto> mapLayerEntities(Set<LayerEntity> layers){
        if(layers == null){
            return Set.of();
        }
        return layers.stream().map(this::mapLayerEntity).collect(Collectors.toSet());
    }
}
