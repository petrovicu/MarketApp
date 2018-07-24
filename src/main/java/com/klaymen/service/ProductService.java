package com.klaymen.service;

import com.klaymen.domain.Product;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by petrovicu on 24/07/2018.
 */
@Service
@Transactional
public interface ProductService {

    public Product getProductById(int id);
}
