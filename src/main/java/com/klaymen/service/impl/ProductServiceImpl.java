package com.klaymen.service.impl;

import com.klaymen.domain.Product;
import com.klaymen.repository.ProductRepository;
import com.klaymen.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by petrovicu on 24/07/2018.
 */
@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product getProductById(int id) {
        return productRepository.getProductById(id);
    }
}
