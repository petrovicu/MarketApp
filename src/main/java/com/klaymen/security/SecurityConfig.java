package com.klaymen.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.savedrequest.NullRequestCache;

/**
 * Created by petrovicu on 23/07/2018.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MarketAppAuthenticationProvider marketAppAuthenticationProvider;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(marketAppAuthenticationProvider);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/auth/**").permitAll()
                .antMatchers("/h2_console/**").permitAll()
                .antMatchers("/secured/**").authenticated()
                .anyRequest().authenticated()
                .and()
                .requestCache()
                .requestCache(new NullRequestCache())
                .and().httpBasic();

        //These are needed to enable H2 console - it runs inside a frame
        http.csrf().disable();
        http.headers().frameOptions().disable();

        //No cookies
        //http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }
}
