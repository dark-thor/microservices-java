package com.ecommerce.store.model;

import com.google.gson.annotations.Expose;

import javax.persistence.*;

/**
 * @author Uday Kiran Thota (tudaykr@yahoo.com)
 */
@Entity
@Table(name="address_suggest", indexes = @Index(columnList = "pincode"))
public class AddressSuggest {
    public AddressSuggest() {
    }

    @Expose
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="address_suggest_id", nullable=false)
    private Integer id;

    @Expose
    @Column(name="pincode", nullable=false)
    private String pincode;

    @Expose
    @Column(name="locality", nullable=false)
    private String locality;

    @Expose
    @Column(name="city", nullable=false)
    private String city;

    @Expose
    @Column(name="state", nullable=false)
    private String state;

    public Integer getId() {
        return id;
    }

    public String getPincode() {
        return pincode;
    }

    public String getLocality() {
        return locality;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }
}
