package com.rocket.onionnft.model.service;

import com.rocket.onionnft.model.dto.ExternalLayerDto;
import com.rocket.onionnft.model.entity.LayerEntity;
import com.rocket.onionnft.model.entity.NftEntity;
import com.rocket.onionnft.model.mapper.LayerMapper;
import com.rocket.onionnft.repository.LayerRepository;
import com.rocket.onionnft.repository.NftRepository;
import com.rocket.onionnft.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LayerService {
    @Autowired
    private LayerRepository layerRepository;
    @Autowired
    private LayerMapper layerMapper;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private NftRepository nftRepository;

    public ExternalLayerDto createLayer(ExternalLayerDto layer){
        NftEntity parentNft = nftRepository.findById(layer.getParentNft()).get();

        int lastLayerPlace = parentNft.getLayers().stream()
                .mapToInt(LayerEntity::getPlace)
                .max()
                .orElse(-1);

        LayerEntity layerEntity = LayerEntity.builder()
                .userEntity(userRepository.findById(layer.getCreator()).get())
                .parentNft(parentNft)
                .place(lastLayerPlace + 1)
                .url(layer.getUrl())
                .price(layer.getPrice())
                .build();

        return layerMapper.mapLayerEntity(layerRepository.save(layerEntity));
    }

}
