package com.regmi.bijay.pasteit.converters;

import java.time.LocalDateTime;

public interface ILocalDateTimeConverter {
    public LocalDateTime convertLongToLocalDateTime(Long epoch);
    public Long convertLocalDateTimeToLong(LocalDateTime localDateTime);
}
