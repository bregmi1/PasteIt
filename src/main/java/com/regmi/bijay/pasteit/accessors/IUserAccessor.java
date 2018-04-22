package com.regmi.bijay.pasteit.accessors;

import com.regmi.bijay.pasteit.domains.DomainUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface IUserAccessor extends JpaRepository<DomainUser, Long> {

    DomainUser findByEmail(String email);

    List<DomainUser> findAllByCreatedOnAfterAndCreatedOnBefore(LocalDateTime startDate, LocalDateTime endDate);
}
