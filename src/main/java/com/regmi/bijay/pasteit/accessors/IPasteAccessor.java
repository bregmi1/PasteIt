package com.regmi.bijay.pasteit.accessors;

import com.regmi.bijay.pasteit.domains.DomainPaste;
import com.regmi.bijay.pasteit.domains.DomainUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface IPasteAccessor extends JpaRepository<DomainPaste, Long> {

    List<DomainPaste> findAllByExpiresOnAfterAndExpiresOnBefore(LocalDateTime startDate, LocalDateTime endDate);

    List<DomainPaste> findAllByExpiresOnBefore(LocalDateTime endDate);

    List<DomainPaste> findAllByUserId(Long userId);

}
