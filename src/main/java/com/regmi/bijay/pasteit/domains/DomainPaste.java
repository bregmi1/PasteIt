package com.regmi.bijay.pasteit.domains;


import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "pastes")
public class DomainPaste implements Serializable {

    @Id
    @Column(name = "paste_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pasteId;

    @Column(name = "body")
    private String body;

    @Column(name = "expires_on")
    private LocalDateTime expiresOn;

    @Column(name = "created_on")
    private LocalDateTime createdOn;

    @Column(name = "updated_on")
    private LocalDateTime updatedOn;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private DomainUser domainUser;


    public Long getPasteId() {
        return pasteId;
    }

    public void setPasteId(Long pasteId) {
        this.pasteId = pasteId;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public LocalDateTime getExpiresOn() {
        return expiresOn;
    }

    public void setExpiresOn(LocalDateTime expiresOn) {
        this.expiresOn = expiresOn;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public LocalDateTime getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(LocalDateTime updatedOn) {
        this.updatedOn = updatedOn;
    }

    public DomainUser getDomainUser() {
        return domainUser;
    }

    public void setDomainUser(DomainUser domainUser) {
        this.domainUser = domainUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DomainPaste domainPaste = (DomainPaste) o;
        return Objects.equals(pasteId, domainPaste.pasteId) &&
                Objects.equals(body, domainPaste.body) &&
                Objects.equals(expiresOn, domainPaste.expiresOn) &&
                Objects.equals(createdOn, domainPaste.createdOn) &&
                Objects.equals(updatedOn, domainPaste.updatedOn) &&
                Objects.equals(domainUser, domainPaste.domainUser);
    }

    @Override
    public int hashCode() {

        return Objects.hash(pasteId, body, expiresOn, createdOn, updatedOn, domainUser);
    }

    @Override
    public String toString() {
        return "DomainPaste{" +
                "pasteId=" + pasteId +
                ", body='" + body + '\'' +
                ", expiresOn=" + expiresOn +
                ", createdOn=" + createdOn +
                ", updatedOn=" + updatedOn +
                ", domainUser=" + domainUser +
                '}';
    }
}
