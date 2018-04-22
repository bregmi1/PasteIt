package com.regmi.bijay.pasteit.views;

import java.util.Objects;

public class ViewPaste {

    private Long pasteId;

    private String body;

    private Long expiresOn;

    private Long updatedOn;

    private ViewUser viewUser;

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

    public Long getExpiresOn() {
        return expiresOn;
    }

    public void setExpiresOn(Long expiresOn) {
        this.expiresOn = expiresOn;
    }

    public Long getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Long updatedOn) {
        this.updatedOn = updatedOn;
    }

    public ViewUser getViewUser() {
        return viewUser;
    }

    public void setViewUser(ViewUser viewUser) {
        this.viewUser = viewUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ViewPaste viewPaste = (ViewPaste) o;
        return Objects.equals(pasteId, viewPaste.pasteId) &&
                Objects.equals(body, viewPaste.body) &&
                Objects.equals(expiresOn, viewPaste.expiresOn) &&
                Objects.equals(updatedOn, viewPaste.updatedOn) &&
                Objects.equals(viewUser, viewPaste.viewUser);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pasteId, body, expiresOn, updatedOn, viewUser);
    }

    @Override
    public String toString() {
        return "ViewPaste{" +
                "pasteId=" + pasteId +
                ", body='" + body + '\'' +
                ", expiresOn=" + expiresOn +
                ", updatedOn=" + updatedOn +
                ", viewUser=" + viewUser +
                '}';
    }
}
