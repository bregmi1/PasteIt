package com.regmi.bijay.pasteit.converters.impl;

import com.regmi.bijay.pasteit.converters.ILocalDateTimeConverter;
import org.springframework.stereotype.Service;

import java.time.*;

@Service
public class LocalDateTimeConverter implements ILocalDateTimeConverter {
    @Override
    public LocalDateTime convertLongToLocalDateTime(Long epoch) {
        if(epoch != null){
            Instant epochDate = Instant.ofEpochMilli(epoch);
            return LocalDateTime.ofInstant(epochDate, ZoneOffset.UTC);
        }
        return null;
    }

    @Override
    public Long convertLocalDateTimeToLong(LocalDateTime localDateTime) {
        if(localDateTime != null){
            OffsetDateTime zdt = localDateTime.atOffset(ZoneOffset.UTC);
            return zdt.toInstant().toEpochMilli();
        }
        return null;
    }
}
