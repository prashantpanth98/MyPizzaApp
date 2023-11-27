package com.niit.AuthenticationService.security;

import com.niit.AuthenticationService.domain.User;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface ISecurityTokenGenerator {
    public Map<String, String> tokenGenerator(User user);
}
