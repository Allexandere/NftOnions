package com.rocket.onionnft.model.mapper;

import com.rocket.onionnft.model.dto.ExternalLayerDto;
import com.rocket.onionnft.model.dto.ExternalNftDto;
import com.rocket.onionnft.model.entity.LayerEntity;
import com.rocket.onionnft.model.entity.NftEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class NftMapper {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private LayerMapper layerMapper;

    public ExternalNftDto mapNftEntity(NftEntity nftEntity){
        return ExternalNftDto.builder()
                .id(nftEntity.getId())
                .layers(layerMapper.mapLayerEntities(nftEntity.getLayers()))
                .onSale(nftEntity.getOnSale())
                .owner(nftEntity.getUserEntity().getId())
                .sellPrice(nftEntity.getSellPrice())
                .name(nftEntity.getName())
                .url(nftEntity.getUrl())
                .build();
    }

    public Set<ExternalNftDto> mapNftEntities(Set<NftEntity> nfts){
        if(nfts == null){
            return Set.of();
        }
        return nfts.stream().map(this::mapNftEntity).collect(Collectors.toSet());
    }
}
