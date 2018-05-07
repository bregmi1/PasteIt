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

    @Column(name="title")
    private String title;

    @Column(name = "body")
    private String body;

    @Column(name = "expires_on")
    private LocalDateTime expiresOn;

    @Column(name = "created_on")
    private LocalDateTime createdOn;

    @Column(name = "updated_on")
    private LocalDateTime updatedOn;

    @Column(name = "user_id")
    private Long userId;

    public Long getPasteId() {
        return pasteId;
    }

    public void setPasteId(Long pasteId) {
        this.pasteId = pasteId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DomainPaste that = (DomainPaste) o;
        return Objects.equals(pasteId, that.pasteId) &&
                Objects.equals(title, that.title) &&
                Objects.equals(body, that.body) &&
                Objects.equals(expiresOn, that.expiresOn) &&
                Objects.equals(createdOn, that.createdOn) &&
                Objects.equals(updatedOn, that.updatedOn) &&
                Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(pasteId, title, body, expiresOn, createdOn, updatedOn, userId);
    }

    @Override
    public String toString() {
        return "DomainPaste{" +
                "pasteId=" + pasteId +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", expiresOn=" + expiresOn +
                ", createdOn=" + createdOn +
                ", updatedOn=" + updatedOn +
                ", userId=" + userId +
                '}';
    }
}
