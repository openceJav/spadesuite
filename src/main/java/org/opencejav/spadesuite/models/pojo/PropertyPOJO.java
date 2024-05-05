package org.opencejav.spadesuite.models.pojo;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import org.opencejav.spadesuite.enums.PropertyType;
import org.opencejav.spadesuite.models.PropertyOwner;
import org.opencejav.spadesuite.models.records.Address;
import org.opencejav.spadesuite.models.records.Unit;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "spd_property")
@SuppressWarnings("all")
// TODO JavaDocify PropertyPOJO Class
public class PropertyPOJO implements Serializable {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "property_id", columnDefinition = "BINARY(16)")
    private UUID id;
    @Column(name = "property_owner")
    private PropertyOwner propertyOwner;
    @Column(name = "property_address")
    private Address address;
    @Column(name = "property_type")
    private PropertyType propertyType;
    @Column(name = "available_units")
    private List<Unit> availableUnits;
    @Column(name = "rented_units")
    private List<Unit> rentedUnits;

    public PropertyPOJO() {
        // Empty Constructor for Empty Object Construction.
    }

    public PropertyPOJO(
            final PropertyOwner propertyOwner,
            final Address address,
            final PropertyType propertyType,
            final List<Unit> availableUnits,
            final List<Unit> rentedUnits) {
        this.propertyOwner = propertyOwner;
        this.address = address;
        this.propertyType = propertyType;
        this.availableUnits = availableUnits;
        this.rentedUnits = rentedUnits;
    }

    //region Getters & Setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public PropertyOwner getPropertyOwner() {
        return propertyOwner;
    }

    public void setPropertyOwner(PropertyOwner propertyOwner) {
        this.propertyOwner = propertyOwner;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public PropertyType getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(PropertyType propertyType) {
        this.propertyType = propertyType;
    }

    public List<Unit> getAvailableUnits() {
        return availableUnits;
    }

    public void setAvailableUnits(List<Unit> availableUnits) {
        this.availableUnits = availableUnits;
    }

    public List<Unit> getRentedUnits() {
        return rentedUnits;
    }

    public void setRentedUnits(List<Unit> rentedUnits) {
        this.rentedUnits = rentedUnits;
    }
    //endregion
}
