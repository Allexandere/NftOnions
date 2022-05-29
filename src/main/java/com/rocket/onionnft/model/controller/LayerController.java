package com.rocket.onionnft.model.controller;

import com.rocket.onionnft.model.dto.ExternalLayerDto;
import com.rocket.onionnft.model.dto.ExternalNftDto;
import com.rocket.onionnft.model.exception.NftException;
import com.rocket.onionnft.model.exception.UserException;
import com.rocket.onionnft.model.service.LayerService;
import com.rocket.onionnft.model.service.NftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/layer")
public class LayerController {
    @Autowired
    private LayerService layerService;

    /*
    @GetMapping("/{layerId}")
    public ExternalLayerDto getNft(@PathVariable("layerId") UUID layerId) throws UserException, NftException {
        return layerService.;
    }
     */

    @PostMapping("")
    public ExternalLayerDto createNft(@RequestBody ExternalLayerDto externalLayerDto){
        return layerService.createLayer(externalLayerDto);
    }
}
