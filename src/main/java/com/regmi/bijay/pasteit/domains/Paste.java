package com.regmi.bijay.pasteit.domains;


import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "pastes")
public class Paste implements Serializable {

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
    private User user;


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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Paste paste = (Paste) o;
        return Objects.equals(pasteId, paste.pasteId) &&
                Objects.equals(body, paste.body) &&
                Objects.equals(expiresOn, paste.expiresOn) &&
                Objects.equals(createdOn, paste.createdOn) &&
                Objects.equals(updatedOn, paste.updatedOn) &&
                Objects.equals(user, paste.user);
    }

    @Override
    public int hashCode() {

        return Objects.hash(pasteId, body, expiresOn, createdOn, updatedOn, user);
    }

    @Override
    public String toString() {
        return "Paste{" +
                "pasteId=" + pasteId +
                ", body='" + body + '\'' +
                ", expiresOn=" + expiresOn +
                ", createdOn=" + createdOn +
                ", updatedOn=" + updatedOn +
                ", user=" + user +
                '}';
    }
}
