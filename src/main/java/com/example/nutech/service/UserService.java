package com.example.nutech.service;

import com.example.nutech.dto.request.LoginUserRequest;
import com.example.nutech.dto.request.ProfileUpdateRequestDTO;
import com.example.nutech.dto.response.ProfileResponseDTO;
import com.example.nutech.dto.response.ResponseDTO;
import com.example.nutech.dto.response.TokenDTO;
import com.example.nutech.entity.User;
import org.springframework.web.multipart.MultipartFile;

public interface UserService {
    ResponseDTO<Void> registration(User user);
    ResponseDTO<TokenDTO> login(LoginUserRequest request);
    ResponseDTO<ProfileResponseDTO> getProfile(String token);
    ResponseDTO<ProfileResponseDTO> updateProfile(String token, ProfileUpdateRequestDTO updateRequestDTO);
    ResponseDTO<ProfileResponseDTO> uploadProfileImage(String token, MultipartFile file);
}
