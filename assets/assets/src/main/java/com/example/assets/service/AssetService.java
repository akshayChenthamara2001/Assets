package com.example.assets.service;

import com.example.assets.dto.AssetRequest;
import com.example.assets.model.Asset;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class AssetService {
    private Map<String, Asset> assests = new HashMap<>();

    public Asset createAsset(AssetRequest assetRequest) {
        String id = UUID.randomUUID().toString();
        Asset asset = new Asset(id, assetRequest.getName());
        asset.setCreatedAt(LocalDateTime.now());
        assests.put(id, asset);
        return asset;
    }

    public Asset getAsset(String id) {
        Asset asset = assests.get(id);
            if (asset != null) {
            return asset;
        }
        return null;
    }

    public Boolean deleteAsset(String id){
        Asset asset =assests.get(id);
        if (asset != null){
            asset.setDeleted(true);
            asset.setUpdatedAt(LocalDateTime.now());
            return true;
        }
        return false;
    }

    public Asset update(Asset asset) {
            Asset ast = assests.get(asset.getId());
            if(ast !=null){
            asset.setName(asset.getName());
            }
        return null;
    }

    public List<Asset> getAllAssets(){
        return assests.values().stream().toList();
    }
}