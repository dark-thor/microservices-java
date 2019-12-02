package com.ecommerce.store.service;

import com.ecommerce.store.model.Address;

import java.util.List;

/**
 * @author Uday Kiran Thota (tudaykr@yahoo.com)
 */
public interface AddressService {
    List<Address> getAddressList(Integer customerId);

    void saveAddress(Address address);

    Address findbyId(Integer addressId);

    void deleteAddress(Address address);

    void updateAddress(Address oldAddress, Address newAddress);
}
