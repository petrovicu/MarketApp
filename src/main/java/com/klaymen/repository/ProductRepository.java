package com.klaymen.repository;

import com.klaymen.domain.BaseEntity;
import com.klaymen.domain.Product;
import org.springframework.stereotype.Repository;

/**
 * Created by petrovicu on 23/07/2018.
 */
@Repository
public interface ProductRepository extends BaseRepository<BaseEntity> {

    /**
     * @param id
     * @return
     */
    public Product getProductById(int id);


}
