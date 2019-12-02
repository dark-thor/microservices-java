package com.ecommerce.store.model;

import com.google.gson.annotations.Expose;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * @author Uday Kiran Thota (tudaykr@yahoo.com)
 */
@Entity
@Table(name="customer_addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="customer_address_id", nullable=false)
    private Integer addressId;

    @Expose
    @NotNull
    @Column(name="address_line1", nullable=false)
    private String addressLine1;

    @Expose
    @NotNull
    @Column(name="address_line2")
    private String addressLine2;

    @Expose
    @NotNull
    @Column(name="city", nullable=false)
    private String city;

    @Expose
    @NotNull
    @Column(name="state", nullable = false)
    private String state;

    @Expose
    @Column(name="country")
    private String country;

    @NotNull
    @Expose
    @Column(name="postal_code")
    private String postalCode;

    @NotNull
    @Expose
    @Column(name="mobile")
    private String mobile;

    @Expose(serialize = false)
    @Transient
    private boolean defaultAddress;

    @Column(name="customer_id", nullable = false)
    private Integer customerId;

    @Column(name="address_ordinal", nullable = false)
    private Integer addressOrdinal;

    @Column(name="status", columnDefinition="enum('ACTIVE','DELETED')")
    @Enumerated(EnumType.STRING)
    public AddressStatus status=AddressStatus.ACTIVE;

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getAddressOrdinal() {
        return addressOrdinal;
    }

    public void setAddressOrdinal(Integer addressOrdinal) {
        this.addressOrdinal = addressOrdinal;
    }

    public boolean isDefaultAddress() {
        return defaultAddress;
    }

    public AddressStatus getStatus() {
        return status;
    }

    public void setStatus(AddressStatus status) {
        this.status = status;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
