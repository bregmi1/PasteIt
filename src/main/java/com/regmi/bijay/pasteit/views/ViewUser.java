package com.regmi.bijay.pasteit.views;


import java.util.Objects;

public class ViewUser {

    private Long userId;

    private String name;

    private String email;

    private Long createdOn;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Long createdOn) {
        this.createdOn = createdOn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ViewUser viewUser = (ViewUser) o;
        return Objects.equals(userId, viewUser.userId) &&
                Objects.equals(name, viewUser.name) &&
                Objects.equals(email, viewUser.email) &&
                Objects.equals(createdOn, viewUser.createdOn);
    }

    @Override
    public int hashCode() {

        return Objects.hash(userId, name, email, createdOn);
    }

    @Override
    public String toString() {
        return "ViewUser{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", createdOn=" + createdOn +
                '}';
    }
}
