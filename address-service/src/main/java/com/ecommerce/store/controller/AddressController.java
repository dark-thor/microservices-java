package com.ecommerce.store.controller;

import com.ecommerce.store.service.AddressService;
import com.ecommerce.store.model.Address;
import com.ecommerce.store.model.AddressStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author Uday Kiran Thota (tudaykr@yahoo.com)
 */
@RestController
@RequestMapping("/v1/profile/customers/{customerId}/addresses/")
public class AddressController {

    static final Logger logger = LoggerFactory.getLogger(AddressController.class);

    @Autowired
    AddressService addressService;

    @Autowired
    MessageSource messageSource;

    /**
     * This function returns default addresses for a customer.
     * @param customerId id of the customer
     * @return default Address
     * @throws Exception
     */
    @RequestMapping(value = "/defaultAddress", method = RequestMethod.GET)
    public ResponseEntity<Address> getDefaultAddress(@PathVariable Integer customerId) throws Exception {
        List<Address> addresses = addressService.getAddressList(customerId);
        if (addresses.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        return ResponseEntity.ok(addresses.get(0));
    }

    /**
     * This function returns list of addresses for a customer
     * with first entry as default address.
     * @param customerId customer of the specified address.
     * @return list of customer addresses.
     * @throws Exception
     */
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Address>> getAddresses(@PathVariable Integer customerId) throws Exception {
        return ResponseEntity.ok(addressService.getAddressList(customerId));
    }

    /**
     * Retrieve an address by addressId for customer
     * @param customerId customer of the specified address.
     * @param addressId address to be fetched
     * @return a customer address.
     * @throws Exception
     */
    @RequestMapping(value = "/{addressId}", method = RequestMethod.GET)
    public ResponseEntity<Address> getAddressById(@PathVariable Integer customerId,
                                                  @PathVariable Integer addressId)
            throws Exception {
        Address address = addressService.findbyId(addressId);
        if (address == null
                || !customerId.equals(address.getCustomerId())
                || address.getStatus() != AddressStatus.ACTIVE)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return ResponseEntity.ok(address);
    }

    /**
     * This method is used to add a new address
     * @param address an address to be added
     * @param result used for input errors
     * @return status
     * @throws Exception
     */
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<String> addAddress(@PathVariable Integer customerId,
                             @RequestBody @Valid Address address,
                           BindingResult result) throws Exception {
        if (result != null && result.hasErrors()) {
            return ResponseEntity.badRequest().body("error");
        }

        address.setCustomerId(customerId);
        addressService.saveAddress(address);
        return ResponseEntity.status(201).body("created");
    }

    /**
     * Delete an address with given addressId
     * @param customerId customer of the specified address.
     * @param addressId address to be deleted
     * @return status
     * @throws Exception
     */
    @RequestMapping(value = "/{addressId}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteAddress(@PathVariable Integer customerId,
                                                @PathVariable Integer addressId)
            throws Exception {
        Address address = addressService.findbyId(addressId);

        if (address == null
                || !customerId.equals(address.getCustomerId())
                || address.getStatus() != AddressStatus.ACTIVE)
            return new ResponseEntity<String>(HttpStatus.NOT_FOUND);

        addressService.deleteAddress(address);
        return ResponseEntity.ok("success");
    }

    /**
     * Update an address for a customer with given customerId
     * @param customerId customer of the specified address.
     * @param entity address entity with new data
     * @param result used for input errors
     * @param addressId address to be updated
     * @return status
     * @throws Exception
     */
    @RequestMapping(value = "/{addressId}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateAddress(@PathVariable Integer customerId,
                                              @RequestBody @Valid Address entity,
                                              BindingResult result,
                                              @PathVariable Integer addressId)
            throws Exception {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body("error");
        }

        Address address = addressService.findbyId(addressId);

        if (address == null
                || !customerId.equals(address.getCustomerId())
                || address.getStatus() != AddressStatus.ACTIVE)
            return new ResponseEntity<String>(HttpStatus.NOT_FOUND);

        addressService.updateAddress(address, entity);
        return ResponseEntity.ok("success");
    }
}
