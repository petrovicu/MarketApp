package com.klaymen.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by petrovicu on 25/07/2018.
 */
@Configuration
public class WebSecurityCorsFilter extends OncePerRequestFilter {

    @Override
    public void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        res.setHeader("Access-Control-Expose-Headers", "x-auth-token");
        res.setHeader("Access-Control-Allow-Credentials", "x-auth-token");

        chain.doFilter(req, res);
    }
}