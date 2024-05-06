package org.opencejav.spadesuite.models.pojo;

import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.opencejav.spadesuite.models.records.Address;
import org.opencejav.spadesuite.models.records.Email;
import org.opencejav.spadesuite.models.records.Lease;
import org.opencejav.spadesuite.models.records.Phone;

import java.sql.Types;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "spd_tenant")
public class TenantPOJO {
    @Id
    @GeneratedValue
    @JdbcTypeCode(Types.VARCHAR)
    private UUID tenantId;
    @Column(name = "tenant_name")
    private String tenantName;
    @Column(name = "tenant_email")
    private Email tenantEmail;
    @Column(name = "tenant_phone")
    private Phone tenantPhone;
    @Column(name = "tenant_address")
    private Address tenantAddress;
    @Column(name = "tenant_lease")
    private Lease tenantLease;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public TenantPOJO() {
        // Empty Constructor for Empty Object Construction.
    }

    public TenantPOJO(
            final String tenantName,
            final Email tenantEmail,
            final Phone tenantPhone,
            final Address tenantAddress,
            final Lease tenantLease) {
        this.tenantName = tenantName;
        this.tenantEmail = tenantEmail;
        this.tenantPhone = tenantPhone;
        this.tenantAddress = tenantAddress;
        this.tenantLease = tenantLease;
    }

    //region Getters & Setters
    public UUID getTenantId() {
        return tenantId;
    }

    public void setTenantId(UUID tenantId) {
        this.tenantId = tenantId;
    }

    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    public Email getTenantEmail() {
        return tenantEmail;
    }

    public void setTenantEmail(Email tenantEmail) {
        this.tenantEmail = tenantEmail;
    }

    public Phone getTenantPhone() {
        return tenantPhone;
    }

    public void setTenantPhone(Phone tenantPhone) {
        this.tenantPhone = tenantPhone;
    }

    public Address getTenantAddress() {
        return tenantAddress;
    }

    public void setTenantAddress(Address tenantAddress) {
        this.tenantAddress = tenantAddress;
    }

    public Lease getTenantLease() {
        return tenantLease;
    }

    public void setTenantLease(Lease tenantLease) {
        this.tenantLease = tenantLease;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
    //endregion
}
