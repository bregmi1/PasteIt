package com.regmi.bijay.pasteit.managers.impl;

import com.regmi.bijay.pasteit.accessors.IPasteAccessor;
import com.regmi.bijay.pasteit.converters.ILocalDateTimeConverter;
import com.regmi.bijay.pasteit.domains.DomainPaste;
import com.regmi.bijay.pasteit.managers.IPasteManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class PasteManger implements IPasteManager {

    @Autowired
    private IPasteAccessor pasteAccessor;

    @Autowired
    private ILocalDateTimeConverter localDateTimeConverter;


    @Override
    public List<DomainPaste> getAllPastes() {
        return pasteAccessor.findAll();
    }

    @Override
    public DomainPaste getPasteById(Long pasteId) {
        return pasteAccessor.findOne(pasteId);
    }

    @Override
    public DomainPaste createPaste(DomainPaste domainPaste) {
        return pasteAccessor.save(domainPaste);
    }

    @Override
    public DomainPaste updatePaste(Long pasteId, DomainPaste domainPaste) {
        DomainPaste currentDomainPaste = pasteAccessor.findOne(pasteId);
        if(currentDomainPaste == null || !domainPaste.getPasteId().equals(pasteId)){
            return null;
        }
        return pasteAccessor.save(domainPaste);
    }

    @Override
    public DomainPaste deletePaste(Long pasteId) {
        DomainPaste domainPaste = pasteAccessor.findOne(pasteId);
        if(domainPaste == null){
            return null;
        }
        pasteAccessor.delete(pasteId);
        return domainPaste;
    }

    @Override
    public List<DomainPaste> getPastesBetweenDates(Long startDate, Long endDate) {
        LocalDateTime ldtStartDate = localDateTimeConverter.convertLongToLocalDateTime(startDate);
        LocalDateTime ldtEndDate = localDateTimeConverter.convertLongToLocalDateTime(endDate);
        return pasteAccessor.findAllByExpiresOnAfterAndExpiresOnBefore(ldtStartDate, ldtEndDate);
    }

    @Override
    public List<DomainPaste> getPastesBeforeDate(Long endDate){
        LocalDateTime ldtEndDate = localDateTimeConverter.convertLongToLocalDateTime(endDate);
        return pasteAccessor.findAllByExpiresOnBefore(ldtEndDate);
    }
}
