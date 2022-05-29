package com.rocket.onionnft.model.service;

import com.rocket.onionnft.model.dto.ExternalNftDto;
import com.rocket.onionnft.model.entity.NftEntity;
import com.rocket.onionnft.model.entity.UserEntity;
import com.rocket.onionnft.model.exception.NftException;
import com.rocket.onionnft.model.mapper.NftMapper;
import com.rocket.onionnft.repository.NftRepository;
import com.rocket.onionnft.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class NftService {
    @Autowired
    private NftMapper nftMapper;
    @Autowired
    private NftRepository nftRepository;
    @Autowired
    private UserRepository userRepository;

    private static final String NFT_WAS_NOT_FOUND = "NFT was not found";
    private static final String NFT_NAME_MUST_BE_UNIQUE = "NFT name must be unique";

    public ExternalNftDto createNft(ExternalNftDto nft) throws NftException {
        if(nftRepository.existsByName(nft.getName())){
            throw new NftException(NFT_NAME_MUST_BE_UNIQUE);
        }
        NftEntity nftEntity = NftEntity.builder()
                .userEntity(userRepository.findById(nft.getOwner()).get())
                .name(nft.getName())
                .onSale(false)
                .sellPrice(0.0)
                .build();

        return nftMapper.mapNftEntity(nftRepository.save(nftEntity));
    }

    public ExternalNftDto getNft(UUID id) throws NftException {
        Optional<NftEntity> foundNft = nftRepository.findById(id);
        if (foundNft.isEmpty()) {
            throw new NftException(NFT_WAS_NOT_FOUND);
        }
        return nftMapper.mapNftEntity(foundNft.get());
    }

    public ExternalNftDto buyNft(UUID nftId, UUID buyerId) {
        NftEntity nftEntity = nftRepository.findById(nftId).get();
        UserEntity userEntity = userRepository.findById(buyerId).get();
        nftEntity.setUserEntity(userEntity);
        return nftMapper.mapNftEntity(nftRepository.save(nftEntity));
    }
}
