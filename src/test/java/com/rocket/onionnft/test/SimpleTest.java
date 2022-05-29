package com.rocket.onionnft.test;

import com.rocket.onionnft.BaseTest;
import com.rocket.onionnft.model.entity.LayerEntity;
import com.rocket.onionnft.model.entity.NftEntity;
import com.rocket.onionnft.model.entity.UserEntity;
import com.rocket.onionnft.repository.LayerRepository;
import com.rocket.onionnft.repository.NftRepository;
import com.rocket.onionnft.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class SimpleTest extends BaseTest {

    @Autowired
    private LayerRepository layerRepository;
    @Autowired
    private NftRepository nftRepository;
    @Autowired
    private UserRepository userRepository;

    @Test
    void test1(){
        UserEntity allexandere = userRepository.save(UserEntity.builder()
                .username("Allexandere")
                .password("1234")
                .build());

        NftEntity nftEntity = nftRepository.save(new NftEntity());

        LayerEntity layerEntity = LayerEntity.builder()
                .price(10.5)
                .place(0)
                .url("abc")
                .parentNft(nftEntity)
                .userEntity(allexandere)
                .build();

        LayerEntity layerEntity1 = LayerEntity.builder()
                .price(15.5)
                .place(1)
                .url("def")
                .parentNft(nftEntity)
                .userEntity(allexandere)
                .build();

        layerRepository.save(layerEntity);
        layerRepository.save(layerEntity1);

        NftEntity nftEntity1 = nftRepository.findById(nftEntity.getId()).get();
        nftEntity1.setUserEntity(allexandere);

        NftEntity save = nftRepository.save(nftEntity1);
        System.out.println(save);

        System.out.println(userRepository.findById(allexandere.getId()).get());
    }

}
