package com.klaymen.security;

import com.klaymen.domain.Customer;
import com.klaymen.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by petrovicu on 24/07/2018.
 */
@Component
public class MarketAppAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private CustomerService customerService;

    @Override
    public Authentication authenticate(Authentication auth) throws AuthenticationException {
        String email = auth.getName();
        String password = auth.getCredentials().toString();

        List<GrantedAuthority> grantedAuths = new ArrayList<GrantedAuthority>();

        Customer dbCustomer = customerService.authenticateCustomer(email, password);
        if (dbCustomer != null) {
            grantedAuths.add(new SimpleGrantedAuthority(UserRights.VALID_CUSTOMER.getValue()));
        } else {
            throw new BadCredentialsException("Customer authentication failed");
        }

        Authentication user = new UsernamePasswordAuthenticationToken(email, auth.getCredentials(), grantedAuths);
        // Add the authentication to the Security context
        SecurityContextHolder.getContext().setAuthentication(user);

        return user;

    }

    @Override
    public boolean supports(Class<?> auth) {
        return auth.equals(UsernamePasswordAuthenticationToken.class);
    }


}
