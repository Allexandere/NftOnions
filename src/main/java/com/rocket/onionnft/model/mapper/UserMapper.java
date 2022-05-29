package com.rocket.onionnft.model.mapper;

import com.rocket.onionnft.model.dto.ExternalUserDto;
import com.rocket.onionnft.model.entity.UserEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private LayerMapper layerMapper;
    @Autowired
    private NftMapper nftMapper;

    public ExternalUserDto mapUserEntity(UserEntity userEntity){
        return ExternalUserDto.builder()
                .id(userEntity.getId())
                .username(userEntity.getUsername())
                .password(userEntity.getPassword())
                .creations(layerMapper.mapLayerEntities(userEntity.getCreations()))
                .ownerships(nftMapper.mapNftEntities(userEntity.getOwnerships()))
                .build();
    }
}
