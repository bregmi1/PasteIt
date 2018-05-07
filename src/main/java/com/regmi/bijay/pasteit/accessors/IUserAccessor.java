package com.regmi.bijay.pasteit.accessors;

import com.regmi.bijay.pasteit.domains.DomainUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


import java.time.LocalDateTime;
import java.util.List;

@RepositoryRestResource(exported = false)
public interface IUserAccessor extends JpaRepository<DomainUser, Long> {
    DomainUser findByEmail(String email);
    List<DomainUser> findAllByCreatedOnAfterAndCreatedOnBefore(LocalDateTime startDate, LocalDateTime endDate);
}
