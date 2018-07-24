package com.klaymen.service;

import com.klaymen.domain.Customer;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by petrovicu on 24/07/2018.
 */
@Service
@Transactional
public interface CustomerService {

    public Customer authenticateCustomer(String email, String password);
    public Customer getCustomerById(int id);
    public Customer getCustomerByEmail(String email);
}
