package com.niit.PizzaService.filter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.http.HttpResponse;

public class JwtFilter extends GenericFilterBean {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest httpServletRequest=(HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse=(HttpServletResponse) servletResponse;

        String authHeader= httpServletRequest.getHeader("Authorization");
        System.out.println("Authheader = " +authHeader);
        ServletOutputStream servletOutputStream= httpServletResponse.getOutputStream();

        if(authHeader==null || !authHeader.startsWith("Bearer ")){
            System.out.println("Authheader = " +authHeader);
            httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            servletOutputStream.println("Missing or invalid Token");
            servletOutputStream.close();
        }

        else{
            System.out.println("Authheader = " +authHeader);
            String jwttoken=authHeader.substring(7);
            System.out.println("token ="+jwttoken);
            Claims claims = Jwts.parser().setSigningKey("secretkey").parseClaimsJws(jwttoken).getBody();
            httpServletRequest.setAttribute("claims",claims);
            System.out.println("Claim from token" + claims);

            filterChain.doFilter(httpServletRequest, httpServletResponse);
        }
    }
}
