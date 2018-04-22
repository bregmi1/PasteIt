package com.regmi.bijay.pasteit.managers.impl;

import com.regmi.bijay.pasteit.accessors.IPasteAccessor;
import com.regmi.bijay.pasteit.converters.ILocalDateTimeConverter;
import com.regmi.bijay.pasteit.converters.IPasteConverter;
import com.regmi.bijay.pasteit.domains.DomainPaste;
import com.regmi.bijay.pasteit.managers.IPasteManager;
import com.regmi.bijay.pasteit.views.ViewPaste;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PasteManger implements IPasteManager {

    @Autowired
    private IPasteAccessor pasteAccessor;

    @Autowired
    private ILocalDateTimeConverter localDateTimeConverter;

    @Autowired
    private IPasteConverter pasteConverter;


    @Override
    public List<ViewPaste> getAllPastes() {
        return pasteAccessor.findAll()
                .stream()
                .map(pasteConverter::domainToView)
                .collect(Collectors.toList());
    }

    @Override
    public ViewPaste getPasteById(Long pasteId) {
        return pasteConverter.domainToView(pasteAccessor.findOne(pasteId));
    }

    @Override
    public ViewPaste createPaste(ViewPaste viewPaste) {
        return pasteConverter.domainToView(pasteAccessor.save(pasteConverter.viewToDomain(viewPaste)));
    }

    @Override
    public ViewPaste updatePaste(Long pasteId, ViewPaste viewPaste) {
        DomainPaste currentDomainPaste = pasteAccessor.findOne(pasteId);
        if(currentDomainPaste == null || !viewPaste.getPasteId().equals(pasteId)){
            return null;
        }
        return pasteConverter.domainToView(pasteAccessor.save(pasteConverter.viewToDomain(viewPaste)));
    }

    @Override
    public ViewPaste deletePaste(Long pasteId) {
        DomainPaste domainPaste = pasteAccessor.findOne(pasteId);
        if(domainPaste == null){
            return null;
        }
        pasteAccessor.delete(pasteId);
        return pasteConverter.domainToView(domainPaste);
    }

    @Override
    public List<ViewPaste> getPastesBetweenDates(Long startDate, Long endDate) {
        LocalDateTime ldtStartDate = localDateTimeConverter.convertLongToLocalDateTime(startDate);
        LocalDateTime ldtEndDate = localDateTimeConverter.convertLongToLocalDateTime(endDate);
        return pasteAccessor.findAllByExpiresOnAfterAndExpiresOnBefore(ldtStartDate, ldtEndDate).stream()
                .map(pasteConverter::domainToView)
                .collect(Collectors.toList());
    }

    @Override
    public List<ViewPaste> getPastesBeforeDate(Long endDate){
        LocalDateTime ldtEndDate = localDateTimeConverter.convertLongToLocalDateTime(endDate);
        return pasteAccessor.findAllByExpiresOnBefore(ldtEndDate).stream()
                .map(pasteConverter::domainToView)
                .collect(Collectors.toList());
    }
}
