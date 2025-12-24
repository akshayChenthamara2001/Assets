package com.example.assets.service;

import com.example.assets.dto.AssetRequest;
import com.example.assets.model.Asset;
import com.example.assets.repository.AssetRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class AssetService {
    
    private final AssetRepository assetRepository;
    public AssetService(AssetRepository assetRepository){
        this.assetRepository =assetRepository; 
    }

    public Asset createAsset(AssetRequest assetRequest) {
        String id = UUID.randomUUID().toString();
        Asset asset = new Asset(id, assetRequest.getName());
        asset.setCreatedAt(LocalDateTime.now());
        return assetRepository.save(asset);
    }

    public Optional<Asset> getAsset(String id) {
           Optional<Asset> assest = assetRepository.findById(id);
           return assest;
    }

    public Boolean deleteAsset(String id){
        Optional<Asset> assest = assetRepository.findById(id);
        if (assest.isPresent()){
            assetRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Asset update(Asset asset) {
        Asset asset1 = new Asset();
        Optional<Asset> assest = assetRepository.findById(asset.getId());
            if(assest !=null){
                asset1.setName(asset.getName());
                asset1.setUpdatedAt(LocalDateTime.now());
                return assetRepository.save(asset1);

            }
        return null;
    }

    public List<Asset> getAllAssets(){
        return assetRepository.findAll().stream().toList();
    }
}