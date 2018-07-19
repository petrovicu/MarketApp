package com.vicert.repository;

import com.vicert.domain.BaseEntity;
import com.vicert.domain.Order;
import org.springframework.stereotype.Repository;

/**
 * Created by petrovicu on 19/07/2018.
 */
@Repository
public interface OrderRepository extends BaseRepository<BaseEntity> {

    public void createOrder(int id);

    public Order getOrderById(int id);

}
