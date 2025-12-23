package com.example.assets.dto;

public class AssetRequest {

    private String name;

    public AssetRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
