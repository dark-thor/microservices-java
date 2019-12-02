package com.ecommerce.store.service.impl;

import com.ecommerce.store.dao.AddressDao;
import com.ecommerce.store.service.AddressService;
import com.ecommerce.store.model.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author Uday Kiran Thota (tudaykr@yahoo.com)
 */
@Service("addressService")
@Transactional
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressDao addressDao;

    @Override
    public List<Address> getAddressList(Integer customerId) {
        return addressDao.getAddressList(customerId);
    }

    @Override
    public void saveAddress(Address address) {
        addressDao.saveAddress(address);
    }

    @Override
    public Address findbyId(Integer addressId) {
        return addressDao.findbyId(addressId);
    }

    @Override
    public void deleteAddress(Address address) {
        addressDao.deleteAddress(address);
    }

    @Override
    public void updateAddress(Address oldAddress, Address newAddress) {
        addressDao.updateAddress(oldAddress, newAddress);
    }
}
