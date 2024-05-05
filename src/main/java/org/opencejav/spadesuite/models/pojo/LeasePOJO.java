package org.opencejav.spadesuite.models.pojo;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "spd_lease")
@SuppressWarnings("all")
// TODO JavaDocify LeasePOJO Class
public class LeasePOJO implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lease_id")
    private int leaseId;
    @Column(name = "tenant_name")
    private String tenantName;
    @Column(name = "unit_number")
    private int unitNumber;
    @Column(name = "rent")
    private double rent;
    @Column(name = "terms")
    private double terms;

    public LeasePOJO() {
        // Empty Constructor for Empty Object Creation.
    }

    public LeasePOJO(
            final String tenantName,
            final int unitNumber,
            final double rent,
            final double terms) {
        this.tenantName = tenantName;
        this.unitNumber = unitNumber;
        this.rent = rent;
        this.terms = terms;
    }

    //region Getters & Setters
    public int getLeaseId() {
        return leaseId;
    }

    public void setLeaseId(int leaseId) {
        this.leaseId = leaseId;
    }

    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    public int getUnitNumber() {
        return unitNumber;
    }

    public void setUnitNumber(int unitNumber) {
        this.unitNumber = unitNumber;
    }

    public double getRent() {
        return rent;
    }

    public void setRent(double rent) {
        this.rent = rent;
    }

    public double getTerms() {
        return terms;
    }

    public void setTerms(double terms) {
        this.terms = terms;
    }
    //endregion
}
