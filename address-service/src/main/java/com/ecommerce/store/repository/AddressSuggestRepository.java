package com.ecommerce.store.repository;

import com.ecommerce.store.model.AddressSuggest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Uday Kiran Thota (tudaykr@yahoo.com)
 */
@Repository
public interface AddressSuggestRepository extends JpaRepository<AddressSuggest, Integer> {
    List<AddressSuggest> findByPincode(String pincode);
}
