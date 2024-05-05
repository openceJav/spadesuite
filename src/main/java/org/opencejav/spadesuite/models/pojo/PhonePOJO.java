package org.opencejav.spadesuite.models.pojo;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "spd_phone")
@SuppressWarnings("all")
// TODO JavaDocify PhonePOJO Class
public class PhonePOJO implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "phone_id")
    private int phoneId;
    @Column(name = "number")
    private String number;
    @Column(name = "country_code")
    private int countryCode;

    public PhonePOJO() {
        // Empty Constructor for Empty Object Creation.
    }

    public PhonePOJO(
            final String number,
            final int countryCode) {
        this.number = number;
        this.countryCode = countryCode;
    }

    //region Getters & Setters
    public int getPhoneId() {
        return phoneId;
    }

    public void setPhoneId(int phoneId) {
        this.phoneId = phoneId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(int countryCode) {
        this.countryCode = countryCode;
    }
    //endregion
}
