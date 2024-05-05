package org.opencejav.spadesuite.models.pojo;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "spd_email")
@SuppressWarnings("all")
// TODO JavaDocify EmailPOJO Class
public class EmailPOJO implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "email_id")
    private int emailId;
    @Column(name = "email")
    private String email;
    @Column(name = "is_verified")
    private boolean isVerified;

    public EmailPOJO() {
        // Empty Constructor for Empty Object Creation.
    }

    public EmailPOJO(
            final String email,
            final boolean isVerified) {
        this.email = email;
        this.isVerified = isVerified;
    }

    //region Getters & Setters
    public int getEmailId() {
        return emailId;
    }

    public void setEmailId(int emailId) {
        this.emailId = emailId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isVerified() {
        return isVerified;
    }

    public void setVerified(boolean verified) {
        isVerified = verified;
    }
    //endregion
}
