package com.regmi.bijay.pasteit.accessors;

import com.regmi.bijay.pasteit.domains.Paste;
import com.regmi.bijay.pasteit.domains.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface IPasteAccessor extends JpaRepository<Paste, Long> {

    List<Paste> findAllByUser(User user);

    List<Paste> findAllByExpiresOnAfterAndExpiresOnBefore(LocalDateTime startDate, LocalDateTime endDate);

    List<Paste> findAllByExpiresOnBefore(LocalDateTime endDate);

}
