package com.ecommerce.store.controller;

import com.ecommerce.store.model.AddressSuggest;
import com.ecommerce.store.service.AddressSuggestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Uday Kiran Thota (tudaykr@yahoo.com)
 */
@RestController
@RequestMapping("/v1/pincodes")
public class AddressSuggestController {
    @Autowired
    AddressSuggestService addressSuggestService;

    static private final Logger logger = LoggerFactory.getLogger(AddressSuggestController.class);

    /**
     * @param pincode input pincode or zip code.
     * @return list of address suggestions for a given pincode
     * @throws Exception
     */
    @RequestMapping(value = "/{pincode}", method = RequestMethod.GET)
    public List<AddressSuggest> getAddresses(@PathVariable String pincode) throws Exception {
        return addressSuggestService.findAllAddresses(pincode);
    }
}
