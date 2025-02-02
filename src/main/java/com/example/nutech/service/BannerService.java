package com.example.nutech.service;

import com.example.nutech.dto.response.BannerResponse;
import com.example.nutech.dto.response.ResponseDTO;

public interface BannerService {
    ResponseDTO<BannerResponse> bannerAll();
}
