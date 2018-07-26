package com.klaymen.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.session.data.redis.config.ConfigureRedisAction;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.web.http.HeaderHttpSessionIdResolver;
import org.springframework.session.web.http.HeaderHttpSessionStrategy;
import org.springframework.session.web.http.HttpSessionIdResolver;

/**
 * Created by petrovicu on 24/07/2018.
 */
@Configuration
@EnableRedisHttpSession
public class SessionConfig {

    @Bean
    public static ConfigureRedisAction configureRedisAction() {
        return ConfigureRedisAction.NO_OP;
    }

    @Bean
    public HeaderHttpSessionStrategy httpSessionStrategy() {
        return new HeaderHttpSessionStrategy();
    }

    @Bean
    public HttpSessionIdResolver httpSessionIdResolver() {
        return HeaderHttpSessionIdResolver.xAuthToken();
    }

    @Bean
    public JedisConnectionFactory redisConnectionFactory() {
        return new JedisConnectionFactory();
    }
}
