package com.ecommerce.store.service;

import com.ecommerce.store.model.AddressSuggest;

import java.util.List;

/**
 * @author Uday Kiran Thota (tudaykr@yahoo.com)
 */
public interface AddressSuggestService {
    List<AddressSuggest> findAllAddresses(String pincode);
}
