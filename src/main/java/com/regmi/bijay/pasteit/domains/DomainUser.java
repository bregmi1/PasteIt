package com.regmi.bijay.pasteit.domains;


import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "users")
public class DomainUser implements Serializable {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "created_on")
    private LocalDateTime createdOn;

    @Column(name = "updated_on")
    private LocalDateTime updateOn;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public LocalDateTime getUpdateOn() {
        return updateOn;
    }

    public void setUpdateOn(LocalDateTime updateOn) {
        this.updateOn = updateOn;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DomainUser domainUser = (DomainUser) o;
        return Objects.equals(userId, domainUser.userId) &&
                Objects.equals(name, domainUser.name) &&
                Objects.equals(email, domainUser.email) &&
                Objects.equals(password, domainUser.password) &&
                Objects.equals(createdOn, domainUser.createdOn) &&
                Objects.equals(updateOn, domainUser.updateOn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, name, email, password, createdOn, updateOn);
    }

    @Override
    public String toString() {
        return "DomainUser{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", createdOn=" + createdOn +
                ", updateOn=" + updateOn +
                '}';
    }

}
