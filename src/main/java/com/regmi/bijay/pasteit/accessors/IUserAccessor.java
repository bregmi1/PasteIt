package com.regmi.bijay.pasteit.accessors;

import com.regmi.bijay.pasteit.domains.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface IUserAccessor extends JpaRepository<User, Long> {

    User findByEmail(String email);

    List<User> findAllByCreatedOnAfterAndCreatedOnBefore(LocalDateTime startDate, LocalDateTime endDate);
}
