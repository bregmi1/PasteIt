package com.regmi.bijay.pasteit.views;

import java.time.LocalDateTime;
import java.util.Objects;


public class ViewPaste {

    private Long pasteId;

    private String title;

    private String body;

    private Long expiresOn;

    private Long createdOn;

    private Long updatedOn;

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

    public Long getExpiresOn() {
        return expiresOn;
    }

    public void setExpiresOn(Long expiresOn) {
        this.expiresOn = expiresOn;
    }

    public Long getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Long createdOn) {
        this.createdOn = createdOn;
    }

    public Long getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Long updatedOn) {
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
        ViewPaste viewPaste = (ViewPaste) o;
        return Objects.equals(pasteId, viewPaste.pasteId) &&
                Objects.equals(title, viewPaste.title) &&
                Objects.equals(body, viewPaste.body) &&
                Objects.equals(expiresOn, viewPaste.expiresOn) &&
                Objects.equals(createdOn, viewPaste.createdOn) &&
                Objects.equals(updatedOn, viewPaste.updatedOn) &&
                Objects.equals(userId, viewPaste.userId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(pasteId, title, body, expiresOn, createdOn, updatedOn, userId);
    }

    @Override
    public String toString() {
        return "ViewPaste{" +
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
