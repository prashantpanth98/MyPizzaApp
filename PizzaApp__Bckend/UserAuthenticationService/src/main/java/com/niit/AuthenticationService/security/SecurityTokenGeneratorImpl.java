package com.niit.AuthenticationService.security;

import com.niit.AuthenticationService.domain.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class SecurityTokenGeneratorImpl implements ISecurityTokenGenerator{
    @Override
    public Map<String, String> tokenGenerator(User user) {
        Map<String, String> map=new HashMap<>();
        Map<String ,Object> userdata = new HashMap<>();
        userdata.put("email",user.getEmail());

        String jwtToken= Jwts.builder().setSubject(user.getEmail())
                                       .setClaims(userdata)
                                       .setIssuedAt(new Date())
                                       .signWith(SignatureAlgorithm.HS256,"secretkey")
                                       .compact();

        map.put("token", jwtToken);
        map.put("message", "User login Successful!");
        map.put("email", user.getEmail());

        return map;
    }
}
