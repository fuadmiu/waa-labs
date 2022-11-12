package edu.miu.lab05.service;


import edu.miu.lab05.domain.dto.request.LoginRequest;
import edu.miu.lab05.domain.dto.request.RefreshTokenRequest;
import edu.miu.lab05.domain.dto.response.LoginResponse;

public interface AuthService {
    LoginResponse login(LoginRequest loginRequest);
    LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
