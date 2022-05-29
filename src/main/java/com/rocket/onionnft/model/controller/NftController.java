package com.rocket.onionnft.model.controller;

import com.rocket.onionnft.model.dto.ExternalNftDto;
import com.rocket.onionnft.model.dto.ExternalUserDto;
import com.rocket.onionnft.model.exception.NftException;
import com.rocket.onionnft.model.exception.UserException;
import com.rocket.onionnft.model.service.NftService;
import com.rocket.onionnft.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/nft")
public class NftController {
    @Autowired
    private NftService nftService;

    @GetMapping("/{nftId}")
    public ExternalNftDto getNft(@PathVariable("nftId") UUID nftId) throws NftException {
        return nftService.getNft(nftId);
    }

    @PostMapping("")
    public ExternalNftDto createNft(@RequestBody ExternalNftDto externalNftDto) throws NftException {
        return nftService.createNft(externalNftDto);
    }

    @PostMapping("/buy")
    public ExternalNftDto buyNft(@RequestParam(name = "nftId") UUID nftId,
                                 @RequestParam(name = "buyerId") UUID buyerId){
        return nftService.buyNft(nftId, buyerId);
    }
}
