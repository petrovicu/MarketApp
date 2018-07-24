package com.klaymen.repository;

import com.klaymen.domain.BaseEntity;
import com.klaymen.domain.Customer;
import org.springframework.stereotype.Repository;

/**
 * Created by petrovicu on 23/07/2018.
 */
@Repository
public interface CustomerRepository extends BaseRepository<BaseEntity> {

    /**
     *
     * @param email
     * @param password
     * @return
     */
    public Customer authenticateCustomer(String email, String password);

    /**
     *
     * @param email
     * @return
     */
    public Customer getCustomerByEmail(String email);

    /**
     *
     * @param id
     * @return
     */
    public Customer getCustomerById(int id);

}
