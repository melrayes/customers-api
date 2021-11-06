package com.company.customers.model.dtos;

public class CustomerDTO {
    private Long id;

    private String name;

    private String contactPhone;

    private Long contactCountryId;

    private String contactCountryName;

    private String contactState;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public Long getContactCountryId() {
        return contactCountryId;
    }

    public void setContactCountryId(Long contactCountryId) {
        this.contactCountryId = contactCountryId;
    }

    public String getContactCountryName() {
        return contactCountryName;
    }

    public void setContactCountryName(String contactCountryName) {
        this.contactCountryName = contactCountryName;
    }

    public String getContactState() {
        return contactState;
    }

    public void setContactState(String contactState) {
        this.contactState = contactState;
    }
}