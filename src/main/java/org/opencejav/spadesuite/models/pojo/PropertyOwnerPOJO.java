package org.opencejav.spadesuite.models.pojo;

import jakarta.persistence.*;
import org.opencejav.spadesuite.models.Property;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Entity
@Table(name = "spd_property_owner")
@SuppressWarnings("all")
// TODO JavaDocify PropertyOwnerPOJO Class
public class PropertyOwnerPOJO implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "owner_id")
    private int ownerId;

    @Column(name = "owner_name")
    private String ownerName;

    @Column(name = "owner_phone_number")
    private String ownerPhoneNumber;

    @Column(name = "owner_email")
    private Optional<String> ownerEmail;

    @Column(name = "owned_properties")
    private Optional<List<Property>> ownedProperties;

    @Column(name = "owner_age")
    private int ownerAge;

    public PropertyOwnerPOJO() {
        // Empty Constructor for Empty Object Construction.
    }

    public PropertyOwnerPOJO(
            final String ownerName,
            final String ownerPhoneNumber,
            final Optional<String> ownerEmail,
            final Optional<List<Property>> ownedProperties,
            final int ownerAge) {
        this.ownerName = ownerName;
        this.ownerPhoneNumber = ownerPhoneNumber;
        this.ownerEmail = ownerEmail;
        this.ownedProperties = ownedProperties;
        this.ownerAge = ownerAge;
    }

    //region Getters & Setters
    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerPhoneNumber() {
        return ownerPhoneNumber;
    }

    public void setOwnerPhoneNumber(String ownerPhoneNumber) {
        this.ownerPhoneNumber = ownerPhoneNumber;
    }

    public Optional<String> getOwnerEmail() {
        return ownerEmail;
    }

    public void setOwnerEmail(Optional<String> ownerEmail) {
        this.ownerEmail = ownerEmail;
    }

    public Optional<List<Property>> getOwnedProperties() {
        return ownedProperties;
    }

    public void setOwnedProperties(Optional<List<Property>> ownedProperties) {
        this.ownedProperties = ownedProperties;
    }

    public int getOwnerAge() {
        return ownerAge;
    }

    public void setOwnerAge(int ownerAge) {
        this.ownerAge = ownerAge;
    }

    //endregion
}
