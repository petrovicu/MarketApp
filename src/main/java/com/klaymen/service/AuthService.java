package com.klaymen.service;

import com.klaymen.domain.Customer;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by petrovicu on 23/07/2018.
 */
@Service
@Transactional
public interface AuthService {

    /**
     *
     * @param email
     * @param password
     */
    public Customer authenticateUser(String email, String password);
}
