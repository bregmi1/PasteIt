package com.regmi.bijay.pasteit.converters.impl;

import com.regmi.bijay.pasteit.converters.ILocalDateTimeConverter;
import com.regmi.bijay.pasteit.converters.IPasteConverter;
import com.regmi.bijay.pasteit.domains.DomainPaste;
import com.regmi.bijay.pasteit.views.ViewPaste;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PasteConverter implements IPasteConverter {

    @Autowired
    private ILocalDateTimeConverter localDateTimeConverter;


    @Override
    public DomainPaste viewToDomain(ViewPaste viewPaste) {
        DomainPaste domainPaste = new DomainPaste();
        domainPaste.setPasteId(viewPaste.getPasteId());
        domainPaste.setBody(viewPaste.getBody());
        domainPaste.setUserId(viewPaste.getUserId());
        domainPaste.setExpiresOn(localDateTimeConverter.convertLongToLocalDateTime(viewPaste.getExpiresOn()));
        LocalDateTime now = LocalDateTime.now();
        domainPaste.setUpdatedOn(now);

        if(viewPaste.getPasteId() == null){
            domainPaste.setCreatedOn(now);
        } else{
            domainPaste.setCreatedOn(localDateTimeConverter.convertLongToLocalDateTime(viewPaste.getCreatedOn()));
        }
        return domainPaste;
    }

    @Override
    public ViewPaste domainToView(DomainPaste domainPaste) {
        ViewPaste viewPaste = new ViewPaste();
        viewPaste.setPasteId(domainPaste.getPasteId());
        viewPaste.setBody(domainPaste.getBody());
        viewPaste.setExpiresOn(localDateTimeConverter.convertLocalDateTimeToLong(domainPaste.getExpiresOn()));
        viewPaste.setUpdatedOn(localDateTimeConverter.convertLocalDateTimeToLong(domainPaste.getUpdatedOn()));
        viewPaste.setUserId(domainPaste.getUserId());
        return viewPaste;
    }
}
