package com.example.nutech.service.impl;

import com.example.nutech.dto.response.BannerResponse;
import com.example.nutech.dto.response.ResponseDTO;
import com.example.nutech.entity.Banner;
import com.example.nutech.repository.BannerRepository;
import com.example.nutech.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BannerServiceImpl implements BannerService {

    @Autowired
    private BannerRepository bannerRepository;

    @Override
    public ResponseDTO<BannerResponse> bannerAll() {
        List<Banner> banner = bannerRepository.findAll();
        BannerResponse bannerResponse = new BannerResponse();
        return null;
    }
}
