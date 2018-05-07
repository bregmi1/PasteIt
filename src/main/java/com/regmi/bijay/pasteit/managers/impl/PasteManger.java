package com.regmi.bijay.pasteit.managers.impl;

import com.regmi.bijay.pasteit.accessors.IPasteAccessor;
import com.regmi.bijay.pasteit.accessors.IUserAccessor;
import com.regmi.bijay.pasteit.converters.ILocalDateTimeConverter;
import com.regmi.bijay.pasteit.converters.IPasteConverter;
import com.regmi.bijay.pasteit.domains.DomainPaste;
import com.regmi.bijay.pasteit.domains.DomainUser;
import com.regmi.bijay.pasteit.managers.IPasteManager;
import com.regmi.bijay.pasteit.views.ViewPaste;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.naming.AuthenticationException;
import javax.persistence.EntityNotFoundException;
import java.security.InvalidParameterException;
import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PasteManger implements IPasteManager {

    @Autowired
    private IPasteAccessor pasteAccessor;

    @Autowired
    private IUserAccessor userAccessor;

    @Autowired
    private ILocalDateTimeConverter localDateTimeConverter;

    @Autowired
    private IPasteConverter pasteConverter;


    @Override
    public List<ViewPaste> getAllPastes(){
        return pasteAccessor.findAll()
                .stream()
                .map(pasteConverter::domainToView)
                .collect(Collectors.toList());
    }

    @Override
    public ViewPaste getPasteById(Long pasteId) {
        DomainPaste domainPaste = pasteAccessor.findOne(pasteId);
        if(domainPaste == null){
            throw new EntityNotFoundException("Unable to retrieve the paste with id: " + pasteId.toString());
        }
        return pasteConverter.domainToView(domainPaste);
    }

    @Override
    public ViewPaste createPaste(ViewPaste viewPaste) {
        if(viewPaste == null){
            throw new InvalidParameterException("Provided null paste for creation");
        }
        return pasteConverter.domainToView(pasteAccessor.save(pasteConverter.viewToDomain(viewPaste)));
    }

    @Override
    public ViewPaste updatePaste(Long pasteId, ViewPaste viewPaste) {
        DomainPaste currentDomainPaste = pasteAccessor.findOne(pasteId);
        if(currentDomainPaste == null){
            throw new EntityNotFoundException("Unable to retrieve the paste with id: " + pasteId.toString());
        } else if(!viewPaste.getPasteId().equals(pasteId)){
            throw new InvalidParameterException("Provided paste id: " + pasteId.toString() +
                    " does not match with provided paste: " + viewPaste.toString());
        }
        return pasteConverter.domainToView(pasteAccessor.save(pasteConverter.viewToDomain(viewPaste)));
    }

    @Override
    public ViewPaste deletePaste(Long pasteId) {
        DomainPaste domainPaste = pasteAccessor.findOne(pasteId);
        if(domainPaste == null){
            throw new EntityNotFoundException("Unable to retrieve the paste with id: " + pasteId.toString());
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

    @Override
    public List<ViewPaste> getAllPastesByUserId(Long userId) {
        return pasteAccessor.findAllByUserId(userId).stream()
                .map(pasteConverter::domainToView)
                .collect(Collectors.toList());
    }
}
