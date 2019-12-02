package com.ecommerce.store.dao.impl;

import com.ecommerce.store.dao.AbstractDao;
import com.ecommerce.store.dao.AddressDao;
import com.ecommerce.store.model.Address;
import com.ecommerce.store.model.AddressStatus;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * @author Uday Kiran Thota (tudaykr@yahoo.com)
 */
@Repository("addressDao")
public class AddressDaoImpl extends AbstractDao<Integer, Address> implements AddressDao {
    @Override
    public List<Address> getAddressList(Integer customerId) {
        CriteriaBuilder criteriaBuilder = createCriteriaBuilder();
        CriteriaQuery<Address> criteriaQuery = criteriaBuilder.createQuery(Address.class);
        Root<Address> root = criteriaQuery.from(Address.class);
        criteriaQuery.select(root);
        criteriaQuery.orderBy(criteriaBuilder.desc(root.get("addressOrdinal")));
        criteriaQuery.where(criteriaBuilder.equal(root.get("status"), AddressStatus.ACTIVE));
        criteriaQuery.where(criteriaBuilder.equal(root.get("customerId"), customerId));
        return getEntityManager().createQuery(criteriaQuery).getResultList();
        /*
        Criteria criteria = createEntityCriteria().addOrder(Order.desc("addressOrdinal"));
        criteria.add(Restrictions.eq("status", AddressStatus.ACTIVE));
        criteria.add(Restrictions.eq("customerId", customerId));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        return (List<Address>) criteria.list();
        */
    }

    @Override
    public void saveAddress(Address address) {
        Address maxOrdinalAddress = findMaxOrdinal(address.getCustomerId());
        Integer maxOrdinal;
        if (maxOrdinalAddress == null) {
            // Customer is adding first address
            address.setAddressOrdinal(1);
        } else if (address.isDefaultAddress()) {
            // Customer is setting new address as default
            maxOrdinal = maxOrdinalAddress.getAddressOrdinal();
            address.setAddressOrdinal(maxOrdinal+1);
        } else {
            // customer has not set default address as default.
            maxOrdinal = maxOrdinalAddress.getAddressOrdinal();
            address.setAddressOrdinal(maxOrdinal);
            maxOrdinalAddress.setAddressOrdinal(maxOrdinal+1);
            persist(maxOrdinalAddress);
        }
        persist(address);
    }

    @Override
    public Address findbyId(Integer addressId) {
        return getByKey(addressId);
    }

    @Override
    public void deleteAddress(Address address) {
        address.setStatus(AddressStatus.DELETED);
        getEntityManager().merge(address);
//        getSession().saveOrUpdate(address);
    }

    private Address findMaxOrdinal(Integer customerId) {
        CriteriaBuilder criteriaBuilder = createCriteriaBuilder();
        CriteriaQuery<Address> criteriaQuery = criteriaBuilder.createQuery(Address.class);
        Root<Address> root = criteriaQuery.from(Address.class);
        criteriaQuery.select(root);
        criteriaQuery.orderBy(criteriaBuilder.desc(root.get("addressOrdinal")));
        criteriaQuery.where(criteriaBuilder.equal(root.get("status"), AddressStatus.ACTIVE));
        criteriaQuery.where(criteriaBuilder.equal(root.get("customerId"), customerId));
        try {
            return getEntityManager().createQuery(criteriaQuery).setMaxResults(1).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
        /*
        Criteria criteria = createEntityCriteria().addOrder(Order.desc("addressOrdinal"));
        criteria.add(Restrictions.eq("status", AddressStatus.ACTIVE));
        // criteria.setProjection(Projections.max("addressOrdinal"));
        criteria.add(Restrictions.eq("customerId", customerId)).setMaxResults(1);
        return (Address) criteria.uniqueResult();
        */
    }

    @Override
    public void updateAddress(Address oldAddress, Address newAddress) {
        oldAddress.setAddressLine1(newAddress.getAddressLine1());
        oldAddress.setAddressLine2(newAddress.getAddressLine2());
        oldAddress.setCity(newAddress.getCity());
        oldAddress.setState(newAddress.getState());
        oldAddress.setCountry(newAddress.getCountry());
        oldAddress.setPostalCode(newAddress.getPostalCode());
        oldAddress.setMobile(newAddress.getMobile());
        if (newAddress.isDefaultAddress()) {
            Address maxOrdinalAddress = findMaxOrdinal(oldAddress.getCustomerId());
            Integer maxOrdinal = maxOrdinalAddress.getAddressOrdinal();
            oldAddress.setAddressOrdinal(maxOrdinal+1);
        }
        getEntityManager().merge(oldAddress);
    }
}
