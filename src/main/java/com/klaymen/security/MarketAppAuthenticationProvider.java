package com.klaymen.security;

import com.klaymen.domain.Customer;
import com.klaymen.service.AuthService;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.annotation.PostConstruct;
import javax.jws.WebMethod;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by petrovicu on 24/07/2018.
 */
@Component
public class MarketAppAuthenticationProvider implements AuthenticationProvider {

    private static final Logger LOGGER = LogManager.getLogger(MarketAppAuthenticationProvider.class);

    @Autowired
    private AuthService authService;

    @Override
    public Authentication authenticate(Authentication auth) throws AuthenticationException {
        String email = auth.getName();
        String password = auth.getCredentials().toString();

        List<GrantedAuthority> grantedAuths = new ArrayList<GrantedAuthority>();

        Customer dbCustomer = authService.authenticateUser(email, password);
        if (dbCustomer != null) {
            grantedAuths.add(new SimpleGrantedAuthority(UserRights.VALID_CUSTOMER.getValue()));
        } else {
            LOGGER.log(Level.DEBUG, "Customer authentication failed for: " + email);
            throw new BadCredentialsException("Customer authentication failed");
        }

        return new UsernamePasswordAuthenticationToken(email, auth.getCredentials(),
                grantedAuths);

    }

    @Override
    public boolean supports(Class<?> auth) {
        return auth.equals(UsernamePasswordAuthenticationToken.class);
    }


}
