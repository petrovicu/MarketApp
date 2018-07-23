package com.klaymen.repository;

import com.klaymen.domain.BaseEntity;
import com.klaymen.domain.Customer;
import org.springframework.stereotype.Repository;

/**
 * Created by petrovicu on 23/07/2018.
 */
@Repository
public interface AuthRepository extends BaseRepository<BaseEntity> {

    /**
     *
     * @param email
     * @param password
     * @return
     */
    public Customer authenticateUser(String email, String password);

}
