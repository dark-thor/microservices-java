package com.ecommerce.store.service.impl;

import com.ecommerce.store.repository.AddressSuggestRepository;
import com.ecommerce.store.model.AddressSuggest;
import com.ecommerce.store.service.AddressSuggestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Uday Kiran Thota (tudaykr@yahoo.com)
 */
@Service
public class AddressSuggestServiceImpl implements AddressSuggestService {
    @Autowired
    AddressSuggestRepository repository;

    static private final Logger logger = LoggerFactory.getLogger(AddressSuggestServiceImpl.class);

    @Override
    @Cacheable("addressSuggest")
    public List<AddressSuggest> findAllAddresses(String pincode) {
        return repository.findByPincode(pincode);
    }
}
