package com.example.assets.controller;

import com.example.assets.dto.AssetRequest;
import com.example.assets.model.Asset;
import com.example.assets.service.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assests")
public class AssetController {
@Autowired
    private AssetService assetService;
@GetMapping("/getAsset/{id}")
public Asset getAssestbyId(@PathVariable String id){
    return assetService.getAsset(id);
}

  @GetMapping("/getAllAsset")
   public List<Asset> getAllAsset(){
        return assetService.getAllAssets();
    }

    @PostMapping("/create")
    public Asset createAsset(@RequestBody AssetRequest assetRequest){
        return assetService.createAsset(assetRequest);

    }

    @DeleteMapping ("/delete/{id}")
    public String deleteAsset(@PathVariable String id){
    assetService.deleteAsset(id);
    return "Deleted Successfully";
    }

    @PatchMapping("/update")
    public Asset update(@RequestBody Asset asset){

    return assetService.update(asset);
    }
}

